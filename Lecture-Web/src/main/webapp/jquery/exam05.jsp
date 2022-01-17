<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		alert('!!!')
		
		//$('tr').css('background-color', 'pink')
		$('tr:even').css('background-color', 'pink')
	})
</script>
</head>
<body>
	<h2>회원명부</h2>
	<table border="1">
		<tr>
			<th>이름</th>
			<th>전화번호</th>
		</tr>
		<tr>
			<th>홍길동</th>
			<th>010-1111-2222</th>
		</tr>
		<tr>
			<th>홍길동</th>
			<th>010-1111-2222</th>
		</tr>
		<tr>
			<th>홍길동</th>
			<th>010-1111-2222</th>
		</tr>
		<tr>
			<th>홍길동</th>
			<th>010-1111-2222</th>
		</tr>
		<tr>
			<th>홍길동</th>
			<th>010-1111-2222</th>
		</tr>
	</table>
</body>
</html>