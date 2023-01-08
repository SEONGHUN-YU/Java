// 메인함수영역 밖에 쓰는 건 그냥 안 됨... 문법상 안 됨

import java.util.Scanner;

public class OperatorMain {
	// 이 곳 사이에다가는 써도 되긴 하는데 자동실행이 안 되는 곳임
	// 수동실행 해야하는 영역임, 안 배워서 쓰면 안 됨
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		System.out.printf("나이 : ");
		int age = keyboard.nextInt();

		System.out.printf("키 : ");
		double height = keyboard.nextDouble();

		System.out.println("-----");
		System.out.printf("%d살, %.1fcm\n", age, height);
		// 자동으로 실행 되는 메인함수 영역

		// 키가 150이상이어야 탈 수 있음
		boolean over150 = (height >= 150);
		System.out.println(over150);

		// 정보처리기사
		// 1. AND
		// 2. OR
		// 3. NOT
		// 4. XOR <- 이거 나오면 정답? ㅋㅋ

		// 논리결합연산자
		// ~고(and) -> &&(중간스킵), &(무식하게 끝까지 적용, 빅데이터에서 필요할 때가 있음)
		// ~거나(or) -> ||(중간스킵), | (무식하게 끝까지 적용, 빅데이터에서 필요할 때가 있음)

		// && 쓸 때는 확률 낮은 조건식(희귀한)을 앞으로 배치하는 게 바람직함
		// || 쓸 때는 확률 높은 조건식(일반적인)을 앞으로 배치하는 게 바람직함

		// XOR = XO->O, OX->O, 둘 중에 하나만 만족해야 성공 (eXclusive OR - 배타적 OR)
		// XOR -> ^ 로 쓴다

		// not(반대,여집합 같은 느낌?) -> ! 로 쓴다

//		키가 100이상이고, 나이가 80살이상이어야 탈 수 있음
//		boolean over100and80 = (height >= 100) && (age >= 80);
//		System.out.println(over100and80); ↓
		boolean overA = (age >= 80) && (height >= 100);
		System.err.println(overA);
		// 앞뒤를 바꿔주면 작업량을 줄일 수 있다

		// 나이가 80이상이거나, 키가 100이상이어야 탈 수 있음
//		boolean over80and100 = (age >= 80) || (height >=100);
//		System.out.println(over80and100); ↓
		boolean overB = (height >= 100) || (age >= 80);
		System.out.println(overB);
		// 마찬가지로 앞뒤를 바꿔주면 작업량을 줄일 수 있다

		// 나이가 20이상이든지, 키가 100이상이든지
		// 둘중에 하나만 만족했을 때 탈 수 있음
		boolean overC = (age >= 20) ^ (height >= 100);
		System.out.println(overC);

		// overC를 못타는 사람만 탈 수 있음
		boolean overD = !overC;
		System.out.println(overD);

		// 10 < 나이 < 20만 탈 수 있음, &&를 쓸 거면 희귀한 조건을 앞으로
		boolean X = (age < 20) && (age > 10);
		System.out.println(X);

		// 키가 120 넘고, 150 넘으면 탈 수 있음, 이상함을 눈치채고 이의제기를 했어야 함 ㅋㅋ...
		boolean Y = (height > 150);
		System.out.println(Y);

		/////////////////////////////////////////////////////////////////////////////////////
		// 연산자
		// 단항연산자 : !a
		// 이항연산자 : a+b, a>b, a=10, 대부분의 연산자는 좌항과 우항으로 이루어져 항이 2개이다
		// 삼항연산자 : a?b:c
		// -> 뭔가 조건을 따져서 값을 줄 때 씀
		// a자리에 조건식을 하나 쓰고, 조건식이(a) ? 참일 때 써먹을 값(b) : 거짓일 때 써먹을 값(c)
		/////////////////////////////////////////////////////////////////////////////////////
		////// 나이가 20살 이상이면 "안녕하세요" 20살 미만이면 "나가"
		// python은 효율을 따지는 언어는 아니어서... 삼항연산자가 없다

		String say = (age >= 20) ? "안녕하세요" : "나가";
		System.out.println(say);

// 한국어로 설계 -번역(개발자)-> 자바로 바꿔주는 사람
// 직역...은 아쉽다

// 코딩테스트 썰
// 데이터를 날짜별로 정렬해달라 했다함?! (날짜순으로 아니고?)
// 저런 건 의사소통의 문제가 된다 (이상함을 눈치채고 이의를 제기한 사람을 거른 것이었던 듯)

	}
	// 이 곳 사이에다가는 써도 되긴 하는데 자동실행이 안 되는 곳임
	// 수동실행 해야하는 영역임, 안 배워서 쓰면 안 됨
}
