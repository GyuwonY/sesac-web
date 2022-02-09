<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
hr, table {
	width: 80%;
}

.td_center{
	text-align: center;
}
</style>
<link rel = "stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css" >
<link rel = "stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css" >
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	function addMemberForm() {
		location.href = "${ pageContext.request.contextPath }/member/signup.do"
	}
</script>
</head>
<body>
	<div align="center">
		<hr>
		<h2>전체 회원 목록</h2>
		<hr>
		<br>
		<table border="1">
			<tr>
				<th width="7%">아이디</th>
				<th width="7%">이름</th>
				<th width="20%">이메일</th>
				<th width="15%">연락처</th>
				<th width="8%">우편번호</th>
				<th>주소</th>
				<th width="5%">타입</th>
				<th width="10%">가입날짜</th>
			</tr>


			<c:forEach items="${ memberList }" var="member">
				<tr>
					<td>${ member.id }</td>
					<td class="td_center">${ member.name }</td>
					<td>${ member.eId }@${ member.eDomain }</td>
					<td class="td_center">${ member.tel1 }-${ member.tel2 }-${ member.tel3 }</td>
					<td class="td_center">${ member.post }</td>
					<td>${ member.bAddr }<br>${ member.dAddr }</td>
					<td class="td_center">${ member.type }</td>
					<td class="td_center">${ member.regDate }</td>
				</tr>
			</c:forEach>

		</table>
		<br>
		<button onclick="addMemberForm()">등록</button>
	</div>
</body>
</html>