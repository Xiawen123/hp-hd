package com.hp.web.controller.tool;

import com.hp.activity.domain.FunseekUser;
import com.hp.activity.domain.FunseekUserOrder;
import com.hp.activity.domain.WxPayRequestForm;
import com.hp.activity.service.IAppPayService;
import com.hp.common.base.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 微信支付
 *
 * @author wanggw
 */
@Api("微信支付")
@Controller
@RequestMapping("/applet/pay")
public class AppPayController {

    @Autowired
    private IAppPayService appPayService;

    /**
     * 微信小程序支付
     *
     * @param wxPayRequestForm 支付参数：金额
     * @param request          HttpServletRequest
     * @return 微信商户下单及加签结果
     */
    @PostMapping("/wxMiniProgramPay")
    @ResponseBody
    public R wxMiniProgramPay(WxPayRequestForm wxPayRequestForm,  HttpServletRequest request) {
        return appPayService.wxMiniProgramPay(wxPayRequestForm,request);
    }

    /*
     * 微信支付平台回调
     *
     * @param notify 回调携带的参数xml格式
     */
    @PostMapping("/confirmNotify")
    @ResponseBody
    public String wxMiniProgramPayNotify(String notify) {
        return appPayService.wxMiniProgramPayNotify(notify);
    }

    /**
     * 微信支付后的本地订单确认
     *
     * @return 结果
     */
    @PostMapping("/orderConfirm")
    @ResponseBody
    public R wxMiniProgramPayOrderConfirm(FunseekUserOrder funseekUserOrder) {
        return appPayService.wxMiniProgramPayOrderConfirm(funseekUserOrder);
    }

}
