package cookiedemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/makeCookie")
public class MakeCookie extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//쿠키생성. 
		Cookie cookie = new Cookie("cookieName", "CookieValue");
		//    '/' 아래의 경로 페이지를 호출할때 cookie 값이 전달됨. 
		cookie.setPath("/");		
		/*	webdemo/aaa/test.jsp  		해당 경로의 해당 jsp 파일에만 cookie 값이 전달이됨. 쿠키생성은 서버에서 생성되며 저장은 사용자 기기에 저장이된다.(클라이언트)
		 * 	webdemo/bbb/sample.jsp		
		 * */
		//쿠키 유효시간 -> 1시간
		cookie.setMaxAge(60*60);
		
		//쿠키를 클라이언트에 응답
		resp.addCookie(cookie);
		
		RequestDispatcher dis = req.getRequestDispatcher("/cookieview/makecookie.jsp");
		dis.forward(req, resp);					
		 
	}//end do get

	
}//end cookie class 
