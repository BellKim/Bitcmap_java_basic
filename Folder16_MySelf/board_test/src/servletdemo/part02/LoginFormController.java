package servletdemo.part02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginForm")
public class LoginFormController extends HttpServlet{
//		http://localhost:8090/webdemo/loginForm
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = 
				req.getRequestDispatcher("/servletview/part02/form.jsp");
		dis.forward(req, resp);
	}

	
	
	
}//end class()






/*@WebServlet("/loginForm")
 * extends HttpServlet
 *  servletview에 part02폴더추가 / form.jsp 생성. 
 *  
 * 
 * 
 * 
 * */









