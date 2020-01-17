package sample10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" hello_ doGet ");
		
		Cookie cookie = new Cookie("id", "abc123");
		resp.addCookie(cookie);	//cookie저장이됨.
		
//		새로운 쿠키를 생성할때는 다음과 같이
		cookie = new Cookie("pwd", "aabbcc");
		
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> 제목 </title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>");
		pw.println(" HelloServlet . java ");
		pw.println(" </h1>");

		pw.println("<a href='displyCookie'>cookie를 표시 </a>");
		
		
		
		pw.println("</body>");
		pw.println("</html>");
		
	}// do get

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}

	
	
}
