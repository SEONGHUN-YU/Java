// Python/Java 하는 사람들 : 메모리 관리 몰라도 됨 <- 면접 때 갈구는 부분
// Python은 기본형 자료가 없고 참조형 자료만 쓴다

// RAM을 OS가 논리적인 3공간으로 나눠서 씀
// 재부팅하면 삭제됨~

// 나눠쓰는 영역의 종류↓

// ???
//

// stack
// 아래쪽에서부터 차곡차곡 쌓여가는 특징이 있다, 프로그램이 끝나면 반환되는 특성이 있다

// heap
// 컴이 보고 적당한 위치에 저장하는 특징이 있다, 개발자가 직접 반환해주어야 하는 특성이 있다

// Garbage Collection를 지원하는 언어가 있고 안 하는 언어가 있다, Python/Java는 둘 다 지원한다
// ↑Heap영역 자동 정리 시스템 => 알아서 반환시켜준다

// 스마트폰 메모리정리어플 => heap영역 반환해주는 어플
// 컴 잘 안 되면 재부팅해라 => 근거있는 행동임

// CPU : 연산장치 -> 이게 좋으면 작업속도가 빠름 계산이 빠름
// RAM : 변수형태로 임시저장장치(?) -> 좋으면 많이 저장 가능
// SSD/HDD : 파일형태로 영구저장장치 -> 좋으면 많이 저장 가능 
// GPU : 그래픽처리용 (CPU+RAM+HDD) 

// 변수(variable)란? 데이터를 담는 그릇(?)
// 데이터를 임시로 저장해야할 때 쓰는 게 변수이다 이건 내가 판단함

// 문법
// 자료형(그릇의 종류 같은 느낌) 변수명(그릇의 이름 같은 느낌)
// DataType

// 자료형의 종류↓

// 기본형 (소문자 시작, 색깔 바뀜) - 데이터가 stack 영역에 저장된다
// 정수 : byte short [int]<-그냥 이거 써 long 그릇 크기, 소<=>대
// 실수 : float [double]<- Java에서는 그냥 이거 써, 소<=>다
// 글자 : char 1글자
// 논리 : boolean
// Java 배우다 보면 자료형을 무조건 써야하는데
// 딱히 필요는 없는데 무조건 칸 채우기용으로라도 써야할 때가 온다
// 자리만 차지 : void

// 참조형 (대문자 시작, 색깔 안 바뀜)
// -> 용량이 천차만별이다, 영상(1GB) / 소리(30MB) 등등 데이터가 heap 영역에 저장된다
// String(여러 글자지만 1글자도 가능함)

// 변수명 : 마음대로 지으렴 다만 몇 가지 규칙은 있다!! 안 지키면 에러 남
// 변수명을 숫자로 시작...X ex) a1(O), 1a(X)
// 변수명을 자바 문법을 쓰는 건...X
// 변수명을 특수문자로 하는 건...X (_,$는 사용가능)

// 업계의 문화
// 한글을 비롯한 다른 언어 모두...X
// class명은 대문자로 시작
// 변수명은 꼭 !!!! 소문자로 시작!!! 제일 중요

// programmer : 설계 + 코딩 둘 다 되는 사람
// coder : 설계해주면 만드는 사람

// 프로그래밍 언어
// 기본자료형 : 아무런 처리 안 하고 값만 떡하니 있을 때 뭘로 인식해?
// Java에서는!
// => 12 : 정수 = int로 취급한다
// => 123.1212 : 소수 = double로 취급한다

public class VariableMain {
	public static void main(String[] args) {
// 사람 키가 180인데 그 정보를 임시로 저장해야 하는 상황
// => 그럼 변수를 만들자(변수 선언) => 이 판단을 잘 하는게 실력과 직결된다

// 변수명 예시
//		int human_age;   뱀체
		int humanAge; // 낙타체 라고 부른다
//		int _int; 나이 지긋하신 분들이 _시작을 자주 쓴다고 한다

		humanAge = 18; // 이 값을 수정하면 이게 들어간 건 다 수정된다
// 변수에 값 저장 => 변수명 = 값;
// 연산자 : = 기호를 대입연산자 라고 부른다
// 이 바닥에서는 A = B가 같다는 뜻이 아니고
// 우항에 있는 거를 좌항에 넣는다는 뜻이다

		System.out.println("humanAge");
		System.out.println(humanAge);

// 사람 시력이 2.0인데 그 정보를 임시로 저장해야 하는 상황
// 나눠 쓸 필요없이 한 번에 써도 된다

		double humanEye = 2.0;
		System.out.println(humanEye);
		System.out.println(humanEye);
		System.out.println(humanEye);

// 형변환 (type casting) : 자료형을 바꾸는 행위
// (바꿀 자료형) 값 ex) => (float) 2.0; double에서 float로 바뀜
		float eye2 = 2.0f; // float로 취급해줄 수 있게 뒤에 f붙여주든지
		float eye3 = (float) 2.0;
		System.out.println(eye2);
		System.out.println(eye3);

		// 1글자
		char c = '예';
		// 사람 이름 홍길동
		String name = "홍길동";
		// = 를 String name= 처럼 붙여놔도 에러는 나지 않지만 가독성이 떨어진다 띄는 걸 추천

		System.out.println(c);
		System.out.println(name);

		// 지금 추워? 응, 아니,에 해당하는 논리 자료형
		boolean cold = true; // flase
		System.out.println(cold);

	}
}
