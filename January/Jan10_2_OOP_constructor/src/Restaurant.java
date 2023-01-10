// 멤버변수들은 위치가 어디있든 상관없긴하다, 근데 그러지말자...
// 나중에 유지보수가 힘들다

// 배치양식 기본 틀
public class Restaurant {

	// 1.멤버변수 배치
	String name;
	int table;
	String address;

	// 2. 생성자시리즈 배치
	// 기본생성자가 딱히 필요할까? => 응 필요하다
	// JSP/Spring 등 후반부 기술로 가면
	// 객체를 자동으로 만듬 => 기본생성자 안 만들어두면 이 때 오류나기 쉬움
	// 어려운 거 아니니까 수동으로 만들어두자
	// ctrl + space
	public Restaurant() {

	}

	// overloaded constructor
	// 오버로딩된 생성자
	// 이걸 많이 쓴다, 기본생성자는 잘 안 쓰임
	public Restaurant(String name, int table, String address) {
		super();
		this.name = name;
		this.table = table;
		this.address = address;
	}

	// 3. 나머지 메소드
	public void print() {
		System.out.println(name);
		System.out.println(table);
		System.out.println(address);

		// 단축키 만들기
		// window -> preference -> General -> Keys -> Binding에 쓰면 됨 -> apply

	}
}
