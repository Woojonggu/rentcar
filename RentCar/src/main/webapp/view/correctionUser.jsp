<%@page import="User.UserDTO"%>
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

String username = user.getUsersName();
String phone = user.getPhone();
int usernum = user.getUsersNum();
String age = user.getAge();

%>
<form method="POST" action="../Service">
			<input type="hidden" name="command" value="correction">

			<table>
				<tr>
					<th>UserNumber</th>
					<td><input type="text" id="usernum" name="usernum"
						value=<%=usernum%> readonly></td>
				</tr>
				<tr>
					<th>UserName</th>
					<td><input type="text" id="username" name="username"
						value="<%=username != null ? username : ""%>"
						<%=username == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>Phone</th>
					<td><input type="text" id="phone" name="phone"
						value="<%=phone != null ? phone : ""%>"
						<%=phone == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>Id</th>
					<td><input type="text" id="id" name="id"
						value="<%=id != null ? id : ""%>"
						<%=id == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="text" id="password" name="password"
						value="<%=password != null ? password : ""%>"
						<%=password == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>Age</th>
					<td><input type="text" id="age" name="age"
						value="<%=age != null ? age : ""%>"
						<%=age == null ? "autofocus" : ""%>></td>
				</tr>
			</table>


			<input type="button" value="등록" onclick="checkValues(form)">


		</form>

</section>
<script src="../resources/validation.js"></script>
</body>
<jsp:include page="footer"/>
</html>