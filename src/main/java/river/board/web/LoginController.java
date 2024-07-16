package river.board.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * 로그인 화면 이동
	 **/ 
	@RequestMapping(value="/login.do")
	public String goLogin(HttpServletRequest request, ModelMap model) throws Exception {
		logger.info("##### goLogin 컨트롤러 진입 #####");
		return "login/login"; 
	}

}
