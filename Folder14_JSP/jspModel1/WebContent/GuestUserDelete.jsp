
<%@page import="jspModel1.CustuserDetailDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	String id = request.getParameter("id");
	CustuserDetailDao dao = CustuserDetailDao.getInstance();
	boolean info = false; //dao.DeleteUser(id);

//DeleteUser


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> GuestUserDelete.jsp</h1>

<h3>대상아이디 : <%=id %></h3>

<p>정말 삭제하시겠습니까?</p>
<button type="button" onclick="deleteMember()"> 삭제합니다 </button>

<button type="button" onclick="goBack()">아니요 (뒤로가기)</button>

<script type="text/javascript">
function goBack() {
	  window.history.back();
	}
	
function deleteMember(){
	<%
	info = dao.DeleteUser(id);
	%>
	if(<%=info%>==true){
		alert("성공적으로 변경되었습니다.");
		location.href='index.jsp';
		//window.location.href = 'http://www.abc.com/';
		
	}else{
		alert("실패하였습니다. ");
	}
	
}

</script>

	
</body>
</html>