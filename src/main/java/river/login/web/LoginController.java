package river.login.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		logger.info("##### Controller : goLogin 진입 #####");
		return "login/login"; 
	}
	
	/**
	 * 로그인 ID, PW 입력
	 **/ 
	@RequestMapping(value="/submitLogin.do", method = RequestMethod.POST)
	public String submit(HttpServletRequest request, ModelMap model) throws Exception {
		logger.info("##### Controller : submit 진입 #####");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			resultMap = loginService.checkLogin(request);
			request.getSession().setAttribute("myid",resultMap.get("userid").toString()); // 세션에 유저ID 넣어줌.
			model.addAttribute("userId", resultMap.get("userid").toString());
		} catch (Exception e) {
			logger.info("##### 에러로 갔음 #####");
			e.printStackTrace();
			return "error/egovError";
		} 
		return "redirect:/logout.do";
	}
	
	/**
	 * 로그아웃
	 **/ 
	@RequestMapping(value="/logout.do")
	public String logout(HttpServletRequest request, ModelMap model) throws Exception {
		logger.info("##### Controller : logout 진입 #####");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		String sessionId = request.getSession().getAttribute("myId").toString(); 
		logger.info("##### sessionId : " + sessionId);
		request.getSession().invalidate(); // 세션에 저장된 데이터 삭제 
		
		
		try {
			resultMap = loginService.checkLogin(request);
			request.getSession().setAttribute("myid",resultMap.get("userid").toString()); // 세션에 유저ID 넣어줌.
			model.addAttribute("userId", resultMap.get("userid").toString());
			model.addAttribute("userPw", resultMap.get("userpw").toString());
			return "login/login"; 
		} catch (Exception e) {
			logger.info("##### 에러로 갔음 #####");
			e.printStackTrace();
			return "error/egovError";
		} 
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
