package com.yu.jan172uc.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class XMLFormat {
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
			while (what != XmlPullParser.END_DOCUMENT) {
				if (what == XmlPullParser.START_TAG) {

				} else if (what == XmlPullParser.TEXT) {

				} else if (what == XmlPullParser.END_TAG) {

				}
				xpp.next();
				what = xpp.getEventType();
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
