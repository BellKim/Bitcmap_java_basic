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
$(function () {
	
	$("button").click(function () {
		// Jar 파일을 추가할 것!!	
		$.ajax({
			url:"custuser",		// servlet
			type:"get",
			datatype:"json",
			data:"id=abc&pwd=123",
			success:function( json ){
				alert("success");				// int, string, 다수의 데이터
			//	alert(json.str);
			//	alert(json.map.title);
			//	alert(json.map.list);
				var list = json.map.list;
				alert(list[0].number);
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


