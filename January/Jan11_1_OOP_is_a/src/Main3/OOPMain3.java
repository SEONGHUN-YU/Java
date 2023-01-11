package Main3;

import java.util.Random;

public class OOPMain3 {
	public static void main(String[] args) {
// 만약 회사에서 랜덤한 정수(홀수만) 나오는 거 만들어 => 클래스 해달라
// final class인 것들도 있다 => 무조건 다 되는 건 아니란 소리
		YuRandom yr = new YuRandom();
		int k = yr.nextInt(10);
		System.out.println(k);
		System.out.println("-----");

	}
}
