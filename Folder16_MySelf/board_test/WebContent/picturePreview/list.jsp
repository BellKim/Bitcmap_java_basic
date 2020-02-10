<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
<!--style-->
<style type="text/css">
	* {
		margin: 0;
		padding: 0;
		border: 0
	}
	
	div.wrap {
		width: 606px;
		margin: auto;
	}
	
	div.line {
		width: 200px;
		height: 220px;
		border: 1px solid black;
		margin-bottom: 10px;
		float: left
	}
	
	.chk {
		float: left;
		width:20px;
		height:20px;
	}
	
	p {
		float: left;
		width: 150px;
	}	
</style>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!--script-->
<script type="text/javascript">
	$(document).ready(function(){
		//$(form).children() 혹은 $('input').length 로 검색. 
		//$('input')[2].checked; -> true or false
		
		$('button').on('click',function(){
			var j = $('input');

 			for(var i=0; i<j.length; i++){
				console.log(i);
				var check11 =$('input')[i].checked; 
  				if(check11){
					console.log(i + "번쨰 선택됨.");
				}
			}
 			
 			var cnt=$('.chk:checked');
			if(cnt.length==0){
				alert("삭제할데이터를 선택.")
				return false;
			}
			console.log("최종 " + cnt);
			$('form').submit();

			
 			
		});
		
		
		
		
		
		
		
		
	});
</script>
	</head>
	<body>
	<a href="insertMain">이미지 삽입</a>
	<h3>이미지 목록</h3>
	<div class="wrap">
		<button>이미지 삭제</button>
		<form method="post" action="testDel">
		 <c:forEach items="${requestScope.aList}" var="dto">
		 	<div class="line">
		 	<%-- <img src="/images/${dto.filepath}" 로는 가지고 올수강벗다. --%>
		 	 <img src="../images/${dto.filepath}" 
				     width="200" height="200" /> <!-- src 절대경로가 아닌 상대경로 -->
				     
			<input type="checkbox" name="chk" 
				    class="chk" value="${dto.num}" />
		
			 <p>${dto.filepath}</p>
		 	</div>
		 </c:forEach>
		</form>
	</div>
	
	
</body>
</html>