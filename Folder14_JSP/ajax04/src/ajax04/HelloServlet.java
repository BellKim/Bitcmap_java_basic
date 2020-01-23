package ajax04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.CustUserDto;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<CustUserDto> list = new ArrayList<CustUserDto>();
		list.add(new CustUserDto(1001, "정수동동"));
		list.add(new CustUserDto(1002, "성츈햐앙"));
		
		resp.setContentType("application/json");		//형식으로 json으로 변환
 		resp.setCharacterEncoding("utf-8");				//깨진한글을 정상으로 출력.
 		
 		
 		//gson 2.8.5.jar 추가 
 		//https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.5
 		String gson = new Gson().toJson(list);			//google json
 		resp.getWriter().write(gson);
		
		
		
		
	}//end of post
	
	

}//end of class
