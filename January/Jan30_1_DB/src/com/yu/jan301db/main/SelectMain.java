package com.yu.jan301db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 데이터 조회

// 전체 상품명, 가격
// 상품 가나다순 -> 가격 싼 순

public class SelectMain {
	public static void main(String[] args) {

		Connection con = null; // 연결
		PreparedStatement pstmt = null; // 총괄객체
		ResultSet rs = null; // select 결과 [List에 가까움]
		try {

			con = DriverManager.getConnection(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			// 데이터 확보 <- 이번엔 필요 없네?

			String sql = "select s_name, s_price from jan30_shop order by s_name, s_price";

			pstmt = con.prepareStatement(sql);

			// ? 채우기 <- 이번엔 필요 없네?

			// CUD : 그 작업 때문에 데이터 몇 개 영향 받았나
			// int row = pstmt.executeUpdate();
			// R : 데이터
			rs = pstmt.executeQuery();

			// rs : size()를 모름
			// rs.next() :
			//		다음 데이터로 감
			//		갔는데 없으면 false
			while (rs.next()) {
				// rs.getXXX("필드명") : 현재위치의 그거
				System.out.println(rs.getString("s_name")); // record 번호 써도 되긴 하는데 객체지향 시대에 굳이 그러진 말자...
				System.out.println(rs.getDouble("s_price"));
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
