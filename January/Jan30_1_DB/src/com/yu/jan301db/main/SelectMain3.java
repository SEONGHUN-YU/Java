package com.yu.jan301db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

// 쌩 SQL -> Java에서 String으로!

// 찾을 휴게소 이름 : 안 <- 안동이 없어서 "나"로...
// ----------
// 안동
// 하행
// 중앙고속
// 100
// ...
public class SelectMain3 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);
			System.out.print("찾을 휴게소 이름 : ");
			String s = k.next();

			
			// ?는 값 쪽 입력에만 쓸 수 있다 (필드명, 테이블명, SQL문법 X)
			String sql = "select r_name, r_toward, r_area, r_parking from jan30_restarea where r_name like '%'||?||'%'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("-----");
				System.out.println(rs.getString("r_name"));
				System.out.println(rs.getString("r_toward"));
				System.out.println(rs.getString("r_area"));
				System.out.println(rs.getString("r_parking"));
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
		k.close();
	}
}
