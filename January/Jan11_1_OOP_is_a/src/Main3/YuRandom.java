package Main3;

import java.util.Random;

// Rnadom : 랜덤한 정수뽑는 기능 이미 있음, 근데 홀수만 나오게 바꾸고 싶음
// => 이게 사실상 현장에서 하는 업무 느낌, 이미 있는 걸 좀 추가하거나 수정하는 정도
// 실전에서 상속 쓰는 건 약간 이런 느낌
public class YuRandom extends Random {

	@Override
	public int nextInt(int bound) {
		int a = super.nextInt(bound);
		return (a % 2 == 0) ? nextInt(bound) : a;
	}

}
