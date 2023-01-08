import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

// 컴퓨터 답 뽑아놓고
// 반복시켜가며
// 입력받기
// 판정받기

// 한국어로 설계 - 번역(개발) -> .java로
// .java가 - 번역(compile)-> .class(기계어)로
// .class가 - 실행

public class RSMain6 {

	public static void printScore(int turn) {
		System.out.printf("%d번만에 정답입니다!", turn);
	}

	public static int answer() {
		// 1~ 10000까지 랜덤한 값을 가지는 함수
		System.out.println("뭐 : ");
		Random r = new Random();
		return r.nextInt(10000) + 1;
	}

	public static int write() {
		Scanner k = new Scanner(System.in);
		return k.nextInt();
	}

	public static boolean judge(int a, int w) {
		if (a == w) {
			return true;
		} else if (a > w) {
			System.out.print("Over\n");
		} else {
			System.out.print("Under\n");
		}
		return false;
	}

	public static void main(String[] args) {
		int a = answer();
		int b;
		for (int turn = 1; true; turn++) {
			b = write();
			if (judge(a, b)) {
				printScore(turn);
				break;
			}

// 게임 계속해야 되면? = false 내맘임 바꿔도 됨
// 게임 그만해야 되면? = true

			// boolean cold = true;
//		if (cold){
//			System.out.println("히터 틀어");
//		}else if (!cold) {
//			System.out.println("히터 틀지마");
//		}
//		// == true : 생략하는 게 default, 일반적으로 생략함, 쓰면 초보 티남
//		// == false : !를 활용

//			Random r = new Random();
//			Scanner k = new Scanner(System.in);
//			int gameAnswer = r.nextInt(10000) + 1;
//			int gameWriteNumber;
////			int gameLoop = 0;
//			System.out.println(gameAnswer);
////			while (true) {
////				gameLoop++;
////		 while문을 for문 형태로 (굳이) 바꿔 봄
//				for (int gameLoop = 1; true; gameLoop++) {
//					System.out.println("뭐 : ");
//					gameWriteNumber = k.nextInt();
//					if (gameAnswer > gameWriteNumber) {
//						System.out.print("Over\n");
//					} else if (gameAnswer < gameWriteNumber) {
//						System.out.print("Under\n");
//					} else {
//						System.out.printf("%d번만에 정답입니다!", gameLoop);
//						break;
//					}
//				}
////			}

		}
	}
}
