package com.yu.jan161uc.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class UCMain5 {
	public static void main(String[] args) {

		BufferedReader br = null;
		try {
			FileInputStream fis = new FileInputStream("D:\\yu\\b.txt");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			String line = null;

			while ((line = br.readLine()) != null) {
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
