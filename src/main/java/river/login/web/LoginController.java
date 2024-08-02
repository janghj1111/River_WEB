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
import river.login.vo.UserVO;

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
	@RequestMapping(value = "/submitLogin.do") /* , method = RequestMethod.POST */
	public String submit(HttpServletRequest request, ModelMap model) throws Exception {
		logger.info("##### Controller : submit 진입 #####");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			resultMap = loginService.checkLogin(request);
			request.getSession().setAttribute("userVo",resultMap.get("userVo")); // 세션에 유저ID말고 userVo 넣어줌.
			//request.getSession().setAttribute("myid",resultMap.get("userid").toString()); // 세션에 유저ID 넣어줌.
			model.addAttribute("userId", ((UserVO)resultMap.get("userVo")).getUserId());
		} catch (Exception e) {
			String errorStr = e.getMessage(); // serviceImpl에서 throw한 Exception 로그를 가져옴.
			logger.info("!!!! errorStr : " + errorStr);
			e.printStackTrace();
			if(errorStr.equals("Validation Error => return Null Error")) {
				return "redirect:/login.do";
			} else {
				// else 
			}
			return "error/egovError";
		} 
		//return "redirect:/main.do";
		return "login/main";
	}
	
	/**
	 * 임시 메인 화면
	 **/ 
	@RequestMapping(value = "/main.do") 
	public String goMain(HttpServletRequest request, ModelMap model) throws Exception {
		try {
			
			logger.info("" + request.getSession().getAttribute("userVo"));
			// UserVO(userNo=0, userId=jang, userPw=qwer1234, nickName=null, enterIp=null, loginIp=null, loginCount=0, usePermit=null, nouse_Count=0, limitCount=0, condition_Yn=null)
			loginService.checkUser(request);
			
			//model.add
		} catch (Exception e) {
			String errorStr = e.getMessage(); // serviceImpl에서 throw한 Exception 로그를 가져옴.
			if(errorStr.equals("guestUser Exception")) {
				return "redirect:/login.do";
			} else {
				// else 
			}
			e.printStackTrace();
			return "error/egovError";
		}
		return "login/main"; 
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
