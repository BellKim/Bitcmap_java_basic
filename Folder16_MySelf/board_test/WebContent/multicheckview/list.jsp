<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, th, td{
		border: 1px solid black;
		border-collapse: collapse;
		
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			
			//전체선택 맻 전체 해제.
			$('.check_all').click(function(){
				$('.chk').prop('checked', this.checked);				
			});
			
			
			$('button').on('click',function(){
				var cnt=$('.chk:checked');
				if(cnt.length==0){
					alert("삭제할데이터를 선택.")
					return false;
				}
				$('form').submit();
			});
			

		});
		
	</script>
</head>
<body>
	<div class="wrap">
		<form action="multi" method="post">
			<button>  사 악 제 </button>
			
			<table>
			
				<tr>
					<th> 
						<input type="checkbox" class="check_all" id="check_all"/>
						<!-- id=checkall 하고 라벨 forall 해주면 전체선택 버튼을 눌러줬을때 같이 눌린다. -->
						<label for="check_all"> 전체선택 </label>
					</th>
					<th>num</th>
					<th>name</th>
					<th>age</th>
					<th>loc</th>
				</tr>
				
				<c:forEach items="${requestScope.aList}" var="dto">
				<tr><!--  name 의 이름이 뭐로 되어있는지 확인해보도록 한다.  -->
					<td><input type="checkbox" name="chk" class="chk" value="${dto.num}"/></td>
					<td>${dto.num }</td>
					<td>${dto.name }</td>
					<td>${dto.age }</td>
					<td>${dto.loc }</td>
				</tr>
				</c:forEach>
				
			</table>
		
		</form>
	</div>

</body>
</html>