package com.yu.jan131oop.main;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.yu.jan131oop.hero.Hulk;

// Component : 요소(생명체)
// JButton : 버튼(사람)

// JFrame : 내장된 클래스 - 클래스 만들필요 없음
public class OOPMain2 {
	public static void main(String[] args) {
		JFrame p = new JFrame("지구"); // 제목이 지구인 JFrame
		JButton h = new JButton("홍길동"); // 텍스트가 홍길동인 JButton
		// JTextField h = new JTextField("ㅋㅋㅋ"); // 텍스트가 ㅋㅋㅋ인 JTextField
		// JFileChooser h = new JFileChooser(); // JFileChooser 기본생성
		p.add(h); // 저 별에 저 사람을 등록

		// [사수] : attack이 필수 Hero라는 interface로
		// [Java] : actionPerformed가 필수 ActionListener라는 interface로
		// 영웅인 아이언맨 -> 아래랑 같은 느낌 interface를 implements한 것(?)
		Hulk i = new Hulk(); // => ActionListener인 헐크
		h.addActionListener(i); // 저 사람이 헐크를 찜
		// 도움요청 : 클릭
		
		p.setSize(500, 500); // 그 별 사이즈 500, 500
		p.setVisible(true); // 그 별 보임

	}
}
