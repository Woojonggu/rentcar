package Controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.Action;
import review.reviewDTO;
import review.controller.reviewDAO;

public class ReviewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num = Integer.valueOf(request.getParameter("reviewNum"));
		String tittle = request.getParameter("tittle");
		String contents = request.getParameter("contents");
	
		
		Long datetime = System.currentTimeMillis();
		Timestamp time = new Timestamp(datetime);
		String id = request.getParameter("id");
		
		reviewDTO reviewDto = new reviewDTO(num,tittle,contents,id,time);
		reviewDAO reviewDao = reviewDAO.getInstance();
		reviewDao.CreateReview(reviewDto);
		
		response.sendRedirect("review");
	}

}
