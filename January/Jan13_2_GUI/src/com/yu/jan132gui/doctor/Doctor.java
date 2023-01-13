package com.yu.jan132gui.doctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Doctor implements ActionListener {
	private JTextField nameTF;
	private JTextField heightTF;
	private JTextField weightTF;
	private JTextArea ta;

	public Doctor() {
	}

	public Doctor(JTextField nameTF, JTextField heightTF, JTextField weightTF, JTextArea ta) {
		super();
		this.nameTF = nameTF;
		this.heightTF = heightTF;
		this.weightTF = weightTF;
		this.ta = ta;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String n = nameTF.getText();
		// String -> double : 중요한 개념

		String h = heightTF.getText(); // 숫자가 필요하지만 원래형식이 텍스트라 일단 텍스트로 받는다
		double h2 = Double.parseDouble(h);

		String w = weightTF.getText();
		double w2 = Double.parseDouble(w);

		double bmi = w2 / (h2 * h2);
		String status = "저체중";
		if (bmi > 30) {
			status = "고도 비만";
		} else if (bmi >= 25) {
			status = "비만";
		} else if (bmi > 23) {
			status = "과체중";
		} else if (bmi >= 18.5) {
			status = "정상";
		}

//		System.out.printf("BMI : %.1f\n%s씨는 %s\n", bmi, n, status); // 아래처럼 변경
		String result = String.format("BMI : %.1f\n%s씨는 %s\n", bmi, n, status);
		ta.setText(result);

		// 빅데이터 분석
		// 데이터랍시고 구하면 거진 : String 일걸?
		System.out.println(nameTF.getText());
		System.out.println(heightTF.getText());
		System.out.println(weightTF.getText());

	}

}
