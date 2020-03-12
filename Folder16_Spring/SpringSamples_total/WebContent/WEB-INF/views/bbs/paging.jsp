<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
페이징 구현방식 
하단 페이지 번호부분은 JSP 에서 별도로 구성해서 추가해줘야한다. 
페이징 표현방식을 구현함에 있어서 현재 페이지 번호를 알고 있어야 함이 중요하다. 
paging 부분에서 별도 추가해서 구성한다. 

--%>

<!--  paging 연산  -->
<%
/*
맨처음,  				맨끝
	<<  < [1][2][3][4][5]   >  >>
*/
	int totalRecordCount;		//전체 글의 수		23중에  -> 3
	int pageNumber;				//현재 페이지		0~9 까지 표현   -> [1] ~ [10]
	int pageCountPerScreen;		//스크린당 페이지수	[1]~[10],  [1]~[5],	
	int recordCountPerPage;		//페이지당 글의 수 	[1]페이지 	-> 글 10 개 
	
	String st1 = request.getParameter("totalRecordCount");
	if(st1 == null){	//파라미터가 안넘어 왔다 = 제일 첫번째 페이지이다. 
		totalRecordCount = 0;
	} else{
		totalRecordCount = Integer.parseInt(st1);
	}
	
	String st2 = request.getParameter("pageNumbaer");
	if(st2 == null){
		pageNumber = 0;
	} else{
		pageNumber = Integer.parseInt(st2);
	}
		
	String st3 = request.getParameter("pageCountPerScreen");
	if(st3 == null){
		pageCountPerScreen = 0;
	} else{
		pageCountPerScreen = Integer.parseInt(st3);
	}
	
	String st4 = request.getParameter("recordCountPerPage");
	if(st4 == null) {
		recordCountPerPage = 0;
	} else {
		recordCountPerPage = Integer.parseInt(st4);
	}
	
	//총 페이지의 수 [1][2][3]
	int totalPageCount = totalRecordCount / recordCountPerPage;
	//		2					23				10
	
	//나머지가 존재할시 페이지 카운트를 하나 더 추가해서 보여줌. 2개의 글을 보여주기 위해서.
	if((totalPageCount % recordCountPerPage)!=0){
		totalPageCount++;
		
	}
	
	//시작페이지 [1]   [11]   [21]   어디서 페이징이 시작될 것인가
	int screenStartPageIndex = ((pageNumber + 1) / pageCountPerScreen) * pageCountPerScreen; 
//									0이면 +1해줌.		
//											0+1		/	10				* 	10		= 1
//											9+1		/ 	10 				*	10		= 10


	//끝 페이지계산 [10]  [20]   [30]
	int screenEndPageIndex = (((pageNumber + 1) / pageCountPerScreen) * pageCountPerScreen) + 10;
	//								0					10						10				+10	= 20
			
			
	//끝 페이지 다시계산		-> [1]~[10]   [1]~[3]
	if(screenEndPageIndex > totalPageCount){
		screenEndPageIndex  = totalPageCount;
	}
	
	//후처리	
	//0~9 를 1~10으로 표현해줘야 한다. 
	if((pageNumber + 1)%pageCountPerScreen == 0){
		screenStartPageIndex = (((pageNumber + 1) / pageCountPerScreen) * pageCountPerScreen) - pageCountPerScreen;
		screenEndPageIndex = pageNumber + 1;		// 0-> 1  9->10
	}
	
	System.out.println("screenStartPageIndex"+screenStartPageIndex);
	System.out.println("screenEndPageIndex"+screenEndPageIndex);
	

%>


<!--  페이징 출력  -->
<div style="float: left; width:96%; text-align: center; ">
	<!--  <<  -->
	<a href="#none" title="처음페이지" onclick="goPage('0')">
		<img alt="" src="./image/arrow_first.gif" style="width:9px; height:9px">
	</a>
	
	<!--  <  10개 단위로 이동시키는것. -->
	<!--  <  을 클릭시 [11]~[20] 의 페이지가 [1]~[10] 으로 보여진다. -->
	<%
	if(screenStartPageIndex > 1){	//총 글의 수가 100개 넘어야 한다. 
	%>		
		<a href="#none" title="이전페이지" onclick="goPage('<%=screenStartPageIndex-1 %>')">
			<img alt="" src="./image/arrow_back.gif" style="width:9px; height:9px; ">
		</a>
	<%
	}
	%>
	
	
	<!--  [1] 2 [3]  -->
	<%
		for(int i=screenStartPageIndex; i<screenEndPageIndex; i++){
			if(i == pageNumber){//현재 페이지	2
			%>
			<span style="font-size: 9pt; color:#000000; font-weight:bold;">
				<%=i+1 %>
			</span>	
			<%
			}else{		//그 외의 페이지	[1] 2 [3][4][5][6]
			%>
				<a href="#none" title="<%=i+1 %>페이지" onclick="goPage(<%=i %>)"	style="font-size:7.5pt; color:#000000; font-weight:normal;">
					[<%=i+1 %>]
				</a>
			<%		
			}
		}
	
	%>
	<!--  >  -->
	<!--  > 클릭시 1~10 페이지 넘버가 보이던걸 11~20으로 보이도록 한다.   -->
	<%
	if(screenEndPageIndex < totalPageCount){		//[11][12][13]   //13페이지까지가 끝일경우 더이상 안보이도록 한다.
	%>
		<a href="#none" title = "다음페이지" onclick="goPage(<%=screenEndPageIndex %>)">
			<img alt="" src="./image/arrow_next.gif" style="width:9px; height:9px;">
		</a>
	<%	
	}
	int end_page=0;
	if(totalPageCount > 0){
		end_page = totalPageCount -1;
	}
	
	%>
	
	<!--  >>  -->
	<a href="#none" title="마지막페이지" onclick="goPage(<%=end_page %>)">
		<img alt="" src="./image/arrow_end.gif" style="width:9px; height:9px;">
	</a>
	
</div>















