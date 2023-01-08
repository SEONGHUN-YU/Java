// 불문율 : 클래스명의 첫 글자는 대문자로 시작함
// 불문율 : 안에 Main함수가 포함 돼 있으면 xxxMain 같은 이름으로 저장한다
// 대형 프로젝트를 설계하고 실행할 때 중간 테스트가 있는 편이 훨씬 좋다
public class PrintMain2 {
	public static void main(String[] args) {
		System.out.println("ㅋㅋ");
// println : 출력하고 줄 바꿈, 가독성도 좋고 매우 자주쓰인다, 단축키 syso
		System.out.print("ㅎㅎ");
// print : 그냥 출력, 단축키 없음
		System.out.printf("%.2f", 3.1415926535);
// printf : format(형식)을 지정해서 출력, 단축키 없음
		System.out.println();
		System.out.println("지하철");
// 프로그램 언어에서 back-slash는 특별한 의미를 가진다
		System.out.println("ㅋ\nㅋ");
// \n : new line = 단순히 줄만 바꾸는 것
		System.out.println("ㅎ\rㄱ");
// \r : carriage return = 커서의 위치를 현재 줄의 맨앞으로 보내는 것
// \r\n : 엔터와 완전히 같다
		System.out.println("그\t다음 또");
		System.out.println("이름\t: 권기웅");
		System.out.println("핸드폰\t: 010-3154-4435");
// \t : tab키와 같은 기능 [tab = 다음 탭포인트로 이동하기]
		System.out.println("자 다음\b");
// \b : backspace(1byte만큼 지우기)
// Java에서는 한글자의 용량이 2bytes이다 \b를 2개 쓴다고 해서 지워지지 않는다 ㅋㅋ
		System.out.println("\\(^^)/");
// \를 글자로 사용하려면 \\로 쓰면 출력된다
		System.out.println("홍길동 : \"아\"");
// "를 글자로 사용하려면 \"로 쓰면 출력된다
		System.out.println("-----");
// 글자데이터는 꼭 따옴표를 쳐야한다, 하지만 숫자는 그냥 친다
// 안 그러면 Java문법으로 인식하기 때문이라고 한다

//		System.out.printf("형식", 데이터);
		System.out.printf("기온 : %d℃\n", 5);
// %d : 정수데이터가 들어올 자리
		System.out.printf("%04d\n", 3);
// %04d : 0채워서 n의 자리로 표기, ex) %04d = 0003, 다른 숫자 아무거나 가능
		System.out.printf("%f\n", 234.12345);
// %f : 실수데이터 들어올 자리		
		System.out.printf("%.2f\n", 234.12345);
// %.2f : 소수점 이하 n자리로 표기(반올림 함), ex) %.2f = 234.12, 다른 숫자 아무거나 가능
		System.out.printf("이름 : %s\n", "홍길동");
// %s : 글자데이터 들어올 자리
//		System.out.println("이름 : 홍길동"); 과의 차이는? 아직은 그냥 넘어가렴
		System.out.printf("습도 : %.0f%%\n", 20.345);
// %를 글자로 사용하려면 %%로 쓰면 출력된다

	}
}
