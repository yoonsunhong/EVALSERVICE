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
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.winis.common.util.ExcelParser;
import net.winis.common.util.ExcelParser.ExcelParseModel;
import net.winis.common.util.FileUploader;
import net.winis.common.util.WisJsonUtil;
import net.winis.servlet.util.WisServletUtil;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import retail.admin.service.AMainUserService;
import retail.admin.service.AMainUserVO;
import retail.common.CommonUtil;
import retail.common.FileUtils;
import retail.common.JqGridResult;

/**
 * @Class Name 	: CopController.java
 * @Description : 사원정보관리
 * @Modification Information 
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2018.03.20
 * @version 1.0
 * @see Copyright (C) by MOPAS All right reserved.
 */

@Controller
public class AMainUserController {

	@Autowired
	private AMainUserService aMainUserService;

	/** log */
	private final Log log = LogFactory.getLog(this.getClass());

	
	
	/*********************************************************
	 ******************* user_manage  *******************
	 *********************************************************/
	
	/**
	 * 관리모드 사원관리 화면
	 * @param model
	 * @return "mav"
	 * @exception Exception
	 */
	@RequestMapping(value = "/aMainUserManage.do", method = RequestMethod.GET)
	public ModelAndView aMainUserManage(HttpServletRequest request, HttpServletResponse response )throws Exception { 
		
		ModelAndView mav = new  ModelAndView("retail/admin/menu/user_manage");
		return   mav; 
	}
	
	/**
	 * 관리모드 사원 리스트 목록을 조회한다. (pageing)
	 * @param AMainGradeVO
	 * @return "jsonStr"
	 * @exception Exception
	 */
	
	@RequestMapping(value = "/aMainUserManageList.do", method=RequestMethod.POST)
	@ResponseBody
	public void select_list_comAdmCopMgtView( @ModelAttribute("userVO") AMainUserVO params, HttpServletResponse response)throws Exception {
		try { 
			
			List<AMainUserVO> resultList = aMainUserService.aMainUserManageList(params);
			
			int TOTAL_CNT = 1 ;
			if(resultList.size() != 0){
				TOTAL_CNT  = Integer.parseInt(resultList.get(0).getTOTAL_CNT());
			}
			//페이지,화면의 로우수, 총 글의 갯수
			JqGridResult jqGridResult = new JqGridResult(Integer.parseInt(params.getPAGE()),Integer.parseInt(params.getROW_LIST()),TOTAL_CNT);
			
			for(AMainUserVO userVO : resultList) {
				jqGridResult.addData(
						userVO.getUSER_NUM() //Index Key
						  , userVO.getRN_NUM()
						  , userVO.getUSER_NUM()
						  , userVO.getUSER_NAME()
						  , userVO.getDEPART_NUM()
						  , userVO.getDEPART_NAME()
						  , userVO.getGRADE_NAME()
						  , userVO.getDUTY_NAME()
						  , userVO.getUPUSER_NAME()
						  , userVO.getUSE_YN()
						  , userVO.getUSER_DATE()
						);
			}
			String jsonStr = jqGridResult.getJsonString();
			response.setContentType("text/json; charset=utf-8");
			response.getWriter().print(jsonStr);
		} catch (IOException e) {
			System.err.println("IOException Occured");
//			e.printStackTrace();
//			log.error("comAdmCopMgtView error: "+e.getMessage());
		}
	}

	/**
	 * 관리모드 사원 리스트 총 개수를 조회한다. (pageing)
	 * @param AMainGradeVO
	 * @return "HashMap<String, Object> map"
	 * @exception Exception
	 */
	@RequestMapping(value = "/aMainUserManageTotal.do", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> aMainUserManageTotal( @ModelAttribute("userVO") AMainUserVO params, HttpServletResponse response)throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		/*리스트 총 개수*/
		AMainUserVO result = aMainUserService.aMainUserManageTotal(params);
		map.put("TOTAL_CNT", result.getTOTAL_CNT());

		return map;
	}
	
	/**
	 * 관리모드 사원 정보 입력
	 * @param  
	 * @return " "
	 * @exception Exception
	 */
	@RequestMapping(value="/insertAMainUser.do", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> insertAMainUser(AMainUserVO params, HttpServletRequest request, HttpServletResponse response)throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			params.setREG_IP(CommonUtil.getIpAddr()); 
	        
	        //MultipartHttpServletRequest 에서 업로드된 파일을 가져온다.
	        // 가져온 파일의 타입은 MultipartFile 이다.
	        //MultipartFile uploadFile = request.getFile("file");

	        
	        //	      UtilFile 객체 생성
	        FileUtils fileUtils = new FileUtils();
	        
	        //	      파일 업로드 결과값을 path로 받아온다(이미 fileUpload() 메소드에서 해당 경로에 업로드는 끝났음)
	        //String uploadPath = fileUtils.fileUpload(request, uploadFile, params);
	        //params.setIMG_NAME(uploadPath);
	        
	        //	      해당 경로만 받아 db에 저장
	        

			String NEW_USER_NUM = aMainUserService.selectUserNum(params);
			System.out.println("insertAMainUser - new USER_NUM : " + NEW_USER_NUM);
			
			params.setUSER_NUM(NEW_USER_NUM);	        
	        aMainUserService.insertAMainUser(params);
	        
	        aMainUserService.insertUserEvalItem(params);
	        
			
		} catch(IOException e) {
//			e.printStackTrace();
//			log.error("comAdmCopMgtPopUpSave error: "+e.getMessage());
			System.err.println("IOException Occured");
			map.put("99", "저장에 실패했습니다.");
		}
		return map;
	}
	
	/**
	 * 관리모드 사원 정보 입력
	 * @param  
	 * @return " "
	 * @exception Exception
	 */
	@RequestMapping(value="/updateAMainUser.do", method=RequestMethod.POST)
	@ResponseBody
	public Integer updateAMainUser(HttpServletRequest request, HttpServletResponse response)throws Exception {
		
		try {
			
			System.out.println(request.getParameter("USER_NUM"));
			System.out.println(request.getParameter("USER_NAME"));
			System.out.println(request.getParameter("DEPART_NUM"));
			System.out.println(request.getParameter("DEPART_NAME"));
			System.out.println(request.getParameter("GRADE_NAME"));
			System.out.println(request.getParameter("DUTY_NAME"));
			System.out.println(request.getParameter("UPUSER_NAME"));
			System.out.println(request.getParameter("USE_YN"));
			System.out.println(request.getParameter("USER_DATE"));
			
			AMainUserVO params = new AMainUserVO();
			params.setUSER_NUM(request.getParameter("USER_NUM"));
			params.setUSER_NAME(request.getParameter("USER_NAME"));
			params.setDEPART_NUM(request.getParameter("DEPART_NUM"));			
			params.setGRADE_NAME(request.getParameter("GRADE_NAME"));
			params.setDUTY_NAME(request.getParameter("DUTY_NAME"));
			params.setUPUSER_NAME(request.getParameter("UPUSER_NAME"));
			params.setUSE_YN(request.getParameter("USE_YN"));
			
			Integer a = aMainUserService.updateAMainUser(params);
			
			return a;
		} catch(IOException e) {
			System.err.println("IOException Occured");

			return 0;
		}

	}
	
	
	/**
	 * 관리모드 사원 상세 팝업 조회 한다. (pageing)
	 * @param AdmCopVO
	 * @return "HashMap<String, Object> map"
	 * @exception Exception
	 */
	@RequestMapping(value = "/aMainUserManageDetail.do", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> aMainUserManageDetail( @ModelAttribute("userVO") AMainUserVO params, HttpServletResponse response)throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		AMainUserVO result = aMainUserService.aMainUserManageDetail(params);
		
		map.put("USER_NUM", result.getUSER_NUM());
		map.put("USER_NAME", result.getUSER_NAME());
		map.put("DEPART_NUM", result.getDEPART_NUM());
		map.put("GRADE_NAME", result.getGRADE_NAME());
		map.put("DUTY_NAME", result.getDUTY_NAME());
		map.put("UPUSER_NUM", result.getUPUSER_NUM());
		map.put("USE_YN", result.getUSE_YN());
		map.put("USER_DATE", result.getUSER_DATE());

		
		return map;
	}
	
	
	/**
	 * 관리모드 사원 삭제
	 * @param  
	 * @return " "
	 * @exception Exception
	 */
	@RequestMapping(value="/deleteAMainUser.do", method=RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Object> deleteAMainUser(@ModelAttribute("userVO") AMainUserVO params, HttpServletRequest request, HttpServletResponse response)throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			aMainUserService.deleteAMainUser(params);
	        aMainUserService.deleteUserEvalItem(params);
	        
		} catch(IOException e) {
//			e.printStackTrace();
//			log.error("comAdmCopMgtListDelete error: "+e.getMessage());
			map.put("99", "저장에 실패했습니다.");
		}
		return map;
	}
}
