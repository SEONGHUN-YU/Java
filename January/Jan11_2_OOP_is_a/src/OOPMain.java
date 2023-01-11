// Java : Sun사 -> Oracle사
// EclipseIDE : IBM사였는데 -> 현재는 독립
public class OOPMain {
	public static void main(String[] args) {
		// 상품
		// 품명
		// 가격
		// 메이커
		// 정보출력
		Firewall f = new Firewall();
		f.name = "80F";
		f.price = 0;
		f.maker = "Fortigate";
		f.port = 10;
		f.showInfo();
		System.out.println("-----");

		Firewall f2 = new Firewall("80F", 0, "fortigate", 10);
		f2.showInfo();
		System.out.println("-----");

		// 모나미153, 500원, 모나미, 검정 펜
		// 정보출력
		Pen p = new Pen("모나미153", 500, "모나미", "검정");
		p.showInfo();
		System.out.println("-----");

		// 로지텍123, 10000, 로지텍마우스
		// 정보출력
		Mouse m = new Mouse("로지텍123", 10000, "로지텍메이커");
		m.showInfo();
		System.out.println("-----");

		// 캐논123, 500000, 캐논 스캐너
		// 정보출력
		Scanner s = new Scanner("캐논123", 500000, "캐논메이커스캐너");
		s.showInfo();

		// 클래스명이 같으면 곤란하다 <- 작동이 안 되니까,
		// 클래스명이 중복 안 되게 조심해서 지어라 <- 거시적 관점에서 사실상 불가능;
		// -> 클래스명을 다 알고 있어야 하는 거 아냐? 엥...?
//		Scanner k = new Scanner(System.in); <- 고장남
//		int q = k.next();

	}
}
