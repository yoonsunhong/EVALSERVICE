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

import retail.admin.service.AMainEvalItemService;
import retail.admin.service.AMainEvalItemVO;
import retail.admin.service.impl.AMainEvalItemDao;


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

@Service("AMainEvalItemService")
public class AMainEvalItemServiceImpl  implements AMainEvalItemService {

	@Autowired
	private AMainEvalItemDao aMainEvalItemDao;
	 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AMainEvalItemServiceImpl.class);

	
	
	@Override
	@Transactional
	public List<AMainEvalItemVO> getEvalItemLst(AMainEvalItemVO params) throws Exception { 
		return aMainEvalItemDao.getEvalItemLst(params);
	}
	
	@Override
	@Transactional
	public Integer insertEvalItem(AMainEvalItemVO params) throws Exception { 
		return aMainEvalItemDao.insertEvalItem(params);
	}	
	
	@Override
	@Transactional
	public Integer insertUserEvalItem(AMainEvalItemVO params) throws Exception { 
		return aMainEvalItemDao.insertUserEvalItem(params);
	}	
	
	@Override
	@Transactional
	public Integer deleteEvalItem(AMainEvalItemVO params) throws Exception { 
		return aMainEvalItemDao.deleteEvalItem(params);
	}	
	
	@Override
	@Transactional
	public Integer deleteUserEvalItem(AMainEvalItemVO params) throws Exception { 
		return aMainEvalItemDao.deleteUserEvalItem(params);
	}	
	
	@Override
	@Transactional
	public Integer updateEvalItem(AMainEvalItemVO params) throws Exception { 
		return aMainEvalItemDao.updateEvalItem(params);
	}	
	
	@Override
	@Transactional
	public Integer updateUserEvalItem(AMainEvalItemVO params) throws Exception { 
		return aMainEvalItemDao.updateUserEvalItem(params);
	}	
	
//	@Override
//	@Transactional
//	public List<AMainEvalItemVO> getCodeDetail(AMainEvalItemVO params) throws Exception { 
//		return aMainEvalItemDao.getCodeDetail(params);
//	}
//	
//	

//	

//	
//	@Override
//	@Transactional
//	public Integer insertCodeDetail(AMainEvalItemVO params) throws Exception { 
//		return aMainEvalItemDao.insertCodeDetail(params);
//	}
//	
//	
//	
//	@Override
//	@Transactional
//	public Integer deleteCodeDetail(AMainEvalItemVO params) throws Exception { 
//		return aMainEvalItemDao.deleteCodeDetail(params);
//	}
//	

//	
//	@Override
//	@Transactional
//	public Integer updateCodeDetail(AMainEvalItemVO params) throws Exception { 
//		return aMainEvalItemDao.updateCodeDetail(params);
//	}
//	
//	@Override
//	@Transactional
//	public  List<AMainEvalItemVO> selectCountCode(AMainEvalItemVO params) throws Exception { 
//		return aMainEvalItemDao.selectCountCode(params);
//	}
	
	 
	
	
 
}
