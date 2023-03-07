package com.yu.mar071smvc.uc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UCController {

	// 1) 하나만 등록되어있어야
	// 2) aac방식이어야
	// 하나만 등록되어있는 객체 자동으로 연결(생성자x, 세터x)
	// 1,2를 만족해야 Autowired가 발동
	@Autowired
	private UCDAO UCDAO;
//	@Autowired private CalcDAO cDAO; 여기에 이걸 또 써도 오류가 안 나는 것처럼
//	Autowired는 필요할 때마다 같은 장소에서도 여러번 쓸 수 있다
	
	@RequestMapping(value = "/input.in", method = RequestMethod.GET)
	public String calc(@RequestParam(value = "value") double n, HttpServletRequest req) {
		UCDAO.calculate(n, req);
		return "output";
	}
}
