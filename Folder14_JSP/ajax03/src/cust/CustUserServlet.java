package cust;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CustUserDto;
import jdk.nashorn.api.scripting.JSObject;
import net.sf.json.JSONObject;

@WebServlet("/custuser")
public class CustUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	System.out.println("CustUserServlet doGet");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		System.out.println("id:" + id);
		System.out.println("pwd:" + pwd);
		
		// 전송 Data
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", "사과");
		
		List<CustUserDto> list = new ArrayList<CustUserDto>();
		list.add(new CustUserDto(101, "홍길동"));
		list.add(new CustUserDto(102, "일지매"));		
		map.put("list", list);
		
		//String str = "Hello";
		
		JSONObject obj = new JSONObject();
	//	obj.put("str", str);		
		obj.put("map", map);
		
		resp.setContentType("application/x-json; charset=UTF-8");
		resp.getWriter().print(obj);
	}	
	
}





