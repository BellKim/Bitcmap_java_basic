package boarddemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boarddemo.dao.BoardDAO;
import boarddemo.dto.BoardDTO;

public class SearchWordAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		BoardDAO dao = BoardDAO.getInstance();
		String searchKey = req.getParameter("searchKey");
		String searchWord = req.getParameter("searchWord");
		System.out.println(" 입력된 검색어  \r key =  " + searchKey + "  word =   " +searchWord + "\r\r ");
		
		//BoardDTO dto = dao.searchMethod(searchKey, searchWord);

		
		
	}
}
