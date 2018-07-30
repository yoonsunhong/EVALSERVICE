/********************************************************
 *  파일명: AMainEvalItem.js
 * 설명:  공통코드관리
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
	getCodeListbinding("#top_search select[name=P_USE_YN]", "CD004");	// 상단 사용여부
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
	/*$("#form_01 select[name=EMAIL_DOMAIN]").change(function(){
		if($(this).find("option:selected").val() == "01") {		// 직접입력
			$("#form_01 input[name=USER_EMAIL_DOMAIN]").focus();
			$("#form_01 input[name=USER_EMAIL_DOMAIN]").select();
		} else {
			$("#form_01 input[name=USER_EMAIL_DOMAIN]").val($(this).find("option:selected").text());
		}
	});*/
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
		url:"/getEvalItemLst.do",
	    mtype: "POST",
	    datatype: "json",
	    postData: {'A':'A','A':'A'},
	    colNames:["순번","평가항목","초기 비중값","사용여부"],
	   	colModel:[           
	   	    {name:"EVAL_ITEM_NUM",   width:5,  align:"center"}, 
	   		{name:"EVAL_ITEM_NAME",   width:20,  align:"left",
	   			editable:true,
	   			edittype:'text',
	   			editoptions:{maxlength: 20}
	   		},
	   		{name:"EVAL_RATE",   width:12,  align:"right",
	   			formatter:"moneyFormat",
	   			editable:true,
	   			editrules:{custom: true, custom_func: validNum},
	   			editoptions:{maxlength: 11}
	   		},
//			{name:"USE_YN",  width:10,   align:"center",
//	   			formatter : function(cellValue,options,rowObject){
//	                if(cellValue == 'Y'){
//	                    return '사용';
//	                }else if(cellValue== 'N'){
//	                    return '미사용';
//	                }
//				}
//	   		},
			{name:"USE_YN",  width:10,   align:"center",
	   			editable: true,
	   			edittype:'select',
	   			editoptions:{value:"Y:사용;N:미사용"},
	   			formatter : function(cellValue,options,rowObject){
		            if(cellValue == 'Y'){
		                return '사용';
		            }else if(cellValue== 'N'){
		                return '미사용';
		            }
				}
	   		}
	   	],  
	   	emptyrecords: "Nothing to display",
	   	rownumbers: false,
	   	autowidth: true,
		rowNum: 30,
	   	rowList:[10,30,50,100],
	   	
	   	cellEdit:true,
	    cellsubmit:'remote',
	    cellurl:'/updateEvalItem.do',	   	
	   	
	   	pager: '#ajaxProwed1',
	   	//viewrecords: true,
	    cmTemplate: { sortable: false },
		footerrow:true,
		loadonce: false,
		multiselect: false,
		
		beforeSubmitCell : function(rowid, cellname, value) {   // submit 전
			var data = jQuery("#grid1").getRowData(rowid);
			//a00lert(data.EVAL_ITEM_NAME + ", " + data.EVAL_RATE + ", " + data.USE_YN + ", " + data.EVAL_ITEM_NUM);
			return {"EVAL_ITEM_NAME":data.EVAL_ITEM_NAME, "EVAL_RATE":data.EVAL_RATE, "USE_YN":validYN(data.USE_YN), "EVAL_ITEM_NUM":data.EVAL_ITEM_NUM};
	    },
	    afterSubmitCell : function(res) {    // 변경 후
	         var aResult = $.parseJSON(res.responseText);
	         var userMsg = "";
	         if(!(aResult == 1)) {
	        	 userMsg = "오류가 발생했습니다.";
	         }
	         //그리드2 재조회 (푸터 합계 계산)
	         btn_search();
	         
	         //서브밋결과를 반드시 리턴 해줘야 한다. 안그럼 javascript 오류 발생
	         return [(aResult == 1) ? true : false, userMsg];
	    },
		
		onSelectRow: function(id) {
//	    	// 분류 상세  
//	    	var rowData = $("#grid1").getRowData(id); 
//	    	$('#EVAL_ITEM_NUM').val(rowData.EVAL_ITEM_NUM); 
//	    	$('#EVAL_ITEM_NAME').val(rowData.EVAL_ITEM_NAME);
//	    	$('#EVAL_RATE').val(rowData.EVAL_RATE);  
//	    	
//	    	if(rowData.USE_YN == "사용"){
//	    		$("input:radio[name='USE_YN']:radio[value='Y']").attr("checked",true);
//	    	}else if(rowData.DEL_YN == "미사용"){
//	    		$("input:radio[name='USE_YN']:radio[value='N']").attr("checked",true);
//	    	}
//	    	
//	    	//btn_search_detail( );   // 상세 리스트 보여주기
//	    	
//	    	crudBit = "U";   // 수정
	     
		},
		ondblClickRow : function(rowId,iCol,cellcontents,e) {   // 상세 팝업 
			
		},
		success:function(data,textStatus){ 
			
		},
		loadComplete: function(data) {
			
		}
//		,
//        //헤더 클릭시 정렬
//        onSortCol: function(sidx, colnum, sort_order){ 	//헤더 클릭
//	    	//alert(sidx +'|'+ sort_order +'|');
//	    	$("#SORTHEADER").val(sidx);
//	    	$("#SORT").val(sort_order);
//	    	
//	    	var grid = $("#grid1");
//	    	var loadData = $("#top_search").serializeAllObject();
//	    	  
//	    	grid.jqGrid('setGridParam', {
//        		url:"/getEvalItemLst.do",
//        	    mtype: "POST",
//        	    datatype: "json",
//        	    postData: loadData ,
//        	}).trigger('reloadGrid'); 
//	    }
	}); 
	
	
	
	//그리드 너비 설정
	$(window).resize(function() {  
		$("#grid1").each(function() {
			var grid = $(this);
 			var height = $(window).height() -  380;
 			grid.setGridHeight(height,true);
		});
	}).resize();
	

	
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
		        		url:"/getEvalItemLst.do",
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
      		url:"/getEvalItemLst.do",
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


function btn_del()
{
	 
    var rowId = $("#grid1").jqGrid('getGridParam', 'selrow');  
	var loData = $("#grid1" ).jqGrid('getRowData', rowId);
	  
	if ( typeof loData.EVAL_ITEM_NUM  == 'undefined')
	{
		alert('하단 그리드에서 코드를 선택하세요.');
		return;
	}  
	
	 
	 if(confirm("코드를 삭제하시겠습니까?") == false) return;
	 
	 
     jQuery.ajax({ 
	    url:"/deleteEvalItem.do",         
	    type:"POST",
		datatype:"json",
		data:  {EVAL_ITEM_NUM:loData.EVAL_ITEM_NUM  },
		beforeSend : function(xhr) {} ,
		success:function(data,textStatus){ 
			btn_search();
			btn_new();
			
	    },
	    complete : function(data) {
	    },
	    error : function(xhr, status, error) { 
	    }
	});
	alert("삭제   되었습니다.");
	 
	
}




function btn_del_cancel()
{

}

function btn_select_count_code(EVAL_ITEM_TYPE_CODE , EVAL_ITEM_NUM){
	 
	    var rtn = "";
		jQuery.ajax({
		    type:"POST",
		    url:"/selectCountCode.do",
		    dataType:"JSON",  
		    async: false ,
		    data:{
		    	   EVAL_ITEM_TYPE_CODE  : EVAL_ITEM_TYPE_CODE
				 , EVAL_ITEM_NUM          : EVAL_ITEM_NUM
		    },
		    success : function(data,textStatus) {  
		    	var i = 0;
		    	$.each(data.content, function(i, item) {  
		    		if(i == 0)
		    		{ rtn = data.content[0].cnt ;  }
		    		
		    		i = i + 1;
		    	});
		    	
		    },
		    complete : function(data) {
		          // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
		          // TODO
		    },
		    error : function(xhr, status, error) {
		     
		    }
		});
		
		
		return rtn;
}

function btn_new()
{
	crudBit = "C";   //신규
	$('#EVAL_ITEM_NAME').val(""); 
	$('#EVAL_ITEM_NUM').val(""); 
	$('#EVAL_RATE').val("");   
	$("input:radio[name='USE_YN']").removeAttr('checked'); 
}

function btn_save()
{
	 
	            
	 if( $('#EVAL_ITEM_NAME').val()  == null || $('#EVAL_ITEM_NAME').val() =="" ){
			confirm("평가항목명은 필수 입력항목 입니다.");
			$('#EVAL_ITEM_NAME').focus();
			return;
	 } else  if( typeof $(':radio[name="USE_YN"]:checked').val() == "undefined" ){
			confirm("사용유무는 필수 입력항목 입니다.");
			$('#USE_YN').focus();
			return;
	 }
	  
	if(crudBit == "C")   // 신규 insert
	{
		  
		jQuery.ajax({ 
		    url:"/insertEvalItem.do",         
		    type:"POST",
			datatype:"json",
			data: {
				EVAL_ITEM_NAME  : $('#EVAL_ITEM_NAME').val()
				, EVAL_RATE  : $('#EVAL_RATE').val()
				, USE_YN : $(':radio[name="USE_YN"]:checked').val()
			},
			beforeSend : function(xhr) {} ,
			success:function(data,textStatus){  
				btn_search();
				alert('신규 저장 하였습니다.');
		    },
		    complete : function(data) {
		    },
		    error : function(xhr, status, error) {
		           
		    }
		});
		
		btn_new();
		 
	}
	
	if(crudBit == "U")   // 수정 update
	{
 
		jQuery.ajax({ 
		    url:"/updateEvalItem.do",         
		    type:"POST",  
			datatype:"json",
			data: {
				EVAL_ITEM_NAME  : $('#EVAL_ITEM_NAME').val()
				, EVAL_RATE  : $('#EVAL_RATE').val()
				, USE_YN : $(':radio[name="USE_YN"]:checked').val()
				, EVAL_ITEM_NUM  : $('#EVAL_ITEM_NUM').val()
			},
			beforeSend : function(xhr) {} ,
			success:function(data,textStatus){  
				btn_search();
				alert('수정 하였습니다.');
		    },
		    complete : function(data) {
		    },
		    error : function(xhr, status, error) {
		           
		    }
		});
		
	}	
	  
}



function btn_search(){
	  
	var loadData = $("#top_search").serializeAllObject(); 
	     
	var grid = $("#grid1");
	grid.jqGrid('setGridParam', {
		url:"/getEvalItemLst.do",
	    mtype: "POST",
	    datatype: "json",
	    postData: loadData , // page:1,
	    
	}).trigger('reloadGrid');
	 
	//그리드 사이즈 조절
	reSizefn();
	
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

function validYN(cellValue) {
	if(cellValue == '사용'){
        return 'Y';
    }else if(cellValue== '미사용'){
        return 'N';
    }else {
    	return 'U';
    }
}
 
//########################################################
//###   상단 버튼 구현 ( 끝 )   							   ###
//########################################################