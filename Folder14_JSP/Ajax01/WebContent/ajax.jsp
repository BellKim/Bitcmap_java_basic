<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("button").click(function(){
			$.ajax({
				url:"data.jsp",		//가야할곳
				type:"get",		//get/post
				data:"t1=XYZ&t2=자차카",	//보내주는 파라미터 (parameter)
				data:{t1:"home", t2:"성공"},
				
				success:function(data, status, xhr){
					//alert("성공");
					//$("#demo").text(data);
					$("#demo").html(data);
					//alert(status);
					//alert(xhr);
					
				}, 
				error:function(xhr, status, error){
					alert("실패");
				},
				complete: function(xhr, status){
					//alert("통 신 종 료");
				}
				
				
				
				
			});	
		});
		
	})
	
</script>
</head>
<body>
	<button type="button"> 버튼 </button>
	<p id="demo"> hello</p>
	

</body>
</html>