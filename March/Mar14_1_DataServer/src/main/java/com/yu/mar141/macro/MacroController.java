package com.yu.mar141.macro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MacroController { // JSON 응답 만들기

	@Autowired
	private MacroDAO mDAO;

	@RequestMapping(value = "/macro.get", method = RequestMethod.GET)
	public String get(HttpServletRequest req) {
		mDAO.get(req);
		req.setAttribute("contentPage", "output.jsp");
		return "index";
	}

	@RequestMapping(value = "/macro.get.json", 
			method = RequestMethod.GET, 
			produces = "application/json; charset=utf-8")
	public @ResponseBody Macros getJSON(HttpServletRequest req, HttpServletResponse res) {
		// JavaScript는 외부 데이터 파싱 불가능해서
		// 이대로는 이 데이터 제 3자에게 못 줌
		// 이 데이터를 외부에서도 쓸 수 있게 하자면
		// 이 프로젝트 외부의 JavaScript에서도 쓸 수 있게
		res.setHeader("Access-Control-Allow-Origin", "*"); // 응답(response) 헤더 추가
		//											 ↑ "192.168.0.140" 이런식으로 하면
		// 이 사람의 요청에만 응답이 감, 나머지는 요청해도 팅겨나간다고 함 (JS에서 AJAX하려고 하는 걸 막는 것)
		// 열람하는 건 아무나 가능한 것 같음, 파싱이 불가(?)
		return mDAO.getJSON(req);
	}
}
