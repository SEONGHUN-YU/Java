// 희귀한 상황

// 상위클래스랑 똑같은 생성자
public class Mouse extends Product {

	public Mouse() {
		super();
	}

	public Mouse(String name, int price, String maker) {
		super(name, price, maker);
	}

}
