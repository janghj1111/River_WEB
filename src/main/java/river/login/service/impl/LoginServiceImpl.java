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
import river.login.vo.UserVO;

@Service("LoginService")
public class LoginServiceImpl extends EgovAbstractServiceImpl implements LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	@Resource(name="LoginMapper")
	LoginMapper loginMapper;
	
	// 유저 체크
	@Override
	public void checkUser(HttpServletRequest request) throws Exception {
		if(request.getSession().getAttribute("userVo") == null) {
			throw new Exception("ERROR : UserInfo Null Exception");
		} 
	}

	// 로그인 시 체크
	@Override
	public HashMap<String, Object> checkLogin(HttpServletRequest request) throws Exception {
		logger.info("##### serviceimpl : checkLogin 진입 #####");
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		// request에 있는 userId와 userPw을 가져온다
		String userId = request.getParameter("userId").toString();
		String userPw = request.getParameter("userPw").toString();
		if( userId.length() > 10) {
			throw new Exception("Validation Error => length Error");
		}
		
		// XML에 보낼 인자값
		paramMap.put("paramId", userId);
		paramMap.put("paramPw", userPw);
		paramMap.put("out_state", -1); // 프로시저 테스트용. 프로시저 타기전에는 -1이 타게되면 0으로 됨
		
		// XML에서 리턴된 결과값
		UserVO userVo = loginMapper.checkLogin(paramMap);
		//resultMap = loginMapper.checkLogin2(paramMap); // 프로시저 테스트용		
		if ( userVo == null ) { // 검색된 내용이 없을 경우   // vo안쓰고 프로시저 사용할 때는 if(resultMap == null){
			throw new Exception("Validation Error => return Null Error");
		} 	
		resultMap.put("userVo", userVo);
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
