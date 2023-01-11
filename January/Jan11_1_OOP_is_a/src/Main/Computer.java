package Main;

public class Computer extends Product {
	String cpu;
	int ram;
	int hdd;
	
	@Override
	public void showInfo() {
		super.showInfo();
		System.out.println(cpu);
		System.out.println(ram);
		System.out.println(hdd);
	}
}
