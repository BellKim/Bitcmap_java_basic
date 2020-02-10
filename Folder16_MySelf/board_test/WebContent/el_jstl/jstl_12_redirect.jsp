<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl_12_redirect.jsp</title>
</head>
<body>
	<%-- sendRedirect() 과 같은 기능을 제공해주는 테그이다.  --%>
	<p>current page </p>
	<c:redirect url="/el_03.jsp"
					context="/webdemo/el_jstl"/>

</body>
</html>