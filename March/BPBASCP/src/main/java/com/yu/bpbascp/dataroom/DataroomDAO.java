package com.yu.bpbascp.dataroom;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yu.bpbascp.BPBASCPOptions;
import com.yu.bpbascp.member.Member;

@Service
public class DataroomDAO {

	@Autowired
	private SqlSession ss;
	@Autowired
	private BPBASCPOptions bo;

	public void getFile(HttpServletRequest req, int page) {
		try {
//			int start = (page - 1) * bo.getDataroomFilePerPage() + 1;
//			int end = page * bo.getDataroomFilePerPage();
			
			List<DataroomFile> files = ss.getMapper(DataroomMapper.class).getFile();
			req.setAttribute("files", files);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void uploadData(DataroomFile df, HttpServletRequest req) {
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, req.getSession().getServletContext().getRealPath("resources/dataroom"),
					500 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "파일 업로드 실패 (파일 용량 초과)");
			// 이 때는 파일 업로드가 안 돼서 삭제할 필요가 없음
			return;
		}

//		String bd_file = mr.getFilesystemName("bd_file"); // 이렇게 해도 상관은 없는
//				  ↑ 이걸 빼고 URLEncoder 쌩으로 때려넣어서 try-catch가 필수가 되어버림
		String token = mr.getParameter("token");
		String lastSuccessToken = (String) req.getSession().getAttribute("successToken");
		if (lastSuccessToken != null && token.equals(lastSuccessToken)) {
			req.setAttribute("result", "파일 업로드 실패 (새로고침)");
			try {
				new File(req.getSession().getServletContext().getRealPath("resources/dataroom") + "/"
						+ URLEncoder.encode(mr.getFilesystemName("bd_file"), "utf-8")).delete();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return;
		}

		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");

			df.setBd_uploader(m.getBm_id());
			df.setBd_title(mr.getParameter("bd_title"));
			df.setBd_file(URLEncoder.encode(mr.getFilesystemName("bd_file"), "utf-8").replace("+", " "));

			if (ss.getMapper(DataroomMapper.class).upload(df) == 1) {
				req.setAttribute("result", "파일 업로드 성공");
				req.getSession().setAttribute("successToken", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "파일 업로드 실패");
			try {
				new File(req.getSession().getServletContext().getRealPath("resources/dataroom") + "/"
						+ URLEncoder.encode(mr.getFilesystemName("bd_file"), "utf-8").replace("+", " ")).delete();
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
		}
	}
}
