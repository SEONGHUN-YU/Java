package com.yu.jan201uc.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;

//HTTP통신 : 요청/응답
//HTTP서버 : JSP/Spring,...

//Socket통신 : 나는 요청 안 하는데, 상대방한테서 오는 통신(카톡 같은 거)
//Socket서버 : 쓰려면 만들어야 함
//Socket클라이언트 : 이것도 만들어야 함

// 전화하려면 -> 전화번호 - 저장
// 통신하려면 -> IP주소 - DNS서버
// ipconfig 치면 IPv4주소 <-이게 필요
// 포트번호도 필요 0 ~ 65535 중에 골라서 쓰자
// 근데 암묵적인 룰이 있다고 함

// 1. 서버 실행
// 2. 서버 대기시킴
// 3. 클라이언트 실행

// Python 동시에 여러 작업이 없다시피
// Java 괜찮은 수준
// Go 동시 처리작업이 특화됨

public class SSMain {
	public static void main(String[] args) {
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(1234);
			System.out.println("서 : 대기중");
			Socket s = ss.accept();
			System.out.println("서 : 누가 접속함");

			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);

			OutputStream os = s.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			BufferedWriter bw = new BufferedWriter(osw);

			Thread t = new Thread() {
				@Override
				public void run() {
					super.run();
					JFrame jf = new JFrame();
					JTextArea jta = new JTextArea();
					jf.add(jta);
					jf.setSize(300, 500);
					jf.setVisible(true);
					while (true) {
						try {
							jta.append(br.readLine() + "\r\n"); // 상대방이 보낸 거 받아서 출력
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			};
			t.start();

			Scanner k = new Scanner(System.in);
			while (true) {
				System.out.println("서버 말 : ");
				String txt = k.next(); // 입력한 글자 받아와서 txt에 저장하기
										// 입력을 안 했다면 멈춰있음

				bw.write(txt + "\r\n"); // br.readline() <- 엔터로 줄 바뀔 때까지 읽는다
				bw.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			ss.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
