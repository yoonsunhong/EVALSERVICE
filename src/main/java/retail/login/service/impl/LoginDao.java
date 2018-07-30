package retail.login.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

import org.springframework.stereotype.Repository;

import retail.login.service.LoginVO;

/**
 * @Class Name : LoginDao.java
 * @Description : 로그인
 * @Modification Information 
 * @author 문희훈
 * @since 2016. 10.31
 * @version 1.0
 * @see Copyright (C) by RETILTECH All right reserved.
 */

@SuppressWarnings("unchecked")
@Repository("LoginDao")
public class LoginDao extends EgovAbstractDAO {

	public List<LoginVO> login(LoginVO params) throws Exception{
		return (List<LoginVO>) list("login.login", params);
	}

	
	public List<LoginVO> getFAQList(LoginVO params) throws Exception{
		return (List<LoginVO>) list("login.faq", params);
	}


	public void insertLog(LoginVO params)  throws Exception{
		insert("login.insertLog", params);
	}
	
	// 2017.12.04 JHJ
	public List<LoginVO> checkuser(LoginVO params) throws Exception {		
		return (List<LoginVO>) list("login.checkuser", params);
	}
	
	public List<LoginVO> getAllUserName() throws Exception {
		return (List<LoginVO>) list("login.getAllUserName");
	}
	
	public List<LoginVO> getAllDepart() throws Exception {
		return (List<LoginVO>) list("login.getAllDepart");
	}
	
	public List<LoginVO> getDepartUser(LoginVO params) throws Exception {
		return (List<LoginVO>) list("login.getDepartUser", params);
	}
}
