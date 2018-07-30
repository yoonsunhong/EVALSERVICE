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
	<title>업무평가 앱 - 평가이력(본인)</title>	
	<link type="text/css" rel="stylesheet" href="/resources/css/common.css">
	<!-- <link type="text/css" rel="stylesheet" href="/resources/css/retail/layer_popup.css"> -->	
	<script type="text/javascript">

		<!--sessionStorage 리셋 -->
		sessionStorage.clear();
		var isRun = false;		
		
		function startEvalData(jsonstring) {	
			var data = JSON.parse(jsonstring);			
			drawEvalData(data);	
		}
		
		function drawEvalData(data) {			
			if(data.result != "0") { 				
				<!--평가 결과화면 그리기 시작-->	
				var resultViewData = "<div class=\"div_left clear p_r\">";
				//resultViewData += "<input class=\"button2 btn_prev\" type=\"button\" onclick=\"getEvalData('0');\" value=\"이전\">";
				resultViewData += "<h3 class=\"subtitle line\">평가완료 확인</h3>";	
				resultViewData += "<span class=\"subinfo\"> - 평가이력이 없습니다 - </span>";	
				//resultViewData += "<input class=\"button2 btn_next\" type=\"button\" onclick=\"getEvalData('1');\" value=\"이후\">";		
				resultViewData += "<input type=\"hidden\" id=\"INDEX_PREV\" value=\"-1\">";	
			    resultViewData += "<input type=\"hidden\" id=\"INDEX_NEXT\" value=\"-1\">";
			    resultViewData += "</div>";		
			    
			    /*
			    resultViewData += "<table style=\"text-align: center;\">";
			    resultViewData += "<tbody>";
			    resultViewData += "<tr><td>평가이력이 없습니다</td></tr>";	
			    resultViewData += "</tbody>";		
			    resultViewData += "</table>";	
			    */
					
				$("#resultView").html( resultViewData );					
				<!--평가 결과화면  그리기 끝-->
			}
			else {
				<!--평가 결과화면 그리기 시작-->	
				var resultViewData = "<div class=\"div_left clear p_r\">";
				resultViewData += "<h3 class=\"subtitle line\">평가완료 확인</h3>";
				resultViewData += "<input class=\"button2 btn_prev\" type=\"button\" onclick=\"getEvalData('0');\" value=\"이전\">";
				resultViewData += "<p class=\"subinfo eval_date\">" + data.period_from + " ~ " + data.period_to + "   </p>";	
				resultViewData += "<input class=\"button2 btn_next\" type=\"button\" onclick=\"getEvalData('1');\" value=\"이후\">";		
				resultViewData += "<input type=\"hidden\" id=\"INDEX_PREV\" value=" + data.eval_index_prev + ">";	
				resultViewData += "<input type=\"hidden\" id=\"INDEX_NEXT\" value=" + data.eval_index_next + ">";
				resultViewData += "</div>";		
			    
				
				if(data.upeval_with == 0) {
					resultViewData += "<table class=\"tbl_stl tbl_stl2\">";
				}
				else {
					resultViewData += "<table class=\"tbl_stl tbl_stl4\">";
				}
				
				
				resultViewData += "<tbody>";					
				
				resultViewData += "<td class=\"intitle\">항목</td>";		
		    	resultViewData += "<td class=\"intitle\">본인평가</td>";		
		    	
 		    	if(data.upeval_with != 0) {
		    		 resultViewData += "<td class=\"intitle\">차상위평가</td>";		
				}	
			    
			    if(data.eval_results_count > 0) {				    
				    $.each(data.eval_results_array, function(index) {				    	
				    	resultViewData += "<tr>";
				    	resultViewData += "<td class=\"name\">" +  data.eval_results_array[index].eval_item_name + "</td>";
				    	//resultViewData += "<td bgcolor=\"" +  data.eval_results_array[index].grade_name +  "\"><input type=\"button\" onclick=\"openLayerContents('layer1', " + index + ");return false;\"";
				    	//resultViewData += " value=\"" + data.eval_results_array[index].grade_name + "\"></td>";
				    	
				    	
						resultViewData += "<td class=\"eval_state p_r\">";
				    	resultViewData += "<strong class=\"" +  data.eval_results_array[index].grade_name +  "\">";
				    	resultViewData += data.eval_results_array[index].grade_name.substring(0,1) + "</strong>";								
				    	resultViewData += "<span class=\"" +  data.eval_results_array[index].grade_name +  "\">";		    	
				    	resultViewData += data.eval_results_array[index].grade_name + "</span>";
				    	
				    	if(data.upeval_with == 0) {
				    		resultViewData += "<input type=\"button\" onclick=\"openLayerContents('layer1', " + index + ");return false;\">";		
				    	}
				    	
				    	resultViewData += "</td>";
				    	
				    	
				    	if(data.upeval_with != 0) {
					    	//resultViewData += "<td class=\"value\" bgcolor=\"" +  data.upeval_results_array[index].grade_name +  "\">" + data.upeval_results_array[index].grade_name + "</td>";
					    						    	
							resultViewData += "<td class=\"eval_state p_r\">";
					    	resultViewData += "<strong class=\"" +  data.upeval_results_array[index].grade_name +  "\">";
					    	resultViewData += data.upeval_results_array[index].grade_name.substring(0,1) + "</strong>";								
					    	resultViewData += "<span class=\"" +  data.upeval_results_array[index].grade_name +  "\">";		    	
					    	resultViewData += data.upeval_results_array[index].grade_name + "</span>";
					    	resultViewData += "<input type=\"button\" onclick=\"openLayerContents('layer1', " + index + ");return false;\">";				    	
					    	resultViewData += "</td>";	
				    	}			    	
				    	
				    	resultViewData += "</tr>";
					});
				}
			    else {
			    	resultViewData += "<tr><td>데이터 없음</td></tr>";	
			    }
			    
			    resultViewData += "</tbody>";		
			    resultViewData += "</table>";		
			    
			    /*
			    if(data.upeval_with == 0) {
			    	resultViewData += "<p>평가 수정 가능</p>";
				}
			    else {
			    	resultViewData += "<p><input type=\"button\" onclick=\"checkUpEvalData();\" value=\"차상위평가 확인\"></p>";
			    }
			    */
					
			    $("#resultView").html( resultViewData );					
				<!--평가 결과화면  그리기 끝-->
				
				<!-- 평가 수정을 위해 sessionStorage에 평가 데이터 저장 -->
				sessionStorage.setItem('evalData', JSON.stringify(data));
			}
			
			<!-- 평가기간 영역 체크 시작 -->			
			if(${periodlen} > 0) {
				$("#periodview1").show();
				$("#periodview2").hide();
			}
			else {
				$("#periodview1").hide();
				$("#periodview2").show();
			}
			<!-- 평가기간 영역 체크 끝 -->
		}	
		
		function checkUpEvalData() {
			
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
			/*
			var topPos = ($(document).height() - $("#layer1").height()) / 2;
			var lftPos = ($(document).width() - $('#layer1').width()) / 2; 
			
			//temp.css({top:topPos, left:lftPos }); 
			temp.css("top", topPos);
			//temp.css("left", lftPos);			
			*/			
			
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
				
				modifyEvalResult(layer_index, layer_grade, layer_comment);
				
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
		
		function modifyEvalResult(index, gradename, comment) {		
			
			if(isRun == true) {
		        return;
		    }   
		    isRun = true;
			
			var jsonstring = sessionStorage.getItem('evalData');				
			var data = JSON.parse(jsonstring);		
			
			<!-- 수정데이터 입력 -->
			data.eval_results_array[index].grade_name = gradename;						
			<c:forEach items="${grade}" var="item">		    	
		    	if('${item.getGRADE_ITEM_NAME()}' == gradename) {
		    		data.eval_results_array[index].grade_num = '${item.getGRADE_ITEM_NUM()}';
		    	}
			</c:forEach>								
			data.eval_results_array[index].eval_comment = comment;
			
			<!-- 서버에 데이터 업데이트 과정 -->
			var resultdata = JSON.stringify(data.eval_results_array[index]);
			
			$.ajaxSetup({ cache: false });
			$.ajax({
				url : "/updateEvalResult.do",
				cache : false,
				type : "POST",
				datatype : "json",
				async : "false",
				data : { 'json_result' : resultdata, 'eval_type' : '0'},
				success : function(resultdata, textStatus) { 
					
					if(resultdata.result != "0") {
						
						if(resultdata.result == "2") {
							alert("차상위평가가 진행되어 평가 수정을 할 수 없습니다.");
							location.reload();
						}
						else {
							alert("데이터 수정 불가!");
						}						
					}
					else {
						alert("평가 수정 완료.");
						<!-- 데이터 업데이트 -->
						drawEvalData(data);						
					}
					
					isRun  = false;
				},
				error : function(x,e){
					console.log('로딩 실패 : ' + x);
					
					isRun  = false;
				}	 
			});
		}	
		
		function drawLayerContents(index) {
			
			var jsonstring = sessionStorage.getItem('evalData');				
			var data = JSON.parse(jsonstring);	

			<!-- 팝업레이어 컨탠츠 그리기 시작 -->
			var layerContent = "<h3 class=\"subtitle\">" + data.eval_results_array[index].eval_item_name + "</h3>";
			if(data.upeval_with != 0) {
				layerContent += "<p class=\"subtitle\">본인평가</p>";				
			}
			layerContent += "<div class=\"area line\">";
			layerContent += "<input type=\"hidden\" id=\"LAYER_INDEX\" value=\"" + index + "\">";
			layerContent += "<label for=\"\">Grade</label><br>";
					
			/* layerContent += "<span class=\"subinfo\">Grade</span>"; */ 
			
			if(data.upeval_with == 0) {
				layerContent += "<select  class=\"select1\" name= \"LAYER_GRADE\" id=\"LAYER_GRADE\">";		
				
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
			}
			else {
				/* layerContent += "<span class=\"subinfo\">" + data.eval_results_array[index].grade_name + "</span>"; */
				layerContent += "<input type=\"text\" value=\"" + data.eval_results_array[index].grade_name + "\" readonly>";
			}
			//layerContent += "</p>";
			layerContent += "</div>";
			
			layerContent += "<div class=\"area\">";
			layerContent += "<label for=\"\">Comment</label><br>";
			if(data.upeval_with == 0) {
				/*layerContent += "<input type=\"text\" id=\"LAYER_COMMENT\" value=\"" + data.eval_results_array[index].eval_comment + "\" onkeyup=\"fnChkByte(this);\">";*/
				layerContent += "<textarea class=\"\" name=\"LAYER_COMMENT\" id=\"LAYER_COMMENT\"  onkeyup=\"fnChkByte(this);\">" + data.eval_results_array[index].eval_comment + "</textarea>";
			}
			else {
				layerContent += "<textarea class=\"\" readonly>" + data.eval_results_array[index].eval_comment + "</textarea>";
			}
			//layerContent += "</p>";	
			layerContent += "</div>";
			
			if(data.upeval_with != 0) {
				layerContent += "<p class=\"subtitle\">차상위평가</p>";
				layerContent += "<div class=\"area\">";
				layerContent += "<label for=\"\">평가자</label><br>";
				layerContent += "<input type=\"text\" value=\"" + data.upuser_name + "\" readonly>";		
				layerContent += "</div>";
				layerContent += "<div class=\"area\">";	
				layerContent += "<label for=\"\">Grade</label><br>";
				layerContent += "<input type=\"text\" value=\"" + data.upeval_results_array[index].grade_name + "\" readonly>";				
				layerContent += "</div>";
				layerContent += "<div class=\"area\">";
				layerContent += "<label for=\"\">Comment</label><br>";
				layerContent += "<textarea class=\"\" readonly>" + data.upeval_results_array[index].eval_comment + "</textarea>";
				layerContent += "</div>";				
/* 				layerContent += "<span class=\"subinfo\">평가자 : " + data.upuser_name + "</span>";
				layerContent += "<br><span class=\"subinfo\">Grade : " + data.upeval_results_array[index].grade_name + "</span>";
				layerContent += "<br><span class=\"subinfo\">Comment : " + data.upeval_results_array[index].eval_comment + "</span>"; */							
			}

			if(data.upeval_with == 0) {
				$("#modify").show();
			}
			else {
				$("#modify").hide();
			}
			
			$("#layerContent").html( layerContent );		
			<!-- 팝업레이어 컨탠츠 그리기 끝 -->					
		}		
		

		
		function getEvalData(flag){	
						
			var eval_index = "0";
			var user_num = <%=getEnv().getUser_num()%>;
			
			if(flag == '0') {
				if($("#INDEX_PREV").val()  == "0") {
					alert("마지막 평가이력 입니다.");
					return;
				}
				else if($("#INDEX_PREV").val()  == "-1") {
					return;
				}
				eval_index = $("#INDEX_PREV").val();
			}
			else if(flag == '1') {
				if($("#INDEX_NEXT").val()  == "0") {
					alert("최신 평가이력 입니다.");
					return;
				}	
				else if($("#INDEX_NEXT").val()  == "-1") {
					return;
				}
				eval_index = $("#INDEX_NEXT").val();
			}
			
			if(eval_index == "0") {
				alert("데이터 에러.");
				return;
			}	
			
			if(isRun == true) {
		        return;
		    } 			
		    isRun = true;		    
			
			$.ajaxSetup({ cache: false });
			$.ajax({
				url : "/getEvalData.do",
				cache : false,
				type : "POST",
				datatype : "json",
				async : "false",
				data : { 'user_num' : user_num , 'eval_index' : eval_index, 'eval_flag' : '0'}, // eval_flag 0 : 본인평가완료한 평가이력정보 로딩.
				success : function(data, textStatus) { 
					isRun  = false;		
					drawEvalData(data);
				},
				error : function(x,e){
					isRun  = false;		
					console.log('로딩 실패 : ' + x);
				}	 
			});
		}
		
		function periodTest() {			
			if($("#PERIOD_FROM").val()  == "") {
				alert("미평가 기간이 없습니다.");
				return;
			}
			else {	
				var form = document.getElementById("form2");
				form.submit();
			}
		}
		
		function testScript() {			
			<c:forEach items="${grade}" var="item">
				alert('${item.getGRADE_ITEM_NUM()}' + " : " + '${item.getGRADE_ITEM_NAME()}');
			</c:forEach>
		}
		
		function goMain() {
			window.location = "/goMain.do";
		}
		
		$(document).ready(function (){
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
			<h2 class="title">본인평가</h2>		
		</div>
		<div class="sub_bg"></div>
		<div class="user_cnt area">
			<span><%=getEnv().getUser_name()%></span><span> 님</span><span>(<%=getEnv().getDepart_name()%>, 사원번호: <%=getEnv().getUser_num()%>)</span>
		</div>
	</header>	
	<%-- 	
	<header>
		<div class="div_left">
			<span class="title">본인평가</span> <input type="button" onclick="goMain();" value="메인화면">
		</div>	
		<div class="div_left">
			<span class="info">부서 : <%=getEnv().getDepart_name()%></span><br><span class="info">사원번호 : <%=getEnv().getUser_num()%>, 사원명 : <%=getEnv().getUser_name()%> </span>		
		</div>		
	</header>
	 --%>		
	<!-- ========== //header ========== -->
	
	<!-- ========== gnb ========== -->
	<%@include file="/WEB-INF/jsp/retail/main/menu.jsp" %>
	<!-- ========== //gnb ========== -->	
		
	<!-- ========== content ========== -->		
	<section class="area">		
		<form name="form2" id="form2" action="/goEvalProcess.do" method="post"> 
			<input type="hidden" name="PERIOD_FROM" id="PERIOD_FROM" value="${period[0]}">
			<h3 class="line">평가기간 선택</h3>
			
			<div id="periodview1" name="periodview1">
				<div class="clear">
					<span class="f_l">
						${period[0]} -
						<span class="p_r">
							<label for="PERIOD_TO" class="select_bul"></label>
							<select class="select1" name= "PERIOD_TO" id="PERIOD_TO">
								<c:forEach items="${period}" var="list">
									<option value="${list}">${list}</option>
								</c:forEach>
							</select>						
						</span>
					</span>
					<input class="f_r btn_stl2" type="button" onclick="periodTest();" value="평가진행">
				</div>
			</div>
			<div id="periodview2"  name="periodview2">
				<span class="subinfo">모든 기간의 평가를 진행하였습니다.</span>
			</div>				
		</form>
		<div class="result_view">
			<div id="resultView"></div>
		</div>	
			
<%-- 		<div class="div_left">
			<form name="form2" id="form2" action="/goEvalProcess.do" method="post"> 
				<input type="hidden" name="PERIOD_FROM" id="PERIOD_FROM" value="${period[0]}">
				<p class="subtitle">[평가기간 선택]</p>
				<div id="periodview1" name="periodview1">
					<span class="subinfo">  ${period[0]} ~
						<select class="select1" name= "PERIOD_TO" id="PERIOD_TO">
							<c:forEach items="${period}" var="list">
								<option value="${list}">${list}</option>
							</c:forEach>
						</select>
						<!-- button type="submit">평가진행1</button -->
						<input class="button1" type="button" onclick="periodTest();" value="평가진행">
					</span> 				
				</div>
				<div id="periodview2"  name="periodview2">
					<span class="subinfo">모든 기간의 평가가 완료되었습니다.</span>
				</div>
			</form>
		</div>
	
		<div class="div_left">						
			<div id="resultView"></div>		
		</div>	
		 --%>
		<!-- 팝업레이어 영역 시작 -->
 		<article style="text-align:left">		
			<div id="layer1" class="pop-layer">
				<div class="pop-container">
					<div class="pop-conts">
						<!-- content -->
						<div id="layerContent"></div>	
						<!-- // content -->									
						<a href="#" class="close_btn"></a>
						<div class="btn_area"> 
							<a href="#" class="btn_stl2 modify" id="modify" name="modify">수정</a>
						</d
					</div>
				</div>
			</div>		
		</article>
		<!-- 팝업레이어 영역 종료 -->	
	</section>			
	<!-- ========== //content ========== -->
	
	<script type="text/javascript">
		startEvalData('${json_result}');
	</script>	

	<!-- ========== footer ========== -->	
	<!-- ========== //footer ========== -->
</body>

</html>