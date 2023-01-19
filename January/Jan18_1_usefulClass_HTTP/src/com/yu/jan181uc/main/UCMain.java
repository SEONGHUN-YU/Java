package com.yu.jan181uc.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

// 실시간 미세먼지 조회 프로그램 -> csv파일에 쓰자

public class UCMain {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			URL u = new URL("http://openapi.seoul.go.kr:8088/" + StudyKey.SEOUL_API + "/xml/RealtimeCityAir/1/25/");
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(isr);

			FileOutputStream fos = new FileOutputStream("D:\\yu\\dust.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);

			int what = xpp.getEventType(); // <xxx> or xxx or </xxx>
			String t = null;
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd,HH");
			String when = sdf.format(now);

			while (what != XmlPullParser.END_DOCUMENT) { // 18.10:18
				if (what == XmlPullParser.START_TAG) {
					t = xpp.getName();
				} else if (what == XmlPullParser.TEXT) {
					if (t.equals("MSRRGN_NM")) {
						bw.write(when);
						bw.write("," + xpp.getText());
					} else if (t.equals("MSRSTE_NM")) {
						bw.write("," + xpp.getText());
					} else if (t.equals("PM10")) {
						bw.write("," + xpp.getText());
					} else if (t.equals("PM25")) {
						bw.write("," + xpp.getText());
					} else if (t.equals("IDEX_NM")) {
						bw.write("," + xpp.getText());
					}
				} else if (what == XmlPullParser.END_TAG) {
					t = "";
					if (xpp.getName().equals("row")) {
						bw.write("\r\n");
						bw.flush();
					}
				}
				xpp.next();
				what = xpp.getEventType();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
		try {
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
