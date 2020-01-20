<%@page import="sample01.human"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
response(응답)  sendRedirect


<%
//response.sendRedirect("NewFile.jsp?name=홍길동");
//영문일때는 상관없지만 한글일때는 charset을 입력해줘야한다.

/*
	request.setCharacterEncoding("utf-8");
	String name="홍길동"; 
	name= URLEncoder.encode(name);
	response.sendRedirect("NewFile.jsp?name="+name);
	*/

%>


<%	//forward방식으로 전송할때는 urlencode를 할필요가 없다. 
/*
	String name="일지매";
	request.setAttribute("name", name);//패키징 해서
	//pageContext : 내장객체
	pageContext.forward("NewFile.jsp");//보낸다.
*/
%>


<%		//human.java와 연계됨.
	String humnaName = "성츈향";

	int humanNum = 1;
	
	human human = new human(humnaName, humanNum);
	
	session.setAttribute("human", human);
	
	pageContext.forward("NewFile1.jsp");

%>

</body>
</html>