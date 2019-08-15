package com.hp.common.http;



import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * 工厂类，用于管理HttpClient
 *
 * @author wanggw
 */
public class OkHttpFactory {

    private static OkHttpClient okHttpClient;
    private static OkHttpCaller caller;

    synchronized static OkHttpClient createOkHttpClient(int connectTimeout, int readTimeOut) {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient
                    .Builder()
                    .connectTimeout(connectTimeout, TimeUnit.MINUTES)
                    .readTimeout(readTimeOut, TimeUnit.SECONDS)
                    .build();
        }
        return okHttpClient;
    }

    public synchronized static OkHttpCaller newOkHttpCaller(int connectTimeout, int readTimeOut) {
        if (caller == null) {
            caller = new OkHttpCallerImpl(connectTimeout, readTimeOut);
        }
        return caller;
    }
}
