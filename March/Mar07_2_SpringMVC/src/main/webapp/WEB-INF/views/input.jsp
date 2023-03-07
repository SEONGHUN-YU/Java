<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="unit.convert">
		<input name="num"><br>
		<input type="radio" name="what" checked="checked" value="len">cm -> inch<br>
		<input type="radio" name="what" value="size">㎡ -> 평<br>
		<button>변환</button>
	</form>
</body>
</html>