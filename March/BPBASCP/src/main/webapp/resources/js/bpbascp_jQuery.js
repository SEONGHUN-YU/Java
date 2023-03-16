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
//	$(".snsUpdateBtn").click(function() { // jQuery말고 JavaScript로 처리해야 하는 상황이 와서, 지워둠
//		$("#popupArea").css("top", "0px").css("left", "0px");
//		$("#popupArea").css("opacity", "1");
//	});
	
	$("#suaCloseBtn").click(function() {
		$("#popupArea").css("opacity", "0");
		setTimeout(function() {
			$("#popupArea").css("top", "-100%").css("left", "-100%");
		}, 300);
	});
}

$(function() {
	connectMenuSummonEvent();
	connectSNSControlAreaSummonEvent();
	connectSNSUpdateFormSummonEvent();
});