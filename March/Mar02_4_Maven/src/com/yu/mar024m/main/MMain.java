package com.yu.mar024m.main;

// 이번에도 kxml.jar가 필요 (이미 kxml.jar가 로컬저장소에 있는 상태)
// Maven을 쓰게 되면 기존 수동 방식과 같이 사용 못 함 (동시에 못 씀)
//		YUDBManager를 못 쓰게 된다는 소리
// -> 내가 만든 .jar를 Maven으로 쓰려면 Import해서 추가해줘야 함
// ojdbc는 Maven 중앙저장소에 없음
// 		갖고있는 ojdbc8.jar를 등록하거나
// 		사설저장소를 활용하거나

// Maven
// 처음 쓰면 : 중앙저장소에서 검색해서 받아오고
// 쓴 적 있는 거면 : pom.xml에서 자체 검색해서 추가해주고
// 내가 만든 거 쓰려면 : import해서 한 번 등록해놓고, 검색해서...

// 중앙저장소에 없는 거
//		갖고있는 거면 : import해서 등록해놓고 검색해서 추가해주고
//		없는 거면 : 사설저장소에서 찾아서 등록하고 쓰거나 해야 할 수도

// 라고는 하는데 그냥 메모장 같은 곳에 적어두고 복붙하는 게 가장 실전적이고 빠르다
public class MMain {
	public static void main(String[] args) {
		
	}
}
