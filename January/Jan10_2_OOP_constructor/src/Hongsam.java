// 생성자 - constructor
// 객체가 만들어질 때, 해야 할 작업이 있으면 쓰는 거 <- 그 작업을 객체생성과 동시에 해줌
// 생성자는 method 씀, 특이사항 : return이 아예 없음 진짜로 없음 모양이 특이함, 메소드명이 클래스명과 같음
// 생성자 작업을 전혀 하지 않으면 <- 매우 중요, 1번이라도 건들면 오류로 뜬다
// Java가 알아서 컴파일할 때 기본생성자를 만들어준다
// => 생성자 작업을 하면 기본생성자 안 만들어줌 (오버로딩 생성자 포함)


// 멤버변수는 기본값이 있는데 쓰레기 코드처럼 왜 쓸까?;;
// 1. 공통속성이면 -> static을 써
// 2. 기본값으로 하고 싶을 때 <- 이 때?! 쓰고 싶을 거다, 일리는 있는데, 이 때 쓰레기처럼 쓰지말고
// 생성자를 쓰면 해결되니까 생성자를 써라

// 우리 쇼핑몰 홍삼제품 대부분 70000원
// 가끔가다 다른 가격이 있음

public class Hongsam {
	String name; // = "qweasdzxc"; <- 쓰레기 코드
	int price;
	static final String ORIGIN = "국산";
	
	// 생성자 단축키
	// ctrl + space
	// 기본 생성자
	// default constructor
	
	public Hongsam() {
		price = 70000;
		System.out.println("입고 됨");
	}
	
	public void showInfo() {
		System.out.println(name);
		System.out.println(this.price);
		System.out.println(ORIGIN);
	}
}
