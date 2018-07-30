<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="retail.common.BaseEnv" %>
<%@include file="/WEB-INF/jsp/retail/inc_common/inc_acommon.jsp" %>
<%@page import ="java.util.List" %>
<%@page import ="java.util.HashMap" %>
<%@page import ="java.util.ArrayList" %>
<%@page import ="java.util.List" %>
<!DOCTYPE HTML>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link type="text/css" rel="stylesheet" href="/resources/js/jquery-ui.css">
<link type="text/css" rel="stylesheet" href="/resources/css/common_web.css">
<!--[if lt IE 9]>
<script src="/resources/js/html5shiv.js"></script>
<script src="/resources/js/IE9.js"></script>
<link type="text/css" rel="stylesheet" href="/resources/css/ie8.css">
<![endif]-->
<script src="/resources/js/jquery-1.11.2.min.js"></script>
<script src="/resources/js/jquery.ui-1.10.4.datepicker.min.js"></script>

<jsp:include page="/WEB-INF/jsp/retail/inc_common/inc_head_web.jsp" />

<%--
	파일명: code_manage.jsp
	설명: 공통코드관리
		
	수정일      	   수정자        수정내용
	------------------------------------------------------
	2018-03-19     장재민       초기작성 
	------------------------------------------------------
	
	version : 1.0
--%> 

	<script type="text/javascript" src="/resources/js/page/adm/AMainUser.js" charset="utf-8"></script>
	<script type="text/javaScript" language="javascript" defer="defer"> </script>
</head>
 
 <body id="in_frame">
<!--##################### 버튼 영역 #####################-->
<div class="btn_area">

</div>
<!--##################### 버튼 영역 #####################-->

<!--##################### 조회폼 영역 #####################-->
<div class="box_form" id="top_search" >
 
<input type="hidden" id="SORTHEADER" name="SORTHEADER" value="" />
<input type="hidden" id="SORT" name="SORT" value="" />


	<label>
		<span>부서명</span>
		<select name="DEPART_NUM" >
			<option value="">전체</option>
		</select>
	</label>
	
	<label>
		<span>직급</span>
		<select name="GRADE_NAME" >
			<option value="">전체</option>
		</select>
	</label>
	
	<label>
		<span>직책</span>
		<select name="DUTY_NAME" >
			<option value="">전체</option>
		</select>
	</label>
	
	<label>
		<span>사원명</span>
		<input type="text" id="USER_NAME" name="USER_NAME"   maxlength="6">  
	</label>

	<label>
		<span>사용여부</span>
		<select name="USE_YN">
			<option value="">전체</option>
		</select>
	</label>
	
	<label>
		<button type="button" id="btn_search" onclick="btn_search()">조회</button>
	</label>
</div>



<!--##################### 조회폼 영역 #####################-->

<!--##################### Grid 영역 #####################-->
<section class="sec_grid">				
	<p class="top_area">
		<h3 class="bul_arr">사원 목록 <strong>(총 <span id="TOTAL_CNT"> 0</span>건)</strong> <button type="button" id="btn_new" onclick="btn_popup('New')">신규</button>
		<button type="button" id="btn_delete" onclick="btn_delete()">삭제</button></h3>
		<!--  span class="tip">※ 목록을 더블 클릭하면 상세내역을 조회할 수 있습니다.</span -->
		
		
	</p>
	<div class="grid_area">
		<table id="grid1"></table>
	</div>		
	<div id="ajaxProwed1"></div>	
</section>
<!--##################### Grid 영역 #####################-->
	
<!--##################### 팝업 영역 #####################-->
<div id="pop_wrap" >
	<header id="pop_head">
		<h1 class="bul_arr">사원 상세정보</h1>
	</header>
	<div id="pop_cnt">
		<input type="hidden" id="USER_NUM" name="USER_NUM" />
		<table class="tbl_st2">
			<tbody>
				<tr>
					<th rowspan = "7" style="width: 200px;"></th>
					<th scope="row"><em>필수입력항목</em>사원명</th>
					<td>
						<input type="text" id="USER_NAME" name="USER_NAME" maxlength="6" style="width: 200px;">
					</td>
				</tr>
				<tr>
					<th scope="row"><em>필수입력항목</em>부서</th>
					<td>
						<select id="DEPART_NUM" name="DEPART_NUM">
							<option value="">선택</option>
						</select>
					</td>
				</tr>
				<tr>
					<th scope="row"><em>필수입력항목</em>직급</th>
					<td>
						<select id="GRADE_NAME" name="GRADE_NAME">
							<option value="">선택</option>
						</select>
					</td>
				</tr>
				<tr>
					<th scope="row"><em>필수입력항목</em>직책</th>
					<td>
						<select id="DUTY_NAME" name="DUTY_NAME">
							<option value="">선택</option>
						</select>
					</td>
				</tr>
				<tr>
					<th scope="row"><em>필수입력항목</em>상위관리자</th>
					<td>
						<select id="UPUSER_NUM" name="UPUSER_NUM">
							<option value="">선택</option>
						</select>
					</td>
				</tr>
				<tr>
					<th scope="row"><em>필수입력항목</em>사용여부</th>
					<td>
						<select id="USE_YN" name="USE_YN">
							<option value="">선택</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<th scope="row">사진 첨부</th>
					<td>
						<input type="file" name="file">
					</td>
				</tr>

			</tbody>
		</table>
	</div>
	<footer id="pop_foot">
	<button type="button" class="btn_st1 blue" onclick="pop_save('New');">저장</button>
	<button type="button" class="btn_st1 blue" onclick="pop_close();">취소</button>
	<!-- button type="button" class="btn_st1 par blue" id="pop_addNew" onclick="pop_save('Add');" >저장 후 계속 등록</button -->
	</footer>
</div>


<!--##################### 팝업 영역 #####################-->




</body>
</html>



