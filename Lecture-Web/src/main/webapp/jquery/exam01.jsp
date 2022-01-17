<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <script src="js/jquery-3.6.0.min.js"></script> -->
<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	// $(선택자).함수() Jquery 기본 문법 
	$(document).ready(function(){ // window.onload 와 동일
		alert('ready...')
		
	})
	
	$(document).ready(function(){ // 여러번 사용해도 전부 실행됨 / 순서가 보장되진 않음
		alert('ready2...')
	})
	
	$(function(){ // 상기와 동일한 기능 / 축약하여 사용 가능 
		alert('ready3...')
	})
</script>
</head>
<body>
	
</body>
</html>