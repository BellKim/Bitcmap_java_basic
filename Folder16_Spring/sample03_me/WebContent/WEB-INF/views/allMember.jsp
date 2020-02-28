<%@page import="bit.com.a.model.MemberDto"%>
<%@page import="java.util.List"%>
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

	<%
		List<MemberDto> list = (List<MemberDto>)request.getAttribute("memlist");
	%>
	
	<%
		for(int i=0; i<list.size(); i++){
			MemberDto mem = list.get(i);
			%>
			<p><%=mem.toString() %> </p>
			System.out.println("hello");
			<%
			
		}
	%>
	
	<h1> 출력여부 확인 </h1>
	
	<h4> 로그인 입니다. </h4>
	
	
	<form action="" id="send_login_info" method="GET">
		<input type="text" id="id" name="_id" value="hello">
		<input type="text" id="password" name="_password" value="hello">
		<input type="button" id="sub_btn" value="sendInfo">
	</form>
	
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#sub_btn").click(function(){
				//console.log("123123");
				var data = {
						id:$("#id").val(),
						password:$("#password").val()
						};
				$.ajax({
					url:"./loginCheck.do",
					data:data,
					type:'get',
					dataType:'json',
					async:true,
					success:function(resp){
						alert("successs"+resp);
						
						},
					error:function(){
						alert("fail  !"+resp);
						}
					});
				});
			
			});

	</script>
	
	
	
	
</body>
</html>