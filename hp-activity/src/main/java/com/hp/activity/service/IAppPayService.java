package com.hp.activity.service;


import com.hp.activity.domain.FunseekUser;
import com.hp.activity.domain.FunseekUserOrder;
import com.hp.activity.domain.WxPayRequestForm;
import com.hp.common.base.R;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * APP支付接口层
 *
 * @author wanggw
 */
public interface IAppPayService {

    /**
     * 微信小程序支付
     *
     * @param wxPayRequestForm 支付参数：金额
     * @param request HttpServletRequest
     *
     * @return 微信商户下单及加签结果
     */
    R wxMiniProgramPay(WxPayRequestForm wxPayRequestForm,  HttpServletRequest request);

    /**
     * 微信支付回调
     *
     * @param notify 回调携带的参数xml格式
     */
    String wxMiniProgramPayNotify(String notify);

    /**
     * 微信支付后的本地订单确认
     *
     * @return 结果
     */
    R wxMiniProgramPayOrderConfirm(FunseekUserOrder funseekUserOrder);
}
