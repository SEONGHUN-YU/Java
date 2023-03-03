<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%--
	css/js/이미지 등등 V쪽에서 쓰는 대부분 것들의 경로가 Controller 기준으로 먹힌다
 --%>
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<jsp:include page="${cp }"></jsp:include>
	${result }<br>
	<c:forEach var="s" items="${snacks }">
		${s.s_no }<br>
		${s.s_name }<br>
		<fmt:formatNumber value="${s.s_price }" type="number"/><br>
		<fmt:formatDate value="${s.s_exp }" type="date"/><hr>
	</c:forEach>
	<c:if test="${curPage != 1 }">
		<a href="SnackPageController?p=${curPage - 1 }">&lt;</a>
	</c:if>
	<c:if test="${curPage != pageCount }">
		<a href="SnackPageController?p=${curPage + 1 }">&gt;</a>
	</c:if>
</body>
</html>