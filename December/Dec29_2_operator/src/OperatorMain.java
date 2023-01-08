//import java.util.Scanner;

// 연산자(operator)
// = : 대입연산자
// 일상에선 = 를 같다라는 뜻으로 쓰지만, 우항에 있는 값을 좌항에 넣는다는 의미이다
// 연산자도 우선순위가 있다, 그 중에 = 는 우선순위가 가장 낮다, 맨 마지막에 발동됨 

public class OperatorMain {
	public static void main(String[] args) {

//		Scanner math = new Scanner(System.in);
//		System.out.print("x : ");
//		int xx = math.nextInt();
//
//		System.out.print("y : ");
//		int yy = math.nextInt();
//
//		System.out.println("-----");
//		System.out.printf("x는 %d, y는 %d\n", xx, yy);
//		System.out.printf("y는 %d", yy);

// + - * / % => 산술연산자, 우선순위도 사칙연산과 완벽히 같다

		int a = 4 + 5;
		int b = 4 - 5;
		int c = 4 * 5;
		int d = 4 / 5;
		int e = 4 % 5; // => 나머지를 구해준다
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println("-----");
		// 숫자라서 숫자인 게 아니고, 숫자로서 의미가 있으면 숫자로 취급한다
		// ex)폰번호 => 숫자로 적혀있긴 하지만 다른 의미를 가진다
		// 겉모양만 보고 숫자라고 생각하면 안 된다

		String s = "5"; // <- 큰 따옴표 안에 있기 때문에 글자취급
// 숫자 + 글자가 가능할까? <- Python은 불가능, Java는 가능
// 무엇이든간에 String과 더하기를 시키면 => 붙여써서 String(글자)로 만들어준다
//		String f = x + s;
//		System.out.println(f);

// Python에서는 x * s가 된다 (어떻게 작용하는지는 안 갈켜주심), Java에서는 불가능

// Java에서는 int와 int를 계산시키면 => 결과값이 int로 나온다
// 한쪽이라도 double이 포함되어 있어야 => 결과값이 double로 나온다
		double x = 10;
		int y = 4;
		double g = x / y;
		System.out.print(g);
		System.out.println("-----");

		int v = 10;
		v = 20;
		System.out.println(v);

// 산술대입연산자(?)도 있다
// += -= *= /= %=
// 1올리기, 1내리기는 카운팅 기호가 있다(?) ++, --
// x++; ++x; 둘다 가능한데 ++x는 쓰면 싫어한다고 한다

		x += 3; // x = x + 3;
		System.out.println(x);
		y -= 2; // y = y - 2;
		System.out.println(y);
		System.out.println("-----");

		x++; // x += 1; // x = x + 1;
		System.out.println(x);

		int h = 3 << 1;
		System.out.println(h);

// << 같은 기호도 있다 <- shift 연산자라고 부른다, 
// 목록에서 다중선택할 때 필요한 기호임! 밑에 예시 있음		

// 계산방식은 (몰라도 된다..)
// 1) 3을 2진수로 바꾼다 => 11
// 2) 11을 왼쪽으로 1번 밀고
// 3) 빈 자리에 0을 채운다 => 110이 된다
// 4) 110을 10진수로 바꾼다 => 6이 된다

// 왼쪽 = 1, 가운데 = 2, 오른쪽 = 3
// 글자.정렬 = 왼쪽;
// 글자.정렬 = 가운데;
// 글자.정렬 = 3;
// 글자.속성
// 이탤릭 = 1 << 0 = 1
// 굵게 = 1 << 1 = 2
// 밑줄 = 1 << 2 = 4
// 글자.속성 = 이+굵 = 3; 응용하면 5; 6; 7;도 된다, 아무것도 넣지 않으면 0

	}
}
