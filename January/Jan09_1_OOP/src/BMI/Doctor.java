package BMI;
// 변수종류 3개
// member variable <- 속성
// parameter <- 필요한 재료
// local variable <- 그 작업을 하는 동안만 임시로 쓰는 거

// PP : 어렵다
// for/if/배열 - 수학적 머리
// OOP : 또 다른 복잡함

public class Doctor {
//	Patient p; // 주치의 담당의사 같은 느낌

	// 들어오시오
	public Patient callPatient() {
		return new Patient();
	}

	// 업무시작
	public void start() {
		Patient a = callPatient();
		ask(a);
		calculate(a);
		tellResult(a);
	}

	// 속성 물어보기
//	public 남는 거(손님정보) ask(필요한 거) {}
	public void ask(Patient a) {
		System.out.println("이름 : ");
		a.name = a.tellName();
		System.out.println("키 : ");
		a.height = a.tellHeight();
		if (a.height > 3) {
			a.height /= 100;
		}
		System.out.println("몸무게 : ");
		a.weight = a.tellWeight();
	}

	// 계산하기
	public void calculate(Patient a) {
		a.bmi = a.weight / (a.height * a.height);

		a.status = "저체중"; // else 생략 꼼수테크닉
		if (a.bmi >= 30) {
			a.status = "비만";
		} else if (a.bmi >= 23) {
			a.status = "과체중";
		} else if (a.bmi >= 18.5) {
			a.status = "정상";
		}
	}

	// 결과발표하기
	public void tellResult(Patient a) {
		System.out.printf("BMI : %.1f\n",a.bmi);
		System.out.printf("%s씨는 %s\n",a.name,a.status);
	}

}
