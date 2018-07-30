<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="retail.common.BaseEnv"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/jsp/retail/inc_common/inc_common.jsp" %>

<jsp:include page="/WEB-INF/jsp/retail/inc_common/inc_head.jsp" /> 
 
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta http-equiv="Content-Type" content="text/html" charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>업무평가 앱 - 평가그래프</title>
	<!-- link type="text/css" rel="stylesheet" href="/resources/css/chart/Nwagon.css" -->
	
	<script type="text/javascript" src="/resources/js/jquery-1.7.1.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="/resources/js/jquery.cookie.js" charset="utf-8"></script>    
	<script type="text/javascript" src="/resources/js/json2.js" charset="utf-8"></script> 
	
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	
	<script type="text/javascript">		
		google.charts.load('current', {'packages':['corechart']});
		//
		
		$(document).ready(function(){
			//drawChartStart();
			if(${object.result} != 0) {
				var notDataView = "<p class=\"subtitle\"> - 해당 기간에는 차상위평가까지 완료된 평가이력이 없습니다 -</p>";				
				$("#chart_view").html( notDataView );		
			}
			else {
				google.charts.setOnLoadCallback(drawChartStart);
			}
		});
		
		function drawChart(flag) {						
			
			var dataEval = google.visualization.arrayToDataTable([
	       			['Month',      			
						<c:forEach items="${object.gradedata}" var="item">		
							'${item.name}',
						</c:forEach>	
	       			],   		
	       			<c:forEach items="${eval}" var="month" varStatus="index">	
	       			['${index.index+1}월',
	       				<c:forEach items="${month}" var="value">		
							${value},
						</c:forEach>	       			 
	       			],
					</c:forEach>		       			
	       		]);
       		
       		var dataUpEval = google.visualization.arrayToDataTable([
   	       			['Month',      			
   						<c:forEach items="${object.gradedata}" var="item">		
   							'${item.name}',
   						</c:forEach>	
   	       			],   		
   	       			<c:forEach items="${upeval}" var="upmonth" varStatus="upindex">	
   	       			['${upindex.index+1}월',
   	       				<c:forEach items="${upmonth}" var="upvalue">		
   							${upvalue},
   						</c:forEach>	       			 
   	       			],
   					</c:forEach>
	       		]);
       		
       		var stitle = "";
       		
       		if(flag == 0) {
       			stitle = "[본인평가] - ";
       		}
       		else {
       			stitle = "[차상위평가] - ";       			
       		}
       		stitle += " 검색 기간 : " + '${period_year}';
       		
       		var options_fullStacked = {
           			title : stitle,
           			titleTextStyle : {fontSize: 30},
           			isStacked: 'percent',
           			chartArea : {width : '100%', height : '75%'},
           			legend: {position: 'top', maxLines: 1, textStyle: {fontSize: 15}},
           			connectSteps: false,
           			areaOpacity: 1,
           			tooltip : {textStyle: {fontSize: 22}},
           			hAxis : {textStyle: {fontSize: 17}},
           		    colors: 
           		    	[
						<c:forEach items="${object.gradedata}" var="item">		
							'${item.name}',
						</c:forEach>	
						],
           			vAxis: {
           				minValue: 0,
           				ticks: [0, .5, 1]
           			}
           		};
       		//colors: ['#DC143C', '#FFFF00', '#228B22', '#C0C0C0', '#FFD700'],
       		// 'Blue', 'yellow', 'green', 'silver', 'gold'
       		
			if(flag == 0) {
				var chart = new google.visualization.SteppedAreaChart(document.getElementById('chart_view'));
				chart.draw(dataEval, options_fullStacked);
			}
			else {
				var chart = new google.visualization.SteppedAreaChart(document.getElementById('chart_view'));
				chart.draw(dataUpEval, options_fullStacked);			
			}			
       		
       		
       		/*
			function resizeChart() {
				if(flag == 0) {
					chart.draw(dataEval, options_fullStacked);
				}
				else {
					chart.draw(dataUpEval, options_fullStacked);
				}
			}			
			if (document.addEventListener) {
				window.addEventListener('resize', resizeChart);
			}
			else if (document.attachEvent) {
				window.attachEvent('onresize', resizeChart);
			}
			else {
				window.resize = resizeChart;
			}
			*/
		}			
		
		function drawChartStart() {		
			drawChart(0);
		}
		
		function selectChart(flag) {			
			if(${object.result} != 0) {
				
			}
			else {
				drawChart(flag);
			}			
		}
		
	</script>		
</head>

	
	
 <body>
	<!-- ========== header ========== -->
	<!-- ========== //header ========== -->

	<!-- ========== content ========== -->
	<section>	
	
		<% 
  			//String user_num = (String) request.getParameter("user_num");
			//String user_name = (String) request.getParameter("user_name"); 
		%>
		
		<div class="div_left">
			<input type="button" onclick="selectChart(0);" value="본인평가"><input type="button" onclick="selectChart(1);" value="차상위평가">
			<div id="chart_view" style="width: 100%; height: 95%;"></div>	
		</div>	
		
		
	
	</section>
	<!-- ========== //content ========== -->

	<!-- ========== footer ========== -->
	<!-- ========== //footer ========== -->
 </body>
</html>
