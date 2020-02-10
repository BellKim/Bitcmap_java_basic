<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_06_foreach</title>
</head>
<body>
	<%
		for(int i=1; i<=5; i++){
			out.print(i);
		}
	%>
	
	<p>for 반복문과 같은 기능을 제공하는 forEach태그 </p>
	<c:forEach var="i" begin="1" end="5" step="1">
			<%--i변수에 1부터 5까지 1씩 증가 함. --%>
	<p> <c:out value="${i}" /> </p>
	
	</c:forEach>
	

</body>
</html>