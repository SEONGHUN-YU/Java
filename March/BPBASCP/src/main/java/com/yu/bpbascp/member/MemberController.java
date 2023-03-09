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
	@RequestMapping(value = "/member.reg.do", method = RequestMethod.POST)
	public String memberRegDo(Member m, HttpServletRequest req) {
		// 파일 업로드라서 post여야 하는데, 개인정보이기도하고 겸사겸사 post로 받아야 함
		mDAO.reg(m, req);
		mDAO.isLogined(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	// 가입할 때 필요한 정보들 입력하러 가기
	@RequestMapping(value = "/member.reg.go", method = RequestMethod.GET)
	public String memberRegGo(HttpServletRequest req) { // 여기로 옴
		DateManager.getCurYear(req);
		mDAO.isLogined(req);
		req.setAttribute("contentPage", "member/reg.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String memberLogin(Member m, HttpServletRequest req) {
		mDAO.login(m, req);
		mDAO.isLogined(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String memberLogout(HttpServletRequest req) {
		mDAO.logout(req);
		mDAO.isLogined(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	// value="/주소"를 동사형으로 짓는 게 좋다 .info보다는 info.go가 좋음
	@RequestMapping(value = "/member.info.go", method = RequestMethod.GET)
	public String memberInfoGo(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			mDAO.splitAddress(req);
			req.setAttribute("contentPage", "member/info.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/member.info.update", method = RequestMethod.POST)
	public String MemberInfoUpdate(Member m, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			mDAO.update(m, req);
			mDAO.splitAddress(req);
			req.setAttribute("contentPage", "member/info.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/member.bye", method = RequestMethod.GET)
	public String MemberBye(HttpServletRequest req) {
		if (mDAO.isLogined(req)) { // 로그인여부 체크
			mDAO.bye(req); // DB에서 정보 삭제
			mDAO.logout(req); // 세션 끊기
			mDAO.isLogined(req); // 로그인여부 체크 -> 페이지 강제이동시키기
		}
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
}
