<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="welcomeTbl">
		<tr>
			<td class="td1">
				&nbsp;<a href="sns.go"> <%-- 누르면 게시판 가기? --%>
					<img src="resources/img/feed.png">
				</a>&nbsp;&nbsp;
				<a href="">
					<img src="resources/img/folder.png">
				</a>&nbsp;
			</td>
			<td align="right" class="td2">
				<table>
					<tr>
						<td><img src="resources/img/${sessionScope.loginMember.bm_photo }"></td>
						<td valign="top">
							&nbsp;${sessionScope.loginMember.bm_id }&nbsp;
							<a href="member.info.go" class="loginBtn">회원정보</a>
							<a href="member.logout" class="loginBtn">로그아웃</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>