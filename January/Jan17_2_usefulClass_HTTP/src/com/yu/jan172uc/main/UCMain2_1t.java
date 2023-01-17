package com.yu.jan172uc.main;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

// 기상청
//		날씨데이터
//		데이터 제공자
// 쌤한테
//		데이터 받아쓰는 사람

// 서버, 클라이언트 사이에 통일된 형식이 필요할 것

// csv폼으로는 복잡한 게 감당이 X
// => 그래서 있는 것이

// 국제표준 데이터 형식
//		XML : 데이터를 HTML형식으로 표현
//		JSON: 데이터를 JavaScript형식으로 표현

// HTML
//		DOM(Document Object Model)객체
//		<XXX> : 시작태그
//		XXX : 텍스트(글자 그 자체)
//		</XXX> : 종료태그

// 기상청 : XML
// 데이터 parsing
//		쓸데없는 부분을 걷어내고 이쁘게 다듬는 행위
// XML parsing : Java에는 없어, 하지만 누군가가 만들어 놓았을 것 => mvnrepository.com
// kxml 검색 -> 사용자 수 많은 거 최신버전 2.3.0 -> jar 다운로드 

// XML파싱
// 자바에 없는 것
// 다른사람이 만들어준 거 쓰는데
// AParser : 미국
// BParser : 영국
// CParser : 중국 이런식이다 (그냥 예시임 저런 거 존재 안 함, 종류는 매우 많음)

// XML 파일이 보기 어렵게 생겼다면
// New -> other... -> XML File 만들고 -> 콘솔창에서 불러온 데이터를 Source에 복붙해서 정렬
public class UCMain2_1t {
	public static void main(String[] args) {
		// 시간, 기온, 날씨
		// hour, temp, wfKor 뽑아와
		HttpsURLConnection huc = null;
		try {
			URL u = new URL("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1165051000");
			huc = (HttpsURLConnection) u.openConnection();
			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			/*
			 * BufferedReader br = new BufferedReader(isr); String line = null; while ((line
			 * = br.readLine()) != null) { System.out.println(line); }
			 */ // 빨대를 물려줄려면 내가 마시면 안 되니까 없애준다(?) 뭔 소리야
				// 어쨌든 밑에 작업을 위해선 필요없으니 빼야되는 부분들
			// System.out.println(br.readLine()); 데이터가 1줄이면 이렇게도 가능한데 흠...

			XmlPullParserFactory xppf = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = xppf.newPullParser();
			xpp.setInput(isr);
//			xpp.setInput(is, "utf-8"); 둘 중에 아무거나 됨
			int type = xpp.getEventType();
			// ↑ 지금 마신 게 (시작태그, 텍스트, 종료태그) 셋 중에 뭐냐?
			String t = null;
			// ↓ 얼마나 마셔야 되는지 모르기 때문에 while문
			while (type != XmlPullParser.END_DOCUMENT) { // 지금 마신 게 끝이 아니라면(제작자가 조건을 만들어 둠)
				// ↓ 지금 마신 것을 처리(무언가 조건문이 들어갈 수 있는 부분)
				if (type == XmlPullParser.START_TAG) { // 지금 마신 게 시작이라면
					t = xpp.getName();
//					System.out.println(xpp.getName()); //*1 < > 안의 글자 부분들만 가져옴 (title 같은 부분들)
				} else if (type == XmlPullParser.TEXT) {
					if (t.equals("hour")) {
						System.out.println("~" + xpp.getText() + "시 까지"); // *2 텍스트 부분만 가져옴
					} else if (t.equals("temp")) {
						System.out.println(xpp.getText());
					} else if (t.equals("wfKor")) {
						System.out.println(xpp.getText());
						System.out.println("-----");
					}
				} else if (type == XmlPullParser.END_TAG) {
					t = "";
//					System.out.println(xpp.getName()); //*1 \도 빼고 가져옴
				}
				xpp.next(); // 다음 거 마셔라
				type = xpp.getEventType();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		huc.disconnect();
	}
}
