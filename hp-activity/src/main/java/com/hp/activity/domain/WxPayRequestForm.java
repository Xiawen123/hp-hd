package com.hp.activity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 微信支付表单
 *
 * @author wanggw
 */
public class WxPayRequestForm implements Serializable {

    //静态参数集合
    public static class ApiSecurity {

        public static final String appid = "wx07c16a86468ddc2f";//小程序ID或者注册的独立APP ID
        public static final String app_secret = "6e140e2d37846a02809433b1afeceff6";//小程序secret
        public static final String mch_id = "1541864471";//微信支付分配的商户号
        public static final String api_secret = "p862ef0NxXq0pla8os5YVNNpWGG4K9C4";//接口秘钥
//        public static final String apiv3_secret = "xD87c8zq6wMoZQXKabR4BGDPYbqdTvD3";//接口v3秘钥
    }

    //微信接口api地址
    public static class ApiUrl {
        public static final String unifiedorder = "https://api.mch.weixin.qq.com/pay/unifiedorder";//统一下单接口
        //用appid+secret+js_code+access_token获取openid
        public static final String jscode2session = "https://api.weixin.qq.com/sns/jscode2session?appid=" + ApiSecurity.appid + "&secret=" + ApiSecurity.app_secret;//openid获取
        //grant_type+appid+app_secret 获取小程序的授权token
        public static final String access_token = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + ApiSecurity.appid + "&secret=" + ApiSecurity.app_secret;
    }


    @NotBlank(message = "随机字符串不可为空")
    @Length(max = 32, message = "随机字符串长度应保持在32位以内")
    @ApiModelProperty(value = "随机字符串")
    private String nonce_str;//随机字符串，长度要求在32位以内。推荐随机数生成算法
    @NotBlank(message = "签名不可为空")
    @ApiModelProperty(value = "签名")
    private String sign;//通过签名算法计算得出的签名值，详见签名生成算法
    @NotBlank(message = "商品简单描述不可为空")
    @ApiModelProperty(value = "商品简单描述")
    private String body = "宏鹏集团-投票打赏";//商品简单描述，该字段请按照规范传递，具体请见参数规定
    @NotBlank(message = "商户系统内部订单号不可为空")
    @ApiModelProperty(value = "商户系统内部订单号")
    private String out_trade_no;//商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号
    @NotNull
    @ApiModelProperty(value = "订单总金额")
    private int total_fee;//订单总金额，单位为分
    @NotBlank(message = "APP和网页支付提交用户端IP不可为空")
    @ApiModelProperty(value = "APP和网页支付提交用户端IP")
    private String spbill_create_ip; //APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
    @NotBlank(message = "异步接收微信支付结果通知的回调地址不可为空")
    @ApiModelProperty(value = "异步接收微信支付结果通知的回调地址")
    private String notify_url;//异步接收微信支付结果通知的回调地址，通知url必须为外网可访问的url，不能携带参数。
    @NotBlank(message = "小程序openid不可为空")
    @ApiModelProperty(value = "小程序openid")
    private String openid;//小程序支付必传，用户在商户appid下的唯一标识。openid如何获取，可参考
    @NotBlank(message = "小程序js_code不可为空")
    @ApiModelProperty(value = "小程序js_code")
    private String js_code;//小程序登陆js_code
    @NotBlank(message = "小程序authorization_code不可为空")
    @ApiModelProperty(value = "小程序authorization_code")
    private String access_token;//授权code
    private String session_key;//会话秘钥

    public static final String trade_type = "JSAPI";//JSAPI 小程序取值如下：JSAPI，详细说明见

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public int getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(int total_fee) {
        this.total_fee = total_fee;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getJs_code() {
        return js_code;
    }

    public void setJs_code(String js_code) {
        this.js_code = js_code;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }
}
