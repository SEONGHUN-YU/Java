package com.yu.jan301db.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 카테고리별 평균가
// select s_kind, avg(s_price) from jan30_shop, jan30_restarea where s_r_no = r_no group by s_kind;

public class SelectMain2 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String addr = StudyKey.DBSERVER_ADDRESS;
			con = DriverManager.getConnection(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);
			
			String sql = "select s_kind, avg(s_price) from jan30_shop, jan30_restarea where s_r_no = r_no group by s_kind";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
