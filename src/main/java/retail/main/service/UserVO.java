package retail.main.service;

public class UserVO {

	/*********************************************************************************************************************************
	 * * 변수 선언 
	 *********************************************************************************************************************************/ 
	
	private String USER_NUM;			// 사원번호 
	private String USER_NAME;		// 사원명 
	private String DEPART_NUM;		// 부서 번호
	private String DEPART_NAME;	// 부서명
	private String UPUSER_NUM;		// 차상위자 사원번호
	private String UPUSER_NAME;	// 차상위자 이름
	
	
	public String getUSER_NUM() {
		return USER_NUM;
	}
	public void setUSER_NUM(String uSER_NUM) {
		USER_NUM = uSER_NUM;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public String getDEPART_NUM() {
		return DEPART_NUM;
	}
	public void setDEPART_NUM(String dEPART_NUM) {
		DEPART_NUM = dEPART_NUM;
	}
	public String getUPUSER_NUM() {
		return UPUSER_NUM;
	}
	public void setUPUSER_NUM(String uPUSER_NUM) {
		UPUSER_NUM = uPUSER_NUM;
	}
	public String getUPUSER_NAME() {
		return UPUSER_NAME;
	}
	public void setUPUSER_NAME(String uPUSER_NAME) {
		UPUSER_NAME = uPUSER_NAME;
	}
	public String getDEPART_NAME() {
		return DEPART_NAME;
	}
	public void setDEPART_NAME(String dEPART_NAME) {
		DEPART_NAME = dEPART_NAME;
	}
	
	/*********************************************************************************************************************************/
	
	
	 
}
