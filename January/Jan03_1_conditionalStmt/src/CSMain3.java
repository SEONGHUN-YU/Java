import java.util.Scanner;

public class CSMain3 {

	public static String getName() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("BMI 검사");
		System.out.println("이름 : ");
		return keyboard.next();

	}

	public static double getHeight() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("키(m) : ");
		double height = keyboard.nextDouble();
		return (height > 3) ? getHeight() : height;
		// return height / 100; <- cm를 쓴다고 가정할 경우 이렇게 해결할 수 있다

	}

	public static double getWeight() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("몸무게(kg) : ");
		return keyboard.nextDouble();

	}

	public static double getBMI(double h, double w) {
		return (w / h * h);

	}

	public static String getJudge(double bmi) {
		if (bmi > 30) {
			return "고도 비만";
		} else if (bmi >= 25) {
			return "비만";
		} else if (bmi > 23) {
			return "과체중";
		} else if (bmi >= 18.5) {
			return "정상";
		}
//			else { 지금같은 상황에서는 else를 생략해도 된다
		return "저체중";
//		}
	}

	public static void printResult(double bmi, String n, String r) {
		System.out.printf("BMI : %.1f\n", bmi);
		System.out.printf("%s씨는 %s\n", n, r);
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String name = getName();
		double height = getHeight();
		double weight = getWeight();
		System.out.println("-----");
		double bmi = getBMI(height, weight);
		String result = getJudge(bmi);
		printResult(bmi, name, result);

		// bmi = weight/height*height
		// bmi<18.5 저체중 18.5<=bmi<=23정상 23<bmi<25 과체중 25<=bmi<=30비만 30<bmi 고도비만

	}
}
