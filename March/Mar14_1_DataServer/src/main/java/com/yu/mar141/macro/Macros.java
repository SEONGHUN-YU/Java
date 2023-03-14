package com.yu.mar141.macro;

import java.util.List;

public class Macros {
	private List<Macro> macro; // 단수형 네이밍 추천

	public Macros() {
	}

	public Macros(List<Macro> macro) {
		super();
		this.macro = macro;
	}

	public List<Macro> getMacro() {
		return macro;
	}

	public void setMacro(List<Macro> macro) {
		this.macro = macro;
	}
}
