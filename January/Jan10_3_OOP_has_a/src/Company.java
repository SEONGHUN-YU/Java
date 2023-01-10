
public class Company {
	String name;
	int workers;
	Human ceo;

	public Company() {
	}

	public Company(String name, int workers, Human ceo) {
		super();
		this.name = name;
		this.workers = workers;
		this.ceo = ceo;
	}

	public void showInfo() {
		System.out.println(name);
		System.out.println(workers);
		if (ceo != null) {
			ceo.showInfo();

		}
	}

}
