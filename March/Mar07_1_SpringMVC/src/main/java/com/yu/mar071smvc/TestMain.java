package com.yu.mar071smvc;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class TestMain {
	public static void main(String[] args) {
		try {
			ScriptEngineManager sem = new ScriptEngineManager();
			ScriptEngine se = sem.getEngineByName("JavaScript");
			int ans = (Integer) se.eval("10+2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
