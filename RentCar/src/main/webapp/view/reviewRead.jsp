<%@page import="review.review"%>
<%@page import="review.controller.reviewDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="header"/>
<body>
<section class="reviewRead">
<%
reviewDAO reviewDao = reviewDAO.getInstance();
int num = Integer.valueOf(request.getParameter("reviewNum"));

review review = reviewDao.getReview(num);
%>
<h1><%=review.getTittle() %></h1>

<div><%=review.getContents() %></div>

</section>

</body>
<jsp:include page="footer"/>
</html>