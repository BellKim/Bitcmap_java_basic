<%@page import="main.MovieVo"%>
<%@page import="main.MovieManager"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<MovieVo> list = MovieManager.getCGVdata();
	for(int i=0; i<list.size(); i++){
		System.out.println(list.get(i).getTitle());
		System.out.println(list.get(i).getLike());
	}
	
	//list -> json
	String jsonlike="[";
	
	for(MovieVo m: list){
		jsonlike += "{ name:'" + m.getTitle() + "', y:"+m.getLike()+ "', imgsrc:'"+m.getPosterLoc()+"},\n";
	}
	jsonlike = jsonlike.substring(0,jsonlike.lastIndexOf(","));
	jsonlike += "}";
	System.out.println(jsonlike);
	
	request.setAttribute("jsonlike", jsonlike);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>

<title>Insert title here</title>
</head>
<body>
<h1> hello test</h1>

<div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>

<script type="text/javascript">
Highcharts.chart('container', {
	  chart: {
	    plotBackgroundColor: null,
	    plotBorderWidth: null,
	    plotShadow: false,
	    type: 'pie'
	  },
	  title: {
	    text: ' 영화가 좋아요? '
	  },
	  tooltip: {
	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	  },
	  plotOptions: {
	    pie: {
	      allowPointSelect: true,
	      cursor: 'pointer',
	      dataLabels: {
	        enabled: true,
	        format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	      }
	    }
	  },
	  series: [{
	    name: 'Brands',
	    colorByPoint: true,
	    data: <%=request.getAttribute("jsonlike") %>
	  }]
	});

</script>

<%
	for(MovieVo j: list){
		 %>
			<img src="<%=j.getPosterLoc()%>"  alt="어느이미지" >
		<%	
	}
	 %>
	 
</body>
</html>