package sample11;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginId")
public class loginIdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("loginID SERVLET");
	

		
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
		pw.println("<h1> </h1>");
		HttpSession session = null;
		if(session == null) {
			pw.println("<p>session을 등록합니다 </p>");
			session = req.getSession(true);
			
			session.setAttribute("name", "홍길동");
			session.setAttribute("age", "24");
			//세션등록완료
		}
		
//		pw.println("<p>등록되어있는 session을 표시합니다. </p>");
//		
//		String name = (String) session.getAttribute("name");
//		pw.println("<p> name : " + name + "</p>");
		
		Enumeration<String> enum_session = session.getAttributeNames();
		
		while(enum_session.hasMoreElements()) {
			String key = enum_session.nextElement();
			String value= (String)session.getAttribute(key);
			
			pw.println("<p>" + key + " : " + value + "</p>");
		}
		
		pw.println("<a href=delObject>age 삭제 </a>");
		pw.println("<br>");
		
		pw.println("<a href=sessionDel>session 삭제</a>");
		
		
		
		
		
		pw.println("");
		
		
		pw.println("</body>");
		pw.println("</html>");
		
		
	}
	
	

}
