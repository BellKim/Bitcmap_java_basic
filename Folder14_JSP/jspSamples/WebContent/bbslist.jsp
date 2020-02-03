<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbsDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	//댓글의 여백과 이미지를 추가하는 함수.  
public String arrow(int depth){
	String rs = "<img src='./image/arrow.png' width='20px' height='20px'/> ";
	String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";
	String ts = "";
	
	for(int i=0; i<depth; i++){
		ts+=nbsp;
	}
	return depth==0?"":ts+rs;	//ts+rs 여백 + 화살표이미지
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	Object ologin = session.getAttribute("login");
	//request.getSession().getAttribute(name);
	MemberDto mem = null;
	if(ologin == null){
		%>
		<script type="text/javascript">
			location.href="login.jsp";
		</script>
		<%
	}
	mem=(MemberDto)ologin;
	
	BbsDao dao = BbsDao.getInstance();
	
	List<BbsDto> list = dao.getBbsList();
	
	request.setAttribute("list", list);
	
%>

<h4 align="right" style="background-color:#f0f0f0">
	환영합니다 <%=mem.getId() %>님
</h4>
<h1> 게 시 판 </h1>

<a href="./calEx/calendar.jsp">일정관리</a>

<div align="center">
	<table border="1">
		<col width="70"><col width="600"><col width="150">
		<tr>
			<th>
				번호
			</th>
			<th>
				제목
			</th>
			<th>
				작성자
			</th>
		</tr>
				<%
				if(list == null || list.size() == 0){
				%>
				<tr>
					<td colspan="3"> 작성된 글이 없습니다. </td>
				</tr>
				<%
				}else{
					for(int i=0; i<list.size(); i++){
						BbsDto bbs = list.get(i);
				%>
		<tr>
			<th><%=i+1 %></th>
			
			<td>
				<%=arrow(bbs.getDepth()) %>
			    <%if(bbs.getDel()==1){%>
			        <a>
			          << 해당글이 삭제되었습니다. >>
			        </a>
			    <%
			    }else{
			    %>
			        <a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>">
			            <%=bbs.getTitle() %>
			        </a>
			    <%    
			    }
			    %>
				<%--
				<a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>">
				    <%=bbs.getTitle() %>
				</a>
				--%>
			</td>
			
			<td align="center">
				<%=bbs.getId() %>
			</td>
		</tr>
		
		<%
			}
		}
		%>
		
	</table>
</div>

	<%--  검색기능 추가함.  --%>
	<div align="center">
		
	</div>

<a href="bbsWrite.jsp"> 글 쓰 기 </a>

</body>
</html>