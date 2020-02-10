<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		EL(Expression Language) : 표현언어
		1. jsp스크립트를 대신해서 속성값들을 편리하게 출력할 수 있도록 제공되는 언어이다. 
		2. ${}
	--%>
	<%
		/*
			scope(영역) - 데이터를 참조할 수 있도록 저장해둔 공간.
		*/
		//page영역에 p1이름으로 page값이 저장된다.
		pageContext.setAttribute("p1","page");
		//기본객체(페이지영역에 저장되는명령어 즉, 이 페이지에서만 참조된다.).setAttribute
		
		//request영역에 p2이름으로 request값이 저장된다. 
		request.setAttribute("p2","request");
		
		//session영역에 p3 이름으로 session값이 저장된다. 
		session.setAttribute("p3","session");
		
		//application p4 이름으로 application 값이 저장된다. 
		application.setAttribute("p4","application");
	%>
	
	<p>${pageScope.p1} / ${requestScope.p2} / ${sessionScope.p3} / ${applicationScope.p4}</p>
	
	
	<!-- 속성값을 가져올때 영역을 명시하지 않으면
		page=> request=> session => application 순으로 검색을 한다. 
	 -->
	
</body>
</html>