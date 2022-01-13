<%@page import="kr.co.mlec.member.dao.MemberDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.mlec.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	MemberDAO dao = new MemberDAO();
	List<MemberVO> list = dao.selectAll();
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css">
<link rel="stylesheet" href="/Mission-Web/css/board.css">
<script type="text/javascript">
	function goSignUpForm(){
		location.href = "signUpForm.jsp"
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>
	<section>
		<div align="center">
			<hr>
			<h2>전체 회원목록 조회</h2>
			<hr>
			<br>
			<table border = "1" >
				<tr>
				<td width=8%>아이디</td>
				<td width=6%>이름</td>
				<td width=8%>비밀번호</td>
				<td width=17%>이메일</td>
				<td width=15%>연락처</td>
				<td>주소</td>
				<td width= 5%>권한</td>
				<td width=10%>가입일자</td>
				</tr>
				<c:forEach var="member" items="${ list }">
					<tr>
						<td>${ member.id }</td>
						<td>${ member.name }</td>
						<td>${ member.pw }</td>
						<td>${ member.eId }@${ member.eDomain }</td>
						<td>${ member.tel1 }-${ member.tel2 }-${ member.tel3 }</td>
						<td>(${ member.post})&nbsp;&nbsp;${ member.bAddr }<br>${ member.dAddr }</td>
						<td>${ member.type }</td>
						<td>${ member.regDate }</td>
					</tr>
				</c:forEach>
			</table>
			<br>
		<button onclick="goSignUpForm()">회원가입</button>
	</div>
	</section>
	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
</body>
</html>