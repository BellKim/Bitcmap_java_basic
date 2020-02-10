<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_19_xml.jsp</title>
</head>
<body>

	<c:import url="mem.xml" var="mem" charEncoding = "UTF-8"/>
	<x:parse var="xmldata" xml="${mem }"/>
	<x:forEach select="$xmldata//student"> <!-- student를 반복해서 작업할것이다 라는것을 가지고온다. -->
		<p>
			<x:out select="./name" /> /			<!-- student에 있는 name, id, age를 가지고온다. --> 
			<x:out select="./id" /> / 
			<x:out select="./age" /> / 
		</p>
	</x:forEach>
	

</body>
</html>