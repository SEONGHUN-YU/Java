package com.yu.jan132gui.main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.yu.jan132gui.doctor.Doctor;

// 가볍게
// 		WORA를 지향하는 Java로 윈도우 프로그램 잘 안 만듬
// 		빅데이터+웹 하는데 JFrame 같은 거 전혀 상관없음
//		android앱이 목표라면 구조 맛보는 느낌으로 괜찮음

// 기업체
//		쓰던 프로그램 : 웹기반 Spring 좀 배워!

// C# -> unity -> VR/AR/MR
public class GUIMain {
	public static void main(String[] args) {
		JFrame jf = new JFrame("비만도검사");
		// Layout 도시계획 입주전략
		// 4행 2열짜리 GridLayout (격자형) <- 맨윗줄부터 가로로 먼저 채우고 그 다음줄로 넘어간다
		// jf의 레이아웃속성으로 지정
		GridLayout gl = new GridLayout(4, 2);
		jf.setLayout(gl);

		// 텍스트가 이름:인 JLabel
		// jf에 추가
		jf.add(new JLabel("이름 : ")); // 지금 경우는 JLabel 변수로 꼭 만들 필요는 없긴하다
		// JTextField
		// jf에 추가
		JTextField nameTF = new JTextField();
		jf.add(nameTF);

		// 텍스트가 키:인 JLabel
		// jf에 추가
		JLabel heightLB = new JLabel("키 : ");
		jf.add(heightLB);
		// JTextField
		// jf에 추가
		JTextField heightTF = new JTextField();
		jf.add(heightTF);

		// 텍스트가 몸무게:인 JLabel
		// jf에 추가
		JLabel weightLB = new JLabel("몸무게 : ");
		jf.add(weightLB);
		// JTextField
		// jf에 추가
		JTextField weightTF = new JTextField();
		jf.add(weightTF);

		// 텍스트가 결과인 JTextArea
		// jf에 추가
		JTextArea ta = new JTextArea("결과");
		Doctor d = new Doctor(nameTF, heightTF, weightTF, ta);
		// 텍스트가 확인인 JButton
		// jf에 추가
		JButton btn = new JButton("확인");
		btn.addActionListener(d);
		jf.add(btn);
		jf.add(ta);

		jf.setSize(500, 500);
		jf.setVisible(true);
	}
}
