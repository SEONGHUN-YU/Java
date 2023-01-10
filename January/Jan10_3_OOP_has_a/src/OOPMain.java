// 2-1 : OOP기본
// 2-2 : 객체간의 관계
// A 사람 has a B 개
// A is a B

// C언어는 객체지향언어가 아니라서 글자 표현도 힘들고 불편하다
public class OOPMain {
	public static void main(String[] args) {
		// 이름이 후추 나이가 3살인 개
		Dog d = new Dog("후추", 3);
		d.showInfo();
		System.out.println("-----");
		// 이름이 홍길동 집이 수원인 사람
		Human h = new Human("홍길동", "수원");
		h.showInfo();
		System.out.println("-----");

		Human h2 = new Human("김길동", "안양", d);
		h2.showInfo();
		System.out.println("-----");
		// 회사명이 삼성, 직원수 100, 사장이 김길동인 회사

		Company c = new Company("삼성", 100, h2);
		c.showInfo();
		System.out.println("-----");
		// 플립3, 공짜, 저 회사에서 만든 폰

		SmartPhone s = new SmartPhone("플립3", 0, c);
		s.showInfo();
		System.out.println("-----");

		// s라는 폰 모델명
		System.out.println(s.modelname);
		System.out.println("-----");

		// s만든 회사 이름
		System.out.println(s.maker.name);
		System.out.println("-----");

		// s만든 회사 전체정보
		s.maker.showInfo();
		System.out.println("-----");

		// s만든 회사 사장님 집
		System.out.println(s.maker.ceo.location);
		System.out.println("-----");

		// s만든 회사 사장님 전체정보
		s.maker.ceo.showInfo();
		System.out.println("-----");

		// s만든 회사 사장님 개 이름
		System.out.println(s.maker.ceo.pet.name);
		System.out.println("-----");

		// s만든 회사 사장님 개 전체정보
		s.maker.ceo.pet.showInfo();
		System.out.println("-----");

	}
}
