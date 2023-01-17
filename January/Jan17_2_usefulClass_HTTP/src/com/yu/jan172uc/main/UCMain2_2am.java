package com.yu.jan172uc.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

//배열, 반복문 쓸 때는 3가지를 확인 (아멘's knowledge)
//1. 스텝 : 한 번에 1씩증가하는지 2씩증가하는지
//2. 길이 : 일종의 공식인 경우가 많음
//3. 시작점 설정 : 좌항 i가 0일 때 우항이 원하는 값이 되도록

public class UCMain2_2am {
	public static void main(String[] args) {
		// 시간, 기온, 날씨
		// hour, temp, wfKor 뽑아와
		HttpsURLConnection huc = null;
		try {
			URL u = new URL("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165051000");
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(isr);
			int type = xpp.getEventType();

			String[] tag = { "hour", "temp", "wfKor" };
			boolean checker = false;

			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					// xpp.getName()이 tag 안에 있는것중 하나랑 일치한다면? -> checker을 true로
					for (String t : tag) {
						if (t.equals(xpp.getName())) {
							checker = true;
						}
					}
				} else if (type == XmlPullParser.TEXT) {
					if (checker) {
						System.out.println(xpp.getText());
					}
				} else if (type == XmlPullParser.END_TAG) {
					for (String t : tag) {
						if (t.equals(xpp.getName())) {
							checker = false;
						}
					}
				}
				xpp.next();
				type = xpp.getEventType();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
