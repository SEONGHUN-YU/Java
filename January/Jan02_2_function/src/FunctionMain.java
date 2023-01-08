// 함수(function)
// 관련있는 작업들을 묶어놓고 필요할 때마다 그 묶음을 사용함
// => 함수는 소스 정리차원에서 쓰인다
// 알고리즘의 시대 -> 유지보수의 시대

// 함수명 짓는 조건 == 변수명 짓는 조건
// 변수명 : 명사
// 함수명 : 동사

// 같은 공간 내에서 이름은 달라야 한다 -> 맞는말
// => 이것 때문에 나오는 결과가 한 class 내에서 함수명이 달라야 한다
// 

public class FunctionMain {

	// 1. 함수 정의 (이쪽 공간에다가 만든다)(서브함수 영역)
	// parameter, 인자 = () <- 요거! 함수에 넣어주는 자리
	// main에 있는 데이터를 -> 함수로 보낼 때 parameter를 쓴다
	// return type = ↓ => 결과물이 뭔지 쓰는 자리
	// public static 자료형 함수명(자료형 변수명, 자료형 변수명, ...) {
	// ...
	// return 값;
	// }

	// 상품관리를 한다고 치면 함수명을
	// abc순서로 소스 정렬
	// 동사를 앞으로 보내면 ***??
	// 동사를 뒤로 보내면 주제별로 묶을 수 있다, 다만 적절하지 않다

	public static void yaDambae() {
		System.out.println("야 어머니한테 만원 받아서");
		System.out.println("동네 슈퍼가서");
		System.out.println("한라산 한 갑 달라고 하고");
		System.out.println("너 과자 하나 사먹고");
		System.out.println("한라산 가져와");

	}

	// 정수를 하나 넣으면 그게 출력되는 함수
	public static void printNumber(int n) {
		System.out.println(n); // n값은 메인에서 함수호출할 때 값을 넣는다
		System.out.println("-----");

	}

	// 정수를 2개 넣으면 그 합을 출력하는 함수
	public static void printHab(int q, int w) {
		int e = q + w;
		System.out.println(e);

	}

	// 정수를 3개 넣으면 그 합을 출력하는 함수
	public static void printHab(int q, int w, int e) {
		int r = q + w + e; // 더해서 r에 저장 <- 이것은 변수이다
		System.out.println(r); // r에 있는 것을 출력
//		System.out.println(q + w + e); 이 정도 데이터양이라면 변수없이 쓰는 게 저장공간을 덜 먹는다(절약)

		// 여기는 전혀 다른 공간이라서 변수명을 q w e로 사용해도 전혀 상관없다
		// 변수라는 것은 공간이 정해져 있는 것이기 때문
		// 함수 overloading => parameter 부분이 다르다면(정의가 다르다면) 함수명이 같아도 된다!
		// -> (갯수가 다르다던지, 자료형이 다르다던지) 한다면 함수명이 같아도 된다
		// 함수 호출할 때 구별이 가능하기 때문에 상관없다
		// 비슷한 기능일 때 일부러 함수명을 같게 짓는 테크닉 : 함수 overloading
		// overloading이 되는 언어가 있고 안 되는 언어가 있다, Python은 불가능하다, Java는 가능하다
	}

	// 정수를 하나 넣으면 홀/짝 출력하는 함수
	public static void printEvenOdd(int n) {
		String number = (n % 2 == 1) ? "짝" : "홀";
		System.out.println(number);
	}

	// 정수를 2개 넣으면 평균값을 구해주는 함수
	public static double getAvg(int q, int w) {
		double e = (q + w) / 2.0;
		// 여기있는 "e"는 메인에서 쓸 수 없다
		return e;
		// return을 쓰면 결과를 호출한(메인)쪽으로 돌려주고 함수를 끝낸다
		// return 자체가 함수의 끝이라서 그 밑으로 무엇을 적어도 소용이 없다
	}

	// 정수를 1개 넣으면 *1000한 값을 구해주는 함수
	// == 초단위를 넣으면 밀리초단위로 바꿔주는 함수
	public static int convertMillisec(int sec) {
		return sec * 1000;
	}

	// 정수 2개 넣으면 더 큰 수 구해주는 함수
	public static int getBigNumber(int a, int b) {
		return a > b ? a : b;
	}

	// 정수를 1개 넣으면 1 + 2 + 3 + ...그 숫자 = ? 구하기 <- 고급 테크닉
	// getHab(1) = 1
	// getHab(2) = getHab(1) + 2
	// getHab(3) = getHab(2) + 3
	// ...
	// getHab(12) = getHab(11) + 12
	public static int getHab(int a) {
		return (a == 1) ? 1 : getHab(a - 1) + a;

	}

	// 정수를 1개 넣으면 팩토리얼을 구하는 함수 <- 함수 재귀적호출 == 함수를 recursive하게 쓴다
	// 함수속에서 자기자신을 불러서 반복이 생기게 하는 테크닉
	// 1! == 1
	// 2! == 1*2 == 1!*2
	// 3! == 1*2*3 == 2!*3
	public static int getFactorial(int a) {
		return (a == 1) ? 1 : getFactorial(a - 1) * a;

	}

	// 정수 하나 넣으면 그 위치의 피보나치수열값 구하는 함수
	public static int getFibonacci(int a) {
		return (a <= 2) ? 1 : getFibonacci(a - 2) + getFibonacci(a - 1); // My solve
//		return (a < 3) ? 1 : (getFibonacci(a - 2) + getFibonacci(a - 1)); Teacher's solve

	}

	////////////////////////////////////////////////////////////////////
	// 에러나는 경우는 괄호 중괄호 확인
	// 지금은 줄 맞추는 거 연습해!

	// main함수 공간↓ : 자동실행
	public static void main(String[] args) throws InterruptedException {
		// 2. 함수호출, 메인에서 수동으로 위에 써놓은 함수를 호출해야한다
		// -> 함수명(); 또는 함수명(값); 또는 함수명(값, 값, ...)으로 호출
		// 함수 호출 : Jump연산을 하는 것 -> 시간이 걸린다

// 회사 : 내 실력을 드러내려고 복잡한 알고리즘을 쓰는 곳이 아니다
// 가장 간결하게 해치우는 게 최고다
// 반복문을 쓰는 게 현실적이다

		// 옛날 자바에는 println(String s)만 있었다
		// String s = a+""; 같은 방식으로 썼었다
		int a = 10;
		// 이 "a"는 이 공간 안에서만 유효하다

//		yaDambae();
//		printNumber(10);
//		printHab(6, 2);
//		printEvenOdd(2);
//		double d = getAvg(10, 20);
//		System.out.println(d);
//		int b = getBigNumber(5, 3);
//		int s = convertMillisec(b);
//		System.out.println(s);
//		Thread.sleep(s);
//		int hab = getHab(10);
//		System.out.println(hab);
//		int fact = getFactorial(4);
//		System.out.println(fact);
		int fibo = getFibonacci(47);
		System.out.println(fibo);

		// ctrl + shift + numpad * /, ctrl + - => 접었다 펴기
	}
}
