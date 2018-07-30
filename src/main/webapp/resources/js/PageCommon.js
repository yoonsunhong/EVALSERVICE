function topBtnFuncMake(asHideBtnId) {

	$(asHideBtnId).hide();
	
	$("#btns button").click(function () {
		
		lsId = $(this).attr("id");
		
		if( typeof(eval(lsId)) != "function" ) {
			
			alert(lsId + "() 처리 함수가 존재하지 않습니다 !\n관리자에 문의 바랍니다.");
			
		} else {
			eval(lsId + "()");
		}
	});
	
}