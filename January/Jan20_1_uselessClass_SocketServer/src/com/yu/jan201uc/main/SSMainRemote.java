package com.yu.jan201uc.main;

import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

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

public class SSMainRemote {
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


			Robot r = new Robot();
			String data = null;
			String[] data2 = null;
			while (true) {
				data = br.readLine();
				if (data.equals("l")) {
					r.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
					r.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
				} else if (data.equals("r")) {
					r.mousePress(MouseEvent.BUTTON3_DOWN_MASK);
					r.mouseRelease(MouseEvent.BUTTON3_DOWN_MASK);
				} else { // 120,32
					data2 = data.split(",");
					int x = Integer.parseInt(data2[0]);
					int y = Integer.parseInt(data2[1]);
					r.mouseMove(x, y);
				}
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
