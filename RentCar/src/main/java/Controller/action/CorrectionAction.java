package Controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Action;
import User.User;
import User.UserDTO;
import User.controller.UserDAO;

public class CorrectionAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO userDao = UserDAO.getInstance();
		int no = Integer.valueOf(request.getParameter("usernum"));
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String custname = request.getParameter("username");
		String phone = request.getParameter("phone");
		String age = request.getParameter("age");
		User user = userDao.getUserInformation(id, password);
		Timestamp time = user.getRegistDate();
		
		UserDTO userDto = new UserDTO(no, custname, phone, id, password, age, time);
		HttpSession session = request.getSession();
		userDao.updateUser(userDto);
		
		session.removeAttribute("id");
		session.removeAttribute("password");
		session.removeAttribute("num");
		
		response.sendRedirect("index.jsp");
		
	}

}
