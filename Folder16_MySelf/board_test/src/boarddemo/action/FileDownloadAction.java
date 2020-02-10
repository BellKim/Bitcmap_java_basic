package boarddemo.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boarddemo.dao.BoardDAO;

public class FileDownloadAction {
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		//다운로드시 num값을 넘기는데 num에 해당하는 첨부파일을 다운받는다. boardDAO에 fileMethod 작성. 
		//작성후 다운로드창에 띄워주기 위해서 추가 적업을 해야한다. 

		int num = Integer.parseInt(req.getParameter("num"));
		BoardDAO dao = BoardDAO.getInstance();
		String filename = dao.fileMethod(num);

		try {
			// 파일명 한글처리
			String convName = URLEncoder.encode(filename, "UTF-8");
			convName=convName.replace("+", " ");

			// 다운로드창에 띄우는  컨텐트 타입 설정방법 			
			resp.setContentType("application/octet-stream");

			// 다운로드 파일명
			resp.setHeader("Content-Disposition", "attachment;filename=" + convName + ";");

			//String saveDirectory = req.getRealPath("/");
			//File file = new File(saveDirectory + "/temp/" + filename);
			File file = new File("c:/temp/" + filename);
			

			// 서버의 파일첨부 읽어오기

			FileInputStream is = new FileInputStream(file);
			BufferedInputStream bs = new BufferedInputStream(is);

			// 클라이언트에 파일내용보내기
			BufferedOutputStream bo = new BufferedOutputStream(resp.getOutputStream());

			byte buffer[] = new byte[1024];
			int len = 0;
			while ((len = bs.read(buffer)) > 0) {//서버에있는 파일의 바이트1024 단위로 읽어옴. 
				bo.write(buffer, 0, len);
				bo.flush();
			}

			// 스트림 연결 종료
			bs.close();
			is.close();
			bo.close();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}//end execute();;

}//end FileDownloadAction();/////////////
