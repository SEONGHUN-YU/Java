package com.yu.jan251uc.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

// 1호선 이용객 
// 2호선
// 3호선
// ...

public class UCMain8 {
	public static void main(String[] args) {

		BufferedReader br = null;
		try {
			// 읽어오기
			FileInputStream fis = new FileInputStream("D:\\yu\\subway.csv");
			InputStreamReader isr = new InputStreamReader(fis, "utf-8");
			br = new BufferedReader(isr);

			HashMap<String, Long> hm = new HashMap<>();

			String line = null;
			String[] line2 = null;
			long sum = 0;
			while ((line = br.readLine()) != null) {
				line2 = line.split(",");
				sum = Long.parseLong(line2[5]) + Long.parseLong(line2[6]); // 이용객 수
				if (!hm.containsKey(line2[3])) { // 1호선이라는 key가 있나? 없어, 이 때는 넣는다
					hm.put(line2[3], sum); // 없으면 넣기
				} else {
					hm.put(line2[3], sum + hm.get(line2[3])); // 기존에 더한다
				}
			}

			Set<String> lines = hm.keySet(); // 이 상태로는 못 쓰니까 list로 옮긴다
			ArrayList<String> al = new ArrayList<>(lines);
			al.sort(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.compareTo(o2);
				}
			});
			for (String s : al) {
				System.out.println(s + " : " + hm.get(s));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close(); // 닫아주기
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
