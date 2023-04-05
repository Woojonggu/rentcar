<%@page import="User.controller.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../resources/validation.js"></script>
<title>Insert title here</title>
</head>
<jsp:include page="header" />
<body>
<%
UserDAO userDao = UserDAO.getInstance();
int usernum = userDao.getCustnoMax();

String username = request.getParameter("username");
String phone = request.getParameter("phone");
String id = request.getParameter("id");
String password = request.getParameter("password");
String age = request.getParameter("age");

%>

	<section>
		<form method="POST" action="../Service">
		<input type="hidden" name="command" value="join"> 

			<table>
				<tr>
					<th>UserNumber</th>
					<td><input type="text" id="usernum" name="usernum" value=<%=usernum %> readonly></td>
				</tr>
				<tr>
					<th>UserName</th>
					<td><input type="text" id="username" name="username" value="<%=username != null ? username : "" %>"
					<%=username == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>Phone</th>
					<td><input type="text" id="phone" name="phone" value="<%=phone != null ? phone : "" %>"
					<%=phone == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>Id</th>
					<td><input type="text" id="id" name="id" value="<%=id != null ? id : "" %>"
					<%=id == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="text" id="password" name="password" value="<%=password != null ? password : "" %>"
					<%=password == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>Age</th>
					<td><input type="text" id="age" name="age" value="<%=age != null ? age : "" %>"
					<%=age == null ? "autofocus" : ""%>></td>
				</tr>
			</table>
			
			
			<input type="button" value="등록" onclick="checkValues(form)">


		</form>


	</section>

</body>
<jsp:include page="footer" />
</html>