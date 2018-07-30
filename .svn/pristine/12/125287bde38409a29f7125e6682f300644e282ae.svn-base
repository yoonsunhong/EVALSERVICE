package retail.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import retail.admin.service.AdminService;
import retail.admin.service.AdminVO;


@Service("AdminService")
public class AdminServiceImpl  implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	@Transactional
	public List<AdminVO> alogin(AdminVO params) throws Exception {
		return adminDao.alogin(params);
	}
	
}
