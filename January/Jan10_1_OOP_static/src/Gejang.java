// 근데 세상의 모든 게장은 김수미가 생산?? <- 그렇다고 하자...

// static 멤버변수
// 객체들의 공통된 속성일 때 쓰는 거
// 메모리의 static 영역에 하나만 만들어지고, 객체들이 공유 => 다 같이 쓰는 이미지
// => 메모리 절약
// 실제로 객체가 없어도 쓸 수 있는 거
// class명.변수명으로 사용한다

// static final 멤버변수
// 값을 바꾸지 못하게 한다
// 상수화 시킨다
// final 붙일꺼면 변수명 다 대문자로 써야됨 (불문율!!!)

// static method
// 메모리 절약 - X
// 메소드는 원래 메모리 공간 먹는 게 아님
// 객체 없이도 사용 가능 <- static method는 이거 하나 보고 쓰는 거다;
// class.메소드명()으로 사용한다
// static이 아닌 거 못 씀
// 사실 static method 잘 안 씀... 이제부터 보기 힘들 수도

// 메소드 : 객체의 행동

public class Gejang {
	String name;
	int weight;
	int price;
//	String producer; // = "김수미"; <- 쓰레기 코드, 이런식으로 하지마라, 귀찮아도 그냥 일일히 해야 돼
	static String producer = "김수미"; // <- 이건 잘한 거임
//	static final String PRODUCER = "김수미";

	public static void test() {
//		System.out.println(name); <- 불가능
		System.out.println(producer); // <- 가능, static 이니까
		System.out.println("테스트");
	}

	public void showInfo() {
		System.out.println(this.name);
		System.out.println(this.weight);
		System.out.println(this.price);
		System.out.println(producer);
	}
}
