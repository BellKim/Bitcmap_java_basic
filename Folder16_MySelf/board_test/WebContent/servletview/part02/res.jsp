<%@page import="servletdemo.part02.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> res.jsp </title>
	</head> 
	<body>
		<%
		 MemberDTO dto = (MemberDTO)request.getAttribute("dto");
		//작성후임폴트
		%>
		<p>
			<%=dto.getFid() %> / <%=dto.getFpass() %>
		</p>
	
	</body>
</html>

 