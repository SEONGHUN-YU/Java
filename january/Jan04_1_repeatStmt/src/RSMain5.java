import java.util.Random;
import java.util.Scanner;

// UpDown
// 컴퓨터가 1~10000 사이의 랜덤한 숫자 하나 생각하고(값을 저장하고)
// 컴퓨터가 생각한 숫자 맞추기 - 1783

// 뭐 : 500
// Up
// -----------
// 뭐 : 3000
// Down
// -----------
// ...
// -----------
// 뭐 : 1783
// 10턴만에 정답

public class RSMain5 {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner k = new Scanner(System.in);
		int a = r.nextInt(10000)+1;
		int b;
		int c = 0;
		System.out.println();
		while (true) {
			c++;
			System.out.println("뭐 : ");
			b = k.nextInt();
			if (a>b) {
				System.out.print("Over\n");
			}else if (a<b) {
				System.out.print("Under\n");
			}else {
				break;
			}
		}
		System.out.printf("%d번만에 정답입니다!",c);
	}
}