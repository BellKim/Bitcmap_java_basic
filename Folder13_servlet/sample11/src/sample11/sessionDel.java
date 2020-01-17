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

@WebServlet("/sessionDel")
public class sessionDel extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> 제목 </title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>");
		pw.println(" loginIdServlet . java ");
		pw.println(" </h1>");
		pw.println("<h1>  sessionDel  </h1>");
		
		HttpSession session = req.getSession();
		
		session.invalidate();//logout일 경우 호출
		
		if(req.getSession(false) == null) {
			pw.println("<p>세션이 비어 있습니다. </p>");
			
		}
		
		pw.println("</body>");
		pw.println("</html>");
		
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}

