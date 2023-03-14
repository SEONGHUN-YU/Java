<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="index.go">인덱스로 가기</a>
	<a href="output.go">출력가기</a>
	<a href="macro.get.json">json용 출력 보러가기</a>
	<jsp:include page="${contentPage }"></jsp:include>
</body>
</html>