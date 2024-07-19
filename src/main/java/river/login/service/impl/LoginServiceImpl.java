package river.login.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import river.login.dao.LoginMapper;
import river.login.service.LoginService;
import river.login.web.LoginController;

@Service("LoginService")
public class LoginServiceImpl extends EgovAbstractServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Resource(name="LoginMapper")
	LoginMapper loginMapper;
	
	
	@Override
	public HashMap<String, Object> httpServletReqTest(HttpServletRequest request) throws Exception {
		logger.info("##### TEST - serviceimpl #####");
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return loginMapper.httpServletReqTest(paramMap);
	}

}
