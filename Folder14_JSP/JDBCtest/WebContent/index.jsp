<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> HR Tables</h1>
	
	<p> 모든 테이블의 목록을 출력한다. </p>
	
	<%! 	//$ 이 문자를 포함하고 있는지.
			//$가 포함되어 있는 테이블은 링크가 되지 않도록 하기위한 함수이다. 
		public boolean has$(String msg){
		return msg.contains("$");
	}
	%>
	
	<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="hr";
	String password="hr";
	Connection conn = DriverManager.getConnection(url, user, password);
	String sql = "SELECT * FROM TAB";
	PreparedStatement psmt = conn.prepareStatement(sql);
	ResultSet rs = psmt.executeQuery();
	ResultSetMetaData rsmd = rs.getMetaData();//column정보를 받아온다.
	int count = rsmd.getColumnCount();//column의 갯수. 
	
	%>
	
	<table border="1">
		<tr>
			<%for(int i=1; i<count+1; i++){ %>
			<td> <%=rsmd.getColumnName(i) %>  </td>
			<%} %>
		</tr>
		
		<%while(rs.next()){%>
			<tr>
				<%
				for(int i=1; i<count+1; i++){
					String cols = rs.getString(i);
					if(i==1 && !has$(cols)){	
						%>
						<td>
							<a href="table.jsp?tname=<%=cols %>"><%=cols %></a>
						</td>
						<%
					}else{
						%>
						<td>
							<%=rs.getString(i) %>
						</td>
						<%
					}
				}
				%>
			</tr>
		<%}%>
		
	</table>
	<%
		if(rs!=null) rs.close();
		if(psmt!=null) psmt.close();
		if(conn!=null)conn.close();
	%>
</body>
</html>
