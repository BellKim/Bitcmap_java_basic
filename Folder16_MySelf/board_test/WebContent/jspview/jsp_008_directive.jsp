<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="jsp_008_directive_value.jsp" %>
	<!--인크루드 액션테그:  윤곽을 잡을떄사용?
	forward 는 아예 제어권을 넘겨버리고 인클루드는 갔따가 원하는것만 얻고 가져온다. 
	:::: 별도로 컴파일이 진행되어서 별도의 파일로 저장됨. 
	-->
	<%
	//include지시어(directive)
	//jsp_008_directive_value.jsp 페이지에 자원을 현재페이지에서 사용할수있도록 
	//페이지를 include 한다. 
		int x=20;
		out.print(x+y);
	%>
	<!-- 
	//다른페이지에 있는 내용을 자바형태의 소스로 바꿔서 불러온다.
	D:\khAcademy\workspace170906\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\work\Catalina\localhost\webdemo\org\apache\jsp\jspview
	-->  
	
</body>
</html>