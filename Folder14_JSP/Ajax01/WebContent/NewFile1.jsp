<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!--
	AJAX : Asynchronous JavaScript ANd XML
	목적 : 비동기 상태로 데이터 송수신 목적.
	
	synchronous : 동기
	CustUserAdd.jsp => custUserAddAf.jsp -> 
	form	 name		DB 		insert.
	
	CustUserAdd.jsp		<- DB, Controller, Dao
	현재 form 을 유지한 상태로 데이터 통신을 수행한다. 
 -->
</head>
<body>
	<p id="demo"></p>
	
	<br>
	
	<button type="button"> click </button>
	<script type="text/javascript">
		$(function(){
			$("button").on("click",function(){
			//$("button").click(){
				//$("#demo").load("data.html");
				//$("#$demo").load("data.html");
				//$("#demo").load("data.html #data2");
				
				//$("#demo").load("data.jsp", "t1=abc&t2=가나다");
						//load를 읽어와서 #demo 위치에 뿌려라. 
				
				//$("#demo").load("data.jsp", {t1:"ABC", t2:"다라마"});
			/*
				$("#demo").load("data.jsp", function(data, status, xhr){//jsp 전체 영역의 데이터를 전부 받아올 수 있다. 
					alert(data);
				
				});
			*/
			
				$("#demo").load("data.jsp", {t1:"ABC", t2:"다라마"}, function(data, status, xhr){//jsp 전체 영역의 데이터를 전부 받아올 수 있다. 
					console.log(data);
				
					$("#demo").append("data = " + data + "<br>");
					$("#demo").append("status = " + status + "<br>");
					$("#demo").append("xhr = " + xhr + "<br");
				});
				
			
					
				
				
				
			});
		});
	</script>
</body>
</html>