package Main2;

// final 멤버변수
// 수정 불가능한 공통속성으로 만듬(상수화)

// final 메소드
// 오버라이딩 못하게 만듬

// final 클래스
// 상속 불가능한 클래스로 만듬
public class Menu {
	String menu;
	int price;
	static final String COOKED = "김셰프";

	public void printInfo() {
		System.out.println(this.menu);
		System.out.println(this.price);
	}
}
