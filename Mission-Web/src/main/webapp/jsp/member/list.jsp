<%@page import="kr.co.mlec.util.JDBCClose"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.mlec.util.ConnectionFactory"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection conn = new ConnectionFactory().getConnection();
	StringBuilder sql = new StringBuilder();
	sql.append("select id, name, password, email_id, email_domain, tel1, tel2, tel3, post, ");
	sql.append(" basic_addr, detail_addr, type, to_char(reg_date, 'yyyy-mm-dd') as reg_date from tbl_member");
	PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	ResultSet rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	hr, table{
		width: 80%
	}
	td{
		text-align: center;
	}
</style>
<script type="text/javascript">
	function goSignUpForm(){
		location.href = "signUpForm.jsp"
	}
</script>
</head>
<body>
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
			<%
				while(rs.next()){
					String id = rs.getString("id");
					String name = rs.getString("name");
					String pw = rs.getString("password");
					String eId = rs.getString("email_id");
					String eDomain = rs.getString("email_domain");
					String tel1 = rs.getString("tel1");
					String tel2 = rs.getString("tel2");
					String tel3 = rs.getString("tel3");
					String post = rs.getString("post");
					String bAddr = rs.getString("basic_addr");
					String dAddr = rs.getString("detail_addr");
					String type = rs.getString("type");
					String regDate = rs.getString("reg_date");
					
					String eMail = eId+"@"+eDomain;
					String tel = tel1+"-"+tel2+"-"+tel3;
					String addr = "("+post+")"+bAddr+"<br>"+dAddr;
					
					if(eId==null){
						eMail = "-";
					}
					
					if(tel1==null){
						tel = "-";
					}
					
					if(post==null){
						addr = "-";
					}
			%>
				<tr>
					<td><%= id %></td>
					<td><%= name %></td>
					<td><%= pw %></td>
					<td><%= eMail %></td>
					<td><%= tel %></td>
					<td><%= addr %></td>
					<td><%= type %></td>
					<td><%= regDate %></td>
				</tr>
			<%
				}
			%>
		</table>
		<br>
		<button onclick="goSignUpForm()">회원가입</button>
	</div>
</body>
</html>
<%
	JDBCClose.close(pstmt, conn);
%>