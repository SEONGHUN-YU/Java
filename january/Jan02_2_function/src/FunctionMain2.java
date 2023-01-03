import java.util.Scanner;

// recursive로 반복적으로 함수를 호출하면 느림 => 계산용X
// => 즉, 원하는 값 나올 때까지 시켜야 할 때! <- 이 경우가 가장 사용하기 적합하다
// 지금 이 상황은 입력받는 상황 -> 프로그램이 멈춰 있음, 속도 따질 상황이 아님 애초에 느린 상황
// => 이런 상황에서 사용하는 것이 recursive의 올바른 사용법이다
public class FunctionMain2 {

	public static int getOdd() {
		Scanner key = new Scanner(System.in);
		System.out.print("홀수 : ");
		int odd = key.nextInt();
		return (odd % 2 == 1) ? odd : getOdd();
		// 변수를 1회용으로 쓸 거면 변수를 없애는 방식으로 식을 세우는 연습을 하는 게 좋다
		// odd는 2번 이상 사용되고 있기 때문에 없애면 안 된다
	}

	public static void main(String[] args) {
		int odd = getOdd();
		// 메인은 짧게!
	}
}
