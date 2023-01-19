package com.yu.jan172uc.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

// 자기 데이터를 남한테 공개 => DDoS에 취약
// 로그인 -> 사용신청 -> 키 값을 줌

// data.go.kr
// data.seoul.go.kr
// data.gg.go.kr
// 포털사이트의 개발자센터
//		dev.naver.com
//		dev.kakao.com
// SNS 개발자센터
//		dev.twitter.com

// 도심권
// 중구
// 미세먼지 : ?
// 초미세먼지 : ?
// 좋은지 나쁜지
// -----

// 1.HTTP통신 먼저(이 때는 bufr까지)

// 자기 에러 안 보임
// 남의 에러 잘 보임
public class UCMain3 {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		try {
			URL u = new URL("http://openapi.seoul.go.kr:8088/"+StudyKey.SEOUL_API+"/xml/RealtimeCityAir/1/25/");
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(isr);

			int what = xpp.getEventType(); // <xxx> or xxx or </xxx>
			String t = null;
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {
					t = xpp.getName();
				} else if (what == XmlPullParser.TEXT) {
					if (t.equals("MSRRGN_NM")) {
						System.out.println(xpp.getText());
					} else if (t.equals("MSRSTE_NM")) {
						System.out.println(xpp.getText());
					} else if (t.equals("PM10")) {
						System.out.println(xpp.getText());
					} else if (t.equals("PM25")) {
						System.out.println(xpp.getText());
					} else if (t.equals("IDEX_NM")) {
						System.out.println(xpp.getText());
					}
				} else if (what == XmlPullParser.END_TAG) {
					if (xpp.getName().equals("row")) {
						System.out.println("-----");
					}
					t = "";
				}
				xpp.next();
				what = xpp.getEventType();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
