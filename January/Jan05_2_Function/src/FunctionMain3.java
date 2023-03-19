import java.util.Scanner;

public class FunctionMain3 {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		System.out.print("입력 : ");
		int option = k.nextInt();
		String[] words = { "24시간", "와이파이존", "주차장", "흡연실" };
		while ((option > 15 || option < 1)) {
			System.out.print("다시 입력 : ");
			option = k.nextInt();
		}
		for (int i = words.length - 1; i >= 0; i--) {
			if (option >= (1 << i)) {
				System.out.println(words[i]);
				option -= (1 << i);
			}
		}
		System.out.println("-----");

		System.out.print("물건 가격 : ");
		int price = k.nextInt();
		System.out.print("지불한 금액 : ");
		int money = k.nextInt();
		System.out.println("-----");
		int change = money - price;
		System.out.printf("거스름돈 : %d\r\n", change);
		int[] won = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
		int amount = 0;
		for (int i = 0; i < won.length; i++) {
			amount = change / won[i];
			change %= won[i];
			System.out.printf("%d원짜리 %d개\r\n", won[i], amount);
		}
	}
}
