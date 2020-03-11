<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="utf-8"/>
    
<%-- 
<%
MemberDto mem = (MemberDto)request.getSession().getAttribute("login");
%>

<%
BbsDto bbs = (BbsDto)request.getAttribute("bbs");
%> 
--%>
    
    
<h1>상세 글 보기</h1>

<div align="center">

<table border="1">
<colgroup>
	<col style="width: 150">
	<col style="width: 600">
</colgroup>

<tr>
	<th>작성자</th>
	<td>
		<%-- 	<%=bbs.getId() %> --%>
		${bbs.id }
	
	</td>
</tr>

<tr>
	<th>제목</th>
	<td>
		<%-- <%=bbs.getTitle() %> --%>
		${bbs.title }
	</td>
</tr>

<tr>
	<th>작성일</th>
	<td>
		<%-- <%=bbs.getWdate() %> --%>
		${bbs.wdate }
	</td>
</tr>

<tr>
	<th>조회수</th>
	<td>
		<%-- <%=bbs.getReadcount() %> --%>
		${bbs.readcount }
	</td>
</tr>

<tr>
	<th>정보</th>
	<td>
		<%-- <%=bbs.getRef() %>-<%=bbs.getStep() %>-<%=bbs.getDepth() %> --%>
		${bbs.ref }
	</td>
</tr>

<tr>
	<th>내용</th>
	<td align="center">
		<textarea rows="10" cols="90" readonly="readonly">
			<%-- <%=bbs.getContent() %> --%>
			${bbs.content }
		</textarea>
	</td>
</tr>
</table>
<%-- <% 
if(bbs.getId().equals(mem.getId())){
%>
<button type="button" onclick="updateBbs(<%=bbs.getSeq() %>)">수정</button>
<button type="button" onclick="deleteBbs(<%=bbs.getSeq() %>)">삭제</button>
<%
}
%> --%>

<form action="answer.do" method="get">
	<input type="hidden" name="seq" value="<%-- <%=bbs.getSeq() %> --%>${bbs.seq }">
	<input type="submit" value="댓글">
</form>

<button type="button" onclick="location.href='bbslist.do'">목록</button>

</div>

<script type="text/javascript">
function updateBbs( seq ) {
	location.href = "bbsupdate.do?seq=" + seq;
}
function deleteBbs( seq ) {
	location.href = "bbsdelete.do?seq=" + seq;
}

</script>
