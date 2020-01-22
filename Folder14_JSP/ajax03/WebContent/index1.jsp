<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<button type="button"></button>

<script type="text/javascript">

	$("button").click(function(){
		$ajax({
			url:"custuser",		//servlet
			type:"get",
			datatype:"json",
			data:"id=abc&pwd=123",
			success:function(json){
				alert("success");		//int, String 다수의 데이터
				 
			},
			error:function(){
				alert("error");
			}
		})
	});
</script>

</body>
</html>