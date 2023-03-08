package com.yu.bpbascp;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class DateManager {
	public static void getCurYear(HttpServletRequest req) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date now = new Date();
		req.setAttribute("curYear", Integer.parseInt(sdf.format(now)));
	}
}
