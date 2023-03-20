<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	
	function getProduct(page) {
		$.getJSON("product.get.json?page=" + page, function(pd) { // getJSON은 parameter에 직접 씀
			$.each(pd.product, function(i, p) {
				var ntd = $("<td></td>").text(p.p_name);
				var ptd = $("<td></td>").text(p.p_price);
				var tr = $("<tr></tr>").append(ntd, ptd);
				$("table").append(tr);
			});
		});
	}

	$(function() {
		// XML -굳이?-> JSON -좋음-> JSON이 요즘 주력
		
		/* $.ajax({ #1 기본 통신방법
			url : "product.get.json",
			data : {page : 1}
			success : function(pd) { // JSON.stringify(pd);
				$.each(pd.product, function(i, p) {
					var ntd = $("<td></td>").text(p.p_name);
					var ptd = $("<td></td>").text(p.p_price);
					var tr = $("<tr></tr>").append(ntd, ptd);
					$("table").append(tr);
				});
			}
		}); */
		
		// $.getJSON("전체주소", function(받아온 거) { #2 JSON일 때만 쓸 수 있는 문법
		//	
		// });
		
		var page = 1;
		getProduct(page);
		$(window).scroll(function() { // 스크롤 하면 쿼리날려서 밑에 붙이기
			if ($(document).height() == $(window).height() + $(window).scrollTop()) {
				page++;
				getProduct(page);
			}
		});
	});
</script>
<style type="text/css">
td {
	height: 100px;
}
</style>
</head>
<body>
	<table border="1"></table>
	<%-- 
	<c:forEach var="p" items="${products }">
		${p.p_name }<br>
		${p.p_price }<br>
	</c:forEach>
	--%>
</body>
</html>