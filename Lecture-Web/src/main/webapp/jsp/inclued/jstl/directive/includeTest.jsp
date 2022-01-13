<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("id", "hong");
	%>
	msg : <%= msg %> <br>
	phone : ${ phone }<br>
	<h2>인클루드전</h2>
	<h3>파라미터 미설정</h3>
	<c:import url="one.jsp"/>
	phone : ${ phone }<br> <!-- include 시점에 따라 공유영역내 값이 달라질 수 있다. -->
	<h3>파라미터 설정</h3>
	<c:import url="one.jsp"> 
		<c:param name="name" value="hong,gil-dong" />
		<c:param name="age" value="12" /> 
	</c:import>
	<h2>인클루드후</h2>
	<c:import url="http://sesac.seoul.kr" />
</body>
</html>