<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

</script>

</head>
<body>

	<button type="button"> click</button>
	<script type="text/javascript">
		$("button").click(function(){
			$.ajax({
				url:"data.json",
				type:'get',
				datatype:'json',
				success:function(json){
					//console.log('success');
					//console.log(json);
					//console.log(json[0].name + " " + json[0].age);
					/*
					for(i=0;i<json.length; i++){
						$("#demo").append(json[i].name+ " ");
						$("#demo").append(json[i].age+ " ");
						$("#demo").append(json[i].address+ " ");
						$("#demo").append(json[i].phone+ " <br>");
					}
					*/
					$.each(json, function(index, item){
						$("#demo").append(index + " ");
						$("#demo").append(item.name + " ");
						$("#demo").append(item.age + " ");
						$("#demo").append(item.address + " ");
						$("#demo").append(item.phone + " <br> ");
						
					})
				},
				error:function(){
					alert('error');
				}
				
			})
		});
	</script>
	<p id="demo"> hello </p>
	
	
</body>
</html>