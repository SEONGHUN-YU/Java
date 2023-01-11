package Main;
// 상속 : inheritance

// 만약 : if
// 출력 : print

// 우유 is a 상품 -> 상속관계

// 상속관계가 맺어졌다
// Milk의 상위/super/부모클래스 : Product
// Product의 하위/자식클래스 : Milk

// 상속 : 하위클래스에 뭔가 추가되는 것을 말한다 (확장)

// @XXX : annotation
// 		XXX에 뭐가 들어가느냐에 따라 다른 기능을 가진다
//		대부분의 쓰임새 : 원래는 따로 작업해야 하는데
//						annotation을 쓰면 자동으로 처리 되게 해준다

public class Milk extends Product {
	// Product에 있는 멤버변수와 메소드들이 상속된다
	String expDate;

// @Override
// 바로 밑에 무조건 override된 method만 있어야 된다
// 아무 상관없는 method가 있으면 error
// 이런 조건들 때문에 -> 소스 가독성이 좋다

	// override 할 때
	// 아예 바꾼다 -> 잘 안 함...
	// 기존에 하던 거에 추가 -> 이게 대부분이겠지 <- (중요)

	@Override
	public void showInfo() {
		super.showInfo(); // 아예 바꾸고 싶으면 지우면 된다, 이걸 지우면 원래 기능 없어짐
		// Product에 있는 showInfo불러서 : 이름/가격 출력
		System.out.println(expDate);
	}

	// super : 상위클래스
	// this : 자기자신

	// Product로 붙어 물려받아온 showInfo에는
	// 이름, 가격 출력만 있다 => 유통기한도 출력하고 싶은데...
	// 물려받아온 showInfo 메소드 기능을 바꾸자 -> 유통기한도 출력하게끔
	// overriding : 물려받아온 method 재정의
	// overloading : method명을 같게 하는 테크닉

}