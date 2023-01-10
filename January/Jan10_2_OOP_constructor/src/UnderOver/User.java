package UnderOver;

import java.util.Scanner;

public class User {
	Scanner brain;
	
	public User() {
		brain = new Scanner(System.in);
	}
	
	public int tell() {
		return brain.nextInt();
	}
}
