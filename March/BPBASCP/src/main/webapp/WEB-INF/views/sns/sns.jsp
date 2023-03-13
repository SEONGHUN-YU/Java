<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${page != 1 }">
		<div class="snsL" onmouseleave="snsPageMove(${page - 1 });">&lt;</div>
	</c:if>
	<c:if test="${page != pageCount }">
		<div class="snsR" onmouseleave="snsPageMove(${page + 1 });">&gt;</div>
	</c:if>
	<c:forEach var="p" items="${posts }">
	 <%-- <form action=""> update용도 form --%>
		<table class="aSNSPost">
			<tr>
				<td rowspan="4" align="center" class="imgTd" valign="top"><img
					src="resources/img/${p.bm_photo }"></td>
				<td class="idTd">${p.bm_id }</td>
			</tr>
			<tr>
				<td align="right" class="dateTd"><fmt:formatDate
						value="${p.bs_date }" type="date" dateStyle="long" /></td>
			</tr>
			<tr>
				<td class="txtTd">${p.bs_txt }</td>
			</tr>
			<tr>
				<td class="replyTd">
					<c:forEach var="r" items="${p.bs_replys }"> <%-- 이 부분 중요함 꼭 다시 해볼 것 --%>
						<p style="height: 10px;">
							<span class="replyWriter">${r.bsr_writer }&nbsp;&nbsp;</span>
							${r.bsr_txt } -
							<fmt:formatDate value="${r.bsr_date }" type="date" dateStyle="short"/>
						</p>
					</c:forEach>
					<form action="sns.reply.write" onsubmit="return snsReplyWriteCheck(this);">
						<%-- name="snsReplyWriteForm"을 지워버림, JS 함수로 this(form 자기 자신을 가르킴)을 받아서 넘겨줌 --%>
						<span class="replyWriter">${sessionScope.loginMember.bm_id }&nbsp;</span>
						<input name="token" value="${token }" type="hidden">
						<input name="bsr_bs_no" value="${p.bs_no }" type="hidden">
						<input name="bsr_txt" maxlength="120" class="replyTxt" autocomplete="off">
						<button>댓글쓰기</button>
					</form>
				</td>
			</tr>
			<c:if test="${sessionScope.loginMember.bm_id == p.bm_id }">
			<tr>
				<td align="right" colspan="2" class="buttonTd">
					<button>수정</button>
					<button onclick="snsPostDelete(${p.bs_no });">삭제</button>
				</td>
			</tr>
			</c:if>
		</table>
	<%-- </form> --%>
	</c:forEach>
	<div id="snsPaddingBottom"></div>
	<table id="snsControlArea">
		<tr>
			<td align="center">
				<form name="snsSearchForm" onsubmit="return snsSearchCheck();" action="">
					<table id="snsSearchArea">
						<tr>
							<td>
								<input name="search" maxlength="10" autocomplete="off">
							<td>
							<td>
								<button>검색</button>
							</td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<td align="center">
				<form name="snsPostWriteForm" onsubmit="return snsPostWriteCheck();"
					action="sns.post.write">
					<input name="token" value="${token }" type="hidden">
					<%-- 토큰 숨겨둠 (M - C - V - C - M) 으로 감 --%>
					<table id="snsControlArea2">
						<tr>
							<td><textarea name="bs_txt" maxlength="250"></textarea><br></td>
							<td><button>글쓰기</button></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>