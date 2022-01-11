<%@page import="kr.co.mlec.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.mlec.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String tel01 = request.getParameter("tel01");
	String tel02 = request.getParameter("tel02");
	String tel03 = request.getParameter("tel03");
	String eId = request.getParameter("eId");
	String domain = request.getParameter("domain");
	String post = request.getParameter("post");
	String bAddr = request.getParameter("bAddr");
	String dAddr = request.getParameter("dAddr");
	
	Connection conn = new ConnectionFactory().getConnection();
	StringBuilder sql = new StringBuilder();
	sql.append("insert into tbl_member(id, name, password, email_id, email_domain, tel1, tel2, tel3, ");
	sql.append(" post, basic_addr, detail_addr) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	pstmt.setString(1, id);
	pstmt.setString(2, pw);
	pstmt.setString(3, name);
	pstmt.setString(4, eId);
	pstmt.setString(5, domain);
	pstmt.setString(6, tel01);
	pstmt.setString(7, tel02);
	pstmt.setString(8, tel03);
	pstmt.setString(9, post);
	pstmt.setString(10, bAddr);
	pstmt.setString(11, dAddr);
	
	pstmt.executeUpdate();
%>
<script>
	alert('회원가입이 완료되었습니다.')
	location.href='list.jsp'
</script>
<%
	JDBCClose.close(pstmt, conn);
%>