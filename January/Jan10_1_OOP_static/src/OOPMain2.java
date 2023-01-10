
public class OOPMain2 {
	public static void main(String[] args) {
//		Calculator c = new Calculator();
//		c.printMulti(10, 5); <- 낭비
		Calculator.printMulti(10, 5);
		System.out.println("-----");

		// 학원에 있는 모든 컴은 다 삼성
		// 학원에 있는 모든 cpu는 다 i7-1231
		// ram : 16
		// hdd : 500
		// 메이커 : 삼성
		// 전체정보 출력
		// 메이커만 단독출력
		AcademyComputer ac = new AcademyComputer();
		ac.cpu = "i7-1231";
		ac.ram = 16;
		ac.hdd = 500;
		ac.showInfo();
		AcademyComputer.showMaker();
		

	}
}
