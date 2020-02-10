<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result.jsp</title>


</head>
<body>
<!--  스크립트 릿?? 자바소스를 구현할때 사용. 
톰캣이 기본적으로 생성될ㄷ떄 9가지 리퀘스트 객체가 생성이된다.


-->
<%
	String fname=(String)request.getAttribute("fname");
%> 
			<!-- 셋어트리뷰트는 저장, 불러오기는 getattriute -->
<p>
<!-- 표현식 (expression) : 변수나 메소드를 호출해서 출력한다.  -->
<%= fname %>
</p>

</body>
</html>