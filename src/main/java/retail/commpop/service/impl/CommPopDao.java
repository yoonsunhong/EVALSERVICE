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
package retail.commpop.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

import org.springframework.stereotype.Repository;

import retail.commpop.service.CommPopVO;
import retail.admin.service.AMainUserVO;
import retail.admin.service.AMainDeptVO;

/**
 * @Class Name 	: MgtDao.java
 * @Description : 화면 기능 및 설명.
 * @Modification Information
 * @ 수정일			수정자			 수정내용
 * @ ---------   	---------   -------------------------------
 * @ 2015.02.09            문희훈    		최초생성
 * @author 문희훈
 * @since 2015.02.09
 * @version 1.0
 * @see
 *  Copyright (C) by Retailtech All right reserved.
 */

@SuppressWarnings("unchecked")
@Repository("CommPopDao")
public class CommPopDao extends EgovAbstractDAO {

 

	public List<CommPopVO> selectAreaCodeList(CommPopVO params) throws Exception{
		return (List<CommPopVO>) list("Commpop.selectCodeList", params);
	}
	
	public List<AMainDeptVO> selectDeptCode(AMainDeptVO params) throws Exception{
		return (List<AMainDeptVO>) list("Commpop.selectDeptList", params);
	}
	
	public List<AMainUserVO> selectUserCode(AMainUserVO params) throws Exception{
		return (List<AMainUserVO>) list("Commpop.selectUserList", params);
	}

	
}
