package Main2;

public class Meat extends Menu {
	String roast;
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(this.roast);
	}
}
