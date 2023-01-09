package RockPaper_fail;
import java.util.Random;
import java.util.Scanner;

public class Machine {
	Random givesomE = new Random();
	Scanner giveSome = new Scanner(System.in);
	Machine r = new Machine();
	User m = new User();
	
	public void explainRule() {
		System.out.println("1) 가위");
		System.out.println("2) 바위");
		System.out.println("3) 보");
	}

	public void pressButton() {
		System.out.println("-----");
		System.out.print("버튼을 누르세요");		
		m.myChoise = giveSome.nextInt();
	}
	
	public int choiceCom() {
		Random givesomE = new Random();
		return givesomE.nextInt(3) + 1;
	}
	
	public void printChoise(Machine r,User m) {
		String[] rps = { null, "가위", "바위", "보" };
		System.out.printf("컴 : %s\n", rps[r.choiceCom()]);
		System.out.printf("나 : %s\n", rps[m.myChoise]);
		
	}
//	
//	public String judge(rps[], int user) {
//		int j = user - com;
//		if (j == 0) {
//			System.out.println("무승부");
//			return 0;
//		} else if (j == -1 || j == 2) {
//			System.out.println("패배");
//			return -1;
//		} else {
//			System.out.println("승리");
//		}
//		return 1;
//	}
//	

}
