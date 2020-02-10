package sessiondemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*
 *http 프로토콜은 한번의 요청과 응답이 되면 클라이언트와 서버의 연경리 끊어짐 이를 해결하기 위해서 session을 이용해 클라이언트 정보를 서버에 저장함으로서  
 *클라이언트와 서버의 연결을 지속시켜줌. 
 *
 */

@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("/sessionview/login.jsp");
		dis.forward(req, resp);//페이지 연결 . 
		
	}//end doget()
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//입력한 바밀번호를 받아오기위해서 설정한다. memdto에 저장. 
		String fid = req.getParameter("fid");
		String fpass = req.getParameter("fpass");
		MemDTO dto = new MemDTO();
		dto.setFid(fid);
		dto.setFpass(fpass); //id pass 를 하나의 객체에 넣어서 보내준다. 
		
		MemDAO dao = MemDAO.getInstance();
		int cnt = dao.memCheck(dto);
		//cnt 값이 있ㄸㅏ  = 회원이다
		//client와 server 
		HttpSession session = req.getSession();//세션객체값을 리턴받아온다.
		if(cnt==1) { //회원이면!
			//회원이니까 연결을 지속시켜주어야한다.
			//jsp에서는 그냥 sessoinsetAttribute()로 가져왔음. 서블릿에서는 다음과같이한다. 
			//request 객체를 가지고 session 객체값을 받아온다.
			
			//클라이언트 정보저장을해준다. 
			session.setAttribute("logOk", fid);//fid 는 클라이언트를 구분지어줄수 있는 유일한 값이기 때문에 사용. 큰따움표 대소문자 구별 유의할것.
			session.setMaxInactiveInterval(30*60);//30분. 아무런 동작을 하지않을때의 시간. 
			//--여기까지하고 login컨트롤.자바로 이동.
			//resp.sendRedirect("login?chk=1"); //본래는 그냥 login인디 구별을 위해서 파라미터값을 추가한다.
			
			session.setAttribute("chk", 1);
			resp.sendRedirect("login");
			
			
//			-->login.jsp의 login클레스위로 이동  
		} else {//회원이 아니면 시작
			//resp.sendRedirect("login?chk=2"); //1파라미터 오픈.
			
			session.setAttribute("chk", 2);
			resp.sendRedirect("login");//파라미터 하이드.
			
			
			
			
			
		}
		
		
		
		
		
		
	}//end do post;;
	
	
	

}//end class
