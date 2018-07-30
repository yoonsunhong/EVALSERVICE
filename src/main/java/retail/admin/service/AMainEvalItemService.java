package retail.admin.service;

import java.util.List;
import java.util.Map;

import retail.admin.service.AMainEvalItemVO;

public interface AMainEvalItemService {
	
	List<AMainEvalItemVO> getEvalItemLst(AMainEvalItemVO params) throws Exception;
	
	Integer insertEvalItem(AMainEvalItemVO params) throws Exception;
	Integer insertUserEvalItem(AMainEvalItemVO params) throws Exception;
	
	Integer deleteEvalItem(AMainEvalItemVO params) throws Exception;
	Integer deleteUserEvalItem(AMainEvalItemVO params) throws Exception;
	
	Integer updateEvalItem(AMainEvalItemVO params) throws Exception;
	Integer updateUserEvalItem(AMainEvalItemVO params) throws Exception;
	
//	List<AMainEvalItemVO> getCodeDetail(AMainEvalItemVO params) throws Exception;//	
//	Integer insertCodeDetail(AMainEvalItemVO params) throws Exception;
//	Integer updateCodeDetail(AMainEvalItemVO params) throws Exception;
//	List<AMainEvalItemVO> selectCountCode(AMainEvalItemVO params) throws Exception;
//	Integer deleteCodeDetail(AMainEvalItemVO params) throws Exception;

	
}