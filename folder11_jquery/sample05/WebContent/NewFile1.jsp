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
		String name= request.getParameter("name");
		String sage= request.getParameter("age");
		String address= request.getParameter("address");
		
		int age = Integer.parseInt(sage);
		
		out.println("이름 :" + name);
		out.println("나이 : " + age);
		out.println("주소 : " + address);
		
		
		
		
	 %>
</body>
</html>