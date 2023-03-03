package com.yu.mar031jspmb.snack;

// select해서 -> SnackSelector으로 만들자 - X, 조회용 DTO가 아님
public class SnackSelector {
	private String search;
	private int start;
	private int end;

	public SnackSelector() {
	}

	public SnackSelector(String search, int start, int end) {
		super();
		this.search = search;
		this.start = start;
		this.end = end;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
}
