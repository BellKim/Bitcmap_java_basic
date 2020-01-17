
<%@page import="dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	 	Member mem = (Member)request.getAttribute("member");
    	System.out.println("detail.jsp 의 값 출력 ");
    	System.out.println(mem.toString());
	 
	 %>
	 
	 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> detail.jsp </title>
</head>
<body>
	<!-- 
		index.html -> java(HelloServlet.java) -> java(SampleServlet) -> detail.jsp 
				  name						Object											
	 
	 detail.html일 경우 데이터를 받아줄수 있는 경우가 Ajax 이다.  
	 
	 -->
	 
	 <h3>detail.jsp</h3>
	 이름 : <p> <%=mem.getName()%> </p>
	나이 : <input type="text" value="<%=mem.getAge() %>">


</body>
</html>