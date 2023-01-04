import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

// 반복문 제어
// break : 만나는 순간 => 반복문 강제종료
// continue : 강제반복, 이번 턴 종료(continue 밑에 꺼 안 함)

// while문 구조상 조건식 자리에 뭐 쓰기가 불편
// while (조건식) { <- 그래서 개발자들이 여기다 조건 잘 안 씀, 2번씩 같은 걸 써야하는 번거로움도 있고 여러모로 애매함
//
// }

// 반복문 진도 끝!

public class RSMain4 {
	public static void main(String[] args) {
//		for (int i = 1; i < 11; i++) { // <- 반복시작
//			if (i == 3) {
//				// break;
//				continue; // for문 시작으로 강제로 보냄
//			}
//			System.out.println(i);
//		} // <- 반복종료, 아직 안 끝났다면 다시 반복하러 감
//		System.out.println("-----");
		Random r = new Random();
//		int a;
//		while (true) { // <- 무한루프 시킴(실전형 while문) == (true)의 존재 때문에 do-while문이 의미가 없다
//			a = r.nextInt(10);
//			System.out.println(a);
//			if (a == 1) {
//			} else if (a == 7) {
//				break;
//			}
//		}
//		System.out.println("-----");
		Scanner k = new Scanner(System.in);
		String s;
		while (true) {
			System.out.println("뭐 : ");
			s = k.next();
			if (!s.equals("ㅃㅇ")) {
			} else if (s.equals("ㅃㅇ")) {
				break;
			}
		}

		// if대신 switch를 억지로 써봤다
//		String word;
//		a: while (true) {
//			System.out.println("뭐 : ");
//			word = k.next();
//			b: switch (word) {
//			case "ㅃㅇ":
//				break a; // <- 이 break는 switch꺼다 (따라서 while의 루프가 종료되질 않음)
//				  	  ↑ 함수명에(조건문 반복문에) 이름 붙여주고 break 뒤에 붙여주면 순서를 무시하고 깨준다 (Java만의 해결법)
//			default:
//				System.out.println("뭐 : ");
//				word = k.next();
//				// break의 주인을 찾아줘야한다, ex) 이중for문에서 break가 어떤 문장의 break인지를 알아야 한다
//			}
//		}

//		System.out.println("-----");
//		for (int i = 0; i < 3; i++) {
//			for (int j = 0; j < 3; j++) {
//				if (j == 2) {
//					break; // <- 이 break는 j-for문을 깬다
//				}
//				System.out.printf("%d %d\n", i, j);
//			}
//		}
	}
}