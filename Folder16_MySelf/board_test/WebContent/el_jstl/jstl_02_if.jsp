<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--          <%@ taglib prefix="c" uri= 입력후 컨트롤스페이스 하고 jsp/jstl/core 를 업로드.      --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_02_if.jsp</title>
</head>
<body>
	<hr>
		<% 
			int num=10;
			if(num % 2 == 0)
				out.print("even");
			if(num % 2 == 1)
				out.print("odd");
		%>
	</hr>
	<%--
		<c:if test="${조건식}" var="변수명" scope="범위">
		</c:if>
		
			var, scope명은 생략할 수 있다. 
			scope생략하면 기본값은 page이다. 
	 --%>
	 <!-- 조건식을 사용할때는 test 를 사용해야한다. true 와 false 로 결과값이 리턴된다. -->
		<c:set var="num" value="10" />	<!-- 코어등록을 해야지 오류가 안뜬다. -->
		<c:if test="${num%2==0 }">		<!-- c:if시작 -->
		<c:out value="${'even'}"/>		
		</c:if>							<!-- c:if 끝. -->
		
		<c:if test="${num%2==1 }">		<!-- c:if시작 -->
		<c:out value="${'odd'}"/>
		</c:if>							<!-- c:if 끝. -->
		  

</body>
</html>