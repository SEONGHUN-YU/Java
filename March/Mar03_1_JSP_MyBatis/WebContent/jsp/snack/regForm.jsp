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
	<form action="SnackRegController">
		<input name="name" placeholder="이름"><br>
		<input name="price" placeholder="가격"><br>
		<input name="date" placeholder="소비기한"><br>
		<button>등록</button>
	</form>
</body>
</html>