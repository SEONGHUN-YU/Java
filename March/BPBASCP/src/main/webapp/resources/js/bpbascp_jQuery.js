function connectMenuSummonEvent() {
	$("#siteTitleArea").mouseenter(function() { // 마우스가 범위 안으로 들어갈 때
		$("#siteTitleArea").css("top", "0px");
	});

	$("#siteTitleArea").mouseleave(function() { // 마우스가 범위안에서 밖으로 나갈 때
		$("#siteTitleArea").css("top", "-60px");
	});
}

function connectSNSControlAreaSummonEvent() {
	$("#snsHandle").click(function() {
		var scaBottom = $("#snsControlArea").css("bottom");
		if (scaBottom == "-255px") {
			$("#snsControlArea").css("bottom", "0px");
		} else {
			$("#snsControlArea").css("bottom", "-255px");
		}
	});
}

function connectSNSUpdateFormSummonEvent() {
	$(".snsUpdateBtn").click(function() {
		$("#popupArea").css("top", "0px").css("left", "0px");
		$("#popupArea").css("opacity", "1");
	});
}

$(function() {
	connectMenuSummonEvent();
	connectSNSControlAreaSummonEvent();
	connectSNSUpdateFormSummonEvent();
});