package com.yu.jan301db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertMain {
	public static void main(String[] args) {

		Scanner k = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 일단 연결 ----------
			String addr = StudyKey.DBSERVER_ADDRESS;
			con = DriverManager.getConnection(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			// 데이터 확보 ---------- (SQL DB에서 양식 가져와)
			System.out.print("휴게소이름 : ");
			String n = k.next();
			System.out.print("방향 : ");
			String s = k.next();
			System.out.print("위치 : ");
			String w = k.next();
			System.out.print("주차대수 : ");
			int p = k.nextInt();

			// SQL(미완성) ----------
			// 1) 자바변수 값 들어갈 자리 : ?
			// 2) ;빼고
			String sql = "insert into jan30_restarea values(jan30_restarea_seq.nextval, ?, ?, ?, ?)";

			// DB관련 작업을 다 해주는 매니저 같은(1회용) ----------
			pstmt = con.prepareStatement(sql);
			
			// SQL완성(? 채우기) ----------
			// pstmt.setXXX(물음표번호, 값); <- 특이하게도, 번호를 1번부터 셈
			pstmt.setString(1, n);
			pstmt.setString(2, s);
			pstmt.setString(3, w);
			pstmt.setInt(4, p);
			
			// SQL을 서버로 전송, 원격실행 시키고, 결과받아오기 ---------- 한방 컷
			int row = pstmt.executeUpdate(); // 그냥 이름만 이래생김... Update랑 상관없음
			
			if (row == 1) {
				System.out.println("등록 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {pstmt.close();} catch (Exception e) {}
		try {con.close();} catch (Exception e) {}
		k.close();
		// 열었으면 닫아야하는데 닫는 순서가 매우 중요하다 <- 진심
	}
}
