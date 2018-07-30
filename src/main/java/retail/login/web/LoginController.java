package retail.login.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import retail.common.CommonUtil;
import retail.common.JqDepartResult;
import retail.common.JqLoginResult;
import retail.common.SessionModel;
import retail.login.service.LoginService;
import retail.login.service.LoginVO;


@Controller
public class LoginController {
	
	private static final boolean D = true;

	@Autowired
	private LoginService loginService;
	
	
	@RequestMapping(value = "/goLogin.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView goLogin(HttpServletRequest request, HttpServletResponse response, ModelMap model)throws Exception 
	{
		if(D) System.out.println("=========== SERVER START ===========");
		ModelAndView mavLogin = new ModelAndView();
		
		String name = "-";
		String pass = "-";	
		
		if(request.getMethod().equals("GET")) {
			if(D) System.out.println("=========== GET ===========");
		}
		if(request.getMethod().equals("POST")) {
			if(D) System.out.println("=========== POST ===========");
			name = request.getParameter("USER_NAME");
			pass = request.getParameter("USER_PASS");
		}
		
		//List<LoginVO> listLogin = loginService.getAllUserName();

		mavLogin.setViewName("/retail/login/login");
		mavLogin.addObject("name", name);
		mavLogin.addObject("pass", pass);	
		
		//mavLogin.addObject("users", listLogin);	
		
		return mavLogin;
 
	}
	
	 
	@RequestMapping(value = "/login.do", method=RequestMethod.POST)
	public void login( HttpServletRequest request,HttpServletResponse response )throws Exception {
		
		try {
			String user_name    = request.getParameter("user_name");
			String user_pass  = request.getParameter("user_pass");
			
			//암호화
			String encryptPass = CommonUtil.encryptSEED128(user_pass);	
			 
			LoginVO paLoginVo = new LoginVO();
			paLoginVo.setUSER_NAME(user_name);
			paLoginVo.setUSER_PASS(encryptPass); 
			//paLoginVo.setUSER_PASS(user_pass); 
			 
			List<LoginVO> listLogin = loginService.login(paLoginVo);
			//result = ajaxServiceSelect(result);
			
			JqLoginResult jqLoginResult = new JqLoginResult();
			
			if( listLogin.size() > 0 ) {
				// 여기에 세션 추가
				SessionModel env = new SessionModel();
				env.setUser_num(listLogin.get(0).getUSER_NUM()); 	
				env.setUser_name(listLogin.get(0).getUSER_NAME()); 	
				env.setDepart_num(listLogin.get(0).getDEPART_NUM()); 
				env.setDepart_name(listLogin.get(0).getDEPART_NAME()); 
				env.setUpuser_num(listLogin.get(0).getUPUSER_NUM()); 
				env.setUpuser_name(listLogin.get(0).getUPUSER_NAME()); 			 
				env.setUser_date(listLogin.get(0).getUSER_DATE()); 			
				env.setUser_pic(CommonUtil.checkUserImg(listLogin.get(0).getUSER_NUM(), request));				
				
				CommonUtil.setEnv(request.getSession(), env); 
				
				jqLoginResult.setResult(0);	
				
				for(LoginVO loginVO : listLogin) {
					jqLoginResult.addUserData(loginVO);
				} 
				
			}			
			else {				
				List<LoginVO> checkList = loginService.checkuser(paLoginVo);
				
				if( checkList.size() > 0 ) {
					if( checkList.get(0).getUSER_PASS() == null || checkList.get(0).getUSER_PASS().length() <= 0) {
						jqLoginResult.setResult(2);	
					}
					else {
						jqLoginResult.setResult(3);	
					}		
				}
				else {
					jqLoginResult.setResult(1);	
				}			
			}
			
			String jsonStr = jqLoginResult.getJsonString(); 	
			response.setContentType("text/json; charset=utf-8"); 
			response.getWriter().print(jsonStr);
			
		} 
		catch (IOException e){
			if(D) System.err.println("login.do IOException Occured : " + e.toString());
		} 
		catch (Exception e){
			if(D) System.err.println("login.do Exception Occured : " + e.toString());
		}
	}
	
	// login - user 선택
	@RequestMapping(value = "/goLoginUser.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView goLoginUser(HttpServletRequest request, HttpServletResponse response, ModelMap model)throws Exception 
	{
		ModelAndView mavLogin = new ModelAndView();
		
		JqDepartResult jqDepartResult = new JqDepartResult();
		
		try {	
			List<LoginVO> listDepart = loginService.getAllDepart();
			
			if(listDepart.size() > 0) {
				for(int i = 0 ; i < listDepart.size() ; i++) {					
					List<LoginVO> listUser = loginService.getDepartUser(listDepart.get(i));					
					jqDepartResult.addDepart(listDepart.get(i), listUser, request);					
				}				
			}			
		}
		catch (IOException e){
			if(D) System.err.println("goLoginUser.do IOException Occured : " + e.toString());
		} 
		catch (Exception e){
			if(D) System.err.println("goLoginUser.do Exception Occured : " + e.toString());
		}
		
		mavLogin.setViewName("/retail/login/login_user");
		mavLogin.addObject("object", jqDepartResult.getJsonObject());			
		
		return mavLogin; 
	}

	

	@RequestMapping(value = "/error.do", method = RequestMethod.GET)
	public ModelAndView goerror(HttpServletRequest request, HttpServletResponse response )throws Exception { 
		 
		CommonUtil.setEnv(request.getSession() , null);
		ModelAndView mav = new  ModelAndView("retail/login/error");
		
		return   mav; 
	}
	
	@RequestMapping(value = "/errorServlet.do", method = RequestMethod.GET)
	public ModelAndView goerrorServlet(HttpServletRequest request, HttpServletResponse response )throws Exception { 
		 
		CommonUtil.setEnv(request.getSession() , null);
		ModelAndView mav = new  ModelAndView("retail/login/errorServlet");
		
		return   mav; 
	}
	
	
	/**
	 * 로그아웃 요청
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView goLogout(HttpServletRequest request, HttpServletResponse response )throws Exception { 
		 
		CommonUtil.setEnv(request.getSession() , null);
		ModelAndView mav = new  ModelAndView("retail/login/logout");
		
		return   mav; 
	}
}
