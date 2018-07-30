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

import retail.admin.service.AMainCodeVO;


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
@Repository("AMainCodeDao")
public class AMainCodeDao extends EgovAbstractDAO {

	
 
	// 공통코드 분류 리스트
	public List<AMainCodeVO> getCodeCategory(AMainCodeVO params) throws Exception{
		return (List<AMainCodeVO>) list("aMainCode.getCodeCategory", params);
	}
	
	// 공통코드 상세 리스트
	public List<AMainCodeVO> getCodeDetail(AMainCodeVO params) throws Exception{
		return (List<AMainCodeVO>) list("aMainCode.getCodeDetail", params);
	}
	
	
	
	// 공통분류 입력
	public Integer insertCategory(AMainCodeVO params) throws Exception {
		return (Integer) this.update("aMainCode.insertCategory", params);
	}
	
	// 공통분류 수정
	public Integer updateCategory(AMainCodeVO params) throws Exception {
		return (Integer) this.update("aMainCode.updateCategory", params);
	}
	
	// 공통코드 입력
	public Integer insertCodeDetail(AMainCodeVO params) throws Exception {
		return (Integer) this.update("aMainCode.insertCodeDetail", params);
	}
	
	// 공통코드 수정
	public Integer updateCodeDetail(AMainCodeVO params) throws Exception {
		return (Integer) this.update("aMainCode.updateCodeDetail", params);
	}
	
	// 공통코드 중복 검사
	public  List<AMainCodeVO>  selectCountCode(AMainCodeVO params) throws Exception {
		return (List<AMainCodeVO>) list("aMainCode.selectCountCode", params);
		 
	}
	 
	// 공통코드 상세 삭제
	public Integer deleteCodeDetail(AMainCodeVO params) throws Exception {
		return (Integer) this.delete("aMainCode.deleteCodeDetail", params);
	}
	//  코드 상세 삭제
	public Integer deleteCode(AMainCodeVO params) throws Exception {
		return (Integer) this.delete("aMainCode.deleteCode", params);
	}
	
	
	 
	
}
