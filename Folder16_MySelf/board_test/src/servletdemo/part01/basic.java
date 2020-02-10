package servletdemo.part01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
		//http://localhost:8090.webdemo/servlet/servletdemo.part01.basic
		//http://localhost:8090.webdemo/basic
/*	
 * 	환경설정
 * 1. xml
 * 2. annotation(@)
 * 3. properties

 * */

	//여기 상속받을 것들을 써줘야한다. 
@WebServlet("/basic")//임폴트함 한 어플리케이션에 이름이 하나만 있어야한다. 자식들에게 똑같은이름을 안주듯.
//       //basic.nhm 으로 추가해줘도된다.... 중복이 되면 실행이 안된다 안되
//	실제 경로가 노출이 안되도록 되어있다. 거두절미하고 /basic 이 ㄷ주소가 되니까. (과거에는 루트폴더부터 쭉 
//브라우저 결과값이 안나오면 콘솔창가서 확인해봐야한다. 

public class basic extends HttpServlet{//httpservlet을 상속받아서 구현해줘야한다. //임폴트 
	//http://localhost:8090/webdemo/ 를 띄우기위해서 httpservlet 을 상속받아서 호출해온다. 
	
	//get, post 방식에 따라서 호출되는 메소드가 달라진다. 
	/*get방식은  겟 메소드가 호출되어 처리. doget 치고 ctrl + space 
	post 방식은 두포스트 메소드가 호출되어 처리.
	doget 할떄 	
	// TODO Auto-generated method stub
		super.doGet(req, resp); 			가 나오는디 이것두 지워줘야한다.
		겟방식
		<form method="post"/> 
		<href="basic" .....    등등. 
	*/
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//						  doGet(요청정보, 응답정보처리)
		//자료형 두가지 HttpServletRequest req, HttpServletResponse resp 꼭 기억해야한다. (자동완성이라서 기억을 잘못함 중요함. )
		
		
		RequestDispatcher dis = 
		req.getRequestDispatcher("/servletview/part01/nameView.jsp");
		//클라이언트에 응답. 
		dis.forward(req, resp);//응답은 긴 주소로 되지만 결과주소창은 짧은 주소로 나온다. 
		
	}//end doGet()
	


/*페이지 요청 - 서버수신 - Basic으로 등록된 페이지를 찾는다. (/basic) 이 클레스가있는 요청메소드 doget()으로 요청, 호출되서 객체값을 받아올 정보 추가(RequestDispatcher )
응답은 	dis.forward(req, resp);로 하고 실질적으로  req.getRequestDispatcher( )로 응답받아옴.*/ 
}//end basic
