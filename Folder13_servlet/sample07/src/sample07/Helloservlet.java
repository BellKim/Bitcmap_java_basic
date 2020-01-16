package sample07;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Helloservlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String sage = req.getParameter("age");
		
		int age = Integer.parseInt(sage);
		
		String fruits[] = req.getParameterValues("fruit");
		
		//한번에 모으는부분
		ObjectDto dto = new ObjectDto(name, age, fruits);
		
		//짐싸
		req.setAttribute("Obj", dto);
		
		
		////////////////////////////////////
		//sendRedirect
		//resp.sendRedirect("resultServlet");		//단순이동, 그냥이동
		//resultServlet?name=... 으로 작성해서 보내주면  전송이 가능하다. 하지만  forward 를 사용해주면 더 쉽다.그러므로 사용하는것이 아니다. 
		
		//forward == 전진 
		req.getRequestDispatcher("resultServlet").forward(req, resp);
							//우리가 가려하는 링크부분.
		//forward는 짐을 가지고 이동한다.
		
		
		
		
		
		

		
		
	}


	

}
