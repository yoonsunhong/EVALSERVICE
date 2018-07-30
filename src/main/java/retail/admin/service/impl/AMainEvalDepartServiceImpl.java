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

import retail.admin.service.AMainEvalDepartService;
import retail.admin.service.AMainEvalDepartVO;
import retail.admin.service.impl.AMainEvalDepartDao;


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

@Service("AMainEvalDepartService")
public class AMainEvalDepartServiceImpl  implements AMainEvalDepartService {

	@Autowired
	private AMainEvalDepartDao aMainEvalDepartDao;
	 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AMainEvalDepartServiceImpl.class);

	
	
	@Override
	@Transactional
	public List<AMainEvalDepartVO> getEvalDepart(AMainEvalDepartVO params) throws Exception { 
		return aMainEvalDepartDao.getEvalDepart(params);
	}
	
	@Override
	@Transactional
	public List<AMainEvalDepartVO> getEvalItem(AMainEvalDepartVO params) throws Exception { 
		return aMainEvalDepartDao.getEvalItem(params);
	}
	
	@Override
	@Transactional
	public Integer updateEvalRateDepart(AMainEvalDepartVO params) throws Exception { 
		return aMainEvalDepartDao.updateEvalRateDepart(params);
	}	
	
	@Override
	@Transactional
	public Integer updateEvalRateDepartUser(AMainEvalDepartVO params) throws Exception { 
		return aMainEvalDepartDao.updateEvalRateDepartUser(params);
	}	
	
	@Override
	@Transactional
	public List<AMainEvalDepartVO> getEvalItemDepartUser(AMainEvalDepartVO params) throws Exception { 
		return aMainEvalDepartDao.getEvalItemDepartUser(params);
	}	
	
//	@Override
//	@Transactional
//	public Integer insertCategory(AMainEvalDepartVO params) throws Exception { 
//		return aMainEvalDepartDao.insertCategory(params);
//	}
//	
//	@Override
//	@Transactional
//	public Integer updateCategory(AMainEvalDepartVO params) throws Exception { 
//		return aMainEvalDepartDao.updateCategory(params);
//	}
//	
//	@Override
//	@Transactional
//	public Integer insertCodeDetail(AMainEvalDepartVO params) throws Exception { 
//		return aMainEvalDepartDao.insertCodeDetail(params);
//	}
//	
//	
//	
//	@Override
//	@Transactional
//	public Integer deleteCodeDetail(AMainEvalDepartVO params) throws Exception { 
//		return aMainEvalDepartDao.deleteCodeDetail(params);
//	}
//	
//	@Override
//	@Transactional
//	public Integer deleteCode(AMainEvalDepartVO params) throws Exception { 
//		return aMainEvalDepartDao.deleteCode(params);
//	}
//	

//	
//	@Override
//	@Transactional
//	public  List<AMainEvalDepartVO> selectCountCode(AMainEvalDepartVO params) throws Exception { 
//		return aMainEvalDepartDao.selectCountCode(params);
//	}
	
	 
	
 
}
