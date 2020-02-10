<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과값 출력. from part04 </title>
</head>
<body>
	<%
		String res = (String)request.getAttribute("res");
		out.print(res);
	%>
	
	<%-- <%=res%> --%>

</body>
</html>