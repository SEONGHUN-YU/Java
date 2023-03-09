package com.yu.bpbascp.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yu.bpbascp.member.MemberDAO;

@Controller
public class SNSController {

	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SNSDAO sDAO;

	@RequestMapping(value = "/sns.go", method = RequestMethod.GET)
	public String snsGo(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/sns.post.write", method = RequestMethod.GET)
	public String snsPostWrite(SNSPOST sp, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.writePost(sp, req);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
}
