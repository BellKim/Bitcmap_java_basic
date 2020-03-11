<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- arrow class 생성 -->
<jsp:useBean id="ubbs" class="bit.com.a.util.BbsArrow"/>

<table class="list_table" style="width: 85%">
<colgroup>
	<col style="width: 70px">
	<col style="width: auto">
	<col style="width: 100px">
</colgroup>

<thead>
	<tr>
		<th>번호</th><th>제목</th><th>작성자</th>
	</tr>
</thead>

<tbody>
	<c:if test="${empty bbslist }">
	<tr>
		<td colspan="3">작성된 글이 없습니다</td>
	</tr>
	</c:if>
	
	<c:forEach items="${bbslist }" var="bbs" varStatus="vs">
	
	<!-- arrow를 setting -->
	<jsp:setProperty property="depth" name="ubbs" value="${bbs.depth }"/>
	
	<tr class="_hover_tr">
		<td>${vs.count }</td>
		<td style="text-align: left;">
			<jsp:getProperty property="arrow" name="ubbs"/>
		
			<c:if test="${bbs.del eq 1 }">
				<font style="color: red;">***이 글은 게시자에 의해서 삭제 되었습니다***</font> 	
			</c:if>
			<c:if test="${bbs.del eq 0 }">
				<a href="bbsdetail.do?seq=${bbs.seq }">
					${bbs.title }
				</a>			
			</c:if>
		</td>
		<td>${bbs.id }</td>		
	</tr>	
	
	</c:forEach>
	

</tbody>

</table>  



  