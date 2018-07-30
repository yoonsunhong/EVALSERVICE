<%@ page language="java"   contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/jsp/retail/inc_common/inc_acommon.jsp" %>
<%@page import ="java.util.List" %>
<%@page import ="java.util.HashMap" %>
<%@page import ="java.util.ArrayList" %>
<%@page import ="java.util.List" %>
<%@page import ="retail.main.service.MainVO" %>


<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="사이트에 대한 설명">
<meta name="keywords" content="키워드, 태그">
<title>리테일테크 업무평가 시스템 관리모드</title>
<link type="text/css" rel="stylesheet" href="/resources/css/acommon.css">
<!--[if lt IE 9]>
<script src="/resources/js/html5shiv.js"></script>
<script src="/resources/js/IE9.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/css/ie8.css">
<![endif]-->

<jsp:include page="/WEB-INF/jsp/retail/inc_common/inc_head.jsp" />
<%  
  List<MainVO> getBigMenu = (List<MainVO>)request.getAttribute("getBigMenu");
%>


<script type="text/javascript" src="/resources/js/jquery-1.7.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/js/jquery.cookie.js" charset="utf-8"></script>    
<script type="text/javascript" src="/resources/js/tabs.js" charset="utf-8"></script>
<script type="text/javascript">
		//폴딩을 위한 전역변수
		var tType = 'O';
		//다국어 디폴트 언어 전역변수
		var languge = 'ko';
		$(document).ready(function () { 
			
			
			// 대메뉴 클릭시 포커스 토글
		    $('#gnb li').click(function() {		
		        $('#gnb li').removeClass('on');
		        $(this).addClass('on');
		    });
			
			//레프트 메뉴 클릭시 포커스 토글
		    $('#snb li').click(function() { 
			     $('#snb li').removeClass('on');
			     $(this).addClass('on');					 
		    });
			
		  /*최초 탭 열기(기본화면 : tabs.js에 함수가 있음)
		  	파라미터 : 클래스패스, URL
		  */
		  //Tabs_Onload('mainContents','mainContents.do');
		  
		  //Tabs_Onload('aMainTop.do','aMainTop.do');
		    Tabs_Onload('aMainUserManage.do','aMainUserManage.do');
			
		});
		 
		
		/*
		// 레프트 메뉴 생성
		function  getMiddleMenu(menu_id, menu_nm) 
		{ 
			
			$.ajaxSetup({ cache: false });
			$.ajax({
				url      : "/getMiddleMenu.do",
				cache: false,
				type     : "POST",
				datatype : "json",
				async    : "false",
				data     : { 'menu_id' : menu_id },
				success  : function(data, textStatus) { 
						<!--레프트 메뉴 그리기 시작-->	 
					    var getMiddleMenuDiv = "<ul>"; 
					    //console.log('DATA : ', data);
					    if( ! ( data.rows[0].cell[1] ==  null ||  data.rows[0].cell[1] ==  ""  ) )
					    {
					    	getMiddleMenuDiv += "<h2>"+menu_nm+"</h2>";
					    }
						$.each(data.rows, function(i, item) {
							if( data.rows[i].cell[1] ==  null ||  data.rows[i].cell[1] ==  ""  )
							{   
								getMiddleMenuDiv += "<h2>"+data.rows[i].cell[0]+"</h2>";
							} else {
								getMiddleMenuDiv +=  '<li id="'+data.rows[i].cell[1].split('.')[0]+'"><a href="javascript:Tabs_On(\''+data.rows[i].cell[1]+'\' ,  \''+data.rows[i].cell[0]+'\' ,  \''+data.rows[i].cell[1]+'\',\'true\' );">'+data.rows[i].cell[0]+"</a></li>" ;
							}
						}); 
						getMiddleMenuDiv += "</ul>";
 						//alert(getMiddleMenuDiv);
						$("#getMiddleMenuDiv").html( getMiddleMenuDiv );
						
						$('#snb li').click(function() {
						     $('#snb li').removeClass('on');
						     $(this).addClass('on');
						});
						
						<!--레프트 메뉴 그리기 끝-->
						 
				},
				error:function(x,e){
					// console.log('메뉴 로딩 실패 : ' + x);
					// alert('1');
				}	 
			});
			    
		}*/
		
		// 레프트 메뉴 생성
		function  getMiddleMenu(menu_id, menu_nm) 
		{ 
			    var getMiddleMenuDiv = "<ul>";
			    getMiddleMenuDiv += "<h2>"+menu_nm+"</h2>";
			    
			    //getMiddleMenuDiv +=  '<li id="'+data.rows[i].cell[1].split('.')[0]+'"><a href="javascript:Tabs_On(\''+data.rows[i].cell[1]+'\' ,  \''+data.rows[i].cell[0]+'\' ,  \''+data.rows[i].cell[1]+'\',\'true\' );">'+data.rows[i].cell[0]+"</a></li>" ;
			    //getMiddleMenuDiv +=  '<li id="'+'aMainTop'+'"><a href="javascript:Tabs_On(\''+'aMainTop.do'+'\' ,  \''+'테스트메뉴'+'\' ,  \''+'aMainTop.do'+'\',\'true\' );">'+'테스트메뉴'+'</a></li>' ;
			    
			    //getMiddleMenuDiv +=  '<li id="aMainTop"><a href="javascript:Tabs_On(\'aMainTop.do\', \'홈\', \'aMainTop.do\', \'true\' );">홈</a></li>';
			    getMiddleMenuDiv +=  '<li id="aMainUserManage"><a href="javascript:Tabs_On(\'aMainUserManage.do\', \'사원 관리\', \'aMainUserManage.do\', \'true\' );">사원 관리</a></li>';
			    getMiddleMenuDiv +=  '<li id="aMainCodeManage"><a href="javascript:Tabs_On(\'aMainCodeManage.do\', \'공통코드 관리\', \'aMainCodeManage.do\', \'true\' );">공통코드 관리</a></li>';
			    getMiddleMenuDiv +=  '<li id="aMainDepartManage"><a href="javascript:Tabs_On(\'aMainDepartManage.do\', \'부서 관리\', \'aMainDepartManage.do\', \'true\' );">부서 관리</a></li>';
			    getMiddleMenuDiv +=  '<li id="aMainEvalManage"><a href="javascript:Tabs_On(\'aMainEvalManage.do\', \'평가기준 관리\', \'aMainEvalManage.do\', \'true\' );">평가기준 관리</a></li>';
			    getMiddleMenuDiv +=  '<li id="aMainEvalDepart"><a href="javascript:Tabs_On(\'aMainEvalDepart.do\', \'부서별 평가기준관리\', \'aMainEvalDepart.do\', \'true\' );">부서별 평가기준관리</a></li>';
			    getMiddleMenuDiv +=  '<li id="aMainEvalUser"><a href="javascript:Tabs_On(\'aMainEvalUser.do\', \'사원별 평가기준관리\', \'aMainEvalUser.do\', \'true\' );">사원별 평가기준관리</a></li>';
				
			    
				getMiddleMenuDiv += "</ul>";
					//alert(getMiddleMenuDiv);
				$("#getMiddleMenuDiv").html( getMiddleMenuDiv );
				
				$('#snb li').click(function() {
				     $('#snb li').removeClass('on');
				     $(this).addClass('on');
				});
				
				<!--레프트 메뉴 그리기 끝-->
			    
		}
		
		//로그아웃 처리
		function logOut()
		{ 
			window.location = "/aLogout.do";
			//window.location = '/';
		}
		
		
		//폴딩 토글
		function togle(){
			if(tType == 'O') {tType='C'}
			else if(tType == 'C') {tType='O';}
			$('#wrap').toggleClass('folded');
		}

		
		/**
		*다국어 설정 변경을 위한 Script 시작
		**/
		//다국어 설정
		function changeLocation(location){
				Language = location.value;
				if(location.value !=""){
					window.location ="/location/changLang.do?lang="+location.value;	
				}
		} 
		
		//다국어 셀렉트 박스 셀렉트
		$(document).ready(function () {
			//alert(getQuerystring('lang'));
			if(typeof getQuerystring('lang') == 'undefined'){
				//최초 로그인시 디폴트 랭귀지 설정
				$("#selectLanguage").val(languge);	
			}else{
				//사용자가 선택 했을때 변경
				$("#selectLanguage").val(getQuerystring('lang'));
			}
		});
		
		//url의 파라미터 값 가지고 오기
		function getQuerystring(paramName){

			var _tempUrl = window.location.search.substring(1); //url에서 처음부터 '?'까지 삭제
			var _tempArray = _tempUrl.split('&'); // '&'을 기준으로 분리하기
			
			for(var i = 0; _tempArray.length; i++) {
				if(typeof _tempArray[i] != 'undefined'){
					var _keyValuePair = _tempArray[i].split('='); // '=' 을 기준으로 분리하기
					
					if(_keyValuePair[0] == paramName){ // _keyValuePair[0] : 파라미터 명
						// _keyValuePair[1] : 파라미터 값
						
						return _keyValuePair[1];
					}	
				}else{
					return _keyValuePair[1];
				}
			}
		}
		//alert(getQuerystring('lang'));
		/**
		*다국어 설정 변경을 위한 Script 끝
		**/
</script>

</head>
<body>
<div id="wrap">
    <!-- header -->
    <header id="header">
		<h1 class="logo">
			<a href="#">
				리테일테크 업무평가 시스템 관리모드
			</a>
		</h1>
		<div class="top_log">
			<span><%=getAEnv().getAdmin_name() %>님 환영합니다.  </span> 
			<a href="javascript:logOut();" class="btn_head">로그아웃</a>	 
			
			<!-- 
			<span>다국어</span>
			<select id="selectLanguage" onchange="changeLocation(this)">
				<option value="">선택</option>Tabs_Onload('main_top','aMainTop.do');
				<option value="ko">한국어</option>
				<option value="en">English</option>
			</select>  -->
		</div>
		<nav id="gnb"> 
			<ul>
				<!-- 대 메뉴 출력 -->				
				<li id ="A100"><a href="javascript:getMiddleMenu('A100','메인메뉴')">메인메뉴</a></li>
			</ul>
		</nav>
    </header> 
	<hr>
    <!-- //header -->
    <!-- container -->
    <div id="container">
		<!-- snb -->
		<nav id="snb">
				<div id="menuLeft">
				<div id="getMiddleMenuDiv"></div>
				<button type="button" class="btn_fold" onclick="javascript:togle();">메뉴 접기/펼치기</button> 
		</nav>
		
		<div id="content" style="width:100%">	
			<div id="tabs" class="tab_st1" style="width:100%">
				<!-- 상단 탭 -->
				<ul id="main_tab" style="width:100%"></ul>
				<!-- //상단 탭 -->
				<!-- 탭 내용 -->
				<div id="frame_box" class="frame_box">
					<iframe id="frame0"  class="DivHide" style="height:700px" src="" title="frame0"></iframe>
					<iframe id="frame1"  class="DivHide" style="height:700px" src="" title="frame1"></iframe>
					<iframe id="frame2"  class="DivHide" style="height:700px" src="" title="frame2"></iframe>
					<iframe id="frame3"  class="DivHide" style="height:700px" src="" title="frame3"></iframe>
					<iframe id="frame4"  class="DivHide" style="height:700px" src="" title="frame4"></iframe>
					<iframe id="frame5"  class="DivHide" style="height:700px" src="" title="frame5"></iframe>
					<iframe id="frame6"  class="DivHide" style="height:700px" src="" title="frame6"></iframe>
					<iframe id="frame7"  class="DivHide" style="height:700px" src="" title="frame7"></iframe>
					<iframe id="frame8"  class="DivHide" style="height:700px" src="" title="frame8"></iframe>
				</div>
			</div>
			<!-- //탭 내용 -->
		</div>
		<!-- //Content : 본문 영역 -->
    </div>
    <!-- //container -->
    
    <!-- 탭기능을 위한 셋팅 시작-->
    <input type="hidden" id="hdnFrameCount" value="0" title="" />
    <input type="hidden" id="hdnMenuCode" value="0" title=""/>   <!-- 첫로딩시 왼쪽트리에 뿌려줄 대메뉴의 라지코드  -->
    <input type="hidden" id="hdnActiveId" title="" />
    <!-- 탭기능을 위한 셋팅 끝-->
    
    <!-- footer -->
	<hr>
    <footer id="footer">
        <nav class="f_menu">
            <ul>
                <li><a href="#" class="f1">fmenu</a></li>
                <li><a href="#" class="f2">fmenu</a></li>
                <li><a href="#" class="f3">fmenu</a></li>
                <li><a href="#" class="f4">fmenu</a></li>
                <li><a href="#" class="f5">fmenu</a></li>
             </ul>
        </nav>
        <address>주소</address>
        <p class="copy">Copyright(C) RETILTECH. All rights reserved.</p>
		<a href="#header" class="btn_top">위로 이동</a>
    </footer>
</div>
</body>

<script language="javascript">
	//최초 로그인 시 상단메뉴 포커스
	$('#A100').addClass( "on" );
	//최초 로그인시 나와야 할 메뉴 셋팅
	//레프트메뉴 생성
	getMiddleMenu('A100','메인메뉴');
</script> 
</html>