<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css">
</head>
<body>
	<c:forEach var="r" items="${result }">
	<h1>
	<fmt:formatNumber value="${param.value }" pattern="#.0"/>
	${r.from } ->
	<fmt:formatNumber value="${r.result }" pattern="#.0"/>
	${r.to }
	</h1>
	</c:forEach>
</body>
</html>