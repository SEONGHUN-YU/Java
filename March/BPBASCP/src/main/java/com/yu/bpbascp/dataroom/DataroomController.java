package com.yu.bpbascp.dataroom;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yu.bpbascp.TokenGenerator;
import com.yu.bpbascp.member.MemberDAO;

@Controller
public class DataroomController {

	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private DataroomDAO dDAO;

	@RequestMapping(value = "/dataroom.go", method = RequestMethod.GET)
	public String dataroomGo(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			dDAO.getFile(req, 1);
			TokenGenerator.generate(req);
			req.setAttribute("contentPage", "dataroom/dataroom.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/dataroom.upload", method = RequestMethod.POST)
	public String dataroomUpload(DataroomFile df, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			dDAO.uploadData(df, req);
			TokenGenerator.generate(req);
			req.setAttribute("contentPage", "dataroom/dataroom.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
}
