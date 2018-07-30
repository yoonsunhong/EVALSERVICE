package retail.graph.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import retail.common.CommonUtil;
import retail.common.JqGraphResult;
import retail.eval.service.EvalResultVO;
import retail.eval.service.EvalService;
import retail.eval.service.EvalVO;
import retail.eval.service.GradeItemVO;
import retail.main.service.MainService;
import retail.main.service.UserVO;



@Controller
public class GraphController {	
	
	private static final boolean D = true;
	
	@Autowired
	private EvalService evalService;
	
	@Autowired
	private MainService mainService;
	
	
	@RequestMapping(value = "/goGraph.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView goGraph(HttpServletRequest request, HttpServletResponse response, ModelMap model)throws Exception 
	{		
		if(D) System.out.println("Start goGraph.do");
		
		ModelAndView mavGraph = new ModelAndView();
		
		UserVO paUserVo = new UserVO();
		
		paUserVo.setUSER_NUM(CommonUtil.getEnv(request.getSession()).getUser_num());
		paUserVo.setUSER_NAME(CommonUtil.getEnv(request.getSession()).getUser_name());
		paUserVo.setDEPART_NUM(CommonUtil.getEnv(request.getSession()).getDepart_num());
		paUserVo.setDEPART_NAME(CommonUtil.getEnv(request.getSession()).getDepart_name());
		paUserVo.setUPUSER_NUM(CommonUtil.getEnv(request.getSession()).getUpuser_num());
		paUserVo.setUPUSER_NAME(CommonUtil.getEnv(request.getSession()).getUpuser_name());		
		
		
		List<UserVO> listUser = mainService.getUnderUser(paUserVo);
		
		if(listUser.size() > 0) {
			listUser.add(0, paUserVo);			
		}
		else {
			listUser = new ArrayList<UserVO>();
			listUser.add(paUserVo);
		}
		
		List<String> listPeriodYear = CommonUtil.getPeriodYear();
		
//		try
//		{
//			
//		} 
//		catch (IOException e) {
//			if(D) System.err.println("goGraph.do IOException Occured1 : " + e.toString());
//		} 
//		catch (Exception e) {
//			if(D) System.err.println("goGraph.do Exception Occured1 : " + e.toString());
//		}		
		mavGraph.setViewName("/retail/graph/graph");		
		mavGraph.addObject("object", listUser);
		mavGraph.addObject("period", listPeriodYear);
		return mavGraph;
	}
	
	@RequestMapping(value = "/testGraph.do", method = RequestMethod.POST)
	public ModelAndView testGraph(HttpServletRequest request, HttpServletResponse response, ModelMap model)throws Exception 
	{	
		if(D) System.out.println("Start testGraph.do");		
		ModelAndView mavGraph = new ModelAndView();
		
		String user_num = request.getParameter("USER_NUM");
		String period_year = request.getParameter("PERIOD_YEAR");		
		String period_from = period_year + "01";
		String period_to = period_year + "12";
		
		if(D) System.out.println("user_num : " + user_num);
		if(D) System.out.println("period_year : " + period_year);
		
		JqGraphResult jqGraphResult = new JqGraphResult();
		ArrayList<ArrayList<String>> evalArrayData = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> upevalArrayData = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> ZeroData = new ArrayList<String>();
		
		try {			
			EvalVO paEvalVo = new EvalVO();		
			paEvalVo.setUSER_NUM(user_num);
			paEvalVo.setPERIOD_FROM(period_from);
			paEvalVo.setPERIOD_TO(period_to);
			paEvalVo.setUPEVAL_WITH("1"); 
			
			List<EvalVO> listEval = evalService.getAllUserEvalData(paEvalVo);
			
			if(listEval.size() > 0) {
				
				List<GradeItemVO> listGradeItem = evalService.getUserGradeItemData(paEvalVo);
				//evalService.getGradeItemData();
				if(D) System.out.println("listGradeItem.size() : " + listGradeItem.size());
				
				if(listGradeItem.size() > 0) {
					
					for(int i = listGradeItem.size() ; i > 0 ; i--) {
						jqGraphResult.addGrade(listGradeItem.get(i-1));
						ZeroData.add("0");
					}
					
					jqGraphResult.setResult(0);
					
					int strPeriod = Integer.parseInt(period_from)-1;
					int endPeriod = Integer.parseInt(period_to);
					
					for(int i = 0 ; i < listEval.size() ; i++) {
						
						int fromPeriod = Integer.parseInt(listEval.get(i).getPERIOD_FROM());
						int toPeriod = Integer.parseInt(listEval.get(i).getPERIOD_TO());
						
						if(fromPeriod - strPeriod > 0) {
							int gap1 = fromPeriod - strPeriod;							
							for(int j = 0 ; j < (gap1-1) ; j++) {
								evalArrayData.add(ZeroData);
								upevalArrayData.add(ZeroData);
							}							
							strPeriod = fromPeriod;
						}		
						else {
							strPeriod = Integer.parseInt(period_from);
						}
						
						ArrayList<String> evalData = new ArrayList<String>();
						ArrayList<String> upevalData = new ArrayList<String>();
						
						List<EvalResultVO> listEvalResult  = evalService.getAllEvalResultData(listEval.get(i));
						
						// 
						evalData = CommonUtil.calculateRate(listEvalResult, listGradeItem, 0);
						upevalData = CommonUtil.calculateRate(listEvalResult, listGradeItem, 1);
						
						evalArrayData.add(evalData);
						upevalArrayData.add(upevalData);
						
						if(toPeriod - strPeriod > 0) {							
							if(toPeriod > endPeriod) {
								toPeriod = endPeriod;
							}
							int gap2 = toPeriod - strPeriod;							
							for(int j = 0 ; j < gap2 ; j++) {
								evalArrayData.add(evalData);
								upevalArrayData.add(upevalData);
							}		
							strPeriod = toPeriod;
						}
					}
					
					if(endPeriod - strPeriod > 0) {
						int gap3 = endPeriod - strPeriod;							
						for(int j = 0 ; j < gap3 ; j++) {
							evalArrayData.add(ZeroData);
							upevalArrayData.add(ZeroData);
						}	
					}
				}
			}
			else {
				jqGraphResult.setResult(1);
			}
		} 
		catch (IOException e) {
			if(D) System.err.println("testGraph.do IOException Occured1 : " + e.toString());
			jqGraphResult.setResult(2);
		} 
		catch (Exception e) {
			if(D) System.err.println("testGraph.do Exception Occured1 : " + e.toString());
			jqGraphResult.setResult(2);
		}		
		
		mavGraph.addObject("eval", evalArrayData);
		mavGraph.addObject("upeval", upevalArrayData);
		mavGraph.addObject("object", jqGraphResult.getJsonObject());
		mavGraph.addObject("user_num", user_num);
		mavGraph.addObject("period_year", period_year);		
		mavGraph.setViewName("/retail/graph/graph_view");
		
		return mavGraph;
	}
	
	@RequestMapping(value = "/goTestGraph.do", method = RequestMethod.GET)
	public ModelAndView goTestGraph(HttpServletRequest request, HttpServletResponse response, ModelMap model)throws Exception 
	{		
		ModelAndView mavGraph = new ModelAndView();	
		mavGraph.setViewName("/retail/graph/graph_view_e");		
		return mavGraph;
	}
	
	@RequestMapping(value = "/viewEvalGraph.do", method = RequestMethod.POST)
	public ModelAndView viewEvalGraph(HttpServletRequest request, HttpServletResponse response, ModelMap model)throws Exception 
	{
		if(D) System.out.println("Start viewEvalGraph.do");		
		ModelAndView mavGraph = new ModelAndView();
		
		String user_num = request.getParameter("USER_NUM");
		String period_year = request.getParameter("PERIOD_YEAR");		
		String period_from = period_year + "01";
		String period_to = period_year + "12";
		
		if(D) System.out.println("user_num : " + user_num);
		if(D) System.out.println("period_year : " + period_year);
		
		JqGraphResult jqGraphResult = new JqGraphResult();
		JSONObject everageObject = new JSONObject();
		
		int everCount = 0;
		ArrayList<HashMap<String, String>> gradeArrayData = new ArrayList<HashMap<String, String>>();
		ArrayList<HashMap<String, String>> rateArrayData = new ArrayList<HashMap<String, String>>();
		
		ArrayList<ArrayList<HashMap<String, String>>> evalArrayData = new ArrayList<ArrayList<HashMap<String, String>>>();
		ArrayList<ArrayList<HashMap<String, String>>> upevalArrayData = new ArrayList<ArrayList<HashMap<String, String>>>();
		
		ArrayList<HashMap<String, String>>  ZeroData = new ArrayList<HashMap<String, String>> ();
		
		HashMap<String, String> zeroHashData = new HashMap<String, String>();		
		zeroHashData.put("num", "0");
		zeroHashData.put("name", "0");
		zeroHashData.put("rate", "0");
		zeroHashData.put("grade", "White");
		zeroHashData.put("gradenum", "0");
		
		try {			
			EvalVO paEvalVo = new EvalVO();		
			paEvalVo.setUSER_NUM(user_num);
			paEvalVo.setPERIOD_FROM(period_from);
			paEvalVo.setPERIOD_TO(period_to);
			paEvalVo.setUPEVAL_WITH("1"); 
			
			List<EvalVO> listEval = evalService.getAllUserEvalData(paEvalVo);
			
			if(listEval.size() > 0) {
				
				List<GradeItemVO> listGradeItem = evalService.getUserGradeItemData(paEvalVo);
				//evalService.getGradeItemData();
				if(D) System.out.println("listGradeItem.size() : " + listGradeItem.size());
				
				if(listGradeItem.size() > 0) {					
					for(int i = listGradeItem.size() ; i > 0 ; i--) {
						jqGraphResult.addGrade(listGradeItem.get(i-1));
						
						HashMap<String, String> tempHash = new HashMap<String, String>();
						tempHash.put("gradenum", listGradeItem.get(i-1).getGRADE_ITEM_NUM());
						tempHash.put("grade", listGradeItem.get(i-1).getGRADE_ITEM_NAME());		
						
						gradeArrayData.add(0, tempHash);
					}
				}

				List<EvalResultVO> listEvalRate  = evalService.getEvalRateData(paEvalVo);	
				//evalService.getGradeItemData();
				if(D) System.out.println("listEvalRate.size() : " + listEvalRate.size());
				
				
				
				if(listEvalRate.size() > 0) {
					
					for(int i = listEvalRate.size() ; i > 0 ; i--) {
						jqGraphResult.addEvalRate(listEvalRate.get(i-1));		
						
						HashMap<String, String> tempHash = new HashMap<String, String>();
						tempHash.put("num", listEvalRate.get(i-1).getEVAL_ITEM_NUM());
						tempHash.put("name", listEvalRate.get(i-1).getEVAL_ITEM_NAME());
						tempHash.put("rate", listEvalRate.get(i-1).getEVAL_RATE());
						
						rateArrayData.add(0, tempHash);
						
						ZeroData.add(zeroHashData);
					}
					
					jqGraphResult.setResult(0);
					
					int strPeriod = Integer.parseInt(period_from)-1;
					int endPeriod = Integer.parseInt(period_to);
					
					for(int i = 0 ; i < listEval.size() ; i++) {
						
						int fromPeriod = Integer.parseInt(listEval.get(i).getPERIOD_FROM());
						int toPeriod = Integer.parseInt(listEval.get(i).getPERIOD_TO());
						
						if(fromPeriod - strPeriod > 0) {
							int gap1 = fromPeriod - strPeriod;							
							for(int j = 0 ; j < (gap1-1) ; j++) {
								evalArrayData.add(ZeroData);
								upevalArrayData.add(ZeroData);
							}							
							strPeriod = fromPeriod;
						}		
						else {
							strPeriod = Integer.parseInt(period_from);
						}
						
						//ArrayList<String> evalData = new ArrayList<String>();
						//ArrayList<String> upevalData = new ArrayList<String>();						

						ArrayList<HashMap<String, String>> evalData = new ArrayList<HashMap<String, String>>();
						ArrayList<HashMap<String, String>> upevalData = new ArrayList<HashMap<String, String>>();
						
						List<EvalResultVO> listEvalResult  = evalService.getAllEvalResultData(listEval.get(i));
						
						for(int j = listEvalResult.size(); j > 0 ; j--) {							
							HashMap<String, String> tempData = new HashMap<String, String>();

							tempData.put("num", listEvalResult.get(j-1).getEVAL_ITEM_NUM());
							tempData.put("name", listEvalResult.get(j-1).getEVAL_ITEM_NAME());
							tempData.put("rate", listEvalResult.get(j-1).getEVAL_RATE());
							tempData.put("grade", listEvalResult.get(j-1).getGRADE_ITEM_NAME());
							tempData.put("gradenum", listEvalResult.get(j-1).getGRADE_ITEM_NUM());
							
							if(listEvalResult.get(j-1).getEVAL_TYPE().equals("0")) {								
								evalData.add(tempData);
							}
							else {								
								upevalData.add(tempData);
							}
						}
						
						// 
						//evalData = CommonUtil.calculateRate(listEvalResult, listGradeItem, 0);
						//upevalData = CommonUtil.calculateRate(listEvalResult, listGradeItem, 1);
						
						evalArrayData.add(evalData);
						upevalArrayData.add(upevalData);			
						everCount++;
						
						if(toPeriod - strPeriod > 0) {							
							if(toPeriod > endPeriod) {
								toPeriod = endPeriod;
							}
							int gap2 = toPeriod - strPeriod;							
							for(int j = 0 ; j < gap2 ; j++) {
								evalArrayData.add(evalData);
								upevalArrayData.add(upevalData);		
								everCount++;
							}		
							strPeriod = toPeriod;
						}
					}
					
					if(endPeriod - strPeriod > 0) {
						int gap3 = endPeriod - strPeriod;							
						for(int j = 0 ; j < gap3 ; j++) {
							evalArrayData.add(ZeroData);
							upevalArrayData.add(ZeroData);
						}	
					}
					
					/*
					 *  TODO 평균 그래프 데이터 계산
					 */
					everageObject = CommonUtil.CulculateEverage(everCount, gradeArrayData, rateArrayData, evalArrayData, upevalArrayData);
					
					/*
					 *  TODO 평가별 총합평균 추가
					 */
					ArrayList<HashMap<String, String>> evalEverData = new ArrayList<HashMap<String, String>>();
					ArrayList<HashMap<String, String>> upevalEverData = new ArrayList<HashMap<String, String>>();
					
					evalEverData = CommonUtil.CulculateEverage2(everCount, gradeArrayData, rateArrayData, evalArrayData);
					upevalEverData = CommonUtil.CulculateEverage2(everCount, gradeArrayData, rateArrayData, upevalArrayData);					

					evalArrayData.add(evalEverData);
					upevalArrayData.add(upevalEverData);
				}
			}
			else {
				jqGraphResult.setResult(1);
			}
		} 
		catch (IOException e) {
			if(D) System.err.println("testGraph.do IOException Occured1 : " + e.toString());
			jqGraphResult.setResult(2);
		} 
		catch (Exception e) {
			if(D) System.err.println("testGraph.do Exception Occured1 : " + e.toString());
			jqGraphResult.setResult(2);
		}		
		
		mavGraph.addObject("eval", evalArrayData);
		mavGraph.addObject("upeval", upevalArrayData);
		mavGraph.addObject("object", jqGraphResult.getJsonObject());
		mavGraph.addObject("ever", everageObject);
		mavGraph.addObject("user_num", user_num);
		mavGraph.addObject("period_year", period_year);		
		mavGraph.setViewName("/retail/graph/graph_view_e");
		
		return mavGraph;
	}
}
