<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%> <!-- isErrorPage="true" 에러 메세지를 출력할 수 있다 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>오류정보입니다.(기타오류)</h1>
<%=exception %><br>
<%=exception.getMessage() %>
</body>
</html>