package com.cworld.timeline.util;

import javax.servlet.http.Cookie;

public class CookieUtil {
	public static String getCookieValue(Cookie cookie) {
		String cookieValue = cookie.getValue();
		cookieValue = cookieValue.replaceAll("%20", " ").replaceAll("%2C", ",");
		return cookieValue;

	}
}
