package Controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.Action;
import User.User;
import User.controller.UserDAO;

public class LoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		UserDAO userDao = UserDAO.getInstance();
		User user = userDao.getUserInformation(id, password);
		
		HttpSession session = request.getSession();
		if(user!=null) {
			response.sendRedirect("index.jsp");
			session.setAttribute("id", id);
			session.setAttribute("password", password);
			session.setAttribute("num", user.getUsersNum());
			
			String str = (String)session.getAttribute("errMsg");
			if(str!=null) {
				session.removeAttribute("errMsg");
			}
		}
		else {
			response.sendRedirect("login");
			session.setAttribute("errMsg", "로그인 정보가 올바르지 않습니다.");
		}
		
	}
	
	

}
