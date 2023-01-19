package com.yu.jan181uc.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// XML은 용량도 크고 무식하게 파싱 돼 있다
// JSON이 깔끔하고 가볍다

// 2015 01 01 ~ 2022 12 31
// 파일에 쓰기
// 2015,01,01,100번(하계동~용산구청),명륜3가.성대입구,108,171
// "USE_DT","BUS_ROUTE_NM","BUS_STA_NM","RIDE_PASGR_NUM","ALIGHT_PASGR_NUM"

// 1. 통신확인
// 2. 파싱
// 3. csv형식으로
// 4. bus2015.csv에 쓰기
// 5. 하루 1 1000 / 1001 2000 / (2001,3000)+=1000;/ 
// 6. 20150101 ~ 20221231 완성 (1년치씩 나눠서)

// 최종프로젝트
//		참신한 주제 - x
//		배웠던 기술 진짜로 내가 할 줄 안다 - o

// 직접 구축한 데이터
// 서버급 컴퓨터 여러대로 병렬 전처리
// Python의 numpy, pandas로 분석
// Python의 scikit-learn, tensorflow로 AI예측
// 그 결과를 활용할 수 있는 웹사이트 한 번 만들어보자 <- 가 우리 반의 핵심

// 내일할 거 : 소켓통신 (실시간 통신)
public class UCMain6 {
	public static void main(String[] args) {
		String k = null;
		String q = null;
		String w = null;
		HttpURLConnection huc = null;
		BufferedWriter bw = null;
//		for (int y = 2015; y < 2023; y++) { // YEAR REPEAT 한 번에 가능은 한데 하지말자, 1년치씩 나눠서 하자

		try { // 31일 미만인 애들 잡는 용도
			String y = "2015";

			// 라이팅 영역
			FileOutputStream fos = new FileOutputStream("D:\\yu\\bus" + y + ".csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);

			for (int m = 1; m < 13; m++) { // MONTH REPEAT
				for (int d = 1; d < 32; d++) { // DAY REPEAT
					for (int start = 1; start < 40002; start += 1000) { // 40k REPEAT
						String date = String.format("/%d/%d/%s%02d%02d", start, start + 999, y, m, d); // (/1/5/20151101)

						huc = (HttpURLConnection) new URL("http://openapi.seoul.go.kr:8088/" + StudyKey.SEOUL_API
								+ "/json/CardBusStatisticsServiceNew" + date).openConnection();
						// ↑ 하나로 합친 모양
//						URL u = new URL("http://openapi.seoul.go.kr:8088/" + StudyKey.SEOUL_API
//								+ "/json/CardBusStatisticsServiceNew" + date);
//						huc = (HttpsURLConnection) u.openConnection();

						String data = new BufferedReader(new InputStreamReader(huc.getInputStream(), "utf-8"))
								.readLine();
						// ↑ 하나로 합친 모양
//						InputStream is = huc.getInputStream(); <- 이건 빠진 듯 (없어도 되는 것 같음)
//						InputStreamReader isr = new InputStreamReader(is, "utf-8");
//						BufferedReader br = new BufferedReader(isr);
//						String data = br.readLine();

						// 파싱 영역
//						JSONParser jp = new JSONParser();
//						JSONObject busData = (JSONObject) jp.parse(data); // 전체데이터
						// ↓ 하나로 합친 모양
						JSONObject busData = (JSONObject) new JSONParser().parse(data);
						JSONObject cbssn = (JSONObject) busData.get("CardBusStatisticsServiceNew");
						if (cbssn != null) { // 40k 미만인 애들 잡는 용도
							JSONArray r = (JSONArray) cbssn.get("row");
							JSONObject station = null;
							for (int i = 0; i < r.size(); i++) {
								station = (JSONObject) r.get(i);
								// Object -> String
								// +""를 하던지 (새 String으로 만듬)
								// (String) 변수를 하던지 <- 얘는 좀 잘 안 됨
								// .toString()을 하던지
								k = station.get("USE_DT") + "";
								q = station.get("RIDE_PASGR_NUM").toString();
								w = station.get("ALIGHT_PASGR_NUM").toString();
								bw.write(k.substring(0, 4)); // +""
								bw.write("," + k.substring(4, 6));
								bw.write("," + k.substring(6, 8));
								bw.write("," + ((String) station.get("BUS_ROUTE_NM")).replace(",", ".")); // (String)
								bw.write("," + station.get("BUS_STA_NM").toString().replace(",", ".")); // .toString()
								bw.write("," + q.replace(".0", ""));
								bw.write("," + w.replace(".0", "") + "\r\n");
								bw.flush();
							}
							System.out.println(date); // 확인용
						}
					} // DAY REPEAT
				}
			}
		} // MONTH REPEAT
//	} // YEAR REPEAT
		catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
		try {
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // main
} // class
