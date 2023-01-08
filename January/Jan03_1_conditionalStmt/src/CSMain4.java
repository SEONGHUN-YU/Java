// 조건문 2개
// if - else if - ... - else
// switch - case <- Python에 없는 조건문!, 근데 if보다 기능이 딸림, 가독성은 좋나??;;-> ㄴㄴ;;;
//		switch (대상) {
//		case 값:
//			대상이 그 값일 때 여기가 실행됨
//			break;
//		case 값:
//			대상이 그 값일 때 여기가 실행됨
//			break;
//		case 값:
//			대상이 그 값일 때 여기가 실행됨
//			break;
//		...
//		default:
//			해당사항 없으면 여기
//			break;
//		}

// 결론 => 주력은 if문이 맞음, 그러나 switch문이 활약하는 경우가 딱 1개 있다고 함
// => 권한설정할 때는 switch문이 유용함
public class CSMain4 {
	public static void main(String[] args) {

//		// 이 경우엔 if문보다 switch문이 유리함
//		String grade = "상병";
//		switch (grade) { // <- 참조형을 받아주는 게 1.5 때부터 자바는 된다
//		case "이병":
//			System.out.println("눈치");
//		case "일병":
//			System.out.println("관등성명");
//		case "상병":
//			System.out.println("훈련");
//		default:
//			System.out.println("잠");
//			break; // <- 있으나 마나한 break
//		}

		String role = "DBA";
		switch (role) {
		case "DBA":
			System.out.println("백업/복구");
			System.out.println("전원/계정관리");
		case "DBP":
			System.out.println("CRUD");
		case "DBU":
			System.out.println("서비스 이용");
			break;
		default:
			System.out.println("ㄲㅈ");
		}

//
//		Scanner k = new Scanner(System.in);
//		System.out.print("저녁먹는 사람 수 : ");
//		int count = k.nextInt();
//		System.out.println("-----");
//		System.out.printf("%d명\n", count);
//
//		switch (count) {
//		case 5: // case count<=5: 와 같은 방식으로 못한다, 정확한 값을 요구 == 조건식 불가능
//			System.out.println("예약");
//			// break; <-를 빼도 된다, break를 빼면 줄줄이 소세지로 실행된다
//		case 3:
//			System.out.println("안 해도 됨");
//			break;
//		default:
//			System.out.println("몰라");
//			break;
//		}

	}
}
