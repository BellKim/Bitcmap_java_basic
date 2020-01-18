package sample11_example;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("helloServlet DO GET ");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("helloServlet do Post ");
		req.setCharacterEncoding("utf-8");
		
		String age = req.getParameter("age");
		String chk_gend= req.getParameter("chk_gend");
		
		String hobby= req.getParameter("hobby");
		
		String name = req.getParameter("name");
//		System.out.println("age = " + age);
//		System.out.println("chk_gend = " + chk_gend);
//		System.out.println("hobby = " + hobby);
//		System.out.println("name = " + name);
		
		InfoDto infodto = new InfoDto(name, age, chk_gend, hobby);
		

		
		req.setAttribute("infodto", infodto);
//		System.out.println(infodto.toString());
		//여성일경우
		if(chk_gend.equals("womon")) {
			System.out.println(" womon in now ");
			RequestDispatcher dispatcher=req.getRequestDispatcher("womonServlet");
			dispatcher.forward(req, resp);
			
		}else if(chk_gend.equals("man")) {
			System.out.println(" man information now ");
			
			//-=== set session  ===========================================
			//infodto
			HttpSession session = null;
			session = req.getSession(false);
			/*
				getSession(false)
				session Object가 존재하면, 현재 HTTPsession을 반환한다. 
				존재하지 않으면, 그냥 null을 반환한다.  
				
				getSession(true)
				session Object가 존재하면, 현재 HttpSession을 반환한다. 
				존재하지 않으면, 새로 생성한다. 
			 */
			
			
			//======== set session  ===========================================
			System.out.println("helloServlet_session value= "+ session);
			if(session == null) {
				session = req.getSession(true);
				session.setMaxInactiveInterval(30);//기한을 주는곳이며, 초단위이다.
													//365*24*60*60 => 1년
//				session.setAttribute("visited", "1");
//				pw.println("<p>첫번째 방문입니다 </p>");
			}
				
				
				session.setAttribute("name", name);
				session.setAttribute("age", age+"");
				session.setAttribute("chk_gend", chk_gend);
				session.setAttribute("hobby", hobby);
				
				
				//세션등록완료
				resp.sendRedirect("manServlet");
//				response.sendRedirect
			
			
			//======== set session  ===========================================
			

/*
			//======== set session  ===========================================
			System.out.println("helloServlet_session valut= "+ session);
			if(session == null) {
				session = req.getSession(true);
				session.setMaxInactiveInterval(30);//기한을 주는곳이며, 초단위이다.
													//365*24*60*60 => 1년
//				session.setAttribute("visited", "1");
//				pw.println("<p>첫번째 방문입니다 </p>");
			}else {
				session = req.getSession(true);
				
				session.setAttribute("name", name);
				session.setAttribute("age", age+"");
				session.setAttribute("chk_gend", chk_gend);
				session.setAttribute("hobby", hobby);
				
				
				//세션등록완료
				resp.sendRedirect("manServlet");
//				response.sendRedirect
			}
			
			//======== set session  ===========================================
			
*/
			
		}
			
			

	}
	
	

}
