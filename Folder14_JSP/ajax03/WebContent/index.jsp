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

<button type="button"> click</button>
	
	<p id="demo"> hello </p>
	
	<script type="text/javascript">
		var target = [];
		var link = [];
		var aname = [];
		$(function (){
			//model1, model2
			$("button").click(function(){
				$.ajax({
					url:"data.jsp",
					type:"get",			//jsp
					datatype:"json", success:function(obj ){
						console.log("success!");
						
						console.log(obj);
						console.log(obj.num);
						
						//string -> json
						var data = JSON.parse(obj);
						console.log("data = "+data.num);
						
						//json -> string
						var str = JSON.stringify(data);
						console.log("str.num = "+str.num);
						
						
					},
					error:function(){
						console.log("error");
					}
					
					
					
				});
				
			});
		});
	</script>

		
		
	

</body>
</html>