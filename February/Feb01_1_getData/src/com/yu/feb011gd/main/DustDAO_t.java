package com.yu.feb011gd.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import seonghun.yu.db.manager.YUDBManager;

// 날짜
// 도심권
// 중구
// 미세먼지 : ?
// 초미세먼지 : ?
// 좋은지 나쁜지
public class DustDAO_t {
	// public
	// C에서 쓰려고 만드는 중인데
	// protected private 쓰면 C에서 못 쓰니까 public으로!
	// static
	// 멤버변수가 없다 -> 저장할 게 없다
	// 굳이 객체 안 만들어도 된다
	// => 객체 안 만들고 쓸 수 있는 static으로!
	// void
	// 이 method 결과로 나오는 게 없다는 뜻
	// getDust
	// 내 맘
	// method명은 알아서 잘 짓자

	public static void getDust() {
		HttpURLConnection huc = null;
		try {
			URL u = new URL("http://openapi.seoul.go.kr:8088/" + StudyKey.SEOUL_API + "/xml/RealtimeCityAir/1/25/");
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(isr);

			DustDTO d = null;

			int line = xpp.getEventType();
			String t = null;
			while (line != XmlPullParser.END_DOCUMENT) {
				if (line == XmlPullParser.START_TAG) {
					t = xpp.getName();
					if (t.equals("row")) {
						d = new DustDTO();
					}
				} else if (line == XmlPullParser.TEXT) {
					if (t.equals("MSRRGN_NM")) {
						d.setArea(xpp.getText());
					} else if (t.equals("MSRSTE_NM")) {
						d.setLocation(xpp.getText());
					} else if (t.equals("PM10")) {
						d.setFine(Integer.parseInt(xpp.getText()));
					} else if (t.equals("PM25")) {
						d.setUltra(Integer.parseInt(xpp.getText()));
					} else if (t.equals("IDEX_NM")) {
						d.setCondition(xpp.getText());
					}
				} else if (line == XmlPullParser.END_TAG) {
					t = "";
					if (xpp.getName().equals("row")) {
						saveToDB(d); // d를 DB에
					}
				}
				xpp.next();
				line = xpp.getEventType();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}

	public static void saveToDB(DustDTO d) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = YUDBManager.hello(StudyKey.DBSERVER_ADDRESS, StudyKey.SERVER_ID, StudyKey.SERVER_PASSWORD);
			String sql = "insert into realtime_dust values(sysdate, ?, ?, ?, ?, ?)";

			if (d.getCondition() == null) {
				d.setCondition("없음");
			}

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, d.getArea());
			pstmt.setString(2, d.getLocation());
			pstmt.setDouble(3, d.getFine());
			pstmt.setDouble(4, d.getUltra());
			pstmt.setString(5, d.getCondition());

			if (pstmt.executeUpdate() == 1) {
				System.out.println("성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		YUDBManager.world(con, pstmt, null);
	}
}
