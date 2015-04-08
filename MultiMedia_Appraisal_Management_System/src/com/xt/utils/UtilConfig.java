package com.xt.utils;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Í³Ò»±àÂë UTF-8
 * */
public class UtilConfig {

	public static String CHARSET = "UTF-8";

	public static void encoding(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			request.setCharacterEncoding(CHARSET);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		response.setContentType("text/html;charset=utf-8");

		response.setCharacterEncoding(CHARSET);
	}

}
