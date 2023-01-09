package BMI;
// OOP : 자바로 실생활 묘사
// OODesign : 실제 병원가서 비만도 검사하는 씬
//			  핵심적인 존재들만 객체로 만들어볼까? (의사, 환자)
//			  속성
//			  씬을 진행 -> 행동

// 첫 실행은 main 있는데서, 두번째부터는 어디서 하든지 상관 없음

public class OOPMain3 {
	public static void main(String[] args) {
		Doctor d = new Doctor();
		d.callPatient();
		d.start();
//		Patient p = new Patient(); 여기다 적는 거 아냐
	}
}
