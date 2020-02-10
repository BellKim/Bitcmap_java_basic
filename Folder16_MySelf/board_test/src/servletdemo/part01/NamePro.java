package servletdemo.part01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/namePro")
public class NamePro extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname"); //nameView.jsp의 name=fname
		//result.jsp에서 사용할 수 있도록 requet영역에 저장. 
		req.setAttribute("fname", fname); //이 이름으로 , 이 값을 저장하겠다는소리.(name,value)
		RequestDispatcher dis=
				req.getRequestDispatcher("/servletview/part01/result.jsp");
		
		//디스페쳐에 응답해줄 페이지에 저장을한다. (디스페쳐가뭔지몰라도 문장 그대로 이해하자.)
		
		//응답해줄 페이지를 이동하기위해서 작성.
		dis.forward(req, resp);
		
		
		 
		
	}//end doGet()////

}//end class

/*webcontent/servletview/part01/result.jsp 만들고 와라. 
 * @WebServlet("namePro")
 * extends HttpServlet
 * doget()
 * 	result 파일에서 값을받아야한다. req.getParameter(arg0) 입력
 * 파라미터값을 입력받을라면 뭐를가지고 받는가. value
 * 
 * id class name 의 역할에 대해서 알아봐라 .
 * 파라미터값을 넘길때는 name 속성에 있는 이름에 값을 얹혀서 보낸다. 
 * req.setAttribute("fname", fname); //이 이름으로 , 이 값을 저장하겠다는소리.
 * //디스페쳐에 응답해줄 페이지에 저장을한다. (디스페쳐가뭔지몰라도 문장 그대로 이해하자.)
 * 
 * //응답해줄 페이지를 이동하기위해서 작성.
		dis.forward(req, resp);
		
		
 * 
 * 위 순서에 의해서 작업을 해주면 된다.
 *  
 *  --basic 에서 실행해주기.
 *  
 * */
