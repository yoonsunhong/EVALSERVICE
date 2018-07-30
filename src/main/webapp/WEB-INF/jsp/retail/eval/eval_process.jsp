<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="retail.common.BaseEnv"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="/WEB-INF/jsp/retail/inc_common/inc_common.jsp" %>
<%@page import ="java.util.List" %>
<%@page import ="java.util.ArrayList" %>
<%@page import ="retail.eval.service.EvalVO" %>
<%@page import ="retail.eval.service.EvalResultVO" %>

<jsp:include page="/WEB-INF/jsp/retail/inc_common/inc_head.jsp" /> 
 
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi" />
	<title>업무평가 앱 - 평가진행(본인)</title>
	<link type="text/css" rel="stylesheet" href="/resources/css/common.css">

	<script type="text/javascript">		

		<!--sessionStorage 리셋 -->
		sessionStorage.clear();
		var isRun = false;		
		
		function startEvalProcess(jsonstring) {			
			//sessionStorage.setItem('evalData', jsonstring);		
			var data = JSON.parse(jsonstring);			
			drawEvalProcess(data);	
		}
		
		function drawEvalProcess(data) {					
			if(data.result != "0" ) { 		
				<!--평가 진행화면 그리기 시작-->	
				var resultViewData = "<div>";
				resultViewData += "<span class=\"subinfo\"> 평가비율 데이터 없음. 관리자에게 문의하세요. </span>";	
			    resultViewData += "</div>";		
					
				$("#resultView").html( resultViewData );					
				<!--평가 진행화면  그리기 끝-->
			}
			else {	
				<!--평가 진행화면 그리기 시작-->
				var resultViewData = "<table class=\"tbl_stl tbl_stl2\">";
				resultViewData += "<tbody>";			
				
				resultViewData += "<td class=\"intitle\">항목</td>";		
		    	resultViewData += "<td class=\"intitle\">본인평가</td>";	
		    	
			    if(data.eval_results_count > 0) {				    
				    $.each(data.eval_results_array, function(index) {	
				    	resultViewData += "<tr>";
				    	resultViewData += "<td class=\"name\">" +  data.eval_results_array[index].eval_item_name + "</td>";
				    	/* resultViewData += "<td bgcolor=\"" +  data.eval_results_array[index].grade_name +  "\"><input type=\"button\" onclick=\"openLayerContents('layer1', " + index + ");return false;\"";
				    	resultViewData += " value=\"" + data.eval_results_array[index].grade_name + "\"></td>"; */
				    	
						resultViewData += "<td class=\"eval_state p_r\">";
				    	resultViewData += "<strong class=\"" +  data.eval_results_array[index].grade_name +  "\">";
				    	resultViewData += data.eval_results_array[index].grade_name.substring(0,1) + "</strong>";								
				    	resultViewData += "<span class=\"" +  data.eval_results_array[index].grade_name +  "\">";		    	
				    	resultViewData += data.eval_results_array[index].grade_name + "</span>";
				    	resultViewData += "<input type=\"button\" onclick=\"openLayerContents('layer1', " + index + ");return false;\"";
				    	resultViewData += "</td>";
				    	
				    	resultViewData += "<input type=\"hidden\" id=\"GRADE_ITEM_NAME" + index + "\" value=\"" + data.eval_results_array[index].grade_name + "\">";
				    	resultViewData += "</tr>";
					});
				}
			    
			    resultViewData += "</tbody>";		
			    resultViewData += "</table>";		
					
				$("#resultView").html( resultViewData );					
				<!--평가 진행화면  그리기 끝-->
				
				<!-- sessionStorage에 데이터 저장 -->
				sessionStorage.setItem('evalProcess', JSON.stringify(data));
			}
		}
		
		function openLayerContents(el, index){
			
			$('body').after("<div class='pop_overlay'></div>");
			drawLayerContents(index);
	
			var temp = $('#' + el);		//레이어의 id를 temp변수에 저장
			//var bg = temp.prev().hasClass('bg');	//dimmed 레이어를 감지하기 위한 boolean 변수
	
			//if(bg){
			//	$('.layer').fadeIn();
			//}else{
				temp.fadeIn();	//bg 클래스가 없으면 일반레이어로 실행한다.
			//}
	
			// 화면의 중앙에 레이어를 띄운다.
			if (temp.outerHeight() < $(document).height() ) temp.css('margin-top', '-'+temp.outerHeight()/2+'px');
			else temp.css('top', '0px');
			if (temp.outerWidth() < $(document).width() ) temp.css('margin-left', '-'+temp.outerWidth()/2+'px');
			else temp.css('left', '0px');
	
			/*temp.find('a.cbtn').click(function(e){
				if(bg){
					$('.layer').fadeOut();
				}else{
					temp.fadeOut();		//'닫기'버튼을 클릭하면 레이어가 사라진다.
				}
				e.preventDefault();
			});*/
			
			temp.find('a.btn_stl2').click(function(e){
				
				var layer_index = $("#LAYER_INDEX").val();
				var layer_grade = $("#LAYER_GRADE").val();
				var layer_comment = $("#LAYER_COMMENT").val();
				
				modifyEvalProcess(layer_index, layer_grade, layer_comment);
				
				//if(bg){
				//	$('.layer').fadeOut();
				//}else{
					temp.fadeOut();		//'닫기'버튼을 클릭하면 레이어가 사라진다.
				//}
				e.preventDefault();
			});
	
			/*$('.layer .bg').click(function(e){				
				if(bg){
					$('.layer').fadeOut();
				}else{
					temp.fadeOut();		//'닫기'버튼을 클릭하면 레이어가 사라진다.
				}				
				e.preventDefault();
			});*/			
		}			
		
		function modifyEvalProcess(index, gradename, comment) {		
			
			
			var jsonstring = sessionStorage.getItem('evalProcess');				
			var data = JSON.parse(jsonstring);			
			
			data.eval_results_array[index].grade_num = "0";
			data.eval_results_array[index].grade_name = gradename;
			
			<c:forEach items="${grade}" var="item">		    	
		    	if('${item.getGRADE_ITEM_NAME()}' == gradename) {
		    		data.eval_results_array[index].grade_num = '${item.getGRADE_ITEM_NUM()}';
		    	}
			</c:forEach>	
			
			data.eval_results_array[index].eval_comment = comment;
			
			drawEvalProcess(data);
			
		}		
		
		function drawLayerContents(index) {
			
			var jsonstring = sessionStorage.getItem('evalProcess');				
			var data = JSON.parse(jsonstring);	
			
			<!-- 팝업레이어 컨탠츠 그리기 시작 -->
			var layerContent = "<h3 class=\"subtitle\">" + data.eval_results_array[index].eval_item_name + "</h3>";
			
			layerContent += "<div class=\"area line\">";
			layerContent += "<input type=\"hidden\" id=\"LAYER_INDEX\" value=\"" + index + "\">";
			layerContent += "<label for=\"\">Grade</label><br>";
			layerContent += "<select class=\"select1\" name= \"LAYER_GRADE\" id=\"LAYER_GRADE\">";
			//layerContent += "<option value=\"None\">None</option>";
			
			<c:forEach items="${grade}" var="item">
				layerContent += "<option value=\"" + '${item.getGRADE_ITEM_NAME()}' + "\""; 			    	
		    	if('${item.getGRADE_ITEM_NAME()}' == data.eval_results_array[index].grade_name) {
		    		layerContent += " selected=\"selected\">"; 
		    	}
		    	else {
		    		layerContent += ">";
		    	}		    
		    	layerContent += '${item.getGRADE_ITEM_NAME()}' + "</option>";
			</c:forEach>
			
			layerContent += "</select>";			
			//layerContent += "</p>";
			layerContent += "</div>";
			
			layerContent += "<div class=\"area\">";
			layerContent += "<label for=\"\">Comment</label><br>";
			layerContent += "<textarea class=\"\" name=\"LAYER_COMMENT\" id=\"LAYER_COMMENT\"  onkeyup=\"fnChkByte(this);\">" + data.eval_results_array[index].eval_comment + "</textarea>";
			
			//layerContent += "</p>";
			layerContent += "</div>";
			
			$("#layerContent").html( layerContent );
			<!-- 팝업레이어 컨탠츠 그리기 끝 -->			
		}
		
		function setEvalData() {			    
			
			var jsonstring = sessionStorage.getItem('evalProcess');			
			var data = JSON.parse(jsonstring);	
			
			for(var i = 0 ; i < data.eval_results_count ; i++){
				if($("#GRADE_ITEM_NAME" + i).val() == "None") {
					alert("index " + (i+1) + "번 항목 등급 미입력 (None) 입니다.");
					return;
				}
			}		
			
			if(isRun == true) {
		        return;
		    } 			
		    isRun = true;
			
			<!--ajax post-->
			$.ajax({
				url:"/setEvalData.do" ,
				type:"POST",
				datatype:"json",
				data:{ 'period_from': ${period_from},  'period_to':${period_to}, 'json_result': jsonstring },
				beforeSend : function(xhr) {} ,
				success:function(data,textStatus){  
					if(data.result != "0" ) { 
						
						isRun  = false;						
					} else {
						alert("평가가 제출되었습니다.");
						
						isRun  = false;
						location.replace("/goEval.do"); 
					} 
				},
				error:function(x,e){
					
					isRun  = false;
				}	 
			}); 
		}
		
		function cancel() {
			window.location = "/goEval.do";
		}	
		
		$(document).ready(function (){
			// 닫기 버튼 클릭시 레이어와 투명 레이어 사라짐
			$(".close_btn, .modify").on("click",function  () {
				$("#layer1, .pop_overlay").hide();
				
			});			
	
			// 팝업 실행시 투명 레이어 생성
			/*$('.eval_state input[type="button"]').on("click",function  () {
				$('body').after("<div class='pop_overlay'></div>");
			});*/
		});
	</script>
</head>

<body>
	<!-- ========== header ========== -->
	<header>
		<div class="tit_cnt">
			<span class="menu"><img src="/resources/img/icon/ico_menu.png" alt="메뉴 아이콘"></span>
			<h2 class="title">본인평가 진행</h2>		
		</div>
		<div class="sub_bg"></div>
		<div class="user_cnt area">
			<span><%=getEnv().getUser_name()%></span><span> 님</span><span>(<%=getEnv().getDepart_name()%>, 사원번호: <%=getEnv().getUser_num()%>)</span>
		</div>
	</header>			
	
	
<%-- 	<header>
		<div class="div_left">
			<span class="title">본인평가 진행</span>
		</div>	
		<div class="div_left">
			<span class="info">부서 : <%=getEnv().getDepart_name()%></span><br><span class="info">사원번호 : <%=getEnv().getUser_num()%>, 사원명 : <%=getEnv().getUser_name()%> </span>	
		</div>		
	</header>		 --%>
	<!-- ========== //header ========== -->

	<!-- ========== gnb ========== -->
	<%@include file="/WEB-INF/jsp/retail/main/menu.jsp" %>
	<!-- ========== //gnb ========== -->	

	<!-- ========== content ========== -->	
	<section class="area">		
		<h3 class="line">선택 평가기간</h3>
		<span class="subinfo">${period_from} ~ ${period_to}</span>	
		<div class="result_view">
			<div id="resultView"></div>
		</div>
		<div class="btn_area">
			<input class="btn_stl2" type="button" onClick="setEvalData();" value="평가 제출">
			<input class="btn_stl2" type="button" onClick="cancel();" value="취소">			
		</div>
		<!-- 팝업레이어 영역 시작 -->
		<article style="text-align:left">
			<div id="layer1" class="pop-layer">
				<div class="pop-container">
					<div class="pop-conts">
						<div id="layerContent"></div>										
					</div>
					<a href="#" class="close_btn"></a>
					<div class="btn_area"> 
						<a href="#" class="btn_stl2 modify" id="modify" name="modify">수정</a>
					</d
				</div>
			</div>
		</article>	
		<!-- 팝업레이어 영역 종료 -->		
<%-- 		<div class="div_left">
			<p class="subtitle">[선택 평가기간]</p>
			<span class="subinfo">${period_from} ~ ${period_to}</span>		
		</div>
		
		<div class="div_left">		
			<div id="resultView"></div>
		</div>
			
		<div class="div_center">	
			<input class="button3" type="button" onClick="setEvalData();" value="평가 제출"> <input class="button3" type="button" onClick="cancel();" value="취소">	
		</div>
		
		<!-- 팝업레이어 영역 시작 -->
		<article style="text-align:left">
			<div id="layer1" class="pop-layer">
				<div class="pop-container">
					<div class="pop-conts">
						<div id="layerContent"></div>										
						<div class="btn-r">
							<a href="#" class="cbtn">Close</a>
							<a href="#" class="obtn">Modify</a>
						</div>
						<!--// content-->
					</div>
				</div>
			</div>
		</article>	
		<!-- 팝업레이어 영역 종료 -->		 --%>
	</section>
	<!-- ========== //content ========== -->
	
	<script type="text/javascript">
		startEvalProcess('${json_result}');
	</script>

	<!-- ========== footer ========== -->	
	<!-- ========== //footer ========== -->
</body>

</html>