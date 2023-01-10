// 변수는 언제 만드나? : 데이터 임시 저장
// 객체는 언제 만드나? : 실생활스럽게 데이터 임시 저장

// 계산기에 뭔가를 저장했나? => No

// 객체가 필요하긴 한지? <- 이걸 항상 따져볼 것
// 멤버변수가 있나? => 객체가 필요하다

// 멤버변수가 없나? => 저장할 게 없다
// -> 굳이 객체를 만들어서 메모리를 쓸 필요가 없다 (낭비)
// -> static method 기반으로 만든다

// 지금 같은 상황에는 static을 넣어서 method를 완성하는 게
// 메모리를 아낄 수 있다

public class Calculator {
	public static void printPlus(int a, int b) {
		System.out.println(a + b);
	}

	public static void printMulti(int a, int b) {
		System.out.println(a * b);
	}
}
