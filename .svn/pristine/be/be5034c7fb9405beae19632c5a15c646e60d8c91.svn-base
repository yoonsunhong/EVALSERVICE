package retail.admin.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface AMainUserService {
	

	/*********************************************************
	 ******************* user_manage  *******************
	 *********************************************************/
	
	/** 사원관리 Grid 조회 */
	List<AMainUserVO> aMainUserManageList(AMainUserVO params) throws Exception;
	
	/** 사원관리 Grid Total Count 조회 */
	AMainUserVO aMainUserManageTotal(AMainUserVO params) throws Exception;

	/** 사원관리 Data 등록 */
	void insertAMainUser(AMainUserVO params) throws Exception;	

	/** 사원관리 Data 등록 */
	Integer updateAMainUser(AMainUserVO params) throws Exception;

	/** 사원관리 Popup 상세 조회 */
	AMainUserVO aMainUserManageDetail(AMainUserVO params) throws Exception;
	
	/** 사원관리 Data 삭제 */
	void deleteAMainUser(AMainUserVO params) throws Exception;
	
	

	public Integer insertUserEvalItem(AMainUserVO params) throws Exception;
	public Integer deleteUserEvalItem(AMainUserVO params) throws Exception;
	

	public String selectUserNum(AMainUserVO params) throws Exception;
	
}