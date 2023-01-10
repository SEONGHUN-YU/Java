package UnderOver_fail;

import java.util.Random;
import java.util.Scanner;

public class Friend {
	Scanner k = new Scanner(System.in);
	Random r = new Random();
	int friendNumber;
	int myNumber;
	boolean judge;
	int turn;

	public Friend() {
	}

	public int pickNumber() {
		System.out.println("골랐어!");
		return r.nextInt(10000) + 1;
	}

	public int writeNumber() {
		return k.nextInt();
	}

	public void printScore(int turn) {
		System.out.printf("%d번만에 정답!", turn);
	}

	public boolean judge(int a, int w) {
		if (a == w) {
			return true;
		} else if (a > w) {
			System.out.print("오버\n");
		} else {
			System.out.print("언더\n");
		}
		return false;
	}

	public void start(Friend f) {
		int a = pickNumber();
		int b;
		System.out.println(a);
		for (int turn = 1; true; turn++) {
			b = writeNumber();
			if (judge(a, b)) {
				printScore(turn);
				break;
			}
		}
	}
}