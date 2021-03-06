package retail.eval.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import retail.eval.service.EvalResultVO;
import retail.eval.service.EvalService;
import retail.eval.service.EvalVO;
import retail.eval.service.GradeItemVO;


@Service("EvalService")
public class EvalServiceimpl implements EvalService {	

	@Autowired
	private EvalDao evalDao;

	@Override
	@Transactional
	public EvalVO getLastEvalData(EvalVO params) throws Exception {		
		return evalDao.getLastEvalData(params);
	}

	@Override
	@Transactional
	public EvalVO getEvalData(EvalVO params) throws Exception {		
		return evalDao.getEvalData(params);
	}
	
	@Override
	@Transactional
	public List<EvalVO> getAllEvalData(EvalVO params) throws Exception {		
		return evalDao.getAllEvalData(params);
	}

	@Override
	@Transactional
	public EvalVO getUserEvalData(EvalVO params) throws Exception {
		return evalDao.getUserEvalData(params);
	}

	@Override
	@Transactional
	public List<EvalVO> getAllUserEvalData(EvalVO params) throws Exception {
		return evalDao.getAllUserEvalData(params);
	}
	
	
	

	@Override
	@Transactional
	public List<EvalResultVO> getAllEvalResultData(EvalVO params) throws Exception {		
		return evalDao.getAllEvalResultData(params);
	}

	@Override
	@Transactional
	public List<EvalResultVO> getEvalResultData(EvalResultVO params) throws Exception {		
		return evalDao.getEvalResultData(params);
	}

	@Override
	@Transactional
	public List<EvalResultVO> getEvalRateData(EvalVO params) throws Exception {		
		return evalDao.getEvalRateData(params);
	}

	
		
	
	@Override
	@Transactional
	public List<GradeItemVO> getGradeItemData(GradeItemVO params) throws Exception {
		return evalDao.getGradeItemData(params);
	}

	@Override
	@Transactional
	public List<GradeItemVO> getUserGradeItemData(EvalVO params) throws Exception {
		return evalDao.getUserGradeItemData(params);
	}

	
	
	
	@Override
	@Transactional
	public Integer insertEvalData(EvalVO params) throws Exception {		
		return evalDao.insertEvalData(params);
	}

	@Override
	@Transactional
	public void insertEvalResultData(List<EvalResultVO> params) throws Exception {		
		evalDao.insertEvalResultData(params);
	}
	
	


	@Override
	@Transactional
	public Integer updateEvalData(EvalVO params) throws Exception {
		return evalDao.updateEvalData(params);
	}
	
	@Override
	@Transactional
	public Integer updateEvalResultData(EvalResultVO params) throws Exception {		
		return evalDao.updateEvalResultData(params);
	}
}
