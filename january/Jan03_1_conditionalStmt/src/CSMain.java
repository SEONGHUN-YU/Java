import java.util.Scanner;

// 조건문 : 조건 따져서 실행해야하는 게 있을 때 씀
//		if (조건식) {
//			조건식을 만족했을 때 할 작업
//		} else {
//			조건식을 만족 못했을 때 할 작업
//		}

//		if (조건식A) {
//		
//		} else if (조건식B) {
//			조건식A는 만족X B를 만족O 일 때 할 작업
//		} ...
//		} else {
//			조건식 만족하는 게 하나도 없으면 할 작업
//		}
public class CSMain {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("중간고사 : ");
		int midScore = keyboard.nextInt();

		System.out.println("기말고사 : ");
		int finScore = keyboard.nextInt();

		double avgScore = ((double) midScore + finScore) / 2;
		// 2.0으로 나눠도 double이나 float 같은 느낌을 낼 수 있다.
		System.out.println("-----");
		System.out.printf("평균점수 : %.1f점\n", avgScore);
		// 오늘할 일은 흐름제어

		// 70 ~ 80 : 좀 더 해라! (참고로 70 < avgScore < 80 은 불가능하다) 조건을 2개로 나눠서 써야함
		// 삼항연산자랑 비슷하다 ㅎㅎ

		// else if를 쓸 수 있는 상황이면 써라!
		// 그러나 else if를 맹신하면 오류 나기 쉽다, 동시에 검사가 필요할 때는 if를 여러번 쓰는 게 낫다
		// 검사횟수가 줄어든다
		
		
		
		
		if (avgScore >= 90) {
			System.out.println("수");
		} else if (avgScore >= 80) {
			System.out.println("우");
		} else if (avgScore >= 70) {
			System.out.println("미");
		} else if (avgScore >= 60) {
			System.out.println("양");
		} else {
			System.out.println("가");
		}

//		if (avgScore >= 90) {
//			System.out.println("수");
//		}
//		if (avgScore >= 80 && avgScore < 90) {
//			System.out.println("우");
//		} ... 이 방식이 틀렸는가? -> X, 그러나 소스도 길고 실행횟수도 많아지고 용량도 커지기 때문에 효율적이지 못하다
		

//		if (avgScore >= 80) {
//			System.out.println("잘했다");
//		} else if (avgScore >= 70) {
//			System.out.println("좀 더 해라");
//		} else if (avgScore >= 60) {
//			System.out.println("쫌...");
//		} else {
//			System.out.println("야");
//		}

//		if (avgScore >= 80) {
//			System.out.println("잘했다");
//		} else {
//			if (avgScore >= 70) {
//				System.out.println("좀 더 해라");
//			} else {
//				if (avgScore >= 60) {
//					System.out.println("쫌");
//				} else {
//					System.out.println("야");
//				}
//			}
//		}
		
		
		
		
		
		
		
	} // 메인함수꺼
} // 클래스꺼
