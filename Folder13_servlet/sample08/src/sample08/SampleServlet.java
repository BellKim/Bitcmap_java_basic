package sample08;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;

public class SampleServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("sampleServlet do get");
		req.setCharacterEncoding("utf-8");
		
		/*
		String name=req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		String newname = URLEncoder.encode(name);
		
		System.out.println("newname = " + newname);
		System.out.println("age = " + age);
		*/
		

		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("sampleServlet do post");
		Object obj = req.getAttribute("dto");
		Member mem = (Member) obj;
		
		System.out.println(mem.toString());
		//객체로 묶어서 보낼때에는 url인코딩을 안해도 된다.
		
		//sendRedirect, forward
//		String name="성춘향";
//		int age = 17;
		
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		// 다시 form으로 가기위한 포장임. 
		Member member = new Member(name, age);
		req.setAttribute("member", member);
		
		req.getRequestDispatcher("detail.jsp").forward(req,resp);
		
		
		
		
		
		
	}
	
	

}
