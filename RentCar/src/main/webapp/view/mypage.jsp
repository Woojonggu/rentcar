<%@page import="User.User"%>
<%@page import="User.controller.UserDAO"%>
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

	<section>
		<%
		UserDAO userDao = UserDAO.getInstance();

		String id = (String) session.getAttribute("id");
		String password = (String) session.getAttribute("password");

		User user = userDao.getUserInformation(id, password);
		%>
		<form action="">
		
			<p>
				이름 :
				<%=user.getUsersName()%></p>
			<p>
				전화번호 :
				<%=user.getPhone()%></p>
			<p>
				나이 :
				<%=user.getAge()%></p>
			<p>
				아이디 :
				<%=user.getClientID()%></p>
			<a href="bookingHistory?num=<%=user.getUsersNum()%>">예약내역</a>
			<a href="correctionUser?num=<%=user.getUsersNum()%>">정보수정</a>
		</form>
	</section>

</body>
<jsp:include page="footer"/>
</html>