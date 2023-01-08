// 반복횟수가 명확 -> for
// 반복조건이 명확
// 10:34
// recursive <- 계산용 아님, 계산은 반복문이 좋다

public class RSMain {
	public static void main(String[] args) {
		// Java는 변수 만들고 나서, 값을 안 넣으면 못 쓴다(기본값이 0이 아니다) 변수 사용을 못함, 값을 넣어야 돼

		// 1 + 2 + ... + 10 = ?

		int a = 0; // <- 0이 아니고 걍 비어있음
		for (int i = 1; i < 11; i++) {
			// int a = 0; // 반복문 속에서 변수 만들지 마라, 피할 수 있으면 꼭 피해라
			a += i;
		}
		System.out.println(a);
		// ctrl(왼쪽) + f11 : 실행
		// f11 : 디버그(벌레잡기) => f6 : 한 줄씩 실행
		System.out.println("-----");
		// 1 * 2 * 3 * ... * 7 = ?
		int b = 1;
		for (int i = 1; i < 8; i++) {
			b *= i;
		}
		System.out.println(b);
		System.out.println("-----");
		// 1 + 3 + 5 + 7 + 9 = ?
		int c = 0;
		for (int i = 1; i < 10; i++) {
			if (i % 2 == 1) {
				c += i;
			}
		}
		System.out.println(c);
		System.out.println("-----");
		// 1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 = ?
		int d = 0;
		int ii = -1; // RAM 사용량이 더 늘어남
		for (int i = 1; i < 10; i++) {
			ii *= -1;
			d += (i * ii);
//			d += (i % 2 == 1) ? i : -i; // <- (괜찮은 풀이), 조건을 따진다 => CPU 사용량이 늘어남
//			if (i % 2 == 0) { // <- (기본 풀이)
//				d -= i;
//			} else {
//				d += i;
//			}
		}
		System.out.println(d);
	}
}
