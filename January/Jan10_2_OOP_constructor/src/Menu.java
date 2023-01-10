// part1 : PP
// part2 : OOP
//		2-1 : OOP기본
//		2-2 : 객체간의 관계
//		2-3 : OOP하는데 Java만 해당되는 것들
// part3 : 내장/외부 클래스 중에
//		빅데이터
//		웹에
//		유용하다 싶은 거 소개

public class Menu {

	String name;
	int price;

	public Menu() {
	}

	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public void showInfo() {
		System.out.println(name);
		System.out.println(price);
	}
}
