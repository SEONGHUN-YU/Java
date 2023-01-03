import java.util.Scanner;
// UX : 인생경험?

public class InputMain {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

// 콘솔창에 입력한 글자데이터 가져오기
		System.out.print("식당이름 : ");
		String name = keyboard.next();

		System.out.print("주소 : ");
		String address = keyboard.next();

		System.out.print("테이블 수 : ");
		int table = keyboard.nextInt();

		System.out.print("별점 : ");
		double star = keyboard.nextDouble();

		System.out.print("예약가능 : ");
		boolean reserve = keyboard.nextBoolean();

		System.out.println("-----");
		System.out.printf("%s에 있는\n", address);
		System.out.println(name);
		System.out.printf("%d테이블\n", table);
		System.out.printf("별점:%.1f\n", star);
		System.out.printf("예약:%b", reserve);

// System.out.printf("형식", 값, 값, 값...); 같은 형식으로도 가능하다

// ex) System.out.printf("%d테이블 별점%.1f\n", table, star);

	}
}
