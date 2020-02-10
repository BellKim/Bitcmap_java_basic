package cookiedemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteCookie")
public class DeleteCookie extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {	
				if (cookies[i].getName( ).equals("cookieName")) {
					cookies[i].setPath("/");
				}else if (cookies[i].getName().equals("JSESSIONID")) {
					cookies[i].setPath("/webdemo");
				}
				cookies[i].setMaxAge(0); // 쿠키삭제
				resp.addCookie(cookies[i]);	
				}
			}
	
		resp.sendRedirect("useCookie");
	}//end get
}//end class





/* 강사님꺼 고치기 .
@WebServlet("/deleteCookie")
public class DeleteCookie extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (int i = 0; i < cookies.length; i++) {	
				if (cookies[i].getName( ).equals("cookieName")) {
					cookies[i].setPath("/");
				}else if (cookies[i].getName().equals("JSESSIONID")) {
					cookies[i].setPath("/webdemo");
				}
				cookies[i].setMaxAge(0); // 쿠키삭제
				resp.addCookie(cookies[i]);				
			}
		}
		
		resp.sendRedirect("useCookie");
	}//end doGet()
}//end class
 



 */