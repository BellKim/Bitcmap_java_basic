<%@page import="dto.PdsDto"%>
<%@page import="dao.PdsDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
//upload함수			//중요 아파치 소속의 파일 아이템이다. 
//insert delete select update
public String processUploadFile(FileItem fileItem, String dir) throws IOException{
	String filename = fileItem.getName();	//들어오는 경로 ( 1. 서버경로  2. 클라이언트경로 )+ 파일명
	long sizeInBytes = fileItem.getSize();
	
	//파일이 정상일 경우 
	if(sizeInBytes > 0){//파일경로 입력방법 :  1. d:\\tmp\\abc.txt   2.  d:/tmp/abc.txt
		int idx = filename.lastIndexOf("\\");//경로의 마지막 \\ 의 값을 받아온다.
		if(idx==-1){
			idx=filename.lastIndexOf("/");		//다른 형식의 파일경로 입력방법을 도입힌다.
		}
		
		filename=filename.substring(idx+1);	//abc.txt
		
		File uploadFile = new File(dir, filename);
		
		try{
		fileItem.write(uploadFile);
		} catch(Exception e){
			
		}
		
	}

	return filename;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdsupload.jsp</title>
</head>
<body>
<%	//tomcat배포(server)
String fupload = application.getRealPath("/upload");
//업로드 폴더가 있어야 한다.

	//지정폴더(client)
//String fupload = "d:\\tmp";
System.out.println("업로드 폴더를 봅시다  =  " + fupload);

String yourTempDir = fupload;


int yourMaxRequestSize = 100 * 1024 * 1024;	//upload했을때 의 최대 사이즈 설정(1MB)
int yourMaxMemorySize = 100* 1024;			//1Kbyte

// form field의 데이터를 저장할 변수 
String id = "";
String title = "";
String content = "";

//file name 
String filename = "";
boolean isMultiPart = ServletFileUpload.isMultipartContent(request);

if(isMultiPart == true){
	//FileItem. 설정
	DiskFileItemFactory factory = new DiskFileItemFactory();
	
	factory.setSizeThreshold(yourMaxMemorySize);
	factory.setRepository(new File(yourTempDir));//java의 fileio
	
	ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setSizeMax(yourMaxRequestSize);
	
	//list저장 -> id, title, content, file 
	List<FileItem> items = upload.parseRequest(request);
	Iterator<FileItem> it = items.iterator();
	
	//구분
	while(it.hasNext()){
		FileItem item = it.next();
		if(item.isFormField()){// ID, title, content
			if(item.getFieldName().equals("id")){
				id=item.getString("UTF-8");
			} else if(item.getFieldName().equals("title")){
				title=item.getString("UTF-8");
			} else if(item.getFieldName().equals("content")){
				content=item.getString("UTF-8");
			}
		
		
		} else {	//fileload
			if(item.getFieldName().equals("fileload")){
				//filename = processuploadfile(item, fupload);
				filename = processUploadFile(item, fupload);
				
			}
			
			
		}
		
		
	}
}else{
	System.out.println("multipart 가 아님");
}
// DB에 저장
PdsDao dao = PdsDao.getInstance();
boolean isS = dao.writePds(new PdsDto(id, title, content, filename));
if(isS){
%>
	<script type="text/javascript">
	alert("성공");
	location.href="pdslist.jsp";
	</script>

<%
}else{
	%>
	<script type="text/javascript">
	alert("실패");
	location.href="pdslist.jsp";
	</script>
	<%
}
%>




</body>
</html>