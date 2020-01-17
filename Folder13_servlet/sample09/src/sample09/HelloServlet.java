package sample09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")	//namespace
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hello servlet do get ");
		
		//include (가져오다), forward(그쪽으로 이동)
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> 제목 </title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1> Hello Servlet </h1>");
		
		//include
//		RequestDispatcher dis = req.getRequestDispatcher("include");
//		dis.include(req,resp);
		
		
		//forward
		RequestDispatcher dis = req.getRequestDispatcher("forward");
		dis.forward(req,resp);
			
		
		
		pw.println("<p> Hello servlet</p>");
		pw.println("<h1>");
//		pw.println("name = "+name);
//		pw.println(" age = "+age);
		pw.println(" Hello Servlet . java ");
		pw.println(" </h1>");
		pw.println("</body>");
		pw.println("</html>");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("helloservlet do post ");
	}
	
	

}
