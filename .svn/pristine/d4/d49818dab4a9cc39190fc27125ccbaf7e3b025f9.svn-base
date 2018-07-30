<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 스프링 메세지 테그사용 :: 다국어 -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--
    파일명: inc_head.jsp
    설명:  공통으로 include 할 head 용 tag 들
    author  : 문희훈
    since   : 2016.10.25
    version : 1.0
--%>
    <title>업무평가 앱 웹페이지</title>  

	<!-- 기본 개발 프레임워크에는 무료버전의 JqGrid를 사용합니다. 유료 그리드 사용시, 그리드 컴포넌트 변경 작업 또는 JqGrid와 상용그리드를 병행 하여 사용하세요. -->
    <!-- <link rel="stylesheet" type="text/css" media="screen" href="/resources/css/ui.jqgrid.css" /> -->
    <script type="text/javascript" src="/resources/js/jquery-1.7.1.min.js" charset="utf-8"></script>
 	<script type="text/javascript" src="/resources/js/jquery-ui-1.10.3.custom.js" charset="utf-8"></script> 
    <script type="text/javascript" src="/resources/js/jquery.form.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/comCodeUtil.js" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/comm.js" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/common.js" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/CommPopup.js" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/vtrans.js" charset="utf-8"></script>
	<script type="text/javascript" src="/resources/js/commUtil.js" charset="utf-8"></script>    
    
    <!-- 달력을 사용하기위한 js/css -->
    <script type="text/javascript" src="/resources/js/jquery.ui-1.10.4.datepicker.min.js" charset="utf-8"></script> 
    <link rel="stylesheet"type="text/css"  href="/resources/js/jquery-ui.css">
    
    <!--  input 숫자와 콤마만 입력되게 하기 필수 include --> 
	<script type="text/javascript" src="/resources/js/jquery.number.js" charset="utf-8"></script>
	
    <!-- <script type="text/javascript" src="/resources/js/CommGrid.js" charset="utf-8"></script> -->
    <!-- <script type="text/javascript" src="/resources/js/jqgrid/i18n/grid.locale-kr.js" charset="utf-8"></script> -->
    <!-- <script type="text/javascript" src="/resources/js/jqgrid/jquery.jqGrid.src.js" charset="utf-8"></script> -->
    
    
    <script type="text/javascript">
    
	    $(document).ready(function(){
	    	$(document).keyup(function(e) {
		   		if (e.keyCode == 27) { 
		   		   if(typeof(gDialogComm) != "undefined") {
		   			   e.preventEvent();
		   			   gDialogComm.close();
		   		   }
		   		}
	   		});
	    	
	    	var obj = {};
	    	
	    	var url = location.href;
			var arrUrl = url.split("/");
			//console.log(arrUrl[arrUrl.length - 1].split(".")[0]);
			obj.MENU_ID = arrUrl[arrUrl.length - 1].split(".")[0];
			var postData = JSON.stringify(obj);
			// console.log(postData);
	    	
			$('input').on('keydown', function (e) {
	    	    if (e.keyCode === 13) {
	    	      e.preventDefault();
	    	    }
	    	});
	    	
	    });
	    
	 	// 평가화면 그룹  팝업레이어 제어부
	    $(document).ready(function (){
	    	// 닫기 버튼 클릭시 레이어와 투명 레이어 사라짐
	    	$(".close_btn, .modify").on("click",function  () {
	    		$("#layer1, .pop_overlay").hide();
	    		$(".pop_overlay").remove();
				
				//$('html').css({'overflow': 'auto'}); //scroll hidden 해제 
				//$('#element').off('scroll touchmove mousewheel'); // 터치무브 및 마우스휠 스크롤 가능
				//$('body').off('scroll touchmove mousewheel'); // 터치무브 및 마우스휠 스크롤 가능
	    	});
	    });

	    jQuery.fn.center = function () {
	        this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + "px");
	        this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px");
	        return this;
	    }

	    function openLayerContents(el, index){
	    	
	    	/*
			$('html').css({'overflow': 'hidden'}); // 모달팝업 중 html,body의 scroll을 hidden시킴 
			$('#element').on('scroll touchmove mousewheel', function(event) { // 터치무브와 마우스휠 스크롤 방지    
				event.preventDefault();     
				event.stopPropagation();     
				return false; 
			});			
			$('body').on('scroll touchmove mousewheel', function(event) { // 터치무브와 마우스휠 스크롤 방지    
				event.preventDefault();     
				event.stopPropagation();     
				return false; 
			});
			*/
	    	
	    	$('body').after("<div id='dinlayer' class='pop_overlay'></div>");
	    	drawLayerContents(index);
	    	
	    	var temp = $('#' + el);				//레이어의 id를 temp변수에 저장
	    	var temp2 = $(".pop_overlay");	//레이어의 id를 temp2변수에 저장

	    	temp.fadeIn();		
	    	
	    	temp.center();
	    	temp2.center();
	    	
	    	temp.find('a.btn_stl2').click(function(e){
	    		
	    		var layer_index = $("#LAYER_INDEX").val();
	    		var layer_grade = $("#LAYER_GRADE").val();
	    		var layer_comment = $("#LAYER_COMMENT").val();
	    		
	    		modifyEvalResult(layer_index, layer_grade, layer_comment);				
	    		
	    		temp.fadeOut();
	    		e.preventDefault();
	    	});
	    }
	    // 팝업레이어 제어 종료
	    
	    // 색상명 -> 색상코드 출력
	    function exportColorCode(_color) {
			
			var colorCode = "#FFFFFF"; // default : white
			
			// common.css .eval_state color 참조
			if(_color == "Gold") {
				colorCode = "#F4E351";
			}
			else if(_color == "Silver") {
				colorCode = "#BABABA";
			}
			else if(_color == "Green") {
				colorCode = "#45E39E";
			}
			else if(_color == "Yellow") {
				colorCode = "#FE912A";
			}
			else if(_color == "Red") {
				colorCode = "#E53052";
			}
			else {
				colorCode = "#FFFFFF";
			}
			
			return colorCode;
		}	
	    
		// 사원 사진 체크
		/*function userImgCheck(user_num){
			
			var userImg = document.getElementById("userImg");
	    	var imgPath = "/resources/img/user/";	
	    	
	    	var noimg = imgPath + "noimg.png";	
	    	var img = imgPath + user_num + ".png";
	    	
			$.ajax({
				url:img,
				type:'HEAD',
				error: function() {
					userImg.src = noimg;
				},
				success: function() {
					userImg.src = img;
				}
			});
		}*/
    </script>
     <style type="text/css">
         .ui-jqgrid .ui-state-highlight { background: #FAED7D; }  
     </style>
     
<!-- 다국어 프로퍼티 변수와 스프링 메세지 사용을 위한  스크립트 전역 변수와의 맵핑을 위한 include -->
<%@include file="/WEB-INF/jsp/retail/inc_common/inc_language.jsp" %>     
     