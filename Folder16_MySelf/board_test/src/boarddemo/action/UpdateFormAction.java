package boarddemo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boarddemo.dao.BoardDAO;
import boarddemo.dto.BoardDTO;

public class UpdateFormAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
//		view.jsp에서 수정버튼(update) 를 누르면 쿼리를 수행하도록
		int num = Integer.parseInt(req.getParameter("num"));
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.viewMeethod(num);
		
		req.setAttribute("dto", dto);
		//여기까지 작성하면 작성된 텍스트가 나온다. 
		/*
		 * 새로 수정시
		 * 기존파일이 있을때, 수정(업데이트 수행), 비수정(업데이트 수행안함, 기존파일 넘겨주기)
		 * 기존파일이 없을때 , 추가(업데이트 수행), 유지(업데이트 비수행)
		 */
		
	}//end execute ();

}//class 
