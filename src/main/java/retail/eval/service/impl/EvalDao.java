package retail.eval.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import retail.eval.service.EvalResultVO;
import retail.eval.service.EvalVO;
import retail.eval.service.GradeItemVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@SuppressWarnings("unchecked")
@Repository("EvalDao")
public class EvalDao extends EgovAbstractDAO {
	
	public EvalVO getLastEvalData(EvalVO params) throws Exception {
		return (EvalVO) select("eval.getLastEvalData", params);
	}	
	public  EvalVO getEvalData(EvalVO params) throws Exception {
		return (EvalVO) select("eval.getEvalData", params);		
	}	
	public List<EvalVO> getAllEvalData(EvalVO params) throws Exception {
		return (List<EvalVO>) list("eval.getAllEvalData", params);				
	}
	
	
	public EvalVO getUserEvalData(EvalVO params) throws Exception {
		return (EvalVO) select("eval.getUserEvalData", params);		
	}	
	public List<EvalVO> getAllUserEvalData(EvalVO params) throws Exception {
		return (List<EvalVO>) list("eval.getAllUserEvalData", params);				
	}	
	
	
	public  List<EvalResultVO> getAllEvalResultData(EvalVO params) throws Exception {
		return (List<EvalResultVO>) list("eval.getAllEvalResultData", params);		
	}
	public List<EvalResultVO> getEvalResultData(EvalResultVO params) throws Exception {
		return (List<EvalResultVO>) list("eval.getEvalResultData", params);		
	}	
	public List<EvalResultVO> getEvalRateData(EvalVO params) throws Exception {
		return (List<EvalResultVO>) list("eval.getEvalRateData", params);		
	}
	
	
	public List<GradeItemVO> getGradeItemData(GradeItemVO params) throws Exception {
		return (List<GradeItemVO>) list("eval.getGradeItemData", params);		
	}
	public List<GradeItemVO> getUserGradeItemData(EvalVO params) throws Exception {
		return (List<GradeItemVO>) list("eval.getUserGradeItemData", params);		
	}
	
	
	public Integer insertEvalData(EvalVO params) throws Exception {		
		return (Integer) this.insert("eval.insertEvalData", params);
	}	
	public void insertEvalResultData(List<EvalResultVO> params) throws Exception {	
		insert("eval.insertEvalResultData", params);
	}	


	public Integer updateEvalData(EvalVO params) throws Exception {
		return (Integer) this.update("eval.updateEvalData", params);
	}
	public Integer updateEvalResultData(EvalResultVO params) throws Exception {		
		return (Integer) this.update("eval.updateEvalResultData", params);
	}
}
