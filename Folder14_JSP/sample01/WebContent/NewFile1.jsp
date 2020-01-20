
<%@page import="sample01.human"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	Object obj = session.getAttribute("human");
    	human human = (human)obj;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>NewFile1.jsp</h3>
	
	num:<input type="text" value="<%=human.getNum() %>">
	name:<input type="text" value="<%=human.getName() %>">
	nameptag : <p><%=human.getName() %></p>

</body>
</html>