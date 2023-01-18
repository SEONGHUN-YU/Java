package com.yu.jan181uc.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.management.modelmbean.XMLParseException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

// XML파싱 : 주로 JavaScript에서 하는 거임

// 어차피 JavaScript에서 쓸 건데
// 왜 HTML모양으로 데이터를 표현한 거야?

// 국제표준포맷
// XML : HTML모양
// JSON : JavaScript모양 <- XML의 후속

// openweathermap.org -> API -> 날씨의 신

// https://api.openweathermap.org/data/2.5/forecast?lat=44.34&lon=10.99&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr

// lat long units lang

// 1. 통신 돼? o
// 2. 파싱 해! <- XML 아니라서 새로운 방법 배워야 돼 (JSON만의 방법이 있는가 봄)

public class UCMain4 {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		try {
			URL u = new URL("https://api.openweathermap.org/data/2.5/forecast?lat=44.34&lon=10.99&appid="
					+ StudyKey.WEATHEAR_SECURITY + "&units=metric&lang=kr");
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
//			InputStreamReader isr = new InputStreamReader(is, "utf-8");
//			BufferedReader br = new BufferedReader(isr); // 통신 됐으면 다 빼
//			System.out.println(br.readLine());

			XmlPullParser xpp = XmlPullParserFactory.newInstance().newPullParser();
			xpp.setInput(is, "utf-8");
			int type = xpp.getEventType();

		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
