package model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustUserDao;
import dto.CustUserDto;

public class custuserdetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processFunc(req, resp);
	}
	
	
	public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String command = req.getParameter("command");
		String inputId = req.getParameter("id");
		
		// 회원정보열람 view
		if(command.equals("none")) {
			resp.sendRedirect("custuserdetail");
		}
		// 해당 회원의 회원정보  -> DB
		else if(command.equals("detail")) {
			String id = req.getParameter("id");

			
			System.out.println("id = "+id);
			
			CustUserDao dao = CustUserDao.getInstance();
			CustUserDto dto = dao.showMemInfo(id);
			req.setAttribute("custuserdetail", dto);
			RequestDispatcher dispatch = req.getRequestDispatcher("custuserdetail.jsp");
			dispatch.forward(req, resp);
			
//			resp.sendRedirect("finding.jsp?isS=" + );			
		}		
	}
	
	

}
