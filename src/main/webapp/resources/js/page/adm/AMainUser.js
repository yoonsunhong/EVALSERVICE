/********************************************************
 *  파일명: AMainUser.js
 * 설명:  사원관리
 * 수정일      	  수정자       수정내용
 * ------------------------------------------------------
 * 2018-03-20     장재민       초기작성 
 * ------------------------------------------------------
 * author	: 장재민
 * since	: 2018.03.20
 * version : 1.0
 ********************************************************/
var pageClean = null;

var uploadcheck = "";

$(document).ready(function(){
	initData();								// 1. 최초 DB에서 세팅헤 필요한 데이터를 가져온다.
	initElementBinding();					// 2. 초기 HTML ELEMENT BINDING
	setFormElementValue();				// 3. FORM ELEMENT 초기값 세팅
	saveFormElementValue();				// 4. FORM ELEMENT 초기값 저장
	applyFormElementJquery();			// 5. FORM ELEMENT 공통 JQUERY 적용
	addFormElementJqueryEvent();		// 6. FORM ELEMENT JQUERY EVENT 등록
	initGrid();								// 7. GRID 초기화
	init();										// 8. init Start
});

var gridDEPART_NUM = "";		// 그리드 부서리스트
var gridGRADE_NAME = "";		// 그리드 직급리스트
var gridDUTY_NAME = "";		// 그리드 직책리스트
var gridUPUSER_NUM = "";		// 그리드 사원리스트


//########################################################
//###	1. 최초 DB에서 세팅에 필요한 데이터를 가져온다 ( 시작 )          ###
//########################################################
function initData() {
	
	getDeptCodeListbinding("#top_search select[name=DEPART_NUM]");		// 상단 부서구분
	getCodeListbinding("#top_search select[name=GRADE_NAME]", "CD002");		// 상단 직급구분
	getCodeListbinding("#top_search select[name=DUTY_NAME]", "CD003");		// 상단 직책구분
	getCodeListbinding("#top_search select[name=USE_YN]", "CD004");	// 상단 사용여부
	
	getDeptCodeListbinding("#pop_wrap select[name=DEPART_NUM]");		// 상세 부서구분
	getCodeListbinding("#pop_wrap select[name=GRADE_NAME]", "CD002");		// 상세 직급구분
	getCodeListbinding("#pop_wrap select[name=DUTY_NAME]", "CD003");		// 상세 직책구분
	getUserCodeListbinding("#pop_wrap select[name=UPUSER_NUM]");		// 상세 직책구분
	getCodeListbinding("#pop_wrap select[name=USE_YN]", "CD004");			// 상세 사용여부
	
	getDeptCodeListGrid();		// 그리드 부서리스트 설정
	getGradeNameListGrid();	// 그리드 직급리스트 설정
	getDutyNameListGrid();		// 그리드 직책리스트 설정
	getUserCodeListGrid();		// 그리드 사원리스트 설정
	
}
//########################################################
//###	1. 최초 DB에서 세팅에 필요한 데이터를 가져온다 ( 끝 )     	   ###
//########################################################

function getDeptCodeListGrid(){
	
	gridDEPART_NUM = "";
	var postValue = {};

	// 부서코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/selectDeptCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    async:false,
	    success : function(data) {
	    	gridDEPART_NUM = ":미지정";
	    	$.each(data.rows, function(key, value) {
	    		gridDEPART_NUM += ";" + this.cell[1] + ":" + this.cell[0];
	    	});
	    },
	    complete : function(data) {},
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
}

function getGradeNameListGrid(){	
	
	gridGRADE_NAME = "";
	var postValue = {"GRADE_ITEM_TYPE_CODE":"CD002"};
	
	// 부서코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/selectAreaCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    async:false,
	    success : function(data) {
	    	$.each(data.rows, function(key, value) {   
	    		if(key != 0) {
	    			gridGRADE_NAME += ";";
	    		}	    		
	    		gridGRADE_NAME += this.cell[0] + ":" + this.cell[0];
	    	});
	    },
	    complete : function(data) {},
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
}

function getDutyNameListGrid(){	
	
	gridDUTY_NAME = "";
	var postValue = {"GRADE_ITEM_TYPE_CODE":"CD003"};
	
	// 부서코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/selectAreaCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    async:false,
	    success : function(data) {
	    	$.each(data.rows, function(key, value) {   
	    		if(key != 0) {
	    			gridDUTY_NAME += ";";
	    		}	    		
	    		gridDUTY_NAME += this.cell[0] + ":" + this.cell[0];
	    	});
	    },
	    complete : function(data) {},
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
}

function getUserCodeListGrid(){
	
	gridUPUSER_NUM = "";
	var postValue = {};
	 
	// 지역코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/selectUserCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    async:false,
	    success : function(data) {
	    	$.each(data.rows, function(key, value) {   
	    		gridUPUSER_NUM = ":미지정";
		    	$.each(data.rows, function(key, value) {
		    		gridUPUSER_NUM += ";" + this.cell[0] + ":" + this.cell[0];
		    	});
	    	});
	    },
	    complete : function(data) {},
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
}

//########################################################
//###	2. 초기 HTML ELEMENT BINDING ( 시작 )  			   ###
//########################################################
function initElementBinding() {

}
//########################################################
//###	2. 초기 HTML ELEMENT BINDING ( 끝 )       	       ###
//########################################################




//########################################################
//###	3. FORM ELEMENT 초기값 세팅 ( 시작 )    			   ###
//########################################################
function setFormElementValue() {
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


//사용여부 코드를 가져온다.
//getCodeListbinding("#top_search select[name=USE_YN]", "CD0007");

//########################################################
//###	3. FORM ELEMENT 초기값 세팅 ( 끝 )      			   ###
//########################################################





//########################################################
//###	4. FORM ELEMENT 초기값 저장 ( 시작 )    			   ###
//########################################################
function saveFormElementValue() {
	pageClean = $("#pop_cnt ").serializeAllObject();
}
//########################################################
//###	4. FORM ELEMENT 초기값 저장 ( 끝 )      			   ###
//########################################################





//########################################################
//###	5. FORM ELEMENT 공통 JQUERY 적용 ( 시작 )    		   ###
//########################################################
function applyFormElementJquery() {
	$("#top_search").applyCommJquery();
	$("#pop_cnt").applyCommJquery();
	
	
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
	
	
	//페이지 로딩시 최초 로딩
	var loadData = $("#top_search").serializeAllObject();
	loadData.PAGE = 1;
    loadData.ROW_LIST = 30;
	
	//검색 리스트 총 개수
	jQuery.ajax({
	    type:"POST",
	    url:"/aMainUserManageTotal.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data: loadData,
	    success : function(data) {
	    	if(data.TOTAL_CNT != null){
	    		var TOTAL_CNT =  data.TOTAL_CNT.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	    		$('#TOTAL_CNT').text(TOTAL_CNT);
	    	}
	    },
	    complete : function(data) {
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
	
	
	//그리드1 셋팅
	jQuery("#grid1").jqGrid({ 
		hoverrows: false,
		url:"/aMainUserManageList.do",
	    mtype: "POST",
	    datatype: "json",
	    postData: loadData, 
	    page:1,
	    colNames:[
	              "RN_NUM"
	            , "사번"  
				, "사원명"
				, "부서코드"
				, "부서명"
				, "직급"
				, "직책"
				, "상위관리자"
				, "사용여부"
				, "등록일자"
				,""
              ],
      colModel:[           
				  {name:"RN_NUM", width:30, align:"center"}
				, {name:"USER_NUM", width:70, align:"center"}
				//, {name:"USER_NAME", width:100, align:"center"}
		   		, {name:"USER_NAME",	width:100,	align:"center",
		   			editable:true,
		   			edittype:'text',
		   			editoptions:{maxlength: 10}
		   	    }
				//, {name:"DEPART_NUM", width:100, align:"center"}
				, {name:"DEPART_NUM", width:100, align:"center",
		   			editable: true,
		   			edittype:'select',
		   			editoptions:{value:gridDEPART_NUM}
		   		}		
				, {name:"DEPART_NAME", width:100, align:"center"}
				//, {name:"GRADE_NAME", width:100, align:"center"}
				, {name:"GRADE_NAME", width:100, align:"center",
		   			editable: true,
		   			edittype:'select',
		   			editoptions:{value:gridGRADE_NAME}
		   		}	
				//, {name:"DUTY_NAME", width:100, align:"center"}
				, {name:"DUTY_NAME", width:100, align:"center",
		   			editable: true,
		   			edittype:'select',
		   			editoptions:{value:gridDUTY_NAME}
		   		}	
				//, {name:"UPUSER_NAME", width:100, align:"center"}
				, {name:"UPUSER_NAME", width:100, align:"center",
		   			editable: true,
		   			edittype:'select',
		   			editoptions:{value:gridUPUSER_NUM}
		   		}		
//				, {name:"USE_YN",  width:50,   align:"center", formatter : function(cellValue,options,rowObject){
//	                if(cellValue == 'Y'){
//	                    return '사용';
//	                }else if(cellValue== 'N'){
//	                    return '미사용';
//	                }
//	             }}
				, { name:"USE_YN", width:50, align:"center",
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
		   		}
				, {name:"USER_DATE", width:50, align:"center"}
				, {name:"", width:150, align:"center"}
				],
				
		emptyrecords: "Nothing to display",
		rownumbers: false,
	   	autowidth: true,
	   	rowNum: 30,
	 	rowList:[10,30,50,100],
	 	
//	   	pager: '#ajaxProwed1',
//	   	sortable: true,
//		loadonce: false,
//		multiselect: true,
	 	
	   	cellEdit:true,
	    cellsubmit:'remote',
	    cellurl:'/updateAMainUser.do',	    
	    
	   	pager: '#ajaxProwed1',	   	
	   	//viewrecords: true,
	    cmTemplate: { sortable: true },
		footerrow:true,
		loadonce: false,
		//multiselect: true,
		multiselect: true,
		
		beforeSubmitCell : function(rowid, cellname, value) {   // submit 전
			var data = jQuery("#grid1").getRowData(rowid);
			return {
				"USER_NUM":data.USER_NUM
				, "USER_NAME":data.USER_NAME
				, "DEPART_NUM":data.DEPART_NUM
				, "DEPART_NAME":data.DEPART_NAME
				, "GRADE_NAME":data.GRADE_NAME
				, "DUTY_NAME":data.DUTY_NAME
				, "UPUSER_NAME":data.UPUSER_NAME
				, "USE_YN":validYN(data.USE_YN)
				, "USER_DATE":data.USER_DATE
			};
			
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
		onSelectRow:function(id) { 
			
		},
		//ondblClickRow: grid1_dbClickRow,
		ondblClickRow: function(data) {
  
		},
//		beforeSelectRow: function(rowid, e) {
//	         var $mygrid = $(this);
//	         i = $.jgrid.getCellIndex($(e.target).closest('td')[0] );
//	         cm = $mygrid.jqGrid('getGridParam','colModel');
//	         return(cm[i].name == "cb"); 
//	    },
		loadComplete: function(data) {
  
		},
		//페이지 아작스 호출
		onPaging: function (pgButton) {
            // 현재 페이징 확인용 
            var newUserValue = $('input.ui-pg-input', "#ajaxProwed1").val();
            
            if(newUserValue == 0){
            	alert("존재하지 않는 페이지 입니다.");
                return;
            }
            //앞으로 이동할 페이지
            var newValue = 1;
            var currentValue = $("#grid1").getGridParam('page');
            if (pgButton.indexOf("next") >= 0){
            	 newValue = currentValue;
            }else if (pgButton.indexOf("prev") >= 0){
            	 newValue = currentValue ;
            }else if (pgButton.indexOf("last") >= 0){
            	newValue = $("#grid1").getGridParam('lastpage');
            }else if (pgButton.indexOf("first") >= 0){
            	newValue = 1;
            }else if (pgButton.indexOf("user") >= 0){
            	newValue = newUserValue;
            }
            
            var grid = $("#grid1");
            var loadData = $("#top_search").serializeAllObject();
            /** 조회시 필요한 조건*/
            loadData.PAGE = newValue;
            loadData.ROW_LIST = $("#grid1").getGridParam('rowNum');
            /** 조회시 필요한 조건*/
        	grid.jqGrid('setGridParam', {
        		url:"/aMainUserManageList.do",
        	    mtype: "POST",
        	    datatype: "json",
        	    postData: loadData ,
        	    page:newValue,
        	}).trigger('reloadGrid');
        },
        
        //헤더 클릭시 정렬
        onSortCol: function(sidx, colnum, sort_order){ 	//헤더 클릭
	    	$("#SORTHEADER").val(sidx);
	    	$("#SORT").val(sort_order);
	    	
	    	var grid = $("#grid1");
	    	/** 조회시 필요한 조건*/
	    	var loadData = $("#top_search").serializeAllObject();
	    	/** 조회시 필요한 조건*/
	    	grid.jqGrid('setGridParam', {
        		url:"/aMainUserManageList.do",
        	    mtype: "POST",
        	    datatype: "json",
        	    postData: loadData ,
        	}).trigger('reloadGrid');
	    }
	}); 
	
	//그리드 너비 설정
	$(window).resize(function() {
		$("#grid1").each(function() {
			var grid = $(this);
			var width = $(".grid_area").parent().width() -2;
			var height = $(window).height() - 252;
			if(height < 115 ){
				height = 115;
			}
			grid.setGridWidth(width,true);
			grid.setGridHeight(height,true);
		});
	}).resize();
	
}
//########################################################
//###	7. grid 초기화 ( 끝 )     						   ###
//########################################################


//########################################################
//###	7. grid 페이징을 위한 함수 ( 시작 )     						   ###
//########################################################

//그리드 페이징의 이동 버튼 클릭시 아작스 호출
function goPage(val){
	
	// 현재 페이징 확인 
	var newUserValue = $('input.ui-pg-input', "#ajaxProwed1").val();
	if(newUserValue == 0){
		alert("존재하지 않는 페이지 입니다.");
		return;
	}
	
	var flag = val.id;
	var maxPage1 = 0;
	var movePage1 = 0;
	
	if(flag == 'ajaxProwed1'){
		
		//셀렉트박스 선택 초기화
		//grid1.bChkAll = false;
	    //grid1.checkRowIds.length = 0;
		
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
      		url:"/aMainUserManageList.do",
      	    mtype: "POST",
      	    datatype: "json",
      	    postData: loadData ,
      	    page:movePage1,
      	}).trigger('reloadGrid');

		}
	}
}
//########################################################
//###	7. grid 페이징을 위한 함수 ( 끝 )     						   ###
//########################################################


//########################################################
//###	8. init ( 시작 )   							   ###
//########################################################
function init() {
	
	
	
	//초기 그리드 사이즈 조절
	$(function() {
		$(window).resize(function() {
			var grid = $("#grid1");
			var width = $(".grid_area").parent().width() -2;
			var height = $(window).height() - 252;
			if(height < 115 ){
				height = 115;
			}
			grid.setGridWidth(width,true);
			grid.setGridHeight(height,true);
		}).resize();
		
		//레이어 팝업 컨트롤
		$("#pop_wrap").dialog({
		    autoOpen : false,
		    modal : true,
		    width : 950,
		    resizable : false
		});

		//유효성 검사 결과 팝업 내용 확인창.
		$("#check_alert").dialog({
		    autoOpen : false,
		    modal : true,
		    width : 430,
		    resizable : false
		});
		
	});
	
 

    //페이징 로우수 변경시 조회 클릭 
    jQuery(".ui-pg-selbox").change(function(){
    	btn_search();
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
				
				// 현재 페이징 확인
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
		        		url:"/aMainUserManageList.do",
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
//########################################################
//###	8. init ( 시작 )   							   ###
//########################################################




//########################################################
//###   사용자 정의 함수 ( 시작 )   							   ###
//########################################################

//그리드 사이즈 조절
function reSizefn(){
	$(window).resize(function() {
		var grid = $("#grid1");
		var width = $(".grid_area").parent().width() -2;
		var height = $(window).height() - 252;
		if(height < 115 ){
			height = 115;
		}
		grid.setGridWidth(width,true);
		grid.setGridHeight(height,true);
	}).resize();
}

function check_pop_close(){
	$( '#txt_check_message' ).val("");
	$("#check_alert").dialog( "close" );
}




function done(result){
	alert(result+"건 수정되었습니다.");
	$("#dialog2").dialog( "close" );
	btn_search();
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
//###   사용자 정의 함수 ( 끝 )     						   ###
//########################################################


//########################################################
//###   팝업 이벤트 구현 ( 시작 )   							   ###
//########################################################

function pop_close(){
	$("#pop_cnt").bindData(pageClean);
	$("#pop_wrap").dialog( "close" );
}

function pop_save(Gubun){
	if(confirm("상세정보 를 저장하시겠습니까?") == false) return;
	var loadData = $("#pop_cnt ").serializeAllObject();
	//### 필수 입력사항 확인 (시작)
	if(loadData.USER_NAME == null || $.trim(loadData.USER_NAME) =="" ){
		confirm("사원명은 필수 입력사항 입니다.");
		return;
	}
	
	if(loadData.DEPART_NUM == null || $.trim(loadData.DEPART_NUM) =="" ){
		confirm("부서는 필수 입력사항 입니다.");
		return;
	}
	
	if(loadData.GRADE_NAME == null || $.trim(loadData.GRADE_NAME) =="" ){
		confirm("직급은 필수 입력사항 입니다.");
		return;
	}
	
	if(loadData.DUTY_NAME == null || $.trim(loadData.DUTY_NAME) =="" ){
		confirm("직책은 필수 입력사항 입니다.");
		return;
	}
	
	if(loadData.UPUSER_NUM == null || $.trim(loadData.UPUSER_NUM) =="" ){
		confirm("상위관리자는 필수 입력사항 입니다.");
		return;
	}
	
	if(loadData.USE_YN == null || $.trim(loadData.USE_YN) =="" ){
		confirm("사용여부를 선택해 주세요.");
		return;
	}
	//### 필수 입력사항 확인 (끝)
	
	jQuery.ajax({
	    type:"POST",
	    url:"/insertAMainUser.do", 
	    enctype : "multipart/form-data",
	    dataType:"JSON",
	    data: loadData,
	    success : function(data) {
	    	alert("저장되었습니다.");
	    	$("#pop_cnt").bindData(pageClean);
	    	btn_search();
	    	if(Gubun == "New"){
	    		$("#pop_wrap").dialog( "close" );
	    	}
	    },
	    complete : function(data) {
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
}


function btn_popup(Gubun, iData){
	/*****팝업 오픈*****/
	$(".ui-dialog-titlebar").addClass("pop_head");
	$( '#pop_wrap' ).dialog( 'open' );
	$("#pop_cnt").bindData(pageClean);
	
	/*****팝업 컨트롤******/
	if(Gubun == "Detail"){

		var loadData = iData;
		 
		$('#ui-id-1.ui-dialog-title').text("사원상세정보");
		$('#pop_addNew').hide();
		
		$('.close_tr').show();
		
		//벌점설명 상세 조회
		jQuery.ajax({
		    type:"POST",
		    url:"/aMainUserManageDetail.do",
		    dataType:"JSON",
		    data: loadData,
		    success : function(data) {
		    	
		    	loadData.USER_NUM = data.USER_NUM;
		    	loadData.USER_NAME = data.USER_NAME;
		    	loadData.DEPART_NUM = data.DEPART_NUM;
		    	loadData.GRADE_NAME = data.GRADE_NAME;
		    	loadData.DUTY_NAME = data.DUTY_NAME;
		    	loadData.UPUSER_NUM = data.UPUSER_NUM;
		    	loadData.USE_YN = data.USE_YN;
		    	
	    		$("#pop_cnt").bindData(loadData);
		    },
		    complete : function(data) {
		    },
		    error : function(xhr, status, error) {
//		          alert("에러발생");
		    }
		});
		
	}else if(Gubun == "New"){
		$('#ui-id-1.ui-dialog-title').text("사원 등록");
		$('#pop_addNew').show();
		$('.close_tr').hide();
	}

}




//########################################################
//###   팝업 이벤트 구현 ( 끝 )   							   ###
//########################################################





//########################################################
//###   grid 이벤트 ( 시작 )   							   ###
//########################################################
function grid1_onSelectRow(rowId, status, e) {
	grid1.onSelectRow(rowId, status, e);
	grid1.setClickedProp(rowId);
}

function grid1_dbClickRow(rowId,status,e){
	/*grid1.setClickedProp(rowId);*/
	var loData = $("#grid1").jqGrid('getRowData', rowId); 
    
    btn_popup("Detail",loData);
}

//셀클릭
function grid1_cellSelect(rowId,iCol,cellcontents,e){

}

//########################################################
//###   grid 이벤트 ( 끝 )     							   ###
//########################################################




//########################################################
//###   상단 버튼 구현 ( 시작 )   							   ###
//########################################################


//버튼 조회
function btn_search(){
	var loadData = $("#top_search").serializeAllObject();
	
	loadData.PAGE = 1;
    loadData.ROW_LIST = $("#grid1").getGridParam('rowNum');

	
	//검색 리스트 총 개수
	jQuery.ajax({
	    type:"POST",
	    url:"/aMainUserManageTotal.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data: loadData,
	    success : function(data) {
	    	if(data.TOTAL_CNT != null){
	    		var TOTAL_CNT =  data.TOTAL_CNT.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
	    		$('#TOTAL_CNT').text(TOTAL_CNT);
	    	}
	    },
	    complete : function(data) {
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
	
	var grid = $("#grid1");
	grid.jqGrid('setGridParam', {
		url:"/aMainUserManageList.do",
	    mtype: "POST",
	    datatype: "json",
	    postData: loadData 
	    ,page:1,
	}).trigger('reloadGrid');
	
	//그리드 사이즈 조절
	reSizefn();
}


function btn_delete() {

	var ARRAY_DATA = new Array();
	
	
	var checkRowIds = $("#grid1").jqGrid('getGridParam', 'selarrrow'); 
	if( checkRowIds.length < 1) {
		alert("삭제할 사원을 선택하세요.");
		return;
	}
	
	if(confirm("선택하신 사원을 삭제하시겠습니까?") == false) return;	 
	for(var i=0; i < checkRowIds.length; i++){
		  
		var loadData = $("#grid1" ).jqGrid('getRowData', checkRowIds[i]);
		ARRAY_DATA[i] =loadData.USER_NUM;
		//ARRAY_DATA[i] =loadData;
	}  
	
	loadData.ARRAY_DATA = ARRAY_DATA;
	jQuery.ajaxSettings.traditional = true;
	jQuery.ajax({
	    type:"POST", 
	    url:"/deleteAMainUser.do",
	    dataType:"JSON",
	    data: loadData,
	    success : function(data) {
	    	alert("삭제되었습니다.");
	    	btn_search();
	    },
	    complete : function(data) {
	    },
	    error : function(xhr, status, error) {
	    	flag = false;
//	    	alert("에러발생");
	    }
	});
}
//########################################################
//###   상단 버튼 구현 ( 끝 )   							   ###
//########################################################







