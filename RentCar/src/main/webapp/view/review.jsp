<%@page import="review.review"%>
<%@page import="java.util.ArrayList"%>
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
	<section class="reviewWrite">


		<h1>후기글</h1>
		<%
		reviewDAO reviewDao = reviewDAO.getInstance();
		ArrayList<review> list = reviewDao.getReviewList();
		%>
		<%
		for (review review : list) {
		%>

		<table>
			<tr>
				<td><%=review.getReviewNum()%>.</td>
				<td><a href="reviewRead?reviewNum=<%=review.getReviewNum()%>"><%=review.getTittle()%></a></td>
				<td><%=review.getWriterId()%></td>
				<td><%=review.getWriteDate()%></td>
			</tr>
		</table>

		<%
		}
		%>
		<div class="write">
			<%
			if (session.getAttribute("id") != null) {
			%>
			<a href="reviewWrite" class="review">글쓰기</a>
			<%
			} else {
			%><a href="login" class="review">글쓰기</a>
			<%
			}
			%>

		</div>

	</section>

	<jsp:include page="footer" />
</body>
</html>