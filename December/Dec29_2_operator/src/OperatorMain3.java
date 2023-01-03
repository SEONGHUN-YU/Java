import java.util.Scanner;

// 앞바퀴둘레 :
// 앞 기어 톱니 수 :
// 뒷 기어 톱니 수 :
// 페달 돌린 횟수 :
// ---------------
// 이동거리 :

public class OperatorMain3 {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);

		System.out.print("앞바퀴 둘레 : ");
		double bike = keyboard.nextDouble();

		System.out.print("앞 기어 톱니 수 : ");
		int front = keyboard.nextInt();

		System.out.print("뒷 기어 톱니 수 : ");
		int back = keyboard.nextInt();

		System.out.print("페달 돌린 횟수 : ");
		int spin = keyboard.nextInt();
		
		System.out.println("-----");

//		double moving = (double) front / back;
		double move = bike * spin * front / back;
		System.out.printf("이동거리 : %.2f", move);
		
		
	}
}
