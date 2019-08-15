package com.hp.activity.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hp.activity.domain.FunseekUser;
import com.hp.activity.domain.FunseekUserOrder;
import com.hp.activity.domain.WxPayRequestForm;
import com.hp.activity.mapper.FunseekUserOrderMapper;
import com.hp.activity.service.IAppPayService;
import com.hp.common.base.R;
import com.hp.common.exception.RRException;
import com.hp.common.http.OkHttpCaller;
import com.hp.common.http.OkHttpCallerAbstract;
import com.hp.common.http.OkHttpFactory;
import com.hp.common.snowflake.SnowFlake;
import com.hp.common.utils.Httprequests;
import com.hp.common.utils.spring.SpringUtils;
import com.hp.common.wxpay.WXPayUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * APP支付接口实现层
 *
 * @author wanggw
 */
@Service
public class AppPayServiceImpl implements IAppPayService {

    @Autowired
    private FunseekUserOrderMapper funseekUserOrderMapper;


    private static Logger logger = LoggerFactory.getLogger(AppPayServiceImpl.class);

    /**
     * 微信小程序支付
     *
     * @param wxPayRequestForm 支付参数：金额，openid
     * @param request          HttpServletRequest
     * @return 微信商户下单及加签结果
     */
    @Override
    public R wxMiniProgramPay(WxPayRequestForm wxPayRequestForm, HttpServletRequest request) {

        OkHttpCaller okHttpCaller = OkHttpFactory.newOkHttpCaller(60, 0);

        //微信支付完整思路
        if (StringUtils.isBlank(wxPayRequestForm.getJs_code())) {
            return R.error(-1, "请提供小程序登陆code:login_code");
        }

        String openidResult = null;
        try {
            openidResult = okHttpCaller.callGetSync(WxPayRequestForm.ApiUrl.jscode2session + "&js_code=" + wxPayRequestForm.getJs_code() + "&grant_type=authorization_code");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(openidResult);

        if (StringUtils.isBlank(openidResult)) {
            throw new RRException("网络异常或服务器内部错误", HttpStatus.UNAUTHORIZED.value());
        }
        JSONObject jsonObject = (JSONObject) JSONObject.parse(openidResult);
        if (jsonObject.containsKey("openid")) {
            wxPayRequestForm.setOpenid(jsonObject.getString("openid"));
            wxPayRequestForm.setSession_key(jsonObject.getString("session_key"));
        } else {
            return R.error(-1, jsonObject.getString("errmsg"));
        }

        //完善数据
        wxPayRequestForm.setSpbill_create_ip("127.0.0.1");
        wxPayRequestForm.setNonce_str(WXPayUtil.generateNonceStr());
        wxPayRequestForm.setOut_trade_no("Z" + SnowFlake.nextId());
        wxPayRequestForm.setNotify_url("https://mp.zymcloud.com/hp-hd/applet/pay/confirmNotify");

        //第三步：下单
        Map<String, String> payParams = new HashMap<>();
        payParams.put("appid", WxPayRequestForm.ApiSecurity.appid);
        payParams.put("body", wxPayRequestForm.getBody());
        payParams.put("mch_id", WxPayRequestForm.ApiSecurity.mch_id);
        payParams.put("nonce_str", wxPayRequestForm.getNonce_str());
        payParams.put("notify_url", wxPayRequestForm.getNotify_url());
        payParams.put("openid", wxPayRequestForm.getOpenid());
        payParams.put("out_trade_no", wxPayRequestForm.getOut_trade_no());
        payParams.put("spbill_create_ip", wxPayRequestForm.getSpbill_create_ip());
        payParams.put("total_fee", String.valueOf(wxPayRequestForm.getTotal_fee()));
        payParams.put("trade_type", WxPayRequestForm.trade_type);

        String sign;
        //生成sign
        try {
            sign = WXPayUtil.generateSignature(payParams, WxPayRequestForm.ApiSecurity.api_secret);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
        }

        if (StringUtils.isBlank(sign)) {
            return R.error(-1, "签名失败：sign generate failed");
        }

        payParams.put("sign", sign);

        String formData;
        try {
            formData = WXPayUtil.mapToXml(payParams);
            //发起
        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
        }

        if (StringUtils.isBlank(formData)) {
            return R.error(-1, "转换失败：map to xml failed");
        }

        //准备下单
        String orderResult;
        try {
            orderResult = okHttpCaller.callPostSync(WxPayRequestForm.ApiUrl.unifiedorder, formData, OkHttpCallerAbstract.CONTENT_TYPE_APPLICATION_XML);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RRException(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
        }

        if (StringUtils.isBlank(orderResult)) {
            return R.error(-1, "下单失败，网络异常：order failed,unknown error");
        }

        System.out.println(orderResult);

        Map<String, String> orderMap;
        try {
            orderMap = WXPayUtil.xmlToMap(orderResult);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RRException(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
        }

        if (orderMap == null || orderMap.size() == 0) {
            return R.error(-1, "下单结果格式异常：unknown order result format");
        }

        //判断结果
        if ("SUCCESS".equals(orderMap.get("return_code")) && "SUCCESS".equals(orderMap.get("result_code"))) {

            //创建订单数据
            FunseekUserOrder funseekUserOrder = new FunseekUserOrder();
            funseekUserOrder.setId(SnowFlake.nextId());
            funseekUserOrder.setCreateTime(new Date());
            funseekUserOrder.setNotifyState("0");
            funseekUserOrder.setOrderId(wxPayRequestForm.getOut_trade_no());
            funseekUserOrder.setOrderState("1");
            funseekUserOrder.setPayState("0");
            funseekUserOrder.setPayWay("1");
            funseekUserOrder.setRefundState("0");
            funseekUserOrder.setTotalFee(wxPayRequestForm.getTotal_fee());

            //生成订单
            funseekUserOrderMapper.insertSelective(funseekUserOrder);

            String timeStamp = String.valueOf(WXPayUtil.getCurrentTimestamp());

            //处理结果
            Map<String, String> prepareSignMap = new HashMap<>();
            prepareSignMap.put("appId", orderMap.get("appid"));
            prepareSignMap.put("signType", "MD5");
            prepareSignMap.put("nonceStr", orderMap.get("nonce_str"));
            prepareSignMap.put("timeStamp", timeStamp);
            prepareSignMap.put("package", "prepay_id=" + orderMap.get("prepay_id"));

            String resSign;
            try {
                resSign = WXPayUtil.generateSignature(prepareSignMap, WxPayRequestForm.ApiSecurity.api_secret);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RRException(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
            }

            if (StringUtils.isBlank(resSign)) {
                return R.error(-1, "下单结果加签失败：order result sign failed");
            }

            //返回结果
            Map<String, String> returnResult = new HashMap<>();
            returnResult.put("timeStamp", timeStamp);
            returnResult.put("package", "prepay_id=" + orderMap.get("prepay_id"));
            returnResult.put("nonceStr", orderMap.get("nonce_str"));
            returnResult.put("signType", "MD5");
            returnResult.put("paySign", resSign);
            //这个orderId APP端需要存下，然后在支付成功之后回调接口进行支付状态确认
            returnResult.put("orderId", funseekUserOrder.getOrderId());

            R ok = new R();
            ok.put("data", returnResult);

            return ok;

        } else {
            //失败
            return R.error(-1, orderMap.get("return_msg"));
        }
    }

    /**
     * 微信支付回调
     *
     * @param notify 回调携带的参数xml格式
     */
    @Override
    public String wxMiniProgramPayNotify(String notify) {
        Map<String, String> returnMap = new HashMap<>();
        //xml字符串转换成map
        Map<String, String> notifyMap;
        try {
            notifyMap = WXPayUtil.xmlToMap(notify);
        } catch (Exception e) {
            logger.error("微信支付回调通知错误：xml转换成map集合失败：" + e.getMessage());
            throw new RRException(e.getMessage());
        }

        if (notifyMap == null) {
            throw new RRException("微信支付回调通知错误：xml转换成map集合失败：xml convert to map failed");
        }

        //校验回调结果

        if ("FAIL".equals(notifyMap.get("return_code"))) {
            returnMap.put("return_code", "FAIL");
            returnMap.put("return_msg", "FAIL");
            try {
                return WXPayUtil.mapToXml(returnMap);
            } catch (Exception e) {
                logger.error("微信支付回调通知错误：map转换xml集合失败：" + e.getMessage());
                throw new RRException(e.getMessage());
            }
        }

        String out_trade_no = notifyMap.get("out_trade_no");
        //检查订单号在本地是否存在
        FunseekUserOrder funseekUserOrder = funseekUserOrderMapper.selectByPrimaryKey(out_trade_no);
        if (funseekUserOrder == null) {
            returnMap.put("return_code", "FAIL");
            returnMap.put("return_msg", "本商户没有此订单号的订单");
            try {
                return WXPayUtil.mapToXml(returnMap);
            } catch (Exception e) {
                logger.error("微信支付回调通知错误：map转换xml集合失败：" + e.getMessage());
                throw new RRException(e.getMessage());
            }
        }

        if ("FAIL".equals(notifyMap.get("result_code"))) {
            //表示业务失败，更新状态，标记错误信息
            funseekUserOrder.setNotifyState("2");
            funseekUserOrder.setUpdateTime(new Date());
            funseekUserOrder.setNotifyError(notifyMap.get("err_code_des"));
            funseekUserOrderMapper.updateFunseekUserOrder(funseekUserOrder);

            returnMap.put("return_code", "SUCCESS");
            returnMap.put("return_msg", "OK");
            try {
                return WXPayUtil.mapToXml(returnMap);
            } catch (Exception e) {
                logger.error("微信支付回调通知错误：map转换xml集合失败：" + e.getMessage());
                throw new RRException(e.getMessage());
            }
        }

        //如果此订单已经被确认，则直接返回
        if ("1".equals(funseekUserOrder.getNotifyState())) {
            //确认成功，更新实际状态，返回
            funseekUserOrder.setNotifyState("1");
            funseekUserOrder.setUpdateTime(new Date());
            funseekUserOrderMapper.updateFunseekUserOrder(funseekUserOrder);
            returnMap.put("return_code", "SUCCESS");
            returnMap.put("return_msg", "OK");
            try {
                return WXPayUtil.mapToXml(returnMap);
            } catch (Exception e) {
                logger.error("微信支付回调通知错误：map转换xml集合失败：" + e.getMessage());
                throw new RRException(e.getMessage());
            }
        }

        //校验订单的金额是否和本地订单信息一致
        if (Integer.parseInt(notifyMap.get("total_fee")) != funseekUserOrder.getTotalFee()) {
            returnMap.put("return_code", "FAIL");
            returnMap.put("return_msg", "订单金额与本商户订单金额不一致");
            try {
                return WXPayUtil.mapToXml(returnMap);
            } catch (Exception e) {
                logger.error("微信支付回调通知错误：map转换xml集合失败：" + e.getMessage());
                throw new RRException(e.getMessage());
            }
        }

        //确认成功，更新实际状态，返回
        funseekUserOrder.setNotifyState("1");
        funseekUserOrder.setUpdateTime(new Date());
        funseekUserOrderMapper.updateFunseekUserOrder(funseekUserOrder);

        returnMap.put("return_code", "SUCCESS");
        returnMap.put("return_msg", "OK");
        try {
            return WXPayUtil.mapToXml(returnMap);
        } catch (Exception e) {
            logger.error("微信支付回调通知错误：map转换xml集合失败：" + e.getMessage());
            throw new RRException(e.getMessage());
        }
    }

    /**
     * 微信支付后的本地订单确认
     *
     * @return 结果
     */
    @Override
    public R wxMiniProgramPayOrderConfirm(FunseekUserOrder funseekUserOrder) {

        if (StringUtils.isBlank(funseekUserOrder.getOrderId())) {
            return R.error(-1,"订单号orderId不可为空");
        }
        funseekUserOrder.setPayState("1");
        funseekUserOrder.setNotifyState("1");
        funseekUserOrderMapper.updateFunseekUserOrder(funseekUserOrder);

        return R.ok("支付成功");

    }
}
