package com.yu.jan161uc.main;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

// 프로그램이 기준이 됨, 서구식 사고방식(?)
// 장치가 기준 X

// Java는 1글자가 2bytes

// 쌤이 그냥 편하게 부르는 용어 (실제 있는 말은 아님)
// Stream급
// Reader/Writer급
// Buffered급

// OutputStream : 프로그램에서 -> 장치(콘솔창?)쪽으로 출력할 때 (보낼 때) (1byte)
// OutputStreamWriter : 2bytes
// BufferedWriter : 1String(데이터를 한줄씩 줄단위로 처리함)

// InputStream : 장치(콘솔창?)에서 -> 프로그램쪽으로 입력받아올 때 (받아올 때) (1byte)
// InputStreamReader : 2bytes
// BufferedReader : 1String(데이터를 한줄씩 줄단위로 처리함)

// 개조형
// FileReader : 파일에서 읽기 편하라고 개조해둔 것
// PrintStream : 다양한 method를 추가해놓은 것
// ...
public class UCMain {
	public static void main(String[] args) {
		// Win이든 Linux든 JVM이 관리하는 콘솔창
		// 콘솔창에서 -> 프로그램으로 받아오는 빨대였다(is)
		InputStream is = System.in;
		// 1.5때부터 추가된 InputStream 서포터
		Scanner k = new Scanner(is); // <- 사실 이게 원래 모습이다
//		Scanner k = new Scanner(System.in);

		// Win이든 Linux든 JVM이 관리하는 콘솔창
		// syso는 프로그램에서 -> 콘솔창으로 보내는 빨대였다(ps)
		PrintStream ps = System.out;
		ps.println("ㅋ"); // <- 사실 이게 원래 모습이다
//		System.out.println("ㅋ");
	}
}
