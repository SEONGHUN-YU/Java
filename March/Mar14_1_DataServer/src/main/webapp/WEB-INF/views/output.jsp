<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	$(function() {
		// AJAX(Asynchronous Javascript And Xml)
		//		비동기식 통신 수행해서, JavaScript로 XML파싱
		//		브라우저의 동일출처정책 -> 외부 XML 못 가져옴
		//		JavaScript/jQuery : event-driven programming
		//							콜백함수 위주로 되어있음
//		$("#b1").click(function() {
		setInterval(function() {
			$.ajax({
				url : "manager.request.get",
				success : function(firstclass) {
					$("table").empty();
					$(firstclass).find("present").each(function(i, p) {
						var n = $(p).find("mr_name").text();
						var p = $(p).find("mr_price").text();
						var ntd = $("<td></td>").text(n);
						var ptd = $("<td></td>").text(p);
						var tr = $("<tr></tr>").append(ntd, ptd);
						$("table").append(tr);
					});
				}
			});
		}, 1000);
//		});
		$("#b2").click(function() {
			$.ajax({
				url : "macro.get.json",
				success : function(firstclass) {
					// 문자열로 바꾸기 : JSON.stringify();
					// alert(JSON.stringify(firstclass));
					$.each(firstclass.macro, function(i, m) {
						var no = $("<td></td>").text(m.bm_no);
						var comment = $("<td></td>").text(m.bm_comment);
						var tr = $("<tr></tr>").append(no, comment);
						$("table").append(tr);
					});
				}
			});
		});
	});
</script>
</head>
<body>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>가격</th>
		</tr>
	</table>
	<hr>
	<button id="b1">xml</button>
	<button id="b2">json</button>
	<hr>
	<c:forEach var="p" items="${presents }">
		${p.mr_name }<br>
		<fmt:formatNumber value="${p.mr_price }"/><br>
	</c:forEach>
	<br>
	<c:forEach var="m" items="${macros }">
		${m.bm_no }<br>
		${m.bm_comment }<br>
	</c:forEach>
</body>
</html>