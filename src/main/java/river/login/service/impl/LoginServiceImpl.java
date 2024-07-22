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

@Service("LoginService")
public class LoginServiceImpl extends EgovAbstractServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Resource(name="LoginMapper")
	LoginMapper loginMapper;

	// 로그인 시 체크
	@Override
	public HashMap<String, Object> checkLogin(HttpServletRequest request) throws Exception {
		logger.info("##### serviceimpl : checkLogin 진입 #####");
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		// request에 있는 userId와 userPw을 가져온다
		String userId = request.getParameter("userId").toString();
		if( userId.length() > 10) {
			throw new Exception("Validation Error => length Error");
		}
		
		// XML에 보낼 인자값
		paramMap.put("paramId", userId);
		
		// XML에서 리턴된 결과값
		resultMap = loginMapper.checkLogin(paramMap);
		if (resultMap == null ) { // 검색된 내용이 없을 경우
			throw new Exception("Validation Error => return Null Error");
		} 	
		
		return resultMap;
	}

	// test 
	@Override
	public HashMap<String, Object> httpServletReqTest(HttpServletRequest request) throws Exception {
		logger.info("##### TEST - serviceimpl #####");
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		return loginMapper.httpServletReqTest(paramMap);
	}
}
