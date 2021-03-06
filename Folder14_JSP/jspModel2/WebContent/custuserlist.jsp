
<%@page import="dto.CustUserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
List<CustUserDto> list = (List<CustUserDto>)request.getAttribute("custlist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custuserlist.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h1> 고객목록	</h1>

<div align="center">
	<form action="custuseradd" method="post">
	
		<input type="add" action="addAf">
	
		<table style="width:700px;">
			<col width="100"> <col width="300"> <col width="300">  
			<tr>	<%--파랑라인 그리는영역 --%>
				<td height="2" bgcolor="#0000ff" colspan="3"> </td>
			</tr>
			
			<tr>
				<th bgcolor="#ffff00">
					<input type="checkbox" name="alldel" onclick="deletechecks(this.checked())">
				</th>
				<th>ID</th>
				<th>NAME</th>
			</tr>
			
			<tr>	<%--파랑라인 그리는영역 --%>
				<td height="2" bgcolor="#0000ff" colspan="3"> </td>
			</tr>
			<%
				if(list.size() == 0){
					%>
					<tr bgcolor="#f6f6f6">
						<td colspan="3" align="center"> 고객리스트가 존재하지 않습니다. </td>
					</tr>
					<tr>	<%--파랑라인 그리는영역 --%>
						<td height="2" bgcolor="#0000ff" colspan="3"> </td>
					</tr>
					<%
				}else{
					for(int i=0; i<list.size(); i++){
						CustUserDto cust = list.get(i);
					%>
					<tr bgcolor="#f6f6f6">
						<td align="center" bgcolor="yellow">
							<input type="checkbox" name="delck" value="<%=cust.getId() %>">
						</td>
						<td>
							<%=cust.getId() %>
						</td>
						<td>
							<a href="custuserdetail.jsp?id=<%=cust.getId()%>">
								<%=cust.getName() %>
							</a>
							
						</td>
					</tr>
					<tr>	<%--파랑라인 그리는영역 --%>
						<td height="2" bgcolor="#0000ff" colspan="3"> </td>
					</tr>
					<%
					}
					
					
				}
			%>
			<%--멀티삭제, 고객정보 추가 --%>
			<tr><!-- 다중삭제 버튼 -->
				<td align="center" height="1" bgcolor="#c0c0c0" colspan="3">
					<input type="submit" value="고객 정보 삭제">
				</td>
			</tr>
			<tr>	<%--파랑라인 그리는영역 --%>
				<td height="2" bgcolor="#0000ff" colspan="3"> </td>
			</tr>
			
			<tr bgcolor="#f6f6f6">
				<td colspan="3">
				
					<a href="custuseradd?command=add"> 고객정보 추가</a>
					
				</td>
			</tr>
			
			
			
			
		</table>
		
	</form>
</div>
	
	

</body>
</html>
