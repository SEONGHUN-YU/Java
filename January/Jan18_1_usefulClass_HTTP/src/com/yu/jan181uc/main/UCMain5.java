package com.yu.jan181uc.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

// JSON : 데이터를 표현하는데
//			JavaScript 모양을 활용해서 표현하는 것뿐, JavaScript는 결코 아니다
// JSON != JavaScript
// JavaScript
//		{name : "홍", age : 5}
// JSON
//		{"name" : "홍", "age" : "5"}
public class UCMain5 {
	public static void main(String[] args) {
//		HttpURLConnection 요즘 사실 누가 이거 써... 거진 https이다

		HttpsURLConnection huc = null;
		try {
			Scanner k = new Scanner(System.in);
			System.out.println("써 : ");
			String search = URLEncoder.encode(k.next(), "utf-8");
			k.close();
			String condition = "?x=127.0266709&y=37.5053693&radius=2000&query=";

			URL u = new URL("https://dapi.kakao.com/v2/local/search/keyword.json" + condition + search);
			huc = (HttpsURLConnection) u.openConnection();
			huc.addRequestProperty("Authorization", "KakaoAK " + StudyKey.KAKAO_API); // request 양식 맞췄으면 빨대꼽아
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();

			JSONParser jp = new JSONParser();
			JSONObject kakaoData = (JSONObject) jp.parse(data); // 전체 데이터
			JSONArray locs = (JSONArray) kakaoData.get("documents"); // documents 안쪽 데이터들 전체 (지금의 경우 배열로 돼 있음)

//			 와 이거 개어렵네
			JSONObject loc = null;
			for (int i = 0; i < locs.size(); i++) {
				loc = (JSONObject) locs.get(i);
				System.out.println(loc.get("place_name"));
				System.out.println(loc.get("road_address_name"));
				System.out.println(loc.get("phone"));
				System.out.println(loc.get("distance"));
			}

//			String a = null;
//			for (Object in : locs) {
//
//				a = ((JSONObject) in).get("distance")+"";
//				System.out.println(a);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
