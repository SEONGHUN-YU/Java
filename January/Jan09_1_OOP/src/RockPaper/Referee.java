package RockPaper;

public class Referee {
	String[] ruleBook = { null, "가위", "바위", "보" };

	public void readRulebook() {
		for (int i = 1; i < ruleBook.length; i++) {
			System.out.printf("%d) %s\n", i, ruleBook[i]);
		}
		System.out.println("-----");
	}

	public int userFire(User u) {
		System.out.println("내세요 : ");
		int uh = u.fire();
		return (uh < 1 || uh > 3) ? userFire(u) : uh;
	}

	public int enemyFire(Enemy e) {
		return e.fire();
	}

	public void tellHand(int uh, int ch) {
		System.out.printf("상대 : %s\n", ruleBook[ch]);
		System.out.printf("유저 : %s\n", ruleBook[uh]);
	}

	public int judge(int uh, int ch) {
		int t = uh - ch;
		if (t == 0) {
			System.out.println("무승부");
			return 0;
		} else if (t == -1 || t == 2) {
			System.out.println("패배");
			return -1;
		} else {
			System.out.println("승리");
			return 1;
		}
	}

	public void tellResult(User u) {
		System.out.printf("%d연승\n", u.win);
	}

	public void start(Enemy e, User u) {
		readRulebook();
		int userHand;
		int comHand;
		int result;
		while (true) {
			userHand = userFire(u);
			comHand = enemyFire(e);
			tellHand(userHand, comHand);
			judge(userHand, comHand);
			result = judge(userHand, comHand);
			if (result == -1) {
				break;
			}
			u.win += result;
		}
		tellResult(u);
	}
}
