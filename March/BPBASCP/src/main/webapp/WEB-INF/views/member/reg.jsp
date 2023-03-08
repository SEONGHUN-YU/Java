<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="f" onsubmit="return regCheck();" action="member.reg.do" method="post" enctype="multipart/form-data">
		<table id="regTbl">
			<tr>
				<th colspan="2">회원가입</th>
			</tr>
			<tr>
				<td class="td1">ID</td>
				<td align="center"><input name="bm_id" placeholder="ID" autofocus="autofocus" autocomplete="off"></td>
			</tr>
			<tr>
				<td class="td1">PW</td>
				<td align="center"><input name="bm_pw" placeholder="PW" autocomplete="off"></td>
			</tr>
			<tr>
				<td class="td1">PW확인</td>
				<td align="center"><input name="bm_pwChk" placeholder="PW확인" autocomplete="off"></td>
			</tr>
			<tr>
				<td class="td1">이름</td>
				<td align="center"><input name="bm_name" placeholder="이름" autocomplete="off"></td>
			</tr>
			<tr>
				<td class="td1">생일</td>
				<td align="center">
				<%-- <td><input name="bm_birthday" placeholder="생년월일 예시)20230101" maxlength="8"></td> %-->
				<%-- ↑ select or input으로 하면 됨 --%>
					<select name="bm_y">
						<c:forEach var="y" begin="${curYear - 100 }" end="${curYear }">
							<option>${y }</option>
						</c:forEach>
					</select>년&nbsp;&nbsp;
					<select name="bm_m">
						<c:forEach var="m" begin="1" end="12">
							<option>${m }</option>
						</c:forEach>				
					</select>월&nbsp;&nbsp;
					<select name="bm_d">
						<c:forEach var="d" begin="1" end="31">
							<option>${d }</option>
						</c:forEach>				
					</select>일
				</td>
			</tr>
			<tr>
				<td class="td1">주소</td>
				<td align="center">
					<input name="bm_addr1" placeholder="우편번호" autocomplete="off"><br>
					<input name="bm_addr2" placeholder="주소" autocomplete="off"><br>
					<input name="bm_addr3" placeholder="상세주소" autocomplete="off"><br>
				</td>
			</tr>
			<tr>
				<td class="td1">프사</td>
				<td align="center"><input type="file" name="bm_photo" placeholder="사진"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button>가입하기</button></td>
			</tr>
		</table>
	</form>
</body>
</html>