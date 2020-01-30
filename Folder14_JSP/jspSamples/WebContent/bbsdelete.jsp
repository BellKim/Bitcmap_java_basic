<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String seq = request.getParameter("seq");
	System.out.println("Receive seq = " + seq);
	BbsDao dao = BbsDao.getInstance();
	boolean isS = dao.deleteBbs(seq);
%>
	
	<script type="text/javascript">
<%
	if(isS==true){
%>
	alert("글 삭제 성공");
	location.href="bbslist.jsp";

<%
	}else{
%>
	alert("글 삭제 실패");
<%
	}
%>
	</script>
</body>
</html>