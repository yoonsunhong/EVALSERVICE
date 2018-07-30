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

import retail.admin.service.AMainEvalItemVO;


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
@Repository("AMainEvalItemDao")
public class AMainEvalItemDao extends EgovAbstractDAO {

	
 
	// 평가항목 조회
	public List<AMainEvalItemVO> getEvalItemLst(AMainEvalItemVO params) throws Exception{
		return (List<AMainEvalItemVO>) list("aMainEvalItem.getEvalItemLst", params);
	}
	
	// 평가항목 저장
	public Integer insertEvalItem(AMainEvalItemVO params) throws Exception {
		return (Integer) this.update("aMainEvalItem.insertEvalItem", params);
	}	
	
	// 평가항목 저장 - 사용자 평가항목
	public Integer insertUserEvalItem(AMainEvalItemVO params) throws Exception {
		return (Integer) this.update("aMainEvalItem.insertUserEvalItem", params);
	}	
	
	//평가항목 삭제
	public Integer deleteEvalItem(AMainEvalItemVO params) throws Exception {
		return (Integer) this.delete("aMainEvalItem.deleteEvalItem", params);
	}	
	
	//평가항목 삭제 - 사용자 평가항목
	public Integer deleteUserEvalItem(AMainEvalItemVO params) throws Exception {
		return (Integer) this.delete("aMainEvalItem.deleteUserEvalItem", params);
	}	
	
	// 평가항목 수정
	public Integer updateEvalItem(AMainEvalItemVO params) throws Exception {
		return (Integer) this.update("aMainEvalItem.updateEvalItem", params);
	}	
	
	// 평가항목 수정 - 사용자 평가항목
	public Integer updateUserEvalItem(AMainEvalItemVO params) throws Exception {
		return (Integer) this.update("aMainEvalItem.updateUserEvalItem", params);
	}	
	
//	// 공통코드 상세 리스트
//	public List<AMainEvalItemVO> getCodeDetail(AMainEvalItemVO params) throws Exception{
//		return (List<AMainEvalItemVO>) list("aMainEvalItem.getCodeDetail", params);
//	}
//	
//	
//	

//	

//	
//	// 공통코드 입력
//	public Integer insertCodeDetail(AMainEvalItemVO params) throws Exception {
//		return (Integer) this.update("aMainEvalItem.insertCodeDetail", params);
//	}
//	
//	// 공통코드 수정
//	public Integer updateCodeDetail(AMainEvalItemVO params) throws Exception {
//		return (Integer) this.update("aMainEvalItem.updateCodeDetail", params);
//	}
//	
//	// 공통코드 중복 검사
//	public  List<AMainEvalItemVO>  selectCountCode(AMainEvalItemVO params) throws Exception {
//		return (List<AMainEvalItemVO>) list("aMainEvalItem.selectCountCode", params);
//		 
//	}
//	 
//	// 공통코드 상세 삭제
//	public Integer deleteCodeDetail(AMainEvalItemVO params) throws Exception {
//		return (Integer) this.delete("aMainEvalItem.deleteCodeDetail", params);
//	}

	
	
	 
	
}
