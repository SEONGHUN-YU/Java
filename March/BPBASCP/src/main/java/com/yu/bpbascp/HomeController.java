package com.yu.bpbascp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goIndex(HttpServletRequest req) {
		req.setAttribute("loginPage", "member/login.jsp"); // 나중에 대체될 것
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String indexDo(HttpServletRequest req) {
		return goIndex(req);
	}
}
