package com.yu.mar201ajax.menu;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Menus {
	private List<Menu> menu;

	public Menus() {
	}

	public Menus(List<Menu> menu) {
		super();
		this.menu = menu;
	}

	public List<Menu> getMenu() {
		return menu;
	}

	@XmlElement
	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
}
