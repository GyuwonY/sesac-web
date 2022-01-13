<%@page import="kr.co.mlec.status.Status"%>
<%@page import="kr.co.mlec.member.vo.MemberVO"%>
<%@page import="kr.co.mlec.member.dao.MemberDAO"%>
<%@page import="kr.co.mlec.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.mlec.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	MemberDAO dao = new MemberDAO();
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String eId = request.getParameter("eId");
	String domain = request.getParameter("domain");
	String post = request.getParameter("post");
	String bAddr = request.getParameter("bAddr");
	String dAddr = request.getParameter("dAddr");
	
	MemberVO member = new MemberVO(id, name, pw, eId, domain, tel1, tel2, tel3, post, bAddr, dAddr);
	dao.singUp(member);
	
	pageContext.setAttribute("type", Status.type);
%>
<script>
	switch(${type}){
		case 1:
			alert('중복된 아이디가 존재합니다. 아이디를 다시 입력해주세요.')
			<% 
				Status.type = 0;
				pageContext.setAttribute("type", Status.type);
			%>
			location.href='signUpForm.jsp'
			break;
		case 3:
			alert('회원가입이 완료되었습니다.')
			<% 
				Status.type = 0;
				pageContext.setAttribute("type", Status.type);
			%>
			location.href='list.jsp'
			break;
	}
</script>

