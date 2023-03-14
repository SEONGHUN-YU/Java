package com.yu.mar141.print;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Presents { // 데이터 여러개 (테이블을 표현하는 JavaBean)
	// 단수형 이름 추천
	// private List<PresentBean> presents;
	private List<PresentBean> present; // 이렇게 단수형으로 네이밍하는 걸 추천

	public Presents() {
	}

	public Presents(List<PresentBean> present) {
		super();
		this.present = present;
	}

	public List<PresentBean> getPresent() {
		return present;
	}
	
	@XmlElement
	public void setPresent(List<PresentBean> present) {
		this.present = present;
	}
}
