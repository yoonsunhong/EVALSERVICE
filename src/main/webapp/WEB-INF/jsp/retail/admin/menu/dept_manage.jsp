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
	파일명: dept_manage.jsp
	설명: 부서관리
		
	수정일      	   수정자        수정내용
	------------------------------------------------------
	2018-03-19     장재민       초기작성 
	------------------------------------------------------
	
	version : 1.0
--%> 
	<script type="text/javascript" src="/resources/js/page/adm/AMainDept.js" charset="utf-8"></script>
	<script type="text/javaScript" language="javascript" defer="defer"> </script>

</head>
 
 <body id="in_frame">
 
	<div class="btn_area">
	<!--  
		<button type="button" id="btn_create">신규</button>
	-->	
		<input type="hidden" id="DEPART_NUM" name="DEPART_NUM" >
	</div>
	
	<!-- 조회폼 영역 -->
	<div class="box_form" id="top_search" >
		<label>
			<span>사용여부</span>
			<select id="USE_YN" name="USE_YN">
				<option value="">전체</option>
			</select>
		</label>
		
		<label>
			<button type="button" id="btn_read" onclick="btn_read()">조회</button>
		</label>
	</div>
	<!-- //조회폼 영역 -->
	
	<div class="col2">
	
		<div class="box_lft">
			<h3 class="bul_arr">부서 목록 <button type="button" id="btn_delete" onclick="btn_delete()">선택목록 삭제</button></h3>
			<div class="sec_grid">
				<div class="grid_area">
					<table id="athGroupList"></table>
				</div>
			</div>
			
			<br>
			
			
			<h3 class="bul_arr">부서 추가 <button type="button" id="btn_update" onclick="btn_update()">저장</button></h3>
			<table class="tbl_st2">
				<tbody>
					<tr>
						<th scope="row">
							<em>필수입력항목</em>
							<label for="DEPART_NAME">부서명</label>
						</th>
						<td><input type="text" id="DEPART_NAME" class="essential" for="부서명" maxlength="10"></td>
					</tr>
					<tr>
						<th scope="row">사용여부</th>
						<td>
							<label class="radio">
								<input type="radio" name="USE_YN" value="Y">
								<span>사용</span>
							</label>
							<label class="radio">
								<input type="radio" name="USE_YN" value="N">
								<span>미사용</span>
							</label>
						</td>
					</tr>
				</tbody>
			</table>					
		</div>
		
		<div class="box_rgt">
			<section class="sec_grid">
				<h3 class="bul_arr">부서원 목록</h3>
				<div class="grid_area">
					<table id="appointMenuList"></table>
				</div>
				
				<div class="btn_updown_area">
					<button type="button" class="btn_down" onclick="btn_down()">아래로</button>
					<button type="button" class="btn_up" onclick="btn_up()">위로</button>
				</div>
				
				<h3 class="bul_arr">부서 미지정 사원 목록</h3>
				<div class="grid_area">
					<table id="notAppointMenuList"></table>
				</div>
			</section>
		</div>
	</div>
</body>

</html>   