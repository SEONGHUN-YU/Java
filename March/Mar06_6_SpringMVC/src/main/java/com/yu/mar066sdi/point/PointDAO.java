package com.yu.mar066sdi.point;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

public class PointDAO {
	private double pointRate;

	public double getPointRate() { // 이제부터 하려는 작업에 getter는 필요없긴하다
		return pointRate;
	}

	public void setPointRate(double pointRate) {
		this.pointRate = pointRate;
	}

	public void calculate(PointInfo obj, HttpServletRequest req) {
		obj.setPoint(obj.getMoney() / 100 * pointRate);
		req.setAttribute("result", obj);
	}
}
