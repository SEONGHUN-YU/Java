package com.yu.mar065sdi.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// HomeController 하나에 다 해도 되는데 <- 원래는 이렇게 하는 게 맞음
// 폴더 정리 차원에서 만든 CalcController이다

@Controller
public class CalcController {

	@Autowired
	private CalcDAO cDAO;

	@RequestMapping(value = "/calculate.do", method = RequestMethod.GET)
	public String calcDo(XXXYYY xxxyyy, HttpServletRequest req) { // 이런 식으로 믹스된 방식을 자주 쓰게 되지 않을까
		cDAO.calculate(xxxyyy, req);
		return "output";
	}

	// 요청 parameter받기
	// 1. 기존 JSP스타일
//	@RequestMapping(value = "/calculate.do", method = RequestMethod.GET)
//	public String calcDo(HttpServletRequest req) {
//		int result = Integer.parseInt(req.getParameter("x")) + Integer.parseInt(req.getParameter("y"));
//		System.out.println(result);
//		System.out.println("계산하고");
//		return "output";
//	}

	// 2. Spring스타일 (자동으로 형변환)
//	@RequestMapping(value = "/calculate.do", method = RequestMethod.GET)
//	public String calcDo(@RequestParam(value = "x") int x, @RequestParam(value = "y") int y) {
//		System.out.println(x + y);
//		return "output";
//	}

	// 3. Spring스타일 (자동으로 객체로 만들어 줌)
	// 		파일업로드, 날짜 처리해야할 때는 못 써먹음
//	@RequestMapping(value = "/calculate.do", method = RequestMethod.GET)
//	public String calcDo(XXXYYY xxxyyy) {
//		System.out.println(xxxyyy.getX());
//		System.out.println(xxxyyy.getY());
//		return "output";
//	}

	// 1번 + 3번 위주로 사용하게 될 것
//	@RequestMapping(value = "/calculate.do", method = RequestMethod.GET)
//	public String calcDo(XXXYYY xxxyyy, HttpServletRequest req) { // 이런 식으로 믹스된 방식을 자주 쓰게 되지 않을까
//		System.out.println(String.format("%d", xxxyyy.getX() + xxxyyy.getY()));
//		return "output";
//	}
}
