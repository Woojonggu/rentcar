<%@page import="java.util.ArrayList"%>
<%@page import="Car.Car"%>
<%@page import="Car.Controller.CarDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header" />
	<section>


		<%
		CarDAO carDao = CarDAO.getInstance();
		ArrayList<Car> list = carDao.getCarList();
		%>

		<div class="carList1">
			<%
			for (Car car : list) {
				String num = car.getCarNum();
				String name = car.getCarName();
				String price = car.getHourPrice();
				String year = car.getYear();
				String age = car.getPossibleAge();
			%>
			<div class="carList">

				<h1><%=name%></h1>
				<p><%=price%>원/hour&nbsp;|&nbsp;<%=age%>세 이상&nbsp;|&nbsp;<%=year%>년
				</p>


				<%
				if (session.getAttribute("id") == null) {
				%>
				<a href="login">예약하기</a>
				<%
				} else {
				%>
				<a href="booking?num=<%=num%>">예약하기</a>
				<%
				}
				%>
			</div>
			<%
			}
			%>


		</div>


	</section>

</body>
<jsp:include page="footer" />
</html>