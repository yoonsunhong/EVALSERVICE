<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="retail.common.BaseEnv"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/WEB-INF/jsp/retail/inc_common/inc_head.jsp" /> 
 
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi" />
	<title>업무평가 앱 - 비밀번호 최초등록</title>
	<link type="text/css" rel="stylesheet" href="/resources/css/common.css">
	<script type="text/javascript">
	
		function regist(){
			   
			if( $("#USER_NAME").val()  == "" )
			{
				alert("사원명을 입력하세요.");
				 $("#USER_NAME").focus();
				return;
			}
			
			if( $("#USER_PASS").val()  == "" )
			{
				alert("비밀번호를 입력하세요.");
				 $("#USER_PASS").focus();
				return;
			}
			
			if( $("#CUSER_PASS").val()  == "" )
			{
				alert("비밀번호확인란을  입력하세요.");
				 $("#CUSER_PASS").focus();
				return;
			}
			
			if( $("#USER_PASS").val() != $("#CUSER_PASS").val() )
			{
				alert("입력한 비밀번호가 일치하지 않습니다.");
				 $("#CUSER_PASS").focus();
				return;
			}
			
			<!--비밀번호 설정 확인-->
			var form = document.getElementById("form1");
			$.ajax({
				url:"/regist.do" ,
				type:"POST",
				datatype:"json",
				data:{ user_name: $("#USER_NAME").val()   ,  user_pass :$("#USER_PASS").val() },
				beforeSend : function(xhr) {} ,
				success:function(data,textStatus){  
					if(data.result != "0" ) { 
						if(data.result == "1") {
							alert("일치하는 사원정보가 없습니다.");
						}
						else if(data.result == "2") {
							alert("비밀번호가 이미 등록된 상태입니다.");
						}
						else {
							alert("비밀번호 설정 오류!\n관리자에게 문의하세요.");
						}						
					} else {
						alert("비밀번호가 정상적으로 설정되었습니다.\n로그인 화면으로 이동합니다.");
						//location.replace("/goLogin.do"); 
						form.submit(); 
					} 
				},
				error:function(x,e){
				}	 
			});
		}
		
		//엔터입력시 로그인 요청 
		function search_check(){
			regist();
		}
		
		function cancel() {
			alert("비밀번호 설정이 취소되었습니다.");
			location.href="goLogin.do"; 
		}
		
		//팝업을 위한 쿠키 (추후 사용)
		function getCookie(cname) 
		{   
			var name = cname + "=";
		    var ca = document.cookie.split(';');
		    for(var i=0; i<ca.length; i++) {
		        var c = ca[i];
		        while (c.charAt(0)==' ') c = c.substring(1);
		        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
		    } 
		    return "";
		}
	</script>
</head>
<body class="eval_regist">
 	<div>
		<!-- ========== header ========== -->
		<div class="div_center">
			<h1 class="login_title"><img src="/resources/img/login/regist_logo.png" alt="리테일테크 업무평가"></h1>		
		</div>
		<!-- ========== //header ========== -->
	
		<!-- ========== content ========== -->
		<section>
			<div class="div_center">			
				<table class="table_center">
					<form name="form1" id="form1"  action="/goLogin.do" method="post"   > 
						<tbody>
							<tr>
								<td><input type=text name="USER_NAME" id = "USER_NAME"   maxlength="15" value="${name}" readonly></td>
							</tr>
							<tr>
								<td><input type=password name="USER_PASS" id="USER_PASS" maxlength="15" value="${pass}" placeholder="비밀번호"></td>
							</tr>
							<tr>
								<td><input type=password name="CUSER_PASS" id="CUSER_PASS"  maxlength="15"  placeholder="비밀번호 확인" onKeyDown="javascript:if (event.keyCode == 13) search_check();"></td>
							</tr>
						</tbody>
					</form>	
				</table>	
			</div>
			<input class="btn_stl1" type="button" onClick="regist();" value="등록">					
		</section>
		<a class="cancel" onclick="cancel();">취소</a>			
		<!-- ========== //content ========== -->
	</div>
 </body> 	
<%--  <body>
	<!-- ========== header ========== -->
	<header>
		<h1 class="title">비밀번호 최초등록</h1>
	</header>	
	<!-- ========== //header ========== -->	
	
	<!-- ========== content ========== -->
	<section>			
		<div class="div_center">
			<table class="table_center">
				<form name="form1" id="form1"  action="/goLogin.do" method="post"   > 
					<tbody>
						<tr>
							<td><span class="lable">[사원명]</span></td>
						</tr>
						<tr>
							<td><input type=text name="USER_NAME" id = "USER_NAME"   maxlength="15" value="${name}"></td>
						</tr>
						<tr>
							<td><span class="lable">[비밀번호]</span></td>
						</tr>
						<tr>
							<td><input type=password name="USER_PASS" id="USER_PASS" maxlength="15" value="${pass}"></td>
						</tr>
						<tr>
							<td><span class="lable">[비밀번호확인]</span></td>
						</tr>
						<tr>
							<td><input type=password name="CUSER_PASS" id="CUSER_PASS"  maxlength="15" onKeyDown="javascript:if (event.keyCode == 13) search_check();"></td>
						</tr>
					</tbody>
				</form>	
			</table>			
		</div>
		
		<article>
			<input class="button2" type="button"   onClick="regist();" value="등록">
			<input class="button2" type="button" onclick="cancel();" value="취소">		
		</article>			
	</section>
	<!-- ========== //content ========== --> --%>
</body>

</html>
