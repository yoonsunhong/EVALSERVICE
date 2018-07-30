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

	<script type="text/javascript" src="/resources/js/page/adm/AMainEvalItem.js" charset="utf-8"></script>
	<script type="text/javaScript" language="javascript" defer="defer"> </script>
</head>
 
 <body id="in_frame">
 
		<div >
			
			<div class="btn_area">
			<!--
				<button type="button" onclick="btn_new()">신규</button>
				<button type="button" onclick="btn_del()">삭제</button>
			-->
			</div>
			
			<!-- 조회폼 영역 -->
			<div class="box_form"    id="top_search">
				
				<label>
					<span>사용여부</span>
						<select  id="P_USE_YN" name="P_USE_YN" >
							<option value="">전체</option>
						</select>
				</label>
				
				<label>
				<button type="button" onclick="btn_search()">조회</button>
				</label>
			</div>
			<!-- //조회폼 영역 -->
			
			<div class="col2">
			
				<div class="box_lft">
					<h3 class="bul_arr">평가항목 리스트 <button type="button" onclick="btn_del()">선택항목 삭제</button></h3>
					<div class="sec_grid">
						<div class="grid_area">
							<table id="grid1" style="width:355px"></table>
						</div>
					</div>
					
								
				</div>
				
				<div class="box_rgt">
					<h3 class="bul_arr">평가항목 추가 <button type="button" onclick="btn_save()">저장</button></h3>
					<table class="tbl_st2" style="width:355px">
						<tbody>
							<!--
							<tr>
								<th scope="row">순번</th>
								<td><input type="text" id="EVAL_ITEM_NUM" name="EVAL_ITEM_NUM"  readonly></td>
							</tr>
							  -->
							<tr>
								<th scope="row"><em>필수입력항목</em>평가항목</th>
								<td><input type="text" id="EVAL_ITEM_NAME" name="EVAL_ITEM_NAME" maxlength="50"></td>
							</tr>  
							<tr>
								<th scope="row">초기 비중값</th>   
								<td><input type="text" id="EVAL_RATE" name="EVAL_RATE" maxlength="3"></textarea></td>
							</tr>
							<tr>
								<th scope="row">사용여부</th>
								<td>
									<label class="radio">
										<input type="radio" value="Y" id="USE_YN" name="USE_YN" checked >
										<span>사용</span>
									</label>
									<label class="radio">
										<input type="radio" value="N"  name="USE_YN" >
										<span>미사용</span>
									</label>
								</td>
							</tr>
						</tbody>
					</table>		
				</div>
			
			</div>

		</div>
		<!-- //Content : 본문 영역 -->
	 

	
</body>
</html>
	
