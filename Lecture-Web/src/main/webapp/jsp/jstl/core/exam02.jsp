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
	<c:out value="내 이름은 <mark>홍길동</mark> 입니다" /><br> <!-- html태그 문자열로 인식되어 출력 -->
	<c:out value="내 이름은 <mark>홍길동</mark> 입니다" escapeXml="false" /><br> 
	<!-- escapeXml = "true" : 문자열로 인식 -->
	
	msg : <c:out value="${ msg }" default="msg변수 미설정" /> <!-- msg 값이 있는 경우는 msg값 출력 -->
	
</body>
</html>