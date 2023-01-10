
public class SmartPhone {
	String modelname;
	int price;
	Company maker;

	public SmartPhone() {
	}

	public SmartPhone(String modelname, int price, Company maker) {
		super();
		this.modelname = modelname;
		this.price = price;
		this.maker = maker;
	}

	public void showInfo() {
		System.out.println(modelname);
		System.out.println(price);
		if (maker != null) {
			maker.showInfo();
		}
	}

}
