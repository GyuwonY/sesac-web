<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String[] names = {"홍길동", "강길동", "윤길동", "송길동", "김길동"};
	
	pageContext.setAttribute("names", names);
	pageContext.setAttribute("namesLength", names.length);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${ names }" var = "name">
		${ name }<c:if test="${ name != names[ namesLength-1 ]}">,</c:if>
	</c:forEach>
	<br>
	<c:forEach var="i" begin="0" end="${ namesLength -1 }">
		${ names[i] }<c:if test="${ i != namesLength-1 }">,</c:if>
	</c:forEach>
	<hr>
	<h3>1 ~ 10 사이의 정수 출력</h3>
	<c:forEach var="i" begin="1" end="10">
		${ i }<br>
	</c:forEach>
	<br>
	년도선택 : 
	<select>
		<c:forEach var="year" begin="1970" end= "2020">
			<option>${ year }</option>
		</c:forEach>
	</select>
	<br>
</body>
</html>