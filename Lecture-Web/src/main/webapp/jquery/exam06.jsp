<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#div01{
		background-color: yellow;
		height: 150px;
	}
</style>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		alert('!!!')
		
		/*
		$('#div01').mouseenter(function() {
			$(this).css('background-color', 'pink')
		})
		
		$('#div01').mouseleave(function(){
			$(this).css('background-color', 'yellow')
		})
		*/
		
		$('#div01').hover(function(){ // mouseenter와 mouseleave를 같이 동작시키기 때문에 매개변수 2개
			$(this).css('background-color', 'green')
		}, function(){
			$(this).css('background-color', 'yellow')
		})
		
		$('#div01').click(function(event) {
			console.log(event.pageX, event.pageY)
		})
		
		$('button').click(function() {
			//$('h1:first').hide(1000) // 1000millisec
			//$('h1:first').hide('fast')
			$('h1:first').hide('slow')
		})
		
		$('body > h1').dblclick(function() {
			$(this).hide(3000)
		})
		
		
	})
</script>
</head>
<body>
	<div id="div01">
		나는 DIV영역입니다<br>
		마우스를 접근시켜보세요
	</div>
	
	<h1>첫번째 문장입니다</h1>
	<h1>두번째 문장입니다</h1>
	<div>
		<h1>세번째 문장입니다</h1>
	</div>
	<h1>네번째 문장입니다</h1>
	<button>클릭</button>
</body>
</html>
