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
<h1>GET</h1>
<form action="" method="post">
	<table border="">
		<tr>
			<td>id</td>
			<td>제품명</td>
			<td>수량</td>
			<td>가격</td>
		</tr>
<c:forEach var="i" begin="0" end="3">		
		<tr>
			<td><input type="text" name="proList[${i }].id" /></td>
			<td><input type="text" name="proList[${i }].name" /></td>
			<td><input type="text" name="proList[${i }].cnt" /></td>
			<td><input type="text" name="proList[${i }].price" /></td>
		</tr>
</c:forEach>
		<tr>
			<td rowspan="3">배송지</td>
			<td>우편번호</td>
			<td><input type="text" name="addr.zipcode" /></td>
		</tr>
		<tr>
			<td>기본주소</td>
			<td><input type="text" name="addr.addr1" /></td>
		</tr>
		<tr>
			<td>상세주소</td>
			<td><input type="text" name="addr.addr2" /></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="submit" value="결재" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>