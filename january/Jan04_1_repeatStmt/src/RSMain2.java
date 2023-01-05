import java.util.Iterator;

public class RSMain2 {
	public static void main(String[] args) {
//		for (int dan = 2; dan < 10; dan++) {
//			for (int i = 1; i < 10; i++) {
//				System.out.printf("%d x %d = %d\n", dan, i, (dan * i));
//			}
//		}
//		System.out.println("-----");
//		for (int i = 1; i < 10; i++) {
//			for (int dan = 2; dan < 10; dan++) {
//				System.out.printf("%d x %d = %d\t", dan, i, (dan * i));
////				if (dan % 9 == 0) { <- (내 처음 풀이)
////					System.out.printf("%d x %d = %d\n", dan, i, (dan * i));}
//				} 
//			System.out.println(); // <- (효율적인 풀이)
//			}
		// 변수를 1회용으로 쓸꺼면 그냥 만들지 마라
		// 반복문 속에서 변수 만들지마라
//		System.out.println("-----");
//
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				System.out.print("ㅋ");
//			}
//			System.out.println();
//		}
		// 선언(자료형을 앞에 붙이는 것)
//					 숫자를 받아서 넣는다
//					 받았는데 또 다시 정의하면 안 된다(자바는 불가능!)		

//					// 1\n2\n3\n4\n5
//					for (int i = 1; i < 6; i++) {
//						for (int j = 1; j < 6; j++) { // j <= i 로도 가능
//							if (i >= j) {
//								System.out.printf("*", i, j);
//							}
//						}
//						System.out.println();
//					}

//					// 5\n4\n3\n2\n1
//					for (int i = 1; i < 6; i++) {
//						for (int j = 1; j < 6; j++) { // j < (6 - i) 로도 가능
//							if (i <= j) {
//								System.out.printf("*", i, j);
//							}
//						}
//						System.out.println();
//					}

		// 11 22 33 44 55
//		for (int i = 1; i < 6; i++) {
//			for (int j = 1; j < 6; j++) { // j < (6 - i) 로도 가능
//				System.out.printf(i == j ? "*" : " ");
////							if (i == j) {
////								System.out.print("*");
////							}else {
////								System.out.printf(" ");
////							}
//			}
//			System.out.println();
//		}
		
		// 11 22 33 44 55
//		for (int i = 1; i < 6; i++) {
//			for (int j = 1; j < i; j++) { 
//				System.out.printf(" ");
//			}
//			System.out.println("*");
//		}
		
		// 짝수자리만 ㅎ 나머진ㅋ
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.printf(j % 2 == 1 ? "ㅎ" : "ㅋ");
//			}
//			System.out.println();
//		}
		// 1 3 5 7 9, 3 5번째는 ㅎ
		
		String s;
		for (int i = 0; i < 5; i++) {
			s = i % 2 == 0 ? "ㅋ" : "ㅎ"; // 검사, 최적화, 검사횟수 줄어듬
			for (int j = 0; j <= (i * 2); j++) {
				System.out.println(s);	// 출력
//				System.out.print(i % 2 == 0 ? "ㅋ" : "ㅎ"); <- 최적화 전 단계
			}
			System.out.println();
		}

	}
}