package sample09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ForwardServlet + doGet");
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> 제목 </title>");
		pw.println("</head>");
		pw.println("<body bgcolor='green'>");
		
		pw.println("<h1> Hello ForwardServlet </h1>");
		pw.println("<p> Hello ForwardServlet</p>");
		pw.println("<h1>");
		pw.println(" ForwardServlet . java ");
		pw.println(" </h1>");
		pw.println("</body>");
		pw.println("</html>");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ForwardServlet + doPost");
		
		
	}

}
