<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	hr, h2{
		width: 80%;
	}
</style>
<script>
	function doWrite() {
		let d = document.inputForm
		
		if(d.id.value==""){
			alert("아이디를 입력하세요.")
			d.id.focus()
			return false
		}
		if(d.pw.value==""){
			alert("패스워드를 입력하세요.")
			d.pw.focus()
			return false
		}
		if(d.name.value==""){
			alert("이름을 입력하세요.")
			d.name.focus()
			return false
		}
		
		return true
	}
</script>
</head>
<body>
	<div align="center">
		<hr>
			<h2>회원가입</h2>
		<hr>
		<form action="signUp.jsp" method="post" name="inputForm" onsubmit="return doWrite()">
			<table border="1">
				<tr>
					<td>아이디 <input type = "text" name = "id"></td>
				</tr>
				<tr>
					<td>비밀번호 <input type = "password" name = "pw"></td>
				</tr>
				<tr>
					<td>이름 <input type = "text" name = "name"></td>
				</tr>
				<tr>
					<td>연락처 
					<input type = "text" name = "tel01">-<input type = "text" name = "tel02">-<input type = "text" name = "tel03">
					</td>
				</tr>
				<tr>
					<td>E-Mail 
					<input type = "text" name = "eId">@<input type = "text" name = "domain">
					</td>
				</tr>
				<tr>
					<td>우편주소 <input type = "text" name = "post">
					주소<input type = "text" name="bAddr">
					상세주소<input type = "text" name="dAddr">
					</td>
				</tr>
			</table>
			<br>
			<input type="submit" value="회원가입">
		</form>
	</div>
</body>
</html>