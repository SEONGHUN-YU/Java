package com.yu.jan135uc.main;

import java.util.StringTokenizer;

// String : 수정이 안 되는 문자열 객체
public class UCMain2 {
	public static void main(String[] args) {
//		String s = new String("ㅋㅋㅋ"); <- 밑에꺼랑 사실은 같다
		String s = "ㅋㅋㅋ";

		// s 뒤에 "ㅎㅎㅎ"
		s = new String(s + "ㅎㅎㅎ"); // <- 밑에 꺼랑 같은 거, 이 방법도 쓰지마
//		s += "ㅎㅎㅎ"; <- 이 방법 쓰지마, 빅데이터에서 안 좋음, heap에 데이터를 계속 새로 만듬 
//		s = s.concat("ㅇㅇ"); <- 이 방법도 쓰지마
//		System.out.println(s + "ㅎㅎㅎ"); StringBuffer를 모를 때 내가 했던 방법
		System.out.println("-----");

		// 문자열을 대량으로 붙일 거라면
		// StringBuffer : 수정 가능한 문자열 객체
		StringBuffer sb = new StringBuffer("ㅋㅋㅋ");
		sb.append("ㅎㅎㅎ");
		sb.append(123);
		sb.append("ㅇㅇ");
		String s2 = sb.toString();
		System.out.println(s2);
		System.out.println("-----");

		// 분석할 데이터 받아오면 String 1덩어리일텐데
		// 문자열 분리
		String s3 = "아 근데 회식 예약은 됐나요";

		// 정형데이터에 유리한 => 유리하지만 무조건 이걸 쓰라는 뜻은 절대 아님, 상황봐서
		String[] s4 = s3.split(" "); // 띄어쓰기 기준으로 분리시킨다는 뜻
		System.out.println(s4[2]);
		System.out.println(s4[4]);
		System.out.println("-----");

		// 비정형데이터에 유리한 => 마찬가지임
		StringTokenizer st = new StringTokenizer(s3, " "); // s3를 띄어쓰기 기준으로 분리
		System.out.println(st.nextToken());
		while (st.hasMoreTokens()) { // 아직도 남았니? 남은 거 전부 반복, 맨 처음부터 반복도 가능
			System.out.println(st.nextToken());
		}
		System.out.println("-----");

		// 정형 데이터 : 형태가 틀에 맞게 딱딱 정해져 있는 데이터
		// ex) 15.1 179.0 38.0 127.7 평범

		// 비정형 데이터 : 정해진 규칙이 없는 데이터
		// ex) 소설책, 이메일, 웹페이지, (큰 범주에서 음성, 영상도 포함)
	}
}
