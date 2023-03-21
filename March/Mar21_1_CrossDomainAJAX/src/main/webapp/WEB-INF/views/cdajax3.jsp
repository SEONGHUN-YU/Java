<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script type="text/javascript" src="resources/StudyKey.js"></script>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script type="text/javascript">
	$(function() {
		/* $.ajax({
			url : "주소만",
			data : { 파라메터명 : 값, ...},
			beforeSend : function(요청객체) {
				요청객체.setRequestHeader("제목", "값");
				요청객체.setRequestHeader("제목", "값");
				...
			},
			success : function(받아온 객체) {
				...
			}
		}); */
		
		var slider = $('.slider').bxSlider({ // src를 import하는 위치가 중요, 무조건 jQuery보다 밑에 둘 것
						 mode: 'fade',
			      		 captions: true,
			   			 slideWidth: 600
					 });
		$("input").keyup(function(e) {
			var search = $(this).val();
			$.ajax({
				url : "https://dapi.kakao.com/v2/search/image", // Host + GET
				data : { query : search },
				beforeSend : function(req) {
					req.setRequestHeader("Authorization", "KakaoAK " + StudyKey_Kakao_rest());
				},
				success : function(imgData){
					$(".slider").empty();
					/* var imgArr = imgData.documents;
					for (var i = 0; i < imgArr.length; i++){ // JS for문으로 해도 되긴 함
						var imgUrl = $(d[i].image_url).text();
					} */
					$.each(imgData.documents, function(i, p) { // jQuery for문으로 처리
						var iDiv = $("<div></div>").append($("<img>").attr("src", p.image_url));
						$(".slider").append(iDiv);
					});
					slider.reloadSlider(); // 위치가 중요
				}
			});
		});
	});
</script>
</head>
<body>
	<input>
	<hr>
	<div class="slider">
    </div>
</body>
</html>