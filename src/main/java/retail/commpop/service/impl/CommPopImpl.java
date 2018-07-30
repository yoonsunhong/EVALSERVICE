package retail.commpop.service.impl;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import retail.commpop.service.CommPopService;
import retail.commpop.service.CommPopVO;
import retail.admin.service.AMainUserVO;
import retail.admin.service.AMainDeptVO;


/**
 * @Class Name 	: 	MgtServiceImpl.java
 * @Description : 	화면 기능 및 설명.
 * @Modification 	Information
 * @ 수정일			수정자			 수정내용
 * @ ---------   	---------   -------------------------------
 * @ 2015.02.09            문희훈    		최초생성
 * @author 	문희훈
 * @since 	2015. 02.09
 * @version 1.0
 * @see
 *
 *  Copyright (C) by Retailtech All right reserved.
 */

@Service("CommPopService")
public class CommPopImpl  implements CommPopService {

	@Autowired
	private CommPopDao commPopDao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommPopImpl.class);

 

	@Override
	@Transactional
	public List<CommPopVO> selectAreaCodeList(CommPopVO params) throws Exception {
		return commPopDao.selectAreaCodeList(params);
	}
	
	@Override
	@Transactional
	public List<AMainDeptVO> selectDeptCode(AMainDeptVO params) throws Exception {
		return commPopDao.selectDeptCode(params);
	}
	
	
	@Override
	@Transactional
	public List<AMainUserVO> selectUserCode(AMainUserVO params) throws Exception {
		return commPopDao.selectUserCode(params);
	}

	
	
}
