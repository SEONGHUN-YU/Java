
public class Firewall extends Product {
	int port;

	public Firewall() {
	}

	// 멤버변수 port가 추가되었는데
	// 상품쪽에 있던 품명/가격/메이커만 들어가는
	// 생성자가 가지고 싶니? -> 그다지...?

	public Firewall(String name, int price, String maker, int port) {
		// 이 자리에 아무것도 없거나, super();가 있거나 -> Product() 호출
		super(name, price, maker); // -> Product(품명, 가격, 메이커) 호출
		this.port = port;
	}

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(port);
	}
}
