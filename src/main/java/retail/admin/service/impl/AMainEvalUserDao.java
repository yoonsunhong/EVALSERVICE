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

import retail.admin.service.AMainEvalUserVO;


/**
 * @Class Name : SampleDAO.java
 * @Description : Sample DAO Class
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

@SuppressWarnings("unchecked")
@Repository("AMainEvalUserDao")
public class AMainEvalUserDao extends EgovAbstractDAO {

	
 
	// 부서 목록 조회
	public List<AMainEvalUserVO> getEvalUser(AMainEvalUserVO params) throws Exception{
		return (List<AMainEvalUserVO>) list("aMainEvalUser.getEvalUser", params);
	}
	
	// 부서별 평가항목 비중 설정
	public List<AMainEvalUserVO> getEvalItemUser(AMainEvalUserVO params) throws Exception{
		return (List<AMainEvalUserVO>) list("aMainEvalUser.getEvalItemUser", params);
	}
	
	// 공통코드 수정
	public Integer updateEvalRateUser(AMainEvalUserVO params) throws Exception {
		return (Integer) this.update("aMainEvalUser.updateEvalRateUser", params);
	}	

	// 공통분류 입력
	public Integer insertEvalUser(AMainEvalUserVO params) throws Exception {
		return (Integer) this.update("aMainEvalUser.insertEvalUser", params);
	}
	
	// 공통코드 상세 삭제
	public Integer deleteEvalItemUser(AMainEvalUserVO params) throws Exception {
		return (Integer) this.delete("aMainEvalUser.deleteEvalItemUser", params);
	}	
	
//	// 공통분류 수정
//	public Integer updateCategory(AMainEvalUserVO params) throws Exception {
//		return (Integer) this.update("aMainEvalUser.updateCategory", params);
//	}
//	
//	// 공통코드 입력
//	public Integer insertCodeDetail(AMainEvalUserVO params) throws Exception {
//		return (Integer) this.update("aMainEvalUser.insertCodeDetail", params);
//	}
//	

//	
//	// 공통코드 중복 검사
//	public  List<AMainEvalUserVO>  selectCountCode(AMainEvalUserVO params) throws Exception {
//		return (List<AMainEvalUserVO>) list("aMainEvalUser.selectCountCode", params);
//		 
//	}
//	 

//	//  코드 상세 삭제
//	public Integer deleteCode(AMainEvalUserVO params) throws Exception {
//		return (Integer) this.delete("aMainEvalUser.deleteCode", params);
//	}
	
	
	 
	
}
