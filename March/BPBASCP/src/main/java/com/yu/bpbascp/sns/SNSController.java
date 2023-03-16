package com.yu.bpbascp.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yu.bpbascp.TokenGenerator;
import com.yu.bpbascp.member.MemberDAO;

@Controller
public class SNSController {

	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private SNSDAO sDAO;

	@RequestMapping(value = "/sns.go", method = RequestMethod.GET)
	public String snsGo(HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.getPost(req, 1);
			sDAO.clearSearch(req);
			TokenGenerator.generate(req);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/sns.post.write", method = RequestMethod.GET)
	public String snsPostWrite(SNSPost sp, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.writePost(sp, req);
			sDAO.getPost(req, 1);
			sDAO.clearSearch(req);
			TokenGenerator.generate(req);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/sns.page.move", method = RequestMethod.GET)
	public String snsPageMove(@RequestParam(value = "p") int p, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.getPost(req, p);
			TokenGenerator.generate(req);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/sns.search", method = RequestMethod.GET)
	public String snsSearch(@RequestParam(value = "search") String search, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.search(search, req);
			sDAO.getPost(req, 1);
			TokenGenerator.generate(req);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/sns.post.delete", method = RequestMethod.GET)
	public String snsPostDelete(SNSPost s, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.deletePost(s, req);
			sDAO.clearSearch(req);
			sDAO.getPost(req, 1);
			TokenGenerator.generate(req);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/sns.reply.write", method = RequestMethod.GET)
	public String snsReplyWrite(SNSReply sr, HttpServletRequest req) {
		if (mDAO.isLogined(req)) {
			sDAO.writeReply(sr, req);
			sDAO.clearSearch(req); // ???
			sDAO.getPost(req, 1); // ???
			TokenGenerator.generate(req);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/sns.post.update", method = RequestMethod.GET)
	public String snsPostUpdate(SNSPost s, HttpServletRequest req) { // rough
		if (mDAO.isLogined(req)) {
			sDAO.updatePost(s, req);
			TokenGenerator.generate(req);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
}
