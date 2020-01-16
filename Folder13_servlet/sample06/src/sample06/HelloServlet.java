package sample06;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//	System.out.println("HelloServlet doGet");
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		String sage = req.getParameter("age");
		
		System.out.println("이름:" + name);
				
		int age = 0;		
		if(sage == null || sage.trim().equals("") ) {
			resp.sendRedirect("index.html");
		}else {
			age = Integer.parseInt(sage);
		}
		
		String fruits[] = req.getParameterValues("fruit");
		/*
		 * if(fruits == null || fruits.length <= 0) { resp.sendRedirect("index.html"); }
		 */
		String fArr = "";		
		for (int i = 0; i < fruits.length; i++) {
			fArr = fArr + "&fluit=" +  fruits[i];
		}
		// &fluit=apple&fluit=pear
		
		resp.sendRedirect("resultServlet?name=" + URLEncoder.encode(name) + "&age=" + age + fArr);	// html <a
		
	//	RequestDispatcher dispatch = req.getRequestDispatcher("resultServlet");
	//	dispatch.forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	
	}
	
	

}
