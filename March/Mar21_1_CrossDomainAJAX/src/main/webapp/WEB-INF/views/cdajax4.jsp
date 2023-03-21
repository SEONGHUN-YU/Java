]<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/StudyKey.js"></script>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=33090d421560a1bb97d24844a5b4b1ba"></script>
<script type="text/javascript">
	function moveMap(x, y) {
		var loc = new kakao.maps.LatLng(y, x);
		map.setCenter(loc);
		marker.setPosition(loc);
		roadviewClient.getNearestPanoId(loc, 50, function(panoId) {
		    roadview.setPanoId(panoId, loc);
		});
	}
	
	var lat = 0, lng = 0;
	var map = null, marker = null;
	var roadview = null, roadviewClient = null;
	$(function() {
		// HTML5에 클라이언트의 위치 받는 기능이 추가됨
		//		GPS있는 기계로 이 사이트에 접속했으면 : GPS로 해줌
		//		GPS없는 기계로 이 사이트에 접속했으면 : IP주소로 해줌
		navigator.geolocation.getCurrentPosition(function(loc) {
			lat = loc.coords.latitude; // 위도 : 30 후반?
			lng = loc.coords.longitude; // 경도 : 120 ~ 130 사이
			var myLocation = new kakao.maps.LatLng(lat, lng); 
			// ---------------------------------------------------
			var container = document.getElementById('map');
			var options = {
				center: myLocation,
				level: 3
			};
			map = new kakao.maps.Map(container, options);
			// ---------------------------------------------------
			marker = new kakao.maps.Marker({ // 마커
			    position: myLocation
			});
			marker.setMap(map);
			// ---------------------------------------------------
			var roadviewContainer = document.getElementById('roadview');
			roadview = new kakao.maps.Roadview(roadviewContainer);
			roadviewClient = new kakao.maps.RoadviewClient(); // manager 느낌
			
			// 내 위치 근처 50미터 이내의 사진찍은 포인트 번호 받기 (seq로 추측됨)
			roadviewClient.getNearestPanoId(myLocation, 50, function(panoId) {
			    roadview.setPanoId(panoId, myLocation);
			});
		});
		
		$("input").keyup(function(e) {
			var txt = $(this).val();
			// 원래는 인터넷 주소에 한글 ㅋ -> %2A(URL인코딩) 해줘야하는데 kakao는 자동으로 해줌
			// 만약 필요하다면,
			// txt = encodeURIComponent(txt); 해주어야 함 <- 알아두면 좋을 듯
			$.ajax({
				url : "https://dapi.kakao.com/v2/local/search/keyword.json",
				data : { query : txt, x : lng, y : lat, radius : 3000, sort : "distance" }, // 현재 위치를 기준으로 3km이내를 찾기
				beforeSend : function(req) {
					req.setRequestHeader("Authorization", "KakaoAK " + StudyKey_Kakao_rest());
				},
				success : function(searchData) {
					$.each(searchData.documents, function(i, 소름) {
						$("#t").empty();
						var p = $("<td></td>").text(소름.place_name);
						var d = $("<td></td>").text(소름.distance);
						var a = $("<td></td>").text(소름.road_address_name);
						var n = $("<td></td>").text(소름.phone);
						$("#t").append($("<tr></tr>").attr("onclick", "moveMap(+" + 소름.x +", " + 소름.y + ");").append(p, d, a, n));
					});
				}
			});
		});
	});
</script>
</head>
<body>
	<table>
		<tr>
			<td>
				<div id="map" style="width:500px;height:400px;"></div>
			</td>
			<td>
				<div id="roadview" style="width:500px;height:400px;"></div>
			</td>
		</tr>
	</table>
	<input>
	<hr>
	<table id="t" border="1"></table>
</body>
</html>