
// 권한 그룹의  SELECT BOX 리스트를 생성한다.
// id: 셀렉트 박스 아이디
// code: 권한그룹 Group
function getRoleList(id){
	 
	jQuery.ajax({
	    type:"POST",
	    url:"/selectRoleCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨 
	    success : function(data) {
	    	$.each(data.rows, function(key, value) {   
	    		 
	    	     $('#'+id).append('<option value="'+ this.cell[1] +'">'+ this.cell[0] +'</option>'); 
	    	});
	    },
	    complete : function(data) {
	          // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	          // TODO
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생111");
	    }
	});
}




// RUCKUS 거래처 정보 가져오기
function getPartnerCode(id,CUST_GB){
	var postValue = {
			 "CUST_GB"   : CUST_GB
	  	}; 
	// 지역코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/getPartnerCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    success : function(data) {
	    	$.each(data.rows, function(key, value) {   
	    	     $('#'+id).append('<option value="'+ this.cell[1] +'">'+ this.cell[0] +'</option>'); 
	    	});
	    },
	    complete : function(data) {
	          // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	          // TODO
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
}


 
//RUCKUS 아이템 정보 가져오기
function getGoodsCode(ids, formGubun){
	  
//	$("#POP_ITEM_GOD_CD > option[value='"+data.GOD_CD+"']").attr("selected", "ture"); 
//	$("select[name='"+ ids +"'] option").remove(); 
	$("#"+ids+" > option").remove(); 
	
	var postValue = {
 			 "FORM_GUBUN"  	 : formGubun
	  	}; 
	// 지역코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/getGoodsCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    async:false,
	    success : function(data) {
	    	
	    	 $('#'+ids).append('<option value="">선택</option>'); 
	    	$.each(data.rows, function(key, value) {   
	    	     $('#'+ids).append('<option value="'+ this.cell[1] +'">'+ this.cell[0] +'</option>'); 
	    	});
	    },
	    complete : function(data) {
	          // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	          // TODO
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
	
}



//RUCKUS 마감 제품코드 가져오기 (재고가 있는것만)
function getGodCodeList(ids){

	 
	var postValue = {
			 "FORM_GUBUN"  	 : ""
	  	}; 
	// 지역코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/getGodCodeList.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    async:false,
	    success : function(data) {
	    	
	    	 $('#'+ids).append('<option value="">선택</option>'); 
	    	$.each(data.rows, function(key, value) {   
	    	     $('#'+ids).append('<option value="'+ this.cell[1] +'">'+ this.cell[0] +'</option>'); 
	    	});
	    },
	    complete : function(data) {
	          // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	          // TODO
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
	
}



//RUCKUS 반품교체 시리얼 정보 가져오기
function getSerialCode(ids,GOD_CD){
	  
	
	var postValue = {
			 "GOD_CD"   : GOD_CD
	  	}; 
	
//	$("#POP_ITEM_GOD_CD > option[value='"+data.GOD_CD+"']").attr("selected", "ture"); 
//	$("select[name='"+ ids +"'] option").remove(); 
	$("#"+ids+" > option").remove(); 
	
	// 지역코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/getSerialCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    async:false,
	    success : function(data) {
	    	
	    	 $('#'+ids).append('<option value="">선택</option>'); 
	    	$.each(data.rows, function(key, value) {   
	    	     $('#'+ids).append('<option value="'+ this.id +'">'+ this.cell[0] +'</option>'); 
	    	});
	    },
	    complete : function(data) {
	          // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	          // TODO
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
	
}

// 공통코드의 SELECT BOX 리스트를 생성한다.
// id: 셀렉트 박스 아이디
// code: 공통 코드 Group
function getCodeList(id, code){
	var postValue = {
			 "CD_CL"  		: code
	  	}; 
	// 지역코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/selectAreaCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    success : function(data) {
	    	$.each(data.rows, function(key, value) {   
	    	     $('#'+id).append('<option value="'+ this.cell[1] +'">'+ this.cell[0] +'</option>'); 
	    	});
	    },
	    complete : function(data) {
	          // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	          // TODO
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
}


/************************************
 * 공통코드의 SELECT BOX 리스트를 생성한다
 * selectboxname	: 셀렉트 박스 NAME
 * Groupcode1		: 공통 코드 Group (ex : CD0005) 
 ************************************/
function getCodeListbinding(selectboxname, Groupcode1){
	
	var postValue = { "GRADE_ITEM_TYPE_CODE"  				: Groupcode1 };
	 
	// 지역코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/selectAreaCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    async:true,
	    success : function(data) {
	    	$.each(data.rows, function(key, value) {   
	    	     $(selectboxname).append('<option value="'+ this.cell[1] +'">'+ this.cell[0] +'</option>'); 
	    	});
	    },
	    complete : function(data) {
	          // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	          // TODO
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
}

/************************************
 * 부서코드의 SELECT BOX 리스트를 생성한다
 * selectboxname	: 셀렉트 박스 NAME
 ************************************/
function getDeptCodeListbinding(selectboxname){
	
	var postValue = {};

	// 부서코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/selectDeptCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    async:true,
	    success : function(data) {
	    	$.each(data.rows, function(key, value) {   
	    	     $(selectboxname).append('<option value="'+ this.cell[1] +'">'+ this.cell[0] +'</option>'); 
	    	});
	    },
	    complete : function(data) {
	          // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	          // TODO
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
}

/************************************
 * 사원코드의 SELECT BOX 리스트를 생성한다
 * selectboxname	: 셀렉트 박스 NAME
 ************************************/
function getUserCodeListbinding(selectboxname, Groupcode1){
	
	var postValue = {};
	 
	// 사원코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/selectDeptCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    async:true,
	    success : function(data) {
	    	$.each(data.rows, function(key, value) {   
	    	     $(selectboxname).append('<option value="'+ this.cell[1] +'">'+ this.cell[0] +'</option>'); 
	    	});
	    },
	    complete : function(data) {
	          // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	          // TODO
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
}


/************************************
 * 사원코드의 SELECT BOX 리스트를 생성한다
 * selectboxname	: 셀렉트 박스 NAME
 ************************************/
function getUserCodeListbinding(selectboxname, Groupcode1){
	
	var postValue = { ""  				: Groupcode1 };
	 
	// 지역코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/selectUserCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    async:true,
	    success : function(data) {
	    	$.each(data.rows, function(key, value) {   
	    	     $(selectboxname).append('<option value="'+ this.cell[1] +'">'+ this.cell[0] +'</option>'); 
	    	});
	    },
	    complete : function(data) {
	          // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	          // TODO
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
}

/************************************
 * 회사 코드를 가지고 회사의 이름을 검색한다.
 ************************************/
function selectCmpyNm(SESSION_CMPNY_CD){
	
	var postValue = { "CMPNY_CD" : SESSION_CMPNY_CD };
	
	// 지역코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/selectCmpnyNm.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    success : function(data) {
	    	$('#SESSION_CMPNY_NM').val(data.CMPNY_NM);	  
	    	$('#CMPNY_NM').val(data.CMPNY_NM);
	    },
	    complete : function(data) {
	          // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	          // TODO
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
	
}

/************************************
 * 전화번호 공통코드의 SELECT BOX 리스트를 생성한다
 * selectboxname	: 셀렉트 박스 NAME
 * Groupcode1		: 공통 코드 Group (ex : CD0005)
 * Joincode2		: 공통 코드 Group (ex : mobile)
 * Joincode3		: 공통 코드 Group (ex : telno)
 ************************************/
function getTelCodeListbinding(selectboxname, Groupcode1, Joincode2, Joincode3){
	var postValue ={};
	if(Joincode2 == null){
		postValue = { "CD_CL"	: Groupcode1 , "MGMT_ITEM_3" 	: Joincode3  };
	}else if(Joincode3 == null){
		postValue = { "CD_CL"	: Groupcode1 , "MGMT_ITEM_2" 	: Joincode2  };
	}else if(Joincode2 != null && Joincode3 != null){
		postValue = { "CD_CL"	: Groupcode1 , "MGMT_ITEM_2" 	: Joincode2 , "MGMT_ITEM_3" 	: Joincode3 };
	}
	// 지역코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/selectTelAreaCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data:postValue,
	    success : function(data) {
	    	$.each(data.rows, function(key, value) {   
	    	     $(selectboxname).append('<option value="'+ this.cell[1] +'">'+ this.cell[0] +'</option>'); 
	    	});
	    },
	    complete : function(data) {
	          // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	          // TODO
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
}


//벌점 유형 조회
function getPenaltyList(id){
	
	/*var postValue = {
			
			 "AREA_CD"  		: AREA_CD
	};*/
	
	// 지역코드를 가져온다.
	jQuery.ajax({
	    type:"POST",
	    url:"/selectPenaltyCode.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    //data:postValue,
	    success : function(data) {
	    	
	    	$.each(data.rows, function(key, value) {   
	    	     $('#'+id).append('<option value="'+ this.cell[0] +'">'+ this.cell[1] +'</option>'); 
	    	});
	    	
	    },
	    complete : function(data) {
	          // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.
	          // TODO
	    },
	    error : function(xhr, status, error) {
//	          alert("에러발생");
	    }
	});
	
}



//숫자 3자리 마다 콤마 찍기
function moneyComma(val){
	var moneyFormat =   val.replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
	return moneyFormat;
}	



//숫자  콤마 빼기
function removeComma(val){
	var removeComma =   val.replace(/,/g, '');
	return removeComma;
}	



// 체크
// essential                  필수입력클래스
// onlynum                    숫자만입력
// input 에서 limit="min,max" 속성추가
// for="이름"                 속성추가
function validationCheck() {
	var isSuccess = false;

	// 필수 입력사항
	$('.essential').each(function() {
		
		if($(this)[0].tagName == 'SELECT') {
			var index = $(this).children("option").index($(this).children("option:selected"));
			
			if(index == 0) {
				alert($(this).attr('for') + '를 선택하세요.');
				$(this).focus();
				
				isSuccess = false;
				return false;
			}else {
				isSuccess = true;				
			}
		}
		else {
			if($(this).val() == '') {
				alert($(this).attr('for') + '을 입력하세요.');
				$(this).focus();
				
				isSuccess = false;
				
				return false;
			}
			else{
				isSuccess = true;				
			}
		}
	});
	
	
	// 숫자만 입력
	/*if(isSuccess) {
		$('.onlynum').each(function() {
			if($(this).val().replace(/[^0-9]/g, '') == '') {
				alert($(this).attr('for') + '는 숫자만 입력 가능합니다.');
				
				$(this).val('');
				$(this).focus();
				
				isSuccess = false;
				
				return false;
			}
			else{
				isSuccess = true;				
			}
		});
	}
	
	if(isSuccess) {
		
		$('input[limit]').each(function() {
			var limit = $(this).attr('limit').split(',');
			var min = limit[0];
			var max = limit[1];
			var valLength = $(this).val().length;
			var msg = $(this).attr('for') + '는 ';
			
			if(min == max) {
				msg += min;
			} else {
				msg += (min + ' - ' + max);
			}
			
			msg += ' 자릿수 제한입니다.';
			
			
			if((min != 0 && valLength < min) || (max != 0 && valLength > max)) {
				alert(msg);
				$(this).focus();
				
				isSuccess = false;
				
				return false;
			}
			else{
				isSuccess = true;				
			}
		});
	}*/

	return isSuccess;
}



//년도별 주의 리스트를 가지고 온다
function getWeekList(selectYear){
	
	//오늘 날짜
	var lsToDate = new CommDateManager().before(0,0,7).getDate("yyyy-mm-dd");
	
	var loadData = {
			
			 "selectYear"  		: selectYear
	}; 
	
	jQuery.ajax({
	    type:"POST",
	    url:"/selectWeekList.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data: loadData,
	    success : function(data) {
	    	//cell[0] 1주 , cell[1] 시작, cell[2] 끝
	    	$.each(data.rows, function(key, value) {
	    		
	    		$('#selectWeek').append('<option value="'+ this.cell[1] +'~'+ this.cell[2] +'">'+ this.cell[0] + '주 (' + this.cell[1] +'~'+ this.cell[2]+')'+ '</option>');
	    		
	    		if(lsToDate >=  this.cell[1] && lsToDate <=  this.cell[2]){
	    			$("#selectWeek").val(this.cell[1] +'~'+ this.cell[2]).attr("selected", "selected");
	    		}
	    	     
	    	     
	    	});
	    	//일별을 계산하기위한 날짜의 차이를 구한다
	    	selDailyPer();
	    },
	    complete : function(data) {
	    },
	    error : function(xhr, status, error) {
	          //alert("에러발생");
	    }
	});
	
}


//년도별 주의 리스트를 가지고 온다
function getAmtWeekList(selectYear){
	
	//오늘 날짜
	var lsToDate = new CommDateManager().before(0,0,7).getDate("yyyy-mm-dd");
	var loadData = {
			
			 "selectYear"  		: selectYear
	}; 
	
	jQuery.ajax({
	    type:"POST",
	    url:"/selectWeekList.do",
	    dataType:"JSON", // 옵션이므로 JSON으로 받을게 아니면 안써도 됨
	    data: loadData,
	    success : function(data) {
	    	//cell[0] 1주 , cell[1] 시작, cell[2] 끝
	    	$.each(data.rows, function(key, value) {
	    		
	    		$('#selectWeek').append('<option value="'+ this.cell[1] +'~'+ this.cell[2] +'">'+ this.cell[0] + '주 (' + this.cell[1] +'~'+ this.cell[2]+')'+ '</option>');
	    		
	    		if(lsToDate >=  this.cell[1] && lsToDate <=  this.cell[2]){
	    			$("#selectWeek").val(this.cell[1] +'~'+ this.cell[2]).attr("selected", "selected");
	    		}
	    	     
	    	});
	    	//일별을 계산하기위한 날짜의 차이를 구한다
	    	selDailyPer();
	    },
	    complete : function(data) {
	    	//최초 데이터 조회
    		btn_search("tab1");
	    },
	    error : function(xhr, status, error) {
	          //alert("에러발생");
	    }
	});
	
}


//년도별 주의 리스트를 가지고 온다
function getWeekList2(selectboxname, selectYear){
	
	var lsToDate = selectYear;
	/*if(selectboxname.split(']')[0].charAt(selectboxname.split(']')[0].length -1) == "S"){
		lsToDate = new CommDateManager().before(0,6,0).getDate("yyyy-mm-dd");
	}else{
		lsToDate = new CommDateManager().getDate("yyyy-mm-dd");
	}*/

	var loadData = {
			 "selectYear"  		: selectYear.split('-')[0]
	}; 
	jQuery.ajax({
	    type:"POST",
	    url:"/selectWeekList.do",
	    dataType:"JSON",
	    data: loadData,
	    async: true, 
	    success : function(data) {
	    	//cell[0] 1주 , cell[1] 시작, cell[2] 끝
	    	$.each(data.rows, function(key, value) {
	    		$(selectboxname).append('<option value="'+ this.cell[0]+'">'+ this.cell[0] + '주 (' + this.cell[1] +'~'+ this.cell[2]+')'+ '</option>');
	    		if(lsToDate >=  this.cell[1] && lsToDate <=  this.cell[2]){
	    			$(selectboxname).val(this.cell[0]).attr("selected", "selected");
	    		}
	    	});
	    	//일별을 계산하기위한 날짜의 차이를 구한다
	    	//selDailyPer();
	    },
	    complete : function(data) {
	    },
	    error : function(xhr, status, error) {
	          //alert("에러발생");
	    }
	});
}


//0채우기 num : 값 , len : 자리수
function fillZeros(num, len) {
    var str = '';
    num = num.toString();

    if (num.length < len) {
    for (var i = 0; i < len - num.length; i++)
      str += '0';
    }
    return str + num;
}


//html코드 특수문자로 변경
function htmlDecode(str){
    if(str == "" || str == null){
        return str;
    }
    else{
        return str.replace(/&amp;/gi,"&").replace(/&#35;/gi,"#").replace(/&lt;/gi,"<").replace(/&gt;/gi,">").replace(/&quot;/gi,"\"").replace(/&#39;/gi,'\\').replace(/&#37;/gi,'%').replace(/&#40;/gi,'(').replace(/&#41;/gi,')').replace(/&#43;/gi,'+').replace(/&#47;/gi,'/').replace(/&#46;/gi,'.').replace(/&apos;/gi,'\'');
    }
}

