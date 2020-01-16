package sample02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
			Servlet -> Java(html)
			JSP-> html(java)
			
			JSP(MVC)
			Model1
			Model2		Servlet -> Controller 
		 */
		System.out.println("sample2 helloServlet doGet");
		
		String name = req.getParameter("name");
		
		System.out.println("name = " + name);
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title> 제목 </title>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<h1> Hello Servlet </h1>");
		pw.println("<p> Hello servlet</p>");
		pw.println("<h1>");
		pw.println("name = "+name);
		pw.println(" </h1>");
		
		pw.println("</body>");
		
		pw.println("</html>");
		
	}
//http://192.168.2.26:8090/sample02/NewFile.html 로도 접속가능. 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("sample2  helloServlet doPost");
		
		String name = req.getParameter("name");
		
		System.out.println("name = " + name);
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title> 제목 </title>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<h1> Hello Servlet </h1>");
		pw.println("<p> Hello servlet</p>");
		pw.println("<h1>");
		pw.println("name = "+name);
		pw.println(" </h1>");
		
		pw.println("</body>");
		
		pw.println("</html>");
		
	}
	

}//end class
