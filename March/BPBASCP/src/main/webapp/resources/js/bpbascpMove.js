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