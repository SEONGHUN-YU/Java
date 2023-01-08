import java.util.Scanner;

public class OperatorMain2 {
	public static void main(String[] args) {
		// 비만도검사
		// 이름 :
		// 키 :
		// 몸무게 :
		// -----
		// 표준체중 : 70.51kg
		// 비만도 : 110.21%
		// 홍길동씨는 비만

		Scanner keyboard = new Scanner(System.in);

		System.out.println("비만도검사");
		System.out.print("이름 : ");
		String name = keyboard.next();
		System.out.print("키 : ");
		double height = keyboard.nextDouble();
		System.out.print("몸무게 : ");
		double weight = keyboard.nextDouble();
		System.out.println("-----");
		double basicWeight = (height - 100) * 0.9;
		double obesity = (weight / basicWeight) * 100;
		String result = (obesity > 120) ? "비만" : "정상";
		System.out.printf("표준체중 : %.2fkg\n비만도 : %.2f%%\n", basicWeight, obesity);
		System.out.printf("%s씨는 %s\n", name, result);
//		System.out.println(name + "씨는 " + ((obesity > 120) == true ? "비만" : "정상")); 으로도 가능하다

		System.out.print("끝내려면 뭐라도 쳐요 : ");
		String end = keyboard.next();

		// 작업 끝났으면 Export -> Runnable JAR file -> 경로설정, 이름설정 후 Finish
		// -> 메모장 열어서 <java -jar 파일명.jar> 입력 후
		// -> 파일형식을 모든 파일로 하고 파일명 뒤에 .bat 붙인 후 저장

	}
}
