
public class Human {
	// 객체 속성을 적는 곳, 멤버 변수
	// member variable, attribute, field

	// 객체 행동
	// method로 표현 <- 진짜 용어 (member function <- 이해하기 쉬우라고 지어낸 단어)

	// 이제야 밝혀진 사실 : Java에는 함수가 없다...;; class안에 들어간 method가 <-(지금까지 function인줄 알았던 것)
	// 있다

	String name;
	int age;

	public void eat() {
		System.out.println("냠");
	}

	public void introduce() {
		// this. <- 생략가능
		System.out.println(this.name);
		System.out.println(age);
	}
}