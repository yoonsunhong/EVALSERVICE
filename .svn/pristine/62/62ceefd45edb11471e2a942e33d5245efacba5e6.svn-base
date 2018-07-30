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
package retail.regist.service.impl;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import retail.regist.service.RegistService;
import retail.regist.service.RegistVO;

@Service("RegistService")
public class RegistServiceImpl  implements RegistService {

	@Autowired
	private RegistDao registDao;

	//private static final Logger LOGGER = LoggerFactory.getLogger(RegistServiceImpl.class);	

	@Override
	@Transactional
	public List<RegistVO> checkUser(RegistVO params) throws Exception {
		return registDao.checkUser(params);
	}

	
	@Override
	@Transactional
	public void updatePass(RegistVO params) throws Exception {
		registDao.updatePass(params);
	}
}
