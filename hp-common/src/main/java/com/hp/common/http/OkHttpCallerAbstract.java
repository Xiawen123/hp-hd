package com.hp.common.http;

import okhttp3.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public abstract class OkHttpCallerAbstract implements OkHttpCaller {

    /**
     * ContentType的一些类型
     */
    public static final MediaType CONTENT_TYPE_APPLICATION_XML = MediaType.parse("text/xml");
    public static final MediaType CONTENT_TYPE_FORM_URLENCODE = MediaType.parse("application/x-www-form-urlencoded");
    public static final MediaType CONTENT_TYPE_APPLICATION_JSON = MediaType.parse("application/json");

    /**x
     * 构建一个GET请求的Request
     *
     * @param url 请求URL
     * @return Request对象
     */
    Request newGetRequest(String url) {
        return new Request.Builder().url(url).build();
    }

    /**
     * 构建一个Post请求的Request
     *
     * @param url         请求URL
     * @param requestBody RequestBody对象
     * @return Request对象
     */
    Request newPostRequest(String url, RequestBody requestBody) {
        return new Request.Builder().url(url).post((okhttp3.RequestBody) requestBody).build();
    }

    /**
     * 将param键值对存储到body里面
     *
     * @param builder 表单
     * @param param   键值对
     */
    void setBodyKVParam(FormBody.Builder builder, Map<String, Object> param) {
        Object[] keys = param.keySet().toArray();
        for (Object key : keys) {
            builder.add(key.toString(), String.valueOf(param.get(key.toString())));
        }
    }

    /**
     * 从下载链接中获取文件名称
     *
     * @param path 地址
     * @return 文件名
     */
    private String getFileName(String path) {
        int separatorIndex = path.lastIndexOf("/");
        return (separatorIndex < 0) ? path : path.substring(separatorIndex + 1);
    }

    /**
     * 根据Response的流对象取出文件并进行存储
     *
     * @param response Response
     * @return 是否成功
     */
    boolean saveFileFromStream(Response response, String url, String destPath) {

        InputStream is = null;
        byte[] buf = new byte[2048];
        int len;
        FileOutputStream fos = null;
        try {
            is = response.body().byteStream();
            File file = new File(destPath, getFileName(url));
            fos = new FileOutputStream(file);
            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
