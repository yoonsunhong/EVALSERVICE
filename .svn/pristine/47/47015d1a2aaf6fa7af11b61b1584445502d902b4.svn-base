package retail.admin.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

import org.springframework.stereotype.Repository;

import retail.admin.service.AdminVO;


@SuppressWarnings("unchecked")
@Repository("AdminDao")
public class AdminDao extends EgovAbstractDAO {

	public List<AdminVO> alogin(AdminVO params) throws Exception{
		return (List<AdminVO>) list("admin.alogin", params);
	}
}
