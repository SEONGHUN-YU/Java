// 삼성이라는 회사가 1개 있는데, 강의실 컴퓨터들을 만들었나? - Yes
// i7-1231라는 부품이 1개 있는데, 강의실 컴퓨터들이 그 부품을 같이 쓰나? No
// i7-1231이 30개 각자, 이 경우 하나만 업그레이드 시키면 (29개, 1개)로 돼야하는 데
// static이면 그게 안 되니까 현재는 될 지 몰라도 나중을 생각하면 static은 안 좋을 수도 있다

public class AcademyComputer {
	String cpu;
	int ram;
	int hdd;
	static String maker = "삼성";

	public void showInfo() {
		System.out.println(cpu);
		System.out.println(this.ram);
		System.out.println(this.hdd);
		System.out.println(maker);
	}
	public static void showMaker() {
		System.out.println(maker);
	}
	
}
