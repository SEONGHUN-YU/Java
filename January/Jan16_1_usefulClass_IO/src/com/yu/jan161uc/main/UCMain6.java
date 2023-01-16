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
public class UCMain6 {
	public static void main(String[] args) {
		// 이름 :
		// 유통기한(YYYYMMDD) :
		// 가격 :
		// 중량 :

		Scanner k = new Scanner(System.in);
		System.out.println("쓰세요 : ");
		String s = k.next();

		BufferedWriter bw = null;
		try {
			FileOutputStream fos = new FileOutputStream("D:\\yu\\음식.csv", true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);
			bw.write(s + ",");
			bw.flush();
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
