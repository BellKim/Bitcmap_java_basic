<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name=request.getParameter("name");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>newfile.jsp</h3>

<input type="text" value="<%=name%>"><br>
<p><%=name %></p>

	<%--
	forward 형식으로 받을때.
 --%>
 
 <%
 	
 %>


</body>
</html>