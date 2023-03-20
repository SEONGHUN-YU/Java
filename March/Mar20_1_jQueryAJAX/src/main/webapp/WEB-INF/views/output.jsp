<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">

	function getMenu() {
		$.ajax({
			url : "menu.get.xml",
			success : function(menuData) { // firstclass
				$("table").empty();
				$(menuData).find("menu").each(function(i, p) { // parameter의 p를 빼고 $(this)로 해도됨
					var name = $(p).find("m_name").text();
					var price = $(p).find("m_price").text();
					var nameTd = $("<td></td>").text(name);
					var priceTd = $("<td></td>").text(price);
					var tr = $("<tr></tr>").append(nameTd, priceTd);
					$("table").append(tr);
				});
			}
		});	
	}
	
	$(function() {
		getMenu(); // 처음에 조회해서 붙이고
		
		$("button").click(function() {
			var n = $("#nInput").val();
			var p = $("#pInput").val();
			
			// $.ajax({
			// url : "주소",			
			// data : {파라메터명:값, 파라메터명:값, ...},
			// success : fuction(받아온 거) {
			//
			// }
			// });
				
			$.ajax({
				url : "menu.reg",
				data : { m_name : n, m_price : p },
				success : function(menuResult) {
					alert($(menuResult).text()); // DB에 insert 시킬 때 나오는 문구
					getMenu(); // 추가됐을 때 조회해서 붙이고
				}
			});
			
			$("#nInput").val("");
			$("#pInput").val("");
			$("#nInput").focus();
		});
		
		$("#pInput").keyup(function(e) {
			if (e.keyCode == 13){
				// jQuery에서는, 어떤 이벤트를 강제로 발생시킬 수 있음
				// 이벤트 강제 발생 : $(선택자).trigger("이벤트명");
				$("button").trigger("click");
			}
		});
		
		
		$("#sInput").keyup(function(e) {
			// if (e.keyCode == 13) { 비동기식이라서 글자가 조금이라도 바뀔 때마다 쿼리 쏨 (실시간 느낌?)
				var s = $(this).val();
				$.ajax({
					url : "menu.search",
					data : { m_name : s },
					success : function(searchResult) {
						$("table").empty();
						$(searchResult).find("menu").each(function(i, p) {
							var n = $("<td></td>").text($(p).find("m_name").text());
							var p = $("<td></td>").text($(p).find("m_price").text());
							$("table").append($("<tr></tr>").append(n, p));
						});
					}
				});
			// }
		});
	});
</script>
</head>
<body>
	<input id="nInput" placeholder="이름"><br>
	<input id="pInput" placeholder="가격"><br>
	<button>등록</button>
	<hr>
	<input id="sInput" placeholder="검색"><br>
	<hr>
	<table border="1"></table>
	<%-- 
	<c:forEach var="m" items="${menus }">
		${m.m_name }<br>
		${m.m_price }<br>
	</c:forEach>
	--%>
</body>
</html>