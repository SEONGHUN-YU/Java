package UnderOver;

import java.util.Random;

public class Friend {
	Random brain;
	
	public Friend() {
		brain = new Random();
	}

	public int tellAnswer() {
		return brain.nextInt(10000) + 1;
	}
}
