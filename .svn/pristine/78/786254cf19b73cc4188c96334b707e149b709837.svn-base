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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import retail.admin.service.AMainDeptService;
import retail.admin.service.AMainDeptVO;

/**
 * @Class Name : AMainDeptServiceImpl.java
 * @Description : 화면 기능 및 설명.
 * @Modification Information
 * @ 수정일				수정자			수정내용
 * @ ---------   		---------   -------------------------------
 * @ 2018.03.21       장재민    		최초생성
 * @author 강경신
 * @since 2018.03.21
 * @version 1.0
 * @see
 *  Copyright (C) by Retailtech All right reserved.
 */

@Service("AMainDeptService")
public class AMainDeptServiceImpl  implements AMainDeptService {

	@Autowired
	private AMainDeptDao aMainDeptDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(AMainDeptServiceImpl.class);

	
	/*********************************************************
	 ******************* COM_ADM_COP_MGT_Lst  *******************
	 *********************************************************/

	@Override
	@Transactional
	public String selectDeptNum(AMainDeptVO params) throws Exception {
		return aMainDeptDao.selectDeptNum(params);
	}
	
	
	@Override
	@Transactional
	public List<AMainDeptVO> aMainDeptList(AMainDeptVO params) throws Exception {
		return aMainDeptDao.aMainDeptList(params);
	}
	
	@Override
	@Transactional
	public List<AMainDeptVO> aMainDeptInUserListList(AMainDeptVO params) throws Exception {
		return aMainDeptDao.aMainDeptInUserListList(params);
	}
	
	@Override
	@Transactional
	public List<AMainDeptVO> aMainDeptOutUserListList(AMainDeptVO params) throws Exception {
		return aMainDeptDao.aMainDeptOutUserListList(params);
	}

	@Override
	@Transactional
	public void saveDept(AMainDeptVO params) throws Exception {
		aMainDeptDao.saveDept(params);
	}
	
	@Override
	@Transactional
	public Integer updateDept(AMainDeptVO params) throws Exception {
		return aMainDeptDao.updateDept(params);
	}
	
	
	@Override
	@Transactional
	public Integer deleteDept(AMainDeptVO params) throws Exception {
		return aMainDeptDao.deleteDept(params);
	}
	
	@Override
	@Transactional
	public Integer saveDeptUser(AMainDeptVO params) throws Exception {
		return aMainDeptDao.saveDeptUser(params);
	}
	
	
	@Override
	@Transactional
	public Integer deleteDeptUser(AMainDeptVO params) throws Exception {
		return aMainDeptDao.deleteDeptUser(params);
	}
	
	
	@Override
	@Transactional
	public Integer insertDeptEvalItem(AMainDeptVO params) throws Exception {
		return aMainDeptDao.insertDeptEvalItem(params);
	}
	
	@Override
	@Transactional
	public Integer deleteDeptEvalItem(AMainDeptVO params) throws Exception {
		return aMainDeptDao.deleteDeptEvalItem(params);
	}
	
	
}
