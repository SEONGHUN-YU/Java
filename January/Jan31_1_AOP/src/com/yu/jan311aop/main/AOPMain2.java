package com.yu.jan311aop.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import seonghun.yu.db.manager.YUDBManager;

// OracleDB랑 연결 -> ojdbc8.jar
// DB랑 연결하기/연결끊기 -> yuDBManager_v1.0.jar

// library
// framework : library + 툴

// 상품명 쓰면 그 상품 삭제되게
public class AOPMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);
			System.out.print("삭제할 상품명 : ");
			String q = k.next();

			String sql = "delete from jan30_shop where s_name = ?"; // '?' 로 하지말 것, 알아서 해줌
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, q);

			if (pstmt.executeUpdate() >= 1) {
				System.out.println("삭제 성공");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		YUDBManager.world(con, pstmt, null);
		k.close();
	}
}