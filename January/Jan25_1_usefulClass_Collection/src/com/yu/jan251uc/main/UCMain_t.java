package com.yu.jan251uc.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;

import javax.net.ssl.HttpsURLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.yu.jan251uc.weather.WeatherInfo;

// 기상청XML파싱 파일 불러오기 -> ArrayList<날씨>로 만들고 -> 제일 추울 때 정보, 제일 따뜻할 때 정보

// 제일 추운 날 : 오늘 몇시 맑음 -10.0도
public class UCMain_t {
	public static void main(String[] args) {

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
			String t = null;

			WeatherInfo w = null;
			ArrayList<WeatherInfo> wis = new ArrayList<>();

			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					t = xpp.getName();
					if (t.equals("data")) {
						w = new WeatherInfo();
					}
				} else if (type == XmlPullParser.TEXT) {
					if (w != null) {
						if (t.equals("hour")) {
							w.setHour(xpp.getText());
						} else if (t.equals("temp")) {
							w.setTemp(Double.parseDouble(xpp.getText()));
						} else if (t.equals("wfKor")) {
							w.setWfKor(xpp.getText());
						} else if (t.equals("day")) {
							w.setDate(xpp.getText());
						}
					}
				} else if (type == XmlPullParser.END_TAG) {
					t = "";
					if (xpp.getName().equals("data")) {
						wis.add(w);
					}
				}
				xpp.next();
				type = xpp.getEventType();
			}
			wis.sort(new Comparator<WeatherInfo>() {
				@Override
				public int compare(WeatherInfo o1, WeatherInfo o2) {
					Double o1Temp = o1.getTemp();
					Double o2Temp = o2.getTemp();
					return o1Temp.compareTo(o2Temp);
				}
			});
			wis.get(0).printInfo();
			wis.get(wis.size() - 1).printInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
