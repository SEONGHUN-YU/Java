package com.yu.jan131oop.main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

// part1 : PP
// part2 : OOP
// 요 사이에 문법파트 하나 있긴 하다!?
// part3 : 유용한 클래스

// JFrame은(머하는용?) 빅데이터에 안 유용함...
// Robot도(매크로용)...

public class OOPMain3 {
	public static void main(String[] args) throws AWTException, InterruptedException {
		// 로본 기본생성
		Robot r = new Robot();
		r.mouseMove(1000, 500);
		r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
		r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(200);

		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
		Thread.sleep(100);
		r.keyPress(KeyEvent.VK_B);
		r.keyRelease(KeyEvent.VK_B);

		// 마우스를 1900,0으로 옮기기
//		r.mouseMove(0, 1080);
//		r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//		r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
//		Thread.sleep(200);
//		r.mouseMove(0, 1000);
//		r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
//		r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
	}
}
