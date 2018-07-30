<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- 스프링 메세지 테그사용 :: 다국어 -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--
    파일명: inc_language.jsp
    설명:  공통으로 include 할 language 용 tag 맵핑
    author  : 문희훈
    since   : 2016.11.23
    version : 1.0
    guide : 
    1. JSP와 JS를 분리하여 개발을 하기 때문에, 프로퍼티 언어별 메세지 셋팅을 자바스크립트 전역변수에 담아 사용 
    2. JS에서 사용되는 alert, 멘트, innerHtml, grid등에 한글이 사용되는 곳은 전역변수에 담아 사용
    3. JSP에서 멘트 및 한글을 사용할경우에는 <spring:message code="프로퍼티변수"/> 해당 코드 바로 사용 가능
    4. 공통 메세지 또는 언어가 추가 되었을 시 다른 개발자에게 공유 및 배포 SVN 처리
--%>
<!-- 다국어를 위한 전역변수 js에서 alert, 한글태그 등에 사용-->
<script type="text/javascript" charset="utf-8">

/**공통 알림 메세지**/
var msgSaveConfirm = '<spring:message code="msgSaveConfirm"/>'; //저장하시겠습니까?
var msgSave= '<spring:message code="msgSave"/>'; //저장되었습니다.
var msgModifyConfirm= '<spring:message code="msgModifyConfirm"/>'; //수정 하시겠습니까?
var msgModify= '<spring:message code="msgModify"/>'; //수정되었습니다.
var msgDeleteConfirm= '<spring:message code="msgDeleteConfirm"/>'; //삭제 하시겠습니까?
var msgDelete= '<spring:message code="msgDelete"/>'; //삭제되었습니다.
var msgAuthDel= '<spring:message code="msgAuthDel"/>'; //권한을 삭제 하시겠습니까?
var msgAutUser= '<spring:message code="msgAutUser"/>'; //명의 사용자가 권한을 사용하고있습니다.

/**공통 버튼**/
var btnNew='<spring:message code="btnNew"/>'; //신규
var btnSave='<spring:message code="btnSave"/>'; //저장
var btnDel='<spring:message code="btnDel"/>'; //삭제
var btnSearch='<spring:message code="btnSearch"/>'; //조회

/**그리드 TEXT**/
var authGroupList='<spring:message code="authGroupList"/>'; //권한그룹 목록
var authGroupName='<spring:message code="authGroupName"/>'; //권한그룹 명 
var useYn='<spring:message code="useYn"/>'; //사용여부
var useMenus='<spring:message code="useMenus"/>'; //사용가능 메뉴
var explanation='<spring:message code="explanation"/>'; //설명
var disabledMenu='<spring:message code="disabledMenu"/>'; //사용불가 메뉴
var commonCode='<spring:message code="commonCode"/>'; //공통 코드
var remarks='<spring:message code="remarks"/>'; //비고
var shortName='<spring:message code="shortName"/>'; //단축명
var properties='<spring:message code="properties"/>'; //등록정보
var aboutFixes='<spring:message code="aboutFixes"/>'; //수정정보
var all ='<spring:message code="all"/>'; //전체
var unused ='<spring:message code="unused"/>'; //미사용
var use ='<spring:message code="use"/>'; //사용
var requiredFields ='<spring:message code="requiredFields"/>'; //필수입력항목
var commonCodeManagement ='<spring:message code="commonCodeManagement"/>'; //공통코드 관리



</script>
