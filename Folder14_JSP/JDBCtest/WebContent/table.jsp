<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String tname = request.getParameter("tname");
    System.out.println("tname = " + tname);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HR table</h1>
	
	<p> 지정 테이블의 정보를 출력한다. </p>
	
	<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="hr";
	String password="hr";
	Connection conn = DriverManager.getConnection(url, user, password);
	
	String sql = " SELECT * FROM " + tname; 
	PreparedStatement psmt = conn.prepareStatement(sql);
	ResultSet rs = psmt.executeQuery();
	
	ResultSetMetaData rsmd = rs.getMetaData();
	int count = rsmd.getColumnCount();
	
	
	%>
	
	<table border="1">
		<tr>
			<%
				for(int i=1; i<count+1; i++){
					%>
					<td>
						<%=rsmd.getColumnName(i) %>
					</td>
					<%
				}
			%>
		</tr>
		<%
			while(rs.next()){
				%>
				<tr>
					<%
					for(int i=1; i<count+1; i++){
						%>
						<td><%=rs.getString(i) %></td>
						<%
					}
					%>
				</tr>
				<%
			}
		%>
	</table>

</body>
</html>