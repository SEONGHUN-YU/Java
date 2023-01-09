package BMI;
import java.util.Scanner;

// Java -> JSP -> EJB(EnterPrise JavaBean)
//					  무겁고 복잡하고 어렵다
//							Winter
// Java -> JSP -> Spring
// Java : perfect OOL
// Java : 커피이름

// 기본단위 명칭 4개
// JavaBean : 기본단위
// DTO (Data Transfer Object) 
// VO (Value Object)
// POJO (Plain Old Java Object)

// 객체지향의 효과
// 데이터를 객체단위로 묶어서 다녀서 편하다 
public class Patient {
	String name;
	double height;
	double weight;
	Scanner mouth = new Scanner(System.in);
	double bmi;
	String status;
	
	// 입장하기
//	public void go() {
//		사실 없어도 되는 부분 Doctor쪽 참고
//	}

	// 대답하기
	public String tellName() {
		return mouth.next();
	}

	public double tellHeight() {
		return mouth.nextDouble(); // 여기서 재귀호출 하는 것보다 Doctor에서
	} // if문 등으로 처리하는 게 리얼월드스럽다

	public double tellWeight() {
		return mouth.nextDouble();
	}
}
