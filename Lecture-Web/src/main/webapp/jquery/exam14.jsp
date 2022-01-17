<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		$('h1').click(function(event){
			$(this)[0].innerText += ' * '
		})
		
		let interval = setInterval(function(){
			//$('h1').click()
			$('h1').trigger('click') // 강제적으로 이벤트를 발생시켜주는 함수
		}, 1000)
		
		setTimeout(function(){
			clearInterval(interval)
		},10000)
	})
</script>
</head>
<body>
	<h1>수행률: </h1>
</body>
</html>