package com.yu.mar073smmb.menu;

public interface MenuMapper {
	// insert, update, delete : int
	// select : resultType에 맞추면 됨, 객체면 객체, String이면 String, (resultType은 Mapper.xml에 있음)
	public abstract int reg(Menu m);
}
