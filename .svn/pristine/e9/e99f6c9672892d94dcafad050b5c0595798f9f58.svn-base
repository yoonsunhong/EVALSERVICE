/********************************************************
 *  파일명: AMainDept.js
 * 설명:  부서관리
 * 수정일      	  수정자       수정내용
 * ------------------------------------------------------
 * 2018-03-20     장재민       초기작성 
 * ------------------------------------------------------
 * author	: 장재민
 * since	: 2018.03.20
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
	getCodeListbinding("#top_search select[name=USE_YN]", "CD004");			// 상세 사용여부 
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
	
	jQuery("#athGroupList").jqGrid({ 
		hoverrows: false,
		url:"/aMainDeptList.do",
	    mtype    : 'POST',
	    datatype : 'json',
	    postData: {'A':'A','A':'A'},
	    //postData : { USE_YN : $('#USE_YN').val() },
	    colNames : [ '부서코드', '부서명', '사용여부', '사원수' ],
	   	colModel : [           
	   	    { name:"DEPART_NUM",		width:10,	align:"center", editable:false//, 
//	   	    	formatter:function(cellValue,options,rowObject){
//		            alert(cellValue);
//		            
//		            var rowId = $("#athGroupList").jqGrid('getGridParam', 'selrow');  
//		        	var loData = $("#athGroupList" ).jqGrid('getRowData', rowId);
//		        	
//		        	alert(loData.DEPART_NUM);
//				}
	   	    },
	   		{ name:"DEPART_NAME",	width:10,	align:"center",
	   			editable:true,
	   			edittype:'text',
	   			editoptions:{maxlength: 20}
	   	    },
			{ name:"USE_YN",			width:5,		align:"center",
	   			editable: true,
	   			edittype:'select',
	   			editoptions:{value:"Y:사용;N:미사용"},
	   			formatter:function(cellValue,options,rowObject){
		            if(cellValue == 'Y'){
		                return '사용';
		            }else if(cellValue== 'N'){
		                return '미사용';
		            }
				}
	   		},
 	   		{ name:"USER_COUNT",		align:"center",	hidden:true }
	   	],
	   	emptyrecords: "Nothing to display",
	   	rownumbers: false,
	   	autowidth: true,
		rowNum: 30,
	   	rowList:[10,30,50,100],
	   	
	   	cellEdit:true,
	    cellsubmit:'remote',
	    cellurl:'/updateDept.do',	    
	    
	   	pager: '#ajaxProwed1',	   	
	   	//viewrecords: true,
	    cmTemplate: { sortable: false },
		footerrow:true,
		loadonce: false,
		multiselect: false,
		
		beforeSubmitCell : function(rowid, cellname, value) {   // submit 전
			//alert("before");
			var data = jQuery("#athGroupList").getRowData(rowid);
			return {"DEPART_NUM":data.DEPART_NUM, "DEPART_NAME":data.DEPART_NAME, "USE_YN":validYN(data.USE_YN)};
	    },
	    afterSubmitCell : function(res) {    // 변경 후
			//alert("after");
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
		onSelectRow:function(id) { // athGroupListRowClick,
			//alert("select");
			btn_search_detail1();
			btn_search_detail2();
		},
		ondblClickRow : function(rowId,iCol,cellcontents,e) {   // 상세 팝업 
			//alert("ondblClickRow");
			btn_search_detail1();
			btn_search_detail2();
		},
		success:function(data,textStatus){ 
			
		},
		loadComplete: function() {
			
		},
        //헤더 클릭시 정렬
        onSortCol: function(sidx, colnum, sort_order){ 	//헤더 클릭
	    	//alert(sidx +'|'+ sort_order +'|');
	    	$("#SORTHEADER").val(sidx);
	    	$("#SORT").val(sort_order);
	    	
	    	var grid = $("#athGroupList");
	    	var loadData = $("#top_search").serializeAllObject();
	    	  
	    	grid.jqGrid('setGridParam', {
        		url:"/aMainDeptList.do",
        	    mtype: "POST",
        	    datatype: "json",
        	    postData: loadData ,
        	}).trigger('reloadGrid'); 
	    }
	});
	
	
	jQuery("#appointMenuList").jqGrid({ 
	    hoverrows: false,
		url      : '/aMainDeptInUserListList.do',
	    mtype    : 'POST',
	    datatype : 'json',
	    //postData : { DEPART_NUM : aDEPART_NUM },
	    postData : { 'A':'A', 'A':'A' },
	    colNames : [ '사원코드', '사원명', '상위담당자', '' ],
	   	colModel : [           
	   		{ name : "USER_NUM",  width : 5, align : "center" },
	   		{ name : "USER_NAME",     width : 10, align : "center" },
	   		{ name : "UPUSER_NAME",  width : 10, align : "center" },
	   		{ name:"", width:50, align:"left" }
	   	],
	   	emptyrecords : "Nothing to display",
		rownumbers   : false,
	   	autowidth    : true,
	   	rowNum       : 1000,
	   	multiselect  : true,
	   	sortable     : true,
		loadonce     : true,
		scrollrows: true,
		onSelectRow  : function(id) { //AppointMenuListRowClick,
			
		},
		loadComplete: function() {
			//appointMenuListResize();
		}
	});
	
	jQuery("#notAppointMenuList").jqGrid({ 
	    hoverrows: false,
		url:"/aMainDeptOutUserListList.do",
	    mtype    : 'POST',
	    datatype : 'json',
	    //postData : { DEPART_NUM : aDEPART_NUM },
	    postData : { 'A':'A', 'A':'A' },
	    colNames : [ '사원코드', '사원명', '상위담당자', '' ],
	   	colModel : [           
	   		{ name : "USER_NUM",  width : 5, align : "center" },
	   		{ name : "USER_NAME",     width : 10, align : "center" },
	   		{ name : "UPUSER_NAME",  width : 10, align : "center" },
	   		{ name:"", width:50, align:"left" }
	   	],
	   	emptyrecords : "Nothing to display",
		rownumbers   : false,
	   	autowidth    : true,
	   	rowNum       : 1000,
	   	multiselect  : true,
	   	sortable     : true,
		loadonce     : true,
		scrollrows: true,
		onSelectRow  : function(id) {
	
		},
		loadComplete: function() {
			//notAppointMenuListResize();
		}
	});
	
	//그리드 너비 설정
	$(window).resize(function() {  
		$("#athGroupList").each(function() {
			var grid = $(this);
 			var height = $(window).height() -  430;
 			grid.setGridHeight(height,true);
		});
	}).resize();
	
	//그리드 너비 설정
	$(window).resize(function() {  
		$("#appointMenuList").each(function() {
			var grid = $(this);
			var width = $(window).width()- 508;
 			var height = $(window).height() -   538;
			grid.setGridWidth(width,true);
 			grid.setGridHeight(height,true);
		});
	}).resize();
	
	//그리드 너비 설정
	$(window).resize(function() {  
		$("#notAppointMenuList").each(function() {
			var grid = $(this);
			var width = $(window).width()- 508;
 			var height = $(window).height() -   538;
			grid.setGridWidth(width,true);
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
		        		url:"/aMainDeptList.do",
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
      		url:"/aMainDeptList.do",
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

function btn_read() { //상단바 조회
	btn_search();
}

function btn_delete() { //선택 부서 삭제
	
	var rowId = $("#athGroupList").jqGrid('getGridParam', 'selrow');  
	var loData = $("#athGroupList" ).jqGrid('getRowData', rowId);
	
	var role_id = loData.DEPART_NUM;
	
	if(role_id != '') {
		//var count = $('#athGroupList').getRowData($('#DEPART_NUM').val()).USER_COUNT;
		//var count = $('#athGroupList').getRowData(role_id).USER_COUNT;
		var count = loData.USER_COUNT;
		var msg = '';

		if(count == 0) {
			msg = "[" + loData.DEPART_NAME + "]\n";
			msg += "부서를 삭제 하시겠습니까?";
		} else {
			msg = "[" + loData.DEPART_NAME + "]\n";
			msg += count + "명의 사용자가 부서에 등록되어있습니다.\n";
			msg += "부서를 삭제 하시겠습니까?";
		}
		
//		var role = {};
//		role.DEPART_NUM = $('#DEPART_NUM').val();
//		role.DEPART_NUM = role_id;
//		
//		var postData = JSON.stringify(role);
		
		if(confirm(msg)) {
			$.ajax({
			    type     : "POST",
			    url      : "/deleteDept.do",
			    dataType : "JSON",
			    //data     : postData,
			    data     : loData,
			    async    : true,
			    success  : function(data) {
			    	var aResult = data;			    	
			    	if(aResult >= 1) {
				    	alert("삭제되었습니다.");
						btn_search_detail1();
						btn_search_detail2();
				    	btn_search();
			    	}
			    	else {
			    		alert("에러발생. 삭제가 취소되었습니다.");
			    	}
			    },
			    complete : function(data) {
			    },
			    error    : function(xhr, status, error) {
					alert("에러발생. 삭제가 취소되었습니다.");
			    }
			});
		}
		else {
			alert("삭제가 취소되었습니다.");
		}
	}
}

function btn_update() { //부서 추가
	
	if( $('#DEPART_NAME').val()  == null || $('#DEPART_NAME').val() =="" ){
		confirm("부서명은 필수 입력항목 입니다.");
		$('#DEPART_NAME').focus();
		return;
	} else  if( typeof $(':radio[name="USE_YN"]:checked').val() == "undefined" ){
		confirm("사용유무는 필수 입력항목 입니다.");
		$('#USE_YN').focus();
		return;
	}
	
//	var arrPostData = new Array();
//	
//	/********************************************************************************
//	 ** 부서코드 설정
//	 ********************************************************************************/
//	
//	var role = {};
//	role.DEPART_NUM = '';
//	role.DEPART_NAME = $('#DEPART_NAME').val();
//	
//	role.USE_YN  = $(':radio[name="use"]:checked').val(); //$('input[type="radio"][name="use"][checked="checked"]').val();
//	
//	// alert(role.USE_YN);
//	
//	arrPostData[0] = role;
	
	/********************************************************************************/
	
	
//	$('#appointMenuList .jqgrow').each(function (idx) {
//		var rowData = $('#appointMenuList').getRowData($(this).attr('id'));
//		arrPostData[idx + 1] = rowData;
//	});
//
//	var postData = JSON.stringify(arrPostData);
	
	jQuery.ajax({
	    url : "/addDept.do", // updateDept.do
	    type : "POST",
		datatype:"json",
	    //data     : postData,
	    data : {	DEPART_NAME : $('#DEPART_NAME').val()
	    		 	,USE_YN : $(':radio[name="USE_YN"]:checked').val() 
	    },
	    async    : true,
	    success  : function(data) {
	    	alert("저장되었습니다.");
	    	btn_search();
	    	btn_new();
	    },
	    complete : function(data) {
	    },
	    error    : function(xhr, status, error) {
	    	  
//				          alert("에러발생");
	    }
	});
}

function btn_down() { //선택부서원 부서 미지정
	
	//var ARRAY_DATA = new Array();
	var checkRowIds = $("#appointMenuList").jqGrid('getGridParam', 'selarrrow'); 
	
	if( checkRowIds.length < 1) {
		alert("부서 미지정 할 사원을 선택하세요.");
		return;
	}
	
	if(confirm("선택하신 사원을 미지정 하시겠습니까?") == false) return;	 
	
//	for(var i=0; i < checkRowIds.length; i++){
//		var loadData = $("#appointMenuList" ).jqGrid('getRowData', checkRowIds[i]);
//		ARRAY_DATA[i] = loadData.USER_NUM;
//		//ARRAY_DATA[i] = loadData;
//		
//		//alert(loadData.USER_NUM); 
//	}  
//	
//	loadData.ARRAY_DATA = ARRAY_DATA;
//	jQuery.ajaxSettings.traditional = true;
//	jQuery.ajax({
//	    type:"POST", 
//	    url:"/deleteDeptUser.do",
//	    dataType:"JSON",
//	    data: loadData,
//	    success : function(data) {
//	    	//alert("삭제되었습니다.");
//	    	btn_search_detail1();
//	    	btn_search_detail2();
//	    	btn_search();
//	    },
//	    complete : function(data) {
//	    },
//	    error : function(xhr, status, error) {
//	    	//flag = false;
//	    	alert("에러발생");
//	    }
//	});
	
	for(var i=0; i < checkRowIds.length; i++){		
		var loadData = $("#appointMenuList" ).jqGrid('getRowData', checkRowIds[i]);		
		
		jQuery.ajax({
		    type:"POST", 
		    url:"/deleteDeptOneUser.do",
		    dataType:"JSON",
//		    data: loadData,
		    data: {USER_NUM	: loadData.USER_NUM},
		    success : function(data) {
		    	//alert("삭제되었습니다.");
		    	btn_search_detail1();
		    	btn_search_detail2();
		    	//btn_search();
		    },
		    complete : function(data) {
		    },
		    error : function(xhr, status, error) {
		    	alert("에러발생 : " + error);
		    }
		});
	}
}

function btn_up() { //선택 미지정부서원 부서 지정
	
	//var ARRAY_DATA = new Array();
	
	var checkRowIds = $("#notAppointMenuList").jqGrid('getGridParam', 'selarrrow'); 
	
	if( checkRowIds.length < 1) {
		alert("부서 지정할 사원을 선택하세요.");
		return;
	}	

	var rowId = $("#athGroupList").jqGrid('getGridParam', 'selrow');  
	var loData = $("#athGroupList" ).jqGrid('getRowData', rowId);
	
	if( loData.DEPART_NUM == undefined) {
		alert("부서를 선택하세요.");
		return;
	}	
	
	if(confirm("선택하신 사원을 [" + loData.DEPART_NAME + "] 부서로 배치 하시겠습니까?") == false) return;	 
	
//	for(var i=0; i < checkRowIds.length; i++){
//		var loadData = $("#notAppointMenuList" ).jqGrid('getRowData', checkRowIds[i]);
//		ARRAY_DATA[i] = loadData.USER_NUM;
//		//ARRAY_DATA[i] = loadData;
//	}  
//	
//	//loadDate.DEPART_NUM =  loData.DEPART_NUM;
//	loadDate.ARRAY_DATA = ARRAY_DATA;
//	jQuery.ajaxSettings.traditional = true;
//	jQuery.ajax({
//	    type:"POST", 
//	    url:"/saveDeptUser.do",
//	    dataType:"JSON",
//	    data: loData,
//	    success : function(data) {
//	    	//alert("삭제되었습니다.");
//	    	btn_search_detail1();
//	    	btn_search_detail2();
//	    	btn_search();
//	    },
//	    complete : function(data) {
//	    },
//	    error : function(xhr, status, error) {
//	    	flag = false;
////	    	alert("에러발생");
//	    }
//	});
	
	for(var i=0; i < checkRowIds.length; i++){
		var loadData = $("#notAppointMenuList" ).jqGrid('getRowData', checkRowIds[i]);
		
		jQuery.ajax({
		    type:"POST", 
		    url:"/saveDeptOneUser.do",
		    dataType:"JSON",
		    data: {
		    	DEPART_NUM	: loData.DEPART_NUM
		    	, USER_NUM	: loadData.USER_NUM
		    },
		    success : function(data) {
		    	//alert("삭제되었습니다.");
		    	btn_search_detail1();
		    	btn_search_detail2();
		    	//btn_search();
		    },
		    complete : function(data) {
		    },
		    error : function(xhr, status, error) {
		    	alert("에러발생 : " + error);
		    }
		});
	}  
}

function btn_new()
{
	$('#DEPART_NUM').val(""); 
	$('#DEPART_NAME').val("");   
	$("input:radio[name='USE_YN']").removeAttr('checked'); 
}

//########################################################
//###   사용자 정의 함수 ( 끝 )     						   ###
//########################################################
 
//########################################################
//###   grid 이벤트 ( 시작 )   							   ###
//########################################################

function btn_search(){

	var loadData = $("#top_search").serializeAllObject(); 
	   
	var grid = $("#athGroupList");
	grid.jqGrid('setGridParam', {
		url:"/aMainDeptList.do",
	  mtype: "POST",
	  datatype: "json",
	  postData: loadData , // page:1,
	  
	}).trigger('reloadGrid');
	
	//그리드 사이즈 조절
	//athGroupListResize();
	reSizefn();
}

function btn_search_detail1( ){
	
	//alert("init btn_search_detail1");
	
	var rowId = $("#athGroupList").jqGrid('getGridParam', 'selrow');  
	var loData = $("#athGroupList" ).jqGrid('getRowData', rowId);
	
	var grid = $("#appointMenuList");
	grid.jqGrid('setGridParam', {
		url:"/aMainDeptInUserListList.do",
	  mtype: "POST",
	  datatype: "json",
	  postData: {DEPART_NUM:loData.DEPART_NUM} , // page:1, 
	}).trigger('reloadGrid');
}

function btn_search_detail2( ){
	
	//alert("init btn_search_detail1");
	
	//var rowId = $("#athGroupList").jqGrid('getGridParam', 'selrow');  
	//var loData = $("#athGroupList" ).jqGrid('getRowData', rowId);
	
	var grid = $("#notAppointMenuList");
	grid.jqGrid('setGridParam', {
		url:"/aMainDeptOutUserListList.do",
	  mtype: "POST",
	  datatype: "json",
	  //postData: {DEPART_NUM:loData.DEPART_NUM} , // page:1, 
	  postData: {DEPART_NUM:''} , // page:1, 
	}).trigger('reloadGrid');
}

//########################################################
//###   grid 이벤트 ( 끝 )     							   ###
//########################################################
 
//########################################################
//###   로우 클릭시 팝업  구현 ( 시작 )    					   ###
//########################################################

//function btn_close(){ 
//	// btn_search();
//	$("#pop_wrap").dialog( "close" );
//}




//
//getCodeListbinding("#top_search select[name=USE_YN]", "CD004");			// 상세 사용여부
//
//function athGroupListResize() {
//	var height = $(window).height() - $('.btn_area').height() - $('.box_form').height() - $('.tbl_st2').height() - 154;
//	
//	// 부서 목록
//	/* $('#gbox_athGroupList').parents('div.ui-jqgrid-bdiv').css("height", height + "px");
//	$('#gbox_athGroupList').css("height", height + "px"); */
//	$('#athGroupList').setGridHeight(height, true);
//}
//
//function appointMenuListResize() {
//	var element = $("#appointMenuList");
//	
//	var width = $(window).width() - 408;
//	var height = parseInt($('.box_lft').css('height')) / 2 - 94;
//	
//	element.setGridWidth(width, true);
//	element.setGridHeight(height, true);
//} 
//
//function notAppointMenuListResize() {
//	var element = $("#notAppointMenuList");
//	
//	var width = $(window).width() - 408;
//	var height = parseInt($('.box_lft').css('height')) / 2 - 94;
//	
//	element.setGridWidth(width, true);
//	element.setGridHeight(height, true);
//}
//
//
//	$( window ).resize(function() {
//	athGroupListResize();
//	appointMenuListResize();
//	notAppointMenuListResize();
//});
//	
//	
//
//$(document).ready(function () {
//	
//	readAthGroupList();
//	
//	// 신규버튼 클릭
//	$('#btn_create').click(function () {
//		
//		// 부서 목록 초기화
//		$('#athGroupList').resetSelection();
//		
//		$('#DEPART_NUM').val('');
//		$('#DEPART_NAME').val('');
//		$('input[type="radio"][name="use"][value="Y"]').attr('checked', true);
//		
//		
//		// 부서있는 사원 목록
//		$("#appointMenuList").jqGrid("GridUnload");
//		$("#appointMenuList").jqGrid('clearGridData');
//		readAppointMenuList('');
//		
//		// 부서없는 사원  목록
//		$("#notAppointMenuList").jqGrid('clearGridData');
//		$("#notAppointMenuList").jqGrid("GridUnload");
//		
//		readNotAppointMenuList('');
//		
//	});
//	
//	
//	// 저장버튼 클릭
//	$('#btn_update').click(function () {
//		
//		if(validationCheck()) {
//			var arrPostData = new Array();
//			
//			/********************************************************************************
//			 ** 부서코드 설정
//			 ********************************************************************************/
//			
//			var role = {};
//			role.DEPART_NUM = '';
//			role.DEPART_NAME = $('#DEPART_NAME').val();
//			
//			role.USE_YN  = $(':radio[name="use"]:checked').val(); //$('input[type="radio"][name="use"][checked="checked"]').val();
//			
//			// alert(role.USE_YN);
//			
//			arrPostData[0] = role;
//			
//			/********************************************************************************/
//			
//			
//			$('#appointMenuList .jqgrow').each(function (idx) {
//				var rowData = $('#appointMenuList').getRowData($(this).attr('id'));
//				arrPostData[idx + 1] = rowData;
//			});
//
//			var postData = JSON.stringify(arrPostData);
//			
//			console.log(postData);
//			$.ajax({
//			    type     : "POST",
//			    url      : "/saveDept.do", // updateDept.do
//			    dataType : "JSON",
//			    data     : postData,
//			    async    : true,
//			    success  : function(data) {
//			    	alert("저장되었습니다.");
//			    	$("#athGroupList").jqGrid("GridUnload");
//					readAthGroupList();
//			    },
//			    complete : function(data) {
//			    },
//			    error    : function(xhr, status, error) {
//			    	  
////					          alert("에러발생");
//			    }
//			});
//		}
//		
//	});
//	
//	
//	// 조회버튼 클릭
//	$('#btn_read').click(function () {
//		
//		$("#athGroupList").jqGrid("GridUnload");
//		readAthGroupList();
//		
//	});
//	
//	// 삭제 버튼 클릭
//	$('#btn_delete').click(function () {
//		
//		var rowId = $("#athGroupList").jqGrid('getGridParam', 'selrow');  
//		var loData = $("#athGroupList" ).jqGrid('getRowData', rowId);
//		
//		var role_id = loData.DEPART_NUM;
//		
//		if(role_id != '') {
//			//var count = $('#athGroupList').getRowData($('#DEPART_NUM').val()).USER_COUNT;
//			var count = $('#athGroupList').getRowData(role_id).USER_COUNT;
//			var msg = '';
//
//			if(count == 0) {
//				msg = '부서를 삭제 하시겠습니까?';
//			} else {
//				msg = count + '명의 사용자가 부서에 등록되어있습니다.\n';
//				msg += '부서를 삭제 하시겠습니까?';
//			}
//			
//			var role = {};
//			role.DEPART_NUM = $('#DEPART_NUM').val();
//			role.DEPART_NUM = role_id;
//			
//			var postData = JSON.stringify(role);
//			
//			if(confirm(msg)) {
//				
//				$.ajax({
//				    type     : "POST",
//				    url      : "/deleteDept.do",
//				    dataType : "JSON",
//				    data     : postData,
//				    async    : true,
//				    success  : function(data) {
//				    	alert('삭제되었습니다.');
//				    	$("#athGroupList").jqGrid("GridUnload");
//						readAthGroupList();
//				    },
//				    complete : function(data) {
//				    },
//				    error    : function(xhr, status, error) {
//				    	  
////						          alert("에러발생");
//				    }
//				});
//				
//				
//			}
//			else {
//				alert('삭제가 취소되었습니다.');
//			}
//		}
//		
//		
//		
//	});
//	
//	
//	// 부서가 지정안 된 사원 목록을 지정 메뉴 목록으로 이동
//	$('.btn_up').click(function() {
//		
//		var sel = $('#notAppointMenuList').jqGrid('getGridParam', 'selarrrow');      // 참조형 데이터
//		var arrSel = new Array();                                                    // 참조형 데이터를 값 복사를 할 배열 선언
//		
//		for(var i=0; i<sel.length; i++) {
//			
//			var rowData = $('#notAppointMenuList').getRowData(sel[i]);
//			
//			$("#appointMenuList").jqGrid('addRow', {
//	           rowID : sel[i],              //중복되지 않게 rowid설정
//	           initdata : { USER_NUM : rowData.USER_NUM, USER_NAME : rowData.USER_NAME, UPUSER_NAME : rowData.UPUSER_NAME },
//	           position :"last",           //first, last
//	           useDefValues : false,
//	           useFormatter : false,
//	           addRowParams : {extraparam:{}}
//			});
//			
//			
//			//$('#appointMenuList tr[id="'+ sel[i] +'"]').attr('aria-selected', false).removeClass('ui-state-highlight');
//			// 선택 초기화
//			//$('#appointMenuList').resetSelection();
//			
//			arrSel[i] = sel[i];
//			
//		}
//		
//		// 로우 삭제
//		for(var i=0; i<arrSel.length; i++) {
//			$('#notAppointMenuList').delRowData(arrSel[i]);
//		}
//		
//	});
//	
//	// 부서가 지정된 사원 목록을 부서가 지정안 된 사원 목록으로 이동
//	$('.btn_down').click(function() {
//		
//		var sel = $('#appointMenuList').jqGrid('getGridParam', 'selarrrow');      // 참조형 데이터
//		var arrSel = new Array();                                                 // 참조형 데이터를 값 복사를 할 배열 선언
//		
//		console.log('선택된 로우 : ' + sel);
//		
//		for(var i=0; i<sel.length; i++) {
//			
//			var rowData = $('#appointMenuList').getRowData(sel[i]);
//			
//			console.log(rowData);
//			
//			// 로우 추가
//			$("#notAppointMenuList").jqGrid('addRow', {
//	           rowID : sel[i],              //중복되지 않게 rowid설정
//	           initdata : { USER_NUM : rowData.USER_NUM, USER_NAME : rowData.USER_NAME, UPUSER_NAME : rowData.UPUSER_NAME },
//	           position :"last",           //first, last
//	           useDefValues : false,
//	           useFormatter : false,
//	           addRowParams : {extraparam:{}}
//			});
//			
//			arrSel[i] = sel[i];
//			
//		}
//		
//		// 로우 삭제
//		for(var i=0; i<arrSel.length; i++) {
//			$('#appointMenuList').delRowData(arrSel[i]);
//		}
//	});
//	
//	
//});
//
//// 부서 목록 그리드
//function readAthGroupList() {
//
//	$("#athGroupList").jqGrid({ 
//		hoverrows: false,
//		url:"/aMainDeptList.do",
//	    mtype    : 'POST',
//	    datatype : 'json',
//	    //postData: {'A':'A','A':'A'},
//	    postData : { USE_YN : $('#USE_YN').val() },
//	    colNames : [ '부서코드', '부서명', '사용여부', '사원수' ],
//	   	colModel : [           
//	   	    { name:"DEPART_NUM",		width:10,	align:"center" },
//	   		{ name:"DEPART_NAME",	width:10,	align:"center",
//	   			editable:true,
//	   			edittype:'text',
//	   			editoptions:{maxlength: 20}
//	   	    },
//			{ name:"USE_YN",			width:5,		align:"center",
//	   			editable: true,
//	   			edittype:'select',
//	   			editoptions:{value:"Y:사용;N:미사용"},
//	   			formatter:function(cellValue,options,rowObject){
//		            if(cellValue == 'Y'){
//		                return '사용';
//		            }else if(cellValue== 'N'){
//		                return '미사용';
//		            }
//				}
//	   		},
// 	   		{ name:"USER_COUNT",		align:"center",	hidden:true }
//	   	],
//	   	
//	   	emptyrecords: "Nothing to display",
//	   	rownumbers: false,
//	   	autowidth: true,
//		rowNum: 30,
//	   	rowList:[10,30,50,100],
//	   	
//	   	cellEdit:true,
//	    cellsubmit:'remote',
//	    cellurl:'/updateDept.do',
//		
//	   	pager: '#ajaxProwed1',
//	   	//viewrecords: true,
//	    cmTemplate: { sortable: false },
//		footerrow:true,
//		loadonce: false,
//		multiselect: false,
//		
//		beforeSubmitCell : function(rowid, cellname, value) {   // submit 전
//			var data = jQuery("#athGroupList").getRowData(rowid);
//			//a00lert(data.EVAL_ITEM_NAME + ", " + data.EVAL_RATE + ", " + data.USE_YN + ", " + data.EVAL_ITEM_NUM);
//			return {"DEPART_NUM":data.DEPART_NUM, "DEPART_NAME":data.DEPART_NAME, "USE_YN":validYN(data.USE_YN)};
//	    },
//	    afterSubmitCell : function(res) {    // 변경 후
//	         var aResult = $.parseJSON(res.responseText);
//	         var userMsg = "";
//	         if(!(aResult == 1)) {
//	        	 userMsg = "오류가 발생했습니다.";
//	         }
//	         //그리드2 재조회 (푸터 합계 계산)
//	         btn_search();
//	         
//	         //서브밋결과를 반드시 리턴 해줘야 한다. 안그럼 javascript 오류 발생
//	         return [(aResult == 1) ? true : false, userMsg];
//	    },
//		//athGroupListRowClick,
//		onSelectRow : function(id){
//			btn_search_detail1();
//		},	
//		ondblClickRow : function(rowId,iCol,cellcontents,e) {   // 상세 팝업 
//			
//		},
//		success:function(data,textStatus){ 
//			
//		},
//		loadComplete: function(data) {
////			var firstRowId = $('#athGroupList .jqgfirstrow').next().attr('id');
////			//$('#' + firstRowId).attr('aria-selected', true).addClass('ui-state-highlight').attr('tabindex', '0');
////			$("#athGroupList").jqGrid('setSelection', firstRowId);
////			// athGroupListRowClick(firstRowId);
////			athGroupListResize();
//		}
//	});
//	
//}
//

//	 
//	//그리드 사이즈 조절
//	reSizefn();
// 
//}
//
///*********************************************************************************************************************************************
// ** 부서목록을 보여주는 그리드의 행을 클릭했을경우 발생하는 함수(이벤트)
// *********************************************************************************************************************************************/
//
//function athGroupListRowClick(id) {
//	var rowData = $('#athGroupList').getRowData(id);
//	
////	// 현재 선택된 부서에 대한 자세한 정보를 표시한다.
////	$('#DEPART_NUM').val(id);
////	$('#DEPART_NAME').val(rowData.DEPART_NAME);
////	
////	if(rowData.USE_YN == "사용"){
////		$("input:radio[name='use']:radio[value='Y']").attr("checked",true);
////	}else if(rowData.USE_YN == "미사용"){
////		$("input:radio[name='use']:radio[value='N']").attr("checked",true);
////	}
//
//	
//	// 현재 선택된 부서에 속해있는 사원 목록을 읽어온다. 
//	$("#appointMenuList").jqGrid("GridUnload");
//	//readAppointMenuList($('#DEPART_NUM').val());
//	readAppointMenuList(rowData.DEPART_NUM);
//	
//	// 현재 선택된 부서에 속해있지 않은 사원 목록을 읽어온다.
//	$("#notAppointMenuList").jqGrid("GridUnload");
//	//readNotAppointMenuList($('#DEPART_NUM').val());
//	readNotAppointMenuList(rowData.DEPART_NUM);
//}
//
///*********************************************************************************************************************************************/
//
//// 부서 지정된 사원 목록 그리드
//function readAppointMenuList(aDEPART_NUM) {
//
//	$('#appointMenuList').jqGrid({ 
//		    hoverrows: false,
//		url      : '/aMainDeptInUserListList.do',
//	    mtype    : 'POST',
//	    datatype : 'json',
//	    postData : { DEPART_NUM : aDEPART_NUM },
//	    colNames : [ '사원코드', '사원명', '상위담당자' ],
//	   	colModel : [           
//	   		{ name : "USER_NUM",  width : 100, align : "center" },
//	   		{ name : "USER_NAME",     width : 100, align : "center" },
//	   		{ name : "UPUSER_NAME",  width : 100, align : "center" }
//	   	],
//	   	emptyrecords : "Nothing to display",
//		rownumbers   : false,
//	   	autowidth    : true,
//	   	rowNum       : 1000,
//	   	multiselect  : true,
//	   	sortable     : true,
//		loadonce     : true,
//		scrollrows: true,
//		onSelectRow  : AppointMenuListRowClick,
//		loadComplete: function() {
//			
//			appointMenuListResize();
//		}
//	});
//}
//
//function AppointMenuListRowClick(id) {
//
//}
//
//// 부서가 미지정된 사원 목록
//function readNotAppointMenuList(aDEPART_NUM) {
//	
//	jQuery("#notAppointMenuList").jqGrid({ 
//		    hoverrows: false,
//		url:"/aMainDeptOutUserListList.do",
//	    mtype    : 'POST',
//	    datatype : 'json',
//	    postData : { DEPART_NUM : aDEPART_NUM },
//	    colNames : [ '사원코드', '사원명', '상위담당자' ],
//	   	colModel : [           
//	   		{ name : "USER_NUM",  width : 100, align : "center" },
//	   		{ name : "USER_NAME",     width : 100, align : "center" },
//	   		{ name : "UPUSER_NAME",  width : 100, align : "center" }
//	   	],
//	   	emptyrecords : "Nothing to display",
//		rownumbers   : false,
//	   	autowidth    : true,
//	   	rowNum       : 1000,
//	   	multiselect  : true,
//	   	sortable     : true,
//		loadonce     : true,
//		scrollrows: true,
//		onSelectRow  : function(id) {
//
//		},
//		loadComplete: function() {
//			
//			notAppointMenuListResize();
//			
//		}
//	});
//	
//}
