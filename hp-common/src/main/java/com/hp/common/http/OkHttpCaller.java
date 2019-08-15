package com.hp.common.http;

import okhttp3.MediaType;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * 接口类，用来管理需要的方法
 * 
 * 
 * 
 * @author wanggw
 *
 */
public interface OkHttpCaller {

	/**
	 * 发送GET请求（同步）
	 * 
	 * @param url
	 *            请求url
	 * @return 返回值
	 * @throws Exception
	 */
	String callGetSync(String url) throws IOException;

	/**
	 * 发送GET请求，专为大型数据准备，返回数据超过1M可以使用（同步）
	 * 
	 * @param url
	 *            请求url
	 * @return 返回值
	 */
	InputStream callGetStreamSync(String url) throws IOException;

	/**
	 * 发送GET请求，专为大型数据准备，返回数据超过1M可以使用（同步）
	 * 
	 * @param url
	 *            请求url
	 * @return 返回值
	 * @throws IOException
	 */
	byte[] callGetBytesSync(String url) throws IOException;

	/**
	 * 发送GET请求（异步）
	 * 
	 * @param url
	 *            请求url
	 * @return 返回值
	 * @throws Exception
	 */
	void callGetAsync(String url, OkHttpCallback callback) throws IOException;

	/**
	 * 发送POST请求，参数为字符串 （同步）
	 * 
	 * @param url
	 *            请求url
	 * @param param
	 *            字符串
	 * @return 返回值
	 */
	String callPostSync(String url, String param, MediaType mediaType) throws IOException;

	/**
	 * 发送POST请求，参数为键值对 （同步）
	 * 
	 * @param url
	 *            请求url
	 * @param param
	 *            键值对参数
	 * @return 返回值
	 * 
	 * @throws IOException
	 */
	String callPostSync(String url, Map<String, Object> param) throws IOException;

	/**
	 * 发送POST请求，参数为字符串 ，返回值为流对象，适用于下载大文件（同步）
	 * 
	 * @param url
	 *            请求url
	 * @param param
	 *            字符串
	 * @return 返回值
	 */
	InputStream callStreamPostSync(String url, String param, MediaType mediaType) throws IOException;

	/**
	 * 发送POST请求，参数为键值对，返回值为流对象，适用于下载大文件（同步）
	 *
	 * @param url
	 *            请求url
	 * @param param
	 *            键值对参数
	 * @return 返回值
	 *
	 * @throws IOException
	 */
	InputStream callStreamPostSync(String url, Map<String, Object> param) throws IOException;

	/**
	 * 发送POST请求，参数为字符串 ，返回值为字节数组，通用（同步）
	 *
	 * @param url
	 *            请求url
	 * @param param
	 *            字符串
	 * @return 返回值
	 */
	byte[] callBytesPostSync(String url, String param, MediaType mediaType) throws IOException;

	/**
	 * 发送POST请求，参数为键值对，返回值为字节数组，通用（同步）
	 *
	 * @param url
	 *            请求url
	 * @param param
	 *            键值对参数
	 * @return 返回值
	 *
	 * @throws IOException
	 */
	byte[] callBytesPostSync(String url, Map<String, Object> param) throws IOException;

	/**
	 * 发起POST请求，参数为字符串，异步
	 *
	 * @param url
	 *            请求链接
	 * @param param
	 *            参数
	 */
	void callPostAsync(String url, String param, MediaType mediaType, OkHttpCallback callback);

	/**
	 * 发起POST请求，参数为键值对，异步
	 * 
	 * @param url
	 *            请求链接
	 * @param param
	 *            参数
	 */
	void callPostAsync(String url, Map<String, Object> param, OkHttpCallback callback);

	/**
	 * 下载文件（同步）
	 * 
	 * @param url
	 *            链接
	 * @param destPath
	 *            存储位置
	 * @return 结果
	 */
	boolean downloadFileSync(String url, String destPath) throws IOException;

	/**
	 * 下载文件（异步）
	 * 
	 * @param url
	 *            链接
	 * @param destPath
	 *            存储位置
	 */
	void downloadFileASync(String url, String destPath) throws IOException;

}
