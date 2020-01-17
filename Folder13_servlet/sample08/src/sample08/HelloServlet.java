package sample08;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Member;



public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		
		//짐싸 하기위함
//		resp.sendRedirect("sample?name="+name+"&age="+age);
		
		Member dto = new Member(name, age);
		req.setAttribute("dto", dto);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("sample");
		
		dispatcher.forward(req, resp);//dispatcher 로 이동
		//sampleservlet.java 의 doposet로 간다. 
		//forward 는 post로 간다. // 현재 위치에 따라서 이동 (post-> post)
		
		
		
		/*
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title> 제목 </title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1> Hello Servlet </h1>");
		pw.println("<p> Hello servlet</p>");
		pw.println("<h1>");
		pw.println("name = "+name);
		pw.println(" age = "+age);
		pw.println(" </h1>");
		
		pw.println("</body>");
		
		pw.println("</html>");
		*/
		
		
	}

}
