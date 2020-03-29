<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    	

<div class="menu_table">
	<form action="bbswriteAf.do" id="submit_form" method="post">
		<ul style="width: 90%">
			<li class="title">
				글쓰기
			</li>
			<li class="subtitle">
				<p style="width:20%" style="float:left;">아이디</p>
				<input type="text" id="_id" name="id" value="${login.id }" readonly>
			</li>
			<li class="subtitle">
				<p style="width:20%" style="float:left;">제목</p>
				<input type="text" id="_title" name="title">
			</li>
			<li class="subtitle">
				<p style="width:20%" style="float:left;">내용</p>
				<input type="text" id="_content" name="content">
			</li>
			<li>
				<input type="button" id="_regiTolist" value="등록">
				<input type="button" id="_goToList" value="글 목록으로 이동">
			</li>
		</ul>
	</form>
	
</div>

<script type="text/javascript">
	$(document).ready(function(){
		
		$("#_regiTolist").click(function(){
			//alert("클릭됨");
			var res = "${login.id}";
			console.log("${login.id}");
			$("#submit_form").submit();
		});

		$("#_goToList").click(function(){
			location.href="bbslist.do";
		});
		
	});
	


</script>
