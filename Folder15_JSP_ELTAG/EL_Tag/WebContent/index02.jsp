<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<MemberDto> list = new ArrayList<>();
	MemberDto mem = null;
	
	mem = new MemberDto();
	mem.setMessage("하이");
	list.add(mem);
	
	mem = new MemberDto();
	mem.setMessage("안녕");
	list.add(mem);
	
	mem = new MemberDto();
	mem.setMessage("바이");
	list.add(mem);
	
	request.setAttribute("list", list);
	
%>

<c:forEach begin="0" end="2" var="m" items="${list }" varStatus="i">
	<p>index : <c:out value="${i.index }"/> </p>
	<p>data : <c:out value="${m.message}"/> </p>
</c:forEach>

<!--  map -->
<%
	Map<String, String> map = new HashMap<>();
		map.put("apple", "사과");
		map.put("pear", "배");
		map.put("banana", "바나나");
		request.setAttribute("map", map);
%>
<c:forEach var="obj" items="${map }">
	key:<c:out value="${obj.key }"></c:out>
	value:<c:out value="${obj.value}"></c:out>
</c:forEach>

</body>
</html>