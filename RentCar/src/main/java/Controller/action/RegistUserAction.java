package Controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.Action;
import User.UserDTO;
import User.controller.UserDAO;


public class RegistUserAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String no = request.getParameter("usernum");
		int custno = 1;
		if(no != null)
			custno = Integer.parseInt(no);
		String custname = request.getParameter("username");
		String phone = request.getParameter("phone");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		Long datetime = System.currentTimeMillis();
		Timestamp time = new Timestamp(datetime);
		

		UserDTO userDto = new UserDTO(custno,custname,phone,id,password,age,time);


		UserDAO userDao = UserDAO.getInstance();
		userDao.createUser(userDto);

		response.sendRedirect("index.jsp");
	}

	
}
