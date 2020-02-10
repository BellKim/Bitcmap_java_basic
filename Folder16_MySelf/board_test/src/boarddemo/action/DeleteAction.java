package boarddemo.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boarddemo.dao.BoardDAO;

public class DeleteAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String saveDirectory="c:/temp/";
		BoardDAO dao = BoardDAO.getInstance();
		int num = Integer.parseInt(req.getParameter("num"));
		String filename = dao.fileMethod(num);
		if(filename != null) {
			File file = new File(saveDirectory, filename);
			file.delete();
		}
		dao.deleteMethod(num); 	//뷰카운트 num값을 넘겨줌. 
		
		
	}//end execute();
	

}
