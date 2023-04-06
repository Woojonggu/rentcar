<%@page import="java.time.Period"%>
<%@page import="java.sql.Date"%>
<%@page import="java.awt.print.Printable"%>
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
		String carNum = request.getParameter("num");

		CarDAO carDao = CarDAO.getInstance();
		Car car = carDao.getCarInformation(carNum);

		String carName = car.getCarName();
		int num = 0;
		if (session.getAttribute("num") != null) {
			num = (int) session.getAttribute("num");
		}
		String borrowDate = request.getParameter("borrowDate");
		String returnDate = request.getParameter("returnDate");
		
		
		%>




		<form method="POST" action="../Service" class = "bookingform">
		
			<input type="hidden" name="command" value="booking">

			<div class="booking">
				<h1><%=carName%></h1>
				<div>
					<h4>
					<%=car.getSeater()%>인승|<%=car.getYear()%>년|<%=car.getPossibleAge()%>세 이상
					</h4>
				</div>
			</div>


			<p>
			<h4>대여일</h4>
			<input type="datetime-local" value="borrowDate">
			</p>

			<p>
			<h4>반납일</h4>
			<input type="datetime-local" value="returnDate">
			</p>

			<input type="submit" value="예약하기">

		</form>



	</section>

</body>
<jsp:include page="footer" />
</html>