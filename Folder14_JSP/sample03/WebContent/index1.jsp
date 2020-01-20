<%@page import="sample03.DtoClass"%>
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
		String addr="경기도";
		int age = 24;
		
	%>
	
	<%
		//request.setAttribute("addr", addr);
		//request.setAttribute("age", age);
		request.setAttribute("dto", new DtoClass(addr, age));
		//session.setAttribute("dto", new DtoClass(addr, age));
		//application.setAttribute("dto", new DtoClass(addr,age));
		
		pageContext.forward("NewFile3.jsp");
		//이 전송방식은 request.setAttribute() 와 //session.setAttribute 만 가능하다.
		
		//response.sendRedirect("NewFile3.jsp");	//session.setAttribute
		
		//response.sendRedirect("newFile3.jsp?addr"+addr + "&age="+age);
		
		
		
	%>

</body>
</html>