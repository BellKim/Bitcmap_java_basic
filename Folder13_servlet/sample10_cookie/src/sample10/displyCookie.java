package sample10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displyCookie")
public class displyCookie extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		

		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> 제목 </title>");
		pw.println("</head>");
		pw.println("<body>");

		pw.println("<p> display cookie</p>");

		pw.println(" <a href=dispCookie>vookie를 퓨ㅛ시 </a>");
		pw.println("  ");
		Cookie cookies[] = req.getCookies();
		if(cookies != null) {
			for(int i=0; i< cookies.length; i++) {
				String value=cookies[i].getValue();
				pw.print("<p>");
				pw.println(cookies[i].getName());
				pw.println(":");
				pw.println(value);
				pw.println("</p>");
			}
		}
		pw.println("<a href=VisitedCookie>방문횟수 </a>");
		
	
		pw.println("<h1>");
		pw.println(" displyCookie . java ");
		pw.println(" </h1>");
		pw.println("</body>");
		pw.println("</html>");
		
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	

}
