package com.yu.jan161uc.main;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 처리하기 성가시고 까다로운 것들
// 날짜/한글

// encoding : 어떠한 데이터를 전기신호로 바꾸는 것
// decoding : 전기신호를 어떠한 데이터로 바꾸는 것

// 분석하겠다고 데이터를 받았는데, 제공처는 C방식
// 분석할 때 A방식 쓰면 => 깨짐

// 파일 : hdd에 논리적으로 존재하는 것
// 모든 데이터는 전기신호(2진수)로 바뀌어서 저장되어야 하는데
// ㅋ -> 101101 같은 느낌으로 저장된다 -> ㅋ
// ㅋ -A라는 방식-> 010000(인코딩) -A라는 복구방식-> ㅋ
// ㅋ -B라는 방식-> 101101		   -B라는 복구방식-> ㅋ
// ㅋ -C라는 방식-> 000010		   -A라는 복구방식-> 뷁(깨짐)
// 인코딩과 디코딩 방식이 서로 다르면 깨진다

public class UCMain4 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("뭐 : ");
		String s = k.next();

		BufferedWriter bw = null;
		try {
			FileOutputStream fos = new FileOutputStream("D:\\yu\\b.txt", true);
			// OutputStream의 개조형(1byte, 일부러 못 읽는애를 써서 깨짐을 방지한다)
			OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");
			bw = new BufferedWriter(osw);
			bw.write(s + "\r\n");
			bw.flush();
//	FileWriter <- OutputStreamWriter의 개조형(2bytes, 용량상 이미 글자를 인식하는 수준)
//	읽기전부터 지멋대로 인식해서 글자가 깨져있을 수 있다는 소리다, 데이터 보호를 위해 위와 같이 하는 게 좋다
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
