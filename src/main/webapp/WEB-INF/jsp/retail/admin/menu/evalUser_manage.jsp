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
	2018-03-19     이성진       초기작성 
	------------------------------------------------------
	
	version : 1.0
--%> 

	<script type="text/javascript" src="/resources/js/page/adm/AMainEvalUser.js" charset="utf-8"></script>
	<script type="text/javaScript" language="javascript" defer="defer"> </script>
</head>
 
 <body id="in_frame">
 
		<div >
			<div class="btn_area">
				<!--  <button type="button" onclick="btn_search()">조회</button> -->
			</div>
			
			<!-- 조회폼 영역 -->
			<div class="box_form"    id="top_search">
				<label>
					<span>사원명</span>
					<input type="text" id="P_USER_NAME" name="P_USER_NAME"   maxlength="50">    
				</label>
				
				<!--
				<label>
					<span>사용여부</span>
						<select  id="P_USE_YN" name="P_USE_YN" >
							<option value="">전체</option>
							<option value="N">미사용</option>
							<option value="Y">사용</option>
						</select>
				</label>
				-->
				
				<label>
					<button type="button" onclick="btn_search()">조회</button>
				</label>
			</div>
			<!-- //조회폼 영역 -->
			
			<div class="col2">
			
				<div class="box_lft">
					<h3 class="bul_arr">사원 리스트</h3>
					<div class="sec_grid">
						<div class="grid_area">
							<table id="grid1" style="width:355px"></table>
						</div>
					</div>
				</div>
				
				<div class="box_rgt">
					<section class="sec_grid">
						<!-- 
						<h3 class="bul_arr">평가항목 비중 리스트<button type="button" onclick="btn_new_detail();">평가항목 일괄등록</button></h3>
						 -->
						<h3 class="bul_arr">평가항목 비중 리스트</h3>
						<div class="grid_area">
							<table id="grid2" style="width:355px"></table>
						</div>
					</section>
				</div>
			
			</div>

		</div>
		<!-- //Content : 본문 영역 -->
	 
<!-- 	 상세 팝업 영역 시작  -->
<!-- 
<div id="pop_wrap">
	<header id="pop_head">
		<h1 class="bul_arr">평가항목 비중상세</h1>
	</header>
 
	<form action="">
		<div id="pop_cnt">
	
			<table class="tbl_st2">
						<input type="hidden"  id="D_USER_NUM" name="D_USER_NUM">
				<tbody>
					<tr>
						<th scope="row"><em>필수항목</em>순번</th>   
						<td colspan="3"><input type="text"  id="D_EVAL_ITEM_NUM" name="D_EVAL_ITEM_NUM" readonly></td>
					</tr>
					<tr>
						<th scope="row"><em>필수항목</em>평가항목</th>
						<td colspan="3"><input type="text" id="D_EVAL_ITEM_NAME" name="D_EVAL_ITEM_NAME" readonly></td>
					</tr>
					<tr>
						<th scope="row">비중값</th>
						<td colspan="3"><input type="text" id="D_EVAL_RATE" name="D_EVAL_RATE"></td>
					</tr>
				</tbody>
			</table>
		</div>
	
		<footer id="pop_foot">
			<button type="button" class="btn_st1 pal" onclick="btn_del_detail()">평가항목삭제</button>
			<button type="button" class="btn_st1" onclick="btn_save_detail()">저장</button>
			<button type="button" class="btn_st1" onclick="btn_close()">취소</button>
		</footer>
		
	</form>

</div>
 -->	 
<!-- 	 상세 팝업 영역 끝  -->
	
</body>
</html>
	
