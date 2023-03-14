<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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