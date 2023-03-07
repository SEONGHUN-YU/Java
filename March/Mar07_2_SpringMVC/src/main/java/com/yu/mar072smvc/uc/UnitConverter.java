package com.yu.mar072smvc.uc;

import java.util.ArrayList;
import java.util.HashMap;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;

//@Service // servlet-context.xml에 뭐 하면 이거 못 씀, 지금은 뭘 쓸거라서 @Service 사용 불가능
public class UnitConverter { // DAO

	// 다 -> for -> List
	// size에 해당하는 것만 ->
	private HashMap<String, ArrayList<String>> data;
	private ScriptEngine se;

	public UnitConverter() {
	}

	public UnitConverter(HashMap<String, ArrayList<String>> data) {
		this.data = data;
		ScriptEngineManager sem = new ScriptEngineManager();
		se = sem.getEngineByName("JavaScript");
	}

	public void convert(UCBean b, HttpServletRequest req) {
		try {
			ArrayList<String> al = data.get(b.getWhat());
			
			b.setFrom(al.get(0));
			
			String calc = al.get(1).replace("x", b.getNum() + "");
			double result = (Double) se.eval(calc);
			b.setResult(result);

			b.setTo(al.get(2));
			
			req.setAttribute("ucb", b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
