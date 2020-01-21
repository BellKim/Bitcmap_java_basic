<%@page import="jspModel1.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
request.setCharacterEncoding("UTF-8");
String id=request.getParameter("id");
String name=request.getParameter("name");
String address=request.getParameter("address");
System.out.println("id = "+ id +"\n name = "+ name + "\n address " + address);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	
	CustUserDao dao = CustUserDao.getInstance();
		//isS = is success
	boolean isS=dao.addCustUser(id, name, address);/*
	if(isS){
		response.sendRedirect("custuserlist.jsp");
	}*/
%>


<%
if(isS){
%>
<script type="text/javascript">
alert("정상적으로 추가되었습니다. ");
location.href="custuserlist.jsp";
</script>

<%
}else{
	%>
	<script type="text/javascript">
		alert("추가되지 않았습니다. 다시 시도해주세요 ");
		location.href="custadd.jsp";
	</script>
<%
}
%>





</body>
</html>