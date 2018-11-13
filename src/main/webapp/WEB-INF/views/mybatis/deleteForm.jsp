<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>delete</h2>
<form action="deleteReg">
	<table border="">
		<tr>
			<td>암호</td>
			<td>
			<input type="hidden" name="id" value="${param.id }" />
			<input type="text" name="pw" /></td>
		</tr>
		<td colspan="2" align="right">
			<a href="detail?id=${param.id }">뒤로</a>
			<input type="reset" value="초기화" />
			<input type="submit" value="삭제" />
		</td>
	</table>
</form>

</body>
</html>