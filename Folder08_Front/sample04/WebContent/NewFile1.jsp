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
	System.out.println(" 시작  \n\n");
	String  inputnumber= request.getParameter("inputnumber");
	System.out.println("inputnumber = "+inputnumber);
	String  inputdate= request.getParameter("inputdate");
	System.out.println("inputdate = "+inputdate);
	String  inputcolor= request.getParameter("inputcolor");
	System.out.println("inputcolor = "+inputcolor);
	String  inputrange= request.getParameter("inputrange");
	System.out.println("inputrange = "+inputrange);
	String  inputsearch= request.getParameter("inputsearch");
	System.out.println("inputsearch = "+inputsearch);

	
	
	
	%>

</body>
</html>