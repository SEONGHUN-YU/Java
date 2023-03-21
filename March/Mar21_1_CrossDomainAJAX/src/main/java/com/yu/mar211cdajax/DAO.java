package com.yu.mar211cdajax;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

@Service
public class DAO {
	public String get() {
		HttpsURLConnection huc = null;
		try {
			huc = (HttpsURLConnection) new URL("https://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1168064000")
					.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(huc.getInputStream(), "utf-8"));
			StringBuffer sb = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			huc.disconnect();
		}
	}
}
