<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel = "stylesheet" href="css/common.css"/>
<title>jsp_009_red.jsp</title>
</head>
<body>
	<div class="wrap">
		<header>
			<jsp:include page="jsp_009_top.jsp"/>
		</header>
		<section class="main_left">
			<nav>
				<jsp:include page="jsp_009_menu.jsp"/>
			</nav>
		</section>
		<section class="main_right">
			<div style='background-color:red; height:490'>
				red page
			</div>
		</section>
		<footer>
			<jsp:include page="jsp_009_bottom.jsp"/>
		</footer>
		
		
		
		
	</div>

</body>
</html>