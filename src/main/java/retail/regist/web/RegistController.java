package retail.regist.web;

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
import retail.common.JqResult;
import retail.regist.service.RegistService;
import retail.regist.service.RegistVO;


@Controller
public class RegistController {
	
	private static final boolean D = true;

	@Autowired
	private RegistService registService;
	
	
	@RequestMapping(value = "/goRegist.do", method = RequestMethod.POST)
	public ModelAndView goRegist(HttpServletRequest request, HttpServletResponse response, ModelMap model)throws Exception 
	{		
		ModelAndView mavRegist = new ModelAndView();
		
		String name = request.getParameter("USER_NAME");
		String pass = request.getParameter("USER_PASS");
		
		//if(D) System.out.println(name);
		
		mavRegist.setViewName("/retail/regist/regist");
		mavRegist.addObject("name", name);
		mavRegist.addObject("pass", pass);	
		
		return mavRegist;
 
	}
	
	@RequestMapping(value = "/regist.do", method=RequestMethod.POST)
	public void regist( HttpServletRequest request,HttpServletResponse response )throws Exception {
		
		try {

			String user_name		= request.getParameter("user_name");
			String user_pass		= request.getParameter("user_pass");
			
			//암호화
			String encryptPass = CommonUtil.encryptSEED128(user_pass);	
			 
			RegistVO params = new RegistVO();
			params.setUSER_NAME(user_name);	
			params.setUSER_PASS(encryptPass); 
			//params.setUSER_PASS(user_pass); 				
			
			List<RegistVO> resultUser;
			resultUser = registService.checkUser(params);
			
			JqResult jqResult = new JqResult();
						
			if( resultUser.size() > 0) {
				
				if(resultUser.get(0).getUSER_PASS() == null) {	
					RegistVO updateparams = new RegistVO();
					updateparams.setUSER_NUM(resultUser.get(0).getUSER_NUM());
					updateparams.setUSER_NAME(user_name);
					updateparams.setUSER_PASS(encryptPass); 
					
					registService.updatePass(updateparams);		
					
					jqResult.setResult(0);
				}
				else {
					jqResult.setResult(2);
				}				
			}			
			else {
				jqResult.setResult(1);
			}
			
			String jsonStr = jqResult.getJsonString(); 	
			response.setContentType("text/json; charset=utf-8"); 
			response.getWriter().print(jsonStr);
			
		} 
		catch (IOException e) {
			if(D) System.err.println("regist.do IOException Occured : " + e.toString());
		}
		catch (Exception e) {
			if(D) System.err.println("regist.do Exception Occured : " + e.toString());
		}
		
		
	}
}
