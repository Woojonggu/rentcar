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
<jsp:include page="header"/>
<section>


<%
CarDAO carDao = CarDAO.getInstance();
ArrayList<Car> list = carDao.getCarList();
%>

<table>
<tr>
<td>차 번호</td>
<td>차 이름</td>
<td>시간 당</td>
<td>차 연식</td>
<td>나이제한</td>
</tr>
<%

for(Car car : list){
	int num = car.getCarNum();
	String name = car.getCarName();
	String price = car.getHourPrice();
	String year = car.getYear();
	String age = car.getPossibleAge();

%>
<tr>
<td><%=num %><a href="view/reservation.jsp">예매하기</a></td>
<td><%=name %></td>
<td><%=price %>원</td>
<td><%=year %>년</td>
<td><%=age %>세 이상</td>
</tr>

<%
}
%>


</table>


</section>

</body>
<jsp:include page="footer"/>
</html>