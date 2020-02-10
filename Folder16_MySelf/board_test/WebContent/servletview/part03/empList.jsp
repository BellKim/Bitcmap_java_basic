<%@page import="servletdemo.part03.EmployeesDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp list2</title>
</head>
<body>
	<%
		List<EmployeesDTO> aList = (List<EmployeesDTO>)request.getAttribute("aList");
	%>
	<table>
		<thead>
			<tr>
				<th> employee_is </th><th>first_name</th><th>salary</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(int i=0; i<aList.size(); i++){
					EmployeesDTO dto=aList.get(i);
			%>
			<tr>
				<td><%= dto.getEmployee_id() %></td>
				<td><%= dto.getFirst_name() %></td>
				<td><%= dto.getSalary() %></td>	
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	 

</body>
</html>