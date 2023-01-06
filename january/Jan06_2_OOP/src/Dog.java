
public class Dog {
	// 속성을 표현함
	String name;
	int age;
	
	// 행동을 표현함
	public void bark() {
		System.out.println("멍");
	}
	
	// 프로그램 상 필요한 기능
	public void showInfo() {
		System.out.println(name);
		System.out.println(age);
	}
}