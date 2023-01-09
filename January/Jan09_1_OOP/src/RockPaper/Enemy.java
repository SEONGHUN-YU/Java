package RockPaper;

import java.util.Random;

public class Enemy {
	Random brain = new Random();

	public int fire() {
		return brain.nextInt(3)+1;
	}
}
