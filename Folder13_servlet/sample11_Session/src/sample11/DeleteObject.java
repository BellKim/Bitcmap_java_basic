package sample11;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/delObject")
public class DeleteObject extends HttpServlet{
		//object 자체만 삭제하게 하기 위해서.
	 
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> 제목 </title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>");
		pw.println(" loginIdServlet . java ");
		pw.println(" </h1>");
		pw.println("<h1> DeleteObject </h1>");
		HttpSession session = req.getSession();
		
		pw.println("<p>현재 등록되어 있는 세션 표시 </p>");
		
		Enumeration<String> enum_session = session.getAttributeNames();
		
		while(enum_session.hasMoreElements()) {
			String key = enum_session.nextElement();
			String value= (String)session.getAttribute(key);
			
			pw.println("<p>" + key + ":" + value + "</p>");
			
		}
		
		
		
		pw.println("</body>");
		pw.println("</html>");
		
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	

}
