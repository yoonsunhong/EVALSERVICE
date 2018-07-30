<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="retail.common.BaseEnv"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="retail.login.service.LoginVO" %>

<jsp:include page="/WEB-INF/jsp/retail/inc_common/inc_head.jsp" /> 
 
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densityDpi=medium-dpi" />
	<title>업무평가 앱 - 로그인</title>
	<link type="text/css" rel="stylesheet" href="/resources/css/common.css">
	<script type="text/javascript" src="/resources/js/jquery.cookie.js" charset="utf-8"></script>    
	<script type="text/javascript">
		
		$(document).ready(function (){
			// 사용사 선택_열고 닫기 이벤트
			$(".user_select .team.open").css("marginTop",'1px').next().css("marginTop",$(".user_select .team.open").find(".member").innerHeight());
			
			$(".user_select .team_name").on("click",function  () {	
				var depth1 = $(this).parent();
				var depth2Hei = depth1.find(".member").innerHeight();	
				console.log(depth2Hei);
				
				depth1.toggleClass("open").siblings().removeClass("open").css("marginTop",'1px');	
				
				if(depth1.hasClass("open") == true) depth1.css("marginTop",'1px').next().css("marginTop",depth2Hei);
				else depth1.css("marginTop",'1px');		
			});	
			
			// 사용자 선택_터치 시작할 때
			$(".user_select .member li a").bind('touchstart', function(e) {
				$(this).addClass('on');
			});

			// 사용자 선택_터치 끝났을 때
			$(".user_select .member li a").bind('touchend', function(e) {
				$(this).removeClass('on');
			});
		});
		
		function SelectUser(index1, index2) {			
			var form = document.getElementById("userform"+index1+"_"+index2);	
			form.submit();
		}		
	
		function testAlert(message1, message2) {			
			alert(message1 + " : " + message2);
		}	
		
		function goBack() {
			location.replace("/goLogin.do"); 			
		}
		
	</script>
</head>

<body>
 	<div class="user_select">
		<header><h3>사용자 선택</h3></header>
		<section>
			<ul>
				<c:forEach items="${object.depart}" var="departs" varStatus="dindex">						
					<li class="team">
						<h4 class="team_name">${departs.depart_name}</h4>
						<ul class="member">
							<c:forEach items="${departs.depart_user}" var="users" varStatus="uindex">				
								<form name="userform${dindex.index}_${uindex.index}" id="userform${dindex.index}_${uindex.index}" action="/goLogin.do" method="post" >
									<input type="hidden" id="USER_NAME" name="USER_NAME" value="${users.user_name}"> 	
									<input type="hidden" id="USER_PASS" name="USER_PASS" value="-">			
									<li><a href="#" onClick="SelectUser(${dindex.index}, ${uindex.index});"><img class="photo3" src="${users.user_pic}" alt="프로필 사진"><span>${users.user_name}</span></a></li>	
								</form>
				 			</c:forEach>
						</ul>
					</li>
				</c:forEach>
			</ul>
		</section>
		
		<!--
		<section>
			<ul>
				<li class="team">
					<h4 class="team_name">최적화팀</h4>
					<ul class="member">
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>	
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>	
					</ul>
				</li>
				
				<li class="team">
					<h4 class="team_name">스마트PI팀</h4>
					<ul class="member">
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>	
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>	
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>								
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>	
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>									
					</ul>
				</li>		
						
				<li class="team">
					<h4 class="team_name">업무혁신팀</h4>
					<ul class="member">
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>	
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>								
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>	
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>		
					</ul>
				</li>		
				
				<li class="team">
					<h4 class="team_name">POS개발팀</h4>
					<ul class="member">
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>	
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>								
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>	
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>		
					</ul>
				</li>	
				
				<li class="team">
					<h4 class="team_name">IoT컨설팅팀</h4>
					<ul class="member">
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>	
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>								
						<li><a href="#"><img src="/resources/img/icon/ico_profile.png" alt="프로필 사진"><span>홍길동</span></a></li>		
					</ul>
				</li>
			</ul>
		</section>
		-->		
		
		<a href="#" class="close_btn" onClick="goBack();"></a>
	</div> 
</body>
</html>
