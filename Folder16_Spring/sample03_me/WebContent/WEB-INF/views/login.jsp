<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>

<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	
	<form id="frm" method="get">
	
		<!-- <div style="padding: 100px 0 0 250px;"> -->
		<div style="padding: 200px 0px 0 400px;">
			<div id="login-box">
				
				<h2>Login Page</h2>
				홍길동 홈페이지에 오신 것을 환영합니다 
				<br>
				<br>
				
				<div id="login-box-name" style="margin-top:20px;">User Id:</div>
				<div id="login-box-field" style="margin-top:20px;">
					<input id="id" name="id" class="form-login" title="Username" size="30" maxlength="50" />
					<input type="checkbox" id="chk_save_id">Save id 
				</div>
				<div id="login-box-name">Password:</div>
				<div id="login-box-field">
					<input id="pwd" name="pwd" type="password" class="form-login" title="Password" value="" size="30" maxlength="48" />
				</div>
				<br>
				
				<span class="login-box-options">
				New User?  <a href="regi.do" style="margin-left:30px;">Register Here</a>
				</span>
				<br/>
				<br/>
				<!-- <input style="margin-left:100px;" type="submit" value="Login" /> -->
				<input type="button" style="margin-left:100px;width: 100px;height: 30px" id="_btnLogin" value="Login">
			</div>
		</div>
	
	</form>
	
	<script type="text/javascript">

	//아이디 비밀번호 빈칸체크 후 입력폼이 완성되면 loginAf.do 로 전송시킨다.
		$("#_btnLogin").click(function(){
			if($("#id").val().trim() == ""){
				alret("id를 입력해주세요 ");
				$("#id").focus();
			}else if($("#pwd").val().trim() == ""){
				alert("password를 입력해 주세요 ");
				$("#pwd").focus();
			}else{
				$("#frm").attr({"action":"loginAf.do", "target":"_self"}).submit();
			}
		});	//end #btn_login

		
	//체크 선택시 쿠키에 아이디 저장하기
	$("#chk_save_id").click(function(){
		if($("#chk_save_id").id(":checked")){
			if( $("#id").val().trim()==""){
				$("#chk_save_id").prop("checked", false);//해당 요소값을 변경해줌. 
			}else{
				$.cookie("user_id", $("#id").val().trim(), {expires:7, path:'./'});
			}
		}else{
			//alert("체크 없어짐 .");
			$.removeCookie("user_id", {path:'./'});
		}
	});
		

	</script>
	
	

</body>
</html>