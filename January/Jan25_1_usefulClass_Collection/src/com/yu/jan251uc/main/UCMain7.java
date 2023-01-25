package com.yu.jan251uc.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

// 요일별 지하철 이용객 수(탄 사람 + 내린 사람)
//	월
//	화
//	수
//	...
public class UCMain7 {
	public static void main(String[] args) {

		BufferedReader br = null;
		try {
			// 읽어오기
			FileInputStream fis = new FileInputStream("D:\\yu\\subway.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			HashMap<String, Integer> hm = new HashMap<>();
			hm.put("월", 0);
			hm.put("화", 0);
			hm.put("수", 0);
			hm.put("목", 0);
			hm.put("금", 0);
			hm.put("토", 0);
			hm.put("일", 0);

			String line = null; // 불러온 텍스트 넣을 곳
			String[] line2 = null; // 파싱해서 보관할 칸
			String t = null; // 파싱한 애들 합쳐서 넣을 곳 <- sdf를 이용해서 d에 넣기 위해
			Date d = null; // 날짜정보 넣을 곳 <- sdf2를 이용해서 yoil에 넣기 위해
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("E");
			String yoil = null; // 요일(String 형식) 넣을 곳
			int sum = 0; // 길어서 줄이려고 만든 변수
			while ((line = br.readLine()) != null) {
				line2 = line.split(",");
				t = line2[0] + line2[1] + line2[2];
				d = sdf.parse(t);
				yoil = sdf2.format(d);
				sum = hm.get(yoil) + Integer.parseInt(line2[5]) + Integer.parseInt(line2[6]);
				hm.put(yoil, sum);
			}
			System.out.println(hm.get("월"));
			System.out.println(hm.get("화"));
			System.out.println(hm.get("수"));
			System.out.println(hm.get("목"));
			System.out.println(hm.get("금"));
			System.out.println(hm.get("토"));
			System.out.println(hm.get("일"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close(); // 닫아주기
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
