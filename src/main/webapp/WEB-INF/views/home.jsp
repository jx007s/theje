<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
별명: ${nick }<br>
시간: ${time }
<h1>함이준 바보</h1>
<h2>request</h2>
<a href="mvc/first">first</a>
<a href="mvc/sec">sec</a>
<a href="mvc/thr">thr</a>
<a href="mvc/four?name=김우빈&jum=88&jum=77&jum=66">four</a>
<a href="mvc/five">five</a>
<a href="mvc/byOrder">byOrder</a><br>
<a href="mvc/fileUpload">fileUpload</a>	
<h2>model</h2>
<a href="model/detail">detail</a>
<a href="model/list">list</a>
<a href="model/insert">insert</a><br>
<a href="actor/detail">detail</a>
<a href="actor/list?key=m">list</a>
<a href="actor/insert?key=f">insert</a>
<h2>path</h2>
ppp/{userId}/aaa/{no}<br>
<a href="ppp">ppp</a><br>
<a href="ppp/aaa">ppp/aaa</a><br>
<a href="ppp/{userId}/aaa/{no}">ppp/{userId}/aaa/{no}</a><br>
<a href="ppp/qwer/aaa/456/qwer">ppp/qwer/aaa/456/qwer</a><br>
<a href="ppp/abcd/aaa/123">ppp/abcd/aaa/123</a><br>
<a href="ppp/zxcv/aaa/asdf">ppp/zxcv/aaa/asdf</a><br>

<h2>mybatis</h2>
<a href="mybatis/list">list</a>
<h2>cookie</h2>
<a href="cookie/make">make</a>
<a href="cookie/view">view</a>
<a href="cookie/modify">modify</a>
<a href="cookie/delete">delete</a>
<h2>session</h2>
<a href="session/make">make</a>
<a href="session/view">view</a>
<a href="session/modify">modify</a>
<a href="session/delete">delete</a>
<h2>etc</h2>
<a href="validate">validate</a>
<a href="interceptor/event">interceptor</a>
<h2>관리자</h2>
<a href="admin/main">메인</a>

</body>
</html>


