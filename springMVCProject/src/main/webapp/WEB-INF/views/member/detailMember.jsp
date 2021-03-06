<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 등록 페이지</title>
<style type="text/css">
table {
	width: 500px;
}
</style>

</head>
<body>
	<div align="center">
		<hr>
		<h2>회원 등록</h2>
		<hr>
		<br>
		<form action="update" method="post">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" value="${member.id }"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${member.name }"></td>
				</tr>
				<tr>
					<th width="100px">패스워드</th>
					<td><input type="password" name="password" value="${member.password }"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>
						<input type="text" name="email_id" value="${member.email_id }">&nbsp;@ 
						<input type="text" name="email_domain" style="width: 30%" value="${member.email_domain }">
					</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>
						<input type="text" name="tel1" placeholder="000" style="width: 10%" value="${member.tel1 }">&nbsp;- 
						<input type="text" name="tel2" placeholder="0000" style="width: 15%" value="${member.tel2 }">&nbsp;- 
						<input type="text" name="tel3" placeholder="0000" style="width: 15%" value="${member.tel3 }">
					</td>
				</tr>
				<tr>
					<th>우편번호</th>
					<td><input type="text" name="post" value="${member.post }"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<input type="text" name="basic_addr" placeholder="주소" style="width: 50%" value="${member.basic_addr }"> 
						<input type="text" name="detail_addr" placeholder="상세 주소" value="${member.detail_addr }"></td>
				</tr>
			</table>
			<br> <input type="submit" value="등록">
		</form>
		<button id="delete"></button>
	</div>
</body>
</html>