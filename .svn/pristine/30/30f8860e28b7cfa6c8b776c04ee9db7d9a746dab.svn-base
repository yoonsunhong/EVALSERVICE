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

import retail.admin.service.AMainCodeService;
import retail.admin.service.AMainCodeVO;
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
public class AMainCodeController {

	@Autowired
	private AMainCodeService aMainCodeService;

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
	@RequestMapping(value = "/aMainCodeManage.do", method = RequestMethod.GET)
	public ModelAndView admCodMgtLst(HttpServletRequest request, HttpServletResponse response )throws Exception { 
		ModelAndView mav = new  ModelAndView("retail/admin/menu/code_manage"); 
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
		@RequestMapping(value = "/getCodeCategory.do", method = RequestMethod.POST)
		@ResponseBody
		public void getCodeCategory(HttpServletRequest request, HttpServletResponse response )throws Exception { 
	
			AMainCodeVO result = new AMainCodeVO(); 
			AMainCodeVO params = new AMainCodeVO(); 
			params.setGRADE_ITEM_NAME(request.getParameter("P_GRADE_ITEM_NAME"));  
			params.setUSE_YN(request.getParameter("P_USE_YN"));  
			List<AMainCodeVO> getCodeCategory = aMainCodeService.getCodeCategory(params);
			int TOTAL_CNT = 1 ;
			if(getCodeCategory.size() != 0){
				//TOTAL_CNT  = Integer.parseInt(getCodeCategory.get(0).getTOTAL_CNT());
			}
			
			//페이지,화면의 로우수, 총 글의 갯수
			JqGridResult jqGridResult = new JqGridResult(  0  );
			
			 int i = 0;
			for(AMainCodeVO codeVO : getCodeCategory) {
				jqGridResult.addData(
						 
						i ,
						codeVO.getGRADE_ITEM_NUM(),
						codeVO.getGRADE_ITEM_NAME(),
						codeVO.getUSE_YN(),    
						codeVO.getREMARK()	
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
		@RequestMapping(value = "/getCodeDetail.do", method = RequestMethod.POST)
		@ResponseBody
		public void getCodeDetail(HttpServletRequest request, HttpServletResponse response )throws Exception { 
	
			AMainCodeVO result = new AMainCodeVO(); 
			AMainCodeVO params = new AMainCodeVO(); 
			params.setGRADE_ITEM_NUM(request.getParameter("GRADE_ITEM_NUM"));   
			List<AMainCodeVO> getCodeCategory = aMainCodeService.getCodeDetail(params);
	 
			int TOTAL_CNT = 1 ;
			if(getCodeCategory.size() != 0){
				//TOTAL_CNT  = Integer.parseInt(getCodeCategory.get(0).getTOTAL_CNT());
			}
			
			//페이지,화면의 로우수, 총 글의 갯수
			JqGridResult jqGridResult = new JqGridResult(  0  );
			
			 int i = 0;
			for(AMainCodeVO codeVO : getCodeCategory) {
				jqGridResult.addData(
						 
						i ,
						codeVO.getGRADE_ITEM_NUM(),
						codeVO.getGRADE_ITEM_NAME(),
						codeVO.getREMARK(),
						codeVO.getSORT(),
						codeVO.getUSE_YN() ,    
						codeVO.getGRADE_ITEM_TYPE_CODE(),
						codeVO.getGRADE_ITEM_NUM()
						
						);
				i = i + 1;
			}
			
			String jsonStr = jqGridResult.getJsonString();
			// System.out.println(jsonStr);
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().print(jsonStr);
			  
		}
		
		
		 
		
		
		/**
		 * 코드 생성 
		 * @param  
		 * @return " "
		 * @exception Exception
		 */
		@RequestMapping(value = "/insertCodeDetail.do", method=RequestMethod.POST)
		@ResponseBody
		public Integer insertCodeDetail( HttpServletRequest request, HttpServletResponse response  )throws Exception {
			AMainCodeVO result = new AMainCodeVO(); 
			AMainCodeVO params = new AMainCodeVO();  
			
			params.setGRADE_ITEM_TYPE_CODE(request.getParameter("GRADE_ITEM_TYPE_CODE")); 
			params.setGRADE_ITEM_NUM(request.getParameter("GRADE_ITEM_NUM")); 
			params.setGRADE_ITEM_NAME(request.getParameter("GRADE_ITEM_NAME")); 
			params.setREMARK(request.getParameter("REMARK")); 
			params.setSORT(request.getParameter("SORT")); 
			params.setUSE_YN(request.getParameter("USE_YN")); 
			
			
		 
			
			Integer a = aMainCodeService.insertCodeDetail(params);
//			Integer a = 0;
			return a;
		}
		

		
		
		
		
		
		
		/**
		 *  코드 삭제  
		 * @param  
		 * @return " "
		 * @exception Exception 
		 */
		@RequestMapping(value = "/deleteCode.do", method=RequestMethod.POST)
		@ResponseBody
		public Integer deleteCode( HttpServletRequest request, HttpServletResponse response  )throws Exception {
			AMainCodeVO result = new AMainCodeVO(); 
			AMainCodeVO params = new AMainCodeVO();
		   
			 
			params.setGRADE_ITEM_NUM(request.getParameter("GRADE_ITEM_NUM"));
			// System.out.println( request.getParameter("GRADE_ITEM_NUM") );
			
			
			Integer a = aMainCodeService.deleteCode(params);
		  
			return a;
		}
		
		
		/**
		 * 상세코드 삭제  
		 * @param  
		 * @return " "
		 * @exception Exception 
		 */
		@RequestMapping(value = "/deleteCodeDetail.do", method=RequestMethod.POST)
		@ResponseBody
		public Integer deleteCodeDetail( HttpServletRequest request, HttpServletResponse response  )throws Exception {
			AMainCodeVO result = new AMainCodeVO(); 
			AMainCodeVO params = new AMainCodeVO();
		   
			
			params.setGRADE_ITEM_TYPE_CODE(request.getParameter("GRADE_ITEM_TYPE_CODE"));
			params.setGRADE_ITEM_NUM(request.getParameter("GRADE_ITEM_NUM"));
			
			Integer a = aMainCodeService.deleteCodeDetail(params);
		  
			return a;
		}
		
		
		/**
		 * 코드 수정 
		 * @param  
		 * @return " "
		 * @exception Exception
		 */
		@RequestMapping(value = "/updateCodeDetail.do", method=RequestMethod.POST)
		@ResponseBody
		public Integer updateCodeDetail( HttpServletRequest request, HttpServletResponse response  )throws Exception {
			AMainCodeVO result = new AMainCodeVO(); 
			AMainCodeVO params = new AMainCodeVO();  
			
			
			
			params.setORIGIN_GRADE_ITEM_NUM(request.getParameter("D_ORIGIN_GRADE_ITEM_NUM")); 
			params.setGRADE_ITEM_TYPE_CODE(request.getParameter("GRADE_ITEM_TYPE_CODE")); 
			params.setGRADE_ITEM_NUM(request.getParameter("GRADE_ITEM_NUM")); 
			params.setGRADE_ITEM_NAME(request.getParameter("GRADE_ITEM_NAME")); 
			params.setREMARK(request.getParameter("REMARK")); 
			params.setSORT(request.getParameter("SORT")); 
			params.setUSE_YN(request.getParameter("USE_YN")); 

			
			 
			
			Integer a = aMainCodeService.updateCodeDetail(params);
			return a;
		}
		
		
		/**
		 * 코드 중복 검사  
		 * @param  
		 * @return " "
		 * @exception Exception
		 */
		@RequestMapping(value = "/selectCountCode.do", method=RequestMethod.POST)
		@ResponseBody
		public AMainCodeVO  selectCountCode( HttpServletRequest request, HttpServletResponse response  )throws Exception {
			AMainCodeVO result = new AMainCodeVO(); 
			AMainCodeVO params = new AMainCodeVO();  
			  
			params.setGRADE_ITEM_TYPE_CODE(request.getParameter("GRADE_ITEM_TYPE_CODE")); 
			params.setGRADE_ITEM_NUM(request.getParameter("GRADE_ITEM_NUM"));  
			  
			List<AMainCodeVO> selectCountCode = aMainCodeService.selectCountCode(params);
 
			result.setResult(selectCountCode.get(0).getRet_cd());
			result.setContent(selectCountCode);
			  
			return result;
		}
		
		

		/**
		 * 뷴류 생성 
		 * @param  
		 * @return " "
		 * @exception Exception
		 */
		@RequestMapping(value = "/insertCategory.do", method=RequestMethod.POST)
		@ResponseBody
		public Integer insertCategory( HttpServletRequest request, HttpServletResponse response  )throws Exception {
			AMainCodeVO result = new AMainCodeVO(); 
			AMainCodeVO params = new AMainCodeVO();  
			params.setGRADE_ITEM_NAME(request.getParameter("GRADE_ITEM_NAME"));
			params.setREMARK(request.getParameter("REMARK"));
			params.setUSE_YN(request.getParameter("USE_YN"));
			Integer a = aMainCodeService.insertCategory(params);
			 
			return a;
		}
		
		/**
		 * 뷴류 수정 
		 * @param  
		 * @return " "
		 * @exception Exception
		 */
		@RequestMapping(value = "/updateCategory.do", method=RequestMethod.POST)
		@ResponseBody
		public Integer updateCategory( HttpServletRequest request, HttpServletResponse response  )throws Exception {
			AMainCodeVO result = new AMainCodeVO(); 
			AMainCodeVO params = new AMainCodeVO();  
			params.setGRADE_ITEM_NAME(request.getParameter("GRADE_ITEM_NAME"));
			params.setREMARK(request.getParameter("REMARK"));
			params.setUSE_YN(request.getParameter("USE_YN"));
			params.setGRADE_ITEM_NUM(request.getParameter("GRADE_ITEM_NUM"));
			
			
			Integer a = aMainCodeService.updateCategory(params);
			 
			return a;
		}
		
		
		
		
		
		 

}
