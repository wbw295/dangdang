package org.tarena.dang.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookie工具类，提供了cookie的添加、 查询、删除方法。
 * 
 */
public class CookieUtil {
	private static int age = 3600 * 24; // 缺省的生存时间
	private static String path = "/dang";

	// 应用名，如果要将该工具用在其它的应用当中，需要
	// 修改这个值。

	/**
	 * 添加cookie,考虑了编码、生存时间、路径问题。
	 */
	public static void addCookie(String name, String value, int age,
			HttpServletResponse response) throws UnsupportedEncodingException {
		Cookie c = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		c.setMaxAge(age);
		c.setPath(path);
		response.addCookie(c);
	}

	/**
	 * 使用缺省的生存时间添加一个cookie
	 */
	public static void addCookie(String name, String value,
			HttpServletResponse response) throws UnsupportedEncodingException {
		addCookie(name, value, age, response);

	}

	/**
	 * 依据cookie的名称返回cookie的值，如果 找不到对应的cookie,返回null。
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public static String findCookie(String name, HttpServletRequest request)
			throws UnsupportedEncodingException {
		String value = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie c = cookies[i];
				if (c.getName().equals(name)) {
					value = URLDecoder.decode(c.getValue(), "utf-8");
				}
			}
		}
		return value;
	}

	/**
	 * 删除cookie
	 */
	public static void detete(String name, HttpServletResponse response) {
		Cookie c = new Cookie(name, "");
		c.setMaxAge(0);
		c.setPath(path);
		response.addCookie(c);

	}

}