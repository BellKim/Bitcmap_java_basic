package sample11_example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Dispatch;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("helloServlet DO GET ");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("helloServlet do Post ");
		
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
	
			
	
			
		}
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
