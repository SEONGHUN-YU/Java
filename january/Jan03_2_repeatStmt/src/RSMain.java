import java.util.Iterator;

// 조건문
// 반복문 <- 가장 수학스럽다
// 배열
// 그 언어만의 특징

// 반복문

// 123번 반복 <- 반복 횟수가 명확한 상황 => for문

//		for (변수생성; 조건식; 증감) {
//			내용
//		}

// 내일 아침까지 반복 <- 반복 조건이 명확한 상황

public class RSMain {
	public static void main(String[] args) {
//		for (int i = 0; i < 5; i++) {
//			System.out.println("yeah");
//		}
//		System.out.println("-----");
//		for (int i = 1; i <= 5; i++) {
//			System.out.println(i);
//		}
//		System.out.println("-----");
////		 1 3 5 7 9
//		for (int i = 1; i < 10; i+=2) {
//			System.out.println(i);
//		}
//		System.out.println("-----");
////		 -3 -2 -1 0 1 2 3
//		for (int i = -3; i < 4; i++) {
//			System.out.println(i);
//		}
//		System.out.println("-----");
////		 5 4 3 2 1
//		for (int i = 5; i > 0; i--) {
//			System.out.println(i);
//		}
//		System.out.println("-----");
////		 1 짝 3 짝 5 짝 7 짝 9 짝
		for (byte i = 1; i < 11 ; i++) {

	System.out.println((i % 2 == 0 ? "짝" : i));
			
//			if (i % 2 == 0) {
//				System.out.println("짝");
//			} else {
//				System.out.println(i);
//			}
		}

	}
}