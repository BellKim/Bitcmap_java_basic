package servletdemo.part04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/problem")
public class ProblemController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("servletview/part04/form.jsp");
		dis.forward(req, resp);
	}//end doGet());;;;
	
	//여기까지 form.jsp 작성후 컴파일해보기
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//겟방식일때는 config 폴더에 server.xml 에 설졍한 UTF-8 인코딩 셋팅한것으로 인코딩이 자동으로 되지만 
		//post 방식에서는 java 파일에서 encodeing을 해줘야한다. 
		
		//req.setCharacterEncoding("UTF-8");//post방식일때의 한글처리방식
		String ko=req.getParameter("ko");
		System.out.println(ko);//ko라는 속성값으로 value 를 넘겨받는다. 하지만 한글이라 깨져버림.
		//그래서 값을 받아옴에 앞서서 인코딩해야한다.req.setCharacterEncoding("UTF-8");
		
		String res = " ";
		if(ko.equals("서울")) {
			res=ko+"는(은) 정답입니다.";
		}else {
			res=ko+"는(은) 정답이 아니네요?.";
		}
		
		req.setAttribute("res", res);
		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part04/result.jsp");
		
		dis.forward(req, resp);
		
		
		
	}//end doPost()
	

}//end class
