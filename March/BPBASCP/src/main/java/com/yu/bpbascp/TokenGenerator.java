package com.yu.bpbascp;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class TokenGenerator {
	public static void generate(HttpServletRequest req) {
		req.setAttribute("token", new SimpleDateFormat("hhmmss").format(new Date()));
	}
}
