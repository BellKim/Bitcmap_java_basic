package sample11_example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

@WebServlet("/manServlet")
public class manServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hello man servlet do get");
		HttpSession session = null;
		
		session = req.getSession();
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> 제목 </title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>");
		pw.println("  ");

		
		//======== get session  ===========================================
		
		Enumeration<String> enum_session = session.getAttributeNames();
		while(enum_session.hasMoreElements()) {
			String key = enum_session.nextElement();
			String value= (String)session.getAttribute(key);
			pw.println("<p>" + key + ":" + value + "</p>");
		}
		//======== get session  ===========================================
		
		pw.println(" </h1>");
		pw.println("<h1> </h1>");
		
		
		
		pw.println("</body>");
		pw.println("</html>");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hello man servlet do post");

		
		
	}
	
	
	

}//end class