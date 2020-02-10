package boarddemo.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boarddemo.dao.BoardDAO;
import boarddemo.dto.PageDTO;

public class ListAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		/*2번째 --페이지 추가를위해서 내림*/
		String pageNum = req.getParameter("pageNum");
		if(pageNum == null || pageNum=="") {
			pageNum = "1";
		}
		
		String searchKey = req.getParameter("searchKey");
		String searchWord = req.getParameter("searchWord");
		
		HashMap<String, String> map =new HashMap<String, String>();
		map.put("searchKey", searchKey);
		map.put("searchWord", searchWord);
		
		
		int currentPage = Integer.parseInt(pageNum);
		BoardDAO dao = BoardDAO.getInstance();
		int cnt = dao.rowTotalCount(map); //여기에 넘긴다. 검색어를. 
		if(cnt>0) {
			//현재페이지번호와 전체레코드수를 넘겨줌. 
			PageDTO pdto = new PageDTO(currentPage, cnt, searchKey, searchWord);
			req.setAttribute("pdto", pdto);
			req.setAttribute("aList", dao.listMethod(pdto));
		}
		
		
		
		
		
		/*1번째 --페이지를 만들기 전에는  이거만 있었음.*/
/*		BoardDAO dao = BoardDAO.getInstance();
		req.setAttribute("aList", dao.listMethod());
		*/
		
		
	}//end execute()

	

}//end class


