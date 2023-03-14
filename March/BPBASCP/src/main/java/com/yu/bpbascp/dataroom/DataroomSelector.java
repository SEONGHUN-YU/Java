package com.yu.bpbascp.dataroom;

public class DataroomSelector {
	private int start;
	private int end;

	public DataroomSelector() {
	}

	public DataroomSelector(int start, int end) {
		super();
		this.start = start;
		this.end = end;
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
