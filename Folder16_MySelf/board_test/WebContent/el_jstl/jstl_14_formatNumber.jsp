<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_14_formatNumber.jsp</title>
</head>
<body>
	<%-- 숫자형식을 지정해주는 formatNumber요소 --%>
	<c:set var = "num1" value="10000"/>
	<c:set var = "num2" value="0.2"/>
	
	<%-- type 속성은 number, percent, currency을 사용할 수 있따.  --%>
	<!-- 10,000 -->
	<fmt:formatNumber value="${num1}" type="number"/>
	
	
	<%-- java.text.DecimalFormat을 참조해서 pattern을 설정한다. --%>
	
	<p><fmt:formatNumber value="${num1}" type="number" pattern="0,000.00"/></p>
	
     <p><fmt:formatNumber value="${num2}" type="percent"/></p> 
     
     <p><fmt:formatNumber value="${num1}" type="currency"/></p>           

</body>
</html>