package sample05;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class myservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do get");
		
		String age = req.getParameter("age");
		System.out.println("age = "+age);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("do post");
		
		String url = req.getParameter("url");
		
		//link를 설정한 경우 
		resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		//이 설정을 빼먹으면 링크가 정상동작 하지 않는다.
		
		if(url.equals("naver.com")) {
			resp.setHeader("Location", "https://www.naver.com/");
			//setHeader 의 입력 파라미터 : 첫번째 : 정해져있다, 두번째 : 가려고하는 링크 또는 주소; 
		}else if(url.equals("google.com")) {
			resp.setHeader("Location", "https://www.google.com/");
		}else {
			resp.setHeader("Location", "https://www.zum.com/");
		}
		
	}
	
	

}
