package com.yu.jan122oop.Me;

// static
//		공통속성 : 객체가 여럿인데 공유하는 것

// 객체가 필요없다 : static method 기반으로 만든다 <- 굳이 객체를 만들지 않도록!
// 객체가 필요해 <- 몇 개?
// 딱 하나 필요하면 : singleton 패턴
// 여러개 : 평소대로 만들어 (캡슐화하면서)

// onlyone 객체가 필요할 때! : singleton 패턴
// 세상에 그런 객체는 하나 뿐이다

public class YU { // singleton 패턴 과정
	private String name;
	private String address;
	// 2. 객체를 내부에서 하나 만들어서 수정도 못하게 만든다(final 때문에 어차피 수정 안 되니 public도 상관없긴 하다)
	private static final YU YU = new YU("유성훈", "서초");

	// 1. 객체를 외부에서 못 만들게 하자 => 생성자에 private을 건다
	private YU() {
	}

	private YU(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	// 객체
	// object, instance

	// 3. 2번의 객체를 외부에서 쓸 수 있게 통로를 만들어준다
	// getInstance()라는 메소드명을 선호하는 파가 있다
	public static YU getInstance() { // final이 있어서 수정이 안 되기 때문에 set은 안 생긴다
		return YU;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
