package com.yu.mar073smmb.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MenuController {
	@Autowired
	private MenuDAO mDAO;

	@RequestMapping(value = "/menu.reg", method = RequestMethod.GET)
	public String menuReg(Menu m) {
		mDAO.reg(m);
		return "input";
	}
}
