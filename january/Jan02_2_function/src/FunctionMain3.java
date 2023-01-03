import java.awt.RenderingHints.Key;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

// 비만도검사
// 이름 :
// 키 :
// 몸무게 :
// -----
// 표준체중 : 70.51kg
// 비만도 : 110.21%
// 홍길동씨는 비만

// 통일성을 위해 필요가 없더라도 함수로 만들어준다?!

// 미래에 바뀔 것 같은 것, 통일성이 필요한 것, 정리가 필요한 것 => 함수로 만들어준다!
// void는 return할 필요가 없다 

// import - General 2번째꺼 -> Select root directory에서 폴더 자체선택 OR 상위폴더선택
// copy projects into workspace = 내가 작업하는 공간에 복사해서 넣어줌

//정답은 없다, 다만 더 괜찮은 답은 있다
//조건문, 반복문, 배열, 그 언어만의 특징을 자유자재로 써낼 수 있으면 => 끝


public class FunctionMain3 {

	public static double getBasicWeight(double h) {
		return (h - 100) * 0.9;
	}

	public static double getHeight() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("키 : ");
		double height = keyboard.nextDouble();
		return (height < 3) ? getHeight() : height;

	}

	public static String getName() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("비만도검사");
		System.out.print("이름 : ");
		return keyboard.next();

	}

	public static double getObesity(double w, double bw) {
		return (w / bw) * 100;
	}

	public static double getWeight() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("몸무게 : ");
		double weight = keyboard.nextDouble();
		return weight;
	}

	public static String judge(double o) {
		return (o > 120) ? "비만" : "정상";
	}

	public static void printEnd() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("끝내려면 아무거나 누르세요 : ");
		keyboard.next();

	}

	public static void printResult(double bw, double o, String n, String r) {
		System.out.printf("표준체중 : %.2fkg\n비만도 : %.2f%%\n", bw, o);
		System.out.printf("%s씨는 %s\n", n, r);

	}

	public static void main(String[] args) {
		String name = getName();
		double height = getHeight();
		double weight = getWeight();
		System.out.println("-----");
		double basicWeight = getBasicWeight(height);
		double obesity = getObesity(weight, basicWeight);
		String result = judge(obesity);
		printResult(basicWeight, obesity, name, result);
		printEnd();
	}
}
