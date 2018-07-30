package retail.admin.service;

import java.util.List;

import retail.common.BaseVO;


@SuppressWarnings("serial")
public class AMainDeptVO extends BaseVO {
	
	

	/*********************************************************************************************************************************
	 * * 변수 선언 
	 *********************************************************************************************************************************/
	
	private String DEPART_NUM;
	private String DEPART_NAME;
	private String USE_YN;
	
	private String USER_NUM;
	private String USER_NAME;
	private String UPUSER_NUM;
	private String UPUSER_NAME;
	
	private String REG_ID;
	private String REG_IP;
	
	private String UPD_IP;
	private String UPD_ID;
	
	private String USE_COUNT;
	
	private List ARRAY_DATA;

	
	
	/*********************************************************************************************************************************/
	
	/******************************************************************
	 * ARRAY or LIST
	 ******************************************************************/
	/**
	 * getter INFO 저장 ARRAY
	 */
	public String getSAVE_INFO_ARRAY() {
		return get("SAVE_INFO_ARRAY");
	}
	/**
	 * setter INFO 저장 ARRAY
	 */
	public void setSAVE_INFO_ARRAY(String value) {
		set("SAVE_INFO_ARRAY", value);
	}
	/**
	 * getter INFO 저장 LIST
	 */
	public List<AMainDeptVO> getSAVE_INFO_LIST() {
		return get("SAVE_INFO_LIST");
	}
	/**
	 * setter INFO 저장 LIST
	 */
	public void setSAVE_INFO_LIST(List<AMainDeptVO> value) {
		set("SAVE_INFO_LIST", value);
	}
	
	


	/*********************************************************************************************************************************
	 * * Getter
	 *********************************************************************************************************************************/
	
	public String getDEPART_NUM() {
		return DEPART_NUM;
	}

	public String getDEPART_NAME() {
		return DEPART_NAME;
	}

	public String getUSE_YN() {
		return USE_YN;
	}

	public String getUSER_NUM() {
		return USER_NUM;
	}

	public String getUSER_NAME() {
		return USER_NAME;
	}

	public String getUPUSER_NUM() {
		return UPUSER_NUM;
	}

	public String getUPUSER_NAME() {
		return UPUSER_NAME;
	}

	public String getREG_ID() {
		return REG_ID;
	}

	public String getREG_IP() {
		return REG_IP;
	}

	public String getUPD_IP() {
		return UPD_IP;
	}

	public String getUPD_ID() {
		return UPD_ID;
	}

	public String getUSE_COUNT() {
		return USE_COUNT;
	}

	public List getARRAY_DATA() {
		return ARRAY_DATA;
	}

	

	
	/*********************************************************************************************************************************/
	
	
	
	
	

	

	


	/*********************************************************************************************************************************
	 * * Setter
	 *********************************************************************************************************************************/
	
	
	public void setDEPART_NUM(String dEPART_NUM) {
		DEPART_NUM = dEPART_NUM;
	}

	public void setDEPART_NAME(String dEPART_NAME) {
		DEPART_NAME = dEPART_NAME;
	}

	public void setUSE_YN(String uSE_YN) {
		USE_YN = uSE_YN;
	}

	public void setUSER_NUM(String uSER_NUM) {
		USER_NUM = uSER_NUM;
	}

	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}

	public void setUPUSER_NUM(String uPUSER_NUM) {
		UPUSER_NUM = uPUSER_NUM;
	}

	public void setUPUSER_NAME(String uPUSER_NAME) {
		UPUSER_NAME = uPUSER_NAME;
	}

	public void setREG_ID(String rEG_ID) {
		REG_ID = rEG_ID;
	}

	public void setREG_IP(String rEG_IP) {
		REG_IP = rEG_IP;
	}

	public void setUPD_IP(String uPD_IP) {
		UPD_IP = uPD_IP;
	}

	public void setUPD_ID(String uPD_ID) {
		UPD_ID = uPD_ID;
	}

	public void setUSE_COUNT(String uSE_COUNT) {
		USE_COUNT = uSE_COUNT;
	}

	public void setARRAY_DATA(List aRRAY_DATA) {
		ARRAY_DATA = aRRAY_DATA;
	}
	
	
	/*********************************************************************************************************************************/
}
