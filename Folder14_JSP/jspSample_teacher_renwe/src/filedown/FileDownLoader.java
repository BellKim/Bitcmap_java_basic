package filedown;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/filedown")
public class FileDownLoader extends HttpServlet{
	
	ServletConfig mconfig = null;
	static final int BUFFER_SIZE = 8192;//8kb의 임시저장공간 이다. 

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO 업로드 폴더 경로를 취득하기 위해서 config에 접근한다.
		super.init(config);
		mconfig = config;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" file download 의 do get ");
		System.out.println(" ");
		
		String filename = req.getParameter("filename");
		String sseq = req.getParameter("seq");
		
		//down load 횃수 증가(DB)
		BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());
		String filePath = "";
		
		// tomcat(server)
		filePath = mconfig.getServletContext().getRealPath("/upload");
		
	
		//폴더(client)
		//filePath = "d:\\tmp";
		
		filePath = filePath + "\\" + filename;
		System.out.println("다운로드 대상파일 : " + filePath);
		
		File f = new File(filePath);
		
		if(f.exists() && f.canRead()) {
			System.out.println("파일이 맞고 대상이 맞습니다. ");
			resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
			resp.setHeader("Content-Transfer-Encoding", "binary;");
			resp.setHeader("Content-Length", "" + f.length());
			resp.setHeader("Pragma", "no-cache;"); 
			resp.setHeader("Expires", "-1;");
			
			//파일을 생성, 기입
			BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(f));
			byte buffer[] = new byte[BUFFER_SIZE];
			
			int read = 0;
			while ((read = fileInput.read(buffer)) != -1) {
				out.write(buffer, 0, read);	//실제 다운로드 되는 부분.
			}
			fileInput.close();
			out.flush();
			
		}
	}
	
	/*
	 FileDownloader 다운로드수
	 
	 PdsDetail 조회수
	 
	 PdsDelete DB에서만 삭제
	 
	 PdsUpdate
	 
	 
	 
	 
	 
	 */
	
	

}//end class
