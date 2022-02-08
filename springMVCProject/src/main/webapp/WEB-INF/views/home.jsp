<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
<h1>
	Hello world!  ${ myname }
</h1>

<P>  The time on the server is ${serverTime}. </P>

<!-- login 창 열기 -->
<a href="test/login">로그인1</a>
<a href="/education/test/login">로그인2</a>
<form action="test/login">
	<input type="submit" value="로그인가기(form 이용)">
</form>
<hr>
<form action="test/login" method="post">
<!-- 	<input type="text" name="userid" value="sesac"><br>
	<input type="text" name="userpass" value="1234"><br> -->
	<input type="submit" value="로그인가기5(form이용 POST)">
</form>
<hr>
<button id="btn1">로그인하기4(JS)</button>
<hr>
<form action="test/helloParam.do">
	<input type="text" name="userid" value="sesac"><br>
	<input type="password" name="userpass" value="1234"><br>
	<input type="password" name="email" value="1234"><br>
	<input type="submit" value="파라미터 보내기">
</form>
<script>
$(function(){
	$("#btn1").click(function(){
		//BOM(Browser Object Model):window, document, location, history, screen
		location.href="test/login";
	});
});
</script>
</body>
</html>
