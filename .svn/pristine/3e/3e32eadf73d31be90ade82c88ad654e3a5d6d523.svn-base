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

import retail.admin.service.AMainCodeService;
import retail.admin.service.AMainCodeVO;
import retail.admin.service.impl.AMainCodeDao;


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

@Service("AMainCodeService")
public class AMainCodeServiceImpl  implements AMainCodeService {

	@Autowired
	private AMainCodeDao aMainCodeDao;
	 
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AMainCodeServiceImpl.class);

	
	
	@Override
	@Transactional
	public List<AMainCodeVO> getCodeCategory(AMainCodeVO params) throws Exception { 
		return aMainCodeDao.getCodeCategory(params);
	}
	
	@Override
	@Transactional
	public List<AMainCodeVO> getCodeDetail(AMainCodeVO params) throws Exception { 
		return aMainCodeDao.getCodeDetail(params);
	}
	
	
	@Override
	@Transactional
	public Integer insertCategory(AMainCodeVO params) throws Exception { 
		return aMainCodeDao.insertCategory(params);
	}
	
	@Override
	@Transactional
	public Integer updateCategory(AMainCodeVO params) throws Exception { 
		return aMainCodeDao.updateCategory(params);
	}
	
	@Override
	@Transactional
	public Integer insertCodeDetail(AMainCodeVO params) throws Exception { 
		return aMainCodeDao.insertCodeDetail(params);
	}
	
	
	
	@Override
	@Transactional
	public Integer deleteCodeDetail(AMainCodeVO params) throws Exception { 
		return aMainCodeDao.deleteCodeDetail(params);
	}
	
	@Override
	@Transactional
	public Integer deleteCode(AMainCodeVO params) throws Exception { 
		return aMainCodeDao.deleteCode(params);
	}
	
	@Override
	@Transactional
	public Integer updateCodeDetail(AMainCodeVO params) throws Exception { 
		return aMainCodeDao.updateCodeDetail(params);
	}
	
	@Override
	@Transactional
	public  List<AMainCodeVO> selectCountCode(AMainCodeVO params) throws Exception { 
		return aMainCodeDao.selectCountCode(params);
	}
	
	 
	
//	@Override
//	@Transactional
//	public List<MenuVO> getBigMenu() throws Exception { 
//		return mainDao.getBigMenu();
//	}
 
//	@Override
//	@Transactional
//	public List<UserVO> getUserList(UserVO params) throws Exception { 
//		return appMgtDao.getUserList(params);
//	}
//
//	@Override
//	@Transactional
//	public List<UserVO> getUserDetail(UserVO params) throws Exception { 
//		return appMgtDao.getUserDetail(params);
//	}

//	@Override
//	@Transactional
//	public List<UserVO> updateUser(UserVO params) throws Exception { 
//		return appMgtDao.updateUser(params);
//	}
	
	
	
//	/** 사용자 수정 Data 등록 */
//	@Override
//	@Transactional
//	public Integer updateUser(UserVO params) throws Exception {
//		UserVO uservo = new UserVO(); 
//		return appMgtDao.updateUser(params); 
// 	 
//	}
//	
//	/** 사용자 롤 Data 등록 */
//	@Override
//	@Transactional
//	public Integer insertUserRoleInfo(UserVO params) throws Exception {
//		UserVO uservo = new UserVO(); 
//		return appMgtDao.insertUserRoleInfo(params); 
// 	 
//	}
//	
	
	
//	/** 사용자 삭제 Data 등록 */
//	@Override
//	@Transactional
//	public Integer deleteUser(UserVO params) throws Exception {
//		UserVO uservo = new UserVO(); 
//		return appMgtDao.deleteUser(params); 
// 	 
//	}
//	
//	/** 사용자 삭제 취소 Data 등록 */
//	@Override
//	@Transactional
//	public Integer deleteCancelUser(UserVO params) throws Exception {
//		UserVO uservo = new UserVO(); 
//		return appMgtDao.deleteCancelUser(params); 
// 	 
//	}
//	
//	/** 승인시 파일 디비삭제  TblCommAttaFileInfo */
//	@Override
//	@Transactional
//	public Integer delTblCommAttaFileInfo(UserVO params) throws Exception {
//		UserVO uservo = new UserVO(); 
//		return appMgtDao.delTblCommAttaFileInfo(params); 
// 	 
//	}
//	
//	/** 승인시 파일 디비삭제  TblUserAttaFiler */
//	@Override
//	@Transactional
//	public Integer delTblUserAttaFiler(UserVO params) throws Exception {
//		UserVO uservo = new UserVO(); 
//		return appMgtDao.delTblUserAttaFiler(params); 
// 	 
//	}
//	
//	
//	@Override
//	@Transactional
//	public void deleteUserList(UserVO params) throws Exception {
//		
//		for(int i=0; i < params.getARRAY_DATA().size(); i++){
//			
//			params.setUSER_ID((String) params.getARRAY_DATA().get(i));
//			
//			System.out.println(params.getUSER_ID());
//
//			appMgtDao.deleteUserList(params);
//		}
//		
//		
//	}
	
 
}
