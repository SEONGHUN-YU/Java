<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script type="text/javascript" src="resources/StudyKey.js"></script>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	$(function() {
		// 구별 미세+초미세 합친거 PM10, PM25
		// 단순 크기 비교 -> 막대그래프
		$.ajax({
			url : "http://openapi.seoul.go.kr:8088/"+ StudyKey_Seoul() +"/xml/RealtimeCityAir/1/25/",
			success : function(d) {
				var arr = [], brr = [];
				$(d).find("row").each(function(i, p) {
					arr[i] = { y: $(p).find("PM10").text() * 1, label: $(p).find("MSRSTE_NM").text() };
					brr[i] = { y: $(p).find("PM25").text() * 1, label: $(p).find("MSRSTE_NM").text() };
				});
				var chart = new CanvasJS.Chart("chartContainer",
				    {
				      title:{
				      text: "서울 구별 미세먼지 현황"
				      },
				        data: [
				      {
				        type: "stackedColumn",
				        dataPoints: arr
				      },  {
				        type: "stackedColumn",
				         dataPoints: brr
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
	<div id="chartContainer" style="height: 300px; width: 100%;"></div>
</body>
</html>