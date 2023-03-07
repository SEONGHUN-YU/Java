<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/index.css">
<script type="text/javascript" src="resources/js/YUValidChecker.js"></script>
<script type="text/javascript" src="resources/js/check.js"></script>
</head>
<body>
	<form name="f" onsubmit="return check();" action="input.in">
		<input name="value" placeholder="숫자" autofocus="autofocus" autocomplete="off"><br>
		<button>변환</button>
	</form>
</body>
</html>