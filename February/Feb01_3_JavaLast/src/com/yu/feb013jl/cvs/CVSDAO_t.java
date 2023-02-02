package com.yu.feb013jl.cvs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import seonghun.yu.db.manager.YUDBManager;

public class CVSDAO_t {
	// 2. 내부에서 만들어서 고정시킴
	private static final CVSDAO_t CDAO = new CVSDAO_t();
	private int allCVSCount; // property
	private int CVSPerPage;

	// 1. 외부에서 객체 못 만들게 private으로 생성자 만듬
	private CVSDAO_t() {
		setAllCVSCount();
		CVSPerPage = 3;
	}

	// 3. 외부에서 2번의 저 CDAO 쓸 수 있게끔
	public static CVSDAO_t getCDAO() {
		return CDAO;
	}

	public int getAllPageCount() {
		return (int) Math.ceil(allCVSCount / (double) CVSPerPage);
	}

	public void setAllCVSCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			String sql = "select count(*) from cvs";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allCVSCount = rs.getInt("count(*)");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			YUDBManager.world(con, pstmt, rs);
		}
	}

	public ArrayList<CVS> getAllCVS(int page) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			int start = (page * CVSPerPage) - 2;
			int end = page * CVSPerPage;
			String count = "slecet count(*) from cvs";

			String sql = "select * from(select rownum as rn, c_no, c_name, c_location, c_addr from(select c_no, c_name, c_location, c_addr from cvs order by c_name, c_location)) where rn >= ? and rn <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			ArrayList<CVS> cvs_al = new ArrayList<>();
			CVS cvs = null;
			while (rs.next()) {
				cvs = new CVS();
				cvs.setNo(rs.getInt("c_no"));
				cvs.setName(rs.getString("c_name"));
				cvs.setLocation(rs.getString("c_location"));
				cvs.setAddr(rs.getString("c_addr"));
				cvs_al.add(cvs);
			}
			return cvs_al;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			YUDBManager.world(con, pstmt, rs);
		}
	}

	public int getserchCVSCount(String searchTxt) {
//		return 검색해서 나온 편의점 수;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);
			String sql = "select count(*) from cvs where c_name like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchTxt);
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt("count(*)");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			YUDBManager.world(con, pstmt, rs);
		}
	}

	public int getsearchPageCount(String searchTxt) {
//		return 검색해서 나온 페이지 수
		return (int) Math.ceil(getserchCVSCount(searchTxt) / (double) CVSPerPage);
	}

	public String reg(CVS cvs) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			String sql = "insert into feb01_cvs values(cvs_seq.nextval, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cvs.getName());
			pstmt.setString(2, cvs.getLocation());
			pstmt.setString(3, cvs.getAddr());

			if (pstmt.executeUpdate() == 1) {
				return "편의점 등록 성공";
			}
			// return null;
			return "insert에서는 이 상황 없지만, 어쨌든 return은 시켜야 되니 만들어두자...";
		} catch (Exception e) {
			e.printStackTrace();
			return "편의점 등록 실패";
		} finally {
			YUDBManager.world(con, pstmt, null);
		}
	}
}
