package sessiondemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogOutController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String fid=(String)session.getAttribute("logOk");//ok 대소문자 구별
		if(fid!=null) {
			//세션 연결 종료
			session.invalidate();
		}
		resp.sendRedirect("login");
		
	}//end doGet();
	//로그아웃 누르면 로그인페이지가 떠야한다. 

}//end class;;;;
