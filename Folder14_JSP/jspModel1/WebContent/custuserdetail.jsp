

<%@page import="jspModel1.CustUserDto"%>
<%@page import="jspModel1.CustuserDetailDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String getid = request.getParameter("id");
CustuserDetailDao dao = CustuserDetailDao.getInstance();
CustUserDto dto = dao.getUserInfo(getid);
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원상세정보  </h1>
	<div align="center" style="width:700px;">
		<form action="custMemberDetail.jsp" method="post">
			<table style="width:700px">
				<col width="200"> <col width="500">
				<tr>	<%--파랑라인 그리는영역 --%>
					<td height="2" bgcolor="#0000ff" colspan="3"> </td>
				</tr>
				<tr>
					<td height="6">ID</td>
					<!-- <td> <input type="text" name="id" value="<%=dto.getId()%>"> </td> -->
					<td><p><%=dto.getId()%></p></td>
				</tr>
				<tr>
					<td height="6">이름</td>
					<!-- <td> <input type="text" name="name" value="<%=dto.getName() %>"> </td> -->
					<td><p><%=dto.getName() %></p></td>
				</tr>
				<tr>
					<td height="6">주소</td>
					<!--  <td> <input type="text" name="address" value="<%=dto.getAddress() %>"> </td>-->
					<td> <p><%=dto.getAddress() %><p> </td>
				</tr>
				<tr>	<%--파랑라인 그리는영역 --%>
					<td height="2" bgcolor="#0000ff" colspan="3"> </td>
				</tr>
				<tr>
					<td colspan="2"  align="center" style="text-align:center;">
					<button type="submit" >수정</button>
					<button type="button" onclick="location.href='GuestUserDelete.jsp?id=<%=dto.getId()%>'">삭제</button>
					</td>
				 </tr>
				 <tr>
					<td colspan="2"  align="center" style="text-align:center;">
					<button type="button" onclick="location.href='index.jsp'" value="">목록</button>
					</td>
				 </tr>
				 
			</table>
		
		</form>
	</div>

</body>
</html>