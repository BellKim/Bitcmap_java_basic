<%@page import="java.util.Date"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberDto mem = (MemberDto)session.getAttribute("login");

//시간을 취득
String fname = (new Date().getTime()) + "";
System.out.println("fname : " + fname);

// 파일명을 milicecond 까지 반영해서 숫자로 저장시킨다. 중복 될 수가 없다. 
//  mydata.txt -> 11580695728906.txt		-> upload

//  11580695728906.txt	-> download -> mydata.txt



%>    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자료 올리기 </h1>
	
	<div align="center">
<%--
id, title, content -> String -> form field data
file				-> byte
--%>
													<%--인코드파일에서 멀티파트 설정할때  cos.jar --%>
<form action="pdsupload.jsp" method="post" enctype="multipart/form-data">
	<table border="1">
		<col width="200"><col width="500">
		<tr>
			<th>아이디</th>
			<td>
				<%=mem.getId() %>
				<input type="hidden" name="id" value="<%=mem.getId() %>">
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="title" size="50">
			</td>
		</tr>
		<tr>
			<th>파일 업로드</th>
			<td>
				<%--파일은 스트링으로 받을수 없다. 바이트단위로 받아야하며 file타입으로 받아야한다. --%>
				<input type="file" name="fileload" style="width:400pd">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea rows="20" cols="50" name="content"> </textarea>
			</td>
		</tr>
		
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="올리기">
			</td>
		</tr>
		
	</table>

</form>




	</div>

</body>
</html>




