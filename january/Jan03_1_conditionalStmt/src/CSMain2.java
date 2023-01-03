import java.util.Scanner;

// 24시간 : 1 << 0 = 1
// 와이파이존 : 1 << 1 = 2
// 주차장 : 1 << 2 = 4
// 흡연실 : 1 << 3 = 8 => 8대신 (1 << 3)을 어디든지 넣어도 된다

public class CSMain2 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("TEST");
		int option = keyboard.nextInt();
		if (option > 15 || option < 1) {
			System.out.println("다시 입력");
		} else {
			if (option >= 8) {
				System.out.println("흡연실");
				option -= 8;
			}
			if (option >= 4) {
				System.out.println("주차장");
				option -= 4;
			}
			if (option >= 2) {
				System.out.println("와이파이존");
				option -= 2;
			}
			if (option >= 1) {
				System.out.println("24시간");
				option -= 1;
			}
		}
	}
}
