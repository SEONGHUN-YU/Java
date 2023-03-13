package com.yu.bpbascp.member;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yu.bpbascp.sns.SNSDAO;
import com.yu.bpbascp.sns.SNSMapper;

@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;
	@Autowired
	private SNSDAO sDAO;

	public void login(Member m, HttpServletRequest req) {
		try {
			Member dbMember = ss.getMapper(MemberMapper.class).getMemberByID(m);
			if (dbMember != null) {
				if (m.getBm_pw().equals(dbMember.getBm_pw())) {
					req.getSession().setAttribute("loginMember", dbMember);
					req.getSession().setMaxInactiveInterval(600); // ???
				} else {
					req.setAttribute("result", "로그인 실패 (PW)");
				}
			} else {
				req.setAttribute("result", "로그인 실패 (미가입ID)");
			}
		} catch (Exception e) {
			req.setAttribute("result", "로그인 실패(DB)");
		}
	}

	public boolean isLogined(HttpServletRequest req) {
		if (req.getSession().getAttribute("loginMember") != null) {
			req.setAttribute("loginPage", "member/welcome.jsp");
			return true;
		}
		req.setAttribute("loginPage", "member/login.jsp");
		return false;
	}

	public void logout(HttpServletRequest req) {
//		req.getSession().setMaxInactiveInterval(-1); 너무 격하고
		req.getSession().setAttribute("loginMember", null);
	}

	public void splitAddress(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String[] address = m.getBm_address().split("!");
		req.setAttribute("addr1", address[2]);
		req.setAttribute("addr2", address[0]);
		req.setAttribute("addr3", address[1]);
	}

	// req.parameter명(input name="")이랑 Bean멤버변수명 같게 해놓으면
	// 자동으로 JavaBean 객체 만들어 주는 좋은 기능이 있지만
	// 날짜 관련쪽은 자동으로 못 함
	// #1 010303-1234567 -> 2001/03/03 으로 Spring이 직접해줄리가... 내가 처리해야 함
	// #2 주소도 input 3개에 나눠져 있기 때문에, 마찬가지로 합치는 작업이 필요
	// 인코딩방식이 달라졌으면 => 자동으로 못함(지금 form의 enctype을 "multipart/form-data"로 바꿨기 때문에
	// 인코딩방식이 바뀜)
	// #3 게다가 파일 업로드 관련 작업은 mr.getParameter로 받아야 하기 때문에
	// req.getParameter때 적용되던 SpringMVC의 자동 객체 생성기능이 사용 불가능해짐
	// 한마디로 파일 업로드 작업이 끼어드는 순간 JSP시절에 하던 방식으로 완전 다 해야한다는 뜻...
	public void reg(Member m, HttpServletRequest req) {
		// 상대경로를 쓰면 -> 서버상의 절대경로로 바꿔주는 method 체인
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		// 인코딩방식이 달라져서 (enctype="multipart/form-data" 때문에)
		// req.getParameter로 못 읽고
		// 바뀐 인코딩방식의 요청객체[근데 파일처리도 되는] == mr
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입 실패(파일 문제)");
			return;
		}
		try {
			m.setBm_id(mr.getParameter("bm_id"));
			m.setBm_pw(mr.getParameter("bm_pw"));
			m.setBm_name(mr.getParameter("bm_name"));

			String bd = String.format("%s%02d%02d", mr.getParameter("bm_y"), Integer.parseInt(mr.getParameter("bm_m")),
					Integer.parseInt(mr.getParameter("bm_d")));
			Date bm_birthday = new SimpleDateFormat("yyyyMMdd").parse(bd);
			m.setBm_birthday(bm_birthday);
			// 그냥 바로 new SimpleDateFormat("yyyyMMdd").parse(bd)를 넣어줘도 되는데
			// Date인 걸 알 수 있도록 변수로 남겨둠

			m.setBm_address(mr.getParameter("bm_addr2") + "!" + mr.getParameter("bm_addr3") + "!"
					+ mr.getParameter("bm_addr1"));
			m.setBm_photo(URLEncoder.encode(mr.getFilesystemName("bm_photo"), "utf-8").replace("+", " "));
			if (ss.getMapper(MemberMapper.class).reg(m) == 1) {
				req.setAttribute("result", "가입 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "가입 실패(네트워크 문제)");
			// 이미 업로드 되어있을 프사파일 삭제
			new File(path + "/" + mr.getFilesystemName("bm_photo")).delete();
		}
	}

	public void update(Member m, HttpServletRequest req) { // m 쓰나마나임
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, req.getSession().getServletContext().getRealPath("resources/img"),
					10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정 실패 (파일 문제 [용량초과])");
			return;
		}

		Member sesM = null;
		try {
			sesM = (Member) req.getSession().getAttribute("loginMember");

			m.setBm_pw(mr.getParameter("bm_pw"));
			m.setBm_name(mr.getParameter("bm_name"));

			m.setBm_address(mr.getParameter("bm_addr2") + "!" + mr.getParameter("bm_addr3") + "!"
					+ mr.getParameter("bm_addr1"));

			if (mr.getFilesystemName("bm_photo") == null) { // m = old
				m.setBm_photo(sesM.getBm_photo());
			} else { // m = new
				m.setBm_photo(URLEncoder.encode(mr.getFilesystemName("bm_photo"), "utf-8").replace("+", " "));
			}

			m.setBm_id(sesM.getBm_id());

			if (ss.getMapper(MemberMapper.class).update(m) == 1) { // 객체 m에 담은 정보를 SQL문에 세팅
				req.setAttribute("result", "수정 성공");
				if (!sesM.getBm_photo().equals(m.getBm_photo())) { // 파일 이름이 다른지 비교, 다르면 이전 꺼 삭제
					new File(req.getSession().getServletContext().getRealPath("resources/img") + "/"
							+ URLDecoder.decode(sesM.getBm_photo(), "utf-8")).delete();
				}
				req.getSession().setAttribute("loginMember", ss.getMapper(MemberMapper.class).getMemberByID(m));
			} else {
				req.setAttribute("result", "잘못된 접근입니다");
				if (!sesM.getBm_photo().equals(m.getBm_photo())) { // 파일 이름이 다른지 비교, 실패했으니 새로등록된 거 없앰
					new File(req.getSession().getServletContext().getRealPath("resources/img") + "/"
							+ URLDecoder.decode(m.getBm_photo(), "utf-8")).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "수정 실패 (DB 문제 [네트워크 연결 실패 등])");
			if (!sesM.getBm_photo().equals(m.getBm_photo())) { // 파일 이름이 다른지 비교, 실패했으니 새로등록된 거 없앰
				try {
					new File(req.getSession().getServletContext().getRealPath("resources/img") + "/"
							+ URLDecoder.decode(m.getBm_photo(), "utf-8")).delete();
				} catch (Exception e2) {
				}
			}
		}
	}

	public void bye(HttpServletRequest req) { // 탈퇴하기
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			int PostCountByWriter = ss.getMapper(SNSMapper.class).getPostCountByWriter(m);
			if (ss.getMapper(MemberMapper.class).bye(m) == 1) {
				req.setAttribute("result", "탈퇴 성공");
				new File(req.getSession().getServletContext().getRealPath("resources/img") + "/"
						+ URLDecoder.decode(m.getBm_photo(), "utf-8")).delete(); // 톰캣에 저장된 이미지 파일은 utf-8 아니라서 디코딩 해준다
				sDAO.setAllPostCount(sDAO.getAllPostCount() - PostCountByWriter);
			} else {
				req.setAttribute("result", "탈퇴 실패");
			}
		} catch (Exception e) {
			req.setAttribute("result", "탈퇴 실패");
		}
	}
}
