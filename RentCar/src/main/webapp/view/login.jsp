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
String id = request.getParameter("id");
String password = request.getParameter("password");

String errMsg = (String)session.getAttribute("errMsg");
if(errMsg == null)
	errMsg = "";

%>

	<section class="login">
	
		<form method="POST" action="../Service">
			<input type="hidden" name="command" value="login">

			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" id="id" name="id" value="<%=id !=null ? id : "" %>"
					<%=id == null ? "autofocus" : "" %>></td>
				</tr>
				<tr>
					<th>password</th>
					<td><input type="text" id="password" name="password" value="<%=password !=null ? password : "" %>"
					<%=password == null ? "autofocus" : "" %>></td>
				</tr>
			</table>

			<input type="button" value="로그인" onclick="checklogin(form)">

		</form>
		<div id="errMsg" style="color:red"><%=errMsg %></div>

	</section>

</body>

<jsp:include page="footer" />


</html>