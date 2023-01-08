import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

// 로또번호 자동 생성기
public class PPSMain2 {

	public static int pick(int[] lotto, int pos) {
		Random r = new Random();
		int ball = r.nextInt(45) + 1;
		for (int i = 0; i < pos; i++) {
			if (ball == lotto[i]) {
				return pick(lotto, pos);
			}
		}
		return ball;
	}

	public static void main(String[] args) {
		// random 필요하고, 1~45 필요하고
		// a를 뽑고, a를 제외한 숫자1개를 뽑고, 6번 반복, == 조건문 필요, 반복문 필요, 배열 안 쓰는 줄 알았는데 써야함
		int[] lotto = new int[6];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = pick(lotto, i);
		}
		Arrays.sort(lotto);
		for (int j : lotto) {
			System.out.println(j);
		}
	}
}
