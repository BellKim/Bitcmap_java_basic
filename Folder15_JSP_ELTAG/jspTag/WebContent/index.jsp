<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
	forward(이동하기), include(불러오기) -> iframe
 --%>
<h3>index.jsp start</h3>
 
<jsp:include page="NewFile.jsp" flush="false"></jsp:include> 

<h3>index.jsp end</h3>
<%-- 
<jsp:forward page="NewFile.jsp"></jsp:forward>
 --%>

<%--
EL, Core 에 없는 부분
MemberDto dto = new MemberDto();
--%> 

<%--
	MemberDto mem = new MemberDto();
	mem.setMessage("안녕하세요");	
	String msg = mem.getMessage();
	
	request.setAttribute("mem", mem);
--%>

<jsp:useBean id="mem" class="dto.MemberDto"></jsp:useBean>
<jsp:setProperty property="message" name="mem" value="안녕하세요"/>
<jsp:getProperty property="message" name="mem"/>

message:${mem.message }
 <br>
</body>
</html>






