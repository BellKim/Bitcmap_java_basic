
<%@page import="dto.BbsDto"%>
<%@page import="dto.MemberDto"%>
<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String sseq = request.getParameter("seq");
int seq = Integer.parseInt(sseq);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BBS UPDATE</title>
</head>
<body>

<%--
	작성자
	제목
	작성일		->readcount()
	조회수
	내용
	
 --%>
 
 <%
 	MemberDto mem = (MemberDto)request.getSession().getAttribute("login"); 
 	
 %>
 <%
 	BbsDao dao = BbsDao.getInstance();
 	
 	BbsDto bbs = dao.getBbs(seq);
 	
 %>
 
 
 <%----------------------------------------------------- --%>
 
		 <h1> 상세 글 보기 </h1>
		 
		 <div align="center">
		 	<table border="1">
		 		<colgroup>
		 			<col style="width:150">
		 			<col style="width:600">
		 		</colgroup>
		 		<tr>
		 			<th>작성자</th>
		 			<td><%=bbs.getId() %></td>
		 		</tr>
		 		<tr>
		 			<th>제목</th>
		 			<td><%=bbs.getTitle() %></td>
		 		</tr>
		 		<tr>
		 			<th>조회수</th>
		 			<td><%=bbs.getReadcount() %></td>
		 		</tr>
		 		<tr>
		 			<th>정보</th>
		 			<td><%=bbs.getRef() %>-<%=bbs.getStep() %>-<%=bbs.getDepth() %></td>
		 		</tr>
		 		
		 		<tr>
		 			<th>내용</th>
		 			<td>
		 				<textarea rows="10" cols="90" ><%=bbs.getContent() %></textarea>
		 			</td>
		 		</tr>
		 		
		
		 	</table>
		 	
		 	
		<%
		 	if(bbs.getId().equals(mem.getId())){
		%>
		 	<button type="button" onclick="updateBbs(<%=bbs.getSeq() %>)">수정 완료</button>
		 	<%-- http://localhost:8090/jspSamples/bbsupdate.jsp?seq=25 --%>
		 	
		 	<button type="button" onclick="deleteBbs(<%=bbs.getSeq() %>)">취소</button>
		 	<%-- http://localhost:8090/jspSamples/bbsdelete.jsp?seq=25 --%>
		 <%
		 	}
		 %>
		 
		 <%-- 댓글 부분이 중요하다  --%>
		 <%--
		 <form action="answer.jsp" method="get">
		 	<input type="hidden" name="seq" value="<%=bbs.getSeq() %>">
		 	<input type="submit" value="댓글">
		 </form>
		 
		 <button type="button" onclick="location.href='bbslist.jsp'">목 록</button>
		  --%>
	</div>
		 
		 
		 
 <%-------------------------------------------------------- --%>
 	<script type="text/javascript">
 	
 		function updateBbs(seq){
 			location.href="bbsupdateAf.jsp?seq="+seq;
 		}
 		function deleteBbs(seq){
 			location.href="bbslist.jsp?";
 		}

 	</script>
 


</body>
</html>