package com.yu.jan313oop.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import seonghun.yu.db.manager.YUDBManager;

// DAO/DTO 패턴
//		MVC패턴의 일종
//		DAO(Data Access Object) : DB관련 작업하는 M
//		DAO에서 작업, 결과를 DTO로 주고받는다
public class RestareaDAO {

	// 일반적으로는 throws 쓰는 게 맞는데
	// 지금은 throws를 쓰면 닫지도 못하고 실패처리도 못하기 때문에
	// -> try-catch 써야 된다
	public static String reg(Restarea ra) {
		// 제대로 하는 중이라 try-catch를 안 해야 되는데... 일단 찝찝하지만 해보자
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);
			// 정보 파라메터로 다 받음 -> 안 써도 됨

			String sql = "insert into jan30_restarea values(jan30_restarea_seq.nextval, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ra.getName());
			pstmt.setString(2, ra.getToward());
			pstmt.setString(3, ra.getArea());
			pstmt.setInt(4, ra.getParking());

			if (pstmt.executeUpdate() == 1) {
				return "성공";
			} else {
				return "실패"; // 2개 추가 or 0개 추가 같은 것들?
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "실패"; // DB서버쪽 문제로 실패
		} finally {
			YUDBManager.world(con, pstmt, null);
		}
	}
}
