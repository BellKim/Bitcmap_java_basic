<%@page import="bit.com.a.MyClass"%>
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
	<!--  1  -->
<h1>Hello 1 jsp </h1>

<%
	MyClass cls = (MyClass)request.getAttribute("mycls");

%>

number:<%=cls.getNumber() %><br>
name:<%=cls.getName() %><br>

<br><br>

<%-- EL TAG --%>
<!-- 2  -->
number:${mycls.number } <br>
name:${mycls.name }<br>


<br><br>
<!-- 3  -->
<form action="move.do">
	아이디 : <input type="text" id="checkid"><br><br>
	<button type="button" id="_check" onclick="idcheck()"> id </button>
</form>

<script type="text/javascript">
	function idcheck(){
		//alert("idcheck");//버튼 동작 여부 확인.
		 $.ajax({
			 url:"./idcheck.do",	//이제 idcheck.do 컨트롤러로 이동하자. 
			 type:"get",
			 data:"id="+$("#checkid").val(),
			 success:function(data){
				 alert("success");
				 alert("data = "+data );
				 console.log(data);
				 },
				 error:function(){
					 alert("error");
					 }


			 });
		
	}//end idcheck() function
</script>

	<br><br>
	<!-- 4 form 을 통해서 데이터를 전송 한다.   -->
	<!--  다수의 데이터를 전송하게 된다.  -->
	<form action="" method="post">
		이름:<input type="text" id="_name" value="홍길동이"> <br>
		전화:<input type="text" id="_phone" value="01012341234"> <br>
		이메일:<input type="text" id="_email" value="hello@world.com"> <br>
		생년월일:<input type="text" id="_birth" value="2001/01/12"> <br>
		<button type="button" id="account" >account</button>
		
	</form>

	<script type="text/javascript">
		$("#account").click(function(){
			//alert("클릭이 잘 되어 들어오는지 확인해 본다. ");

			var human = {
					name:$("#_name").val(),
					tel:$("#_phone").val(),
					email:$("#_email").val(),
					birth:$("#_birth").val()
					};
			$.ajax({
				url:"./account.do",	//보낼controller
				data:human,		//보낼 데이터
				type:'post',	//보낼방식
				dataType:'json',//받을데이터형태
				async:true,	//동기방식
				success:function(resp){
					alert("success");
					console.log(resp.msg);
					console.log(resp.name);
					
					
					},
				error:function(){
					alert("error");
					}
				
				});


		});

		

	</script>



		<br><br><br>
		
		
		이름:<input type="text" id="_name1" value="정수동동이"><br>
		전화:<input type="text" id="_phone1" value="010-9999-0999"><br>
		이메일:<input type="text" id="_email1" value="health@life.com"><br>
		생년월일:<input type="text" id="_birth1" value="2011-11-33"><br>
		<button type="button" id="account1">account</button>
		
		<script type="text/javascript">
		$("#account1").on("click", function(){
		   var data = {};
		   
		   data["name"] = $("#_name1").val();
		   data["tel"] = $("#_phone1").val();
		   data["email"] = $("#_email1").val();
		   
		   var birth = $("#_birth1").val();
		   data["birth"] = birth.replace(/-/g, "");//2020-02-25 ->20200225
		   //alert(data["birth"]);

			$.ajax({
				contentType:'application/json',	//목적:json으로 날려주면 map으로 받는것이 목적
				dataType:'json',
				url:"updateUser.do",//컨트롤러로 가라.
				type:'post',
				data:JSON.stringify(data),		//json->String     json반대:parse
				//데이터가 갔다 왔을때의 상황 
				success:function(resp){
					alert("success");
					console.log(resp);
					},
				error:function(error){
					alert("fail");
					}
				



				
				});




		   
		   
		});


		
		
		</script>





</body>

</html>