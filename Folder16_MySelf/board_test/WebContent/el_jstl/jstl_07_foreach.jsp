<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 프리픽스에 c 가 대문자여도 오류가 난다. 시발 ㅠㅠ  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_07_foreach</title>
</head>
<body>
	<%
		int[] num = new int[] {10, 20, 30, 40, 50 };
		for(int i = 0; i<num.length; i++){
			out.print(num[i] + " ");
			
		}
	%>
	
	<hr/>
<!-- 여러개의 값을 가지고있는 컬랙션이나 배열을 가져올때는(반복된 값을 가져올때) items 를 사용한다.  --> 
	
	<hr />

	<c:forEach items="<%=num%>" var="i">
		<p>
			<c:out value="${i}" />
		</p>
	</c:forEach>
	<hr />
	
<!-- varStatus: 반복상태를 갖는 속성이다. -->
  <c:forEach items="<%=new int[]{10,20,30,40,50}%>" 
              var="i"  varStatus="status" step="2">
    <p>
      <span>count:${status.count}</span>
      <span>[${status.index}]</span>
       <c:out value="${i}" />
    </p>
  </c:forEach>

</body>
</html> 














