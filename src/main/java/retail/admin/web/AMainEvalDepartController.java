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

 
import java.io.File;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
  
import egovframework.rte.fdl.property.EgovPropertyService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import retail.admin.service.AMainEvalDepartService;
import retail.admin.service.AMainEvalDepartVO;
import retail.common.CommonUtil;
import retail.common.JqResult;
import retail.common.JqGridResult;


import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;


/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller Class
 * @Modification Information @ @ 수정일 수정자 수정내용 @ --------- ---------
 *               ------------------------------- @ 2018.03.19 최초생성
 * 
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2018.03.19
 * @version 1.0
 * @see Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class AMainEvalDepartController {

	@Autowired
	private AMainEvalDepartService aMainEvalDepartService;

	/** EgovPropertyService */
/*	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;*/

	/** Validator */
/*	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;*/
	
	/** log */
	private final Log log = LogFactory.getLog(this.getClass());

	
	
	/**
	 * 화면뷰 만들기.  
	 * 
	 * @param  
	 *             
	 * @param model
	 * @return "mav"
	 * @exception Exception
	 */
	@RequestMapping(value = "/aMainEvalDepart.do", method = RequestMethod.GET)
	public ModelAndView admCodMgtLst(HttpServletRequest request, HttpServletResponse response )throws Exception { 
		ModelAndView mav = new  ModelAndView("retail/admin/menu/evalDepart_manage");
		return   mav; 
	}
	
	
	  
	
	
		/**
		 * 공통코드 분류 리스트 만들기.  
		 * 
		 * @param 공통코드 
		 * @param model
		 * @return "mav"
		 * @exception Exception
		 */
		@RequestMapping(value = "/getEvalDepart.do", method = RequestMethod.POST)
		@ResponseBody
		public void getEvalDepart(HttpServletRequest request, HttpServletResponse response )throws Exception { 
	
			AMainEvalDepartVO result = new AMainEvalDepartVO(); 
			AMainEvalDepartVO params = new AMainEvalDepartVO(); 
			params.setDEPART_NAME(request.getParameter("P_DEPART_NAME"));  
			//params.setUSE_YN(request.getParameter("P_USE_YN"));  
			params.setUSE_YN("Y");  
			List<AMainEvalDepartVO> getCodeCategory = aMainEvalDepartService.getEvalDepart(params);
			int TOTAL_CNT = 1 ;
			if(getCodeCategory.size() != 0){
				//TOTAL_CNT  = Integer.parseInt(getCodeCategory.get(0).getTOTAL_CNT());
			}
			
			//페이지,화면의 로우수, 총 글의 갯수
			JqGridResult jqGridResult = new JqGridResult(  0  );
			
			 int i = 0;
			for(AMainEvalDepartVO codeVO : getCodeCategory) {
				jqGridResult.addData(
						 
						i ,
						codeVO.getDEPART_NUM(),
						codeVO.getDEPART_NAME(),
						codeVO.getUSE_YN()	
						);
				i = i + 1;
			}
			
			String jsonStr = jqGridResult.getJsonString();
			// System.out.println(jsonStr);
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().print(jsonStr);
			  
		}
	
		
		/**
		 * 공통코드 상세  리스트 만들기.  
		 * 
		 * @param 공통코드 
		 * @param model
		 * @return "mav"
		 * @exception Exception
		 */
		@RequestMapping(value = "/getEvalItem.do", method = RequestMethod.POST)
		@ResponseBody
		public void getEvalItem(HttpServletRequest request, HttpServletResponse response )throws Exception { 
	
			AMainEvalDepartVO result = new AMainEvalDepartVO(); 
			AMainEvalDepartVO params = new AMainEvalDepartVO(); 
			params.setDEPART_NUM(request.getParameter("DEPART_NUM"));   
			List<AMainEvalDepartVO> getCodeCategory = aMainEvalDepartService.getEvalItem(params);
	 
			int TOTAL_CNT = 1 ;
			if(getCodeCategory.size() != 0){
				//TOTAL_CNT  = Integer.parseInt(getCodeCategory.get(0).getTOTAL_CNT());
			}
			
			//페이지,화면의 로우수, 총 글의 갯수
			JqGridResult jqGridResult = new JqGridResult(  0  );
			
			 int i = 0;
			for(AMainEvalDepartVO codeVO : getCodeCategory) {
				jqGridResult.addData(
						 
						i ,
						codeVO.getDEPART_NUM(),
						codeVO.getEVAL_ITEM_NUM(),
						codeVO.getEVAL_ITEM_NAME(),
						codeVO.getEVAL_RATE()
						
						);
				i = i + 1;
			}
			
			String jsonStr = jqGridResult.getJsonString();
			// System.out.println(jsonStr);
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().print(jsonStr);
			  
		}
		
		/**
		 * 평가항목비중 수정
		 * @param  
		 * @return " "
		 * @exception Exception
		 */
		@RequestMapping(value = "/updateCellEvalItem.do", method=RequestMethod.POST)
		@ResponseBody
		public Integer updateCellEvalItem( HttpServletRequest request, HttpServletResponse response  )throws Exception {
			AMainEvalDepartVO result = new AMainEvalDepartVO(); 
			AMainEvalDepartVO params = new AMainEvalDepartVO();  
			
			
			params.setDEPART_NUM(request.getParameter("DEPART_NUM")); 
			params.setEVAL_ITEM_NUM(request.getParameter("EVAL_ITEM_NUM")); 
			params.setEVAL_RATE(request.getParameter("EVAL_RATE")); 

			Integer a = aMainEvalDepartService.updateEvalRateDepart(params);
			return a;
		}		
		
		/**
		 * 평가항목비중 부서별 일괄 수정
		 * @param  
		 * @return " "
		 * @exception Exception
		 */
		@RequestMapping(value = "/updateEvalRateDepartUser.do", method=RequestMethod.POST)
		@ResponseBody
		public Integer updateEvalRateDepartUser( HttpServletRequest request, HttpServletResponse response  )throws Exception {
			AMainEvalDepartVO result = new AMainEvalDepartVO(); 
			AMainEvalDepartVO params = new AMainEvalDepartVO();  
			

			params.setDEPART_NUM(request.getParameter("DEPART_NUM")); 
			List<AMainEvalDepartVO> getCodeCategory = aMainEvalDepartService.getEvalItem(params);
			
			for(AMainEvalDepartVO codeVO : getCodeCategory) {
				AMainEvalDepartVO param = new AMainEvalDepartVO();
				
				param.setDEPART_NUM(request.getParameter("DEPART_NUM")); 
				param.setEVAL_ITEM_NUM(codeVO.getEVAL_ITEM_NUM()); 
				param.setEVAL_RATE(codeVO.getEVAL_RATE()); 
				
				aMainEvalDepartService.updateEvalRateDepartUser(param);
			}
			
			//return a;
			return 1;
		}		
		
		/**
		 * 코드 수정 
		 * @param  
		 * @return " "
		 * @exception Exception
		 */
		@RequestMapping(value = "/updateEvalRateDepart.do", method=RequestMethod.POST)
		@ResponseBody
		public Integer updateEvalRateDepart( HttpServletRequest request, HttpServletResponse response  )throws Exception {
			AMainEvalDepartVO result = new AMainEvalDepartVO(); 
			AMainEvalDepartVO params = new AMainEvalDepartVO();  
			
			params.setDEPART_NUM(request.getParameter("DEPART_NUM")); 
			params.setEVAL_ITEM_NUM(request.getParameter("EVAL_ITEM_NUM")); 
			params.setEVAL_ITEM_NAME(request.getParameter("EVAL_ITEM_NAME")); 
			params.setEVAL_RATE(request.getParameter("EVAL_RATE")); 

			Integer a = aMainEvalDepartService.updateEvalRateDepart(params);
			return a;
		}		
		
		/**
		 * 부서별 사원 평가항목 비중 조회
		 * 
		 * @param  
		 * @param model
		 * @return "mav"
		 * @exception Exception
		 */
		@RequestMapping(value = "/getEvalItemDepartUser.do", method = RequestMethod.POST)
		@ResponseBody
		public void getEvalItemDepartUser(HttpServletRequest request, HttpServletResponse response )throws Exception { 
	
			AMainEvalDepartVO result = new AMainEvalDepartVO(); 
			AMainEvalDepartVO params = new AMainEvalDepartVO(); 
			params.setDEPART_NUM(request.getParameter("DEPART_NUM")); 
			params.setEVAL_ITEM_NUM(request.getParameter("EVAL_ITEM_NUM")); 
			List<AMainEvalDepartVO> getCodeCategory = aMainEvalDepartService.getEvalItemDepartUser(params);
	 
			int TOTAL_CNT = 1 ;
			if(getCodeCategory.size() != 0){
				//TOTAL_CNT  = Integer.parseInt(getCodeCategory.get(0).getTOTAL_CNT());
			}
			
			//페이지,화면의 로우수, 총 글의 갯수
			JqGridResult jqGridResult = new JqGridResult(  0  );
			
			 int i = 0;
			for(AMainEvalDepartVO codeVO : getCodeCategory) {
				jqGridResult.addData(
						 
						i ,
						codeVO.getUSER_NUM(),
						codeVO.getUSER_NAME(),
						codeVO.getEVAL_ITEM_NAME(),
						codeVO.getEVAL_RATE()
						
						);
				i = i + 1;
			}
			
			String jsonStr = jqGridResult.getJsonString();
			// System.out.println(jsonStr);
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().print(jsonStr);
			  
		}		
		 
		
		
//		/**
//		 * 코드 생성 
//		 * @param  
//		 * @return " "
//		 * @exception Exception
//		 */
//		@RequestMapping(value = "/insertCodeDetail.do", method=RequestMethod.POST)
//		@ResponseBody
//		public Integer insertCodeDetail( HttpServletRequest request, HttpServletResponse response  )throws Exception {
//			AMainEvalDepartVO result = new AMainEvalDepartVO(); 
//			AMainEvalDepartVO params = new AMainEvalDepartVO();  
//			
//			params.setGRADE_ITEM_TYPE_CODE(request.getParameter("GRADE_ITEM_TYPE_CODE")); 
//			params.setGRADE_ITEM_NUM(request.getParameter("GRADE_ITEM_NUM")); 
//			params.setGRADE_ITEM_NAME(request.getParameter("GRADE_ITEM_NAME")); 
//			params.setREMARK(request.getParameter("REMARK")); 
//			params.setSORT(request.getParameter("SORT")); 
//			params.setUSE_YN(request.getParameter("USE_YN")); 
//			
//			
//		 
//			
//			Integer a = aMainEvalDepartService.insertCodeDetail(params);
////			Integer a = 0;
//			return a;
//		}
//		
//
//		
//		
//		
//		
//		
//		
//		/**
//		 *  코드 삭제  
//		 * @param  
//		 * @return " "
//		 * @exception Exception 
//		 */
//		@RequestMapping(value = "/deleteCode.do", method=RequestMethod.POST)
//		@ResponseBody
//		public Integer deleteCode( HttpServletRequest request, HttpServletResponse response  )throws Exception {
//			AMainEvalDepartVO result = new AMainEvalDepartVO(); 
//			AMainEvalDepartVO params = new AMainEvalDepartVO();
//		   
//			 
//			params.setGRADE_ITEM_NUM(request.getParameter("GRADE_ITEM_NUM"));
//			// System.out.println( request.getParameter("GRADE_ITEM_NUM") );
//			
//			
//			Integer a = aMainEvalDepartService.deleteCode(params);
//		  
//			return a;
//		}
//		
//		
//		/**
//		 * 상세코드 삭제  
//		 * @param  
//		 * @return " "
//		 * @exception Exception 
//		 */
//		@RequestMapping(value = "/deleteCodeDetail.do", method=RequestMethod.POST)
//		@ResponseBody
//		public Integer deleteCodeDetail( HttpServletRequest request, HttpServletResponse response  )throws Exception {
//			AMainEvalDepartVO result = new AMainEvalDepartVO(); 
//			AMainEvalDepartVO params = new AMainEvalDepartVO();
//		   
//			
//			params.setGRADE_ITEM_TYPE_CODE(request.getParameter("GRADE_ITEM_TYPE_CODE"));
//			params.setGRADE_ITEM_NUM(request.getParameter("GRADE_ITEM_NUM"));
//			
//			Integer a = aMainEvalDepartService.deleteCodeDetail(params);
//		  
//			return a;
//		}

//		
//		
//		/**
//		 * 코드 중복 검사  
//		 * @param  
//		 * @return " "
//		 * @exception Exception
//		 */
//		@RequestMapping(value = "/selectCountCode.do", method=RequestMethod.POST)
//		@ResponseBody
//		public AMainEvalDepartVO  selectCountCode( HttpServletRequest request, HttpServletResponse response  )throws Exception {
//			AMainEvalDepartVO result = new AMainEvalDepartVO(); 
//			AMainEvalDepartVO params = new AMainEvalDepartVO();  
//			  
//			params.setGRADE_ITEM_TYPE_CODE(request.getParameter("GRADE_ITEM_TYPE_CODE")); 
//			params.setGRADE_ITEM_NUM(request.getParameter("GRADE_ITEM_NUM"));  
//			  
//			List<AMainEvalDepartVO> selectCountCode = aMainEvalDepartService.selectCountCode(params);
// 
//			result.setResult(selectCountCode.get(0).getRet_cd());
//			result.setContent(selectCountCode);
//			  
//			return result;
//		}
//		
//		
//
//		/**
//		 * 뷴류 생성 
//		 * @param  
//		 * @return " "
//		 * @exception Exception
//		 */
//		@RequestMapping(value = "/insertCategory.do", method=RequestMethod.POST)
//		@ResponseBody
//		public Integer insertCategory( HttpServletRequest request, HttpServletResponse response  )throws Exception {
//			AMainEvalDepartVO result = new AMainEvalDepartVO(); 
//			AMainEvalDepartVO params = new AMainEvalDepartVO();  
//			params.setGRADE_ITEM_NAME(request.getParameter("GRADE_ITEM_NAME"));
//			params.setREMARK(request.getParameter("REMARK"));
//			params.setUSE_YN(request.getParameter("USE_YN"));
//			Integer a = aMainEvalDepartService.insertCategory(params);
//			 
//			return a;
//		}
//		
//		/**
//		 * 뷴류 수정 
//		 * @param  
//		 * @return " "
//		 * @exception Exception
//		 */
//		@RequestMapping(value = "/updateCategory.do", method=RequestMethod.POST)
//		@ResponseBody
//		public Integer updateCategory( HttpServletRequest request, HttpServletResponse response  )throws Exception {
//			AMainEvalDepartVO result = new AMainEvalDepartVO(); 
//			AMainEvalDepartVO params = new AMainEvalDepartVO();  
//			params.setGRADE_ITEM_NAME(request.getParameter("GRADE_ITEM_NAME"));
//			params.setREMARK(request.getParameter("REMARK"));
//			params.setUSE_YN(request.getParameter("USE_YN"));
//			params.setGRADE_ITEM_NUM(request.getParameter("GRADE_ITEM_NUM"));
//			
//			
//			Integer a = aMainEvalDepartService.updateCategory(params);
//			 
//			return a;
//		}

		
		
		
		
		 

}
