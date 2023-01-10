package UnderOver_fail;

public class OOPMain2_1 {
	public static void main(String[] args) {
		Friend f = new Friend();
		f.start(f);
	}

	// 친구 앞에 앉아서 친구가 생각한 숫자를 맞추는 게임
	// 1. 친구가 숫자를 고른다
	// 2. 내가 숫자를 쓴다
	// 3. 친구가 단서를 준다 -> 정답이 나올 때까지 반복한다
	// 4. 정답이 나오면 반복을 멈추고 확인메시지가 나오고 끝

}
