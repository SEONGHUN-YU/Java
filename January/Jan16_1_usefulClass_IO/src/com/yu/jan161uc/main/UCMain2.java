package com.yu.jan161uc.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// cpu : 계산하는 애(연산장치)
// ram : 변수형태로 임시저장하는 애
// hdd : 파일형태로 영구저장하는 애

public class UCMain2 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.println("뭐 : ");
		String s = k.next();

		BufferedWriter bw = null; // 변수를 밖으로 빼놔라, 변수는 뭐라도 값을 넣어놔라(b에러가 났을 때를 위해)
		try {
//			int b = 1 / 0;
			FileWriter fw = new FileWriter("D:\\yu/a.txt", true); // true를 쓰면 초기화 안 되고 뒤에 내용이 계속 추가됨
			// ↑ OutputStreamWriter의 개조형 : 파일에 쓰기 편하라고 만들어진 애
			bw = new BufferedWriter(fw); // 큰 빨대 꼽기
			bw.write(s + "\r\n"); // \n만 해놓으면 예전 win 버전에서는 메모장이 깨짐
			bw.flush(); // 빨대 용량 다 안 채워도 강제 전송
//			int a = 1 / 0; <- 이런식으로 사고나면 어떡할건데? close는 밖으로 빼라
			// 빨대들은 다 썼으면 빨리 닫아야, 그 빨대를 다른 프로그램에서 쓸 수 있다
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bw.close();
			// fw 위에 덧씌운 bw 같은 느낌이라서
			// 연관된 거 중에 하나만 닫으면 모두 닫힘 fw를 닫든 bw를 닫든 상관X
		} catch (IOException e) {
			e.printStackTrace();
		}
		k.close();

		// FileWriter 특징
		// 파일 없으면 만들어줌
		// 드라이브/폴더는 안 만들어줌 => 직전 폴더까지 수동으로 다 만들어 놓아야함

		// D:가 없으면? 폴더가 없으면?
		// 지금 로그인한 win 계정이 그 폴더에 대한 권한이 없으면?

		// Win : C:\program Files\...
		// linux : /abc/zxc
		// D:\\ 처럼 \\ 2개를 쓰던지 linux 스타일로 / 1개를 쓰던지 둘 다 가능
	}
}
