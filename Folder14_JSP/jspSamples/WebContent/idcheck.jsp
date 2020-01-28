<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String id = request.getParameter("id");
System.out.println("id : " + id);

MemberDao dao = MemberDao.getInstance();
boolean b = dao.getId(id);

if(b == true){		//아이디가 이미 존재한다(신규가입에 사용할수 없다.)
	out.println("NO");
}else {				//아이디가 존재하지 않는다.(신규가입 가능)
	out.println("YES");
}

%>
