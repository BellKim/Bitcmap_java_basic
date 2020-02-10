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
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		if(id.equals("kim")&& pwd.equals("1234")){
	%>
		<!--  서버에서 페이지이동   (액션테그)-->
			<jsp:forward page = "jsp_006_logout.jsp"/>
	
	<%
		}else{
			//서버와 클라이언트에서 페이지 이동. 
			response.sendRedirect("jsp_006_logout.jsp");
			
		}
	%>
<!-- 주소 확인해보기.
jspview/jsp_006_logout.jsp 
jspview/jsp_006_response.jsp 
-->
</body>
</html>