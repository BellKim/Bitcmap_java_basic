package sample03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class helloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do get ");
		this.createHTML("GET", req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do post ");
		this.createHTML("Post", req, resp);
		
	}
	
	public void createHTML(String methodType, HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
		pw.println("<h2> 방식 : "+ methodType +" </h2>");
		
		
		pw.println("<p> Hello servlet</p>");
		pw.println("<h1>");
		pw.println("name = "+name);
		pw.println(" </h1>");
		
		pw.println("</body>");
		
		pw.println("</html>");
	}
	
	

}//end class
