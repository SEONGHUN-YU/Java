package com.yu.jan161uc.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 여러 인코딩 방식이 있지만
// 오늘은 utf-8 <- 방식으로 연습해보자

// win   : 경로 대소문자 구별X
// linux : 경로 대소문자 구별O

// 확장자 : MS진영에만 있는 허상 (공식적으로 파일에는 확장자라는 개념이 존재하지 않는다)
//			사람이 그거 보고 뭔지 알기 편하게 하기 위해 만든 것

// .txt : 메모장 파일? 아니다 ↓정확한 건 밑의 개념이다
//		메모장에서 열면 이쁘게 열리는 파일
// .xls : 엑셀파일
//		엑셀에서 열면 잘 열리는 파일
// .ppt : 파워포인트파일
//		마찬가지

// .csv <- 데이터 업계에서 많이 쓰임, 그럴만 하네
//		Comma Separated Value
//		각각의 값들이 ,로 구분된 파일이라는 뜻

// 빅데이터 분석 :
// 쉽다는 이유로 Python 시키는데
// 소규모 분석을 해서 구실만 갖추고 의미 없는데

// 아직 대한민국에는 빅데이터가 없다

public class UCMain6 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		BufferedWriter bw = null;
		try {
			System.out.println("품명 : ");
			String n = k.next();
			System.out.println("유통기한 : ");
			String e = k.next();
			System.out.println("가격 : ");
			String p = k.next();
			System.out.println("중량 : ");
			String w = k.next();

			FileOutputStream fos = new FileOutputStream("D:\\yu\\food.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8"); // euc-kr <- 엑셀에서 안 깨지려면 이거
			bw = new BufferedWriter(osw);

			String data = String.format("%s,%s,%s,%s\r\n", n, e, p, w); // 꿀팁
			bw.write(data);
			bw.flush();
			System.out.println("끝");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		k.close();
	}
}
