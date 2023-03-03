package com.yu.mar031jspmb.snack;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import seonghun.yu.db.manager.YUDBManager;

public class SnackDAO {
	private int allSnackCount;
	private int snackPerPage;
	private static final SnackDAO SNACKDAO = new SnackDAO();

	private SnackDAO() {
		snackPerPage = 5;
	}

	public static SnackDAO getDAO() {
		return SNACKDAO;
	}

	public void setAllSnackCount() {
		SqlSession ss = null;
		try {
			ss = YUDBManager.getYUDBM().getSSFactory().openSession();
			allSnackCount = ss.selectOne("snackMapper.getAllSnackCount");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}

	// ConnectionPool - tomcat
	// 튜브대여소 : DataSource
	// 튜브 : Connection
	// MyBatis - 자체시스템
	// 튜브대여소 : SqlSessionFactory
	// 튜브 : SqlSession

	// Java 관련된 경로는 src 기준으로 되어 있음 그래서 Resources.getResourceAsReader("")
	// 해줄 때 src 기준으로 경로를 쓸 것
	public void reg(HttpServletRequest req) {
		SqlSession ss = null; // Connection + PreparedStatement 같은 느낌
		try {
			// ~ 2.0까지는 .close(); 가 길어서 만든 느낌이면
			// YUDBManager_v3.0은 굳이 매번 대여소를 만들 필요를 못 느껴서 만드는 것
			InputStream is = Resources.getResourceAsStream("com/yu/mar031jspmb/main/config.xml");
			// 쌩 설정파일에서 데이터 가져올 수 있는 빨대 InputStream
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder(); // 건축가 만들기
			SqlSessionFactory ssf = ssfb.build(is); // 설정파일을 토대로 만드는 튜브대여소
			ss = ssf.openSession(); // 튜브 빌려오기

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // String 형식

			// BigDecimal에 String 가능, Integer도 당연히 가능
			// 근데 parameter를 굳이 Integer로 바꿔서 넣을 필요는 없으니 String으로 넣을 것
			Snack s = new Snack(null, req.getParameter("name"),
					new BigDecimal(Integer.parseInt(req.getParameter("price"))), sdf.parse(req.getParameter("date")));
			if (ss.insert("snackMapper.reg", s) == 1) {
				req.setAttribute("result", "성공");
				allSnackCount++;
				ss.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "실패");
		}
		ss.close();
	}

	public void get(HttpServletRequest req, int page) {
		SqlSession ss = null;
		try {
			ss = YUDBManager.getYUDBM().getSSFactory().openSession();
			int snackCount = allSnackCount;
			String search = "";

			int pageCount = (int) Math.ceil(allSnackCount / (double) snackPerPage);
			int start = (page - 1) * snackPerPage + 1;
			int end = page * snackPerPage;

			req.setAttribute("pageCount", pageCount);
			req.setAttribute("curPage", page);
			req.setAttribute("snacks", ss.selectList("snackMapper.get", new SnackSelector(search, start, end)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		ss.close();
	}
}
