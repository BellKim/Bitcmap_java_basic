<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	/*
		내장객체 : 동적할당 하지 않고 사용할 수 있는 OBJECT
		request -> getParameter, setAttribute, getAttribute
		response -> sendRedirect
		out		-> 
		session -> 
	*/
														/*
														form <input type="text"
														<a href=" ...."
														location.href
														submit()
														*/
	String name=request.getParameter("name");
	System.out.println("name" + name);
	String age=request.getParameter("age");
	System.out.println("age" + age);
	String hobby[] = request.getParameterValues("hobby");	//checkbox
	
	if(hobby!=null && hobby.length > 0){
		for(int i=0; i<hobby.length; i++){
			System.out.println("hobby = " + hobby[i]);
		}
	}
	
				
		
	%>

</body>
</html>