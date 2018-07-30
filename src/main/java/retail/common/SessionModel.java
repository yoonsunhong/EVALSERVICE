package retail.common;

 
public class SessionModel   {
	
	// 사원번호
	private String user_num;
	// 사원명
	private String user_name;
	// 부서번호
	private String depart_num;
	// 부서명
	private String depart_name;
	// 상위사원번호
	private String upuser_num;
	// 상위사원명
	private String upuser_name;	
	// 입사일
	private String user_date;	
	
	//180116 추가 : 사원이미지 경로
	private String user_pic;
	
	
	public String getUser_num() {
		return user_num;
	}
	public void setUser_num(String user_num) {
		this.user_num = user_num;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getDepart_num() {
		return depart_num;
	}
	public void setDepart_num(String depart_num) {
		this.depart_num = depart_num;
	}
	public String getDepart_name() {
		return depart_name;
	}
	public void setDepart_name(String depart_name) {
		this.depart_name = depart_name;
	}
	public String getUpuser_num() {
		return upuser_num;
	}
	public void setUpuser_num(String upuser_num) {
		this.upuser_num = upuser_num;
	}
	public String getUpuser_name() {
		return upuser_name;
	}
	public void setUpuser_name(String upuser_name) {
		this.upuser_name = upuser_name;
	}
	public String getUser_date() {
		return user_date;
	}
	public void setUser_date(String user_date) {
		this.user_date = user_date;
	}
	public String getUser_pic() {
		return user_pic;
	}
	public void setUser_pic(String user_pic) {
		this.user_pic = user_pic;
	}

//	//기업코드
//	private String CORP_CODE;
//	
//	//아이디
//	private String userId;
//	
//	//성명
//	private String userNm;
//	 
//	 
//	 
//	
//	// 핸드폰
//	private String PHON_NO;
//	
//	// 이메일
//	private String EMAIL_ACCNT; 
//	  
//	 
//	
//	
//	 
//	public String getCORP_CODE() {
//		return CORP_CODE;
//	}
//	public void setCORP_CODE(String cORP_CODE) {
//		CORP_CODE = cORP_CODE;
//	}
//	public String getUserId() {
//		return userId; 		
//	} 
//	public void setUserId(String value) {
//		this.userId = value; 
//	}
//	 
//	public String getUserNm() {
//		return userNm; 		
//	} 
//	public void setUserNm(String value) {
//		this.userNm = value; 
//	}
// 
//	
//	public String getPHON_NO()
//	{
//		return this.PHON_NO;
//	}
//	
//	public void setPHON_NO(String pPHON_NO)
//	{
//		this.PHON_NO = pPHON_NO;
//	}
//	
//	public String getEMAIL_ACCNT()
//	{
//		return this.EMAIL_ACCNT;
//	}
//	
//	public void setEMAIL_ACCNT(String pEMAIL_ACCNT)
//	{
//		this.EMAIL_ACCNT = pEMAIL_ACCNT;
//	}
}
