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
package retail.commpop.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import retail.common.CommonUtil;
import retail.common.JqGridResult; 
import retail.commpop.service.CommPopService;
import retail.commpop.service.CommPopVO;
import retail.admin.service.AMainUserVO;
import retail.admin.service.AMainDeptVO;

/**
 * @Class Name 	: MgtController.java
 * @Description : 화면 기능 및 설명.
 * @Modification Information
 * @ 수정일			수정자			 수정내용
 * @ ---------   	---------   -------------------------------
 * @ 2015.02.09            문희훈    		최초생성
 * @author 문희훈
 * @since 2015.02.09
 * @version 1.0
 * @see
 *  Copyright (C) by Retailtech All right reserved.
 */

@Controller
public class CommPopController {

	@Autowired
	private CommPopService commPopService;
	
	/** log */
	private final Log log = LogFactory.getLog(this.getClass());

	
	/**
	 * 공통코드를 조회한다. 
	 * 
	 * @param searchVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/selectAreaCode.do", method=RequestMethod.POST)
	public void selectAreaCode( HttpServletRequest request,HttpServletResponse response)throws Exception {
		try {
			CommPopVO params = new CommPopVO();
			
			params.setGRADE_ITEM_TYPE_CODE(request.getParameter("GRADE_ITEM_TYPE_CODE"));
			
			List<CommPopVO> resultList = commPopService.selectAreaCodeList(params);
			JqGridResult jqGridResult = new JqGridResult(resultList.size());
			
			
			for(CommPopVO CommPopVO : resultList) {
				jqGridResult.addData(
						//key  
						CommPopVO.getGRADE_ITEM_NUM()
						, CommPopVO.getGRADE_ITEM_NAME()
	               		, CommPopVO.getGRADE_ITEM_NUM()
						);
			}
			String jsonStr = jqGridResult.getJsonString();
			// System.out.println(jsonStr);
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().print(jsonStr);
		} catch (IOException e) {
			System.err.println("IOException Occured");
//			e.printStackTrace();
//			log.error("getPptcoReportDetail error: "+e.getMessage());
		}
	}
	
	/**
	 * 부서코드를 조회한다. 
	 * 
	 * @param searchVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/selectDeptCode.do", method=RequestMethod.POST)
	public void selectDeptCode( HttpServletRequest request,HttpServletResponse response)throws Exception {
		try {
			AMainDeptVO params = new AMainDeptVO();

			List<AMainDeptVO> resultList = commPopService.selectDeptCode(params);
			JqGridResult jqGridResult = new JqGridResult(resultList.size());
			
			for(AMainDeptVO aMainDeptVO : resultList) {
				jqGridResult.addData(
						//key  
						aMainDeptVO.getDEPART_NUM()
						, aMainDeptVO.getDEPART_NAME()
	               		, aMainDeptVO.getDEPART_NUM()
						);
			}
			String jsonStr = jqGridResult.getJsonString();
			// System.out.println(jsonStr);
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().print(jsonStr);
		} catch (IOException e) {
			System.err.println("IOException Occured");
//			e.printStackTrace();
//			log.error("getPptcoReportDetail error: "+e.getMessage());
		}
	}
	
	/**
	 * 사원코드를 조회한다. 
	 * 
	 * @param searchVO
	 * @param model
	 * @return "egovSampleList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/selectUserCode.do", method=RequestMethod.POST)
	public void selectUserCode( HttpServletRequest request,HttpServletResponse response)throws Exception {
		try {
			AMainUserVO params = new AMainUserVO();
			
			List<AMainUserVO> resultList = commPopService.selectUserCode(params);
			JqGridResult jqGridResult = new JqGridResult(resultList.size());
			
			
			for(AMainUserVO aMainUserVO : resultList) {
				jqGridResult.addData(
						//key  
						aMainUserVO.getUSER_NUM()
						, aMainUserVO.getUSER_NAME()
	               		, aMainUserVO.getUSER_NUM()
						);
			}
			String jsonStr = jqGridResult.getJsonString();
			// System.out.println(jsonStr);
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().print(jsonStr);
		} catch (IOException e) {
			System.err.println("IOException Occured");
//			e.printStackTrace();
//			log.error("getPptcoReportDetail error: "+e.getMessage());
		}
	}
	

}
