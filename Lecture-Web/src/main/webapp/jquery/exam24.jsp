<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	img{
		width:150px;
		height: 150px;
	}
</style>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('button').click(function(){
			//$('img').first().appendTo('body') 첫번째 이미지태그를 body 자손으로 추가 (appendTo 맨 뒤로 추가됨)
			$('img').last().prependTo('body')
		})
	})
</script>
</head>
<body>
	<img src="/Lecture-Web/html/images/pen.jpg">
	<img src="/Lecture-Web/html/images/dog2.jpg">
	<img src="/Lecture-Web/html/images/dog3.jpg">
	<img src="/Lecture-Web/html/images/sun.gif">
	<br>
	<button>클릭</button>
</body>
</html>