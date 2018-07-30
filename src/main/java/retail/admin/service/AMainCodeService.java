package retail.admin.service;

import java.util.List;
import java.util.Map;

import retail.admin.service.AMainCodeVO;

public interface AMainCodeService {
	
	List<AMainCodeVO> getCodeCategory(AMainCodeVO params) throws Exception;
	List<AMainCodeVO> getCodeDetail(AMainCodeVO params) throws Exception;
	Integer insertCategory(AMainCodeVO params) throws Exception;
	Integer updateCategory(AMainCodeVO params) throws Exception;
	Integer insertCodeDetail(AMainCodeVO params) throws Exception;
	Integer updateCodeDetail(AMainCodeVO params) throws Exception;
	List<AMainCodeVO> selectCountCode(AMainCodeVO params) throws Exception;
	Integer deleteCodeDetail(AMainCodeVO params) throws Exception;
	Integer deleteCode(AMainCodeVO params) throws Exception;
	
}