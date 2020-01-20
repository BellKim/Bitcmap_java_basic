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
	
		String address = "서울시";
	
	%>
	<form action="NewFile.jsp" method="post">
		<input type="text" name="age" value="10">
		<input type="text" name="addr" value="<%=address %>">
		<input type="hidden" name="command" value="<%="비밀데이터" %>"><br>
					<%--hidden : 외부에는 공개가 되지 않는다. --%>
		<input type="submit" value="전송">
	</form>
	
	<br><br>
	
	<form action="NewFile1.jsp" method="post"><br>
		<input type="text" id="name" value="홍길동"><br>
		<input type="text" id="email" value="hgd"><br>
		<button type="button" onclick="sendData()"> 전 송 </button><br>
	</form>
	
	<script type="text/javascript">
		function sendData(){
			var name=document.getElementById("name").value;
			var email=document.getElementById("email").value;

			location.href="NewFile1.jsp?name="+name+"&email="+email;
			
		}
	
	</script>

	
	<br><br><br><br>
	<form id="frm" action="NewFile2.jsp" method="post">
		<input type="text" id="age" name="age" value="10"><br>
		<input type="text" id="addr" name="addr" value="<%=address %>"><br>
		<input type="button" id="btn" value="전 송 "><br>
		
	</form>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btn").click(function(){
				alert("클릭됨이 확인되었다.");
				$("#frm").submit();
			});
		});
		
	</script>
	

</body>
</html>