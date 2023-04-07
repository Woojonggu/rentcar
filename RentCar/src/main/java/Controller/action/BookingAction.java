package Controller.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Action;
import Util.DateParsor;
import booking.BookingDTO;
import booking.controller.BookingDAO;

public class BookingAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookingDAO booking = BookingDAO.getInstance();
		HttpSession session = request.getSession();

		String returnStr = request.getParameter("returnDate");
		String borrowStr = request.getParameter("borrowDate");

		Timestamp borrowDate = DateParsor.parseTimestamp(borrowStr);
		Timestamp returnDate = DateParsor.parseTimestamp(returnStr);
		
		long gap = returnDate.getTime() - borrowDate.getTime();
		int hours = (int) (gap / 1000 / 60 / 60);
		System.out.println("hours : " + hours);

		String carNum = request.getParameter("carNum");
		String carName = request.getParameter("carName");
		String totalPayment = request.getParameter("price");
		int clientNum = (int) session.getAttribute("num");
		Long datetime = System.currentTimeMillis();
		Timestamp registDate = new Timestamp(datetime);

		BookingDTO bookingDto = new BookingDTO(clientNum, carNum, carName, borrowDate.toString(), totalPayment, returnDate.toString(), registDate);
		booking.createUser(bookingDto);

		response.sendRedirect("index.jsp");
	}

}
