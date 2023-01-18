package com.yu.jan181uc.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import seonghun.yu.string.cleaner.StringCleaner;

// Python
// numpy , pandas 쉽게 분석됨
// scikit-learn , tensorflow 쉽게 ai됨

// 용돈주세요 : 얼마? 현금? 언제까지?
// 뉴스주세요 : 무슨주제? 어떤뉴스?

// 인터넷 주소 형식
//		https://						- protocol(통신방식)
//		openapi.naver.com				- 서버주소
//		/v1/search/news.xml				- /폴더/폴더/파일
//		?								- 구분자
//		변수명=값&변수명=값&변수명=값...- request parameter (요청 파라메터) (보안상 별로 안 중요한 값)

// 내부적으로 전달할 때는 : request header (요청 헤더) (보안상 꽤 중요한 값 전달할 때 쓰는 거)

// 인터넷 주소에는 한글 못 넣는다! <- 중요
//**1 명절선물 -> %2A어쩌구 주소(URL인코딩)

// 네이버에서 뉴스검색한 데이터를 파일에 저장
// 1. HTTP 통신 되는지 확인
// 2. 된다면 파싱
// 3. 파일에 적기(이런 비정형데이터는 ,로 나누기 힘드니까 그냥 txt로 저장하는 게 낫다)
// 

public class UCMain3 {
	public static void main(String[] args) {

//		VITQwGJ87taKzIBU1ALt
//		dCQNImVfMu

		HttpsURLConnection huc = null;
		BufferedWriter bw = null;
		try {
			String what = "코로나";
			what = URLEncoder.encode(what, "utf-8"); // **1

			URL u = new URL("https://openapi.naver.com/v1/search/news.xml?query=" + what);
			huc = (HttpsURLConnection) u.openConnection();
			// request header : huc.addRequestProperty(제목, 값);
			huc.addRequestProperty("X-Naver-Client-Id", StudyKey2.NAVER_SECURITY_ID);
			huc.addRequestProperty("X-Naver-Client-Secret", StudyKey3.NAVER_SECURITY_SECRET);
			InputStream is = huc.getInputStream();

//			InputStreamReader isr = new InputStreamReader(is, "utf-8"); <- 확인할 때만 필요한 애들
//			BufferedReader br = new BufferedReader(isr);
//			System.out.println(br.readLine());

			FileOutputStream fos = new FileOutputStream("D:\\yu\\news.txt", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);

			XmlPullParser xpp = XmlPullParserFactory.newInstance().newPullParser();
			xpp.setInput(is, "utf-8");
			int type = xpp.getEventType();
			String t = null;
			boolean data = false; // *1 쌤의 처리법

			while (type != XmlPullParser.END_DOCUMENT) {
				if (type == XmlPullParser.START_TAG) {
					t = xpp.getName();
					if (t.equals("item")) { // *1
						data = true;
					}
				} else if (type == XmlPullParser.TEXT) {
					if (data) { // *1
						if (t.equals("title")) {
							bw.write(StringCleaner.clean(xpp.getText()) + "\t"); // <- 비정형데이터 나누는 꿀팁
						} else if (t.equals("description")) {
							bw.write(StringCleaner.clean(xpp.getText()) + "\r\n");
							bw.flush();
						}
					}
//				} else if (type == XmlPullParser.END_TAG) { // <- 쓸데없는 enter가 없어서 이번 상황에서는
//					t = ""; // 굳이 쓸 필요 없는, 없애도 되는 소스
				}
				xpp.next();
				type = xpp.getEventType();
			}
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
