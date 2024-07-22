package river.login.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
	
	public HashMap<String, Object> httpServletReqTest(HttpServletRequest request) throws Exception;

	public HashMap<String, Object> checkLogin(HttpServletRequest request) throws Exception;
}
