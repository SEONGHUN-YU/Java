package com.yu.bpbascp.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yu.bpbascp.DateManager;

@Controller
public class MemberController {

	@Autowired
	private MemberDAO mDAO;
	
	// 가입하기
	@RequestMapping(value = "/member.reg.do", method = RequestMethod.POST) // 파일 업로드라서 post여야 하는데, 개인정보이기도하고 겸사겸사 post로 받아야 함
	public String memberRegDo(Member m, HttpServletRequest req) {
		mDAO.reg(m, req);
		req.setAttribute("loginPage", "member/login.jsp");
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	// 가입할 때 필요한 정보들 입력하러 가기
	@RequestMapping(value = "/member.reg.go", method = RequestMethod.GET)
	public String memberRegGo(Member m, HttpServletRequest req) { // 여기로 옴
		DateManager.getCurYear(req);
		req.setAttribute("loginPage", "member/login.jsp");
		req.setAttribute("contentPage", "member/reg.jsp");
		return "index";
	}
}
