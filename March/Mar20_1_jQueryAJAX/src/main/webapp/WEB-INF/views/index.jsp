<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="index.go">홈</a><br>
	<a href="output.go">XML 출력가기</a><br>
	<a href="outputjson.go">JSON 출력가기</a><br>
	<jsp:include page="${cp }"></jsp:include>
</body>
</html>