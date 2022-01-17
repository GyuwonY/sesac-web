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
		alert('ready...')
		
		// $('h1').hide() // display none으로 바꾸는 함수
		
 		//$('#h01').hide()
		//$('.c01').hide() 
		// $('h1.c01').hide()
		//$('body > *').hide() body의 모든 후손들
		//$('h1:first').hide() h1 태그중 처음
		$('h1:last').hide()
		
		
		/*
		let h1Tags = document.getElementsByTagName("h1")
		for(let tag of h1Tags){
			tag.style.display = 'none'
		}
		*/
	})
</script>
</head>
<body>
	<hr>
	<h1 id="h01">Hello</h1>
	<h1 class="c01">Hi</h1>
	<h2>good-bye</h2>
	<hr>
	<h1 id="h01">Hello</h1>
	<h1 class="c01">Hi</h1>
	<h2 class="c01">good-bye</h2>
	<hr>
</body>
</html>