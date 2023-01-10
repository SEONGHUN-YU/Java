
public class NewYearGift {
	String name;
	int price;
	double weight;

	public NewYearGift() {
		name = "1++등급 한우 꽃꽃명작 선물세트";
		price = 199950;
		weight = 1.2;
	}

	public void showInfo() {
		System.out.println(this.name);
		System.out.printf("%d원\n", this.price);
		System.out.printf("%.1fkg\n", this.weight);
	}
}
