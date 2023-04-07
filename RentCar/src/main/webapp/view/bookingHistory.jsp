<%@page import="java.util.ArrayList"%>
<%@page import="booking.controller.BookingDAO"%>
<%@page import="booking.Booking"%>
<%@page import="User.controller.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="header" />
</head>

<body>
	<%
	int userNum = (int) session.getAttribute("num");
	BookingDAO bookingDao = BookingDAO.getInstance();
	
	ArrayList<Booking> booking = bookingDao.getBookingList(userNum);
	
	%>>
	<section>

		<table>
			<tr>
				<td>차번호</td>
				<td>차이름</td>
				<td>대여날</td>
				<td>반납날</td>
				<td>결제금액</td>
				<td>등록일</td>
			</tr>
			<%
			for (Booking list : booking) {
			%>
			<tr>
				<td><%=list.getCarNum()%></td>
				<td><%=list.getCarName()%></td>
				<td><%=list.getBorrowDate()%></td>
				<td><%=list.getReturnDate()%></td>
				<td><%=list.getTotalPayment()%>원</td>
				<td><%=list.getRegistDate()%></td>
			</tr>
			<%
			}
			%>


		</table>

	</section>

</body>
<jsp:include page="footer" />
</html>