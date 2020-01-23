<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%--

	JSP: html, JavaScript, CSS, Java
	
	<%! 선언부(class, function, variable) %>
	
	<% 코드부 %>
	
	<%= value %>
	
	EL테그 : front end 에서 JAVA코드를 사용하지 않게 하기 위해서 사용하게 되었다.
	
	-------------------
	EL tag -> value			<== Java
	Core tag => 제어문
	------------------- 
	Expression Language
	표현 			언어			
	
	JSTL ( JAVA Server Page Standard Tag Language)
 --%>
</head>
<body>
	<%
		String str = "hello";
		request.setAttribute("_str", str);		//request scope
	%>
	<%
		String s = (String)request.getAttribute("_str");
	%>
	<%
		out.println("s = " + s);
	%>
	
	<br><br>
	s = <%=s %>
	
	s = ${_str}		<%--	setattribute("이곳") 에서 가져온것임.  --%>
	<br>
	<%=2 + 3 %>
	<br>
	${3>2?100:200 }
	<br><br>
	data = ${empty data }<!--  true // false -->
	<br>
	data=${not empty data }
	<br><br>
	1<9:${1<9 }
	<br>
	2+3:${2+3}
	<br><br>
	
	<%
		Integer a, b;
		a=10;
		b=3;
		request.setAttribute("a", a);
		request.setAttribute("b", b);
		
		boolean c;
		c=false;
		
		request.setAttribute("c", c);
	
	%>
	
<pre>
a:${a }
b:${b }
c:${c }

a+b:${a+b}

gt:${a gt b }
gt:${a>b }

lt:${a lt b }
lt:${a > b }

el:${a le b }	<!-- <=  -->
el:${a ge b }	<!-- >=  -->

div:${a div b }		<!--  a / b  -->
mod:${a mod b }		<!-- a % b  -->

c : ${!c}
${a == 10 && !c }



</pre>




<%
MemberDto mem = new MemberDto();
mem.setMessage("Hello EL");
request.setAttribute("mem", mem);
%>

<%=mem.getMessage() %>
${mem.message }			<!-- get message를 자동적으로 호출한다. (mem.getmessage() -->

<br><br>

<%
	String array[]={ "hello","world"};
	request.setAttribute("array", array);
	//배열에 대해서 접근하는방법 setattribute("콜네임", 자료입력);
%>
<%=array[0] %>
<br>
${array[0] }

<%
	List<String> list = new ArrayList<>();
	list.add("세상");
	list.add("el");
	request.setAttribute("list", list);
%>

<%=list.get(0) %>
<br>
${list[0] }
<br><br>

<%
	List<MemberDto> memlist = new ArrayList<>();
	MemberDto m = new MemberDto();
	m.setMessage("첫번째 메시지");
	memlist.add(m);
	
	request.setAttribute("memlist", memlist);
%>

<% memlist.get(0).getMessage(); %>
<br>
???: ${memlist[0].message }
<br><br>
<%
	HashMap<String, String> map = new HashMap<>();
	map.put("apple", "사과");
	map.put("grape", "포도");
	
	request.setAttribute("map", map);
	
%>

<%=map.get("apple") %>
${map.get("apple")}
${map.apple }
${map["apple"] }











</body>
</html>