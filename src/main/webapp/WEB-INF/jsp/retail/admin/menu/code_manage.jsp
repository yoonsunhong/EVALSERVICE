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

	<script type="text/javascript" src="/resources/js/page/adm/AMainCode.js" charset="utf-8"></script>
	<script type="text/javaScript" language="javascript" defer="defer"> </script>
</head>
 
 <body id="in_frame">
 
		<div >
			
			<div class="btn_area">
				<!--<button type="button" onclick="btn_new()">신규</button>-->
			</div>
			
			<!-- 조회폼 영역 -->
			<div class="box_form"    id="top_search">
				<label>
					<span>분류명</span>
					<input type="text" id="P_GRADE_ITEM_NAME" name="P_GRADE_ITEM_NAME"   maxlength="50">    
				</label>
				
				<label>
					<span>사용여부</span>
					<select id="P_USE_YN" name="P_USE_YN">
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
					<h3 class="bul_arr">공통코드 분류<button type="button" onclick="btn_del()">선택목록 삭제</button></h3>
					<div class="sec_grid">
						<div class="grid_area">
							<table id="grid1" style="width:355px"></table>
						</div>
					</div>	
					
					<h3 class="bul_arr">공통코드 추가<button type="button" onclick="btn_save()">저장</button></h3>
					<table class="tbl_st2">
						<tbody>
							<tr>
								<th scope="row"><em>필수입력항목</em>분류명</th>
								<td><input type="text" id="GRADE_ITEM_NAME" name="GRADE_ITEM_NAME" maxlength="15"></td>
							</tr>     
							<!--
							<tr>
								<th scope="row">분류코드</th>
								<td><input type="text" id="GRADE_ITEM_NUM" name="GRADE_ITEM_NUM"  readonly></td>
							</tr>
							  -->
							<tr>
								<th scope="row">설명</th>   
								<td><textarea id="REMARK" name="REMARK"  maxlength="150" ></textarea></td>
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
				
				<div class="box_rgt">
					<section class="sec_grid">
						<!-- <button type="button" onclick="btn_new_detail();">상세 신규</button> -->
						<h3 class="bul_arr">공통코드 상세<button type="button" onclick="btn_del_detail()">선택항목 삭제</button></h3>

						<div class="grid_area">
							<table id="grid2" style="width:355px"></table>
						</div>
					</section>
					
					<h3 class="bul_arr">상세코드 추가<button type="button" onclick="btn_save_detail()">저장</button></h3>
					<table class="tbl_st2">
						<input type="hidden"  id="D_ORIGIN_GRADE_ITEM_NUM" name="D_ORIGIN_GRADE_ITEM_NUM">
						<tbody>
							<tr>
								<th scope="row"><em>필수항목</em>코드</th>   
								<td colspan="3"><input type="text"  id="D_GRADE_ITEM_NUM" name="D_GRADE_ITEM_NUM" maxlength="5"></td>
							</tr>
							<tr>
								<th scope="row"><em>필수항목</em>코드명</th>
								<td colspan="3"><input type="text" id="D_GRADE_ITEM_NAME" name="D_GRADE_ITEM_NAME" maxlength="15"></td>
							</tr>
							<tr>
								<th scope="row">코드설명</th>
								<td colspan="3"><textarea id="D_REMARK" name="D_REMARK" maxlength="150"></textarea></td>
							</tr>
							<tr>
								<th scope="row">순서</th>
								<td><input type="text" id="D_SORT" name="D_SORT" maxlength="2"></td>
								<th scope="row">사용여부</th>
								<td>
									<div class="selectbox">
										<select id="D_USE_YN" name="D_USE_YN">
											<option value="Y">사용</option>
											<option value="N">미사용</option>
										</select>
									</div>
								</td>
							</tr>
						</tbody>
					</table>	
				</div>
			
			</div>

		</div>
		<!-- //Content : 본문 영역 -->
	 
<!-- 	 상세 팝업 영역 시작  -->
<!--
<div id="pop_wrap">
	<header id="pop_head">
		<h1 class="bul_arr">공통코드 상세 정보</h1>
	</header>
 
	<form action="">
		<div id="pop_cnt">
	
			<table class="tbl_st2">
						<input type="hidden"  id="D_ORIGIN_GRADE_ITEM_NUM" name="D_ORIGIN_GRADE_ITEM_NUM">
				<tbody>
					<tr>
						<th scope="row"><em>필수항목</em>코드</th>   
						<td colspan="3"><input type="text"  id="D_GRADE_ITEM_NUM" name="D_GRADE_ITEM_NUM" maxlength="5"></td>
					</tr>
					<tr>
						<th scope="row"><em>필수항목</em>코드명</th>
						<td colspan="3"><input type="text" id="D_GRADE_ITEM_NAME" name="D_GRADE_ITEM_NAME" maxlength="15"></td>
					</tr>
					<tr>
						<th scope="row">코드설명</th>
						<td colspan="3"><textarea id="D_REMARK" name="D_REMARK" maxlength="150"></textarea></td>
					</tr>
					<tr>
						<th scope="row">순서</th>
						<td><input type="text" id="D_SORT" name="D_SORT" maxlength="2"></td>
						<th scope="row">사용여부</th>
						<td>
							<div class="selectbox">
								<select id="D_USE_YN" name="D_USE_YN">
									<option value="Y">사용</option>
									<option value="N">미사용</option>
								</select>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	
		<footer id="pop_foot">
			<button type="button" class="btn_st1 pal" onclick="btn_del_detail()">상세코드삭제</button>
			
			<button type="button" class="btn_st1" onclick="btn_save_detail()">저장</button>
			<button type="button" class="btn_st1" onclick="btn_close()">취소</button>
		</footer>
		
	</form>

</div>
  -->	 
<!-- 	 상세 팝업 영역 끝  -->
	
</body>
</html>
	
