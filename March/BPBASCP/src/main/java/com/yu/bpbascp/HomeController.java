package com.yu.bpbascp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yu.bpbascp.member.MemberDAO;
import com.yu.bpbascp.sns.SNSDAO;

@Controller
public class HomeController {

	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SNSDAO sDAO;

	private boolean firstReq;

	// HomeController, SNSDAO, SqlSession 셋 다
	// Spring이 자동으로 만들기 때문에 순서를 알 수가 없고, 그래서 생성자를 활용하기가 애매해졌다
	// [servlet-context.xml을 aac방식으로 자동으로 불러오는 중]
	// 내부구조를 알 수가 없으니, 전략을 바꾸자 => boolean 활용

	public HomeController() {
//		sDAO.setAllPostCount();
		firstReq = true;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goIndex(HttpServletRequest req) {
		if (firstReq) { // 첫 생성자 (사이트 처음으로 켜질 때) -> 첫 요청이 있을 때 select 하는 걸로 전략 바꿈
			sDAO.setAllPostCount();
			firstReq = false;
		}
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
