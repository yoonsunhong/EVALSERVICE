/********************************************************
 * 설명:  공통코드관리
 * 수정일      	수정자       수정내용
 * ------------------------------------------------------
 * ------------------------------------------------------
 * author	: 문희훈
 * since	: 2016.10.31
 * version : 1.0
 ********************************************************/
	
var crudBit          =   "C";   // 최초 신규로 시작함
var crudBitDetail    =   "C";   // 최초 신규로 시작함

$(document).ready(function(){
	
	init();

});

// ----------------------- 그리드 설정 시작 -------------------------------------
//rMate그리드 경로정보 셋팅
rMateGridH5.setAssetsPath("/resources/js/rMateGridH5/Assets/");


// rMate 그리드 생성 준비가 완료된 상태 시 호출할 함수를 지정합니다.
var jsVars = "rMateOnLoadCallFunction=gridReadyHandler";

// rMateDataGrid 를 생성합니다.
// 파라메터 (순서대로)
//  1. 그리드의 id ( 임의로 지정하십시오. )
//  2. 그리드가 위치할 div 의 id (즉, 그리드의 부모 div 의 id 입니다.)
//  3. 그리드 생성 시 필요한 환경 변수들의 묶음인 jsVars
//  4. 그리드의 가로 사이즈 (생략 가능, 생략 시 100%)
//  5. 그리드의 세로 사이즈 (생략 가능, 생략 시 100%)
rMateGridH5.create("grid1", "gridHolder1", jsVars, "100%", "300");
rMateGridH5.create("grid2", "gridHolder2", jsVars, "700", "500");

// 그리드의 속성인 rMateOnLoadCallFunction 으로 설정된 함수.
// rMate 그리드의 준비가 완료된 경우 이 함수가 호출됩니다.
// 이 함수를 통해 그리드에 레이아웃과 데이터를 삽입합니다.
// 파라메터 : id - rMateGridH5.create() 사용 시 사용자가 지정한 id 입니다.
function gridReadyHandler(id) {
	if (id == "grid1") {
		// rMateGrid 관련 객체
		gridApp1 = document.getElementById(id);	// 그리드를 포함하는 div 객체
		gridRoot1 = gridApp1.getRoot();	// 데이터와 그리드를 포함하는 객체

		gridApp1.setLayout(layoutStr);
		gridApp1.setData(gridData);

		//로우 클릭 이벤트 제어
		var itemClickHandler = function(event) {
			var rowIndex = event.rowIndex;
			var columnIndex = event.columnIndex;
			dataRow1 = gridRoot1.getItemAt(rowIndex);
			// 컬럼중 숨겨진 컬럼(visible false인 컬럼)이 있으면 getDisplayableColumns()를 사용하여 컬럼을 가져옵니다.
			var column = dataGrid1.getDisplayableColumns()[columnIndex];
			var dataField = column.getDataField();
			clickData1 = dataRow1[dataField];
			
			//alert(clickData1.CD_ID);
			
			$('#CD_NM').val(dataRow1.CD_NM); 
			$('#CD_ID').val(dataRow1.CD_ID); 
	    	$('#CD_DESCRIPTION').val(dataRow1.CD_DESCRIPTION);  
	    	
	    	if(dataRow1.DEL_YN == "N"){
	    		$("input:radio[name='DEL_YN']:radio[value='N']").attr("checked",true);
	    	}else if(dataRow1.DEL_YN == "Y"){
	    		$("input:radio[name='DEL_YN']:radio[value='Y']").attr("checked",true);
	    	}
	    	
	    	btn_search_detail();   // 상세 리스트 보여주기
	    	
	    	crudBit = "U";   // 수정
			
		};
		
		//그리드1 핸들러
		var layoutCompleteHandler1 = function(event) {
			dataGrid1 = gridRoot1.getDataGrid();	// 그리드 객체
			
			//그리드1 셀선택 이벤트
			dataGrid1.addEventListener("itemClick", itemClickHandler);

		};
		
		//레이아웃을 읽어와 그리드 생성을 완료하면 그리드1 핸들러 생성.
		gridRoot1.addEventListener("layoutComplete", layoutCompleteHandler1);
		
		
	} else if(id =="grid2") {
		
		gridApp2 = document.getElementById(id);	// 그리드를 포함하는 div 객체
		gridRoot2 = gridApp2.getRoot();	// 데이터와 그리드를 포함하는 객체

		gridApp2.setLayout(layoutStr2);
		gridApp2.setData(gridData2);
		
		//그리드2 로우 더블 클릭 이벤트 제어
		var itemDoubleClick = function(event) {
			var rowIndex = event.rowIndex;
			var columnIndex = event.columnIndex;
			dataRow2 = gridRoot2.getItemAt(rowIndex);
			// 컬럼중 숨겨진 컬럼(visible false인 컬럼)이 있으면 getDisplayableColumns()를 사용하여 컬럼을 가져옵니다.
			var column = dataGrid2.getDisplayableColumns()[columnIndex];
			var dataField = column.getDataField();
			clickData2 = dataRow2[dataField];
			
			//alert(dataRow2.CD_ID);
			
			
			crudBitDetail = "U";   // 수정
			
			 $('#D_ORIGIN_CD_ID').val(dataRow2.CD_ID);
			
			 $('#D_CD_ID').val(dataRow2.CD_ID);
			 $('#D_CD_NM').val(dataRow2.CD_NM);
			 $('#D_CD_SHORT_NM').val(dataRow2.CD_SHORT_NM);
			 $('#D_CD_DESCRIPTION').val(dataRow2.CD_DESCRIPTION);
			 $('#D_SORT_ORDER').val(dataRow2.SORT_ORDER);
			 $('#D_MGMT_ENTRY_1').val(dataRow2.MGMT_ENTRY_1);
			 $('#D_MGMT_ENTRY_DESCRIPTION_1').val(dataRow2.MGMT_ENTRY_DESCRIPTION_1);
			 
	    	if(dataRow2.DEL_YN == "N"){
	    		$('#D_DEL_YN').val("N");
	    	}else if(dataRow2.DEL_YN == "Y"){
	    		$('#D_DEL_YN').val("Y");
	    	}
			$( '#pop_wrap' ).dialog( 'open' ); 
			
		};

		//그리드2 핸들러
		var layoutCompleteHandler2 = function(event) {
			dataGrid2 = gridRoot2.getDataGrid();	// 그리드 객체
			
			dataGrid2.setDoubleClickEnabled(true);
			//그리드2 셀선택 이벤트
			dataGrid2.addEventListener("itemDoubleClick", itemDoubleClick);
			
		};
		gridRoot2.addEventListener("layoutComplete", layoutCompleteHandler2);
	}
}

//그리드의 데이터 제어를 위한 전역변수 설정
var gridApp1, gridRoot1, dataGrid1,dataRow1,clickData1,selectorColumn1;
var gridApp2, gridRoot2, dataGrid2, dataRow2,clickData2,selectorColumn2;

//----------------------- 그리드 설정 끝 -----------------------

//그리드1 헤더 설정
var layoutStr =
'<rMateGrid>\
	<DataGrid id="dg1" sortableColumns="true" selectionMode="singleRow" textAlign="center" alternatingItemColors="[#ffffff,#f9f9f9]" headerHeight="37" rowHeight="34" verticalAlign="middle" showDataTips="true">\
		<columns>\
			<DataGridColumn dataField="CD_ID"  headerText="공통코드 분류" textAlign="center" />\
			<DataGridColumn dataField="CD_NM" headerText="공콩코드 분류명" textAlign="center" />\
			<DataGridColumn dataField="DEL_YN" headerText="삭제여부" textAlign="center" labelJsFunction="labelFunc"/>\
		 	<DataGridColumn dataField="CD_DESCRIPTION" headerText="설명" textAlign="center" />\
		</columns>\
	</DataGrid>\
</rMateGrid>';

//그리드2 헤더 설정
var layoutStr2 =
'<rMateGrid>\
	<DataGrid id="dg1" sortableColumns="true" selectionMode="singleRow" textAlign="center" alternatingItemColors="[#ffffff,#f9f9f9]" headerHeight="37" rowHeight="34" verticalAlign="middle" showDataTips="true">\
		<columns>\
			<DataGridColumn dataField="CD_ID"  headerText="상세코드 아이디" textAlign="center" />\
			<DataGridColumn dataField="CD_NM"  headerText="상세코드 명" textAlign="center" />\
			<DataGridColumn dataField="CD_SHORT_NM"  headerText="단축명" textAlign="center" />\
			<DataGridColumn dataField="CD_DESCRIPTION"  headerText="코드설명" textAlign="center" />\
			<DataGridColumn dataField="SORT_ORDER"  headerText="순서" textAlign="center" />\
			<DataGridColumn dataField="MGMT_ENTRY_1"  headerText="관리항목1" textAlign="center" />\
			<DataGridColumn dataField="MGMT_ENTRY_DESCRIPTION_1"  headerText="관리항목1설명" textAlign="center" />\
			<DataGridColumn dataField="DEL_YN"  headerText="삭제유무" textAlign="center" labelJsFunction="labelFunc"/>\
			<DataGridColumn dataField="CD_CL"  headerText="분류코드" textAlign="center" visible="false"/>\
		</columns>\
	</DataGrid>\
</rMateGrid>';


//그리드 row의 값을 변경하여 보여주기
function labelFunc(item, value, column){
  var str = item["DEL_YN"];//삭제여부 컬럼의 필드명
  if(str=="N")
    return "사용";
  else if(str=="Y")
   return "미사용";
}

//그리드1 데이터 초기화
var gridData = [];

//최초 로딩시 그리드1 데이터 조회 및 그리드 데이터 셋팅
jQuery.ajax({ 
    url:"/getCodeCategory.do",         
    type:"POST",
	datatype:"json",
	async:false,
	data: {'A':'A','A':'A'},
	success:function(data){  
		gridData = data;
		//alert(data);
    },
    complete : function(data) {
    },
    error : function(xhr, status, error) {
           
    }
});

//그리드2 데이터 초기화
var gridData2 = [];

// ----------------------- 그리드 설정 끝 -------------------------------------

function applyFormElementJquery() {
	$("#top_search").applyCommJquery();
}


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
 

//공통코드 상세 정보 팝업 닫기
function btn_close(){ 
	// btn_search();
	$("#pop_wrap").dialog( "close" );
}


//공통코드 삭제
function btn_del()
{
	 
	//그리드 1 체크여부 테스트
	 if(dataRow1 ==undefined || dataRow1 == 'undefined' || dataRow1 ==null){
		 
		 alert('왼쪽 그리드에서 코드를 선택하세요.');
			return;
	 } 
	
	
	 
	 if(confirm("코드를  삭제  하시겠습니까?") == false) return;
	 
	 
     jQuery.ajax({ 
	    url:"/deleteCode.do",         
	    type:"POST",
		datatype:"json",
		data:  {CD_ID:dataRow1.CD_ID  },
		beforeSend : function(xhr) {} ,
		success:function(data,textStatus){ 
			btn_search();
			btn_search_detail();
	    },
	    complete : function(data) {
	    	
	    	alert("삭제   되었습니다.");
	    	
	    },
	    error : function(xhr, status, error) { 
	    }
	});
	
	 
	
}

//상세코드 삭제
function btn_del_detail()
{
	
	if(confirm("상세코드를  삭제  하시겠습니까?") == false) return;
	
	
     jQuery.ajax({ 
	    url:"/deleteCodeDetail.do",         
	    type:"POST",
		datatype:"json",
		data:  {CD_CL:dataRow2.CD_CL , CD_ID:dataRow2.CD_ID},
		beforeSend : function(xhr) {} ,
		success:function(data){ 
			btn_search_detail();
	    },
	    complete : function(data) {
	    	alert("상세코드가 삭제   되었습니다.");
	    },
	    error : function(xhr, status, error) { 
	    }
	});
	
	btn_close();
}



// 공콩코드 있는지 확인 count
function btn_select_count_code(CD_CL , CD_ID){
	 
	    var rtn = "";
		jQuery.ajax({
		    type:"POST",
		    url:"/selectCountCode.do",
		    dataType:"JSON",  
		    async: false ,
		    data:{
		    	   CD_CL          : CD_CL
				 , CD_ID          : CD_ID
		    },
		    success : function(data) {  
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


//공통코드 상세 저장
function btn_save_detail(){
	
	 
	 if( $('#D_CD_ID').val()  == null || $('#D_CD_ID').val() =="" ){
			confirm("코드는 필수 입력항목 입니다.");
			$('#D_CD_ID').focus();
			return;
	 } else  if(  $('#D_CD_NM').val()  == null || $('#D_CD_NM').val() =="" ){
			confirm("코드명은 필수 입력항목 입니다.");
			$('#D_CD_NM').focus();
			return;
	 } 
	 
	if(crudBitDetail == "C")   // 신규 insert
	{ 
		
		
		if( btn_select_count_code(dataRow1.CD_ID , $('#D_CD_ID').val()) == "0" )  // 카운트가 0이면 업데이트
		{ 
				 jQuery.ajax({ 
					    url:"/insertCodeDetail.do",         
					    type:"POST",
						datatype:"json",
						async:false,
						data: {     
							  CD_CL          : dataRow1.CD_ID
							, CD_ID          : $('#D_CD_ID').val()
							, CD_NM          : $('#D_CD_NM').val()
							, CD_SHORT_NM    : $('#D_CD_SHORT_NM').val()
							, CD_DESCRIPTION          : $('#D_CD_DESCRIPTION').val()
							, SORT_ORDER     : $('#D_SORT_ORDER').val()
							, MGMT_ENTRY_1    : $('#D_MGMT_ENTRY_1').val()
							, MGMT_ENTRY_DESCRIPTION_1 : $('#D_MGMT_ENTRY_DESCRIPTION_1').val() 
							, DEL_YN         : $('#D_DEL_YN').val() 
						},
						beforeSend : function(xhr) {} ,
						success:function(data){  
							btn_search_detail();
							alert('신규 코드를 저장 하였습니다.');
					    },
					    complete : function(data) {
					    },
					    error : function(xhr, status, error) {
					           
					    }
					});
		} else {
			
			alert('[신규]중복된 공통코드입니다.');
			
		}
				 
	} 

	if(crudBitDetail == "U")   // 수정 update
	{ 
		 
		jQuery.ajax({ 
		    url:"/updateCodeDetail.do",         
		    type:"POST",
			datatype:"json",
			async:false,
			data: {     
				  D_ORIGIN_CD_ID : $('#D_ORIGIN_CD_ID').val()
				, CD_CL          : dataRow1.CD_ID
				, CD_ID          : $('#D_CD_ID').val()
				, CD_NM          : $('#D_CD_NM').val()
				, CD_SHORT_NM    : $('#D_CD_SHORT_NM').val()
				, CD_DESCRIPTION          : $('#D_CD_DESCRIPTION').val()
				, SORT_ORDER     : $('#D_SORT_ORDER').val()
				, MGMT_ENTRY_1    : $('#D_MGMT_ENTRY_1').val()
				, MGMT_ENTRY_DESCRIPTION_1 : $('#D_MGMT_ENTRY_DESCRIPTION_1').val() 
				, DEL_YN         : $('#D_DEL_YN').val() 
			},
			beforeSend : function(xhr) {} ,
			success:function(data){  
				btn_search_detail();
				alert('코드를 수정 하였습니다.');
		    },
		    complete : function(data) {
		    },
		    error : function(xhr, status, error) {
		           
		    }
		});

	}
	 
	 $('#D_CD_ID').val("");
	 $('#D_CD_NM').val("");
	 $('#D_CD_SHORT_NM').val("");
	 $('#D_CD_DESCRIPTION').val("");
	 $('#D_SORT_ORDER').val("");
	 $('#D_MGMT_ENTRY_1').val("");
	 $('#D_MGMT_ENTRY_DESCRIPTION_1').val(""); 
	 $('#D_DEL_YN').val("Y");
		
	 // 저장후 창 닫기
	 btn_close();
	
}


//코드 상세 팝업 호출
function btn_new_detail() {   // 상세신규
	crudBitDetail = "C";     
	
	 $('#D_CD_ID').val("");
	 $('#D_CD_NM').val("");
	 $('#D_CD_SHORT_NM').val("");
	 $('#D_CD_DESCRIPTION').val("");
	 $('#D_SORT_ORDER').val("");
	 $('#D_MGMT_ENTRY_1').val("");
	 $('#D_MGMT_ENTRY_DESCRIPTION_1').val(""); 
	 $('#D_DEL_YN').val("Y");
	 
	 if(dataRow1 ==undefined || dataRow1 == 'undefined' || dataRow1 ==null){
		 alert('왼쪽 그리드에서 공통 분류를 선택하세요.');
	 } else{
		 $( '#pop_wrap' ).dialog( 'open' );	
	 }
}


function btn_new()
{
	crudBit = "C";   //신규
	$('#CD_NM').val(""); 
	$('#CD_ID').val(""); 
	$('#CD_DESCRIPTION').val("");   
	$("input:radio[name='DEL_YN']").removeAttr('checked'); 
}

function btn_save()
{
     //그리드 1 체크여부 테스트
	 /*if(dataRow1 ==undefined || dataRow1 == 'undefined' || dataRow1 ==null){
		 
		 alert('선택 행 없음');
	 } else{
		 alert(dataRow1.CD_ID);
	 }*/
	
	//dataGrid1.addEventListener("itemClick", test); 
	
	 if( $('#CD_NM').val()  == null || $('#CD_NM').val() =="" ){
			confirm("분류명은 필수 입력항목 입니다.");
			$('#CD_NM').focus();
			return;
	 } else  if( typeof $(':radio[name="DEL_YN"]:checked').val() == "undefined" ){
			confirm("사용유무는 필수 입력항목 입니다.");
			$('#DEL_YN').focus();
			return;
	 }
	  
	if(crudBit == "C")   // 신규 insert
	{
		  
		jQuery.ajax({ 
		    url:"/insertCategory.do",         
		    type:"POST",
			datatype:"json",
			data: {
				  CD_NM  : $('#CD_NM').val()
				, CD_DESCRIPTION  : $('#CD_DESCRIPTION').val()
				, DEL_YN : $(':radio[name="DEL_YN"]:checked').val()
			},
			beforeSend : function(xhr) {} ,
			success:function(data){  
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
		    url:"/updateCategory.do",         
		    type:"POST",  
			datatype:"json",
			data: {
				  CD_NM  : $('#CD_NM').val()
				, CD_DESCRIPTION  : $('#CD_DESCRIPTION').val()
				, DEL_YN : $(':radio[name="DEL_YN"]:checked').val()
				, CD_ID  : $('#CD_ID').val()
			},
			beforeSend : function(xhr) {} ,
			success:function(data){  
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


//코드 상세 조회 클릭 후 이벤트 리스너 호출 테스트
function test(event){
	var rowIndex = event.rowIndex;
	var columnIndex = event.columnIndex;
	dataRow1 = gridRoot1.getItemAt(rowIndex);
	// 컬럼중 숨겨진 컬럼(visible false인 컬럼)이 있으면 getDisplayableColumns()를 사용하여 컬럼을 가져옵니다.
	var column = dataGrid1.getDisplayableColumns()[columnIndex];
	var dataField = column.getDataField();
	clickData1 = dataRow1[dataField];
	
	alert(dataField.CD_ID);
}


//코드 상세정보 조회
function btn_search_detail(){
	
	//테스트 :: 그리드에 add리스너를 하여 실행될 함수를 호출 할 수 있다.
	//dataGrid1.addEventListener("itemClick", test);
	 
	jQuery.ajax({ 
	    url:"/getCodeDetail.do",         
	    type:"POST",  
		datatype:"json",
		data: {CD_ID:dataRow1.CD_ID},
		beforeSend : function(xhr) {} ,
		success:function(data){  
			gridApp2.setData(data);
	    },
	    complete : function(data) {
	    },
	    error : function(xhr, status, error) {
	           
	    }
	});
	 
}

function btn_search(){
	
	
	var loadData = $("#top_search").serializeAllObject(); 

	
	//최초 로딩시 그리드1 데이터 조회 및 그리드 데이터 셋팅
	jQuery.ajax({ 
	    url:"/getCodeCategory.do",         
	    type:"POST",
		datatype:"json",
		async:false,
		data: loadData,
		success:function(data){  
			gridApp1.setData(data);
			
	    },
	    complete : function(data) {
	    },
	    error : function(xhr, status, error) {
	           
	    }
	});
	
}
 
//########################################################
//###   상단 버튼 구현 ( 끝 )   							   ###
//########################################################