/********************************************************
 *  파일명: AMainEvalDepart.js
 * 설명:  부서별 항목 비중 설정
 * 수정일      	수정자       수정내용
 * ------------------------------------------------------
 * 2018-03-19   이성진       초기작성 
 * ------------------------------------------------------
 * author	: 이성진
 * since	: 2018.03.19
 * version : 1.0
 ********************************************************/
var crudBit          =   "C";   // 최초 신규로 시작함
var crudBitDetail    =   "C";   // 최초 신규로 시작함
var curDepart    =   "000";   // 최초 신규로 시작함


$(document).ready(function(){
	//$("#header").hide();
	//page = new Page();				// Page 클래스 생성
	
	initData();							// 1. 최초 DB에서 세팅헤 필요한 데이터를 가져온다.
	initElementBinding();				// 2. 초기 HTML ELEMENT BINDING
	setFormElementValue();				// 3. FORM ELEMENT 초기값 세팅
	saveFormElementValue();				// 4. FORM ELEMENT 초기값 저장
	applyFormElementJquery();			// 5. FORM ELEMENT 공통 JQUERY 적용
	addFormElementJqueryEvent();		// 6. FORM ELEMENT JQUERY EVENT 등록
	initGrid();							// 7. GRID 초기화
	init();								// 8. init Start
});
 
//########################################################
//###	1. 최초 DB에서 세팅에 필요한 데이터를 가져온다 ( 시작 )          ###
//########################################################
function initData() {
	//getCodeListbinding("#top_search select[name=P_USE_YN]", "CD004");	// 상단 사용여부
}
//########################################################
//###	1. 최초 DB에서 세팅에 필요한 데이터를 가져온다 ( 끝 )     	   ###
//########################################################
 
//########################################################
//###	2. 초기 HTML ELEMENT BINDING ( 시작 )  			   ###
//########################################################
function initElementBinding() {
	/* 보통 TOP_SEARCH 의 select 등 바인딩에 사용합니다.*/
	
}
//########################################################
//###	2. 초기 HTML ELEMENT BINDING ( 끝 )       	       ###
//########################################################
 
//########################################################
//###	3. FORM ELEMENT 초기값 세팅 ( 시작 )    			   ###
//########################################################
function setFormElementValue() {
	//달력 셋팅
	$("#top_search").applyCommJquery();
	
}

//통화포멧
var moneyFormat = {
        decimalSeparator : ".",
        thousandsSeparator : ",",
        decimalPlaces : 0,
        prefix : "",
        suffix : "",
        defaulValue : 0
}; 

//########################################################
//###	3. FORM ELEMENT 초기값 세팅 ( 끝 )      			   ###
//########################################################
 
//########################################################
//###	4. FORM ELEMENT 초기값 저장 ( 시작 )    			   ###
//########################################################
function saveFormElementValue() {
	/* 초기값을 설정하여 Search 이후 클린시 사용합니다.*/
/*	page.initFormData.top_search = $("#top_search").serializeObject(); */
}
//########################################################
//###	4. FORM ELEMENT 초기값 저장 ( 끝 )      			   ###
//########################################################
 
//########################################################
//###	5. FORM ELEMENT 공통 JQUERY 적용 ( 시작 )    		   ###
//########################################################
function applyFormElementJquery() {
	$("#top_search").applyCommJquery();
}
//########################################################
//###	5. FORM ELEMENT 공통 JQUERY 적용 ( 끝 )      		   ###
//########################################################
 
//########################################################
//###	6. FORM ELEMENT JQUERY EVENT 등록 ( 시작 )    	   ###
//########################################################
function addFormElementJqueryEvent() {

	
}
//########################################################
//###	6.FORM ELEMENT JQUERY EVENT 등록 ( 끝 )      	   ###
//########################################################
 
//########################################################
//###	7. grid 초기화 ( 시작 )   						   ###
//########################################################
function initGrid(){
	 
	jQuery("#grid1").jqGrid({ 
        hoverrows: false,
		url:"/getEvalDepart.do",
	    mtype: "POST",
	    datatype: "json",
	    postData: {'A':'A','A':'A'},
	    colNames:[
	  	   	    "부서코드",
	  	   	    "부서명",
//	  	   	    "사용여부"
	    ],
	   	colModel:[           
	   	    {name:"DEPART_NUM",   width:10,  align:"center"}, 
	   		{name:"DEPART_NAME",   width:10,  align:"center"},
//			{name:"USE_YN",  width:5,   align:"center", formatter : function(cellValue,options,rowObject){
//														                if(cellValue == 'Y'){
//														                    return '사용';
//														                }else if(cellValue== 'N'){
//														                    return '미사용';
//														                }
//														             }}
	   	],  
	   	emptyrecords: "Nothing to display",
	   	rownumbers: false,
	   	autowidth: true,
		rowNum: 100,
	   	rowList:[10,30,50,100],
	   	pager: '#ajaxProwed1',
	   	//viewrecords: true,
	   	cmTemplate: { sortable: false },
		loadonce: false,
		multiselect: false,
		onSelectRow: function(id) {
	    	// 분류 상세  
	    	var rowData = $("#grid1").getRowData(id); 
	    	$('#DEPART_NUM').val(rowData.DEPART_NUM); 
	    	
	    	curDepart = rowData.DEPART_NUM;
	    	
	    	if(rowData.USE_YN == "사용"){
	    		$("input:radio[name='USE_YN']:radio[value='Y']").attr("checked",true);
	    	}else if(rowData.DEL_YN == "미사용"){
	    		$("input:radio[name='USE_YN']:radio[value='N']").attr("checked",true);
	    	}
	    	
	    	btn_search_detail( );   // 상세 리스트 보여주기
	    	
	    	crudBit = "U";   // 수정
	     
		},
		ondblClickRow : function(rowId,iCol,cellcontents,e) {   // 상세 팝업 
		},
		success:function(data,textStatus){ 
		},
		loadComplete: function(data) {
		},
        //헤더 클릭시 정렬
        onSortCol: function(sidx, colnum, sort_order){ 	//헤더 클릭
	    	//alert(sidx +'|'+ sort_order +'|');
	    	$("#SORTHEADER").val(sidx);
	    	$("#SORT").val(sort_order);
	    	
	    	var grid = $("#grid1");
	    	var loadData = $("#top_search").serializeAllObject();
	    	  
	    	grid.jqGrid('setGridParam', {
        		url:"/getEvalDepart.do",
        	    mtype: "POST",
        	    datatype: "json",
        	    postData: loadData ,
        	}).trigger('reloadGrid'); 
	    }
	}); 
	
	
	
	jQuery("#grid2").jqGrid({ 
        hoverrows: false,
		url:"/getEvalItem.do",
	    mtype: "POST",
	    datatype: "json",
	    postData: {'A':'A','A':'A'},
	    colNames:["부서코드","순번","평가항목명","비중",""],
	   	colModel:[    
            {name:"DEPART_NUM",        width:40, align:"center", hidden:true},      
	   	    {name:"EVAL_ITEM_NUM",   width:40,    align:"center", key:true}, 
	   		{name:"EVAL_ITEM_NAME",  width:160,   align:"left"},
			{name:"EVAL_RATE",   		  width:40,    align:"right",formatter :"moneyFormat",editable:true,
	   		  editrules:{custom: true,custom_func: validNum},
	   		  editoptions:{maxlength: 11}
	        },
			{name:"",   		                  width:400,    align:"left"}
	   	],  
	   	emptyrecords: "Nothing to display",
	   	rownumbers: false,
	   	autowidth: true,
		rowNum: 100,
	    cellEdit:true,
	    cellsubmit:'remote',
	    cellurl:'/updateCellEvalItem.do',
	   	rowList:[10,30,50,100],
	   	pager: '#ajaxProwed1',
	   	//viewrecords: true,
	    cmTemplate: { sortable: false },
		loadonce: false,
		footerrow:true,
		multiselect: false,
		beforeSubmitCell : function(rowid, cellname, value) {   // submit 전
			var data = jQuery("#grid2").getRowData(rowid);
			//alert(data);
			return {"DEPART_NUM":data.DEPART_NUM, "EVAL_ITEM_NUM":data.EVAL_ITEM_NUM, "EVAL_RATE":data.EVAL_RATE};

	    },
	    afterSubmitCell : function(res) {    // 변경 후
	         var aResult = $.parseJSON(res.responseText);
	         var userMsg = "";
	         if(!(aResult == 1)) {
	        	 userMsg = "오류가 발생했습니다.";
	         }
	         //그리드2 재조회 (푸터 합계 계산)
	         btn_search_detail();
	         
	         //서브밋결과를 반드시 리턴 해줘야 한다. 안그럼 javascript 오류 발생
	         return [(aResult == 1) ? true : false, userMsg];
	    },
		onSelectRow: function(id) {
	    	// 분류 상세  
	    	var rowData = $("#grid2").getRowData(id); 
	    	$('#DEPART_NUM').val(rowData.DEPART_NUM); 
	    	$('#EVAL_ITEM_NUM').val(rowData.EVAL_ITEM_NUM); 
	    	crudBit = "U";   // 수정
		},		
		onSelectRow: function(id) {

		},
		ondblClickRow : function(rowId,iCol,cellcontents,e) {   // 상세 팝업 
			  
		},
		success:function(data,textStatus){ 
		},
		loadComplete: function(data) {
			//비중치 토탈 합
			var EVAL_RATE = $('#grid2').jqGrid('getCol','EVAL_RATE',false, 'sum');
			$('#grid2').jqGrid('footerData','set',  {crateName:'합계',EVAL_RATE:EVAL_RATE}   );
		}
	}); 
	
	
	//그리드 너비 설정
	$(window).resize(function() {  
		$("#grid1").each(function() {
			var grid = $(this);
 			var height = $(window).height() -  190;
 			grid.setGridHeight(height,true);
		});
	}).resize();
	
	//그리드 너비 설정
	$(window).resize(function() {  
		$("#grid2").each(function() {
			var grid = $(this);
			var width = $(window).width()- 408;
 			var height = $(window).height()  -  538;
			grid.setGridWidth(width,true);
 			grid.setGridHeight(height,true);
		});
	}).resize();
	
}

//그리드 셀에디트시 숫자만 입력체크
function validNum(val, nm, valref){
	
	if($.isNumeric(val)){
		if(val%5 == 0) {
			if(val > 0) {
				return [true, ""];
			}
			else {
				return [false, "0보다 큰 수만 입력 가능합니다."];
			}
		}
		else {
			return [false, "비중값은 5배수로 입력 가능합니다."];
		}
	}
	else{
          return [false, "숫자만 입력 가능 합니다."];
	}
}
//########################################################
//###	7. grid 초기화 ( 끝 )     						   ###
//########################################################
 
//########################################################
//###	8. init ( 시작 )   							   ###
//########################################################
function init() {

	 
	//초기 그리드 사이즈 조절
	$(function() {
		$("#pop_wrap").dialog({
		    autoOpen : false,
		    modal : true,
		    width : 900,
		    resizable : false
		});
		
	});
	
	//숫자만 입력받기
	$("#D_SORT_ORDER").keyup(function(){
		$(this).val($(this).val().replace(/[^0-9]/g,''));
    });
	 
	//회사검색 팝업
	$("#dialog1").dialog({
	    autoOpen : false,
	    modal : true,
	    width : 650,
	    resizable : false
	});

	//그리그 페이징 엔터 입력시 아작스 호출(ajaxProwed1페이지를 바인딩 하는 아이디를 입력)
    $('input.ui-pg-input',"#ajaxProwed1").keypress( function(e) {
		 
		var key = e.charCode ? e.charCode : e.keyCode ? e.keyCode : 0;
		
		//  tstti : 페이징 시 택스트 박스에서 엔터
		if(key == 13) {
			 
			var flag = 'ajaxProwed1';
			
			var maxPage1 = 0;
			var movePage1 = 0;
			
			if(flag == 'ajaxProwed1'){
				
				// 현재 페이징 확인용 
			    var newUserValue = $('input.ui-pg-input', "#ajaxProwed1").val();
			    
			    if(newUserValue == 0){
			    	alert("존재하지 않는 페이지 입니다.");
			        return;
			    }
				
				maxPage1 = $('#sp_1_ajaxProwed1').text();
				movePage1 = $('#goPageajaxProwed1').val();
				
				if(Number(movePage1) > Number(maxPage1)){
					alert("총 페이지 수보다 큽니다. 다시 입력 해주세요.");
					return;
				}else{
					var grid = $("#grid1");
		            var loadData = $("#top_search").serializeAllObject();
		            
		            loadData.PAGE = movePage1;
		            
		            loadData.ROW_LIST = $("#grid1").getGridParam('rowNum');
		            
		        	grid.jqGrid('setGridParam', {
		        		url:"/getEvalDepart.do",
		        	    mtype: "POST",
		        	    datatype: "json",
		        	    postData: loadData ,
		        	    page:movePage1,
		        	}).trigger('reloadGrid');
		        	return;
				}
			}
		}
    });

}
//나중에 js로 빼
jQuery.download = function(url, data, method){
    // url과 data를 입력받음
    if( url && data ){ 
        // data 는  string 또는 array/object 를 파라미터로 받는다.
        data = typeof data == 'string' ? data : jQuery.param(data);
        // 파라미터를 form의  input으로 만든다.
        var inputs = '';
        jQuery.each(data.split('&'), function(){ 
            var pair = this.split('=');
            inputs+='<input type="hidden" name="'+ pair[0] +'" value="'+ pair[1] +'" />'; 
        });
        // request를 보낸다.
        jQuery('<form action="'+ url +'" method="'+ (method||'post') +'">'+inputs+'</form>')
        .appendTo('body').submit().remove();
    };
};
//########################################################
//###	8. init ( 시작 )   							   ###
//########################################################
  
//########################################################
//###   사용자 정의 함수 ( 시작 )   							   ###
//########################################################


//그리드 페이징의 이동 버튼 클릭시 아작스 호출
function goPage(val){
	
	// 현재 페이징 확인용 
  var newUserValue = $('input.ui-pg-input', "#ajaxProwed1").val();
   
  if(newUserValue == 0){
  	alert("존재하지 않는 페이지 입니다.");
      return;
  }
	
	var flag = val.id;
	
	var maxPage1 = 0;
	var movePage1 = 0;
	
	if(flag == 'ajaxProwed1'){
		
		maxPage1 = $('#sp_1_ajaxProwed1').text();
		movePage1 = $('#goPageajaxProwed1').val();
		
		if(Number(movePage1) > Number(maxPage1)){
			alert("총 페이지 수보다 큽니다. 다시 입력 해주세요.");
			return;
		}else{
			
			var grid = $("#grid1");
          var loadData = $("#top_search").serializeAllObject();
          
          loadData.PAGE = movePage1; 
          loadData.ROW_LIST = $("#grid1").getGridParam('rowNum');
           
      	grid.jqGrid('setGridParam', {
      		url:"/getEvalDepart.do",
      	    mtype: "POST",
      	    datatype: "json",
      	    postData: loadData ,
      	    page:movePage1,
      	}).trigger('reloadGrid');
			
			//$('#grid1').jqGrid('setGridParam', { "page": movePage1 }).trigger("reloadGrid");
		}
	}
}


//그리드 사이즈 조절
function reSizefn(){
	
}

 


//########################################################
//###   사용자 정의 함수 ( 끝 )     						   ###
//########################################################
 
//########################################################
//###   grid 이벤트 ( 시작 )   							   ###
//########################################################



//########################################################
//###   grid 이벤트 ( 끝 )     							   ###
//########################################################
 
//########################################################
//###   로우 클릭시 팝업  구현 ( 시작 )    					   ###
//########################################################

function btn_close(){ 
	// btn_search();
	$("#pop_wrap").dialog( "close" );
}


function btn_search_detail( ){
	 
	var rowId = $("#grid1").jqGrid('getGridParam', 'selrow');  
	var loData = $("#grid1" ).jqGrid('getRowData', rowId);
	
	var grid = $("#grid2");
	grid.jqGrid('setGridParam', {
		url:"/getEvalItem.do",
	    mtype: "POST",
	    datatype: "json",
	    postData: {DEPART_NUM:loData.DEPART_NUM} , // page:1, 
	}).trigger('reloadGrid');
	 
	//그리드 사이즈 조절
	reSizefn();
 
}

function btn_search(){
	  
	var loadData = $("#top_search").serializeAllObject(); 
	     
	var grid = $("#grid1");
	grid.jqGrid('setGridParam', {
		url:"/getEvalDepart.do",
	    mtype: "POST",
	    datatype: "json",
	    postData: loadData , // page:1,
	    
	}).trigger('reloadGrid');
	 
	//그리드 사이즈 조절
	reSizefn();
	
}

// 2018.04.02
// 부서원의 평가기준을 부서기준으로 일괄 수정
function btn_update_all() {
	
	var rowId = $("#grid1").jqGrid('getGridParam', 'selrow');  
	var loData = $("#grid1" ).jqGrid('getRowData', rowId);
		
	if(loData.DEPART_NUM == undefined) {
		alert("부서를 선택하십시오.");
		return;
	}
	
	if(confirm("[" + loData.DEPART_NAME + "]\n부서원의 평가기준을 일괄 수정하시겠습니까?") == false) return;
	
	var EVAL_RATE = $('#grid2').jqGrid('getCol','EVAL_RATE',false, 'sum');
	
	if(EVAL_RATE != 100) {
		alert("평가 비중의 합이 100이 아닙니다. 수정 후 다시 시도하십시오.");
		return;
	}
	
	jQuery.ajax({
	    type:"POST",
	    url:"/updateEvalRateDepartUser.do",
	    enctype : "multipart/form-data",
	    dataType:"JSON",
	    data: loData,
	    success : function(data) {
	    	alert("수정되었습니다.");
	    },
	    complete : function(data) {
	    },
	    error : function(xhr, status, error) {
	    	alert("에러 발생.");
	    }
	});
}
 
//########################################################
//###   상단 버튼 구현 ( 끝 )   							   ###
//########################################################