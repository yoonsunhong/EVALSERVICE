/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package retail.main.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import retail.common.CommonUtil;
import retail.common.JqUserResult;
import retail.main.service.MainService;
import retail.main.service.UserVO;

@Controller
public class MainController {
	
	private static final boolean D = true;	

	@Autowired
	private MainService mainService;
	

	@RequestMapping(value = "/goMain.do", method = RequestMethod.GET)
	public ModelAndView goMain(HttpServletRequest request, HttpServletResponse response )throws Exception { 
		
		ModelAndView mavMain = new  ModelAndView();
		mavMain.setViewName("/retail/main/main");
			
		return   mavMain;
	}
	
	@RequestMapping(value = "/goSelect.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView goSelect(HttpServletRequest request, HttpServletResponse response )throws Exception { 
		
		ModelAndView mavSeclet = new  ModelAndView();
		JqUserResult jqUserResult = new JqUserResult();
		
		try {	
			UserVO paUserVo = new UserVO();
			paUserVo.setUSER_NUM(CommonUtil.getEnv(request.getSession()).getUser_num());
			
			List<UserVO> listUser = mainService.getUnderUser(paUserVo);
			
			if( listUser.size() > 0 ) {		

				mavSeclet.addObject("userlist", listUser);
				jqUserResult.setResult(0);
				
				for(UserVO userVO : listUser) {
					jqUserResult.addUserData(userVO);
				} 				
			}
			else {				
				jqUserResult.setResult(1);
			}
			
		}
		catch (IOException e) {			
			jqUserResult.setResult(2);
			if(D) System.err.println("goSelect.do IOException Occured : " + e.toString());
		}
		catch (Exception e) {			
			jqUserResult.setResult(2);
			if(D) System.err.println("goSelect.do Exception Occured : " + e.toString());
		}
		
		mavSeclet.setViewName("/retail/main/select");
		mavSeclet.addObject("json_object", jqUserResult.getJsonObject());
		return   mavSeclet;
	}
}
