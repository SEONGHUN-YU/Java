// Procedural Programming
// 절차지향 프로그래밍
// 조건문, 반복문, ... 적재적소에 배치해서 (절차에 맞게)
// 프로그램을 완성시키자

// 컴이 좋아짐 (딱히 아니어도 됨, 적재적소에 배치할 필요가 적어짐)
// 버블소트 - 저질 알고리즘

// Object Oriented Programming
// 객체지향 프로그래밍

// 프로그램 완성은 당연하고
// 유지보수에 용이하게 하자
// => 소스 보기 편하게 하자
// => 자바가 인간의 언어에 가까워진다면 
// => 자바로 현실(리얼월드)를 묘사할 수 있다면

public class OOPMain {
	public static void main(String[] args) {
		String name = "후추";
		System.out.println(name);
		
		int age = 3;
		System.out.println(age);

		// 객체를 만들려면 클래스가 필요, 오잉?
		// 객체 : 리얼월드에 존재하는 그거
		// 리얼월드에 존재하는 개를 표현하고 싶어 => 개 객체가 갖고 싶다
		Dog d = new Dog();
		d.name = "후추";
		d.age = 3;
		d.bark();
		d.showInfo();
	}
}