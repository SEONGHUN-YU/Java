public abstract class ArrayMain2 {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < args.length; i++) {
			String s = args[i];
			System.out.println(s);
		}
		System.out.println("-----");

		for (String s : args) {
			System.out.println(s);
		}
		Thread.sleep(50000);
	}
}
