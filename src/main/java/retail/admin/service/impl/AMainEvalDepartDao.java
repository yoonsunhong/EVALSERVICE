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

import retail.admin.service.AMainEvalDepartVO;


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
@Repository("AMainEvalDepartDao")
public class AMainEvalDepartDao extends EgovAbstractDAO {

	
 
	// 부서 목록 조회
	public List<AMainEvalDepartVO> getEvalDepart(AMainEvalDepartVO params) throws Exception{
		return (List<AMainEvalDepartVO>) list("aMainEvalDepart.getEvalDepart", params);
	}
	
	// 부서별 평가항목 비중 설정
	public List<AMainEvalDepartVO> getEvalItem(AMainEvalDepartVO params) throws Exception{
		return (List<AMainEvalDepartVO>) list("aMainEvalDepart.getEvalItem", params);
	}
	
	//  부서별 평가항목 비중 설정 수정
	public Integer updateEvalRateDepart(AMainEvalDepartVO params) throws Exception {
		return (Integer) this.update("aMainEvalDepart.updateEvalRateDepart", params);
	}	
	
	//  부서별 평가항목 비중 일괄 수정
	public Integer updateEvalRateDepartUser(AMainEvalDepartVO params) throws Exception {
		return (Integer) this.update("aMainEvalDepart.updateEvalRateDepartUser", params);
	}	
	
	// 부서별사원 평가항목 비중 조회
	public List<AMainEvalDepartVO> getEvalItemDepartUser(AMainEvalDepartVO params) throws Exception{
		return (List<AMainEvalDepartVO>) list("aMainEvalDepart.getEvalItemDepartUser", params);
	}	

//	// 공통분류 입력
//	public Integer insertCategory(AMainEvalDepartVO params) throws Exception {
//		return (Integer) this.update("aMainEvalDepart.insertCategory", params);
//	}
//	
//	// 공통분류 수정
//	public Integer updateCategory(AMainEvalDepartVO params) throws Exception {
//		return (Integer) this.update("aMainEvalDepart.updateCategory", params);
//	}
//	
//	// 공통코드 입력
//	public Integer insertCodeDetail(AMainEvalDepartVO params) throws Exception {
//		return (Integer) this.update("aMainEvalDepart.insertCodeDetail", params);
//	}
//	

//	
//	// 공통코드 중복 검사
//	public  List<AMainEvalDepartVO>  selectCountCode(AMainEvalDepartVO params) throws Exception {
//		return (List<AMainEvalDepartVO>) list("aMainEvalDepart.selectCountCode", params);
//		 
//	}
//	 
//	// 공통코드 상세 삭제
//	public Integer deleteCodeDetail(AMainEvalDepartVO params) throws Exception {
//		return (Integer) this.delete("aMainEvalDepart.deleteCodeDetail", params);
//	}
//	//  코드 상세 삭제
//	public Integer deleteCode(AMainEvalDepartVO params) throws Exception {
//		return (Integer) this.delete("aMainEvalDepart.deleteCode", params);
//	}
	
	
	 
	
}
