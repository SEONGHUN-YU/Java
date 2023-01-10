package UnderOver;

public class Referee {
	// 멤버변수 없는데?;; -> 객체는 굳이 안 만들어도 되는 거임 -> 굳이 메모리 공간 깨먹을 필요는 없잖아?
	
	public static int askGameAnswer(Friend f) {
		System.out.println("골랐어!");
		return f.tellAnswer();
	}

	public static int askUserAnswer(User u) {
		int ua = u.tell();
		return (ua < 1 || ua > 10000) ? askUserAnswer(u) : ua;
	}

	public static boolean judge(int ga, int ua) {
		if (ga == ua) {
			System.out.println("정답");
			return true;
		} else if (ga > ua) {
			System.out.println("Over");
		} else {
			System.out.println("Under");
		}
		return false;
	}

	public static void tellResult(int turn) {
		System.out.printf("%d번만에 정답!", turn);
	}

	public static void start(Friend f, User u) {
		int gameAnswer = askGameAnswer(f);
		System.out.println(gameAnswer);
		int userAnswer;
		for (int turn = 1; true; turn++) {
			userAnswer = askUserAnswer(u);
			if (judge(gameAnswer, userAnswer)) {
				tellResult(turn);
				break;
			}
		}
	}
}
