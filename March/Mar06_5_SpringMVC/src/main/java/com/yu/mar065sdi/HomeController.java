package com.yu.mar065sdi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// JSP : Servlet
//		doGet, doPost - 요청 2개 감당가능
// Spring : 일반 class
//		일반 method
@Controller
public class HomeController {
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index() {
		return "input";
		// request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	// http://localhost/mar065sdi/tes.t로 GET방식 요청
	@RequestMapping(value="/tes.t", method=RequestMethod.GET)
	public void test() { // @RequestMapping에 의해서, 어떤 요청이 들어오면 이 method가 돌아감
		System.out.println("테스트");
	}
	
	@RequestMapping(value="/abc.def", method=RequestMethod.GET)
	public void test2() {
		System.out.println("abcdef");
	}
	
}
