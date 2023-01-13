package com.yu.jan131oop.main;

import com.yu.jan131oop.hero.IronMan;
import com.yu.jan131oop.human.Human;
import com.yu.jan131oop.planet.Planet;

public class OOPMain {
	public static void main(String[] args) {
		Planet p = new Planet("지구"); // 이름이 지구인 행성
		Human h = new Human("홍길동"); // 이름이 홍길동인 사람
		p.add(h); // 저 별에 저 사람 등록
		// [사수입장에서] : 영웅이라는 존재들은 공격하기 기능이 필수
		IronMan i = new IronMan(); // 영웅인 아이언맨 / 아이언맨 is a 영웅
		h.pick(i); // 저 사람이 아이언맨을 자기 영웅으로 찜
		h.help(); // 저 사람이 도움요청
		p.setSize(500); // 저 별 사이즈 500
		p.setVisible(true); // 저 별이 보임

	}
}
