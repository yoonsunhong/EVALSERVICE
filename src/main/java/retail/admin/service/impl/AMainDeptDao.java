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

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

import org.springframework.stereotype.Repository;

import retail.admin.service.AMainDeptVO;

/**
 * @Class Name : CopDAO.java
 * @Description : Cop DAO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2018.03.21           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2018. 03.21
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@SuppressWarnings("unchecked")
@Repository("AdmAthDao")
public class AMainDeptDao extends EgovAbstractDAO {
	
	/*********************************************************
	 ******************* TSP_PNL_TYP_MGT_Lst  *******************
	 *********************************************************/
	
	public String selectDeptNum(AMainDeptVO params) throws Exception{
		return (String) selectByPk("aMainDept.selectDeptNum", params);
	}

	public List<AMainDeptVO> aMainDeptList(AMainDeptVO params) throws Exception {
		return (List<AMainDeptVO>) list("aMainDept.aMainDeptList", params);
	}
	
	public List<AMainDeptVO> aMainDeptInUserListList(AMainDeptVO params) throws Exception {
		return (List<AMainDeptVO>) list("aMainDept.aMainDeptInUserListList", params);
	}
	
	public List<AMainDeptVO> aMainDeptOutUserListList(AMainDeptVO params) throws Exception {
		return (List<AMainDeptVO>) list("aMainDept.aMainDeptOutUserListList", params);
	}
	
	public void saveDept(AMainDeptVO params) throws Exception {
		insert("aMainDept.saveDept", params);
	}
	
	public Integer updateDept(AMainDeptVO params) throws Exception {
		return (Integer) this.update("aMainDept.updateDept", params);
	}
	
	public Integer deleteDept(AMainDeptVO params) throws Exception {
		return (Integer) delete("aMainDept.deleteDept", params);
		//update("aMainDept.deleteDeptUser", params);
	}
	
	public Integer saveDeptUser(AMainDeptVO params) throws Exception {
		return (Integer) update("aMainDept.saveDeptUser", params);
	}
	
	public Integer deleteDeptUser(AMainDeptVO params) throws Exception {
		return (Integer) update("aMainDept.deleteDeptUser", params);
	}
	
	public Integer insertDeptEvalItem(AMainDeptVO params) throws Exception {
		return (Integer) update("aMainDept.insertDeptEvalItem", params);
	}
	
	public Integer deleteDeptEvalItem(AMainDeptVO params) throws Exception {
		return (Integer) delete("aMainDept.deleteDeptEvalItem", params);
	}
}
