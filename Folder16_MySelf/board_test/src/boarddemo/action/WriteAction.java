package boarddemo.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import boarddemo.dao.BoardDAO;
import boarddemo.dto.BoardDTO;

public class WriteAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//멀티파트리퀘스트로 파라미터값을 받아야한다. 
		MultipartRequest multi = null;
		String saveDirectory = "c:/temp";
		File file = new File(saveDirectory);
		if(!file.exists())
			file.mkdir();
		int maxPostSize = 100000000; //1GB
		String encoding = "UTF-8";
		
		try {
			multi = new MultipartRequest(req, 
					saveDirectory, maxPostSize, 
					encoding, new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BoardDTO dto = new BoardDTO();
		dto.setWriter(multi.getParameter("writer"));
		dto.setEmail(multi.getParameter("email"));
		dto.setSubject(multi.getParameter("subject"));
		dto.setContent(multi.getParameter("content"));
		dto.setUpload(multi.getFilesystemName("upload"));

		BoardDAO dao = BoardDAO.getInstance();
		/*ref = 해당 num 에 부여받은 ref 번호와 동일. 
		 * 동일한 ref의 순서번호 
		 * */
		
		//답변글이면, 
		if(multi.getParameter("re_level") != null) {
			HashMap<String, Integer> map = 
					new HashMap<String, Integer>();
			map.put("ref", Integer.parseInt(multi.getParameter("ref")));
			map.put("re_step", Integer.parseInt(multi.getParameter("re_step")));
			dao.reStepMethod(map);
			
			dto.setRef(Integer.parseInt(multi.getParameter("ref")));
			//view.jsp에서 넘어온 값이다.  개발 의도에 맞춰서 +1 +1 되어야 한다. 
			dto.setRe_step(Integer.parseInt(multi.getParameter("re_step"))+1);
			dto.setRe_level(Integer.parseInt(multi.getParameter("re_level"))+1);
			
		}
		
		
		
		
		dao.insertMethod(dto);

		
	}//end execute()
	
}//end class

