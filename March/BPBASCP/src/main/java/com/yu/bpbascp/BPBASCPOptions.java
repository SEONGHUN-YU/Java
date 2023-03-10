package com.yu.bpbascp;

// 이 사이트에 뭐 유지보수당할만 한 거
public class BPBASCPOptions {
	private int snsPostPerPage; // 한 페이지당 sns포스트 수
	private int dataroomFilePerPage; // 한 페이지당 자료실 파일 수
	// ...

	public BPBASCPOptions() {
	}

	public BPBASCPOptions(int snsPostPerPage, int dataroomFilePerPage) {
		super();
		this.snsPostPerPage = snsPostPerPage;
		this.dataroomFilePerPage = dataroomFilePerPage;
	}

	public int getSnsPostPerPage() {
		return snsPostPerPage;
	}

	public void setSnsPostPerPage(int snsPostPerPage) {
		this.snsPostPerPage = snsPostPerPage;
	}

	public int getDataroomFilePerPage() {
		return dataroomFilePerPage;
	}

	public void setDataroomFilePerPage(int dataroomFilePerPage) {
		this.dataroomFilePerPage = dataroomFilePerPage;
	}
}
