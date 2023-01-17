package com.yu.jan172uc.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

// 배운걸로 평생 먹고 살 수 없어
// 강사 : 필드에 있는 사람들과 소통, 현재 시점 필드 알려줌

// 빅데이터 관련 사업
// 분석가
// 엔지니어(분석하는 프로그램 만드는 인간)
// 시스템구축
// 데이터 판매

// JSP/Spring : Java로 HTTP서버 하는 기술
//		쉬운말      => 홈페이지 만들자!
//	다른 거 또 있음 -> 데이터 제공해주는 서버

// 빅데이터 분석만 하자 X
// 빅데이터 분석+AI 서비스를 활용할 수 있는 웹사이트

// 조건문
// 반복문
// 배열
// 그 언어의 특징 :
// 규칙
// 객체
// 남의 작품 잘 활용하기 (남의 꺼 잘 쓰기)
// => HTTP통신까지 할 줄 알면 -> 그 언어 뗏다고 봐도 됨

public class UCMain {
	public static void main(String[] args) {
		// HTTP 통신 최신 방법
		HttpsURLConnection huc = null;
		try {
//			String s = "https://soldesk.com/"; // 받아오고 싶은 서버 주소를 쓴다
			URL u = new URL("https://www.naver.com/");
			// http or https 골라서 써야된다
//			HttpURLConnection huc = u.open...;
			huc = (HttpsURLConnection) u.openConnection();
			// .openConnection은 수동으로 형변환해서 사용하도록 만들어져 있다 <- 중요!
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);

			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
