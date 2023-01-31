package com.yu.jan313oop.main2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import seonghun.yu.db.manager.YUDBManager;

public class ShopDAO {
	public static ArrayList<Shop> getShop() {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			String sql = "select s_name, s_price from jan30_shop order by s_name, s_price";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<Shop> shops = new ArrayList<>();
			Shop s = null;
			while (rs.next()) {
				s = new Shop();
				s.setName(rs.getString("s_name"));
				s.setPrice(rs.getInt("s_price"));
				shops.add(s);
			}
			return shops;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			YUDBManager.world(con, pstmt, null);
		}
	}
}
