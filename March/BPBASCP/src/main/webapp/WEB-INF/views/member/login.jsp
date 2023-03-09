<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" onsubmit="return loginCheck();" action="member.login" method="post"> <%-- 여기 안 함 --%>
		<input class="loginInput" placeholder="ID" name="bm_id" maxlength="10" autocomplete="off">
		<input class="loginInput" placeholder="PW" name="bm_pw" type="password" maxlength="10">
		<button class="loginBtn">로그인</button>
		<a href="member.reg.go" class="loginBtn">회원가입</a>
	</form>
</body>
</html>