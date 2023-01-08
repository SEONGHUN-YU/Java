import java.util.Scanner;

// 공부방법
// 1. 저게 뭔데 저 강사가 저기다 써놨나 (위치가 중요한가 보네?)
// 2. 지우고 다시 만들어보기 (외워서 하라는 게 아니고 왜 저기다 썼는지? 오류는 안 나는지? 연구)
// 3. 뭐 좀 추가해서 해보기 (공격, 필살기, 좌우에서 상하까지?)
// + 코테 / 정보올림피아드 기출문제 해봐라 -> 수학익힘책 보스문제 같은 느낌

// 구매한 물건 가격 : 39640 
// 낸 돈 : 50000
// 거스름돈 :
// 50000원짜리 0개
// 10000원짜리 1개
// 5000원짜리 0개
// 1000원짜리 0개
// 100원짜리 3개
// 50원짜리 1개
// 10원짜리 1개

public class OperatorMain2_1 {
	public static void main(String[] args) {

		Scanner money = new Scanner(System.in);
		System.out.print("구매한 물건 가격 : ");
		int price = money.nextInt();

		System.out.print("낸 돈 : ");
		int myMoney = money.nextInt();
		System.out.println("-----");

		int change = myMoney - price;
		System.out.printf("거스름돈 : %d\n", change);

		int C50000 = change / 50000;
		System.out.printf("50000원 %d개\n", C50000);

		change %= 50000;
		int C10000 = change / 10000;
		System.out.printf("10000원 %d개\n", C10000);

		change %= 10000;
		int C5000 = change / 5000;
		System.out.printf("5000원 %d개\n", C5000);

		change %= 5000;
		int C1000 = change / 1000;
		System.out.printf("1000원 %d개\n", C1000);

		change %= 1000;
		int C500 = change / 500;
		System.out.printf("500원 %d개\n", C500);

		change %= 500;
		int C100 = change / 100;
		System.out.printf("100원 %d개\n", C100);

		change %= 100;
		int C50 = change / 50;
		System.out.printf("50원 %d개\n", C50);

		change %= 50;
		int C10 = change / 10;
		System.out.printf("10원 %d개\n", C10);

	}
}
