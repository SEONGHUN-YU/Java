// 쇼핑몰 앱
//		찜 기능?
//		입고되면 알림

// 객체 만들기
// 클래스명 변수명 = new 클래스명 - X
// 클래스명 변수명 = new 생성자 - ?

public class OOPMain {
	public static void main(String[] args) {
//		Math.PI = 213; <- 못 바꾼다
//		System.out.println(Math.PI);
//		Hongsam.ORIGIN = "중국"; <- final이 붙어서 이건 불가능
//		System.out.println(Hongsam.ORIGIN);

		Hongsam h = new Hongsam(); // <-
		System.out.println();
		h.name = "홍삼환 스페셜세트";
//		h.price = 100000;
		h.showInfo();
		// 홍삼
		// 품명 : 홍삼환 스페셜세트
		// 가격 : 100000
		// 인삼원산지 : 국산
		// 국산만 취급, 절대로 외국산으로 바꾸는 거 없음
		// 정보출력
		System.out.println("-----");

		// 객체를 왜 만들어? : 정보 저장하려고!
		NewYearGift k = new NewYearGift();
		k.showInfo();
		System.out.println("-----");

		// 객체 만들면서 값까지 넣자 <- 그럼 이게 자주 쓰이겠네!
		Vitamin v2 = new Vitamin("센트룸111", 30000, "알약", 200);
		v2.showInfo();
		System.out.println("-----");

		Restaurant r = new Restaurant("코스모", 10, "논현동");
		r.print();
		System.out.println("-----");

		// 이름이 양꼬치, 가격이 9000원하는 메뉴
		// 정보출력
		Menu m = new Menu("양꼬치", 9000);
		m.showInfo();

	}
}
