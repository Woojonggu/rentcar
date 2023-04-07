
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/rent.css">
<title>Insert title here</title>
</head>
<body>

	<header>
		<h1><a href="index.jsp">JW RentCar</a></h1>
	</header>
	<nav>
		<ul>
			<li><a href="carList">렌트하기</a></li>
			<li><a>공지사항</a></li>
			<li><a href="review">후기</a></li>
			
			<%
			String str =(String)session.getAttribute("id");
			boolean id = str == null ? true : false;
			
			if(id){%>
			<li><a href="join">회원가입</a></li>
			<li><a href="login">로그인</a></li>
			<%	
			}
			else{
			%>
			<li><a href="mypage">마이페이지</a></li>
			<li><a href="logout">로그아웃</a></li>
			
			<%
			}
			 %>
			
			
			
		</ul>
	</nav>

</body>
</html>