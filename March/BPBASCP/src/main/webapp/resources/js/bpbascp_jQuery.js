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
	// $(".snsUpdateBtn").click(function() { // jQuery말고 JavaScript로 처리해야 하는 상황이
	// 와서, 지워둠
	// $("#popupArea").css("top", "0px").css("left", "0px");
	// $("#popupArea").css("opacity", "1");
	// });

	$("#suaCloseBtn").click(function() {
		$("#popupArea").css("opacity", "0");
		setTimeout(function() {
			$("#popupArea").css("top", "-100%").css("left", "-100%");
		}, 300);
	});
}

function connectJoinIDKeyEvent() {
	$("#regID").keyup(function(e) {
		var id = $(this).val();
		$.getJSON("member.id.check?bm_id=" + id, function(data) {
			if (data.member[0] == null) { // 조회했을 때 안 나오면 통과
				$("#regID").css("color", "white");
			} else {
				$("#regID").css("color", "red");
			}
		});
	});
}

function connectAddressSearchSummonEvent() {
	$("#regAddr1, #regAddr2").click(function() {
		new daum.Postcode({
			oncomplete : function(data) {
				$("#regAddr1").val(data.zonecode); // 우편번호
				$("#regAddr2").val(data.roadAddress); // 도로명주소
			}
		}).open();
	});
}

$(function() {
	connectMenuSummonEvent();
	connectSNSControlAreaSummonEvent();
	connectSNSUpdateFormSummonEvent();
	connectJoinIDKeyEvent();
	connectAddressSearchSummonEvent();
});