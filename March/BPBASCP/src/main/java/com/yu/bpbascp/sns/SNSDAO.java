package com.yu.bpbascp.sns;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yu.bpbascp.BPBASCPOptions;
import com.yu.bpbascp.member.Member;

@Service
public class SNSDAO {
	private int allPostCount;

	@Autowired
	private SqlSession ss;

	@Autowired
	private BPBASCPOptions bo;

	public int getAllPostCount() {
		return allPostCount;
	}

	public void setAllPostCount(int allPostCount) {
		this.allPostCount = allPostCount;
	}

	public void setAllPostCount() {
		allPostCount = ss.getMapper(SNSMapper.class).getPostCount(new SNSSelector("", 0, 0));
	}

	public void search(String search, HttpServletRequest req) {
		req.getSession().setAttribute("search", search);
	}

	public void clearSearch(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}

	public void getPost(HttpServletRequest req, int page) {
		try {
			int postCount = allPostCount;
			String search = (String) req.getSession().getAttribute("search");
			if (search == null) {
				search = "";
			} else {
				SNSSelector searchOnly = new SNSSelector(search, 0, 0);
				postCount = ss.getMapper(SNSMapper.class).getPostCount(searchOnly);
			}
			int pageCount = (int) Math.ceil(postCount / (double) bo.getSnsPostPerPage());
			int start = (page - 1) * bo.getSnsPostPerPage() + 1;
			int end = page * bo.getSnsPostPerPage();

			SNSSelector sSel = new SNSSelector(search, start, end);

			List<SNSPost> posts = ss.getMapper(SNSMapper.class).getPost(sSel);
			for (SNSPost p : posts) {
				p.setBs_replys(ss.getMapper(SNSMapper.class).getReply(p));
			}
			req.setAttribute("posts", posts);
			req.setAttribute("pageCount", pageCount);
			req.setAttribute("page", page);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void writePost(SNSPost s, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String lastSuccessToken = (String) req.getSession().getAttribute("successToken");
			if (lastSuccessToken != null && token.equals(lastSuccessToken)) {
				// ???????????? ?????????
				req.setAttribute("result", "??? ?????? ?????? (????????????)");
				return;
			}

			Member m = (Member) req.getSession().getAttribute("loginMember");
			// <textarea>?????? ?????? : \r\n
			// ???????????? : <br>
			// => ????????? ?????? .replace()??? ??????
			s.setBs_writer(m.getBm_id());
			s.setBs_txt(s.getBs_txt().replace("\r\n", "<br>"));
			if (ss.getMapper(SNSMapper.class).writePost(s) == 1) {
				req.setAttribute("result", "??? ?????? ??????");
				req.getSession().setAttribute("successToken", token);
				allPostCount++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "??? ?????? ??????");
		}
	}

	public void deletePost(SNSPost s, HttpServletRequest req) {
		try {
			if (ss.getMapper(SNSMapper.class).deletePost(s) == 1) {
				req.setAttribute("result", "??? ?????? ??????");
				allPostCount--;
			} else {
				req.setAttribute("result", "??? ?????? ??????");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "??? ?????? ??????");
		}
	}

	// ??????????????? reply
	public void getReply(SNSReply sr, HttpServletRequest req) { // rough
		
	}
	
	public void writeReply(SNSReply sr, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String lastSuccessToken = (String) req.getSession().getAttribute("successToken");
			if (lastSuccessToken != null && token.equals(lastSuccessToken)) {
				req.setAttribute("result", "?????? ?????? ??????");
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			sr.setBsr_writer(m.getBm_id());
			if (ss.getMapper(SNSMapper.class).writeReply(sr) == 1) {
				req.setAttribute("result", "?????? ?????? ??????");
				req.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "?????? ?????? ??????");
		}
	}

	public void deleteReply(HttpServletRequest req) { // rough

	}
}
