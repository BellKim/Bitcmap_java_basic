package pictureview;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testDel")
public class TestDelController extends HttpServlet{
	
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String []chk= req.getParameterValues("chk");
	TestDAO dao = TestDAO.getInstance(); //db연결, dao객체값 받아오기.
	List<String> aList = dao.fileList(chk);
	
	for(String fileData : aList) {
		File file = new File("c:/temp/",fileData);
		file.delete();
	}
	dao.deleteMethod(chk);
	resp.sendRedirect("previewList");
	
	
	
	
	
	
	
	
	
	
	
	
	
}//end doPost;;;;;;;;;;;;;
	
	
/*	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			TestDAO dao = TestDAO.getInstance();
			ArrayList<TestDTO> aList = dao.selectMethod();
			req.setAttribute("aList", aList);
			RequestDispatcher dis = req.getRequestDispatcher("/picturePreview/list.jsp");
			dis.forward(req, resp);
			
			
	}//doget//////////////////////////////////////
	
	
	
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String []chk= req.getParameterValues("chk");
	TestDAO dao = TestDAO.getInstance();
	
	for(int i=0; i<chk.length; i++) {
		int num = Integer.parseInt(chk[i]);
		dao.deleteMethod(num);
	}
	resp.sendRedirect("testDel");
}
	*/

}
