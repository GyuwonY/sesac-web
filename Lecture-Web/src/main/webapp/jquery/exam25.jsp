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
		$('#prev').click(function(){
			$('img').last().prependTo('span')
		})
		
		$('#next').click(function(){
			$('img').first().appendTo('span')
		})
		
		setInterval(function(){
			$('#next').trigger('click')
		}, 1000)
	})
</script>
</head>
<body>
	<button id="prev">prev</button>
	<span>
		<img src="/Lecture-Web/html/images/pen.jpg">
		<img src="/Lecture-Web/html/images/dog2.jpg">
		<img src="/Lecture-Web/html/images/dog3.jpg">
		<img src="/Lecture-Web/html/images/sun.gif">
	</span>
	<button id="next">next</button>
</body>
</html>