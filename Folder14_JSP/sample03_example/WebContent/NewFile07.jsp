<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%! int dan = 0; %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table tr td{
	border:1px solid black;
}
</style>
</head>
<body>
	<h1>구구단</h1>
	<% dan++; %>
	<table>
		<%for(int i=0; i<dan; i++){ %>
			<tr>
				<%for(int j=0; j<dan; j++){  %>
					<td>
						<%=i %> * <%=j %> = <%=i*j %>
					</td>
				<%} %>

			</tr>
		<%} %>

	</table>
	
	

</body>
</html>