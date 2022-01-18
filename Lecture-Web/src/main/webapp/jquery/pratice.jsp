<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#wrap{
		position: absolute;
		left: 30%;
		top: 30%;
		width: 500px;
		height: 500px;
		align: center;
	}
	.days{
		text-align: center;
		font-size: 20pt;
		float: left;
		width: 50px;
		height: 50px;
	}
</style>
<script src="js/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js" integrity="sha256-eGE6blurk5sHj+rmkfsGYeKyZx3M4bG+ZlFyA7Kns7E=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		let day
		
 		$('.days').hover(function(){
 			$(this).text(function(index, element){
 				day = element
 				return element+'요일'
 			}),
			$(this).animate({
				'width': '+=50px',
				'height': '+=50px',
				'left': '25px',
				'top': '25px'
			}, 300)}, function(){
			$(this).text(function(index, element){
				return day
			}),
			$(this).animate({
				'width': '-=50px',
				'height': '-=50px',
				'left': '0px',
				'top': '0px'
			}, 300)
		}) 
		
/* 		$('.days').on({
			'mouseenter' : function(){
				$(this).animate({
					'width': '+=50px',
					'height': '+=50px'
			}, 1000)}, 'mouseleave': function(){
				$(this).animate({
				'width': '-=50px',
				'height': '-=50px'
			})
			}
		}) */
	})
</script>

</head>
<body>
	<div id="wrap">
		<div class="days" style="background-color: red">월</div>
		<div class="days" style="background-color: orange">화</div>
		<div class="days" style="background-color: yellow">수</div>
		<div class="days" style="background-color: green">목</div>
		<div class="days" style="background-color: blue">금</div>
		<div class="days" style="background-color: navy">토</div>
		<div class="days" style="background-color: purple">일</div>
	</div>
</body>
</html>