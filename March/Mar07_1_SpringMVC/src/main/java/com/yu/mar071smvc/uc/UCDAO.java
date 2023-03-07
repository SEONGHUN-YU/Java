package com.yu.mar071smvc.uc;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.http.HttpServletRequest;

// Spring :
//			beans.xml에 객체 만들어놓고
//			.java에서는 불러오기만

//			servlet-context.xml이 beans.xml역할을 한다
//			aac방식으로 불러오는 중

// servlet-context.xml에 등록시켜주는 역할
// @Service <- 필드 ArrayList에 값을 넣어줘야 해서 안녕... 
public class UCDAO {
	private ArrayList<ArrayList<String>> data; // 단위들과 계산식 넣을 리스트 ex) cm, x*0.3937, inch
	private ScriptEngine se;

	public UCDAO() {
		ScriptEngineManager sem = new ScriptEngineManager();
		se = sem.getEngineByName("JavaScript");
	}

	public void setData(ArrayList<ArrayList<String>> data) {
		this.data = data;
	}

//			String cmI = String.format("%f * %f * 0.3937", n, n);
//			String.format()을 쓰면 문제가 생김, .replace()로 유동적으로 대응 가능
	public void calculate(double n, HttpServletRequest req) {
		try {
			ArrayList<UCDTO> result = new ArrayList<UCDTO>();
			UCDTO ucdto = null;
			for (ArrayList<String> al : data) {
				ucdto = new UCDTO();
				ucdto.setFrom(al.get(0));
				ucdto.setResult((Double) se.eval(al.get(1).replace("x", n + "")));
				ucdto.setTo(al.get(2));
				result.add(ucdto);
//				result.add(new UCDTO(al.get(0), (Double) se.eval(al.get(1).replace("x", n + "")), al.get(2)));
			}

//			String cm_Inch = "x * 0.3937".replace("x", n + "");
//			double cm_Inch_r = (Double) se.eval(cm_Inch);
//			String square_Feet = "x * 0.3025".replace("x", n + "");
//			double square_Feet_r = (Double) se.eval(square_Feet);
//			result.add(new UCDTO("cm", cm_Inch_r, "inch"));
//			result.add(new UCDTO("㎡", square_Feet_r, "평"));
			req.setAttribute("result", result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
