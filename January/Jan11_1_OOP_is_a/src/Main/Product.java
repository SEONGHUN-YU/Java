package Main;
// 우유 is a 상품 -> 상속관계

// 상속관계가 맺어졌다
// Milk의 상위/super/부모클래스 : Product
// Product의 하위/자식클래스 : Milk

public class Product { // 아무것도 안 써 있으면 extends object가 생략된 거랑 같다
	String name;
	int price;

	public void showInfo() {
		System.out.println(name);
		System.out.println(price);
	}
}
