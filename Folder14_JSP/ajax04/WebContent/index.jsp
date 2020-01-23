<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<p id="demo"></p>
<br>
<button type="button">click</button>

<script type="text/javascript">
//$(function () {});
$(document).ready(function(){
	$("button").click(function(){
		$.ajax({
			url:"./hello",
			type:"post",
			datatype:"json",
			data:"num=1",
			success:function(data){
				//alert("success");
				console.log("data");
				console.log(data[0].number);
				console.log(data[0].name);
				
				$.each(data, function(i, val){
					$("#demo").append("i:" + "number : " + val.number + " name : " + val.name + "<br>");
					
				});
			},
			error:function(){
				alert("error");
			}
			
			
		});
	});
});
</script>

</body>
</html>