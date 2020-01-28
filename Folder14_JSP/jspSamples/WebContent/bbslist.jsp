<%@page import="dto.MemberDto"%>
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
	Object ologin = session.getAttribute("login");
	//request.getSession().getAttribute(name);
	MemberDto mem = null;
	if(ologin == null){
		%>
		<script type="text/javascript">
			location.href="login.jsp";
		</script>
		<%
	}
	mem=(MemberDto)ologin;
	
%>

<h4 align="right" style="background-color:#f0f0f0">
	환영합니다 <%=mem.getId() %>님
</h4>
<h1> 게 시 판 </h1>

<a href="bbsWrite.jsp"> 글 쓰 기 </a>

</body>
</html>