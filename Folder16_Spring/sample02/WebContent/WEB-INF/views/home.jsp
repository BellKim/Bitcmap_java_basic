<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>home</h1>

<%
	String name = (String)request.getAttribute("name");
	out.println("name: " + name);
%>

<h3>${name}</h3>


	<!-- html -->
	
	<a href="world.do?age=24&email=abc@naver.com"> world 로 이동 </a>
	<!-- 월드 컨트롤러(.do) 로 이동하며 age, email 로 파라미터를 전달해서 보내준다.  -->
	
	<%-- <a href="world.do?age=24&email=<%=변수명 %> "> world 로 이동 </a> --%>
	<!-- 다음과 같이 	jsp  형식도 가능하다. --> 


	<br>
	<%-- form 사용  --%>
	<form action="func.do" method="GET">
		이름:<input type="text" name="name" value="홍길동"> <br>
		주소:<input type="text" name="address" value="서울시"> <br>
		나이:<input type="text" name="age" value="24"> <br>
		<input type="submit" value="func 이동 "><br>
	</form>




</body>
</html>