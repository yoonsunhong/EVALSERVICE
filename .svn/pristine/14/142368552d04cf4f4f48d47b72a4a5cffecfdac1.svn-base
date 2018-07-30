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
package retail.admin.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import retail.admin.service.AMainDeptVO;
import retail.admin.service.AMainUserService;
import retail.admin.service.AMainUserVO;

/**
 * @Class Name : AMainUserServiceImpl.java
 * @Description : 화면 기능 및 설명.
 * @Modification Information
 * @ 수정일				수정자			수정내용
 * @ ---------   		---------   -------------------------------
 * @ 2018.03.20          이  석    		최초생성
 * @author 이석
 * @since 2018.03.20
 * @version 1.0
 * @see
 *  Copyright (C) by Retailtech All right reserved.
 */

@Service("AMainUserService")
public class AMainUserServiceImpl  implements AMainUserService {

	@Autowired
	private AMainUserDao aMainUserDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(AMainUserServiceImpl.class);

	
	/*********************************************************
	 ******************* user_manage  *******************
	 *********************************************************/
	
	/** 사원정보관리 Grid 조회 */
	@Override
	@Transactional
	public List<AMainUserVO> aMainUserManageList(AMainUserVO params) throws Exception {
		return aMainUserDao.aMainUserManageList(params);
	}
	
	/** 사원정보관리 Grid Total Count 조회 */
	@Override
	@Transactional
	public AMainUserVO aMainUserManageTotal(AMainUserVO params) throws Exception {
		return aMainUserDao.aMainUserManageTotal(params);
	}
	
	/** 사원정보관리 Data 등록 */
	@Override
	@Transactional
	public void insertAMainUser(AMainUserVO params) throws Exception {

//		//UPDATE
//		if(null != params.getUSER_NUM() && !params.getUSER_NUM().equals("") ){
//			aMainUserDao.updateAMainUser(params);
//		}else{
//		//INSERT
			aMainUserDao.insertAMainUser(params);
//		}
		
	}
	

	/** 사원정보관리 Data 등록 */
	@Override
	@Transactional
	public Integer updateAMainUser(AMainUserVO params) throws Exception {
		return aMainUserDao.updateAMainUser(params);
	}
	
	/** 사원정보관리 Popup 상세 조회 */
	@Override
	@Transactional
	public AMainUserVO aMainUserManageDetail(AMainUserVO params) throws Exception {
		return aMainUserDao.aMainUserManageDetail(params);
	}
	
	
	/** 사원정보관리 Data 삭제 */
	@Override
	@Transactional
	public void deleteAMainUser(AMainUserVO params) throws Exception {
		AMainUserVO copvo = new AMainUserVO();
		for(int i=0; i < params.getARRAY_DATA().size(); i++){
			params.setUSER_NUM ((String) params.getARRAY_DATA().get(i));
			// System.out.println(params.getCUST_CD());
			aMainUserDao.deleteAMainUser(params);
		}
	}
	

	
	
	@Override
	@Transactional
	public Integer insertUserEvalItem(AMainUserVO params) throws Exception {
		return aMainUserDao.insertUserEvalItem(params);
	}
	
	@Override
	@Transactional
	public Integer deleteUserEvalItem(AMainUserVO params) throws Exception {
		return aMainUserDao.deleteUserEvalItem(params);
	}
	
	@Override
	@Transactional
	public String selectUserNum(AMainUserVO params) throws Exception {
		return aMainUserDao.selectUserNum(params);
	}

	
}
