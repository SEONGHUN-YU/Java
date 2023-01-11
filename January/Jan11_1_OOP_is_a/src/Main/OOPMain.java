package Main;
// 2-2 : 객체간의 관계
//		사람 has a 개
//		Taxi is a Car

public class OOPMain {
	public static void main(String[] args) {
		// 상품(생성자 빼고)
		// 품명
		// 가격
		// 정보출력
		Milk m = new Milk();
		m.name = "서울우유500";
		m.price = 1000;
		m.expDate = "내일";
		m.showInfo();
		System.out.println("-----");
		
		// 컴퓨터
		// 품명 매직스테이션213
		// 가격 2000000
		// cpu : i7-1231
		// ram : 16
		// hdd : 500
		// 정보출력
		Computer c = new Computer();
		c.name = "매직스테이션213";
		c.price = 2000000;
		c.cpu = "i7-1231";
		c.ram = 16;
		c.hdd = 500;
		c.showInfo();
		System.out.println("-----");
		
		// 노트북
		// 그램234
		// 250만원
		// i7-6553
		// 16
		// 1000
		// 무게 2kg
		// 배터리용량 500
		// 정보출력
		Notebook n = new Notebook();
		n.name = "그램234";
		n.price = 2500000;
		n.cpu = "i7-6553";
		n.ram = 16;
		n.hdd = 1000;
		n.weight = 2;
		n.battery = 500;
		n.showInfo();
		
		
		
		
		
	}
}
