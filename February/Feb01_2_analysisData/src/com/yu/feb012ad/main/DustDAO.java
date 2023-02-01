package com.yu.feb012ad.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import seonghun.yu.db.manager.YUDBManager;

public class DustDAO {
	public static ArrayList<LocationCount> getCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);

			String sql = "select r_location, avg(r_fine_dust + r_ultra_fine_dust) from realtime_dust where r_condition != '없음' group by r_location order by avg(r_fine_dust + r_ultra_fine_dust) desc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<LocationCount> alc = new ArrayList<>();
			LocationCount l = null;
			while (rs.next()) {
				l = new LocationCount();
				l.setLocation(rs.getString("r_location"));
				l.setCount(rs.getDouble("avg(r_fine_dust+r_ultra_fine_dust)"));
				alc.add(l);
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
