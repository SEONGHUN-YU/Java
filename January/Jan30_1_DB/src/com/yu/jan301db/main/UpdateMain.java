package com.yu.jan301db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

// 찾을 휴게소 이름 :
// 변경할 주차대수 :

public class UpdateMain {
	public static void main(String[] args) {

		Scanner k = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			
			String addr = StudyKey.DBSERVER_ADDRESS; // 연결
			con = DriverManager.getConnection(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);
			
			System.out.println("찾을 휴게소 이름 : "); // 필요데이터 확보
			String q = k.next();
			System.out.println("변경할 주차대수 : ");
			String w = k.next();
			
			String sql = "update jan30_restarea set r_parking = ? where r_name = ?"; // 미완성 SQL문장
			
			pstmt = con.prepareStatement(sql); // 총괄객체
			
			pstmt.setString(1, w); // ? 채우기
			pstmt.setString(2, q);

			if (pstmt.executeUpdate() >= 1) { // 결과처리
				System.out.println("수정 성공");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
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
