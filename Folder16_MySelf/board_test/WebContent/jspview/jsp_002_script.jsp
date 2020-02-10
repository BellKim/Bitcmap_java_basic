<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp_002_script.jsp</title>
</head>
<body>
	<%--
		jsp에서 제공하는 구성 기본요소 : jsp 에서 실시간으로 문서의 내용을 생성하기 위해서 사용된다. 
		(1) 표현식(expression) : 값을 출력한다. <%= %>
		(2) 스크립트릿(scriptlet) : 자바코드를 실핸한다. <% %>
		(3) 선언부(declaration) : 맴버변수, 메소드를 정의한다. <%! %>
		
	 --%>
	 
	 <%!
	 	int x; //맴버변수 
	 	int y;
	 	
	 	public void setData(int x, int y){
	 		this.x=x;
	 		this.y=y;
	 	}
	 	
	 	public int getSum(){
	 		return x+y;
	 	}
	
	 %>
	<%
		int z=20;
		setData(10,5);
	%> 
	
	<p> <%=getSum()  %></p>
	<p> <%=x  %>  /  <%=y  %></p>
	
	 

</body>
</html>