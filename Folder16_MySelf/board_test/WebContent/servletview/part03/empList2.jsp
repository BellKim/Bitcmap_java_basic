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

	
	<table>
		<thead>
			<tr>
				<th> employee_is </th><th>first_name</th><th>salary</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.aList}"  var="dto">
			
			<tr> 
				<td>${dto.employee_id}</td>
				<td>${dto.first_name}</td>
				<td>${dto.salary}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	 

</body>
</html>

<!-- 


 <table>
  <thead>
   <tr>
   <th>employee_id</th><th>first_name</th><th>salary</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${requestScope.aList}"  var="dto">
      <tr> 
       <td>${dto.employee_id}</td>
       <td>${dto.first_name}</td>
       <td>${dto.salary}</td>
      </tr>
    </c:forEach>
 </tbody>
 </table>



 -->