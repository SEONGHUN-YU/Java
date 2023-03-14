package com.yu.bpbascp.dataroom;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yu.bpbascp.BPBASCPOptions;
import com.yu.bpbascp.member.Member;

@Service
public class DataroomDAO {
	private int allFileCount;

	@Autowired
	private SqlSession ss;
	@Autowired
	private BPBASCPOptions bo;

	public void setAllFileCount() {
		allFileCount = ss.getMapper(DataroomMapper.class).getAllFileCount();
	}

	public void getFile(HttpServletRequest req, int page) {
		try {
			int pageCount = (int) Math.ceil(allFileCount / (double) bo.getDataroomFilePerPage());
			int start = (page - 1) * bo.getDataroomFilePerPage() + 1;
			int end = page * bo.getDataroomFilePerPage();

//			DataroomSelector ds = new DataroomSelector(start, end);
			List<DataroomFile> files = ss.getMapper(DataroomMapper.class).getFile(new DataroomSelector(start, end));
			req.setAttribute("files", files);
			req.setAttribute("filePageCount", pageCount);
			req.setAttribute("filePage", page);
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
				allFileCount++;
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

	public void deleteData(HttpServletRequest req) { // rough

	}

	// 그림파일인식, 음악파일인식, 영상파일인식 방법이 다를 수가 없음
	public void download(DataroomFile df, HttpServletRequest req, HttpServletResponse res) {
		// 쌩 자바로 파일에서 읽어내서 : ㅋ.png (fis 사용)
		FileInputStream fis = null; // 파일에 있는 거 꺼낼 때 쓰는 빨대[1byte]
		// tomcat + jsp로 응답 : %2A.png (sos 사용)
		ServletOutputStream sos = null; // 클라이언트한테 응답할 때 쓰는 빨대[1byte]
		try {
			String fileNameHangul = df.getBd_file(); // 한글처리 된 파일명 [%2A.png - tomcat용] <- 디코딩 필요함
			String fileName = URLDecoder.decode(df.getBd_file(), "utf-8"); // 한글처리 풀린 파일명 [ㅋ.png - java용]
			String path = req.getSession().getServletContext().getRealPath("resources/dataroom");
			fis = new FileInputStream(path + "/" + fileName);

			res.reset(); // 혹시나 기존에 응답객체에 뭐 들어있던 거 지우는 method

			res.setContentType("application/octet-stream"); // 파일 다운시켜주는 응답이라고 선언해줌
			res.setHeader("Content-Disposition", "attachment; filename=" + fileNameHangul);
			// ↑ 웹에서 일어나는 일이라 서버에 저장된 이름[tomcat용]을 씀

			sos = res.getOutputStream();

			// fis로 파일에서 읽어내서, sos로 쏴줄 것(전송할 것)
			// fis로 파일에 들어있는 데이터 읽어서, 클라이언트에게 전송
			// C언어 냄새
			byte[] b = new byte[4096]; // 4k byte씩 읽어서 저장시키도록 해보았음(내 마음, 근데 대부분 이렇게 쓴다 함)
			int data = 0;
			// 4000개 읽어서 data에 저장 -> 그걸 data에 저장
			// data에 뭐 저장된 게 없을 때까지 반복, data라는 식별자는 while문 돌리는 용도로 씀
			while ((data = fis.read(b, 0, b.length)) != -1) {
				sos.write(b, 0, b.length); // b에 저장되어 있는 걸 응답
			}
			sos.flush(); // 용량 꽉 안 차도 전송시킴

			// data = fis.read(b, 0, b.length)
			// 0 : 처음부터
			// b.length : 4000개
			// 읽어서 b에다 저장
			// 그거를 int로 변환해서 data라는 식별자에 저장한다는 의미

//			String s = "abc";
//			char[] c = {'a','b','c'}; // C에서는 이런식으로 한다나 봄

			// 한글처리 된 파일명[%2A.png]
			// 한글처리 풀린 파일명[ㅋ.png]
			// 파일 다운로드 구현하려면 이 2개가 필요함
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			sos.close();
		} catch (Exception e) {
		}
		try {
			fis.close();
		} catch (Exception e) {
		}
	}
}
