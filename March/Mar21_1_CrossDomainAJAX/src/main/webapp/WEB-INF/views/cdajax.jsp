<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	$(function() {
		// AJAX : 브라우저의 동일 출처 정책 -> 외부의 데이터는 튕겨냄
		// 그래서 필요하고, 나온 게
		// Cross-Domain AJAX : 외부 데이터를 가져오는 AJAX
		// 연결할 수 있는 방법들
		//		1) 서버측에서 Access-Control-Allow-Origin 헤더 설정을 해둠 <- 연결 가능해짐
		//		2) 서버측에서 안 해놨으면 => proxy 서버 만들어서
		
		// Java에서는 됐었음
		// JavaScript에서 안 되는 중
		
		// queryDFSRSS.jsp : 기상청 서버에 있는 거 -> AJAX 불가능
		// weather.get : 내 프로젝트에 있는 거
		$.ajax({ 
			url : "weather.get",
			success : function(w) {
				var arr = [];
				$(w).find("data").each(function(i, p) {
					if ($(p).find("day").text() == "0") {
						var h = $(p).find("hour").text() + "시까지";
						var t = $(p).find("temp").text() * 1; // String을 Number로 바꿔줌
						var w = $(p).find("wfKor").text();
						
						arr[i] = { label : h, y : t, indexLabel : w };
						
						var hTd = $("<td></td>").text(h);
						var tTd = $("<td></td>").text(t + "℃");
						var wTd = $("<td></td>").text(w);
						$("table").append($("<tr></tr>").append(hTd, tTd, wTd));
					}
				});
				var chart = new CanvasJS.Chart("chartContainer", {
					title:{
						text: "기상청 날씨",
						fontColor: "green"
					},
					data: [              
					{
						type: "line",
						dataPoints: arr
					}
					]
				});
				chart.render();
			}
		});
	});
</script>
</head>
<body>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<hr>
	<table border="1"></table>
</body>
</html>