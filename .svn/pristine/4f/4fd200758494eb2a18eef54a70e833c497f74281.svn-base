package retail.common;

import retail.login.service.LoginVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JqLoginResult {

	
	private int result;		
	private int usercount;	
	
	private JSONObject mainObject;
	private JSONArray	userDataArray;
		
	public JqLoginResult() {
		result = 0;
		usercount = 0;
		
		mainObject = new JSONObject();
		userDataArray = new JSONArray();
	}
	
	public void setResult(int result) {
		this.result = result;		
	}
	
	public void addUserData(LoginVO loginVo) {
		
		JSONObject user = new JSONObject();
		user.put("user_num", loginVo.getUSER_NUM());
		user.put("user_name", loginVo.getUSER_NAME());
		user.put("depart_num", loginVo.getDEPART_NUM());
		user.put("depart_name", loginVo.getDEPART_NAME());
		user.put("upuser_num", loginVo.getUPUSER_NUM());
		user.put("upuser_name", loginVo.getUPUSER_NAME());
		
		userDataArray.add(user);
	}
	
	public String getJsonString() {
					
		usercount = userDataArray.size();		
		
		mainObject.put("result", Integer.toString(result));	
		mainObject.put("user_count", Integer.toString(usercount));				
		mainObject.put("user_data", userDataArray);
		
		return mainObject.toString();
	}
	
	
}
