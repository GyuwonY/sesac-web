<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	BoardDAO dao = new BoardDAO();
	List<BoardVO> list = dao.selectAllBoard(); 
	int boardCnt = dao.boardCnt();
	int boardPrtCnt = 15; 

	pageContext.setAttribute("list", list);
	pageContext.setAttribute("boardCnt", boardCnt);
	pageContext.setAttribute("boardPrtCnt", boardPrtCnt);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Mission-Web/css/layout.css">
<link rel="stylesheet" href="/Mission-Web/css/board.css">
<script src="/Mission-Web/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){
		$('button').click(function(){
			location.href = "writeForm.jsp"
		})
	})
	
	function goWriteForm(){
		location.href = "writeForm.jsp"
	}

	function doAction(boardNo){
		<c:choose>
			<c:when test="${ not empty userVO}">
				location.href = "detail.jsp?no="+boardNo
			</c:when>
			<c:otherwise>
				if(confirm("로그인이 필요한 서비스입니다\n로그인페이지로 이동하시겠습니까?")){
					location.href = "/Mission-Web/jsp/login/loginForm.jsp"
				}
			</c:otherwise>
		</c:choose>
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
			<h2>게시판 목록</h2>
			<hr>
			<br>
			<table border = "1" class="list">
				<tr>
					<th width="7%">번호</th>
					<th>제목</th>
					<th width = "16%">글쓴이</th>
					<th width = "20%">등록일</th>
				</tr>
			<c:forEach var="i" begin="${(param.pageNo)}*${boardPrtCnt}" end="${(param.pageNo+3)}*${boardPrtCnt}">
				<tr>
					<td>${ board[i].no }</td>
					<td>
						<a href="javascript:doAction(${board[i].no })"> <%-- href에서 "javascript: 를 붙이면 javascript 문법이 실행된다. --%>
							<c:out value="${ board[i].title }"/>
						</a>
				
						<%-- <a href="detail.jsp?no=${ board.no }">
							<c:out value="${ board.title }"/>
						</a> --%>
					</td>
					<td>${ board[i].writer }</td>
					<td>${ board[i].regDate }</td>
				</tr>
			</c:forEach>
			</table>
			<br>
			<form action="/listTable.jsp?value=${value }">
				<select>
					<option>>5</option>
					<option selected>10</option>
					<option>15</option>
					<option>20</option>
					<option>30</option>
				</select>
			</form>
			<c:forEach var="pageNo" begin="1" end="5">
				<a href="list.jsp?pageNo=${pageNo}">${pageNo}</a>
			</c:forEach>
			<br>
			<c:if test="${ not empty userVO }">
				<button onclick="goWriteForm()">새글등록</button>
			</c:if>
		</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>
