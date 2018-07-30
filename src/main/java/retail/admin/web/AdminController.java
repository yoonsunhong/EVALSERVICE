package retail.admin.web;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import retail.admin.service.AdminService;
import retail.admin.service.AdminVO;
import retail.common.CommonUtil;
import retail.common.JqResult;
import retail.common.SessionAModel;


@Controller
public class AdminController {
	
	private static final boolean D = true;

	@Autowired
	private AdminService adminService;	
	
	@RequestMapping(value = "/admin.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView admin(HttpServletRequest request, HttpServletResponse response, ModelMap model)throws Exception 
	{
		ModelAndView mavAdmin = new ModelAndView();
		mavAdmin.setViewName("/retail/admin/alogin");
		
		return mavAdmin; 
	}
	
	@RequestMapping(value = "/aLogin.do", method = RequestMethod.POST)
	public void aLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model)throws Exception 
	{
		try {
			String admin_id    = request.getParameter("admin_id");
			String admin_pass  = request.getParameter("admin_pass");
			
			//암호화
			//String encryptPass = CommonUtil.encryptSEED128(admin_pass);	
			 
			AdminVO paAdminVo = new AdminVO();
			paAdminVo.setADMIN_ID(admin_id);
			paAdminVo.setADMIN_PASS(admin_pass); 
			//paAdminVo.setADMIN_PASS(encryptPass); 
			 
			List<AdminVO> listAdmin = adminService.alogin(paAdminVo);			
			JqResult jqResult = new JqResult();
			
			if( listAdmin.size() > 0 ) {
				// 여기에 세션 추가
				SessionAModel env = new SessionAModel();
				env.setAdmin_id(listAdmin.get(0).getADMIN_ID());
				env.setAdmin_grade(listAdmin.get(0).getADMIN_GRADE());
				env.setAdmin_name(listAdmin.get(0).getADMIN_NAME());
				
				CommonUtil.setAEnv(request.getSession(), env); 
				
				jqResult.setResult(0);					
			}			
			else {	
				jqResult.setResult(1);		
			}
			
			String jsonStr = jqResult.getJsonString(); 	
			response.setContentType("text/json; charset=utf-8"); 
			response.getWriter().print(jsonStr);
			
		} 
		catch (IOException e){
			if(D) System.err.println("aLogin.do IOException Occured : " + e.toString());
		} 
		catch (Exception e){
			if(D) System.err.println("aLogin.do Exception Occured : " + e.toString());
		} 
	}
	
	@RequestMapping(value = "/goAMain.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView goAMain(HttpServletRequest request, HttpServletResponse response, ModelMap model)throws Exception 
	{
		ModelAndView mavAdmin = new ModelAndView();
		mavAdmin.setViewName("/retail/admin/amain");
		
		return mavAdmin; 
	}
	
	
	
	/**
	 * 관리모드 Top화면
	 * @param model
	 * @return "mav"
	 * @exception Exception
	 */
	@RequestMapping(value = "/aMainTop.do", method = RequestMethod.GET)
	public ModelAndView aMainTop(HttpServletRequest request, HttpServletResponse response )throws Exception { 
		
//		/**
//		 * 다국어 프로퍼티 가지고 오는 샘플
//		 * */
//		String korMessage = messageSource.getMessage("title.sample.regUser",null, "no surch", Locale.KOREA);
//		String engMessage = messageSource.getMessage("title.sample.regUser",null, "no surch", Locale.ENGLISH);
//		System.out.println("KOR: "+korMessage+" ENG: "+engMessage);
		
		ModelAndView mav = new  ModelAndView("retail/admin/menu/top");
		return   mav; 
	}
	
	
//	/**
//	 * 관리모드 평가기준 관리 화면
//	 * @param model
//	 * @return "mav"
//	 * @exception Exception
//	 */
//	@RequestMapping(value = "/aMainEvalManage.do", method = RequestMethod.GET)
//	public ModelAndView aMainEvalManage(HttpServletRequest request, HttpServletResponse response )throws Exception { 
//		
//		ModelAndView mav = new  ModelAndView("retail/admin/menu/eval_manage");
//		return   mav; 
//	}
	
	
	
	/**
	 * 관리모드 로그아웃 요청
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/aLogout.do", method = RequestMethod.GET)
	public ModelAndView aLogout(HttpServletRequest request, HttpServletResponse response )throws Exception { 
		 
		CommonUtil.setAEnv(request.getSession() , null);
		ModelAndView mav = new  ModelAndView("retail/admin/alogout");
		
		return mav; 
	}
}
