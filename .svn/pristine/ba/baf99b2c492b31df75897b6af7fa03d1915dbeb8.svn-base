/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package retail.admin.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import retail.admin.service.AMainDeptService;
import retail.admin.service.AMainDeptVO;
import retail.admin.service.AMainUserVO;
import retail.common.CommonUtil;
import retail.common.JqGridResult;
import retail.common.SessionModel;
/*import net.sf.json.JSONArray;
import net.sf.json.JSONObject;*/



/**
 * @Class Name 	: AMainDeptController.java
 * @Description : 부서관리
 * @Modification Information 
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2018.03.21
 * @version 1.0
 * @see Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class AMainDeptController {

	@Autowired
	private AMainDeptService aMainDeptService;

	/** log **/
	private final Log log = LogFactory.getLog(this.getClass());

	
	
	/*********************************************************
	 ******************* depart_manage  *******************
	 *********************************************************/
	
	/**
	 * 관리모드 부서관리 화면
	 * @param model
	 * @return "mav"
	 * @exception Exception
	 */
	@RequestMapping(value = "/aMainDepartManage.do", method = RequestMethod.GET)
	public ModelAndView aMainDepartManage(HttpServletRequest request, HttpServletResponse response )throws Exception { 
		
		ModelAndView mav = new  ModelAndView("retail/admin/menu/dept_manage");
		return   mav; 
	}
	
	/**
	 * 부서목록을 조회한다.
	 * 
	 * @param searchVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/aMainDeptList.do", method=RequestMethod.POST)
	@ResponseBody
	public void aMainDeptList( HttpServletRequest request,HttpServletResponse response)throws Exception {
		
		try 
		{
			AMainDeptVO params = new AMainDeptVO();

			params.setUSE_YN(request.getParameter("USE_YN"));

			List<AMainDeptVO> resultList = aMainDeptService.aMainDeptList(params);
			
			JqGridResult jqGridResult = new JqGridResult(resultList.size());
			
			for(AMainDeptVO aMainDeptVO : resultList) 
			{
				jqGridResult.addData (
					  //key  
					  aMainDeptVO.getDEPART_NUM()
					  
					, aMainDeptVO.getDEPART_NUM()
					, aMainDeptVO.getDEPART_NAME()
               		, aMainDeptVO.getUSE_YN()
               		, aMainDeptVO.getUSE_COUNT()
				);
			}
			
			String jsonStr = jqGridResult.getJsonString();
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().print(jsonStr);
		} 
		catch (IOException e) 
		{
			System.err.println("IOException Occured");
//			e.printStackTrace();
//			log.error("getPptcoReportDetail error: "+e.getMessage());
		}
	}
	
	/**
	 * 부서의 등록된 사원 목록 조회
	 * 
	 * @param searchVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/aMainDeptInUserListList.do", method=RequestMethod.POST)
	@ResponseBody
	public void aMainDeptInUserListList( HttpServletRequest request,HttpServletResponse response)throws Exception {
		
		try 
		{
			AMainDeptVO params = new AMainDeptVO();

			params.setDEPART_NUM(request.getParameter("DEPART_NUM"));

			List<AMainDeptVO> resultList = aMainDeptService.aMainDeptInUserListList(params);
			
			JqGridResult jqGridResult = new JqGridResult(resultList.size());
			
			for(AMainDeptVO aMainDeptVO : resultList) 
			{
				jqGridResult.addData (
					  //key  
					  aMainDeptVO.getUSER_NUM()
					  
					, aMainDeptVO.getUSER_NUM()
					, aMainDeptVO.getUSER_NAME()
               		, aMainDeptVO.getUPUSER_NAME()
				);
			}
			
			String jsonStr = jqGridResult.getJsonString();
			// System.out.println("JSON : " + jsonStr);
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().print(jsonStr);
		} 
		catch (IOException e) 
		{
			System.err.println("IOException Occured");
//			e.printStackTrace();
//			log.error("getPptcoReportDetail error: "+e.getMessage());
		}
	}
	
	/**
	 * 부서의 등록 안된 사원 목록 조회
	 * 
	 * @param searchVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/aMainDeptOutUserListList.do", method=RequestMethod.POST)
	@ResponseBody
	public void aMainDeptOutUserListList( HttpServletRequest request,HttpServletResponse response)throws Exception {
		
		try 
		{
			AMainDeptVO params = new AMainDeptVO();

			params.setDEPART_NUM(request.getParameter("DEPART_NUM"));

			List<AMainDeptVO> resultList = aMainDeptService.aMainDeptOutUserListList(params);
			
			JqGridResult jqGridResult = new JqGridResult(resultList.size());
			
			for(AMainDeptVO aMainDeptVO : resultList) 
			{
				jqGridResult.addData (
					  //key  
					  aMainDeptVO.getUSER_NUM()
					  
					, aMainDeptVO.getUSER_NUM()
					, aMainDeptVO.getUSER_NAME()
               		, aMainDeptVO.getUPUSER_NAME()
				);
			}
			
			String jsonStr = jqGridResult.getJsonString();
			// System.out.println("JSON : " + jsonStr);
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().print(jsonStr);
		} 
		catch (IOException e) 
		{
			System.err.println("IOException Occured");
//			e.printStackTrace();
//			log.error("getPptcoReportDetail error: "+e.getMessage());
		}
	}
	
	
	/**
	 * 신규 부서 등록
	 * 
	 * @param searchVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/addDept.do", method=RequestMethod.POST)
	@ResponseBody
	public void addAth(HttpServletRequest request,HttpServletResponse response)throws Exception {

//		String json = jsonStringParser(request, "menus");
//		
//		JSONParser jsonParser = new JSONParser();
//		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
//		
//		JSONArray arrMenus = (JSONArray) jsonObject.get("menus");
		
		// System.out.println("jsonObj : " + arrMenus);
		
		try {
			
//			SessionModel sessionModel = CommonUtil.getEnv(request.getSession());
//			AMainDeptVO params = new AMainDeptVO();
//			JSONObject athObj = (JSONObject) arrMenus.get(0);
//			
//			// 부서코드 없으면 신규
//			if(athObj.get("DEPART_NUM").equals("")) {
//				// System.out.println("권한 신규 항목");
				
			AMainDeptVO params = new AMainDeptVO();
			
			String NEW_DEPART_NUM = aMainDeptService.selectDeptNum(params);
			
			params.setDEPART_NUM(NEW_DEPART_NUM);
			params.setDEPART_NAME(request.getParameter("DEPART_NAME"));
			params.setUSE_YN(request.getParameter("USE_YN"));
				//params.setREG_IP(CommonUtil.getIpAddr());
				
			aMainDeptService.saveDept(params);
			
			params.setUPUSER_NUM("999"); // 평가기준정보를 가져오기 위해 임시로 UPUSER_NUM 필드에 집어넣음.
			aMainDeptService.insertDeptEvalItem(params);
//				
////				// 사원에게 부서 추가
////				for(int i=1; i<arrMenus.size(); i++) {
////					
////					params = new AMainDeptVO();
////					
////					athObj = (JSONObject) arrMenus.get(0);
////					params.setDEPART_NUM(NEW_DEPART_NUM);
////					
////					JSONObject tempObj = (JSONObject) arrMenus.get(i);
////					params.setUSER_NUM(tempObj.get("USER_NUM").toString());
////					params.setREG_IP(CommonUtil.getIpAddr());
////					
////					aMainDeptService.saveDeptUser(params);
////				}
//			}
				
//			// 부서코드 있으면 수정
//			else {
//				// System.out.println("권한 수정 항목");
//				// 현재 부서코드 속해있는 사원 삭제
//				params.setDEPART_NUM(athObj.get("DEPART_NUM").toString());
//				params.setDEPART_NAME(athObj.get("DEPART_NAME").toString());
//				params.setUSE_YN(athObj.get("USE_YN").toString());
//				params.setUPD_IP(CommonUtil.getIpAddr());
//
//				aMainDeptService.updateDept(params);
//				
//				aMainDeptService.deleteDeptUser(params);
//				
//				// 현재 부서코드 사원 목록 추가
//				for(int i=1; i<arrMenus.size(); i++) {
//					
//					params = new AMainDeptVO();
//					
//					athObj = (JSONObject) arrMenus.get(0);
//					params.setDEPART_NUM(athObj.get("DEPART_NUM").toString());
//					
//					JSONObject tempObj = (JSONObject) arrMenus.get(i);
//					params.setUSER_NUM(tempObj.get("USER_NUM").toString());
//					
//					
//					params.setREG_IP(CommonUtil.getIpAddr());
//					
//					aMainDeptService.saveDeptUser(params);
//				}
//			}
			
		} catch(IOException e) {
			System.err.println("IOException Occured");
//			log.error("comAdmCopMgtSaveExcelUpload error: " + e.getMessage());
		}
		
	}
	
	/**
	 * 부서정보 수정
	 * 
	 * @param searchVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/updateDept.do", method=RequestMethod.POST)
	@ResponseBody
	public Integer updateAth(HttpServletRequest request,HttpServletResponse response)throws Exception {
		
		try {
			AMainDeptVO params = new AMainDeptVO();		
			
			params.setDEPART_NUM(request.getParameter("DEPART_NUM"));
			params.setDEPART_NAME(request.getParameter("DEPART_NAME"));
			params.setUSE_YN(request.getParameter("USE_YN"));

			Integer a = aMainDeptService.updateDept(params);
			return a;
			
		} catch(IOException e) {
			System.err.println("IOException Occured");
//			log.error("comAdmCopMgtSaveExcelUpload error: " + e.getMessage());
			return 0;
		}
	}
	
	
	@RequestMapping(value = "/deleteDept.do", method=RequestMethod.POST)
	@ResponseBody
	public Integer deleteAthGroup(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
//		String json = jsonStringParser(request, "");
//		
//		JSONParser jsonParser = new JSONParser();
//		JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
//		
//		AMainDeptVO params = new AMainDeptVO();
//		params.setDEPART_NUM(jsonObject.get("DEPART_NUM").toString());
		
		
		try {
			AMainDeptVO params = new AMainDeptVO();
			params.setDEPART_NUM(request.getParameter("DEPART_NUM"));
			
			Integer a = aMainDeptService.deleteDept(params);
			aMainDeptService.deleteDeptUser(params);
			
			
			aMainDeptService.deleteDeptEvalItem(params);
			
			return a;
			
		} catch(IOException e) {
			System.err.println("IOException Occured");
//			log.error("comAdmCopMgtSaveExcelUpload error: " + e.getMessage());
			return 0;
		}
	}
	
	@RequestMapping(value = "/deleteDeptUser.do", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> deleteDeptUser(@ModelAttribute("userVO") AMainDeptVO params, HttpServletRequest request, HttpServletResponse response)throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			params.setDEPART_NUM(null);
			aMainDeptService.saveDeptUser(params);
		} catch(IOException e) {
			System.err.println("IOException Occured");
//			log.error("comAdmCopMgtSaveExcelUpload error: " + e.getMessage());
			map.put("99", "저장에 실패했습니다.");
		}
		return map;
	}
	
	@RequestMapping(value = "/deleteDeptOneUser.do", method=RequestMethod.POST)
	@ResponseBody
	public Integer deleteDeptOneUser(HttpServletRequest request, HttpServletResponse response)throws Exception {		
		try {
			AMainDeptVO params = new AMainDeptVO();
			params.setDEPART_NUM(null);
			params.setUSER_NUM(request.getParameter("USER_NUM"));
			
			Integer a = aMainDeptService.saveDeptUser(params);
			return a;
			
		} catch(IOException e) {
			System.err.println("IOException Occured");
//			log.error("comAdmCopMgtSaveExcelUpload error: " + e.getMessage());
			return 0;
		}
	}
	
	@RequestMapping(value = "/saveDeptUser.do", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> saveDeptUser(@ModelAttribute("userVO") AMainDeptVO params, HttpServletRequest request, HttpServletResponse response)throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		try {
			aMainDeptService.saveDeptUser(params);
		} catch(IOException e) {
			System.err.println("IOException Occured");
//			log.error("comAdmCopMgtSaveExcelUpload error: " + e.getMessage());
			map.put("99", "저장에 실패했습니다.");
		}
		return map;
	}
	
	@RequestMapping(value = "/saveDeptOneUser.do", method=RequestMethod.POST)
	@ResponseBody
	public Integer saveDeptOneUser(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		try {
			AMainDeptVO params = new AMainDeptVO();
			params.setDEPART_NUM(request.getParameter("DEPART_NUM"));
			params.setUSER_NUM(request.getParameter("USER_NUM"));
			
			Integer a = aMainDeptService.saveDeptUser(params);
			return a;
		} catch(IOException e) {
			System.err.println("IOException Occured");
//			log.error("comAdmCopMgtSaveExcelUpload error: " + e.getMessage());
			return 0;
		}
	}
	
	
	private String jsonStringParser(HttpServletRequest request, String key)
	{
		String rtnVal = null;
		
		try
		{
			
			StringBuffer json = new StringBuffer();
			String line = null;
			
			BufferedReader reader = request.getReader();
			
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
			
			if(key != null && !key.equals(""))
			{
				rtnVal = "{\"" + key + "\":" + json.toString() + "}";
			}
			else
			{
				rtnVal = json.toString();
			}
		}
		catch(IOException e)
		{
			System.err.println("IOException Occured");
		}
		
		return rtnVal;
	}
	
	
}
