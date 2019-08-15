package com.hp.common.http;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 发送请求工具类
 * 
 * @author wanggw
 *
 */
public class OkHttpCallerBase {

	/**
	 * 对于拼接在url后面的参数，从map进行字符串转换
	 * 
	 * 将每一个key和value取出形成key=val的样式，每对之间用&符号进行分割
	 * 
	 * 
	 * @param param
	 *            参数
	 * @return 字符串
	 */
	public static String generateUrlParam(Map<String, Object> param) {
		StringBuilder stringBuffer = new StringBuilder();
		if (param != null && param.size() > 0) {
			Object[] keys = param.keySet().toArray();
			for (int i = 0; i < keys.length; i++) {
				stringBuffer.append(i == 0 ? keys[i].toString().concat("=").concat(param.get(keys[i]).toString())
						: "&".concat(keys[i].toString().concat("=").concat(param.get(keys[i]).toString())));
			}
		}
		return stringBuffer.toString();
	}

	/**
	 * 将对象数据序列化后写出到前台
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @param data
	 *            待写出数据
	 * @throws Exception
	 */
	public static void writeJson(HttpServletRequest request, HttpServletResponse response, Object data)
			throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String rs = mapper.writeValueAsString(data);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(rs);
		out.flush();
		out.close();
	}

}
