package com.yu.mar201ajax.menu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MenuController {

	@Autowired
	private MenuDAO mDAO;

	@RequestMapping(value = "/output.go", method = RequestMethod.GET)
	public String outputGo(HttpServletRequest req) {
		mDAO.get(req);
		req.setAttribute("cp", "output.jsp");
		return "index";
	}

	@RequestMapping(value = "/menu.get.xml", method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody Menus menuGetXML() {
		return mDAO.getXML();
	}
	
	@RequestMapping(value = "/menu.reg", method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody String menuReg(Menu m) {
		return mDAO.reg(m);
	}
	
	@RequestMapping(value = "/menu.search", method=RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody Menus menuSearch(Menu m) {
		return mDAO.searchXML(m);
	}
}
