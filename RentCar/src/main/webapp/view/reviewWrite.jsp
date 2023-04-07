<%@page import="review.controller.reviewDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="header" />
<body>
<%
reviewDAO reviewDao = reviewDAO.getInstance();
int reviewNum = reviewDao.getReviewNoMax();
String id = (String)session.getAttribute("id");
String tittle = request.getParameter("tittle");
String contents = request.getParameter("contents");

%>
	<section>
		<h1>후기 글쓰기</h1>
		<form method="POST" action="../Service">
		<input type="hidden" name="command" value="review">
		<input type="hidden" name="reviewNum" value=<%=reviewNum %>>
			<input type="hidden" name="id" value=<%=id %>>
			<div class="reviewWrite1">
				<input type="text" name="tittle" id="tittle" class="tittle" value="<%=tittle != null ? tittle : "" %>"<%=tittle == null ? "autofocus" : "" %> placeholder="제목을 입력하세요">
				<input type="text" name="contents" id="contents" value="<%=contents != null ? contents : "" %>"<%=contents == null ? "autofocus" : "" %> class="contents" placeholder="내용을 입력하세요">
				
			</div>
				<input type="button" value="등록" onclick="checkReview(form)">
		</form>
	</section>
	<script src="../resources/validation.js"></script>

</body>
<jsp:include page="footer" />
</html>