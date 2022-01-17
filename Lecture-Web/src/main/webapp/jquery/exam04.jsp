<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js" integrity="sha256-eGE6blurk5sHj+rmkfsGYeKyZx3M4bG+ZlFyA7Kns7E=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		alert('!!!')
		//$('a').hide()
		//$('a[target]').hide()
		//$('a[href="http://www.naver.com"]').hide() // [속성] 을 통한 태그 선택 가능
		
		//$('input[type="text"]').hide()
		//$('input:text').hide() // input 태그만 축약 가능
		//$('input:button').hide()
		//$('button').hide()
		//$(':text').hide()
		//$(':button').hide() // 버튼태그까지 선택됨
		
		$(':button').click(function(){
			//$('hr').hide()
			$(this).hide("drop", {direction: 'down'})
		})
	})
</script>
</head>
<body>
	<h2>a Tag전</h2>
	<a href="http://www.naver.com">네이버</a>
	<a href="http://www.daum.net" target="_blank">다음</a>
	<h2>a Tag후</h2>
	<hr>
		<input type="text">
		<input type="button" value="버튼1">
		<button>버튼2</button>
	<hr>
</body>
</html>