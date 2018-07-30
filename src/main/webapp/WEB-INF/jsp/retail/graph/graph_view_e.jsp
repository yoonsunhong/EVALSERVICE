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
	<link type="text/css" rel="stylesheet" href="/resources/css/common.css">
	
	
	<script type="text/javascript" src="/resources/js/jquery-1.7.1.min.js" charset="utf-8"></script>
	<script type="text/javascript" src="/resources/js/jquery.cookie.js" charset="utf-8"></script>    
	<script type="text/javascript" src="/resources/js/json2.js" charset="utf-8"></script> 
	
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	
	<script type="text/javascript">		
		google.charts.load('current', {'packages':['corechart']});
		
		$(document).ready(function(){
			if(${object.result} != 0) {
				drawMessage(-1);
			}
			else {
				google.charts.setOnLoadCallback(drawChartStart);
			}
		});
		
		function drawChart(flag) {	
			var dataEval = google.visualization.arrayToDataTable(
			[
				[
					{ label:'Month', role: 'domain' },
					<c:forEach items="${object.ratedata}" var="item">		
						{ label:'${item.name}', role: 'data' }, 
						{ role: 'style' }, 
						{ role: 'tooltip'}, 
					</c:forEach>	
				],  				
				<c:forEach items="${eval}" var="month" varStatus="index">				
					<c:choose>
						<c:when test="${index.last}">
						[
						 	'Total',
							<c:forEach items="${month}" var="value">		
								${value.rate},	
								'fill-color: ' + exportColorCode('${value.grade}') + '; stroke-color: #000000; stroke-width: 0.5',	
								'[평균]\n${value.name}\n평가비중 : ${value.rate}\n평가등급 : ${value.grade}',
							</c:forEach>	       			 
						],		        
				    	</c:when>	
				    	<c:otherwise>
				    	[
						 	'${index.index+1}월',
							<c:forEach items="${month}" var="value">		
								${value.rate},	
								'fill-color: ' + exportColorCode('${value.grade}') + '; stroke-color: #000000; stroke-width: 0.5',	
								'[${index.index+1}월]\n${value.name}\n평가비중 : ${value.rate}\n평가등급 : ${value.grade}',
							</c:forEach>	       			 
						],
				    	</c:otherwise>
					</c:choose>
				</c:forEach>						
			]);
       		
       		var dataUpEval = google.visualization.arrayToDataTable(
     		[
   				[
   					{ label:'Month', role: 'domain' },
   					<c:forEach items="${object.ratedata}" var="item">		
   						{ label:'${item.name}', role: 'data' },
   						{ role: 'style' },
   						{ role: 'tooltip' }, 
   					</c:forEach>	
   				],    				
   				<c:forEach items="${upeval}" var="month" varStatus="index">				
					<c:choose>
						<c:when test="${index.last}">
						[
						 	'Total',
							<c:forEach items="${month}" var="value">		
								${value.rate},	
								'fill-color: ' + exportColorCode('${value.grade}') + '; stroke-color: #000000; stroke-width: 0.5',	
								'[평균]\n${value.name}\n평가비중 : ${value.rate}\n평가등급 : ${value.grade}',
							</c:forEach>	       			 
						],		        
				    	</c:when>	
				    	<c:otherwise>
				    	[
						 	'${index.index+1}월',
							<c:forEach items="${month}" var="value">		
								${value.rate},	
								'fill-color: ' + exportColorCode('${value.grade}') + '; stroke-color: #000000; stroke-width: 0.5',	
								'[${index.index+1}월]\n${value.name}\n평가비중 : ${value.rate}\n평가등급 : ${value.grade}',
							</c:forEach>	       			 
						],
				    	</c:otherwise>
					</c:choose>
				</c:forEach>			
   			]);
       		
       		
       		var dataEverage = google.visualization.arrayToDataTable(
       		[
				[	
				 	'eval', 
				 	'grade', 
				 	{ role: 'style' }, 
				 	{ role: 'annotation' },
				 	{ role: 'tooltip' } ,
				 ],
				
				<c:forEach items="${ever.everdata}" var="edata" varStatus="index">				
					<c:choose>
						<c:when test="${index.first}">
						[
							'종합등급', // '${edata.name}',
							${edata.value},
							exportColorCode('${edata.grade}'),
							'${edata.grade}',
							'[${period_year}년]\n종합등급 : ${edata.grade}',
		   				],			        
				    	</c:when>
	
				    	<c:otherwise>
				    	[
							'${edata.name}',
							${edata.value},
							exportColorCode('${edata.grade}'),
							'${edata.grade}',
							'평가비중 : ${edata.rate}\n등급 : ${edata.grade}',
		   				],
				    	</c:otherwise>
					</c:choose>
   				</c:forEach>    				
			]);
       		       		
       		var options_fullStacked = {
          		title: {position: 'none'},
   	   			legend: {position: 'none'},
          		chartArea : {left:'10%', width:'85%', top:'5%', bottom:'10%', height : '85%'},
   				bar: { groupWidth: '90%', },
   				isStacked: true,
       			areaOpacity: 1,
       			tooltip : {textStyle: {fontSize: 17}},
       			hAxis : {textStyle: {fontSize: 10}},
   	   			vAxis: {
   	   				minValue: 0,
   	   				maxValue: 100,
   	   				ticks: [
						<c:set var="totalnum" value='0'/>
   						<c:forEach items="${object.ratedata}" var="item">
							<c:set var="totalnum" value='${totalnum + item.rate}'/>
   							{ v: ${totalnum},	f: '${item.abname}' },
						</c:forEach>
					],
   	   			}
          		};
       		
       		var optionsEverage = {
           		title: {position: 'none'},
 	   			legend: {position: 'none'},
 				bar: { groupWidth: '80%', },
       			chartArea : {left:'40%', top:'5%', bottom:'10%', width : '60%', height : '85%', right:'0%'},
       			areaOpacity: 1,
       			tooltip : {textStyle: {fontSize: 17}},
       			hAxis : {
       				textStyle: {fontSize: 10},
       				minValue: 0,
       				maxValue: 6.0,
       				ticks: [
						<c:forEach items="${ever.color}" var="color" varStatus="index">
							{
								v: ${color.value},
								f: '${color.name}', 
							},
						</c:forEach>     
					],
       			},
       			vAxis : {
       				textStyle: {fontSize: 15},
       			},
       		};
       		
			if(flag == 0) {
				var chart = new google.visualization.SteppedAreaChart(document.getElementById('chart_view'));
				chart.draw(dataEval, options_fullStacked);
				drawMessage(0);
			}
			else if(flag == 1){
				var chart = new google.visualization.SteppedAreaChart(document.getElementById('chart_view'));
				chart.draw(dataUpEval, options_fullStacked);	
				drawMessage(1);			
			}
			else{
				var chart = new google.visualization.BarChart(document.getElementById('chart_view'));
				chart.draw(dataEverage, optionsEverage);	
				drawMessage(2);
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
		
		function drawMessage(_flag) {			
			var messageView = "";			
			if(_flag == -1) {
				messageView += "<p class=\"area subtitle\">검색기간(${period_year}년)내에<br>차상위평가까지 완료된 평가이력이 없습니다.</p>";
			}
			else {
				messageView += "<p class=\"graph_title subtitle\">";	       		
	       		if(_flag == 0) {
	       			messageView += "[본인평가] - ";
	       		}
	       		else if(_flag == 1){
	       			messageView += "[차상위평가] - ";       			
	       		}
	       		else{
	       			messageView += "[종합평가] - ";       			
	       		}
	       		messageView += " 검색 기간 : " + '${period_year}' + "년</p>";				
			}				
			$("#message_view").html( messageView );
			//$("#chart_view").html( messageView );
		}
		
		// 해당 그래프 버튼 on
		$(document).ready(function(){
			$(".graph_btn").on("click",function(){
				$(this).addClass("on").siblings().removeClass("on");
			})
		});
		
	</script>		
</head>

	
	
 <body>
	<!-- ========== header ========== -->
	<!-- ========== //header ========== -->

	<!-- ========== content ========== -->
	<section>			
		<div>
			<div class="clear">
				<input class="graph_btn on" type="button" onclick="selectChart(0);" value="본인평가">
				<input class="graph_btn" type="button" onclick="selectChart(1);" value="차상위평가">	
				<!--  <input class="graph_btn" type="button" onclick="selectChart(2);" value="종합평가">	-->	
				<!-- 버튼 추가시 common.css에서 width 수정 필요 -->
			</div>
			<div id="message_view"></div>
			<div id="chart_view" style="width: 100%; height: 85%;"></div>	
		</div>	
	</section>
	<!-- ========== //content ========== -->

	<!-- ========== footer ========== -->
	<!-- ========== //footer ========== -->
 </body>
</html>