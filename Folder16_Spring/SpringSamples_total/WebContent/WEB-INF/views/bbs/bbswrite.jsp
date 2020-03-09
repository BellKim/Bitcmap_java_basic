<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    	

<div class="menu_table">
	<ul style="width: 90%">
		<li class="title">
			글쓰기
		</li>
		<li class="subtitle">
			게시판
		</li>
		<li class="subtitle">
			<a href="bbslist.do" title="글목록">글목록</a>
		</li>
		<li class="subtitle">
			<a href="bbswrite.do" title="글쓰기">글쓰기</a>
		</li>
	</ul>
</div>

<%-- <table class="list_table" style="width: 85%">
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
				<td colspan="3"> 작성된 글이 없습니다. </td>
			</tr>
		</c:if>
		<c:forEach items="${bbslist }" var="bbs" varStatus="vs">
			<tr class="_hover_tr">
				<td>${vs.count }</td>
				<td style="text-align: left;">
					<a href="bbsdetail.do?seq=${bbs.seq }">${bbs.title }</a>
				</td>
				<td>${bbs.id }</td>		
			</tr>	
		</c:forEach>
	</tbody>
</table> --%>

	
	
	
	