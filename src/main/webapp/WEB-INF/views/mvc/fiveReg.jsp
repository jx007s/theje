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
왕 내가fiveReg양<br>
이름:${exam.name }<br>
<c:forEach  var="no" begin="0" end="2">
${exam.title(no) }<br>
</c:forEach>
</body>
</html>