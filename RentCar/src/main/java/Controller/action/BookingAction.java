package Controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Action;
import booking.BookingDTO;
import booking.controller.BookingDAO;

public class BookingAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookingDAO booking = BookingDAO.getInstance();
		HttpSession session = request.getSession();
		
		String carNum =request.getParameter("carNum");
		String carName = request.getParameter("carName");
		String borrowDate = request.getParameter("borrowDate");
		String totalPayment = request.getParameter("totalPayment");
		int clientNum = (int)session.getAttribute("num");
		String returnDate = request.getParameter("returnDate");
		Long datetime = System.currentTimeMillis();
		Timestamp registDate = new Timestamp(datetime);
		
		BookingDTO bookingDto = new BookingDTO(clientNum, carNum, carName, borrowDate, totalPayment, returnDate, registDate);
		booking.createUser(bookingDto);
		
		response.sendRedirect("index.jsp");
	}

}
