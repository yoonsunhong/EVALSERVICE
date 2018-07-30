package retail.common;
 

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import retail.eval.service.EvalResultVO;
import retail.eval.service.EvalVO;
import retail.eval.service.GradeItemVO;
import retail.seed.SeedCipher;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.winis.common.util.WisConvertUtil;
import java.util.UUID;

public class CommonUtil {

	
	/**
	 * 
	 * 아이피 가져오기
	 * @throws UnknownHostException 
	 * */
	public static String getIpAddr() throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost(); 
		String strIP = addr.getHostAddress(); 
//		String strHostName = addr.getHostName(); 
		return strIP;
	}
	
	 
	/**
	 * '공통' 으로 사용되는 '숫자 포멧변환' Method 'String 형태의 숫자와 원하는 포멧' 를 받아 '변환' 한다. 포멧 사용
	 * ex) "#,###" <-천단위마다 콤마
	 * 
	 * @param numberString
	 * @param format
	 * @return
	 */
	public static String NumberFormatter(String numberString, String format) {

		int number = Integer.parseInt(numberString);
		DecimalFormat decimalFormat = new DecimalFormat(format);
		String result = (String) decimalFormat.format(number);

		return result;

	}

	public static String NumberFormatter(Integer number, String format) {

		DecimalFormat decimalFormat = new DecimalFormat(format);
		String result = (String) decimalFormat.format(number);

		return result;

	}

	/** 세션의 사용자 환경정보 반환 */
	public static SessionModel getEnv(HttpSession session) {
		return (SessionModel) session.getAttribute(BaseEnv.PROP_ENV);
	}	
	public static SessionAModel getAEnv(HttpSession session) {
		return (SessionAModel) session.getAttribute(BaseEnv.PROP_AENV);
	}

	/** 세션에 사용자 환경정보 저장. */
	public static void setEnv(HttpSession session, SessionModel env) {
		session.setAttribute(BaseEnv.PROP_ENV, env);
	}
	public static void setAEnv(HttpSession session, SessionAModel env) {
		session.setAttribute(BaseEnv.PROP_AENV, env);
	}

	/** 보안정책 검증한다. */
	public static void validatePolicy(HttpServletRequest request) {
		// validateProtocol(request);
		validateSession(request);
	}

	/** 세션을 검증한다. */
	public static void validateSession(HttpServletRequest request) {
		// 로긴상태인지 확인
		if (CommonUtil.getEnv(request.getSession()) == null) {
			throw new SessionException();
		}
	}
	public static void validateASession(HttpServletRequest request) {
		// 로긴상태인지 확인
		if (CommonUtil.getAEnv(request.getSession()) == null) {
			throw new SessionException();
		}
	}

	/** 프로토콜을 검증한다. */
	public static void validateProtocol(HttpServletRequest request) {
		// boolean ssl = BaseEnv.get(request.getServletContext()).isSSL();
		// String protocol = request.getProtocol().toLowerCase();
		//
		// if((ssl && !protocol.startsWith("https"))
		// || (!ssl && protocol.startsWith("https"))) {
		// throw new SessionException("프로토콜 보안 위배입니다.", null);
		// }
	}

	/** 관리자 보안검증 */
	public static void validateAdmin(HttpServletRequest request) {
		// SessionModel model = CommonUtil.getEnv(request.getSession());
		//
		// //로긴상태인지 확인
		// if(model == null || !"Y".equals(model.getAdminYn())) {
		// throw new SessionException("관리자 보안 위배 입니다.", null);
		// }
	}

	/** 문자열 데이트를 형식문자열로 반환 */
	public static String formatDate(String dateStr, int type) {
		String result = null;
		if (dateStr != null && !"".equals(dateStr)) {
			if (type == 4) {
				result = dateStr.substring(0, 2) + "시 "
						+ dateStr.substring(2, 4) + "분";
			} else if (type == 8) {
				result = dateStr.substring(0, 4) + "-"
						+ dateStr.substring(4, 6) + "-"
						+ dateStr.substring(6, 8);
			} else if (type == 12) {
				result = dateStr.substring(0, 4) + "-"
						+ dateStr.substring(4, 6) + "-"
						+ dateStr.substring(6, 8) + " "
						+ dateStr.substring(8, 10) + ":"
						+ dateStr.substring(10, 12);
			} else if (type == 14) {
				result = dateStr.substring(0, 4) + "-"
						+ dateStr.substring(4, 6) + "-"
						+ dateStr.substring(6, 8) + " "
						+ dateStr.substring(8, 10) + ":"
						+ dateStr.substring(10, 12) + ":"
						+ dateStr.substring(12, 14);
			}
		}

		return result;
	}
 

	/** 필수입력항목표시 마크 반환 */
	public static String getRequiredMark() {
		return "*";
	}

	/** 업무시간을 계산하여 반환 **/
	public static String getJobTime(String startDt, String endDt,
			String oldJobTime) {
		Date sDate = WisConvertUtil.get().toDate(startDt, "yyyyMMddHHmm");
		Date eDate = WisConvertUtil.get().toDate(endDt, "yyyyMMddHHmm");

		float difTime = eDate.getTime() - sDate.getTime();
		int difMinute = Math.round(difTime / (60 * 1000))
				+ getMinuteFromJobTime(oldJobTime);

		return getHourMinute(difMinute);
	}

	/** 업무시간을 분으로 계산하여 반환 **/
	public static int getMinuteFromJobTime(String jobTime) {
		if (jobTime != null) {
			String[] times = jobTime.split(":");
			return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
		}

		return 0;
	}

	/** 분을 입력받아 시:분 형식으로 반환 **/
	public static String getHourMinute(Integer min) {
		if (min <= 0)
			return "0:00";

		return min / 60 + ":" + (min % 60 < 10 ? "0" + min % 60 : min % 60);
	}

	/** null 일 경우 대체값 반환 */
	public static <D extends Object> D nvl(D value, D replacement) {
		return value == null ? replacement : value;
	}

	/** text/plain 문자열을 text/html로 변경 */
	public static String convertTextToHtml(String text) {
		if (text == null) {
			return "";
		} else {
			return text.replace("<", "&lt;").replace(">", "&gt;")
					.replace("\n", "<br>").replace("\r", "");
		}
	}

	public static String toHtmlValue(String value) {
		if (value != null) {
			return value.replace("&", "&#38;").replace("<", "&lt;")
					.replace(">", "&gt;").replace("\"", "&quot;")
					.replace("'", "&#39;").replace(",", "&#44;")
					.replace("/", "&#47;").replace("\n", "<br>")
					.replace("\r", "").replace("\t", "");
		} else {
			return null;
		}
	}

	public static String toString(Date date, String pattern) {
		String result = null;
//		try {
			if (date != null) {
				if (pattern == null)
					pattern = "yyyy-MM-dd";
				;
				SimpleDateFormat format = new SimpleDateFormat(pattern,
						new Locale("KOREA", "KOREA"));
				result = format.format(date);
			}
//		} catch (Exception e) {
//		}
		return result;
	}

	/**
	 * 년계산
	 * 
	 * @param date
	 * @param months
	 * @return
	 */
	public static Date addYear(Date date, int year) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, year);

		return cal.getTime();
	}
	
	/**
	 * 월계산
	 * 
	 * @param date
	 * @param months
	 * @return
	 */
	public static Date addMonth(Date date, int months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		
		return cal.getTime();
	}

	/**
	 * 일계산
	 * 
	 * @param date
	 * @param months
	 * @return
	 */
	public static Date addDay(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);

		return cal.getTime();
	}

	public static void printMap(Map aoMap) {
		CommonUtil.printMap("HashMap Print", aoMap);
	}

	public static void printMap(String asTitle, Map aoMap) {
		StringBuilder loSb = new StringBuilder();

		loSb.append("------------------------------------------------------------------");
		loSb.append("\n " + asTitle + " \n");
		loSb.append("------------------------------------------------------------------\n");

		Iterator loItor = aoMap.keySet().iterator();

		while (loItor.hasNext()) {
			String lsKey = loItor.next().toString();
			loSb.append(lsKey).append(" = ").append(aoMap.get(lsKey))
					.append("\n");
		}
		loSb.append("------------------------------------------------------------------");

//		 System.out.println("\n\n");
//		System.out.println(loSb.toString());
//		System.out.println("\n\n"); 
	}

	public static void printListMap(List<Map> aoList) {
		CommonUtil.printListMap("ListMap Print", aoList);
	}

	public static void printListMap(String asTitle, List<Map> aoList) {
		StringBuilder loSb = new StringBuilder();

		loSb.append("------------------------------------------------------------------");
		loSb.append("\n " + asTitle + " \n");
		loSb.append("------------------------------------------------------------------\n");

		for (int i = 0; i < aoList.size(); i++) {
			CommonUtil.printMap(i + "번째 Map", (Map) aoList.get(i));
		}

		loSb.append("------------------------------------------------------------------");

//		 System.out.println("\n\n");
//		System.out.println(loSb.toString());
//		System.out.println("\n\n"); 
	}

	public static void printJSONObject(JSONObject aoJson) {
		CommonUtil.printJSONObject("JSONObject Print", aoJson);
	}

	public static void printJSONObject(String asTitle, JSONObject aoJson) {
		StringBuilder loSb = new StringBuilder();

		loSb.append("------------------------------------------------------------------");
		loSb.append("\n " + asTitle + " \n");
		loSb.append("------------------------------------------------------------------\n");

		Iterator loItor = aoJson.keySet().iterator();

		while (loItor.hasNext()) {
			String lsKey = loItor.next().toString();
			loSb.append(lsKey).append(" = ").append(aoJson.get(lsKey))
					.append("\n");
		}
		loSb.append("------------------------------------------------------------------");

//		 System.out.println("\n\n");
//		System.out.println(loSb.toString());
//		System.out.println("\n\n"); 
	}

	public static void printRequest(HttpServletRequest aoJson) {
		CommonUtil.printRequest("JSONObject Print", aoJson);
	}

	public static void printRequest(String asTitle, HttpServletRequest request) {
		StringBuilder loSb = new StringBuilder();

		loSb.append("------------------------------------------------------------------");
		loSb.append("\n " + asTitle + " \n");
		loSb.append("------------------------------------------------------------------\n");

		Enumeration enuNames = request.getParameterNames();

		while (enuNames.hasMoreElements()) {
			String lsKey = enuNames.nextElement().toString();

			loSb.append(lsKey).append(" = ")
					.append((String) request.getParameter(lsKey)).append("\n");
		}

		loSb.append("------------------------------------------------------------------");

//		 System.out.println("\n\n");
//		System.out.println(loSb.toString());
//		System.out.println("\n\n"); 
	}

	public static void printJSONArray(JSONArray aorJson) {
		CommonUtil.printJSONArray("JSONArray Print", aorJson);
	}

	public static void printJSONArray(String asTitle, JSONArray aorJson) {
		StringBuilder loSb = new StringBuilder();

		loSb.append("------------------------------------------------------------------");
		loSb.append("\n " + asTitle + " \n");
		loSb.append("------------------------------------------------------------------\n");

		//System.out.println(loSb.toString());

		for (int i = 0; i < aorJson.size(); i++) {
			CommonUtil.printJSONObject(i + "번째 JSONObject",
					aorJson.getJSONObject(i));
		}

	}

	public static void setMapFromJsonString(HashMap aoHashMap, String asJson) {

		CommonUtil.setMapFromJsonObject(aoHashMap,
				JSONObject.fromObject(asJson));

	}

	public static void setMapFromJsonObject(Map aoMap, JSONObject aoJson) {

		Iterator loItor = aoJson.keySet().iterator();
		String lsKey, lsVal;

		while (loItor.hasNext()) {
			lsKey = loItor.next().toString();
			lsVal = (String) aoJson.getString(lsKey);

			aoMap.put(lsKey, lsVal);
		}
		
		aoMap.put("RTNCNT",Integer.parseInt("0"));

		loItor = null;
	}
	
/** seok add start **/
	
//	public static Map jsonToMap(JSONObject json) throws JSONException {
//		Map<String, Object> retMap = new HashMap<String, Object>();
//
//		if (json != null) {
//			retMap = toMap(json);
//		}
//		return retMap;
//	}
	
	public static List<Map> jsonStringToList(String jsonString) throws JSONException, UnsupportedEncodingException {
		JSONArray jsonArray;
		JSONObject jsonObject = null;
		List<Map> list = new ArrayList<Map>();
		
		if(jsonString != null){
			String strTemp = new String(jsonString).replaceAll("&quot;", "\"");
			
			jsonArray = JSONArray.fromObject(strTemp);
			for (int i = 0; i < jsonArray.size(); i++) {
				jsonObject = jsonArray.getJSONObject(i);
	            list.add((Map)toMap(jsonObject));
	        }
		}
		
		return list;
	}

	public static Map toMap(JSONObject object) throws JSONException {
		Map<String, Object> map = new HashMap<String, Object>();

		Iterator<String> keysItr = object.keys();
		while (keysItr.hasNext()) {
			String key = keysItr.next();
			Object value = object.get(key);

			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = toMap((JSONObject) value);
			}
			map.put(key, value);
		}
		return map;
	}

	public static List toList(JSONArray array) throws JSONException {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < array.size(); i++) {
			list.add(array.get(i));
		}
		return list;
	}
	
	/** seok add end **/
	
	
	// PATH_TRAVERSAL (외부의 입력에서 경로 조작에 사용될 수 있는 문자를 필터링)
	public static String getPathTraversal(String fileName) {
		
		if(fileName != null && !"".equals(fileName)) {
				   
		    fileName = fileName.replaceAll("/", "");
		    fileName = fileName.replaceAll("\\", "");
		    fileName = fileName.replaceAll(".", "");
		    fileName = fileName.replaceAll("&", "");
		   
		    return fileName;
		}
		else {
			
			return "";
			
		}
		
	}
	
	public static String getXSS(String variable) {
		
		if(variable != null) {
			
			variable = variable.replaceAll("<", "&lt;");
			variable = variable.replaceAll(">", "&gt;");
			
			return variable;
		}
		else {
			return "";
		}
		
	}
	
	
	public static final String DEFAULT_PERIOD = "201712"; // 최소 서비스 시작년월에서 1개월 전 초기 값 - 201701월 시작
	public static final String DEFAULT_PERIOD_YEAR = "2017"; // 최초 서비스 실행 년도 - 데이터 입력이 시작된 년도
	
	public static String getCurPeriod() {
		
		Date cDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM"); 
		String current = sdf.format(cDate).toString();
		
		return current;
	}
	
	
	
	/**
	 * 입력된 yyyyMM 데이터에서 현재 yyyyMM데이터 사이의 모든 yyyyMM형태의 년월데이터를 String 리스트로 출력
	 * 
	 * @param _before
	 * @return cYearMonth
	 */
	public static List<String> getPeriod(String _before) {
		
		Date cDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM"); 
		String current = sdf.format(cDate).toString();
		//System.out.println("current : " + current); 
		String before = _before;
		//System.out.println("before : " + before); 

		int strtYear = Integer.parseInt(before.substring(0,4));
		int strtMonth = Integer.parseInt(before.substring(4,6));

		int endYear = Integer.parseInt(current.substring(0,4));
		int endMonth = Integer.parseInt(current.substring(4,6));

		int month = (endYear - strtYear)* 12 + (endMonth - strtMonth);

		//System.out.println("[Month]current - before : " + month);
		
		int cYear = strtYear;
		int cMonth = strtMonth;
		
		List<String> cYearMonth = new ArrayList<String>();		
		
		for(int i = 0 ; i < (month-1) ; i++) {			
			cMonth++;			
			if(cMonth > 12) {
				cYear++;
				cMonth = 1;
			}
			cYearMonth.add(String.format("%d%02d", cYear, cMonth));	
		}				
		
		return cYearMonth;
	}
	
	public static List<String> getUnderPeriod(String _current) {
		
		String current = _current;				
		String before = digitPeriod(current, -12);

		int strtYear = Integer.parseInt(before.substring(0,4));
		int strtMonth = Integer.parseInt(before.substring(4,6));

		int endYear = Integer.parseInt(current.substring(0,4));
		int endMonth = Integer.parseInt(current.substring(4,6));

		int month = (endYear - strtYear)* 12 + (endMonth - strtMonth);

		//System.out.println("[Month]current - before : " + month);
		
		int cYear = strtYear;
		int cMonth = strtMonth;
		
		List<String> cYearMonth = new ArrayList<String>();		
		
		for(int i = 0 ; i < (month) ; i++) {	
			cMonth++;	
			if(cMonth > 12) {
				cYear++;
				cMonth = 1;
			}				
			cYearMonth.add(String.format("%d%02d", cYear, cMonth));	
		}				
		
		return cYearMonth;
	}
	
	public static List<String> getUpperPeriod(String _current) {
		
		String before = _current;				
		String current = digitPeriod(before, 12);

		int strtYear = Integer.parseInt(before.substring(0,4));
		int strtMonth = Integer.parseInt(before.substring(4,6));

		int endYear = Integer.parseInt(current.substring(0,4));
		int endMonth = Integer.parseInt(current.substring(4,6));

		int month = (endYear - strtYear)* 12 + (endMonth - strtMonth);

		//System.out.println("[Month]current - before : " + month);
		
		int cYear = strtYear;
		int cMonth = strtMonth;
		
		List<String> cYearMonth = new ArrayList<String>();		
		
		for(int i = 0 ; i < (month) ; i++) {			
			cYearMonth.add(String.format("%d%02d", cYear, cMonth));	
			cMonth++;			
			if(cMonth > 12) {
				cYear++;
				cMonth = 1;
			}
		}				
		
		return cYearMonth;
	}
	
	public static List<String> getDefaultPeriod(String _current) {
		
		String before = digitPeriod(_current, -12);				
		String current = digitPeriod(_current, 12);

		int strtYear = Integer.parseInt(before.substring(0,4));
		int strtMonth = Integer.parseInt(before.substring(4,6));

		int endYear = Integer.parseInt(current.substring(0,4));
		int endMonth = Integer.parseInt(current.substring(4,6));

		int month = (endYear - strtYear)* 12 + (endMonth - strtMonth);

		//System.out.println("[Month]current - before : " + month);
		
		int cYear = strtYear;
		int cMonth = strtMonth;
		
		List<String> cYearMonth = new ArrayList<String>();		
		
		for(int i = 0 ; i < (month) ; i++) {			
			cYearMonth.add(String.format("%d%02d", cYear, cMonth));	
			cMonth++;			
			if(cMonth > 12) {
				cYear++;
				cMonth = 1;
			}
		}				
		
		return cYearMonth;
	}
	
	/**
	 * 입력된 yyyymm 데이터에서 n만큼 더하거나 빼서 출력
	 * 
	 * @param _period
	 * @param value
	 * @return result
	 */
	public static String digitPeriod(String _period, int value) {		

		int strtYear = Integer.parseInt(_period.substring(0,4));
		int strtMonth = Integer.parseInt(_period.substring(4,6));
		
		strtMonth = strtMonth + value;
		
		while(strtMonth < 1 || strtMonth > 12) {			
			if(strtMonth > 12) {
				strtYear++;
				strtMonth = strtMonth -12;
			}
			else if(strtMonth < 1) {
				strtYear--;
				strtMonth = strtMonth + 12;
			}			
		}
		
		String result = String.format("%d%02d", strtYear, strtMonth);		
		return result;
	}
	
	
	/**
	 * 입력된 yyyy 데이터에서 현재 yyyy데이터 사이의 모든 yyyy형태의 년월데이터를 String 리스트로 출력
	 * 
	 * @param _before
	 * @return cYearMonth
	 */
	public static List<String> getPeriodYear() {
		
		Date cDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy"); 
		String current = sdf.format(cDate).toString();
		//System.out.println("current : " + current); 
		String before = DEFAULT_PERIOD_YEAR;
		//System.out.println("before : " + before); 

		int strtYear = Integer.parseInt(before);
		int endYear = Integer.parseInt(current);

		int year = (endYear - strtYear);

		//System.out.println("[Month]current - before : " + month);
		
		int cYear = strtYear;
		
		List<String> dYear = new ArrayList<String>();		
		dYear.add(String.format("%d", strtYear));	
		
		for(int i = 0 ; i < year ; i++) {		
			cYear++;
			dYear.add(String.format("%d", cYear));	
		}				
		
		return dYear;
	}
	
	public static List<String> getPeriodYear(String _before) {
		
		Date cDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy"); 
		String current = sdf.format(cDate).toString();
		//System.out.println("current : " + current); 
		String before = _before;
		//System.out.println("before : " + before); 

		int strtYear = Integer.parseInt(before);
		int endYear = Integer.parseInt(current);

		int year = (endYear - strtYear);

		//System.out.println("[Month]current - before : " + month);
		
		int cYear = strtYear;
		
		List<String> dYear = new ArrayList<String>();		
		dYear.add(String.format("%d", strtYear));	
		
		for(int i = 0 ; i < year ; i++) {		
			cYear++;
			dYear.add(String.format("%d", cYear));	
		}				
		
		return dYear;
	}
	
	/**
	 * 차상위자 평가가 진행되지 않은 모든 평가 기간을 받아 String List로 출력
	 * 
	 * @param evalData
	 * @return cYearMonth
	 */
	public static List<String> getPeriodFromTo(List<EvalVO> evalData) {
		
		List<String> cYearMonth = new ArrayList<String>();		
		
		for(int i = 0 ; i < evalData.size() ; i++) {
			cYearMonth.add(String.format("%s ~ %s", evalData.get(i).getPERIOD_FROM(), evalData.get(i).getPERIOD_TO()));	
		}				
		
		return cYearMonth;
	}
	

	
	/**
	 * 평가 결과 비율을 계산하여 비중 계산
	 * 
	 * @param _listEvalResult
	 * @param _listGradeItem
	 * @param flag
	 * @return resultData
	 */	
	public static ArrayList<String> calculateRate(List<EvalResultVO> _listEvalResult, List<GradeItemVO> _listGradeItem, int flag) {
		
		int gradesize = _listGradeItem.size();
		
		int[] stack = new int[gradesize];
		for(int i = 0 ; i < gradesize ; i++) {
			stack[i] = 0;
		}
		
		for(int i = 0 ; i < _listEvalResult.size() ; i++) {			
			if(Integer.parseInt(_listEvalResult.get(i).getEVAL_TYPE()) == flag) {				
				for(int j = 0 ; j < gradesize ; j++) {					
					if(Integer.parseInt(_listEvalResult.get(i).getGRADE_ITEM_NUM()) == Integer.parseInt(_listGradeItem.get(j).getGRADE_ITEM_NUM())) {						
						stack[gradesize-(j+1)] += Integer.parseInt(_listEvalResult.get(i).getEVAL_RATE());
					}			
				}
			}			
		}
		
		// temp..//
//		if(Integer.parseInt(_listEvalResult.get(i).getGRADE_ITEM_NUM()) == (j+1)) {						
//			stack[gradesize-(j+1)] += Integer.parseInt(_listEvalResult.get(i).getEVAL_RATE());
//		}
		
		ArrayList<String> resultData = new ArrayList<String>();
		for(int i = 0 ; i < gradesize ; i++) {
			resultData.add(Integer.toString(stack[i]));
		}
		
		return resultData;
	}
	
	/**
	 * webapp에 실제 사원이미지 파일이 존재하는지 체크
	 * 
	 * @param _userNum
	 * @param _request
	 * @return imgPath
	 */
	
	public static String checkUserImg(String _userNum, HttpServletRequest _request) {
		
		String imgPath = "/resources/img/user/pic" + _userNum + ".png";
		String noimgPath = "/resources/img/icon/ico_main_man.png";
		String realPath = _request.getSession().getServletContext().getRealPath(imgPath);
		
		File file = new File(realPath);
		
		if(file.exists()) {
			return imgPath;
		}
		else {
			return noimgPath;
		}
	}
	
	/**
	 * string 암호화 encrypt
	 * 
	 * @param text
	 * @return encryptText
	 *
	 */
	
	@SuppressWarnings("restriction")
	public static String encryptSEED128(String text) {
		
		String encryptText = "";		
		
		try {
			SeedCipher seed = new SeedCipher();
			encryptText = Base64.encode(seed.encrypt(text, BaseEnv.ekey.getBytes(), "UTF-8"));
		}
		catch(Exception e) {
			
		}		
		return encryptText;		
	}
	
	/**
	 * 평균 그래프의 데이터를 계산
	 * 
	 * @param everCount
	 * @param gradeArrayData
	 * @param rateArrayData
	 * @param evalArrayData
	 * @param upevalArrayData
	 * 
	 * @return mainObject
	 *
	 */
	public static JSONObject CulculateEverage(
			int everCount, // 실제 평가 월수
			ArrayList<HashMap<String, String>> gradeArrayData, 
			ArrayList<HashMap<String, String>> rateArrayData, 
			ArrayList<ArrayList<HashMap<String, String>>> evalArrayData, 
			ArrayList<ArrayList<HashMap<String, String>>> upevalArrayData)
	{		
		/*
		if(D) System.out.println("CulculateEverage start===================");
		if(D) System.out.println("everCount : " + everCount);				
		
		if(D) System.out.println("gradeArrayData.size() : " + gradeArrayData.size());
		if(D) System.out.println("gradeArrayData : " + gradeArrayData.toString());
				
		if(D) System.out.println("rateArrayData.size() : " + rateArrayData.size());
		if(D) System.out.println("rateArrayData : " + rateArrayData.toString());
		
		if(D) System.out.println("evalArrayData.size() : " + evalArrayData.size());
		if(D) System.out.println("evalArrayData : " + evalArrayData.toString());
		
		if(D) System.out.println("upevalArrayData.size() : " + upevalArrayData.size());
		if(D) System.out.println("upevalArrayData : " + upevalArrayData.toString());
		if(D) System.out.println("CulculateEverage end===================");
		*/		

		// 출력할 JSONObject 선언부
		JSONObject mainObject = new JSONObject();
		JSONArray colorArray = new JSONArray();
		JSONArray everageArray = new JSONArray();
		
		// Array에  Object 입력하기 위한 재사용 object
		JSONObject tempObject = new JSONObject();
		
		// 등급 최소, 최대값을 이용한 평균 기준 정의
		int gradeStart = Integer.parseInt(gradeArrayData.get(0).get("gradenum"));
		int gradeEnd = Integer.parseInt(gradeArrayData.get(gradeArrayData.size()-1).get("gradenum"));
				
		int gradeMax = gradeStart + gradeEnd; // 역순으로 기록된 등급값으로 인해 전환에 사용할 값. ex) Gold는 1인데 실제 그래프에 표시하기 위해서 5로 전환이 필요
		int gradeLength = gradeEnd - gradeStart;		
		float gradeGap = (float)((float)gradeLength / (float)gradeArrayData.size()); // 한 구간의 값의 크기			
		//if(D) System.out.println("gradeGap : " + Float.toString(gradeGap));		
		
		// 구간별 범위를 배열로 저장하기 위한 변수 설정	
		float gradeMatrix[][] = new float[gradeArrayData.size()][2];	
		
		float gradeTemp = gradeStart;			
		
		for(int i = 0 ; i <  gradeArrayData.size() ; i++) {			
			gradeMatrix[i][0] = gradeTemp;
			gradeTemp+= gradeGap;
			gradeMatrix[i][1] = gradeTemp;			
			
			//if(D) System.out.println("gradeMatrix : " + String.format("%.2f", gradeMatrix[i][0]) + ", " + String.format("%.2f", gradeMatrix[i][1]));	
			
			// 그래프의 ticks 값을 array에 입력
			tempObject = new JSONObject();
			tempObject.put("value", String.format("%.2f", gradeMatrix[i][0]));
			tempObject.put("name", gradeArrayData.get(gradeArrayData.size()-1-i).get("grade"));			
			colorArray.add(tempObject);
		}
		
		// 그래프의 ticks에 마지막으로 최대값(MAX)을 array에 입력
		tempObject = new JSONObject();
		tempObject.put("value", String.format("%.2f", gradeTemp));
		tempObject.put("name", "MAX");
		colorArray.add(tempObject);
		
		//if(D) System.out.println("colorArray : " + colorArray.toString());	
		
		int totalRate = 0; // 모든 평가 비율의 합을 가지는 변수
		int evalStruct[] = new int[rateArrayData.size()]; // 검색 기간에서 모든 평가등급을 항목별로 더하기 위해 항목수 만큼 배열을 만듦
		float evalEverStruct[] = new float[rateArrayData.size()]; // 검색 기간에서 모든 평가등급을 항목별로 더하기 위해 항목수 만큼 배열을 만듦
		
		// 배열 초기화 및 비율총합 계산
		for(int i = 0 ; i < rateArrayData.size() ; i++) {
			evalStruct[i] = 0;
			evalEverStruct[i] = (float)0;
			totalRate+= Integer.parseInt(rateArrayData.get(i).get("rate"));
		}
		
		// 본인평가의 모든 평가항목 합산 
		for(int i = 0 ; i < evalArrayData.size() ; i++) {			
			ArrayList<HashMap<String, String>> tempData = new ArrayList<HashMap<String, String>>();			
			tempData = evalArrayData.get(i);
			
			for(int j = 0 ; j < tempData.size() ; j++) {				
				int evalNum = Integer.parseInt(tempData.get(j).get("num"));				
				if(evalNum > 0) { // 평가가 이루어 지지 않은 달은 스킵
					evalStruct[evalNum-1] += Integer.parseInt(tempData.get(j).get("gradenum"));					
				}				
			}			
		}
		
		// 차상위평가의 모든 평가항목 합산 
		for(int i = 0 ; i < upevalArrayData.size() ; i++) {
			
			ArrayList<HashMap<String, String>> tempData = new ArrayList<HashMap<String, String>>();			
			tempData = upevalArrayData.get(i);
			
			for(int j = 0 ; j < tempData.size() ; j++) {				
				int evalNum = Integer.parseInt(tempData.get(j).get("num"));				
				if(evalNum > 0) { // 평가가 이루어 지지 않은 달은 스킵
					evalStruct[evalNum-1] += Integer.parseInt(tempData.get(j).get("gradenum"));					
				}				
			}			
		}
		
		
		for(int i = 0 ; i < rateArrayData.size() ; i++) {
			
			/* TODO 
				중요 포인트 - 합산된 항목별 등급 총합을 나누어 평균값을 구하는 과정 
				x2를 한 이유는 본인평가와 차상위평가를 전부 더하기 때문에 */
			evalEverStruct[i] = (float)evalStruct[i] / (float)(everCount*2);
			//if(D) System.out.println("evalStruct : " + String.format("%d", evalStruct[i]));		
			
			/* TODO 
				중요 포인트 - 실제 등급은 높은등급이 낮은 값을 가져 그래프에 표시하기 위해서는 값을 역순으로 전환해야됨
				이부분에서 전환 진행 */
			evalEverStruct[i] = (float)gradeMax - evalEverStruct[i]; 
			
			//if(D) System.out.println("evalEverStruct change : " + String.format("%.2f", evalEverStruct[i]));		
			//if(D) System.out.println("evalEverStruct : " + String.format("%.2f", evalEverStruct[i]));		
			
			// 등급명 저장할 변수 초기화.
			String sTemp = "None";
			
			// 등급명 체크 진행
			for(int j = 0 ; j < gradeArrayData.size() ; j++) {				
				if(gradeMatrix[j][0] <= evalEverStruct[i] && evalEverStruct[i] <= gradeMatrix[j][1]) {
					sTemp = gradeArrayData.get(gradeArrayData.size()-1-j).get("grade");
				}				
			}
			//if(D) System.out.println("Grade : " + sTemp);		
			
			// 그래프 데이터를 위한 array 입력 작업
			tempObject = new JSONObject();
			tempObject.put("name", rateArrayData.get(i).get("name"));
			tempObject.put("value", String.format("%.2f", evalEverStruct[i]));
			tempObject.put("grade", sTemp);
			tempObject.put("rate", rateArrayData.get(i).get("rate"));			
			everageArray.add(tempObject);
		}
		
		//if(D) System.out.println("everageArray : " + everageArray.toString());	
		//if(D) System.out.println("totalRate : " + totalRate);	
		
		// 모든 평가항목의 값을 더하여 전체 평균등급을 계산
		float totalValue = 0;
		
		for(int i = 0 ; i < everageArray.size() ; i++) {
			
			tempObject = new JSONObject();
			tempObject = everageArray.getJSONObject(i);
			
			float value = Float.parseFloat((String)tempObject.get("value"));
			int rate = Integer.parseInt((String)tempObject.get("rate"));

			//if(D) System.out.println("- value: " + value);	
			//if(D) System.out.println("- rate: " + rate);	
			
			// 등급별 평균값에 평가비중값을 곱하여 전체값에 더함
			totalValue+= value*(float)rate; 
		}
		
		// 더해진 전체값에서 평가비중의 총합으로 나눈 평균값 계산
		float everageValue = (totalValue / (float)totalRate);
		
		// 전체 평균등급을 저장하기 위한 변수 정의
		String everageGrade = "None";		
		//if(D) System.out.println("totalValue : " + String.format("%.2f", totalValue));	
		//if(D) System.out.println("everage value : " + String.format("%.2f", everageValue));	
		
		// 전체 평균등급 확인
		for(int j = 0 ; j < gradeArrayData.size() ; j++) {				
			if(gradeMatrix[j][0] <= everageValue && everageValue <= gradeMatrix[j][1]) {
				everageGrade = gradeArrayData.get(gradeArrayData.size()-1-j).get("grade");
			}				
		}
		//if(D) System.out.println("everage grade : " + everageGrade);	
		
		// 그래프 재일 상단에 전체 평균결과를 array에 입력
		tempObject = new JSONObject();
		tempObject.put("name", "종합평균");
		tempObject.put("value", String.format("%.2f", everageValue));
		tempObject.put("grade", everageGrade);
		tempObject.put("rate", "0");		
		everageArray.add(0, tempObject); // stack 재일 첫번째에 저장하기 위해 위치를 0으로 지정
		
		
		// 출력할 JSONObject에 결과 Array 입력
		mainObject.put("color", colorArray);
		mainObject.put("everdata", everageArray);
		
		return mainObject;
	}
	
	public static ArrayList<HashMap<String, String>> CulculateEverage2(
			int everCount, // 실제 평가 월수
			ArrayList<HashMap<String, String>> gradeArrayData, 
			ArrayList<HashMap<String, String>> rateArrayData, 
			ArrayList<ArrayList<HashMap<String, String>>> evalArrayData)
	{		
		boolean D = false;
		
		// 출력할 Arraylist 선언부
		ArrayList<HashMap<String, String>> everArrayData = new ArrayList<HashMap<String, String>>();
		
		// Array에  Hashmap 입력하기 위한 재사용 Hashmap
		HashMap<String, String> tempHashmap = new HashMap<String, String>();
		
		// 등급 최소, 최대값을 이용한 평균 기준 정의
		int gradeStart = Integer.parseInt(gradeArrayData.get(0).get("gradenum"));
		int gradeEnd = Integer.parseInt(gradeArrayData.get(gradeArrayData.size()-1).get("gradenum"));
				
		int gradeMax = gradeStart + gradeEnd; // 역순으로 기록된 등급값으로 인해 전환에 사용할 값. ex) Gold는 1인데 실제 그래프에 표시하기 위해서 5로 전환이 필요
		int gradeLength = gradeEnd - gradeStart;		
		float gradeGap = (float)((float)gradeLength / (float)gradeArrayData.size()); // 한 구간의 값의 크기			
		//if(D) System.out.println("gradeGap : " + Float.toString(gradeGap));		
		
		// 구간별 범위를 배열로 저장하기 위한 변수 설정	
		float gradeMatrix[][] = new float[gradeArrayData.size()][2];	
		
		float gradeTemp = gradeStart;			
		
		for(int i = 0 ; i <  gradeArrayData.size() ; i++) {			
			gradeMatrix[i][0] = gradeTemp;
			gradeTemp+= gradeGap;
			gradeMatrix[i][1] = gradeTemp;			
			
			//if(D) System.out.println("gradeMatrix : " + String.format("%.2f", gradeMatrix[i][0]) + ", " + String.format("%.2f", gradeMatrix[i][1]));
		}
		
		int evalStruct[] = new int[rateArrayData.size()]; // 검색 기간에서 모든 평가등급을 항목별로 더하기 위해 항목수 만큼 배열을 만듦
		float evalEverStruct[] = new float[rateArrayData.size()]; // 검색 기간에서 모든 평가등급을 항목별로 더하기 위해 항목수 만큼 배열을 만듦
		
		// 배열 초기화 및 비율총합 계산
		for(int i = 0 ; i < rateArrayData.size() ; i++) {
			evalStruct[i] = 0;
			evalEverStruct[i] = (float)0;
		}
		
		// 본인평가의 모든 평가항목 합산 
		for(int i = 0 ; i < evalArrayData.size() ; i++) {			
			ArrayList<HashMap<String, String>> tempData = new ArrayList<HashMap<String, String>>();			
			tempData = evalArrayData.get(i);
			
			for(int j = 0 ; j < tempData.size() ; j++) {				
				int evalNum = Integer.parseInt(tempData.get(j).get("num"));				
				if(evalNum > 0) { // 평가가 이루어 지지 않은 달은 스킵
					evalStruct[evalNum-1] += Integer.parseInt(tempData.get(j).get("gradenum"));					
				}				
			}			
		}		
		
		for(int i = 0 ; i < rateArrayData.size() ; i++) {
			
			/* TODO 
				중요 포인트 - 합산된 항목별 등급 총합을 나누어 평균값을 구하는 과정 */
			evalEverStruct[i] = (float)evalStruct[i] / (float)everCount;
			//if(D) System.out.println("evalStruct : " + String.format("%d", evalStruct[i]));		
			
			/* TODO 
				중요 포인트 - 실제 등급은 높은등급이 낮은 값을 가져 그래프에 표시하기 위해서는 값을 역순으로 전환해야됨
				이부분에서 전환 진행 */
			evalEverStruct[i] = (float)gradeMax - evalEverStruct[i]; 
			
			//if(D) System.out.println("evalEverStruct change : " + String.format("%.2f", evalEverStruct[i]));		
			//if(D) System.out.println("evalEverStruct : " + String.format("%.2f", evalEverStruct[i]));		
			
			// 등급명 저장할 변수 초기화.
			String sTemp = "None";
			String sTemp2 = "0";
			
			// 등급명 체크 진행
			for(int j = 0 ; j < gradeArrayData.size() ; j++) {				
				if(gradeMatrix[j][0] <= evalEverStruct[i] && evalEverStruct[i] <= gradeMatrix[j][1]) {
					sTemp = gradeArrayData.get(gradeArrayData.size()-1-j).get("grade");
					sTemp2 = gradeArrayData.get(gradeArrayData.size()-1-j).get("gradenum");
				}				
			}
			
			if(D) System.out.println("init No." + i);	
			if(D) System.out.println("num : " + rateArrayData.get(i).get("num"));		
			if(D) System.out.println("name : " + rateArrayData.get(i).get("name"));		
			if(D) System.out.println("rate : " + rateArrayData.get(i).get("rate"));		
			if(D) System.out.println("grade : " + sTemp);		
			if(D) System.out.println("gradenum : " + sTemp2);		
			
			tempHashmap = new HashMap<String, String>();
			tempHashmap.put("num", rateArrayData.get(i).get("num"));
			tempHashmap.put("name", rateArrayData.get(i).get("name"));
			tempHashmap.put("rate", rateArrayData.get(i).get("rate"));
			tempHashmap.put("grade", sTemp);
			tempHashmap.put("gradenum", sTemp2);
			
			everArrayData.add(0, tempHashmap); // 역순으로 입력
		}
		
		if(D) System.out.println("everArrayData : " + everArrayData.toString());	
		
		return everArrayData;
	}
	
	public static String getRandomString(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
}
