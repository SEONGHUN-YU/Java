import java.util.Random;
import java.util.Scanner;

public class FunctionMain4_2 {
	public static void printRule() {
		System.out.println("1) 가위");
		System.out.println("2) 바위");
		System.out.println("3) 보");
	}

	public static int com() {
		Random r = new Random();
		return r.nextInt(3) + 1;

	}

	public static int user() {
		Scanner k = new Scanner(System.in);
		System.out.println("-----");
		System.out.print("내라 : ");
		int some = k.nextInt();
		return (some < 1 || some > 3) ? user() : some;

	}

	public static void printHand(int com, int user) {
		String[] rps = { "---", "가위", "바위", "보" };
		System.out.printf("컴 : %s\n", rps[com]);
		System.out.printf("나 : %s\n", rps[user]);

	}

	public static int judge(int com, int user) {
		int j = user - com;
		if (j == 0) {
			System.out.println("무승부");
			return 0;
		} else if (j == -1 || j == 2) {
			System.out.println("패배");
			return -1;
		} else {
			System.out.println("승리");
		}
		return 1;
	}

	public static void printWinCount(int win) {
		System.out.printf("%d연승\n", win);

	}

	public static void main(String[] args) {
//		String[] rps = { "가위", "바위", "보" };
//		for (int i = 0; i < rps.length; i++) {
//			System.out.printf("%d) %s\n", i, rps[i]);
//		}
		printRule();
		int com;
		int user;
		int win = 0;
		int r;
		while (true) {
			com = com();
			user = user();
			printHand(com, user);
			r = judge(com, user);
			if (r == -1) {
				break;
			}
			win += r;
		}
		printWinCount(win);
	}
}
