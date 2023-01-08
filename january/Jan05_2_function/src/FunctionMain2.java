// 2년있다가 이직할꺼지
// 어떤일을 시키면 안되냐

// Java/Python 배우는 사람들 => 메모리 몰라도 된다고 생각함; 기본이 안 된 거야

// call by value (a) => 값으로 부름
// 함수속에서 건드려도 원본에 타격 안 감
// 원본에 어떻게 하려면 return을 잘 써야

// call by reference (b, c) => 참조값으로 부름
// 함수속에서 건들면 원본에 영향이 감
// return 안 써도 영향을 줌

// 함수란 건 공간이 정해져 있다
// 변수란 건 그 공간에서만 쓸 수 있는 데이터이다 int double String 등등
public class FunctionMain2 {
	public static void test(int a, int[] b, int[] c) {
		System.out.println(a);
		System.out.println(b[0]);
		System.out.println(c[0]);
		System.out.println("-----");
		a = 100;
		b[0] = 100;
		c = new int[] { 100, 200 }; // 배열값 새롭게 줄 때 쓰는 문법, 얘는 새로운 주소값을 가진다, 이 공간에서 밖에 못 씀
		System.out.println(a);
		System.out.println(b[0]);
		System.out.println(c[0]);
	}

	public static void main(String[] args) {
		int a = 10;
		int[] b = { 10, 20 };
		int[] c = { 10, 20 };
		System.out.println(a);
		System.out.println(b[0]);
		System.out.println(c[0]);
		System.out.println("-----");
		test(a, b, c);
		System.out.println("-----");
		System.out.println(a);
		System.out.println(b[0]);
		System.out.println(c[0]);
	}
}
