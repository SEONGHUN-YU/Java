
public class Human {
	String name;
	String location;
	Dog pet;

	public Human() {
	}

	public Human(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}

	public Human(String name, String location, Dog pet) {
		super();
		this.name = name;
		this.location = location;
		this.pet = pet;
	}

	public void showInfo() {
		System.out.println(name);
		System.out.println(location);
		if (pet != null) {
			pet.showInfo();
		}

	}
}
