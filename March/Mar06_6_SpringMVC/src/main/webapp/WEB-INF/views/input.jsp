<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/mar066.css">
<script type="text/javascript" src="resources/js/YUValidChecker.js"></script>
<script type="text/javascript" src="resources/js/check.js"></script>
</head>
<body>
	<form name="f" onsubmit="return check();" action="point.calculate" method="post">
		<input name="name"><br>
		<input name="money"><br>
		<button>계산</button><br>
	</form>
</body>
</html>