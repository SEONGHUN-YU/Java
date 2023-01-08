
public class VariableMain2 {
	public static void main(String[] args) {
		// 식당 이름이 김밥천국
		// 식당 주소가 봉은사로117
		// 테이블이 10테이블
		// 별점 4.5
		// 예약 가능
		System.out.println("-----");

		// 출력...풀이 예시
		String rstName = "김밥천국";
		String rstAddress = "봉은사로117";
		int table = 10;
//		double table = 10;
		double star = 4.5;
//		float star = 4.5f;
		boolean reserve = true;

		System.out.printf("%s\n", rstName);
		System.out.printf("%s\n", rstAddress);
		System.out.printf("%d\n", table);
		System.out.printf("%.1f\n", star);
		System.out.printf("%s", reserve);

	}
}
