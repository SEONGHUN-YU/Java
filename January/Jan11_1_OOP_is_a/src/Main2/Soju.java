package Main2;

public class Soju extends Menu{
	int alcohol;
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(this.alcohol);
	}
}
