package com.hp.common.http;

import okhttp3.Response;

/**
 * 异步请求时的回调
 *
 * FunctionalInterface注解 表示这个是一个函数式接口
 *
 * @author wangw
 *
 */
@FunctionalInterface
public interface OkHttpCallback {
	void callback(Response response, Exception exception);
}
