package com.yu.feb013jl.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.yu.feb013jl.cvs.CVS;
import com.yu.feb013jl.cvs.StudyKey;
import com.yu.feb013jl.snack.Snack;

import seonghun.yu.db.manager.YUDBManager;

public class StoreDAO_rough {

	public static String insertCVS(CVS cvs) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			String sql = "insert into cvs values(cvs_seq.nextval, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cvs.getName());
			pstmt.setString(2, cvs.getLocation());
			pstmt.setString(3, cvs.getAddr());

			if (pstmt.executeUpdate() == 1) {
				return "성공";
			} else
				return "실패";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			YUDBManager.world(con, pstmt, null);
		}
	}

	public static String insertSnack(Snack s) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			String sql = "insert into snack values(snack_seq.nextval, ?, ?, to_date(?,'YYYYMMDD'), ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getPrice());
			pstmt.setString(3, s.getExp_pre());
			pstmt.setInt(4, s.getCvsno());

			if (pstmt.executeUpdate() == 1) {
				return "성공";
			} else
				return "실패";
		} catch (Exception e) {
			e.printStackTrace();
			return "실패";
		} finally {
			YUDBManager.world(con, pstmt, null);
		}
	}

	public ArrayList<CVS> getAllCVS() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			String sql = "select * from cvs order by c_name c_location";
			pstmt = con.prepareStatement(sql);
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
		}
	}

	public ArrayList<Snack> getAllSnack() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			String sql = "slecet s_no, s_name, s_price, s_exp from snack order by s_name, s_price";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<Snack> snacks = new ArrayList<>();
			Snack s = null;
			while (rs.next()) {
				s = new Snack();
				s.setNo(rs.getInt("s_no"));
				s.setName(rs.getString("s_name"));
				s.setPrice(rs.getInt("s_price"));
				s.setExp(rs.getDate("s_exp"));
				snacks.add(s);
			}
			return snacks;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
