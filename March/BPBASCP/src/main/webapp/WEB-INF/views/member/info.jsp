<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="memberUpdateForm" onsubmit="return memberUpdateCheck();" action="member.info.update" method="post" enctype="multipart/form-data">
		<table id="regTbl">
			<tr>
				<th colspan="2">${sessionScope.loginMember.bm_id }</th>
			</tr>
			<tr>
				<td class="td1">PW</td>
				<td align="center"><input name="bm_pw" placeholder="PW" autocomplete="off" value="${sessionScope.loginMember.bm_pw }"></td>
			</tr>
			<tr>
				<td class="td1">PW확인</td>
				<td align="center"><input name="bm_pwChk" placeholder="PW확인" autocomplete="off" value="${sessionScope.loginMember.bm_pw }"></td>
			</tr>
			<tr>
				<td class="td1">이름</td>
				<td align="center"><input name="bm_name" placeholder="이름" autocomplete="off" value="${sessionScope.loginMember.bm_name }"></td>
			</tr>
			<tr>
				<td class="td1">생일</td>
				<td align="center">
					<fmt:formatDate value="${sessionScope.loginMember.bm_birthday }" type="date" dateStyle="long"/>
				</td>
			</tr>
			<tr>
				<td class="td1">주소</td>
				<td align="center">
					<input name="bm_addr1" value="${addr1 }"><br>
					<input name="bm_addr2" value="${addr2 }"><br>
					<input name="bm_addr3" value="${addr3 }"><br>
				</td>
			</tr>
			<tr>
				<td class="td1">사진</td>
				<td align="center">
				<img id="memberInfoImg" src="resources/img/${sessionScope.loginMember.bm_photo }">
				<input type="file" name="bm_photo"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button>수정</button>
					<div onclick="bye();">탈퇴</div>>
					<%-- 
					<a href="member.bye?bm_id=${sessionScope.loginMember.bm_id }">탈퇴하기</a> 
						보안이 안 좋음	
					--%>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>