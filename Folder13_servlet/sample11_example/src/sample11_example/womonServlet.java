package sample11_example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/womonServlet")
public class womonServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("womonServlet _ do Get NOW");
	}//end do get 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("womonServlet _ do Post NOW");
		InfoDto infodto = (InfoDto) req.getAttribute("infodto");
//		System.out.println("womon servlet");
//		System.out.println(infodto.toString());
		
		
		String name = infodto.getName();
		String age = infodto.getAge();
		String hobby = infodto.getHobby();
		String chk_gend = infodto.getChk_gend();
		resp.setContentType("text/html; charset=utf-8");		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>제목</title>");
		pw.println("</head>");
		
		pw.println("<body>");
				
		pw.println("<p>이름:" + name + "</p>");
		pw.println("<p>나이:" + age + "</p>");
		pw.println("<p>나이:" + hobby + "</p>");
		pw.println("<p>나이:" + chk_gend + "</p>");

		
		pw.println("</body>");
		
		pw.println("</html>");
		
		pw.close();
		
	
		
		
	}//end do post

}//end class
