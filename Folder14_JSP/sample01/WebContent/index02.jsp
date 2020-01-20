<%@page import="sample01.MyUtil"%>
<%@page import="sample01.YouClass"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	public class MyClass{
	 	private int num;
	 	private String name;
	 	
	 	public MyClass(){
	 		num=12;
	 		name="world";
	 	}
	 	
	 	public String print(){
	 		
	 		return num + " " + name;
	 		
	 	}
	 	//자동완성 constructor 가 없다. 
	 	
	}///end class

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		MyClass cls1= new MyClass();
	%>
	<%=cls1.print() %>
	<%
		out.println(cls1.print());
	%>
	
	<%
		YouClass ycls1 = new YouClass(100, "일지매");
	%>
	
	<%=ycls1.toString()%>
	
	<%
		MyUtil.myfunc();
	%>
	
	<%
		String str="hello";
	%>
	
	<input type="text" size="20" value="<%=str%>">
	
	
</body>
</html>