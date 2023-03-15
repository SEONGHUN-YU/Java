<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>빅데이터 플랫폼 기반 AI 융합 서비스 개발자 양성과정 카페</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/member.css">
<link rel="stylesheet" href="resources/css/sns.css">
<link rel="stylesheet" href="resources/css/dataroom.css">
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/YUValidChecker.js"></script>
<script type="text/javascript" src="resources/js/bpbascpCheck.js"></script>
<script type="text/javascript" src="resources/js/bpbascpMove.js"></script>
<script type="text/javascript" src="resources/js/bpbascp_jQuery.js"></script>
</head>
<body>
	<div id="result">${result }</div>
	<table id="siteTitleArea">
		<tr>
			<td>
				<table id="siteMenuArea">
					<tr>
						<td><jsp:include page="${loginPage }"></jsp:include></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table id="siteTitleArea2">
					<tr>
						<td><a href="index.go">빅데이터 플랫폼 기반 AI 융합 서비스 개발자 양성과정 카페</a></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="siteContentArea">
		<tr>
			<td align="center"><jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>