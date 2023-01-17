package com.yu.jan161uc.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

// food.csv를 읽어서
// 품명 : 
// 유통기한 : 
// 가격 : 
// 중량 : 
// g당 가격 : price / weight
// 유통기한 지났는지 확인 .before이나 .after 사용
// -----
// ...
// -----
// 평균가 : ???

// 날짜 비교 아이디어
// 1. 연 -> 월 -> 일 비교 (if문 사용)
// 2. 쌩 숫자로 해서 크기비교, 오늘날짜가 더 크다 => 못 먹어
// 3. Date 객체 사용
public class UCMain7 {
	public static void main(String[] args) {

		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("D:\\yu\\food.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			String line = null;
			String[] line2 = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd(E)");
			Date exp = null;
			int price = 0;
			double weight = 0;
			Date now = new Date();
			int sum = 0;
			int count = 0;
			
			while ((line = br.readLine()) != null) {
				count++;
				line2 = line.split(",");
				System.out.println(line2[0]); // 품명

				exp = sdf.parse(line2[1]);
				System.out.println(sdf2.format(exp)); // 유통기한

				price = Integer.parseInt(line2[2]);
				weight = Double.parseDouble(line2[3]);
				System.out.println(price); // 가격
				sum += price;
				System.out.println(weight); // 중량
				System.out.println(price / weight); // g당 가격
				System.out.println(exp.before(now) ? "먹지마" : "먹어"); // 오늘보다 전이면 지난 거다
				System.out.println("-----");
			}
			System.out.println(sum / (double) count); // 평균가격
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
