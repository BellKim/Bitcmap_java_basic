package boarddemo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import boarddemo.action.DeleteAction;
import boarddemo.action.FileDownloadAction;
import boarddemo.action.ListAction;
import boarddemo.action.UpdateFormAction;
import boarddemo.action.UpdateProAction;
import boarddemo.action.ViewAction;
import boarddemo.action.WriteAction;

@WebServlet("/board/*")		//  요청을 하기위해서   "  /*   "  을 쓴다. 
public class BoardController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);//get이던 post던 process에서 처리하도록 하기위해서 추가한다. 
					//모든 권한을 process에게 넘김
	}//end doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);//get이던 post던 process에서 처리하도록 하기위해서 추가한다.
					//모든 권한을 process에게 넘김
	}//end doPost
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();	// 
			// 	/webdemo/board/*
		String path="";
		System.out.println(uri);
		String action = uri.substring(uri.lastIndexOf("/"));	//indexof가 아닌 lastIndexOf() 를 사용.
												//인덱스값인 /을 가져오는데 LASTINDEXOF 를해서 끝까지 가져와라 라는뜻. 
		if(action.equals("/*") || action.equals("/list.do")){
			System.out.println("listPage");
			ListAction list = new ListAction();
			list.execute(req, resp); //LIST를 수행해라
			path="/boardview/list.jsp";
			//wevdemo/board/view.do
			
		} else if(action.equals("/view.do")) {//메인에서 글쓰기 버튼 클릭시
			ViewAction view = new ViewAction();
			view.execute(req, resp);
			path="/boardview/view.jsp";
		} else if(action.equals("/writeForm.do")) {
			path="/boardview/write.jsp";
		} else if(action.equals("/write.do")) {//arraylist를 사용해야함. 왜 리다이렉트 했는지 생각좀..
			WriteAction write = new WriteAction();
			write.execute(req, resp);
			resp.sendRedirect("list.do");			
		} else if(action.equals("/download.do")) {//view.jsp 에 downloa.do
			FileDownloadAction download = new FileDownloadAction();
			download.execute(req, resp);
		} else if(action.equals("/updateForm.do")) {
			UpdateFormAction uform = new UpdateFormAction();
			uform.execute(req, resp);
			path="/boardview/update.jsp";
		} else if(action.equals("/updatePro.do")) {
			UpdateProAction pro = new UpdateProAction();
			MultipartRequest multi = pro.execute(req, resp);
			resp.sendRedirect("list.do?pageNum=" + multi.getParameter("pageNum"));
		} else if(action.equals("/delete.do")) {
			DeleteAction write = new DeleteAction();
			write.execute(req, resp);
			resp.sendRedirect("list.do?pageNum="+req.getParameter("pageNum"));
		}
		
		
		
		
		
		if(path != "" ) {
			System.out.print("uri : "+uri +"  action :: " + action + " ");
			RequestDispatcher dis = req.getRequestDispatcher(path); //LIST.JSP로 값을 넘겨줘라. 
			dis.forward(req, resp);
			
		}
		
		
	}	//end process()
	

}
