package com.yu.jan135uc.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 날짜/시간
// Java 1.8.xxx 에서는 됨, 1.8.yyy 에서 안 돼도 불평하지말라는 뜻
// 세월이 가면서 -> 세상이 바뀜
// Date객체 : Java초창기에 만들어진
//			  2000년대를 생각하지 않던 시절
// 그 때 만들어진 Date객체가
// 2000년 넘어선 현 시점에 안 맞음
// Java 입장에서는 그걸 업그레이드를 하든지,
// 버리고 신제품 출시하든지
// deprecated : 업그레이드를 하든, 없애고 신제품 출시를 하든 할 거다
//				그런 계획에 있다라는 의미, 유예기간, 사용을 자제해라
//				없어질 수도 있는 기능이라는 뜻

public class UCMain5 {
	public static void main(String[] args) throws ParseException {
		Date now = new Date();
		System.out.println(now);

		// Date -> String 으로 바꿔주는 객체
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM"); // <- 최신식 방법
		String now2 = sdf.format(now);
		System.out.println(now2);

		// 특정 시간날짜 : String -> Date
		try { // 1* 과 같은 이유로 try-catch 씌워줌
			String d = "2000-01-01";
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
			Date d2 = sdf2.parse(d); // 1* Java는 예외처리를 꼭 해줘야함
			System.out.println(d2);
		} catch (Exception e) {
			e.printStackTrace();
		}

//		Date d = new Date(2000, 10, 1);
//		↑ 걍 이런 것도 있다 해, 이거 아마 없어질 거임, 쓰는 거 절대 비추

		// 연도
		// System.out.println(now.getYear()); <- 구식 방법(구림)
		// 항상 get~ 형태로 있을 것, 캡슐화가 걸려있기 때문

		// 월
		// System.out.println(now.getMonth());

		// 일
		// System.out.println(now.getDate());
	}
}
