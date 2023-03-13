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
	<c:if test="${page != 1 }">
		<div class="snsL" onmouseleave="snsPageChange(${page - 1 });"></div>
	</c:if>
	<c:if test="${page != pageCount }">
		<div class="snsR" onmouseleave="snsPageChange(${page + 1 });"></div>
	</c:if>
	<c:forEach var="f" items="${files }">
		<table class="aDRFile">
			<tr>
				<td rowspan="4" align="center" class="imgTd" valign="top">
					<img src="resources/img/${f.bm_photo }">
				</td>
				<td class="idTd">${f.bd_uploader }</td>
			</tr>
			<tr>
				<td align="right" class="dateTd">
					<fmt:formatDate value="${f.bd_date }" type="date" dateStyle="long"/>
				</td>
			</tr>
			<tr>
				<td class="txtTd">
					<%-- a태그는 get방식요청이라는 거고, 주소만 알면 로그인 안 해도 된다?? --%>
					<%-- 링크만 알면 뚫린다는 소린데, 아무나 받지 못하게 해야할 것 --%>
					<a href="resources/dataroom/${f.bd_file }">다운받기</a>
				</td>
			</tr>
			<c:if test="${sessionScope.loginMember.bm_id == f.bd_uploader }">
				<tr>
					<td align="right" colspan="2" class="buttonTd">
						<button>수정</button>
						<button onclick="snsPostDelete(${p.bs_no});">삭제</button>
					</td>
				</tr>
			</c:if>
		</table>
	</c:forEach>
	<div id="snsPaddingBottom"></div>
	<table id="drControlArea">
		<tr>
			<td align="center">
				<form onsubmit="return drUploadCheck(this);"
					action="dataroom.upload" method="post" enctype="multipart/form-data">
					<input name="token" value="${token }" type="hidden">
					<table id="drControlArea2">
						<tr>
							<td>
							<input name="bd_title" maxlength="30" placeholder="제목" autocomplete="off">
							<input name="bd_file" type="file">
							</td>
							<td><button>업로드</button></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>