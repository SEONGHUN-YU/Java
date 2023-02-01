package com.yu.jan313oop.main3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import seonghun.yu.db.manager.YUDBManager;

// 단단하게/날카롭게 구사하는 MVC패턴
public class ShopDAO {
	public static ArrayList<CategoryCount> getCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			String sql = "select s_kind, count(*) from jan30_shop group by s_kind";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<CategoryCount> alc = new ArrayList<>();
			CategoryCount cc = null;
			while (rs.next()) {
//				alc.add(new CategoryCount(rs.getString("s_kind"), rs.getInt("count(*)"))); // 줄이면 이렇게
				cc = new CategoryCount();
				cc.setCategory(rs.getString("s_kind"));
				cc.setCount(rs.getInt("count(*)"));
				alc.add(cc);
			}
			return alc;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			YUDBManager.world(con, pstmt, rs);
		}
	}
}

//public static ArrayList<Shop> getShop() {
//	Connection con = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	try {
//		con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);
//		
//		String sql = "select s_kind, count(*) from jan30_shop group by s_kind";
//		pstmt = con.prepareStatement(sql);
//		rs = pstmt.executeQuery();
//		
//		ArrayList<Shop> shops = new ArrayList<>();
//		Shop s = null;
//		while (rs.next()) {
//			s = new Shop();
//			s.setKind(rs.getString("s_kind"));
//			shops.add(s);
//		}
//		return shops;
//	} catch (Exception e) {
//		e.printStackTrace();
//		return null;
//	} finally {
//		YUDBManager.world(con, pstmt, rs);
//	}
//}
