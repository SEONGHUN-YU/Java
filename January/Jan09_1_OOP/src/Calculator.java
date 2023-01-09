// member variable : 객체의 속성
// 기본값이 있음! 헐? => 숫자계열은 0, 참조형은 null 을 가진다

// method parameter : 그 행동에 필요한 재료
// 기본값이 없음 -> main에서 넣어서 호출할테니 별로 문제는 없다

// local variable : 지역 변수, 그 행동 하는 동안만 임시로 쓰고 버리는 변수
// 지역변수는 Java에서는 기본값이 없음 -> 첫 값 넣고 (초기화하고 <- 멋있는 말) 써야 된다

public class Calculator {
	String modelname;
	int price;

	public void introduce() {
		System.out.println(this.modelname);
		System.out.println(this.price);
	}
	public void printPlus(int a, int b) {
		System.out.println(a+b);
	}
	
	
}