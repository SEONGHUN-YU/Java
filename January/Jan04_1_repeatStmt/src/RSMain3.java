
// 백준, 프로그래머스 < , hackerrank, leetcode, codeup
import java.util.Random;
import java.util.Scanner;

// 반복문
// 반복횟수가 명확 -> for
// 반복조건이 명확 -> while (조건에 바로 맞는다면거나 조건이 이상하다면 반복이 안 될 수도 있음)
//							 => 조건자체를 1번 실행하게 한다면 do-while 별로 의미 없는데?
//					  do-while (최소 1번은 반복을 보장) <- 그래서 사실 잘 안 쓰임, 그래서 python에도 없음

// while은 검사부터! 하고 나서 조건이 만약 잘못됐다면 실행을 안 할 수도 있음
//do-while은 일단 실행부터 하고, 그 다음 while을 실행, 즉 짝수가 먼저 나와도 while로 넘어간다
// do-while문은 최소 1번은 반복을 보장한다!

//		while (조건식) { <- 반복을 종료시킬 조건을 쓰는 게 아니고, 반복을 해야될 상황을 조건으로 써야 함 => 계속 해야할 조건
//			조건 맞으면 실행, 다시 조건식쪽으로 15:12
//		}

public class RSMain3 {
	public static void main(String[] args) {
		// 1 + 2 + ... + 50 = ?
//		int a = 0;
//		for (int i = 1; i < 51; i++) {
//			a += i;
//		}
//		System.out.println(a);
//		System.out.println("-----");

		// 랜덤뽑을준비, 계속 뽑고 싶음
		Random r = new Random(); // <- 필드마법 같은 느낌
//		int b = r.nextInt(10); // 0 ~ 9 사이의 랜덤한 정수 (0부터시작, 10일 경우 10의 직전까지)
//		System.out.println(b);

		// 5번 쯤 하자 말고, 몇번이든 7이 나올 때까지 하자 -> 이 때는 while
//		while (b != 7) {
//			b = r.nextInt(10); // <- while문의 구조상 어쩔 수 없이 썼던 거 또 써야함
//			System.out.println(b);
//		}
//		System.out.println("-----");

		// 10번 받자 -> for
		// ㅃㅇ라고 입력할 때까지 -> while
		Scanner k = new Scanner(System.in); // <- 필드마법 같은 느낌
//		System.out.println("뭐 : ");
//		String s = k.next();
//
//		while (!s.equals("ㅃㅇ")) {
//			System.out.println("뭐 : "); // <- while문의 구조상 어쩔 수 없이 썼던 거 또 써야함
//			s = k.next();
//		}
//		System.out.println("-----");

		// 1 ~ 100 사이의 랜덤한 정수 계속 출력되게, 단 짝수 나올 시 종료
		int c = r.nextInt(100) + 1; // 그냥 (101)은 0 ~ 100으로 나온다
		System.out.println(c);

		do { // <- while 과는 먼저 실행하고나서 검사를 하느냐, 검사를 먼저하고 실행하느냐 차이
			c = r.nextInt(100) + 1;
			System.out.println(c);
		} while (c % 2 == 1);

//		while (c % 2 == 1) { // <- 계속할 조건을 적어야 함, c % 2 == 0은 실행을 계속할 조건이 아니라 실행을 끊을 조건임
//			c = r.nextInt(100) + 1;
//			System.out.println(c);
//		}
	}
}
