package com.yu.jan133eh.calculator;

import java.io.FileReader;

public class Calculator {
	public static void printMok(int x, int y) {
		// 나누기는 위험하다 -> 처리를 해야겠다
		// 이제 뭐가 또 위험할까...?? <- 생각보다 걱정 안 해도 됨 (쓸 거 다 쓰고 빨갛다하면 처리하면 되니까)
		// Java는 위험한 거 예외처리 안 하면 에러
		// 초보자 : 처리 언제해야하나 고민 안 해도 되니 좋음
		// 숙련자 : 별로 처리하기 싫은데 해야함
		// 장점이자 단점
//		FileReader fr = new FileReader("C:/a.txt"); // <- 이건 또 뭐야

		try {
			System.out.println(x / y);
		} catch (Exception e) {
			System.out.println("나누기 0은 없다");
		}
		System.out.println("끝");
	} // <- void였으면 이렇게 써도 그닥 상관없긴한데...

	public static int divide(int x, int y) { // return 해줘야하는 애들일 때가 문제지
		// 정상 : return z; try - finally - return
		// 에러 : return 0; 펑 - catch - finally - return
		try {
			int z = x / y;
			return z;
		} catch (Exception e) {
			System.out.println("나누기 0은 없다");
			return 0;
		} finally {
			System.out.println("끝"); // <- 이럴 때 쓰는 게 finally
		}
	}
//	System.out.println("끝"); <- return 때문에 절대 실행 안 됨

	// divide2를 수행하다가 Arithmetic이 발생하면
	// divide2를 호출한 쪽에서 처리해라 (여기서 안 할거니 저쪽에서 해)
	// => 권한 있는 사람이 처리하도록
	public static int divide2(int x, int y) throws ArithmeticException {
		int z = x / y;
		return z;
	}

// 왠지 이 기능이 다른 프로젝트에서도 쓰일 것 같은 느낌이 드니
// .jar로 Export해볼까? <- 라는 설정

	// Java -> .jar로 들고 다님
	// Python -> 소스로 들고 다님
	// try - Python에 있음
	// throws - Python에 없음

}
