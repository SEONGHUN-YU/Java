package com.yu.feb013jl.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.yu.feb013jl.cvs.CVS;
import com.yu.feb013jl.snack.Snack;

import seonghun.yu.db.manager.YUDBManager;

public class StoreDAO {
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

			String sql = "insert into snack values(snack_seq.nextval, ?, ?, ?, ?)";
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
}
