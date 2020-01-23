
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%--
	EL 표현식(값, 판별)
	CORE : 제어문(for, if) -> EL tag 와 같이 사용한다. 
	
 --%>
</head>
<body>

	<%
		request.setAttribute("data", "JSTL입니다.");
	%>
	${data }
	<br>
	
	<%
	String cdata = "";
	%>
	<!-- set -->
	<c:set var="cdata" value="core JSTL 입니다. "/>
	${cdata }
	<br><br>
	
	<!--  out 내장객체 -->
	<%--
		out.println(cdata);
	--%>
	<%
		session.setAttribute("sessionData", "저장된 데이터");
	%>
	<c:set var="sdate" value="${sessionData }"/>
	<c:out value="${sdate}"/>
	<br><br>
	
	<!-- if -->
	<% request.setAttribute("count", "10");
		String sCount=(String)request.getAttribute("count");
		int count = Integer.parseInt(sCount);
	
		if(count>=10){
			%>
			<p>count: <%=count %></p>
			<%
		}
	%>
	<c:if test="${count>=10 }">
		<p> core count<c:out value="${count }"/></p>
	</c:if>
	
	
	<%
		request.setAttribute("name", "홍길동");
	%>
	
	<c:if test="${name eq '홍길동' }">
		<p>제이름은 홍길동이 맞습니다. </p>
	</c:if>
	
	<%
		request.setAttribute("name", "일지매");
	%>
	
	<c:if test="${name == '일지매' }" var="flg"/>
	
	<c:if test="${flg }">
		<p>이름은 일지매 입니다 </p>
	</c:if>
	
	<!-- for -->
	<%
		for(int i=0; i<10; i++){
			%>
			<%=i %>
			<%
		}
	%>
	<c:forEach begin="0" end="9" step="1" varStatus="i">
		<c:out value="$d{i.index}"> </c:out>
	</c:forEach>
	
	

</body>
</html>