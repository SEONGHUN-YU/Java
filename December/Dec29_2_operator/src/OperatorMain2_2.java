import java.util.Scanner;

public class OperatorMain2_2 {
	public static void main(String[] args) {
		//쌤의 풀이
		Scanner money = new Scanner(System.in);
		System.out.print("구매금액 : ");
		int buy = money.nextInt();

		System.out.print("지출 :");
		int give = money.nextInt();
		System.out.println("-----");

		int change = give - buy;
		System.out.printf("거스름돈 : %d원\n", change);

		int jjary = 50000;
		int amount = change / jjary;
		System.out.printf("%d원짜리 %d개\n", jjary, amount);
//	change = change - (jjary*amount); => change -= (jjary*amount);
		change = change % jjary; // => change %= jjary;

		jjary = 10000;
		amount = change / jjary;
		System.out.printf("%d원짜리 %d개\n", jjary, amount);
		change = change % jjary;

		jjary = 5000;
		amount = change / jjary;
		System.out.printf("%d원짜리 %d개\n", jjary, amount);
		change = change % jjary;

		jjary = 1000;
		amount = change / jjary;
		System.out.printf("%d원짜리 %d개\n", jjary, amount);
		change = change % jjary;

		jjary = 500;
		amount = change / jjary;
		System.out.printf("%d원짜리 %d개\n", jjary, amount);
		change = change % jjary;

		jjary = 100;
		amount = change / jjary;
		System.out.printf("%d원짜리 %d개\n", jjary, amount);
		change = change % jjary;

		jjary = 50;
		amount = change / jjary;
		System.out.printf("%d원짜리 %d개\n", jjary, amount);
		change = change % jjary;

		jjary = 10;
		amount = change / jjary;
		System.out.printf("%d원짜리 %d개\n", jjary, amount);
		change = change % jjary;

	}
}
