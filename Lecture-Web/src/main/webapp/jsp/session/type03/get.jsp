<%@page import="kr.co.mlec.member.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO member = (MemberVO)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	세션 ID : ${ sessionScope.member.id }<br>
	세션 PASSWORD : ${ sessionScope.member.id }<br>
	<a href="remove.jsp">세션 삭제</a>
	
</body>
</html>