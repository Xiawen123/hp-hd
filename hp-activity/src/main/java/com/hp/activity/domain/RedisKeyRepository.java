package com.hp.activity.domain;

/**
 * redis key静态资源集合
 *
 * @author wanggw
 */

public final class RedisKeyRepository {

    //登陆验证码key,%s使用用户手机号替换
    public static final String APP_LOGIN_SMSCODE = "app:login:sms_%s";

    //注册验证码key,%s使用用户手机号替换
    public static final String APP_REGISTER_SMSCODE = "app:register:sms_%s";


    public static final String QRCODE_DATA_STATISTICS_CAR = "qrcode:data:statistics:car";
    public static final String QRCODE_DATA_STATISTICS_LOST = "qrcode:data:statistics:lost";

}