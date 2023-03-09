package com.yu.bpbascp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yu.bpbascp.member.MemberDAO;

@Controller
public class HomeController {

	@Autowired
	private MemberDAO mDAO;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goIndex(HttpServletRequest req) {
//		req.setAttribute("loginPage", "member/login.jsp"); // 나중에 대체될 것
		mDAO.isLogined(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/index.go", method = RequestMethod.GET)
	public String indexDo(HttpServletRequest req) {
		return goIndex(req);
	}
}
