package com.yu.mar211cdajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@Autowired
	private DAO wDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String indexGo(HttpServletRequest req) {
		req.setAttribute("cp", "cdajax4.jsp");
		return "index";
	}

	// weather.get -> 기상청에서 받은 XML 그대로 응답
	@RequestMapping(value = "/weather.get", method = RequestMethod.GET, produces = "application/xml; charset=utf-8")
	public @ResponseBody String weatherGet() {
		return wDAO.get();
	}
}
