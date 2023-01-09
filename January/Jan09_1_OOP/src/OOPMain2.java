// RAM : 재부팅하면 날아감
//		 OS가 논리적으로 3공간으로 나눠서 사용
//		 ??
//		 stack
//			  밑에서부터 차곡차곡 활용
//			  프로그램이 끝나면 자동정리 됨
//			  반대로 말하면!? 프로그램이 안 끝나면 정리를 못한다
// 		 heap
//			  컴이 판단해서 적당한 위치를 찾아서 활용
//			  자동정리 안 됨
//			  개발자가 직접 정리해야 됨

// Garbage collection
// heap영역 자동정리시스템
// Java/Python은 이게 있음 => 메모리 몰라도 된다!? <- 응 아니야;; 알아야지
// 면접관 : 그러면 그 자동이 언제 발동하냐?
// 그 번지에 더 이상 접근이 불가능하게 되면 발동



// 변수
// 기본형 : stack영역에 데이터가 쌓인다
//			커봐야 8byte -> 차곡차곡이 가능(레고 블럭같은 느낌)
// 		    int, double, boolean, ...
// 참조형 : heap영역에 데이터, 변수만 stack에
//			사이즈가 천차만별 -> 차곡차곡이 불가능
//			객체는 참조형


// = 연산자는 stack 영역이 대상이다



// 1. 강사가 뭔 생각으로 쓰는지
// 2. 지웠다가 다시 써봐
// 3. 문제 내보기
public class OOPMain2 {
	public static void main(String[] args) {
		Book b = new Book();
		b.title = "이것이 자바다";
		b.author = "KOSA";
		b.price = 30000;
		b.printInfo();
		System.out.println("-----");

		Book b2 = new Book();
		b2.title = "혼자 공부하는 파이썬";
		b2.author = "홍길동";
		b2.price = 25000;
		b2.printInfo();
		System.out.println("-----");

		// 첫번째 거랑 같은 거 하나 더 - X
		// 첫번째 책을 b3라는 변수로도 접근할 수 있게 한 거임
		Book b3 = b;
		b3.printInfo();
		System.out.println("-----");

		// 세번째 책 가격을 2만원으로
		b3.price = 20000;
		b3.printInfo();
		System.out.println("-----");

		b.printInfo(); // ?!
		
		b = null; // 아무 번지도 안 가리키게
		b3 = null; // 이러면 heap 데이터 번지수 날라감, 수동으로 날려서 메모리 땡겨쓰기 스킬, 빅데이터니까 써야지?!
//		b.printInfo();

		System.out.println(b);
		System.out.println(b2);
		System.out.println(b3);
		
		// 자바는 주소 알아도 접근 못함
		// C는 가능
		
	}
}
