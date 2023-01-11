package Main;
// 노트북 is a 상품
// 노트북 is a 컴퓨터

public class Notebook extends Computer { // 다단상속
	double weight;
	int battery;

	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(weight);
		System.out.println(battery);
	}
}
