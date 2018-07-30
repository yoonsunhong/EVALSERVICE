package retail.common;

import retail.eval.service.EvalResultVO;
import retail.eval.service.EvalVO;
import retail.eval.service.GradeItemVO;
import retail.login.service.LoginVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JqEvalResult {

	
	private int result;		
	
	private int evalcount;	
	private int upevalcount;	
	//private int gradecount;	
	
	private String eval_index;
	private String user_num;
	private String user_name;
	private String depart_num;
	private String depart_name;
	private String period_from;
	private String period_to;
	private String eval_with;
	private String upeval_with;	
	private String upuser_num;
	private String upuser_name;
	
	private String eval_index_prev;
	private String eval_index_next;
	
	
	private JSONObject mainObject;
	private JSONArray	evalDataArray;
	private JSONArray	upEvalDataArray;
	//private JSONArray	gradeItemArray;
		
	public JqEvalResult() {
		result = 0;
		evalcount = 0;
		upevalcount = 0;
		//gradecount = 0;
		
		mainObject = new JSONObject();
		evalDataArray = new JSONArray();
		upEvalDataArray = new JSONArray();
		//gradeItemArray = new JSONArray();
	}
	
	public void setResult(int result) {
		this.result = result;		
	}
	
	public void addEvalData(EvalVO evalVo) {		
		eval_index 			= evalVo.getEVAL_INDEX();
		user_num			= evalVo.getUSER_NUM();
		user_name			= evalVo.getUSER_NAME();
		depart_num			= evalVo.getDEPART_NUM();
		depart_name		= evalVo.getDEPART_NAME();
		period_from			= evalVo.getPERIOD_FROM();
		period_to			= evalVo.getPERIOD_TO();
		eval_with			= evalVo.getEVAL_WITH();
		upeval_with			= evalVo.getUPEVAL_WITH();		
		upuser_num			= evalVo.getUPUSER_NUM();
		upuser_name		= evalVo.getUPUSER_NAME();
		
		eval_index_prev	= evalVo.getEVAL_INDEX_PREV();
		eval_index_next	= evalVo.getEVAL_INDEX_NEXT();
	}
	
	public void addEvalResultData(EvalResultVO evalResultVo) {
		
		JSONObject eval = new JSONObject();
		eval.put("eval_index", evalResultVo.getEVAL_INDEX());
		eval.put("eval_item_num", evalResultVo.getEVAL_ITEM_NUM());
		eval.put("eval_item_name", evalResultVo.getEVAL_ITEM_NAME());
		eval.put("eval_rate", evalResultVo.getEVAL_RATE());
		eval.put("grade_num", evalResultVo.getGRADE_ITEM_NUM());
		eval.put("grade_name", evalResultVo.getGRADE_ITEM_NAME());
		eval.put("eval_type", evalResultVo.getEVAL_TYPE());
		eval.put("eval_comment", evalResultVo.getEVAL_COMMENT());
		
		evalDataArray.add(eval);
	}
	
	public void addUpEvalResultData(EvalResultVO evalResultVo) {
		
		JSONObject eval = new JSONObject();
		eval.put("eval_index", evalResultVo.getEVAL_INDEX());
		eval.put("eval_item_num", evalResultVo.getEVAL_ITEM_NUM());
		eval.put("eval_item_name", evalResultVo.getEVAL_ITEM_NAME());
		eval.put("eval_rate", evalResultVo.getEVAL_RATE());
		eval.put("grade_num", evalResultVo.getGRADE_ITEM_NUM());
		eval.put("grade_name", evalResultVo.getGRADE_ITEM_NAME());
		eval.put("eval_type", evalResultVo.getEVAL_TYPE());
		eval.put("eval_comment", evalResultVo.getEVAL_COMMENT());
		
		upEvalDataArray.add(eval);
	}
	
//	public void addGradeItemData(GradeItemVO gradeItemVo) {
//		JSONObject gradeItem = new JSONObject();
//		gradeItem.put("grade_num", gradeItemVo.getGRADE_ITEM_NUM());
//		gradeItem.put("grade_name", gradeItemVo.getGRADE_ITEM_NAME());
//		
//		gradeItemArray.add(gradeItem);
//	}
	
	public String getJsonString() {
					
		evalcount = evalDataArray.size();		
		upevalcount = upEvalDataArray.size();	 
		//gradecount = gradeItemArray.size();	 
		
		mainObject.put("result", Integer.toString(result));	
		mainObject.put("eval_index", eval_index);	
		mainObject.put("user_num", user_num);
		mainObject.put("user_name", user_name);
		mainObject.put("depart_num", depart_num);
		mainObject.put("depart_name", depart_name);
		mainObject.put("period_from", period_from);	
		mainObject.put("period_to", period_to);	
		mainObject.put("eval_with", eval_with);	
		mainObject.put("upeval_with", upeval_with);	
		mainObject.put("upuser_num", upuser_num);
		mainObject.put("upuser_name", upuser_name);
		
		mainObject.put("eval_index_prev", eval_index_prev);	
		mainObject.put("eval_index_next", eval_index_next);	
		
		mainObject.put("eval_results_count", Integer.toString(evalcount));				
		mainObject.put("eval_results_array", evalDataArray);		
		mainObject.put("upeval_results_count", Integer.toString(upevalcount));	
		mainObject.put("upeval_results_array", upEvalDataArray);	
		//mainObject.put("grade_items_count", Integer.toString(gradecount));	
		//mainObject.put("grade_items_array", gradeItemArray);
		
		return mainObject.toString();
	}
	
	
}
