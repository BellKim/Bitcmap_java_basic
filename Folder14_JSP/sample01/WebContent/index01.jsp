<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<%-- 
	Java Server Page J S P 
										web application sserver
	client 			---- ->		server(WAS)		< -------- > server(DB)
				request			JAVA+html
		localhost:8080/sample
									web server
									web container
									servlet, jsp
									(get, post) -> 보안ㅌ
				<--------			해석
				response
				
		Servlet = java(HTML)
		JSP		= HTML(java)
				=html , javascript, css, jquery, java
				
		
		
		 
 --%>
<!-- html 주석문 -->
<body>

	<h1> index jsp </h1>
	
	<%
		//JAVA영역
		//scriptlet = script + applet의 약자 
		System.out.println("콘솔 출력 ");
	
		/*
			내장(암시) 객체 : new를 하지 않고 바로 사용할 수 있는 Object
			request, response, session 
			HTTPServletRequest
		*/
		
		out.println("<p>web 출력 </p>");
		out.println("<p>web 출력 </p>");
			
	%>
	
	<p id="demo"> p demo </p>
	
	<script type="text/javascript">
		document.getElementById("demo").innerHTML = "change p tag";
		
	
	</script>
	

</body>
</html>





