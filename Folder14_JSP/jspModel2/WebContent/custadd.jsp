<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.main_div{
	text-align:center;
}
	
</style>
</head>
<body>

<h1> 고 객 추 가 </h1>

<div align="center" style="border:solid 1px black; width:700px;" class="main_div">
	<form action="custaddAF.jsp" method="post">
		<table style="width:700px">
			<col width="200"> <col width="500">
			<tr>	<%--파랑라인 그리는영역 --%>
				<td height="2" bgcolor="#0000ff" colspan="3"> </td>
			</tr>
			<tr>
				<td height="6">ID</td>
				<td> <input type="text" name="id"> </td>
			</tr>
			<tr>
				<td height="6">이름</td>
				<td> <input type="text" name="name"> </td>
			</tr>
			<tr>
				<td height="6">주소</td>
				<td> <input type="text" name="address"> </td>
			</tr>
			<tr>	<%--파랑라인 그리는영역 --%>
				<td height="2" bgcolor="#0000ff" colspan="3"> </td>
			</tr>
			<tr>
				<td colspan="2"  align="center" style="text-align:center;">
				<button type="submit" value="">고객추가</button>
				<button type="submit" value="">취소</button>
				</td>
			 </tr>
			 
		</table>
	
	</form>


</div>

</body>
</html>