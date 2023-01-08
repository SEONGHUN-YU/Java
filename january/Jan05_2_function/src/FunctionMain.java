
public class FunctionMain {
	public static void printPD(int a, int b) {
		System.out.println(a + b);
	}

	public static void printPD(int a, int b, int c) {
		System.out.println(a + b + c);
	}

	// 정수를 몇개를 넣든지 그걸 다 곱한거 출력하는 함수
	// 자료형... 변수명 : 갯수 무제한 parameter
	public static void printMD(int... is) { // ...<- 배열 취급

		int multi = 1;
		for (int i : is) {
			multi *= i;
		}
		System.out.println(multi);
	}

	public static void main(String[] args) {
		// 정수 2개를 넣으면 그 합을 출력하는 함수
		// 정수 3개를 넣으면 그 합을 출력하는 함수

		printMD(1, 2, 3, 4, 5);
		printPD(10, 20);
		printPD(1, 2, 3);
	}
}