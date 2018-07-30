<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="retail.common.BaseEnv"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>
<%@include file="/WEB-INF/jsp/retail/inc_common/inc_common.jsp" %>
<%@page import ="java.util.List" %>
<%@page import ="java.util.ArrayList" %>
<%@page import ="retail.eval.service.EvalVO" %>
<%@page import ="retail.main.service.UserVO" %>
<%@page import ="retail.eval.service.EvalResultVO" %>

<jsp:include page="/WEB-INF/jsp/retail/inc_common/inc_head.jsp" /> 
 
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi" />
	<title>업무평가 앱 - 평가이력(하위사원)</title>	
	<link type="text/css" rel="stylesheet" href="/resources/css/common.css">
	
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
				resultViewData += "<h3 class=\"subtitle line\">평가완료 확인</h3>";
				resultViewData += "<span class=\"subinfo\">평가이력이 없습니다.</span>";	
				//resultViewData += "<input class=\"button2\" type=\"button\" onclick=\"getEvalData('1');\" value=\"이후\">";		
				//resultViewData += "<input class=\"button2\" type=\"button\" onclick=\"getEvalData('0');\" value=\"이전\">";
				resultViewData += "<input type=\"hidden\" id=\"INDEX_PREV\" value=\"-1\">";	
			    resultViewData += "<input type=\"hidden\" id=\"INDEX_NEXT\" value=\"-1\">";
			    resultViewData += "</div>";	
					
				$("#resultView").html( resultViewData );					
				<!--평가 결과화면  그리기 끝-->
			}
			else {
				<!--평가 결과화면 그리기 시작-->
				var resultViewData = "<div class=\"div_left clear p_r\">";
				resultViewData += "<h3 class=\"subtitle line\">평가완료 확인</h3>";
				resultViewData += "<input class=\"button2 btn_prev\" type=\"button\" onclick=\"getEvalData('0');\" value=\"이전\">";
				
				//resultViewData += "<p class=\"subinfo eval_date\">" + data.period_from + " ~ " + data.period_to + "   </p>";					
				resultViewData += "<p class=\"subinfo eval_date\">";
				resultViewData += data.period_from.substring(0,4) + "년 " + data.period_from.substring(4,6) + "월 - ";
				resultViewData += data.period_to.substring(0,4) + "년 " + data.period_to.substring(4,6) + "월</p>";	
				
				resultViewData += "<input class=\"button2 btn_next\" type=\"button\" onclick=\"getEvalData('1');\" value=\"이후\">";		
				resultViewData += "<input type=\"hidden\" id=\"INDEX_PREV\" value=" + data.eval_index_prev + ">";	
				resultViewData += "<input type=\"hidden\" id=\"INDEX_NEXT\" value=" + data.eval_index_next + ">";
				resultViewData += "</div>";						

				resultViewData += "<table class=\"tbl_stl tbl_stl4\">";
				resultViewData += "<tbody>";					

				resultViewData += "<td class=\"intitle\">항목</td>";
				resultViewData += "<td class=\"intitle\">본인평가</td>";		
		    	resultViewData += "<td class=\"intitle\">차상위평가</td>";					
				
			    
			    if(data.eval_results_count > 0) {				    
				    $.each(data.eval_results_array, function(index) {				    	
				    	resultViewData += "<tr>";
				    	resultViewData += "<td class=\"name\">" +  data.eval_results_array[index].eval_item_name + "</td>";
				    	
						resultViewData += "<td class=\"eval_state p_r\">";
				    	resultViewData += "<strong class=\"" +  data.eval_results_array[index].grade_name +  "\">";
				    	resultViewData += data.eval_results_array[index].grade_name.substring(0,1) + "</strong>";								
				    	resultViewData += "<span class=\"" +  data.eval_results_array[index].grade_name +  "\">";		    	
				    	resultViewData += data.eval_results_array[index].grade_name + "</span>";    	
				    	resultViewData += "</td>";
				    	
						resultViewData += "<td class=\"eval_state p_r\">";
				    	resultViewData += "<strong class=\"" +  data.upeval_results_array[index].grade_name +  "\">";
				    	resultViewData += data.upeval_results_array[index].grade_name.substring(0,1) + "</strong>";								
				    	resultViewData += "<span class=\"" +  data.upeval_results_array[index].grade_name +  "\" onclick=\"openLayerContents('layer1', " + index + ");return false;\">";		    	
				    	resultViewData += data.upeval_results_array[index].grade_name + "</span>";
				    	resultViewData += "<input type=\"button\" onclick=\"openLayerContents('layer1', " + index + ");return false;\">";					    	
				    	resultViewData += "</td>";				    	
				    	
				    	//resultViewData += "<td class=\"value\" bgcolor=\"" +  data.eval_results_array[index].grade_name +  "\">" +  data.eval_results_array[index].grade_name + "</td>";
					    //resultViewData += "<td bgcolor=\"" +  data.upeval_results_array[index].grade_name +  "\"><input type=\"button\" onclick=\"openLayerContents('layer1', " + index + ");return false;\"";
				    	//resultViewData += " value=\"" + data.upeval_results_array[index].grade_name + "\"></td>"; 
				    	resultViewData += "</tr>";
					});
				}
			    else {
			    	resultViewData += "<tr><td>데이터 없음</td></tr>";	
			    }
			    
			    resultViewData += "</tbody>";		
			    resultViewData += "</table>";	
					
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
				
		function modifyEvalResult(index, gradename, comment) {		
			
			if(isRun == true) {
		        return;
		    }   
		    isRun = true;
			
			var jsonstring = sessionStorage.getItem('evalData');				
			var data = JSON.parse(jsonstring);		
			
			<!-- 수정데이터 입력 -->
			data.upeval_results_array[index].grade_name = gradename;						
			<c:forEach items="${grade}" var="item">		    	
		    	if('${item.getGRADE_ITEM_NAME()}' == gradename) {
		    		data.upeval_results_array[index].grade_num = '${item.getGRADE_ITEM_NUM()}';
		    	}
			</c:forEach>								
			data.upeval_results_array[index].eval_comment = comment;
			
			<!-- 서버에 데이터 업데이트 과정 -->
			var resultdata = JSON.stringify(data.upeval_results_array[index]);
			
			$.ajaxSetup({ cache: false });
			$.ajax({
				url : "/updateEvalResult.do",
				cache : false,
				type : "POST",
				datatype : "json",
				async : "false",
				data : { 'json_result' : resultdata, 'eval_type' : '1'},
				success : function(resultdata, textStatus) { 
					
					if(resultdata.result != "0") {
						alert("수정 불가.");
					}
					else {
						alert("수정 완료.");
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
			var layerContent = "<h3 class=\"subtitle\">" + data.eval_results_array[index].eval_item_name + "</h3>"
			
			layerContent += "<p class=\"subtitle\">본인평가</p>";
			layerContent += "<div class=\"line\">";
			layerContent += "<div class=\"clear area\">";
			layerContent += "<p class=\"f_l\">Grade</p>";
			
			/* layerContent += "<input type=\"text\" value=\"" + data.eval_results_array[index].grade_name + "\" readonly>"; */
			layerContent += "<div class=\"eval_state eval1 p_r f_r\">";
			layerContent += "<strong class=\"" +  data.eval_results_array[index].grade_name +  "\">";
	    	layerContent += data.eval_results_array[index].grade_name.substring(0,1) + "</strong>";								
	    	layerContent += "<span class=\"" +  data.eval_results_array[index].grade_name +  "\">";		    	
	    	layerContent += data.eval_results_array[index].grade_name + "</span>";        	
	    	layerContent += "</div>";	
	    	
			layerContent += "</div>";			
			layerContent += "</div>";
			layerContent += "<div class=\"area\">";			
			layerContent += "<p class=\"\">Comment</p>";
			layerContent += "<textarea class=\"\" readonly>" + data.eval_results_array[index].eval_comment + "</textarea>"; 		
			layerContent += "</div>";
			
			layerContent += "<p class=\"subtitle\">차상위평가</p>";	
			layerContent += "<div class=\"line\">";
			layerContent += "<div class=\"clear area\">";	
			layerContent += "<input type=\"hidden\" name=\"LAYER_INDEX\" id=\"LAYER_INDEX\" value=\"" + index + "\">";
			layerContent += "<p class=\"f_l\">Grade</p>";

			// 등급 그리기
			if(data.eval_index_next == 0) {				
				layerContent += "<div class=\"eval_state eval2 p_r f_r\">";
				layerContent += "<div id=\"draw_grade\"></div>";
	    	}
			else {
				layerContent += "<div class=\"eval_state eval1 p_r f_r\">";
				layerContent += "<input type=\"hidden\" name=\"LAYER_GRADE\" id=\"LAYER_GRADE\" value=\"" + data.upeval_results_array[index].grade_name + "\">";
				layerContent += "<strong class=\"" +  data.upeval_results_array[index].grade_name +  "\">";
		    	layerContent += data.upeval_results_array[index].grade_name.substring(0,1) + "</strong>";								
		    	layerContent += "<span class=\"" +  data.upeval_results_array[index].grade_name +  "\">";		    	
		    	layerContent += data.upeval_results_array[index].grade_name + "</span>";
		    	/*layerContent += "<input type=\"button\" onclick=\"selectGrade();\">";*/
			}  	
	    	
	    	layerContent += "<ul class=\"grade_select\">";	    	
		    	<c:forEach items="${grade}" var="item" varStatus="status">	
			    	//layerContent += "<li class=\"eval_state p_r\" onclick=\"changeGrade(${status.index});\">";
			    	layerContent += "<li class=\"eval_state p_r\" onclick=\"changeGrade('" + '${item.getGRADE_ITEM_NAME()}' + "');\">";
					layerContent += "<strong class=\"${item.getGRADE_ITEM_NAME()}\">";
			    	layerContent += '${fn:substring(item.getGRADE_ITEM_NAME(),0,1)}' + "</strong>";		
			    	layerContent += "<span class=\"${item.getGRADE_ITEM_NAME()}\">";		    	
			    	layerContent += "${item.getGRADE_ITEM_NAME()}</span>"; 	
			    	layerContent += "</li>";
				</c:forEach>
	    	
			/*
	    	layerContent += "<li class=\"eval_state p_r\">";
			layerContent += "<strong class=\"" +  data.upeval_results_array[index].grade_name +  "\">";
	    	layerContent += data.upeval_results_array[index].grade_name.substring(0,1) + "</strong>";								
	    	layerContent += "<span class=\"" +  data.upeval_results_array[index].grade_name +  "\">";		    	
	    	layerContent += data.upeval_results_array[index].grade_name + "</span>"; 	
	    	layerContent += "</li>";
	    	
	    	layerContent += "<li class=\"eval_state p_r\">";
			layerContent += "<strong class=\"Silver\">S</strong>";								
	    	layerContent += "<span class=\"Silver\">Silver</span>"; 	
	    	layerContent += "</li>";
	    	
	    	layerContent += "<li class=\"eval_state p_r\">";
			layerContent += "<strong class=\"Green\">G</strong>";								
	    	layerContent += "<span class=\"Green\">Green</span>"; 	
	    	layerContent += "</li>";
	    	
	    	layerContent += "<li class=\"eval_state p_r\">";
			layerContent += "<strong class=\"Yellow\">Y</strong>";								
	    	layerContent += "<span class=\"Yellow\">Yellow</span>"; 	
	    	layerContent += "</li>";
	    	
	    	layerContent += "<li class=\"eval_state p_r\" >";
			layerContent += "<strong class=\"Red\">R</strong>";								
	    	layerContent += "<span class=\"Red\">Red</span>"; 	
	    	layerContent += "</li>";
	    	*/
	    	
	    	
	    	layerContent += "</ul>";		    	
/* 			if(data.eval_index_next == 0) {
				layerContent += "<select  class=\"select1\" name= \"LAYER_GRADE\" id=\"LAYER_GRADE\">";		
				
				<c:forEach items="${grade}" var="item">
					layerContent += "<option value=\"" + '${item.getGRADE_ITEM_NAME()}' + "\""; 			    	
			    	if('${item.getGRADE_ITEM_NAME()}' == data.upeval_results_array[index].grade_name) {
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
				layerContent += "<input type=\"text\" value=\"" + data.upeval_results_array[index].grade_name + "\" readonly>";	
			} */
			//layerContent += "</p>";
			
			layerContent += "</div>";			
			layerContent += "</div>";			
			layerContent += "</div>";
			
			layerContent += "<div class=\"area\">";
			layerContent += "<p class=\"\">Comment</p>";
			if(data.eval_index_next == 0) {
				layerContent += "<textarea class=\"\" name=\"LAYER_COMMENT\" id=\"LAYER_COMMENT\" onkeyup=\"fnChkByte(this);\" onKeyDown=\"javascript:if (event.keyCode == 13) event.preventDefault();\">"  + data.upeval_results_array[index].eval_comment + "</textarea>";	
			}
			else {
				layerContent += "<textarea class=\"\" readonly>" + data.upeval_results_array[index].eval_comment + "</textarea>";
			}
			layerContent += "</div>";
			
			$("#layerContent").html( layerContent );	

			if(data.eval_index_next == 0) {
				$("#modify").show();
				drawLayoutContentsGrade(data.upeval_results_array[index].grade_name);
			}
			else {
				$("#modify").hide();
			}
	
			<!-- 팝업레이어 컨탠츠 그리기 끝 -->
		}	
		
		function drawLayoutContentsGrade(_grade) {		
			
			var drawGrade = "<input type=\"hidden\" name=\"LAYER_GRADE\" id=\"LAYER_GRADE\" value=\"" + _grade + "\">";
			drawGrade += "<strong class=\"" +  _grade +  "\">";
			drawGrade += _grade.substring(0,1) + "</strong>";								
			drawGrade += "<span class=\"" +  _grade +  "\" onclick=\"selectGrade();\">";		    	
			drawGrade += _grade + "</span>";	    	
			drawGrade += "<input type=\"button\" onclick=\"selectGrade();\">";
			
			$("#draw_grade").html( drawGrade );
		}
		
		function changeGrade(grade_index) {						
			var temp = grade_index;
			drawLayoutContentsGrade(temp);
			selectGrade();			
		}
		
		// 차상위평가 평가 단계 선택
		function selectGrade(){
			$(".grade_select").slideToggle();			
		}	
		
		function getEvalData(flag){	
			
			var eval_index = "0";
			var user_num = '${userdata.user_num}';
			
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
				data : { 'user_num' : user_num , 'eval_index' : eval_index, 'eval_flag' : '1'}, // eval_flag 1 : 차상위평가까지 완료한 평가이력정보 로딩.
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
			
			if(${fn:length(period) } <= 0) {
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
		
		function goSelect() {
			window.location = "/goSelect.do";
		}			
	</script>		
</head>

<body>
	<!-- ========== header ========== -->
	<header>
		<div class="tit_cnt">
			<span class="menu"><img src="/resources/img/icon/ico_menu.png" alt="메뉴 아이콘"></span>
			<h2 class="title">차상위평가</h2>	
			<span class="prev" onclick="goSelect();"><img src="/resources/img/icon/ico_prev.png" alt="이전화면 아이콘"></span>
		</div>
		<div class="sub_bg"></div>
		<div class="user_cnt area">
			<img class="photo3" src="<%=getEnv().getUser_pic()%>" alt="프로필 사진"> 
			<span class="user_name"><%=getEnv().getUser_name()%></span><span> 님</span><span>(<%=getEnv().getDepart_name()%>, 사원번호: <%=getEnv().getUser_num()%>)</span>
		</div>
	</header>			
	
<%-- 	<header>
		<div class="div_left">
			<span class="title">차상위평가</span> <input type="button" onclick="goSelect();" value="이전화면">
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
		<h3 class="line">선택사원 정보</h3>
		<div class="clear select_member">
			<h4 class="f_l team_tit">${userdata.depart_name}</h4>
			<span class="f_r">사원번호 : ${userdata.user_num}, 사원명 : ${userdata.user_name}</span>
		</div>
		<div>
			<form name="form2" id="form2" action="/goUpEvalProcess.do" method="post">
				<input type="hidden" id="USER_NUM" name="USER_NUM" value="${userdata.user_num}">
				<input type="hidden" id="USER_NAME" name="USER_NAME" value="${userdata.user_name}">
				<input type="hidden" id="DEPART_NUM" name="DEPART_NUM" value="${userdata.depart_num}">
				<input type="hidden" id="DEPART_NAME" name="DEPART_NAME" value="${userdata.depart_name}">			 	
				<h3 class="line">평가기간 선택</h3>
				<div id="periodview1" name="periodview1">
					<span class="clear shbinfo">&nbsp;&nbsp;
						<select class="select2 f_l" name= "PERIOD_FROMTO" id="PERIOD_FROMTO">
							<c:forEach items="${period}" var="list">
								<!-- <option value="${list}">${list}</option> -->								
								<option value="${list}">${fn:substring(list,0,4)}년 ${fn:substring(list,4,6)}월 - ${fn:substring(list,9,13)}년 ${fn:substring(list,13,15)}월</option>
							</c:forEach>
						</select>
						<input class="btn_stl2 f_r" type="button" onclick="periodTest();" value="평가진행">
					</span> 
				</div>
				<div id="periodview2"  name="periodview2">
					<span class="subinfo">현재 평가 가능한 기간이 없습니다.</span>
				</div>				
			</form>
		</div>
		<div class="result_view">
			<div id="resultView"></div>
		</div>	
		<!-- 팝업레이어 영역 시작 -->
		<article style="text-align:left">	
			<div id="layer1" class="pop-layer">
				<div class="pop-container">
					<div class="pop-conts">
						<div id="layerContent"></div>	
						<a class="close_btn"></a>
						<div class="btn_area"> 
							<a class="btn_stl2 modify" id="modify" name="modify">수정</a>
						</div>
					</div>
				</div>
			</div>		
		</article>	
		<!-- 팝업레이어 영역 종료 -->		
<%-- 		<div class="div_left">
			<p class="subtitle">[선택사원 정보]</p>
			<span class="subinfo">부서 : ${userdata.depart_name}</span><br><span class="subinfo">사원번호 : ${userdata.user_num}, 사원명 : ${userdata.user_name}</span>	
		</div>
		
		<div class="div_left">
			<form name="form2" id="form2" action="/goUpEvalProcess.do" method="post"> 															
				<input type="hidden" id="USER_NUM" name="USER_NUM" value="${userdata.user_num}">
				<input type="hidden" id="USER_NAME" name="USER_NAME" value="${userdata.user_name}">
				<input type="hidden" id="DEPART_NUM" name="DEPART_NUM" value="${userdata.depart_num}">
				<input type="hidden" id="DEPART_NAME" name="DEPART_NAME" value="${userdata.depart_name}">
				<p class="subtitle">[평가기간 선택]</p>
				<div id="periodview1" name="periodview1">
					<span class="shbinfo">&nbsp;&nbsp;
						<select class="select2" name= "PERIOD_FROMTO" id="PERIOD_FROMTO">
							<c:forEach items="${period}" var="list">
								<option value="${list}">${list}</option>
							</c:forEach>
						</select>
						<input class="button1" type="button" onclick="periodTest();" value="평가진행">
					</span> 
				</div>
				<div id="periodview2"  name="periodview2">
					<span class="subinfo">현재 평가 가능한 기간이 없습니다.</span>
				</div>
			</form>
		</div>
	
		<div class="div_left">				
			<div id="resultView"></div>		
		</div>					
		
		<!-- 팝업레이어 영역 시작 -->
		<article style="text-align:left">	
			<div id="layer1" class="pop-layer">
				<div class="pop-container">
					<div class="pop-conts">
						<!-- content -->
						<div id="layerContent"></div>	
						<!--// content-->									
						<div class="btn-r">
							<a href="#" class="cbtn">Close</a>
							<a href="#" class="obtn" id="modify" name="modify">Modify</a>
						</div>
					</div>
				</div>
			</div>		
		</article>	
		<!-- 팝업레이어 영역 종료 -->				 --%>
	</section>
	<!-- ========== //content ========== -->
	
	<script type="text/javascript">
		startEvalData('${json_result}');
	</script>	

	<!-- ========== footer ========== -->	
	<!-- ========== //footer ========== -->
</body>

</html>