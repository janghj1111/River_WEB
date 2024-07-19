package river.login.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import river.login.service.LoginService;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource(name="LoginService")
	LoginService loginService;
	
	/**
	 * 로그인 화면 이동
	 **/ 
	@RequestMapping(value="/login.do")
	public String goLogin(HttpServletRequest request, ModelMap model) throws Exception {
		logger.info("##### goLogin 컨트롤러 진입 #####");
		return "login/login"; 
	}
	
	/**
	 * 테스트
	 **/ 
	@RequestMapping(value="/test.do")
	public String test(HttpServletRequest request, ModelMap model) throws Exception {
		logger.info("##### TEST #####");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		try {
			resultMap = loginService.httpServletReqTest(request);
			model.addAttribute("userId", resultMap.get("userid").toString());
			model.addAttribute("userPw", resultMap.get("userpw").toString());
			return "login/test"; 
		} catch (Exception e) {
			logger.info("##### 에러로 갔음 #####");
			e.printStackTrace();
			return "error/egovError";
		}
		
	}
	
	

}
