<%@ page language="java"   contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 

작성일 : 2016-11-21
직상지 : 문희훈 

본 페이지는 개발을 진행함에 있어, 검색, 입력등에 사용되는 공통 함수 입니다.
금액, 날짜, 휴대폰번호, 이메일검증, 사업자등록번호 검증, 한글/영어만 입력, 자동 하이픈, 자동 콤마 등
필요한 함수가 있다면, 본 페이지의 예제를 활용하여 개발하시길 바랍니다.
 -->

<jsp:include page="/WEB-INF/jsp/retail/inc_common/inc_head.jsp" />		


<script language="javascript">

$(document).ready(function () {
	
	/**
	* 2010-01 (년도-월) 
	* 달력을 사용하기 위한 함수 날짜가 나오기 않게 하기 위해 아래의 스타일을 꼭 JSP 파일상단에 선언해죠야 한다.
	*<style>
	*table.ui-datepicker-calendar { display:none; }
	*</style>
	*/
	$.datepicker.regional['ko'] = {
        closeText: '닫기',
        prevText: '이전달',
        nextText: '다음달',
        currentText: '오늘',
        monthNames: ['1월(JAN)','2월(FEB)','3월(MAR)','4월(APR)','5월(MAY)','6월(JUN)',
        '7월(JUL)','8월(AUG)','9월(SEP)','10월(OCT)','11월(NOV)','12월(DEC)'],
        monthNamesShort: ['1월','2월','3월','4월','5월','6월',
        '7월','8월','9월','10월','11월','12월'],
        dayNames: ['일','월','화','수','목','금','토'],
        dayNamesShort: ['일','월','화','수','목','금','토'],
        dayNamesMin: ['일','월','화','수','목','금','토'],
        weekHeader: 'Wk',
        dateFormat: 'yy-mm-dd',
        firstDay: 0,
        isRTL: false,
        showMonthAfterYear: true,
        yearSuffix: '',
        showOn: 'both',
        buttonText: "달력",
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        yearRange: 'c-99:c+99'
    };
    $.datepicker.setDefaults($.datepicker.regional['ko']);
  
    var datepicker_default = {
        showOn: 'both',
        buttonText: "달력",
        currentText: "이번달",
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        yearRange: 'c-10:c+10',
        showOtherMonths: true,
        selectOtherMonths: true
    }
 
    datepicker_default.closeText = "선택";
    datepicker_default.dateFormat = "yy-mm";
    datepicker_default.onClose = function (dateText, inst) {
        var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
        var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
        $(this).datepicker( "option", "defaultDate", new Date(year, month, 1) );
        $(this).datepicker('setDate', new Date(year, month, 1));
    }
 
    datepicker_default.beforeShow = function () {
        var selectDate = $("#sdate").val().split("-");
        var year = Number(selectDate[0]);
        var month = Number(selectDate[1]) - 1;
        $(this).datepicker( "option", "defaultDate", new Date(year, month, 1) );
    }
 	
    //달력을 호출할 TEXT박스 ID 에 달력 적용 
    $("#sdate").datepicker(datepicker_default);
});

 

/**
 * 사업자 등록번호 유효성 체크 함수 시작
 **/	
//사업자 등록번호 체크
function checkBizID(bizID){ 
	
    // bizID는 숫자만 10자리로 해서 문자열로 넘긴다. 
	var checkID = new Array(1, 3, 7, 1, 3, 7, 1, 3, 5, 1);
	var i, chkSum=0, c2, remander;
	bizID = bizID.replace(/-/gi,'');
	 
	for (i=0; i<=7; i++) chkSum += checkID[i] * bizID.charAt(i);
	c2 = "0" + (checkID[8] * bizID.charAt(8));
	c2 = c2.substring(c2.length - 2, c2.length);
	chkSum += Math.floor(c2.charAt(0)) + Math.floor(c2.charAt(1));
	remander = (10 - (chkSum % 10)) % 10 ;
	 
	if (Math.floor(bizID.charAt(9)) == remander) return true ; // OK!
	return false;
} 


function checkBizRegNo(){
var bizID = $("#bizRegNo");
	
	if( !bizID.val() ){
       alert('사업자 등록번호를 입력 해 주세요');
       bizID.focus();
       return false;
   } else{
	   if(checkBizID(bizID.val())){
		   alert("참");
	   }else{
		   alert("거짓");
	   };
   }
}
/**
 * 사업자 등록번호 유효성 체크 함수 시작
 **/	
 
 
 /**
 *자바스크립트 생년월일 유효성 체크
 *년도의 유효성은 1900년생 이상, 현재 20살 이상으로 하였다.
 *각자의 조건에 따라 수정하여 사용하면 될듯 싶다.
  **/
 //생년월일 유효성 체크
 function isValidDate() {
	
	  var birthday = $("#birthDay");
	  var dateStr = birthday.val();
      var year = Number(dateStr.substr(0,4)); 
      var month = Number(dateStr.substr(4,2));
      var day = Number(dateStr.substr(6,2));
      var today = new Date(); // 날자 변수 선언
      var yearNow = today.getFullYear();
      var adultYear = yearNow-20;

      if (year < 1900 || year > adultYear){
           alert("년도를 확인하세요. 1900년생 이상, "+adultYear+"년생 이전 출생자만 등록 가능합니다.");
           birthday.focus();
           return false;
      }
      if (month < 1 || month > 12) { 
           alert("달은 1월부터 12월까지 입력 가능합니다.");
           birthday.focus();
           return false;
      }
     if (day < 1 || day > 31) {
           alert("일은 1일부터 31일까지 입력가능합니다.");
           birthday.focus();
           return false;
      }
      if ((month==4 || month==6 || month==9 || month==11) && day==31) {
    	  birthday.focus();
          alert(month+"월은 31일이 존재하지 않습니다.");
          return false;
      }
      if (month == 2) {
           var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
           if (day>29 || (day==29 && !isleap)) {
                alert(year + "년 2월은  " + day + "일이 없습니다.");
                birthday.focus();
                return false;
           }
      }
      return true;
 }
 
 //비밃번호 유효성 체크 
 function validPwd(){
	 var passWd = $("#pwd");
	 var str = passWd.val();
	 if(!checkPwd( $.trim(str))){ 

	 	alert('비밀번호를 확인하세요. (영문,숫자를 혼합하여 8~20자 이내)');    

	 	$('#pwd').val('');

	 	$('#pwd').focus(); 
	 
	 	return false;
	} 
 }
 //비밀번호 영문+숫자 조합 8자리이상 정규식
 function checkPwd(str){
	 
	 var reg_pwd = /^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;

	 if(!reg_pwd.test(str)){
  		return false;
	 }else{
	 	return true;
	 }

}

 //공백제거 
 function trimText(){
	 
	 alert("공백제거전 ::"+$("#trimtest").val()+":: -> " + "공백제거후 ::"+$.trim($("#trimtest").val())+"::" );
	 
 }
 
</script>

<style>
table.ui-datepicker-calendar { display:none; }
</style>

</head>
<body style="">

<p>다국어 샘플 예제: message-common_ko.properties, message-common_en.properties 파일 참조</p>
현재 설정된 메세지 출력 : <spring:message code="msgSaveConfirm"/>

<p>휴대폰 / 이메일 유효성 체크</p>
<table border='1' align='' class='find_pass' style="width:500px;">
    <tr>
        <th width='200'>휴대폰번호</th>
        <td> <input type="text" name="cellPhone" id="cellPhone" placeholder="핸드폰 번호 입력" maxlength="13" /></td>
    </tr>
    <tr>
        <th width='200'>이메일</th>
        <td><input type='text' id='user_email' placeholder="이메일 입력"  maxlength='40' /></td>
    </tr>
    <tr><td colspan='2' height='1px'></td></tr>
    <tr>
    	<td colspan="2">
          <button class="btn_pass"> 확인</button>
        </td>
    </tr>
</table>

<p>사업자 등록번호 체크</p>
<table border='1' align='' class='find_pass' style="width:500px;">
    <tr>
        <th width='200'>사업자 등록번호</th>
        <td> <input type="text" name="bizRegNo" id="bizRegNo" placeholder="사업자번호 입력" maxlength="12" /></td>
    </tr>
    <tr>
    	<td colspan="2">
          <span class="btn_ok" onclick="checkBizRegNo()"> 확인</span>
        </td>
    </tr>
</table>


<p>생년월일 체크(입력예: 19580101 / 1900년이상 , 20살이상)</p> 
<table border='1' align='' class='find_pass' style="width:500px;">
    <tr>
        <th width='200'>생년월일</th>
        <td> <input type="text" name="birthDay" id="birthDay" placeholder="생년월일 입력" maxlength="10" /></td>
    </tr>
    <tr>
    	<td colspan="2">
          <span class="btn_ok" onclick="isValidDate()"> 확인</span>
        </td>
    </tr>
</table>

<p>돈 3자리마다 콤마, 소수점2째 자리까지 입력</p> 
<table border='1' align='' class='find_pass' style="width:500px;">
    <tr>
        <th width='200'>돈 입력</th>
        <td> <input type="text" name="money" id="money" placeholder="돈 3자리 콤마, 소수점2째 자리까지 입력" maxlength="20" numberOnly  /></td>
    </tr>
</table>

<p>한글만 입력</p> 
<table border='1' align='' class='find_pass' style="width:500px;">
    <tr>
        <th width='200'>한글만 입력</th>
        <td> <input type="text" name="hangle" id="hangle" placeholder="한글만 입력" maxlength="20" numberOnly  /></td>
    </tr>
</table>

<p>영어만 입력</p> 
<table border='1' align='' class='find_pass' style="width:500px;">
    <tr>
        <th width='200'>영어만 입력</th>
        <td> <input type="text" name="eng" id="eng" placeholder="영어만 입력" maxlength="20" numberOnly  /></td>
    </tr>
</table>

<p>한글/영어만 입력</p> 
<table border='1' align='' class='find_pass' style="width:500px;">
    <tr>
        <th width='200'>한글/영어만 입력</th>
        <td> <input type="text" name="hanEng" id="hanEng" placeholder="한글/영어만 입력" maxlength="20" numberOnly  /></td>
    </tr>
</table>



<p>비밀번호 유효성검사</p> 
<table border='1' align='' class='find_pass' style="width:500px;">
    <tr>
        <th width='200'>비밀번호 입력</th>
        <td> <input type="password" name="pwd" id="pwd" placeholder="비밀번호(영문+숫자조합 8자이상)" maxlength="20" numberOnly  /></td>
    </tr>
    <tr>
    	<td colspan="2">
          <span class="btn_ok" onclick="validPwd()"> 확인</span>
        </td>
    </tr>
</table>

<p>날짜 (ex:1900-01)</p> 
<table border='1' align='' class='find_pass' style="width:500px;">
    <tr>
        <th width='200'> (ex:1900-01)</th>
        <td> <input  name="sdate" id="sdate" class="date-picker" /></td>
    </tr>
</table>

<p>공백제거</p> 
<table border='1' align='' class='find_pass' style="width:500px;">
    <tr>
        <th width='200'>단어 입력(공백포함)</th>
        <td> <input type="text" name="trimtest" id="trimtest" placeholder="공백제거 테스트 단어  작성" maxlength="20" numberOnly  /></td>
    </tr>
    <tr>
    	<td colspan="2">
          <span class="btn_ok" onclick="trimText()"> 확인</span>
        </td>
    </tr>
</table>



 


<script type='text/javaScript'>

$(document).ready(function () {
	
	$("#dateForm").applyCommJquery();
	
	/** 
	 * input 숫자와 콤마만 입력되게 하기. 
	 * 매우중요 : jquery.number.js 파일 인크루드하기
	 * include js : jquery.number.js
	 * input 속성에 numberOnly 추가
	 * jsp : <input type="text" id="amount" name="amount" numberOnly placeholder="0" />
	 * $(this).number(true);
	 * $.number( 5020.2364 );				// Outputs 5,020
	 * $.number( 5020.2364, 2 );			// Outputs: 5,020.24
	 * $.number( 135.8729, 3, ',' );		// Outputs: 135,873
	 * $.number( 5020.2364, 1, ',', ' ' );	// Outputs: 5 020,2 
	 */
	$('#money').number( true, 2 );
	 
	 
	 //한글만 입력 가능하도록 처리 하는 부분
     $("#hangle").keyup(function (event) {
         regexp = /[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
         v = $(this).val();
         if (regexp.test(v)) {
             alert("한글만 입력가능 합니다.");
             $(this).val(v.replace(regexp, ''));
         }
     });
	 
     //영어만 입력 가능하도록 처리 하는 부분
     $("#eng").keyup(function (event) {
         regexp = /[\ㄱ-ㅎㅏ-ㅣ가-힣0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
         v = $(this).val();
         if (regexp.test(v)) {
             alert("영어만 입력가능 합니다.");
             $(this).val(v.replace(regexp, ''));
         }
     });
	 
     
     //한글/영어만 입력 가능하도록 처리 하는 부분
     $("#hanEng").keyup(function (event) {
         regexp = /[0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"'\\]/g;
         v = $(this).val();
         if (regexp.test(v)) {
             alert("한글/영어만 입력가능 합니다.");
             $(this).val(v.replace(regexp, ''));
         }
     });

	/**
	 * 휴대폰 / 이메일 유효성 체크 함수 시작
	 **/	
	
	//이메일, 휴대폰 유효성 체크
    var u_email = $('#user_email');
    var u_phone = $('#cellPhone');
    
    //버튼 클릭 시 검사
    $('.btn_pass').click(function(){
        // 정규식 - 이메일 유효성 검사
        var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
        // 정규식 -전화번호 유효성 검사
        var regPhone =  /^01([0|1|6|7|8|9]?)-?([0-9]{3,4})-?([0-9]{4})$/;

        //휴대폰 입력 및 유효성 체크
        if( !u_phone.val() ){
            alert('휴대폰 번호를 입력 해 주세요');
            u_phone.focus();
            return false;
        } else {
            if(!regPhone.test(u_phone.val())) {
            	alert("잘못된 휴대폰 번호입니다. 숫자, - 를 포함한 숫자만 입력하세요.");
                u_phone.focus();
                return false;
            }
        }
        
        //이메일 입력 및 유효성 체크
        if( !u_email.val() ){
            alert('이메일주소를 입력 해 주세요');
            u_email.focus();
            return false;
        } else {
            if(!regEmail.test(u_email.val())) {
                alert('이메일 주소가 유효하지 않습니다');
                u_email.focus();
                return false;
            }
        }
    });
    /**
	 * 휴대폰 / 이메일 유효성 체크 함수 끝
	 **/	

});

/**
 * 휴대폰 입력시 자동 하이픈"-" 추가 함수 시작
 **/

//휴대폰 입력시 자동 하이픈 생성 함수
function autoHypenPhone(str){
    str = str.replace(/[^0-9]/g, '');
    var tmp = '';
    if( str.length < 4){
        return str;
    }else if(str.length < 7){
        tmp += str.substr(0, 3);
        tmp += '-';
        tmp += str.substr(3);
        return tmp;
    }else if(str.length < 11){
        tmp += str.substr(0, 3);
        tmp += '-';
        tmp += str.substr(3, 3);
        tmp += '-';
        tmp += str.substr(6);
        return tmp;
    }else{              
        tmp += str.substr(0, 3);
        tmp += '-';
        tmp += str.substr(3, 4);
        tmp += '-';
        tmp += str.substr(7);
        return tmp;
    }
    return str;
}

//휴대폰 입력시 자동 하이픈 생성
var cellPhone = document.getElementById('cellPhone');
cellPhone.onkeyup = function(event){
event = event || window.event;
var _val = this.value.trim();
this.value = autoHypenPhone(_val) ;
}

/**
 * 휴대폰 입력시 자동 하이픈"-" 추가 함수 끝
 **/
 
 
 /**
  * 사업자 등록번호 등록 시 자동 하이픈"-" 추가 함수 시작
  **/

 //사업자 등록번호 입력시 자동 하이픈 생성 함수
 function autoHypenBizNo(str){
     str = str.replace(/[^0-9]/g, '');
     var tmp = '';
     
     if( str.length < 4){
         return str;
     }else if(str.length < 5){
         tmp += str.substr(0, 3);
         tmp += '-';
         tmp += str.substr(3);
         return tmp;
     }else if(str.length < 6){
         tmp += str.substr(0, 3);
         tmp += '-';
         tmp += str.substr(3, 2);
         tmp += '-';
         tmp += str.substr(6);
         return tmp;
     }else{       
         tmp += str.substr(0, 3);
         tmp += '-';
         tmp += str.substr(3,2);
         tmp += '-';
         tmp += str.substr(5);
         return tmp;
     }
     return str;
 }

 //사업자 등록번호 입력시 자동 하이픈 생성
 var bizNo = document.getElementById('bizRegNo');
 bizNo.onkeyup = function(event){
 event = event || window.event;
 var _val = this.value.trim();
 this.value = autoHypenBizNo(_val) ;
 }

 /**
  * 사업자 등록번호 등록 시 자동 하이픈"-" 추가 함수 끝
  **/
 
  

  /**
   * 생년월일 등록 시 자동 하이픈"-" 추가 함수 시작
   **/

  //생년월일 입력시 자동 하이픈 생성 함수
  function autoHypenBirthDay(str){
      str = str.replace(/[^0-9]/g, '');
      var tmp = '';
      
      if( str.length < 5){
          return str;
      }else if(str.length < 6){
          tmp += str.substr(0, 4);
          tmp += '-';
          tmp += str.substr(4);
          return tmp;
      }else if(str.length < 6){
          tmp += str.substr(0, 3);
          tmp += '-';
          tmp += str.substr(4, 2);
          tmp += '-';
          tmp += str.substr(5);
          return tmp;
      }else{       
          tmp += str.substr(0, 4);
          tmp += '-';
          tmp += str.substr(4, 2);
          tmp += '-';
          tmp += str.substr(6);
          return tmp;
      }
      return str;
  }

  //생년월일 입력시 자동 하이픈 생성
  var birthDay = document.getElementById('birthDay');
  birthDay.onkeyup = function(event){
  event = event || window.event;
  var _val = this.value.trim();
  this.value = autoHypenBirthDay(_val) ;
  }

  /**
   * 생년월일 등록 시 자동 하이픈"-" 추가 함수 끝
   **/
</script>
</body>
</html>



