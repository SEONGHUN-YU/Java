package com.yu.mar02m.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

// .jar는 컴파일된 상태라서 수정이 불가
// 소스 수정 -> 컴파일 -> 압축 -> 배포

// => .java 수정하지 않게 하면 만사 OK 아닌가?!
// 뭔가가 .java에 있으면 : 수정 불편(컴파일부터 다시해야하고...)
// => 수정이 일어날만 한 거 : .java말고 외부파일에 쓰고, .java에서는 그 내용을 빨대로 불러와서(fis) 쓰도록

// library : 자주 일어날만 한 작업, 정리해놓고 불러다 씀, ex)YUDBManager_v2.0.jar
//			시키는대로 하면 간편하게 처리됨
// framework : library + 자체적인 tool정도 포함된 개념, 요즘은 그다지 구분 안 해서 부르는 듯 하기도
//			library급인데 framework급이라 우기는 게 많다고 함...?

// eGovFramework(전자정부프레임워크) : 정부에서 만든 거(국산) - X
//		framework들이 많은데, 정부측에서 그 중에 괜찮은 framework를 지정한 것

//		전자정부프레임워크 3종세트
//		Java + DB 	: MyBatis
//		.jar 관리		: Maven (라이브러리 관리 자동으로 해주는 시스템)
//		Java객체		: Spring

// Java - JSP - Spring
// Spring : JSP Model 2의 진화형
// Spring을 배우려면 JSP배우고 나서 배워야 한다? No, Java - Spring도 가능
public class MMain2 {
	public static void getPoint() {
		Scanner k = new Scanner(System.in);
		System.out.print("물건금액 : ");
		int purchase = k.nextInt();

		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("D:/yu/pointRate.txt");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);
			String pr = br.readLine();
			double pointRate = Double.parseDouble(pr);
			double point = purchase * pointRate;
			System.out.printf("적립포인트 : %.0f원\r\n", point);
		} catch (Exception e) {
		}
		try {
			br.close();
		} catch (Exception e) {
		}
		System.out.print("종료하려면 아무 글자나 입력하세요 : ");
		k.next();
		k.close();
	}

	public static void main(String[] args) {
		getPoint();
	}
}
