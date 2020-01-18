package sample10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitedCookie")
public class VisitedCookie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> 제목 </title>");
		pw.println("</head>");
		pw.println("<body>");

		pw.println("<p> VisitedCookie cookie</p>");
		Cookie cookies[] = req.getCookies();
		Cookie visitCookie = null;
		
		if(cookies != null) {
			// 쿠키는 있음.
			
			
			//검색
			for (int i = 0; i < cookies.length; i++) {
				if(cookies[i].getName().equals("visited")) {
					visitCookie = cookies[i];
					break;
				}
			}
			//찾을수도 있고, 
			if(visitCookie != null) {
				int count = Integer.parseInt(visitCookie.getValue()) + 1;
				pw.println("<p>" + count + "번재 방문입니다 </p>");
				
			//쿠키값을 갱신해 줍니다.
				visitCookie.setValue(count + "");//들어갈 변수는 String 이므로 "" 을 추가해서 STRING으로 변해서 들어가도록한다.
				visitCookie.setMaxAge(60);//기한설정 365*24*60*60 -> 1년  365일24시간60분60초
				//샐정해두면 설정해둔 시간까지만 쿠키가 유효해진다.
				resp.addCookie(visitCookie);//갱신완료
				
				
			}
			//못찾음. 
			else {
				 pw.println("<p> 첫번째 방문입니다. </p>");
				 Cookie newCookie= new Cookie("visited", "1");
				 resp.addCookie(newCookie);
			}
			
			
		}else {
			//쿠키가 한개도 없음. --=> 생성해주기.
			 pw.println("<p> 첫번째 방문입니다. </p>");
			 Cookie newCookie= new Cookie("visited", "1");
			 resp.addCookie(newCookie);
		}

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
