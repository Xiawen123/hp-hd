package com.hp.common.http;

import okhttp3.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * OkHttpCaller实现类
 *
 * @author wanggw
 */
public class OkHttpCallerImpl extends OkHttpCallerAbstract {

    private int connectTimeout;
    private int readTimeout;

    public OkHttpCallerImpl(int connectTimeout, int readTimeOut) {
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeOut;
    }

    /**
     * 构建OkHttpClient对象
     */
    private OkHttpClient client = OkHttpFactory.createOkHttpClient(connectTimeout, readTimeout);

    /**
     * 发送GET请求（同步）
     *
     * @param url 请求url
     * @return 返回值
     * @throws IOException 抛出运行时读写数据流异常
     */
    @Override
    public String callGetSync(String url) throws IOException {

        // 构建request请求对象
        Request request = newGetRequest(url);

        // 发送请求并获取响应对象
        Response response = client.newCall(request).execute();
        // 对结果进行判断
        if (response.isSuccessful()) {
            // 如果成功，则取出响应体
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 发送GET请求，专为大型数据准备，返回数据超过1M可以使用（同步）
     *
     * @param url 请求url
     * @return 返回值
     * @throws IOException 抛出运行时读写数据流异常
     */
    @Override
    public InputStream callGetStreamSync(String url) throws IOException {

        // 构建request请求对象
        Request request = newGetRequest(url);

        // 发送请求并获取响应对象
        Response response = client.newCall(request).execute();

        // 对结果进行判断
        if (response.isSuccessful()) {
            // 如果成功，则取出响应体
            return response.body().byteStream();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 发送GET请求，专为大型数据准备，返回数据超过1M可以使用（同步）
     *
     * @param url 请求url
     * @return 返回值
     * @throws IOException 抛出运行时读写数据流异常
     */
    @Override
    public byte[] callGetBytesSync(String url) throws IOException {
        // 构建request请求对象
        Request request = newGetRequest(url);

        // 发送请求并获取响应对象
        Response response = client.newCall(request).execute();

        // 对结果进行判断
        if (response.isSuccessful()) {
            // 如果成功，则取出响应体
            return response.body().bytes();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 发送GET请求（异步）
     *
     * @param url 请求url
     * @return 返回值
     * @throws Exception 抛出运行时读写数据流异常
     */
    @Override
    public void callGetAsync(String url, final OkHttpCallback callback) throws IOException {
        // 构建request请求对象
        Request request = newGetRequest(url);
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call arg0, Response arg1) throws IOException {
                callback.callback(arg1, null);
            }

            @Override
            public void onFailure(Call arg0, IOException arg1) {
                callback.callback(null, arg1);
            }
        });
    }

    /**
     * 发送POST请求，参数为json字符串 （同步）
     * <p>
     * ContentType = application/json; charset=utf-8
     *
     * @param url  请求url
     * @param param 参数字符串
     * @return 返回值
     * @throws IOException 抛出运行时读写数据流异常
     */
    @Override
    public String callPostSync(String url, String param,MediaType mediaType) throws IOException {
        RequestBody body = RequestBody.create(mediaType, param);
        Request request = newPostRequest(url, body);

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 发送POST请求，参数为键值对 （同步）
     *
     * @param url   请求url
     * @param param 键值对参数
     * @return 返回值
     * @throws IOException 抛出运行时读写数据流异常
     */
    @Override
    public String callPostSync(String url, Map<String, Object> param) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        // 写入键值对
        setBodyKVParam(builder, param);
        FormBody body = builder.build();
        Request request = newPostRequest(url, body);

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 发送POST请求，参数为json字符串 ，返回值为流对象，适用于下载大文件（同步）
     *
     * @param url  请求url
     * @param param 参数字符串
     * @return 返回值
     * @throws IOException 抛出运行时读写数据流异常
     */
    @Override
    public InputStream callStreamPostSync(String url, String param,MediaType mediaType) throws IOException {
        RequestBody body = RequestBody.create(mediaType, param);
        Request request = newPostRequest(url, body);

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().byteStream();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 发送POST请求，参数为键值对，返回值为流对象，适用于下载大文件（同步）
     *
     * @param url   请求url
     * @param param 键值对参数
     * @return 返回值
     * @throws IOException 抛出运行时读写数据流异常
     */
    @Override
    public InputStream callStreamPostSync(String url, Map<String, Object> param) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        // 写入键值对
        setBodyKVParam(builder, param);
        FormBody body = builder.build();
        Request request = newPostRequest(url, body);

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            return response.body().byteStream();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 发送POST请求，参数为json字符串 ，返回值为字节数组，通用（同步）
     *
     * @param url  请求url
     * @param param 参数字符串
     * @return 返回值
     * @throws IOException 抛出运行时读写数据流异常
     */
    @Override
    public byte[] callBytesPostSync(String url, String param,MediaType mediaType) throws IOException {
        RequestBody body = RequestBody.create(mediaType, param);
        Request request = newPostRequest(url, body);

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().bytes();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 发送POST请求，参数为键值对，返回值为字节数组，通用（同步）
     *
     * @param url   请求url
     * @param param 键值对参数
     * @return 返回值
     * @throws IOException 抛出运行时读写数据流异常
     */
    @Override
    public byte[] callBytesPostSync(String url, Map<String, Object> param) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        // 写入键值对
        setBodyKVParam(builder, param);

        FormBody body = builder.build();
        Request request = newPostRequest(url, body);

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            return response.body().bytes();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 发起POST请求，参数为字符串，异步
     *
     * @param url  请求链接
     * @param param 参数
     */
    @Override
    public void callPostAsync(String url, String param,MediaType mediaType, final OkHttpCallback callback) {
        RequestBody body = RequestBody.create(mediaType, param);
        Request request = newPostRequest(url, body);

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.callback(null, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.callback(response, null);
            }
        });

    }

    /**
     * 发起POST请求，参数为键值对，异步
     *
     * @param url   请求链接
     * @param param 参数
     */
    @Override
    public void callPostAsync(String url, Map<String, Object> param, final OkHttpCallback callback) {
        FormBody.Builder builder = new FormBody.Builder();
        // 写入键值对
        setBodyKVParam(builder, param);

        FormBody body = builder.build();
        Request request = newPostRequest(url, body);

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.callback(null, e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.callback(response, null);
            }
        });
    }

    /**
     * 下载文件（同步）
     *
     * @param url      链接
     * @param destPath 存储位置
     * @return 结果
     * @throws IOException 抛出运行时读写数据流异常
     */
    @Override
    public boolean downloadFileSync(String url, String destPath) throws IOException {

        Request request = newGetRequest(url);
        Response response = client.newCall(request).execute();

        return saveFileFromStream(response, url, destPath);
    }

    /**
     * 下载文件（异步）
     *
     * @param url      链接
     * @param destPath 存储位置
     * @return 结果
     */
    @Override
    public void downloadFileASync(final String url, final String destPath) {
        downloadFileASyncAssist(url, (response, exception) -> {
            if (response != null) {
                saveFileFromStream(response, url, destPath);
            }
        });

    }

    /**
     * 下载文件（异步）-- 辅助方法
     *
     * @param url 链接
     * @return 结果
     */
    private void downloadFileASyncAssist(String url, final OkHttpCallback callback) {
        Request request = newGetRequest(url);
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Call arg0, Response arg1) throws IOException {
                callback.callback(arg1, null);
            }

            @Override
            public void onFailure(Call arg0, IOException arg1) {
                callback.callback(null, arg1);
            }
        });
    }
}
