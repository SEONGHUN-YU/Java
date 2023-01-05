// Java에서는 배열 자체를 잘 안 쓴다, 상위호환의 것이 있어서 굳이 안 씀
// 자료형을 섞지 못한다 => int배열은 int만 쓸 수 있다 글자랑 숫자를 같이 못 써서 구림
// 숫자로 접근하니 다른 사람이 의미를 모르기 쉬움
// 요즘은 알고리즘에 집중X => 유지보수에 집중O => 간단하게 정리할 수록 좋은 거임

// Java/Python : 2차원 배열사용은 쫌 아님... 다른 언어면 몰라

public class ArrayMain3 {
	public static void main(String[] args) { // 학생 3명이 시험을 3번 본 거라고 치자
		int[][] score = { { 90, 50, 80 }, { 10, 20, 30 }, { 10, 30, 50 } }; // 2차원 배열
		
		System.out.println(score); // 의미상으로는 전체점수
		System.out.println(score[0]); // 첫번째 학생의 점수
		System.out.println(score[1][2]); // 두번째 학생의 3번째 시험점수
	}
}
