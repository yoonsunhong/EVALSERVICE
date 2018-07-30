<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="retail.common.BaseEnv"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/jsp/retail/inc_common/inc_common.jsp" %>

<jsp:include page="/WEB-INF/jsp/retail/inc_common/inc_head.jsp" /> 
 
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi" />
	<title>업무평가 앱 - 평가 그래프</title>
	<link type="text/css" rel="stylesheet" href="/resources/css/common.css">
	<!-- link type="text/css" rel="stylesheet" href="/resources/css/main.css"-->	
	
	<script type="text/javascript">		

	
		function goMain() {
			window.location = "/goMain.do";
		}
		
		function fnGoTest() {
			fnGo(); 
		}
		
		function fnGo() {		  	
		  	//frm.target = "graphFrame";
		  	//frm.action="/testGraph.do";
		  	//frm.submit();
		  	
		  	$('#graphFrame').attr("src", "testGraph.do");
		}
		
		function selectUser() {
			var form = document.getElementById("form2");
			form.submit();
		}
	</script>	
</head>

	
	
 <body>
	<!-- ========== header ========== -->
	<header>
		<div class="tit_cnt">
			<span class="menu"><img src="/resources/img/icon/ico_menu.png" alt="메뉴 아이콘"></span>
			<h2 class="title">평가그래프</h2>		
		</div>
		<div class="sub_bg"></div>
		<div class="user_cnt area">
			<img class="photo3" src="<%=getEnv().getUser_pic()%>" alt="프로필 사진"> 
			<span class="user_name"><%=getEnv().getUser_name()%></span><span> 님</span><span>(<%=getEnv().getDepart_name()%>, 사원번호: <%=getEnv().getUser_num()%>)</span>
		</div>
	</header>			
	
<%-- 	<header>
		<div class="div_left">
			<span class="title">평가 그래프</span> <input type="button" onclick="goMain();" value="메인화면">
		</div>	
		<div class="div_left">
			<span class="info">부서 : <%=getEnv().getDepart_name()%></span><br><span class="info">사원번호 : <%=getEnv().getUser_num()%>, 사원명 : <%=getEnv().getUser_name()%> </span>
		</div>		
	</header>	 --%>	
	<!-- ========== //header ========== -->
	
	<!-- ========== gnb ========== -->
	<%@include file="/WEB-INF/jsp/retail/main/menu.jsp" %>
	<!-- ========== //gnb ========== -->	

	<!-- ========== content ========== -->
	<section class="graph_area">						
		<div class="area">
			<!--  <form name="form2" id="form2" action="/testGraph.do" method="post" target="graphFrame"> -->
			<form name="form2" id="form2" action="/viewEvalGraph.do" method="post" target="graphFrame"> 		
			<div class="clear">
				<div class="f_l">
					<div class="f_l p_r">
						<span class="subtitle select1">검색기간</span>
						<label for="PERIOD_YEAR" class="select_bul"></label>
						<select class="select" name= "PERIOD_YEAR" id="PERIOD_YEAR">
							<c:forEach items="${period}" var="year" varStatus="index">	
								<c:choose>
									<c:when test="${index.last}">
										<option value="${year}" selected="selected">${year}</option>	        
							    	</c:when>	
							    	<c:otherwise>
							    		<option value="${year}">${year}</option>
							    	</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>						
					</div>
					<div class="f_l p_r">
						<span class="subtitle select2">사원</span> 
						<label for="USER_NUM" class="select_bul"></label>
						<select class="" name= "USER_NUM" id="USER_NUM">
							<c:forEach items="${object}" var="list" varStatus="index">
								<option value="${list.getUSER_NUM()}">${list.getUSER_NAME()}</option>
								<c:if test="${index.first}">
									<c:if test="${!index.last}">
										<optgroup label="하위 사원">
									</c:if>
								</c:if>	
							</c:forEach>
						</select>						
					</div>			
				</div>
				<input class="f_r btn_stl2 btn_search" type="button" onclick="selectUser();" value="검색">
			</div>	
<%-- 				<table>
					<tr>
						<td>
							<span class="subtitle">검색 기간</span>
							<select class="select" name= "PERIOD_YEAR" id="PERIOD_YEAR">
								<c:forEach items="${period}" var="year">
									<option value="${year}">${year}</option>
								</c:forEach>
							</select>
						</td>
						<td rowspan="2">
							<input class="btn_stl2 btn_search" type="button" onclick="selectUser();" value="검색">
						</td>
					</tr>
					<tr>
						<td>
							<span class="subtitle">사원 선택</span> 
							<select class="select" name= "USER_NUM" id="USER_NUM">
								<c:forEach items="${object}" var="list" varStatus="index">
									<option value="${list.getUSER_NUM()}">${list.getUSER_NAME()}</option>
									<c:if test="${index.first}">
										<c:if test="${!index.last}">
											<optgroup label="하위 사원">
										</c:if>
									</c:if>	
								</c:forEach>
							</select>
						</td>
					</tr>				
				</table> --%>
			</form>
		</div>	
				
		<div>
			<iframe id="graphFrame" name="graphFrame" style="width:100%; height:70%" src=""></iframe>						
		</div>	
	
	</section>
	<!-- ========== //content ========== -->

	<!-- ========== footer ========== -->
	<!-- ========== //footer ========== -->
 </body>
</html>
