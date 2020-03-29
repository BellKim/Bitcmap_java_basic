<%@page import="bit.com.a.util.CalendarUtil"%>
<%@page import="bit.com.a.model.PollDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<PollDto> plists = (List<PollDto>)request.getAttribute("plists");
 %>
 
<%-- 관리자 --%>
<c:if test="${login.auth eq '1'}">
<table class="list_table" style="width:95%">
   <col width="50"><col width="50"><col width="300"><col width="100">
   <col width="100"><col width="50"><col width="50"><col width="100">
   <tr>
      <th>번호</th>
      <th>아이디</th>
      <th>질문</th>
      <th>시작일</th>
      <th>종료일</th>
      <th>투표항목</th>
      <th>투표수</th>
      <th>등록일</th>
   </tr>
<%
for(int i =0 ; i< plists.size(); i++){
   PollDto pollDto = plists.get(i);
%>
   <tr bgcolor="#aabbcc">
      <td><%=i+1 %></td>
      <td><%=pollDto.getId() %></td>
      <td><%=pollDto.getQuestion() %></td>
      <td><%=pollDto.getSdate() %></td>
      <td><%=pollDto.getEdate() %></td>
      <td><%=pollDto.getItemcount() %></td>
      <td><%=pollDto.getPolltotal()%></td>
      <td><%=pollDto.getRegdate() %></td>
      
   </tr>
<%
}
%>
</table>
</c:if>


<%-- 사용자 --%>
<c:if test="${login.auth eq '3'}">
<table class="list_table" style="width:95%">
   <col width="50"><col width="50"><col width="300"><col width="100">
   <col width="100"><col width="50"><col width="50"><col width="100">
   <tr>
      <th>번호</th>
      <th>아이디</th>
      <th>질문</th>
      <th>결과</th>
      <th>시작일</th>
      <th>종료일</th>
      <th>투표항목</th>
      <th>투표수</th>
      <th>등록일</th>
   </tr>
   
   <%
   for(int i =0 ; i<plists.size(); i++){
	      PollDto pollDto = plists.get(i);
	%>
	   <tr bgcolor="#aabbcc">
	      <td><%=i+1 %></td>
	      <td><%=pollDto.getId() %></td>
	      <%
	      boolean result = pollDto.isVote(); // 투표 가능여부
	      
	      // 투표가능 여부 || 기간만료
	      if(result == true || CalendarUtil.isEnd(pollDto.getEdate())== true ){
	      %>
	      <td>[마감]<%=pollDto.getQuestion() %></td>
	      <%
	      }else{
	      %>
	      <td>
	         <a href="pollDetail.do?pollid=<%=pollDto.getPollid() %>">
	            <%=pollDto.getQuestion() %>
	         </a>
	      </td>
	      <%
	      }
	      %>
	      <td>
	      <%
	      if(result == true || CalendarUtil.isEnd(pollDto.getEdate())== true ){
	      %>
	         <a href="pollResult.do?pollid=<%=pollDto.getPollid() %>">
	         결과
	         </a>
	      <%
	      }else{
	      %>
	         <img alt="" src="image/pen.gif">
	      <%
	      }
	      %>
	      </td>
	      <td><%=pollDto.getSdate() %></td>
	      <td><%=pollDto.getEdate() %></td>
	      <td><%=pollDto.getItemcount() %></td>
	      <td><%=pollDto.getPolltotal()%></td>
	      <td><%=pollDto.getRegdate() %></td>
	   </tr>   
	<%
	   }
	%>
	</table>
	</c:if>

	<c:if test="${login.auth eq '1' }">
	   <a href="pollmake.do">투표만들기</a>
	</c:if>
 
  