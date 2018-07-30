package retail.eval.service;

public class EvalResultVO {
	
	private String EVAL_INDEX;				// 평가이력 고유번호
	private String EVAL_ITEM_NUM;			// 평가항목번호
	private String EVAL_ITEM_NAME;		// 평가항목명
	private String EVAL_RATE;				// 평가비중(비율)
	private String GRADE_ITEM_NUM;		// 등급번호
	private String GRADE_ITEM_NAME;		// 등급명
	private String EVAL_TYPE;				// 평가유형 (0:본인평가, 1:차상위자평가)
	private String EVAL_COMMENT;			// 평가 Comment
	

	public String getEVAL_INDEX() {
		return EVAL_INDEX;
	}
	public void setEVAL_INDEX(String eVAL_INDEX) {
		EVAL_INDEX = eVAL_INDEX;
	}	
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
	public String getGRADE_ITEM_NUM() {
		return GRADE_ITEM_NUM;
	}
	public void setGRADE_ITEM_NUM(String gRADE_ITEM_NUM) {
		GRADE_ITEM_NUM = gRADE_ITEM_NUM;
	}
	public String getGRADE_ITEM_NAME() {
		return GRADE_ITEM_NAME;
	}
	public void setGRADE_ITEM_NAME(String gRADE_ITEM_NAME) {
		GRADE_ITEM_NAME = gRADE_ITEM_NAME;
	}
	public String getEVAL_TYPE() {
		return EVAL_TYPE;
	}
	public void setEVAL_TYPE(String eVAL_TYPE) {
		EVAL_TYPE = eVAL_TYPE;
	}
	public String getEVAL_COMMENT() {
		if(EVAL_COMMENT != null) {
			return EVAL_COMMENT;
		} else {
			return "";
		}
	}
	public void setEVAL_COMMENT(String eVAL_COMMENT) {
		EVAL_COMMENT = eVAL_COMMENT;
	}
		
}
