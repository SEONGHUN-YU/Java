
public class Vitamin {
	String name;
	int price;
	String type;
	int count;

// this.는 생략해도 되지만
// 멤버변수명이랑 지역변수명/파라메터명이 같을 때
// 기본은 지역변수/파라메터로 인식함
// 멤버변수로 인식시키고 싶으면 this.사용

	public void test() {
		String name = "홍길동";
		System.out.println(name);
		System.out.println(this.name);
	}

	// 기본생성자(default constructor)
	public Vitamin() {
		System.out.println("비타민 입고 됨");
	}

	// shift + alt + s -> o 단축키
	// overloading된 생성자 ↓ 근데 밑에처럼은 쓰지말자 선 넘었다...
	public Vitamin(String n, int p, String type, int count) {
		// super(); <- 이게 머지?
		name = n;
		price = p;
		this.type = type;
		this.count = count;
	}

	public void showInfo() {
		System.out.println(name);
		System.out.println(price);
		System.out.println(type);
		System.out.println(count);
	}
}
