// PP -> OOP
// 객체를 써서 실생황을 묘사하자
// -> 유지보수에 용이

// Python
// hybrid한 OOL
// 자유의 언어

// Java
// perfect한 OOL
// 규칙의 언어 (문화/규칙 -> 융통성이 너무 없다)

public class OOPMain {
	public static void main(String[] args) {
		// 리얼월드에 있는 사람 표현
		// 실생활에 존재하는 것 : 객체
		// 사람 객체를 만들자
		// class : 객체를 만들 때 필요한 것
		Human h = new Human();
		h.name = "홍길동";
		h.age = 20;
		h.eat();
		h.introduce();
		System.out.println("-----");

		// 사람
		// 김길동
		// 30
		// 정보출력
		Human k = new Human();
		k.name = "김길동";
		k.age = 30;
		k.introduce();
		System.out.println("-----");
		
		
		
		// 계산기
		// 모델명이 카시오2134
		// 가격이 34500
		// 계산기 정보 출력
		// 20, 30의 합 출력
		Calculator c = new Calculator();
		c.modelname = "카시오2134";
		c.price = 34500;
		c.introduce();
		c.printPlus(20, 30);
		
	}

}
