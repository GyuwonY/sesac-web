<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 	
	BoardDAO dao = new BoardDAO();
	int boardCnt = dao.boardCnt();
	int boardPrtCnt = 15; 
	int pageNo= 1;
	double pageCnt= Math.ceil(boardCnt/boardPrtCnt);
%>
<c:forEach var="board" items="${ list }">
	<tr>
		<td>${ board.no }</td>
		<td>
			<a href="javascript:doAction(${board.no })"> <%-- href에서 "javascript: 를 붙이면 javascript 문법이 실행된다. --%>
				<c:out value="${ board.title }"/>
			</a>
				
			<%-- <a href="detail.jsp?no=${ board.no }">
				<c:out value="${ board.title }"/>
			</a> --%>
		</td>
		<td>${ board.writer }</td>
		<td>${ board.regDate }</td>
	</tr>
</c:forEach>