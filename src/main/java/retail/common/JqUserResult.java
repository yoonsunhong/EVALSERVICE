package retail.common;

import retail.main.service.UserVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JqUserResult {
	
	private int result;		
	private int usercount;	
	
	private JSONObject mainObject;
	private JSONArray	userDataArray;
		
	public JqUserResult() {
		result = 0;
		usercount = 0;
		
		mainObject = new JSONObject();
		userDataArray = new JSONArray();
	}
	
	public void setResult(int result) {
		this.result = result;		
	}
	
	public void addUserData(UserVO userVo) {
		
		JSONObject user = new JSONObject();
		user.put("user_num", userVo.getUSER_NUM());
		user.put("user_name", userVo.getUSER_NAME());
		user.put("depart_num", userVo.getDEPART_NUM());
		user.put("depart_name", userVo.getDEPART_NAME());
		user.put("upuser_num", userVo.getUPUSER_NUM());
		user.put("upuser_name", userVo.getUPUSER_NAME());
		
		userDataArray.add(user);
	}
	
	public String getJsonString() {
		processJSON();
		return mainObject.toString();
	}
	
	public JSONObject getJsonObject() {		
		processJSON();
		return mainObject;
	}	
	
	private void processJSON() {
		
		mainObject = new JSONObject();					
		usercount = userDataArray.size();		
		
		mainObject.put("result", Integer.toString(result));	
		mainObject.put("user_count", Integer.toString(usercount));				
		mainObject.put("user_data", userDataArray);
	}
	
}
