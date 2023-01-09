import RockPaper.User;

// Jan09_1_OOP : A가 작업
// Jan09_2_ThisIsJava : B가 작업
// 		A가 작업했던 User.java가 쓰고싶음

// A한테 User.java를 받나????? NO
// 소스가 다 보이는데 -> 고생해서 만들었는데 내 아이디어가...
// 소스는 안 까고, 기능만 쓸 수 있게 해주자

// 이해가 안 됨
// 어떤식으로 실행되는지 모르겠다 => 당연한 거...
// jsp.jar
// spring.jar

// Java로 프로그램만들고/분석해야지
// Java를 만들고 Java를 분석할 거냐?

// B의 입장
// A가 준 user.jar쓰면 되는데
// 소스를 못 보니, 정확한 사용법을 알 턱이 있나 ㅠ ㅠ

// A가 설명서는 만들어줬어야지!

// java 8 api doc 구글링해봐

public class TIJMain {
	public static void main(String[] args) {
		// A가 작업한 user.jar 받아왔음
		System.out.println("뭐 : ");
		User u = new User();
		int uh = u.fire();
		System.out.println(uh);
	}
}

// configure build path -> libraies 누르고 add EXernal JaRs(오른쪽 2번째꺼)