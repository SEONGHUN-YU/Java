<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="snsControlArea">
		<tr>
			<td align="center">
				<form name="snsPostWriteForm" onsubmit="return snsPostWriteCheck();"
					action="sns.post.write">
					<table id="snsControlArea2">
						<tr>
							<td><textarea name="bs_txt" maxlength="250"></textarea><br></td>
							<td><button>쓰기</button></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>