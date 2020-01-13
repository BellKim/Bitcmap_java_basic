<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- name=1
&addrno1=2
&addrno2=3
&addr=4
&phNo1=5
&phNo2=6
&phNo3=7
&deleveryTime=12%3A00+%7E+15%3A00
&orderRecep=on
&eMailInfo=true
 -->
	<%
		String name = request.getParameter("name");
	
		String saddrno1 = request.getParameter("addrno1");//int
		String saddrno2 = request.getParameter("addrno2");//int
		
		String addr = request.getParameter("addr");
		
		String sphNo1 = request.getParameter("phNo1");//int
		String sphNo2 = request.getParameter("phNo2");//int
		String sphNo3 = request.getParameter("phNo3");//int
		
		String deleveryTime = request.getParameter("deleveryTime");
		String orderRecep = request.getParameter("orderRecep");
		String eMailInfo = request.getParameter("eMailInfo");
		
		
		int addrno1 = Integer.parseInt(saddrno1);
		int addrno2 = Integer.parseInt(saddrno2);
		
		int phNo1 = Integer.parseInt(sphNo1);
		int phNo2 = Integer.parseInt(sphNo2);
		int phNo3 = Integer.parseInt(sphNo3);
		
		out.println(" name = " + name);
		out.println(" addrno1 = " + addrno1);
		out.println(" addrno2 = " + addrno2);
		out.println(" addr" + addr);
		out.println(" phNo1 = " + phNo1);
		out.println(" phNo2 = " + phNo2);
		out.println(" phNo3 = " + phNo3);
		out.println(" deleveryTime = " + deleveryTime);
		out.println(" orderRecep = " + orderRecep );
		out.println(" eMailInfo = " + eMailInfo );
		
		
		
		
	
	
	%>

</body>
</html>