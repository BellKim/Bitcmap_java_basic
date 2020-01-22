

<%@page import="jspModel1.CustUserDto"%>
<%@page import="jspModel1.CustuserDetailDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String getid = request.getParameter("id");
String getname = request.getParameter("name");
String getaddress = request.getParameter("address");

CustuserDetailDao dao = CustuserDetailDao.getInstance();
//CustUserDto dto = dao.setUpdate(getid);
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 회원정보 변경   </h1>
	<div align="center" style="width:700px;">
		<form action="custMemberDetail.jsp" method="post">
			<table style="width:700px">
				<col width="200"> <col width="500">
				<tr>	<%--파랑라인 그리는영역 --%>
					<td height="2" bgcolor="#0000ff" colspan="3"> </td>
				</tr>
				<tr>
					<td height="6">ID</td>
					<td> <input type="text" name="id" value=""> </td>
				</tr>
				<tr>
					<td height="6">주소</td>
					<td> <input type="text" name="address" value=""> </td>
				</tr>
				<tr>	<%--파랑라인 그리는영역 --%>
					<td height="2" bgcolor="#0000ff" colspan="3"> </td>
				</tr>
				<tr>
					<td colspan="2"  align="center" style="text-align:center;">
					<button type="submit" value="">수정</button>
					<button type="submit" value="">삭제</button>
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