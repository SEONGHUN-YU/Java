package com.yu.mar071smvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Servlet -> @Controller 붙은 일반 클래스로 바뀜
@Controller
public class HomeController {

	// doGet/doPost -> @RequestMapping 붙은 일반 메소드로 바뀜
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "input";
		// ↑ request.getRequestDispatcher("input.jsp".forward(request, response); <- 이거랑 기능 똑같음
	}
}
