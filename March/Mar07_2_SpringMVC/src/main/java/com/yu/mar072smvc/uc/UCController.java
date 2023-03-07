package com.yu.mar072smvc.uc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UCController {

	@Autowired
	private UnitConverter UCDAO;

	@RequestMapping(value = "/unit.convert", method = RequestMethod.GET)
	public String output(UCBean b, HttpServletRequest req) {
		UCDAO.convert(b, req);
		return "output";
	}
}
