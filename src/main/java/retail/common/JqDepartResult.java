package retail.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import retail.eval.service.EvalResultVO;
import retail.eval.service.GradeItemVO;
import retail.login.service.LoginVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JqDepartResult {

	
	private int result;		
	
	private JSONObject mainObject;
	private JSONArray	departArray;
		
	public JqDepartResult() {
		result = 0;
		
		mainObject = new JSONObject();
		departArray = new JSONArray();
	}
	
	public void setResult(int result) {
		this.result = result;		
	}
	
	public void addDepart(LoginVO loginVo, List<LoginVO> users, HttpServletRequest request) {	
		JSONObject depart = new JSONObject();
		JSONArray userArray = new JSONArray();

		depart.put("depart_num", loginVo.getDEPART_NUM());
		depart.put("depart_name", loginVo.getDEPART_NAME());
		
		if(users.size() > 0) {
			for(int i = 0 ; i < users.size() ; i++) {
				JSONObject user = new JSONObject();
				user.put("user_num", users.get(i).getUSER_NUM());
				user.put("user_name", users.get(i).getUSER_NAME());		
				user.put("user_pic", CommonUtil.checkUserImg(users.get(i).getUSER_NUM(), request));					
				
				userArray.add(user);
			}
		}
		
		depart.put("depart_user", userArray);
		
		departArray.add(depart);
	}	
	
	public JSONObject getJsonObject() {		
		
		mainObject = new JSONObject();		
		mainObject.put("result", result);
		mainObject.put("depart", departArray);			
		
		return mainObject;
	}
	
	
}
