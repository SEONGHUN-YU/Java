package com.yu.jan171uc.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

// 서버 : 서비스를 제공하는 컴퓨터
// 클라이언트 : 서비스를 이용하는 컴퓨터

// HTTP서버 : JSP/Spring, flask, node.js, ....
// HTTP클라이언트 : 자바에 없었어서, 지금부터 만들어가야 돼 => 다른 개발자가 만든 거 쓰자
// apache.org - HttpComponents - Download - HttpClient 4.5.14 Binary.zip

// 통신을 해보자
//		Socket : 실시간 통신(카톡 같은 거)
//			↑ 우리 커리큘럼하고는 별로 상관 없는 애

//		HTTP   : 요청-응답(인터넷 같은 거)
//			교육과정 전체를 아우르는 가장 핵심은 HTTP이다

// 밑의 방식처럼 해본 이유
// 1. 그것이 자바다가 하고 싶었다
// 2. 패키지명 섞이는 것도 경험해보라고
// 3. 통일된 시스템이라는 걸 상기시켜주고 싶었다
// 4. HTTP통신이 처음이라서 옛날방식 해봄 (앞으로 배울 내용은 너무 생략 돼 있어서 구조를 알기 어려움)
public class UCMain {
	public static void main(String[] args) {
		DefaultHttpClient dhc = new DefaultHttpClient();
		BufferedReader br = null;
		try {
			// 요청(클라이언트가 하는 것)에는 2가지 방식이 있다
			// POST방식요청 <- 레어한 방식, 다음에 배워~
			// HttpPost hp; <- 잘 안 쓰는 건가? 특이한 건가?

			// GET방식요청 <- 기본방식
			HttpGet hg = new HttpGet("https://soldesk.com/"); // 클라이언트가 요청
			HttpResponse hr = dhc.execute(hg); // 응답이 옴
			HttpEntity he = hr.getEntity(); // 응답내용
			InputStream is = he.getContent();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(isr);

			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			// ex)편지
			// 보낸사람
			// 받는사람
			// 우표
			// 편지봉투
			// 편지지(응답내용) <- 사실 핵심은 이거
		} catch (Exception e) {
			e.printStackTrace();
		}
		dhc.close(); // br로 해도 되는데 dhc로 닫아보았다, 이 때 주의할 점은 객체가 try-catch 바깥에 있어야 한다
		// session : 통신에는 session 이라는 개념이 있는데 시간제한을 둔 것으로, 시간이 지나면 자동으로 끊김
		// HTTP서버쪽에서 끊기도 할거고 신경 좀 덜 써도 되는 부분
	}
}
