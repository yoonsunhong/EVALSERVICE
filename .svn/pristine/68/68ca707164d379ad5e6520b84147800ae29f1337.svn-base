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

import java.util.HashMap;
import java.util.List;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

import org.springframework.stereotype.Repository;

import retail.admin.service.AMainDeptVO;
import retail.admin.service.AMainUserVO;

/**
 * @Class Name : AMainUserDao.java
 * @Description : User DAO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2018.03.20           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2018. 03.20
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@SuppressWarnings("unchecked")
@Repository("AMainUserDao")
public class AMainUserDao extends EgovAbstractDAO {
	
	
	/*********************************************************
	 ******************* TSP_PNL_TYP_MGT_Lst  *******************
	 *********************************************************/
	
	/** 사원정보관리 Grid 조회 */
	public List<AMainUserVO> aMainUserManageList(AMainUserVO params) throws Exception{
		return (List<AMainUserVO>) list("aMainUser.aMainUserManageList", params);
	}
	
	/** 사원정보관리 Grid Total Count 조회 */
	public AMainUserVO aMainUserManageTotal(AMainUserVO params) throws Exception{
		return (AMainUserVO) selectByPk("aMainUser.aMainUserManageTotal", params);
	}
	
	/** 사원정보관리 Data Insert  */
	public void insertAMainUser(AMainUserVO params) throws Exception {
		this.insert("aMainUser.insertAMainUser", params);
	}

	/** 사원정보관리 Data update  */
	public Integer updateAMainUser(AMainUserVO params) throws Exception {
		return (Integer) update("aMainUser.updateAMainUser", params);
	}
	
	/** 사원정보관리 Popup 상세 조회 */
	public AMainUserVO aMainUserManageDetail(AMainUserVO params) throws Exception{
		return (AMainUserVO) selectByPk("aMainUser.aMainUserManageDetail", params);
	}
	
	/** 사원정보관리 Data delete  */
	public void deleteAMainUser(AMainUserVO params) {
		 this.update("aMainUser.deleteAMainUser", params);
	}

	
	public Integer insertUserEvalItem(AMainUserVO params) throws Exception {
		return (Integer) update("aMainUser.insertUserEvalItem", params);
	}
	
	public Integer deleteUserEvalItem(AMainUserVO params) throws Exception {
		return (Integer) delete("aMainUser.deleteUserEvalItem", params);
	}
	
	public String selectUserNum(AMainUserVO params) throws Exception{
		return (String) selectByPk("aMainUser.selectUserNum", params);
	}
}
