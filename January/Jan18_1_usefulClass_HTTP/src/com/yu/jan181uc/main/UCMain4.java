package com.yu.jan181uc.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// XML파싱 : 주로 JavaScript에서 하는 거임

// 어차피 JavaScript에서 쓸 건데
// 왜 HTML모양으로 데이터를 표현한 거야?

// 국제표준포맷
// XML : HTML모양
// JSON : JavaScript모양 <- XML의 후속

// 요즘은 XML말고 JSON이 주력으로 쓰인다
// JSON파싱을 잘 해야된다

// openweathermap.org -> API -> 날씨의 신

// https://api.openweathermap.org/data/2.5/forecast?lat=44.34&lon=10.99&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr

// lat long units lang

// 1. 통신 돼? o
// 2. 파싱 해! <- XML 아니라서 새로운 방법 배워야 돼 (JSON만의 방법이 있는가 봄)
// 3. csv스타일로 바꿔봐
// 4. 파일에 때려넣어
public class UCMain4 {
	public static void main(String[] args) {
		HttpURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			URL u = new URL("https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid="
					+ StudyKey.WEATHEAR_SECURITY + "&units=metric&lang=kr");
			huc = (HttpURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr); // 통신 됐으면 다 빼
			String data = br.readLine();

			FileOutputStream fos = new FileOutputStream("D:\\yu\\weather.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);

			// kxml : 무식한 파싱... 빨대로 하나씩 빨면서 처리하기 때문
			// json-simple : 전체를 받아놓고, 객체지향 스타일로 감

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy,MM,dd,HH,"); // 맨 뒤에 ,도 가능!?
			String date = sdf.format(new Date());
			bw.write(date);

			// JSONObject : {} <- JavaScript에서 객체
			// JSONArray : [] <- JavaScript에서 배열
			JSONParser jp = new JSONParser();
			// jp.parse(isr); // 둘 중에 하나로 쓰면 됨 <- 주의할 거는 Reader급으로
			// jp.parse(data); // 통신 되는지 확인 해본김에 이거 쓰던지

			// {로 시작하니까
			JSONObject jo = (JSONObject) jp.parse(data); // 전체 다 빨아서 jo에 담아놓음
			// System.out.println(jo.get("name")); 처럼 가져올 수 있다

			// [로 시작하면
			// JSONArray ja = (JSONArray) jp.parse(data);

			JSONArray w = (JSONArray) jo.get("weather");
//			System.out.println(jo.get("weather"));
			JSONObject w0 = (JSONObject) w.get(0);
			bw.write(w0.get("description") + ",");
//
			JSONObject m = (JSONObject) jo.get("main");
			bw.write(m.get("temp") + ",");
			bw.write(m.get("humidity") + "\r\n");

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
