import java.util.Scanner;

// 연산자 : 모든 연산자들은 stack영역에 저장된다

// 이름이 홍길동만
// 왜? 해결방안말고 무슨 상황이냐고!
// String에 equals 써야한다

// 발표하지마라, 말을 해라!???




// 논리연산자 : 결과로 true/false가 나오는 애들

//	초과	이상
//	>		>=	
//	같다	다르다
//	= =		! =					
//	이하	미만
//	<=		<

// 머신러닝 : 문제를 해결하는데 필요한 알고리즘을 지정해주는 것?

public class OperatorMain4 {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.print("이름 : ");
		String name = keyboard.next();

		System.out.print("키 : ");
		double height = keyboard.nextDouble();

		System.out.print("나이 : ");
		int age = keyboard.nextInt();

		System.out.println("-----");
		System.out.printf("키는 %.0fcm, 나이는 %d\n", height, age);

// 키가 120↑이어야 탑승 가능하다
		boolean child = (height >= 120);
// 변수가 앞쪽에 배치되도록 쓰자, 가독성을 위해 괄호를 써도 좋다
//		boolean child = 120 <= height; <- 이런 스타일로 쓰면 업계에서 싫어한다
		System.out.println(child);
// 나이가 10살 미만이어야 탑승 가능하다

		boolean old = (age < 10);
		System.out.println(old);

		boolean only5 = (age == 5);
		System.out.println(only5);

		boolean odd = (age % 2 == 1);
		System.out.println(odd);

//		boolean onlyHong = (name == "홍길동");
//		System.out.println(onlyHong);

//		String HGD = "홍길동";
		boolean onlyHong = name.equals("홍길동"); //(HGD);
		System.out.println(onlyHong);

	}
}
