package servletdemo.part02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *	String fid
 *	String fpass
 *	System.out.println(fid+" "+fpass); 
 */
@WebServlet("/loginPro")
public class LoginProController extends HttpServlet{
	@Override//메소드 포스트로 서야욯애한다.
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fid= req.getParameter("fid"); 
		String fpass= req.getParameter("fpass");
		
		MemberDTO dto=new MemberDTO();
		dto.setFid(fid);
		dto.setFpass(fpass);	//
		req.setAttribute("dto", dto);
		
		RequestDispatcher dis = 
				req.getRequestDispatcher("/servletview/part02/res.jsp");
		dis.forward(req, resp);
		
		
		
		
		
		//System.out.println(fid+" "+fpass);
		
	}

	
	//테이블컬럼 . dto 의값 jsp의 값 모두 같게 해라. 
	
	


}
