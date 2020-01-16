package sample04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myservlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code");

		System.out.println("code = " + code);
		
		//initparam
		String tax = this.getInitParameter("tax");
		
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title> 제목 </title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		if(code.equals("200")) {
			pw.println("<p>200:SC_OP</p>");
		}else if(code.equals("404")) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND,"페이지를 찾을 수 없습니다."); 
		}else if(code.equals("500")) {
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "코드가 틀렸습니다. "); 
		}
		
		pw.println("<p> TAX : "+ tax +"</p>");
		
		pw.println("</body>");
		
		pw.println("</html>");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	public void createHTML(String methodType, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String code = req.getParameter("code");
		
		System.out.println("code = " + code);
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title> 제목 </title>");
		pw.println("</head>");
		
		pw.println("<body>");
		
		if(code.equals("200")) {
			pw.println("<p>200:SC_OP</p>");
		}else if(code.equals("404")) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND,"페이지를 찾을 수 없습니다."); 
		}else if(code.equals("500")) {
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "코드가 틀렸습니다. "); 
		}
		

		
		pw.println("</body>");
		
		pw.println("</html>");
	}
	
	
	
}
