package com.yu.mar141.print;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PresentController { // XML 응답 만들기

	@Autowired
	private PresentDAO pDAO;

	@RequestMapping(value = "/output.go", method = RequestMethod.GET)
	public String goOutput(HttpServletRequest req) {
		pDAO.get(req);
		req.setAttribute("contentPage", "output.jsp");
		return "index";
	}

	@RequestMapping(value = "/manager.request.get", 
			method = RequestMethod.GET,
			produces = "application/xml; charset=utf-8")
	public @ResponseBody Presents managerRequestGet(HttpServletRequest req) {
		return pDAO.getXML(req); // NewFile.jsp로 포워딩
								// NewFile이라는 글자를 응답하고 싶으면? @ResponseBody
	}
}
