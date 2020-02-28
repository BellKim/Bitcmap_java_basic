<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
    
    
    
    <c:if test="${not empty login}">		<!--  login이 됐을 경우  -->
    	${login.id } 님 안녕하세요
    	<table border="1 bgcolor="Gray">
    		<col width="200">
    			<tr>
    				<td> 
    					<a href="bbslist.do"> 글 목록 </a>
    				</td>
    			</tr>
    			<tr>
    				<td> 
    					<a href="bbswrite.do"> 글 쓰기  </a>
    				</td>
    			</tr>
    		<col>
    	</table>
    </c:if>
    
    
    <c:if test="${empty login}">		<!--  login이 되지 않았을 경우 -->
    	<form action="loginAf.do" method="post">
    		<table border="1">
    			<tr>
    				<td>
    					아이디
    				</td>
    				<td>
    					<input type="text" name="id" size="20">
    				</td>
    			</tr>
    			
    			<tr>
    				<td>
    					비밀번호 
    				</td>
    				<td>
    					<input type="text" name="pwd" size="20">
    				</td>
    			</tr>
    			<tr>
    				<td colspan="2">
    					<input type="submit" value="log-in">
    				</td>
    			</tr>
    			
    			
    		</table>
    	</form>
    	
    	<a href="regi.do">회원가입</a>
    </c:if>
    
    
    