package servletdemo.part05;

import java.io.IOException;
import java.util.Random;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/game")
public class GameController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis = req.getRequestDispatcher("servletview/part05/input.jsp");
		dis.forward(req, resp);
	}// end doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String gg=req.getParameter("gg");
		System.out.println(gg);
		//------수업코드 ----------------------------------
		String person=gg;
		
		Random ran = new Random();
		int computer = ran.nextInt(3) + 1;
		String type = " ";
		
		if(computer == 1 ) {
			if(person.equals("가위")) {
				type = "컴 : 가위, 유저 가위 무숭부";
			}else if(person.equals("바위")) {
				type = "컴 : 가위, 유저 바위  유저 승";
			}else {
				type = "컴:가위, 유저 보 컴승";
			}
					
		}else if(computer == 2) {
			if(person.equals("가위")) {
				type = "컴 : 바위, 유저 가위 컴승";
			}else if(person.equals("바위")) {
				type = "컴 : 바위, 유저 바위  유저 무승부";
			}else {
				type = "컴:바위, 유저 보 유저스응";
			}		
		}else {
			if(person.equals("가위")) {
				type = "컴 : 보, 유저 가위 유저승";
			}else if(person.equals("바위")) {
				type = "컴 : 보, 유저 바위  유저 컴승";
			}else {
				type = "컴: 보 , 유저 보 비김";
			}
		}
		
		/*req.setAttribute("res", type);
		RequestDispatcher dis = req.getRequestDispatcher("/part05/gameResult.jsp");
		dis.forward(req, resp);*/

		
		req.setAttribute("res", type);
		RequestDispatcher dis = req.getRequestDispatcher("servletview/part05/gameResult.jsp?res="+type);
		dis.forward(req, resp);
		
			
		}
			

		//------수업코드 --------끝 !!!!!!--------------------------		
		
/*		
  		String input= " ";
		if(gg.equals("가위")) {
			input="1";
		}else if(gg.equals("바위")) {
			input="2";
		}else if(gg.equals("보")) {
			input="3";
		}else {
			input="error";
		}

		double radomValue = Math.random();
		int intValue = (int)(radomValue*2)+1;
		String change= String.valueOf(intValue);
		System.out.println("렌덤값 : "+ change);
		
		
		
		String res=" ";
		
		if(input.equals(change)) {
			res="비김";
		}else if{
			res=gg+"이기거나 짐";
		}
		
		
		req.setAttribute("res", res);
		RequestDispatcher dis = req.getRequestDispatcher("/servletview/part05/gameResult.jsp");
		
		dis.forward(req, resp); 		
	}*/

}//end class
