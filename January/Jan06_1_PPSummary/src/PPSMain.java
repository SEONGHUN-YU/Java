import java.util.Arrays;
import java.util.Iterator;

// 정리하려면 안쪽에서 바깥쪽으로 만들어 나가라
public class PPSMain {
	public static void bubbleSort(int[] no) { // 로직이 틀린거지 알고리즘이 틀리지 않은 걸 조심
		int a;
		for (int turn = 1; turn < no.length; turn++) {
			for (int i = 0; i < (no.length - turn); i++) {
				if (no[i] > no[i + 1]) {
					a = no[i + 1];
					no[i + 1] = no[i];
					no[i] = a;
				}
			}
		}
	}

	// 함수를 부르면 작은 것부터 순서대로 나오게 해봐라
	// 버블소트 : 두 자리씩 비교해서 앞의 숫자가 크면 뒤로 보내서 정렬하는 알고리즘
	// 한 번 비교를 시작한 숫자가 더 이상 자리를 바꿀 수 없을 때 마지막 자리를 고정시키고 다시 맨 처음 숫자부터 비교한다
	public static void selectionSort(int[] no) {

		int min;
		int minIndex;
		int a;
		for (int turn = 0; turn < no.length - 1; turn++) {
			min = no[turn];
			minIndex = turn;
			for (int i = (turn + 1); i < no.length; i++) {
				if (min > no[i]) {
					min = no[i];
					minIndex = i;
				}
			}
			a = no[turn];
			no[turn] = no[minIndex];
			no[minIndex] = a;
		}

//		int min = 999999999; // 최소값 찾는 식
//		for (int n : no) {
//			if (min > n) {
//				min = n;
//			}
//		}
	}

	// 함수를 부르면 작은 것부터 순서대로 나오게 해봐라
	// 셀렉션소트 : 반복적으로 모두 비교해서 가장 작은 숫자를 찾은 후 맨 앞자리에 넣고 그 다음자리도 같은 방식으로 채워나가는 방법
	public static void main(String[] args) {
		int[] no = { 23, 345, 234, 111, 45, 5667, 6786 };
//		bubbleSort(no); // 흐름 발동 순서 조심(위치가 매우 중요함, 항상 신경 써라)
		selectionSort(no);
		Arrays.sort(no); // 알아서 정렬해줌
		for (int i : no) {
			System.out.println(i);
		}
	}
}
