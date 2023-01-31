package com.yu.jan301db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 평범한 학원 빅데이터 과정
//		1. DB를 모름 -> SQLite(폰에 내장, 네트워크 기능 X)
//			SQL을 빅데이터에서 어따 쓰냐
//		2. select * from jan30_shop 이러고 있음

// OracleDB
// SQL활용
// SQL응용

// 카테고리별 평균가
// select s_kind, avg(s_price) from jan30_shop, jan30_restarea where s_r_no = r_no group by s_kind;
public class SelectMain2 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			String sql = "select s_kind, avg(s_price) from jan30_shop group by s_kind order by s_kind";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString("s_kind"));
				System.out.println(rs.getDouble("avg(s_price)"));
				System.out.println("-----");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (Exception e) {
		}
		try {
			pstmt.close();
		} catch (Exception e) {
		}
		try {
			con.close();
		} catch (Exception e) {
		}
	}
}
