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

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import retail.admin.service.AMainEvalUserService;
import retail.admin.service.AMainEvalUserVO;
import retail.admin.service.impl.AMainEvalUserDao;


/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2018.03.19           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("AMainEvalUserService")
public class AMainEvalUserServiceImpl  implements AMainEvalUserService {

	@Autowired
	private AMainEvalUserDao aMainEvalUserDao;
	 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AMainEvalUserServiceImpl.class);

	
	
	@Override
	@Transactional
	public List<AMainEvalUserVO> getEvalUser(AMainEvalUserVO params) throws Exception { 
		return aMainEvalUserDao.getEvalUser(params);
	}
	
	@Override
	@Transactional
	public List<AMainEvalUserVO> getEvalItemUser(AMainEvalUserVO params) throws Exception { 
		return aMainEvalUserDao.getEvalItemUser(params);
	}
	
	@Override
	@Transactional
	public Integer updateEvalRateUser(AMainEvalUserVO params) throws Exception { 
		return aMainEvalUserDao.updateEvalRateUser(params);
	}	
	
	@Override
	@Transactional
	public Integer insertEvalUser(AMainEvalUserVO params) throws Exception { 
		return aMainEvalUserDao.insertEvalUser(params);
	}
	
	
	
	
	@Override
	@Transactional
	public Integer deleteEvalItemUser(AMainEvalUserVO params) throws Exception { 
		return aMainEvalUserDao.deleteEvalItemUser(params);
	}	
	
//	@Override
//	@Transactional
//	public Integer updateCategory(AMainEvalUserVO params) throws Exception { 
//		return aMainEvalUserDao.updateCategory(params);
//	}
//	
//	@Override
//	@Transactional
//	public Integer insertCodeDetail(AMainEvalUserVO params) throws Exception { 
//		return aMainEvalUserDao.insertCodeDetail(params);
//	}

//	
//	@Override
//	@Transactional
//	public Integer deleteCode(AMainEvalUserVO params) throws Exception { 
//		return aMainEvalUserDao.deleteCode(params);
//	}
//	

//	
//	@Override
//	@Transactional
//	public  List<AMainEvalUserVO> selectCountCode(AMainEvalUserVO params) throws Exception { 
//		return aMainEvalUserDao.selectCountCode(params);
//	}
	
	 
	
 
}
