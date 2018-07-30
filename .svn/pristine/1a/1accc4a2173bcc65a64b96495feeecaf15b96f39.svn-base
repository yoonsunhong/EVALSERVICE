/********************************************************
 * 설명:  메뉴관리
 * 수정일      	수정자       수정내용
 * ------------------------------------------------------
 * ------------------------------------------------------
 * author	: 문희훈
 * since	: 2016.10.31
 * version : 1.0
 ********************************************************/
var crudBit          =   "";   // 최초 신규로 시작함
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

	btn_search();

});

$(window).resize(function() {

	$('.box_menu').height($(window).height() - 60);
});
 
//########################################################
//###	1. 최초 DB에서 세팅에 필요한 데이터를 가져온다 ( 시작 )          ###
//########################################################
function initData() {
	 $("#deleteRow").css("display","none");
}
//########################################################
//###	1. 최초 DB에서 세팅에 필요한 데이터를 가져온다 ( 끝 )     	   ###
//########################################################
 
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
	//달력 셋팅
//	$("#top_search").applyCommJquery();
	
	//오늘날짜 셋팅
	//달력 1달 전 셋팅
//	var lsToDate = new CommDateManager().getDate("yyyy-mm-dd");
//	var beforeMonthDate = new CommDateManager().before(0, 1, 0).getDate("yyyy-mm-dd");
	
	//var lsToDate1= new CommDateManager().getDate("yyyy-mm-dd");
	//alert(lsToDate);
//	$("#top_search input[name=S_REG_DTTM]").val(beforeMonthDate);
//	$("#top_search input[name=E_REG_DTTM]").val(lsToDate);
	 
	// 사용 주체
//	getCodeList("USER_TYPE", "CD0004");
	
	// 승인상태
//	getCodeList("CONF_CD", "CD0017");
	
	// 팝업-이메일 도메인
//	getCodeList("P_EMAIL_DOMAIN", "CD0012");
	
	// 팝업-전화번호
//	getCodeList("P_PHON_NO1", "CD0006");
	
	// 팝업-FAX
//	getCodeList("P_MOBILE_NO1", "CD0006");
	 
	// 팝업-사용 주체
	//getCodeList("P_USER_TYPE", "CD0004");
	
	// 팝업-지자체  
//	getCodeList("P_LOCGOV_CD", "CD0005");
	
//	getCodeList("CD_ID", "CD0005");
//	getCodeList("COPOR_INDV_GB", "CD0014");
	
	
	// 사용자그룹 리스트
//	getCodeList("P_USER_TYPE", "CD0004");
	
	// 권한 리스트
//	getRoleList("P_ROLE_ID");
	
}
  
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
//	$("#top_search").applyCommJquery();
}
//########################################################
//###	5. FORM ELEMENT 공통 JQUERY 적용 ( 끝 )      		   ###
//########################################################
 
//########################################################
//###	6. FORM ELEMENT JQUERY EVENT 등록 ( 시작 )    	   ###
//########################################################
function addFormElementJqueryEvent() {

	$('#MENU_GB').change(menuGbChange);

}
//########################################################
//###	6.FORM ELEMENT JQUERY EVENT 등록 ( 끝 )      	   ###
//########################################################
 
//########################################################
//###	7. grid 초기화 ( 시작 )   						   ###
//########################################################
function initGrid(){
	   
	 
	
}
//########################################################
//###	7. grid 초기화 ( 끝 )     						   ###
//########################################################
 
//########################################################
//###	8. init ( 시작 )   							   ###
//########################################################
function init() {

	  
	
	//숫자만 입력받기
	$("#SORT_ORDER").keyup(function(){
		$(this).val($(this).val().replace(/[^0-9]/g,''));
    });

	$('.box_menu').height($(window).height() - 60);
	  

}
//########################################################
//###	8. init ( 시작 )   							   ###
//########################################################
  
//########################################################
//###   사용자 정의 함수 ( 시작 )   							   ###
//########################################################



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
 


// 메뉴구분 변경시 이벤트 함수
function menuGbChange() {

	var menuGb = $(this).val();

	// 대메뉴, 중메뉴는 class 명이 있으면 오류
	if(menuGb == '' || menuGb == '1' || menuGb == '2') {
		$('#CLASS_NM').attr('readonly', true);
	}
	else {
		$('#CLASS_NM').attr('readonly', false);	
	}
	

}

 

function btn_del()
{
	
	if(confirm("메뉴를  삭제 하시겠습니까?") == false) return;
	 
	jQuery.ajax({ 
	    url:"/deleteMenuInfo.do",         
	    type:"POST",
		datatype:"json",
		data: {
		      MENU_ID     : $('#MENU_ID').val() 
	    },
		beforeSend : function(xhr) {} ,
		success:function(data,textStatus){ 
			   
	    },
	    complete : function(data) {
	    },
	    error : function(xhr, status, error) {
	          
	    }
	});

	alert("삭제 되었습니다.");
	 
	location.reload();
}

   

 


function btn_new()
{

	if(crudBit == '') {
		alert('메뉴를 선택하세요.');
		return;
	}

	if(crudBit == 'C') {

		alert('신규 메뉴 작성 중입니다.');
		return;

	}

 	crudBit = "C";   //신규
 	
 	if(  $('#UP_MENU_ID').val() == "" )
 	{
 		alert("신규 입력하기 위해서 왼쪽 트리메뉴에서 메뉴를 선택하세요.\n선택한 메뉴 하위로 새 메뉴가 생성됩니다.");
 		return;
 	}
 	
 	if(  $('#MENU_GB').val() == "3" )
 	{
 		alert("소메뉴 하위에는 메뉴를 추가 할 수 없습니다.\n대메뉴 혹은 중메뉴를 선택하세요");
 		return;
 	}

	// console.log($('#MENU_GB').val());

 	var $select = $('<select>');
	var $option = $('<option>').text('선택').val('');
	var $optionBigMenu = $('<option>').text('대메뉴').val('1');
	var $optionMiddleMenu = $('<option>').text('중메뉴').val('2');
	var $optionSmallMenu = $('<option>').text('소메뉴').val('3');

 	// MENU_GB (1 : 대메뉴, 2 : 중메뉴, 3 : 소메뉴)



 	// 대메뉴 클릭후 신규 클릭시 중메뉴 소메뉴만 추가 가능
 	if($('#MENU_GB').val() == "1") {

 		$('#CLASS_NM').attr('readonly', true);

 		$('#MENU_GB').empty();
 		$('#MENU_GB').append($option, $optionMiddleMenu, $optionSmallMenu);
 	}
 	// 중메뉴 클릭후 신규 클릭시 소메뉴만 추가 가능
 	else if($('#MENU_GB').val() == "2") {

 		$('#MENU_GB').empty();
 		$('#MENU_GB').append($option, $optionSmallMenu);
 	}
 	else {

 		$('#CLASS_NM').attr('readonly', true);

 		$('#MENU_GB').empty();
 		$('#MENU_GB').append($option, $optionBigMenu);
 	}
 	
 	
 	$("#deleteRow").css("display","none");
 	
// 	$('#UP_MENU_NM').val(""); 
// 	$('#UP_MENU_ID').val("");
 	$('#MENU_ID').val(""); 
 	$('#MENU_NM').val(""); 
 	$('#CLASS_NM').val(""); 
 	$('#MENU_GB').val(""); 
 	$('#SORT_ORDER').val(""); 
 	$('#USE_YN').val(""); 
 	$('#MENU_ID').attr("readonly",false);
 	// $('#CLASS_NM').attr("readonly",false);
// 	$('#SORT_ORDER').attr("readonly",true);
 	$('#MENU_GB').attr("disabled",false);
 	
	 
}

function btn_save()
{
	if(crudBit == '') {
		alert('메뉴를 선택하세요.');
		return;
	} 


	 if(confirm("메뉴를  저장 및 수정 하시겠습니까?") == false) return;
	                
	 if( $('#MENU_ID').val()  == null || $('#MENU_ID').val() =="" ) {

			confirm("메뉴ID는 필수입력 항목 입니다.");
			$('#MENU_ID').focus();
			return;

	 } 
	 
	 if( $('#MENU_NM').val()  == null || $('#MENU_NM').val() =="" ) {

			confirm("메뉴명은 필수 입력항목 입니다.");
			$('#MENU_NM').focus();
			return;

	 } 
	 
	 if( $('#MENU_GB').val() == '3' && ($('#CLASS_NM').val() == null || $('#CLASS_NM').val() == "")) {

			confirm("클래스명은 필수 입력항목 입니다.");
			$('#CLASS_NM').focus();
			return;

	 }


	 if( $('#MENU_GB').val() != '3' && ($('#CLASS_NM').val() != null || $('#CLASS_NM').val() != "")) {

		/*	confirm("대메뉴, 중메뉴 추가시에는 클래명은 입력 받지 않습니다.");
			$('#CLASS_NM').val('');
			$('#CLASS_NM').focus();
			return;*/

	 }

	 
	 if( $('#MENU_GB').val() == null || $('#MENU_GB').val() == "" ) {

			confirm("메뉴구분은 필수 입력항목 입니다.");
			$('#MENU_GB').focus();
			return;

	 } 
	 
	 if( $('#SORT_ORDER').val()  == null || $('#SORT_ORDER').val() == "" ) {

			confirm("정렬순서는 필수 입력항목 입니다.");
			$('#SORT_ORDER').focus();
			return;

	 } 
	 
	 if( $('#USE_YN').val()  == null || $('#USE_YN').val() == "" ) {

			confirm("사용유무는 필수 입력항목 입니다.");
			$('#USE_YN').focus();
			return;

	 }
	 
	 if(crudBit == "C")   // 신규 insert
	 {
		 
		 var UP_MENU_ID = "";

		 if($('#MENU_GB').val() == "1")  // 대메뉴 선택시 널을 넣는다.
		 {
			 UP_MENU_ID = "";
		 } 
		 else {
			 if( $('#MENU_GB').val() == "2" || $('#MENU_GB').val() == "3") { // 중메뉴 선택시 상위아이디을 넣는다.
				 UP_MENU_ID = $('#UP_MENU_ID').val();
			 }
		 }
		  
		 jQuery.ajax({ 
			    url:"/insertMenuInfo.do",         
			    type:"POST",  
				datatype:"json",
				data: {
					      MENU_ID     : $('#MENU_ID').val()
						, MENU_NM     : $('#MENU_NM').val()
						, UP_MENU_ID  : UP_MENU_ID
						, SORT_ORDER  : $('#SORT_ORDER').val() 
						, MENU_GB     : $('#MENU_GB').val()
						, CLASS_NM    : $('#CLASS_NM').val()
						, BIGO        : $('#BIGO').val()
						, USE_YN      : $('#USE_YN').val() 
				},
				beforeSend : function(xhr) {} ,
				success:function(data,textStatus){  
					btn_search();
					alert('저장 하였습니다.');
			    },
			    complete : function(data) {
			    },
			    error : function(xhr, status, error) {
			           
			    }
			});
		 
	 }
	 if(crudBit == "U")   // 수정 업데이트
	 {
		 
		 
		 jQuery.ajax({ 
			    url:"/updateMenuInfo.do",         
			    type:"POST",  
				datatype:"json",
				data: {
					      MENU_ID     : $('#MENU_ID').val()
						, MENU_NM     : $('#MENU_NM').val()
						, UP_MENU_ID  : $('#UP_MENU_ID').val()
						, SORT_ORDER  : $('#SORT_ORDER').val()
						, MENU_GB     : $('#MENU_GB').val()
						, CLASS_NM    : $('#CLASS_NM').val()
						, BIGO        : $('#BIGO').val()
						, USE_YN      : $('#USE_YN').val() 
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
	 
	 location.reload();
	  
}
 


function setMenuInfo(menu_id  ,menu_nm ,up_menu_id ,sort_order ,menu_gb ,class_nm ,bigo ,use_yn ,del_yn, up_menu_nm) 
{
	
	var $select = $('<select>');
	var $option = $('<option>').text('선택').val('');
	var $optionBigMenu = $('<option>').text('대메뉴').val('1');
	var $optionMiddleMenu = $('<option>').text('중메뉴').val('2');
	var $optionSmallMenu = $('<option>').text('소메뉴').val('3');

	$('#MENU_GB').empty();
	$('#MENU_GB').append($option, $optionBigMenu, $optionMiddleMenu, $optionSmallMenu);


	crudBit = "U";
	
	$("#deleteRow").css("display","block");
	
	$('#MENU_ID').val(menu_id);
	$('#MENU_NM').val(menu_nm);
	if(up_menu_nm == 'null') {up_menu_nm = "최상위 메뉴";}
	$('#UP_MENU_NM').val(up_menu_nm);
	$('#UP_MENU_ID').val(menu_id);
	$('#SORT_ORDER').val(sort_order);
	$('#MENU_GB').val(menu_gb);
	if(class_nm == 'null') {class_nm = "";}
	$('#CLASS_NM').val(class_nm);
	if(bigo == 'null') {bigo = "";}
	$('#BIGO').val(bigo);
	$('#USE_YN').val(use_yn); 
	
	if(menu_gb == "3")
	{   
		$('#MENU_ID').attr("readonly",true);   
		$('#CLASS_NM').attr("readonly",false);  
		$('#MENU_GB').attr("disabled",true);   
		
	}   else {   
		$('#MENU_GB').attr("disabled",true);   
		$('#MENU_ID').attr("readonly",true);   
		$('#CLASS_NM').attr("readonly",true);  
	}
}


var str = "";
var i   = 0;
function treeMenu( data )
{
 	 
	var parent;	// 현재 노드
	var child;	// 다음에 출력할 노드
	 
	if( i < data.content.length )
	{ 
		  
					str += "<li>";
					str += '<a href="javascript:setMenuInfo(\''+data.content[i].menu_ID+'\'   ,\''+data.content[i].menu_NM+'\'  , \''+data.content[i].up_MENU_ID+'\'  , \''+data.content[i].sort_ORDER+'\'  , \''+data.content[i].menu_GB+'\'  ,  \''+data.content[i].class_NM+'\'  ,  \''+data.content[i].bigo+'\'  , \''+data.content[i].use_YN+'\'  ,  \''+data.content[i].del_YN+'\' ,  \''+data.content[i].up_MENU_NM+'\' )" >'+data.content[i].menu_NM+' ('+data.content[i].sort_ORDER+')</a>';
//					str += '<a href= javascript:setMenuInfo(\''+data+'\' , \''+i+'\') >\''+data.content[i].menu_NM+'\'</a>';
					
					
					if(i+1 < data.content.length ){	
							/* 다음노드가 존재하는경우 */
							
							/* 현재노드와 다음노드 depth비교 */
							parent 	= data.content[i].menu_GB;
							child 	= data.content[i+1].menu_GB;
							
							if(parent < child){			// 다음 노드가 본인보다 높은레벨(자식)일경우
								str += "<ul> ";
							} else if(parent==child){	// 같은 레벨일경우
								str += "</li> ";
							} else if(parent>child){	// 다음 노드가 본인보다 작은레벨(부모)일경우
								str += "</li> ";
								for(var depth=0; depth < parent-child; depth++){	// 부모레벨로 이동
									str += "</ul> ";
									str += "</li> ";
								}
							}
							
							i++;		// i 증가
							treeMenu(data);	// 재귀호출 (다음노드 호출)
						
					} else {
							/* 다음노드가 존재하지 않는경우 마무리 */
							str += "</li> ";
							for(var depth=1; depth < data.content[i].menu_GB; depth++){	// 들어갔던 depth만큼 빠져나오기
								str += "</ul> ";
								str += "</li> ";
							}
							i++;	// i를 증가하지않는경우  if( i < data.content.length ) 조건문을 계속 타게되어 새로고침할때마다 숫자가 계속출력
					}
					  
	}	
	 
	return str;
	
}


function tree_init(status){
	var tree_menu_ul = $('#tree_menu_ul');
	if (status == 'close'){
		tree_menu_ul.find('ul').hide();
		$('a.control').find('img').attr('src', icon_open);
	} else if (status == 'open'){
		tree_menu_ul.find('ul').show();
		$('a.control').find('img').attr('src', icon_close);
	}
}



function btn_search(){
	
	
 
	
	$.ajax({
		url:"/getMenuTree.do" ,
		type:"POST",
		datatype:"json",
		async:"false",
//		data:{ menu_id:menu_id },
		beforeSend : function(xhr) {} ,
		success:function(data,textStatus){ 
				  
			
			
		//	 .menu_ID .menu_NM .up_MENU_ID .sort_ORDER+ .menu_GB+ class_NM+ .bigo+ .use_YN+ .del_YN+' t[i].up_MENU_NM+'\' )" >   
 
			
			
			var menu = treeMenu( data );
			$("#tree_menu").html( "<ul id=tree_menu_ul><li><a href= javascript:setMenuInfo('AAAA','메뉴루트','AAAA','0','0','','','','','메뉴루트') >[[ 메뉴루트 ]]</a>"+menu+"</li></ul>" );
 
		 	$('#UP_MENU_NM').val(""); 
		 	$('#UP_MENU_ID').val(""); 
		 	$('#MENU_ID').val(""); 
		 	$('#MENU_NM').val(""); 
		 	$('#CLASS_NM').val(""); 
		 	$('#MENU_GB').val(""); 
		 	$('#SORT_ORDER').val(""); 
		 	$('#USE_YN').val(""); 
		 	$('#MENU_ID').attr("readonly",false); 
			 
			
			// 메뉴 선택시 메뉴 활성화 효과
			$('#tree_menu li a').mouseup(function(e) {
		    	e.preventDefault();

		    	$('#tree_menu a').removeClass('menuActive');
		    	$(this).addClass('menuActive');

		    });
				 
		},
		error:function(x,e){ 
		}	 
	}); 
	
	 
	
}


 
//########################################################
//###   상단 버튼 구현 ( 끝 )   							   ###
//########################################################