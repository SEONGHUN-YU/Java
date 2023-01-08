// 변수 : 데이터 저장
// 변수가 하나 있다면 거기엔 데이터가 하나밖에 안 들어간다

// 배열 == 참조형
// 변수 하나에 여러개의 데이터가 가지고 싶지 않나? 그게 배열이다
// 만들 때 사이즈 고정, 변경불가 => 사이즈를 못 바꿈
// 만들 때 사이즈를 모르면 어떡해? => 못 만들어...
// 그래서 배열 써먹기 힘듬, Java에서는 활용도 낮음 => 빅데이터에선 안 쓰일테니 감각만 배우고 가라

public class ArrayMain {
	public static void main(String[] args) {

		// int[] eng = new int[데이터 갯수 == 데이터를 몇개 넣을건지]
		// 옛날 문법 (오리지널), 길고 비효율적
		int[] eng = new int[4]; // 0번부터 센다
		eng[0] = 90;
		eng[1] = 80;
		eng[2] = 70;
		eng[3] = 10;

		// 개선버전
		// String[] name = new String[] { ? , ? ...};
		String[] name = new String[] { "홍길동", "김길동" };

		// 한 번 더 개선한 최신형 문법, 그러나 모든 문법이 다 필요하다 (알고있어야 함) 최신형 문법으로 안 되는 경우가 있음
		// int kor[] 둘다 된다, 쌤의 문체는 밑에 꺼
		int[] kor = { 90, 100, 50 };
		System.out.println(kor.length); // 배열에 총 몇개의 데이터가 들어있는지 세고 싶을 때
		System.out.println(kor); // 주소값 (기계어임)
		System.out.println(kor[0]); // 첫번째 데이터(0번부터 세서)
		System.out.println("-----");

		// 횟수가 명확 : for
		// 조건이 명확 : while, do-while

		// 배열을 차례대로 돌면서 탐색 : for-each => 순서조절불가, i값이 없음 => 따라서 활용도는 별로, 그래도 알아는 두자
		// for (자료형 변수명 : 배열명) {
		//
		// }

		// 배열과 for문은 짝꿍이다
		for (int i = 0; i < kor.length; i++) { // for문을 자동완성 시키면 가장 가까이 있는 배열을 넣어준다
			int t = kor[i];
			System.out.println(t);
		}
		System.out.println("-----"); // 위에 꺼랑 같은 거임, 더욱 함축시켜놓음, for-each문이라고 부름 우리가 평소에 쓰는건 클래식 for문
		// Python에는 클래식 for문이 없고 for-each문만 있음(신형 for문)
		for (int t : kor) {
			System.out.println(t);
		}

	}
}
