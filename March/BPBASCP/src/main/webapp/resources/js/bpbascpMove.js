function bye() {
	if (confirm("진짜?")) {
		location.href = "member.bye";
	}
}

function snsPageMove(curPage) {
	location.href = "sns.page.move?p=" + curPage;
}

function snsPostDelete(bs_no) {
	if (confirm("삭제하시겠습니까?")) {
		location.href = "sns.post.delete?bs_no=" + bs_no;
	}
}

function drPageMove(curPage) {
	location.href = "dataroom.page.move?p=" + curPage;
}

function showSnsUpdatePopup(bs_no, bs_txt) {
	// Java : replace - 다 바뀜
	// JavaScript : replace - 첫번째 것만 바뀜
	// bs_txt = bs_txt.replcace("<br>", "\r\n"); <- 하나만 바뀜
	bs_txt = bs_txt.replace(/<br>/g, "\r\n"); // 다 바뀌게 하려면 정규식
	$("#snsUpdateBsNo").val(bs_no);
	$("#snsUpdateBsTxt").val(bs_txt);
	$("#popupArea").css("top", "0px").css("left", "0px");
	$("#popupArea").css("opacity", "1");
}