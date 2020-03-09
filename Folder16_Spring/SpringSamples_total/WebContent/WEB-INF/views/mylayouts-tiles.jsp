<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- 
<% request.getAttribute("utf-8"); %> --%>



<!-- 인코딩 포맷을 설정하는 또다른 방식 -->
<fmt:requestEncoding value="utf-8"/>




<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<tiles:insertAttribute name="header"/>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css">


</head>
<body>
	<div id="body_wrap">
		<div id="main_wrap">
			<tiles:insertAttribute name="top_inc"/>
			<tiles:insertAttribute name="top_menu"/>
		</div>
		<div id="middle_wrap">
			<div id="sidebar_wrap">
				<tiles:insertAttribute name="left_menu"/>
			</div>
			<div id="content_wrap">
					<div class="title">${doc_title }</div>			
			</div>
			
			<tiles:insertAttribute name="main"/>
			
			<div id="footer_wrap">
				<tiles:insertAttribute name="bottom_wrap"/>
			</div>
		</div>
	</div>
	
	
<script type="text/javascript">
	$(document).ready(function(){
		$("#content_title_wrap div.title").css("background-image","url('./image/ico_sub_sb.gif')");
		
	});
	

</script>


</body>
</html>









