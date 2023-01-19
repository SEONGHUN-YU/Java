package com.yu.jan181uc.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

// 1. HTTP 통신 되는지 확인 <- bufr이랑 syso 이용
// 2. 되면 파싱하기
// 3. csv 형태로 바꾸기
// 4. fos osw bw로 csv 파일 만들어서 Writer로 적기
// 5. 하루치 저장하기
// 6. 한달치 저장하기 (20151101 ~ 20151130)
// 7. 2015년초부터 2022년말까지는?
public class UCMain2 {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;

		try {
			FileOutputStream fos = new FileOutputStream("D:\\yu\\subway.csv");
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw); // 열었다 닫았다를 최소화 시키기 위해 반복문 바깥으로

			for (int y = 2015; y < 2023; y++) {
				for (int m = 1; m < 13; m++) {
					for (int i = 1; i < 31; i++) {
						String when = String.format("%d%02d%02d", y, m, i); // %d를 범위에 따라 적절히 사용해야 한다

						URL u = new URL(
								"http://openapi.seoul.go.kr:8088/"+StudyKey.SEOUL_API+"/xml/CardSubwayStatsNew/1/650/"
										+ when);
						huc = (HttpURLConnection) u.openConnection();
						InputStream is = huc.getInputStream();
//				InputStreamReader isr = new InputStreamReader(is, "utf-8"); <- 왜 없지? 아! 그런 거였구나
						// bufr랑 syso로 통신확인 후, 밑에 작업

//				XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
//				XmlPullParser xpp = xppf.newPullParser();
						XmlPullParser xpp = XmlPullParserFactory.newInstance().newPullParser(); // 한 줄로
						xpp.setInput(is, "utf-8"); // 여기서 isr로 안 할거면 isr 굳이 필요없음

						int type = xpp.getEventType();
						String t = null;

						// 글자 자르는 방법
						// 1. split
						// 2. StringTokenizer
						// 3. Date로 변환후 SimpleDateFormat
						// 4. substring
						while (type != XmlPullParser.END_DOCUMENT) {
							if (type == XmlPullParser.START_TAG) {
								t = xpp.getName();
							} else if (type == XmlPullParser.TEXT) {
								if (t.equals("USE_DT")) {
									bw.write(xpp.getText().substring(0, 4));
									bw.write("," + xpp.getText().substring(4, 6));
									bw.write("," + xpp.getText().substring(6, 8));
								} else if (t.equals("LINE_NUM")) {
									bw.write("," + xpp.getText());
								} else if (t.equals("SUB_STA_NM")) {
									bw.write("," + xpp.getText().replace(",", ".")); // csv 형태니까 comma 예외를 배제
								} else if (t.equals("RIDE_PASGR_NUM")) {
									bw.write("," + xpp.getText());
								} else if (t.equals("ALIGHT_PASGR_NUM")) {
									bw.write("," + xpp.getText() + "\r\n");
									bw.flush();
								}
							} else if (type == XmlPullParser.END_TAG) {
								t = "";
							}
							xpp.next();
							type = xpp.getEventType();
						}
						System.out.println(when);
					}
				} // 3중for문꺼 괄호
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
