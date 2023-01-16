package com.yu.jan161uc.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Python : 전체를 읽어서 저장해놓는 특징이 있음 -> 파일이 1TB면 어쩔려고?
public class UCMain3 {
	public static void main(String[] args) {

		BufferedReader br = null;
		try {
			FileReader fr = new FileReader("D:\\yu\\a.txt");
			// ↑ InputStreamReader의 개조형 : 파일 작업하기 편하게 개조한 애
			br = new BufferedReader(fr);

			String line = null;

			while ((line = br.readLine()) != null) { // 평소엔 조건 거의 안 쓰는데 파일 읽을 때는 while문에 조건을 쓰는 불문율이 있음
				// .readLine() <- 더 이상 읽을 게 없으면 null이 나온다
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
