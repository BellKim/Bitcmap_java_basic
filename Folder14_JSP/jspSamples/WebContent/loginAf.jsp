
<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

System.out.println("id = " + id);
System.out.println("pwd = " + pwd);

MemberDao dao = MemberDao.getInstance();

MemberDto mem = dao.login(new MemberDto(id, pwd, null, null, 0));

if(mem != null && !mem.getId().equals("")){
	//login정보의 저장
	session.setAttribute("login", mem);
	session.setMaxInactiveInterval(30*60*60);
%>
	<script type="text/javascript">
		alert("안녕하세요 <%=mem.getName() %>님 ");
		location.href="./bbslist.jsp";
	</script>
<%	
}else{
%>
	<script>
		alert("id나 pw를 확인해주세요 ");
		location.href="./loginAf.jsp";
	</script>


<%
}
%>