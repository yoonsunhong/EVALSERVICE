package retail.eval.service;

import java.util.List;

public interface EvalService {
	
	EvalVO getLastEvalData(EvalVO params) throws Exception;	
	EvalVO getEvalData(EvalVO params) throws Exception;
	List<EvalVO> getAllEvalData(EvalVO params) throws Exception;	
	
	EvalVO getUserEvalData(EvalVO params) throws Exception;	
	List<EvalVO> getAllUserEvalData(EvalVO params) throws Exception;		
	
	List<EvalResultVO> getAllEvalResultData(EvalVO params) throws Exception;	
	List<EvalResultVO> getEvalResultData(EvalResultVO params) throws Exception;	
	List<EvalResultVO> getEvalRateData(EvalVO params) throws Exception;		
	
	List<GradeItemVO> getGradeItemData(GradeItemVO params) throws Exception;		
	List<GradeItemVO> getUserGradeItemData(EvalVO params) throws Exception;	
		
	public Integer insertEvalData(EvalVO params) throws Exception;	
	public void insertEvalResultData(List<EvalResultVO> params) throws Exception;			

	Integer updateEvalData(EvalVO params) throws Exception;	
	Integer updateEvalResultData(EvalResultVO params) throws Exception;	
}
