package com.yu.bpbascp.sns;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yu.bpbascp.member.Member;

@Service
public class SNSDAO {
	@Autowired
	private SqlSession ss;

	public void writePost(SNSPOST sp, HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			// <textarea>에서 엔터 : \r\n
			// 웹에서는 : <br>
			// => 받아온 값을 .replace()로 처리
			sp.setBs_writer(m.getBm_id());
			sp.setBs_txt(sp.getBs_txt().replace("\r\n", "<br>"));
			if (ss.getMapper(SNSMapper.class).writePost(sp) == 1) {
				req.setAttribute("result", "글 작성 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "글 작성 실패");
		}
	}
}
