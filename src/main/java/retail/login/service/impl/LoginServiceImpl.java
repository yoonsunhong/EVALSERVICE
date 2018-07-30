package retail.login.service.impl;

import java.util.List;

 







//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;






import retail.login.service.LoginService;
import retail.login.service.LoginVO;


/**
 * @Class Name : LoginServiceImpl.java
 * @Description : 로그인
 * @Modification Information 
 * @author 문희훈
 * @since 2016. 10.31
 * @version 1.0
 * @see Copyright (C) by RETILTECH All right reserved.
 */

@Service("LoginService")
public class LoginServiceImpl  implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	//private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);



	@Override
	@Transactional
	public List<LoginVO> login(LoginVO params) throws Exception {
		return loginDao.login(params);
	}

	
	@Override
	@Transactional
	public List<LoginVO> getFAQList(LoginVO params) throws Exception {
		return loginDao.getFAQList(params);
	}


	@Override
	public void insertLog(LoginVO params) throws Exception {
		loginDao.insertLog(params);
	}
	
	// 2017.12.04 JHJ	
	@Override
	@Transactional
	public List<LoginVO> checkuser(LoginVO params) throws Exception {		
		return loginDao.checkuser(params);
	}

	@Override
	@Transactional
	public List<LoginVO> getAllUserName() throws Exception {
		return loginDao.getAllUserName();
	}


	@Override
	@Transactional
	public List<LoginVO> getAllDepart() throws Exception {
		return loginDao.getAllDepart();
	}


	@Override
	@Transactional
	public List<LoginVO> getDepartUser(LoginVO params) throws Exception {
		return loginDao.getDepartUser(params);
	}
	
}
