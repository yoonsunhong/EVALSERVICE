<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="retail.common.BaseEnv"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">		
	function goMain() {
		window.location = "/goMain.do";
	}

	function userEval() {
		window.location = "/goEval.do";
	}
	
	function upuserEval() {	
		window.location = "/goSelect.do";
	}
	
	function evalGraph() {
		window.location = "/goGraph.do";
	}
	function logOut() {
		window.location = "/logout.do";
	}

	
	$(document).ready(function (){
		// 메뉴 아이콘 클릭시 메뉴 영역 생성
		$(".menu").on("click",function  () {
			$("#gnb").addClass("open");
		});		
		
		// 메뉴 영역 닫기
		$(".home .close_btn").on("click",function  () {
			$("#gnb").removeClass("open");
		});
	});		
</script>

<body>
	<nav id="gnb">
		<div class="home clear">
			<h3 class="f_l" onClick="goMain()">홈으로</h3>
			<a href="#" class="f_r close_btn"></a>
		</div>
		<ul>
			<li><a href="#" onClick="userEval();">본인평가</a></li>
			<li><a href="#" onClick="upuserEval();">차상위평가</a></li>
			<li><a href="#" onClick="evalGraph();">평가그래프</a></li>
		</ul>	
		<a href="#" class="f_r logout" onClick="logOut();">로그아웃</a>
	</nav>
</body>