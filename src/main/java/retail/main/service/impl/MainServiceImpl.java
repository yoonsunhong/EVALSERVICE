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
package retail.main.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import retail.main.service.MainService;
import retail.main.service.MainVO;
import retail.main.service.UserVO;


/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("MainService")
public class MainServiceImpl  implements MainService {

	@Autowired
	private MainDao mainDao;
	 
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(MainServiceImpl.class);

 
	@Override
	@Transactional
	public List<MainVO> getBigMenu(MainVO params) throws Exception { 
		return mainDao.getBigMenu(params);
	}

	@Override
	@Transactional
	public List<MainVO> getMiddleMenu(MainVO params) throws Exception { 
		return mainDao.getMiddleMenu(params);
	}

	@Override
	@Transactional
	public List<UserVO> getUnderUser(UserVO params) throws Exception {
		return mainDao.getUnderUser(params);
	}

}
