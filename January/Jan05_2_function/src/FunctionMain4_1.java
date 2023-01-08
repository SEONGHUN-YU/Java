import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

// 1. 가위, 2. 바위, 3.보
// 내라 :
// 나 : 보
// 컴 : 바위
// 승

public class FunctionMain4_1 {
	public static void main(String[] args) {

		String[] rps = { "---", "가위", "바위", "보" };
		for (int i = 1; i < rps.length; i++) {
			System.out.printf("%d) %s\n", i, rps[i]);
		}

		Random r = new Random();
		Scanner k = new Scanner(System.in);
		int win = 0;
		while (true) {
			int com = r.nextInt(3) + 1;

			System.out.println("-----");
			System.out.print("내라 : ");
			int user = k.nextInt();

			System.out.printf("컴 : %s\n", rps[com]);
			System.out.printf("나 : %s\n", rps[user]);

			int j = user - com;
			if (j == 0) {
				System.out.println("무승부");
			} else if (j == -1 || j == 2) {
				System.out.println("패배");
				break;
			} else {
				System.out.println("승리");
				win++;
			}
		}
		System.out.printf("%d연승\n", win);
	}
}
