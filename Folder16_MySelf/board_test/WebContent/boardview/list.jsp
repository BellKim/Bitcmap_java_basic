<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">d
		<title>Insert title here</title>
<!--style-->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!--script-->
	<script type="text/javascript">
		$(document).ready(function(){
			
 			$('#searchBtn').on('click', function( ) {
 				$('form').attr('action', 'list.do');
				$('form').submit( ); 
			});  
 			
 			//검색-> 글읽기-> 목록 눌러서 목록으로 돌아왔을때 검색창에 항목과 검색어가 그대로 남아있도록 하는것. )
 			$('[name=searchWord]').val('${pdto.searchWord}');
 			switch('${pdto.searchKey}'){			
 			case 'all' : $('[value=all]').prop('selected','selected');
 					$('[name=searchWord]').val('');   break;
 			case 'subject' : $('[value=subject]').prop('selected','selected'); break;
 			case 'writer' : $('[value=writer]').prop('selected','selected'); break;
 			case 'contetn' : $('[value=content]').prop('selected','selected'); break;
 			}
		
		});
	</script>
	</head>
	<body>
		<!-- 리스트엑션 불러오기.  -->
		
		<div class="wrap">
			<p>
				<a href="writeForm.do"> 글쓰기. </a>
			</p>
			<p>
				<form>
					<select name="searchKey">
						<option value="all"> 검색어 업력 </option>
						<option value="subject"> 제목  </option>
						<option value="content"> 내용 </option>
						<option value="writer"> 글쓴이 </option>
					</select>
					<%-- 대소문자 구분없이 문자를 검색하여 가져온다. --%>
					<input type="text" name="searchWord"/>
					<input type="button" value="검색" id="searchBtn"/>
				</form>
			</p>
			<!-- ?searchkey=" value name "&searchWord="검색어" -->	
			<table>
				<tr>
					<th>num</th>
					<th>subject</th>
					<th>writer</th>
					<th>readcount</th>
					<th>file</th>
				</tr>
				
				<c:forEach items="${requestScope.aList }" var="dto"><!-- boardController의 aList -->
					<tr>
						<td>${dto.num }</td>
						<td>
							<!--답변글 출력 -->
							<c:if test="${dto.re_level!=0 }"> <%-- 답변글일때 출력될 이미지 --%>
							 <img src="../boardview/images/level.gif" width="${20*dto.re_level }" height="20px"/><%--공백을 이용한 위치변화 --%>
								<img src="../boardview/images/re.gif"/>
							</c:if>
								<c:url var="link" value="view.do">
									 <c:param name="num" value="${dto.num}"/>
									 <c:param name="pageNum" value="${pdto.currentPage}" />
									 <c:param name="searchKey" value="${pdto.searchKey}" /> 
									 <c:param name="searchWord" value="${pdto.searchWord}" />
								</c:url>
							
							<%-- <a href="view.do?num=${dto.num}&pageNum=${pdto.currentPage}">${dto.subject }</a> 
								c:url 부분과 <a> 테그 부분이 추가되었음. 검색후 글을 누르고 나서 목록을 누르면 기존의 리스트로 돌아가게 하기 위한 목적의 코드. 
							--%>
										 <!-- 목록을 눌렀을떄 현재페이지로 가기위해서 추가설정한부분 &pageNum=${pdto.currentPage} -->
										 
										 
							<a href="${link}">${dto.subject }</a>			  
						</td>
						<td>${dto.writer }</td>
						<td>${dto.readcount }</td>
						<%-- <td>${dto.upload }</td> --%>   <%--파일명이나오도록하는부분 --%>
						<td> <%-- 첨부파일이 있다고 이미지로 표시하는 부분. --%>
							<c:if test="${!empty dto.upload}">
							<a href="download.do?num=${dto.num}">
								<img src="../boardview/images/save.gif"/>
							</a>
								
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
			
			<p><!-- 페이지번호 출력하기 -->
			<!-- 이전 123 다음 
				  이전 456 다음  		구현하기. -->
				<!-- 이전 -->
				<c:if test="${pdto.startPage>1 }">
					<a href="list.do?pageNum=${pdto.startPage-pdto.blockPage}&searchKey=${pdto.searchKey}&searchWord=${pdto.searchWord}"> PREV</a>
				</c:if> 
				<!--이전끝. -->
			
				<c:forEach begin="${pdto.startPage }" end="${pdto.endPage }" var="i"><%--리퀘스트영역에 저장되어있는 pdto --%>
					<%--var에 저장되어있는 i를 페이지 출력함. --%> 		<%-- --%>
					<span> <a href="list.do?pageNum=${i}&searchKey=${pdto.searchKey}&searchWord=${pdto.searchWord}"> ${i} </a> </span>
				</c:forEach>
				
				<!-- 다음  -->
				<!-- 엔드페이지가 토탈페이지보다 작을때, 다음이 활성화 되도록한다. -->
				<c:if test="${pdto.endPage<pdto.totalPage}">
					<a href="list.do?pageNum=${pdto.startPage+pdto.blockPage}&searchKey=${pdto.searchKey}&searchWord=${pdto.searchWord}"> NEXT </a>
				</c:if> 
				 
				<!-- 다음끝 -->
				
			</p><!-- 페이지번호 출력하기 끝. -->
			<!-- 
			   구현순서 
			페이지번호 구현 -> 
			페이지 다음 이전 구현 -> 
			2페이지 누르고 목록누르면 2페이지로 돌아오게 하기. -->
			
		</div>
		
	</body>
</html>