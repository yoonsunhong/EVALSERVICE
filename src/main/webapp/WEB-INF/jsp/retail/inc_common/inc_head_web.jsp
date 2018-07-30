<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%--
    파일명: inc_head_web.jsp
    설명:  공통으로 include 할 head 용 tag 들
        
    수정일             수정자        수정내용
    ------------------------------------------------------
    2018-03-16 장재민       초기작성 
    ------------------------------------------------------
    
    author  : 장재민
    since   : 2018.03.16
    version : 1.0
--%>
    
   
     <link rel="stylesheet" type="text/css" media="screen" href="/resources/js/jqGrid-4.4.1/css/ui.jqgrid.css" /> 
 
    <script type="text/javascript" src="/resources/js/jquery-ui-1.10.3.custom/js/jquery-1.7.1.min.js" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/jquery-ui-1.10.3.custom/js/jquery-ui-1.10.3.custom.js" charset="utf-8"></script> 
 
    <script type="text/javascript" src="/resources/js/jquery.ui.datepicker-ko.min.js" charset="utf-8"></script>
 
    <script type="text/javascript" src="/resources/js/jqGrid-4.4.1/js/i18n/grid.locale-kr.js" charset="utf-8"></script> 
    <script type="text/javascript" src="/resources/js/jqGrid-4.4.1/js/jquery.jqGrid.src.js" charset="utf-8"></script>  
     <script type="text/javascript" src="/resources/js/jquery.form.min.js " charset="utf-8"></script> 
    <script type="text/javascript" src="/resources/js/common.js" charset="utf-8"></script> 
    <script type="text/javascript" src="/resources/js/comm.js" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/vtrans.js" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/CommGrid.js" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/CommPopup.js" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/PageCommon.js" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/comCodeUtil.js" charset="utf-8"></script>
    <link type="text/css" rel="stylesheet" href="/resources/css/iframeCommon.css">
    
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
    </script>
     <style type="text/css">
         .ui-jqgrid .ui-state-highlight { background: #FAED7D; }  
     </style>
        
<!--      <style type="text/css">  -->
<!--        .ui-jqgrid tr.jqgrow td.colCell { -->
<!-- 		    padding-right: 15px; -->
<!-- 		} -->
<!--   	</style> -->
        
   