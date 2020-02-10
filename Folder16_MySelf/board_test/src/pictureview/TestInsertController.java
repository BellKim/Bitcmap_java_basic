/*package pictureview;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/insertMain")
public class TestInsertController extends HttpServlet{
	
	url과 서블릿을 연결(맵핑) 시켜주는것을 웹서블릿 어노테이션이 한다. 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher dis = 
				req.getRequestDispatcher("/picturePreview/insert.jsp");
		dis.forward(req, resp);		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		멀티파트 폼일떄는 리퀘스트를 통해서 파라미터 값을 받아올수가 없다.
		String filepath=req.getParameter("filepath");
		System.out.println(filepath); null 이 되는지 확인하고 왜인지 생각해본다.

		//cos.jar 파일을 다운받아서 lib 에 넣어준다.
		
		MultipartRequest multi = null;
		String saveDirectory = "c:\\temp";
		
		new
 * 		String saveDirectory = req.getRealPath("/");
		System.out.println(saveDirectory);
		saveDirectory +="/temp";
		
		
		File file = new File(saveDirectory);
		if(!file.isDirectory())//디렉토리가 없으면
			mkdirs - 복수파일
			mkdir - 단일파일
			file.mkdir();
		//클라이언트가 서버에 파일을 보내는데 있어서 용량제한을 두는것
		int maxPostSize = 1*1000*1000*1000; //1GB 크기까지 전송제한. (킬로바이트단위
					//		킬로      메가      기가    *1000 테라
							
		//encoding 방식
		String encoding = "UTF-8";
		
		//DefaultFileRenamePolicy : 서버에 저장된 첨부파일의 중복제거. 
		multi = new MultipartRequest(req, saveDirectory, maxPostSize, encoding, new DefaultFileRenamePolicy());
								// 리퀘스트, 파일위치, 전송제한값, 인코딩타입, 같은이름의 파일 중복제거를 가능하게 해준다.;
								// 서버저장후에 테이블에 저장된다. 그러므로 양쪽에 다 들어가있는지 확인을 해야한다. 
		
//		<input type = "file"/> 일때는 getFileSystemName() 메소드로 받는다.
		String filepath = multi.getFilesystemName("filepath");
		
		TestDAO dao = TestDAO.getInstance();
		dao.insertMethod(filepath);
		resp.sendRedirect("previewList");
	}//end doPost()
}//end class

	8090/webdemo/
 * 	8090/webdemo/images/allmenutitle.gif
 * 
 * 


*/


package pictureview;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/insertMain")
public class TestInsertController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dis =
 req.getRequestDispatcher("/picturePreview/insert.jsp");
		dis.forward(req, resp);
	}
	
	
	//cos.jar 다운받음
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MultipartRequest multi = null;
		String saveDirectory = "c:\\temp";
		
		/*String saveDirectory=req.getRealPath("/");
		System.out.println(saveDirectory);
		saveDirectory += "/temp";*/
		
		File file = new File(saveDirectory);
		if(!file.isDirectory())
			file.mkdir();
		
		int maxPostSize = 1 * 1000 * 1000 * 1000;// 1GB 크기 지정
		
		// encoding 방식
		String encoding = "UTF-8";
		
		//DefaultFileRenamePolicy : 서버에 저장된 첨부파일 중복제거
		multi=new MultipartRequest(req, saveDirectory,maxPostSize,encoding,new DefaultFileRenamePolicy());
		
		//<input type="file" /> 일때는 getFilesystemName()메소드로 받는다.
		String filepath = multi.getFilesystemName("filepath");
		
		TestDAO dao = TestDAO.getInstance();
		dao.insertMethod(filepath);
		resp.sendRedirect("previewList");
		//삭제를 하고 리스트를 다시 보여줘야 하니까 이부분을 보여준다. 
		
		
		
	}//end doPost()
}// end class













