package com.yu.jan201uc.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

// IPv4주소
// 127.0.0.1 <- localhost
// "localhost"

// echo서버
public class SCMain {
	public static void main(String[] args) {
		Socket s = null;
		try {
			// s = new Socket("", );
			s = new Socket("192.168.0.148", 8053);
			System.out.println("클 : 접속성공");

			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			BufferedWriter bw = new BufferedWriter(osw);

			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);

			Scanner k = new Scanner(System.in);
			Thread t = new Thread() {
				@Override
				public void run() {
					super.run();
					while (true) {
						try {
							System.out.println("클라 말 : ");
							String txt = k.next();
							bw.write(txt + "\r\n"); // br.readline() <- 엔터로 줄 바뀔 때까지 읽는다
							bw.flush();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			};
			t.start();

			JFrame jf = new JFrame();
			JTextArea jta = new JTextArea();
			jf.add(jta);
			jf.setLocation(300, 0); // 서버 채팅창 옆에 생성되게 해준 것
			jf.setSize(300, 500);
			jf.setVisible(true);
			while (true) {
				jta.append(br.readLine() + "\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
