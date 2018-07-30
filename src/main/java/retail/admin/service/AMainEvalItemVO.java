package retail.admin.service;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Map; 

import net.winis.common.shared.model.WisModelData;

@SuppressWarnings("serial") 
public class AMainEvalItemVO extends WisModelData {


	private String  EVAL_ITEM_NUM;
	private String  DEPART_NUM;
	private String  EVAL_ITEM_NAME;
	private String  EVAL_RATE;
	private String  USE_YN;
	
	
	private String  SORT;
	private String  ORIGIN_GRADE_ITEM_NUM;
	private String  Ret_cd; 
	private String  Result;
	private String  CNT;

	/** getter - 결과값 리스트 */
//	public List<?> getContent() {
//		List<?> list = get("content");
//		if( list == null ) {
//			list = new ArrayList<Map<String, Object>>();
//			this.setContent(list);
//		}
//		return list;
//	} 
//	/** setter - 결과값 리스트 */
//	public void setContent(List<?> list) {
//		set("content", list);
//	}
	
	public String getEVAL_ITEM_NUM() {
		return EVAL_ITEM_NUM;
	}
	public void setEVAL_ITEM_NUM(String eVAL_ITEM_NUM) {
		EVAL_ITEM_NUM = eVAL_ITEM_NUM;
	}

	public String getEVAL_ITEM_NAME() {
		return EVAL_ITEM_NAME;
	}
	public void setEVAL_ITEM_NAME(String eVAL_ITEM_NAME) {
		EVAL_ITEM_NAME = eVAL_ITEM_NAME;
	}	
	
	public String getEVAL_RATE() {
		return EVAL_RATE;
	}
	public void setEVAL_RATE(String eVAL_RATE) {
		EVAL_RATE = eVAL_RATE;
	}	
	
	public String getUSE_YN() {
		return USE_YN;
	}
	public void setUSE_YN(String uSE_YN) {
		USE_YN = uSE_YN;
	}
	
	
	public String getDEPART_NUM() {
		return DEPART_NUM;
	}
	public void setDEPART_NUM(String dEPART_NUM) {
		DEPART_NUM = dEPART_NUM;
	}
	

	

	

	
//	public String getGRADE_ITEM_TYPE_CODE() {
//		return GRADE_ITEM_TYPE_CODE;
//	}
//	public void setGRADE_ITEM_TYPE_CODE(String gRADE_ITEM_TYPE_CODE) {
//		GRADE_ITEM_TYPE_CODE = gRADE_ITEM_TYPE_CODE;
//	}

//	public String getGRADE_ITEM_NAME() {
//		return GRADE_ITEM_NAME;
//	}
//	public void setGRADE_ITEM_NAME(String gRADE_ITEM_NAME) {
//		GRADE_ITEM_NAME = gRADE_ITEM_NAME;
//	}
//	public String getSORT() {
//		return SORT;
//	}
//	public void setSORT(String sORT) {
//		SORT = sORT;
//	}
//	public String getREMARK() {
//		return REMARK;
//	}
//	public void setREMARK(String rEMARK) {
//		REMARK = rEMARK;
//	}

//	public String getORIGIN_GRADE_ITEM_NUM() {
//		return ORIGIN_GRADE_ITEM_NUM;
//	}
//	public void setORIGIN_GRADE_ITEM_NUM(String oRIGIN_GRADE_ITEM_NUM) {
//		ORIGIN_GRADE_ITEM_NUM = oRIGIN_GRADE_ITEM_NUM;
//	}
//	public String getRet_cd() {
//		return Ret_cd;
//	}
//	public void setRet_cd(String ret_cd) {
//		Ret_cd = ret_cd;
//	}
//	public String getResult() {
//		return Result;
//	}
//	public void setResult(String result) {
//		Result = result;
//	}
//	public String getCNT() {
//		return CNT;
//	}
//	public void setCNT(String cNT) {
//		CNT = cNT;
//	}
	
	

}
