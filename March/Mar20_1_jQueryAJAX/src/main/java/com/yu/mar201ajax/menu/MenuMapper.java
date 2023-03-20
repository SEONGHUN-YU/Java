package com.yu.mar201ajax.menu;

import java.util.List;

public interface MenuMapper {
	public abstract List<Menu> get();
	public abstract int reg(Menu m);
	public abstract List<Menu> search(Menu m);
}
