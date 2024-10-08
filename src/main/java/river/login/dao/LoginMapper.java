package river.login.dao;

import java.util.HashMap;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

import river.login.vo.UserVO;

@Mapper("LoginMapper")
public interface LoginMapper {

	// 로그인 시 정보 확인
	public UserVO checkLogin(HashMap<String, Object> paramMap)throws Exception;
	
	// checkLogin 프로시저 테스트용
	public HashMap<String, Object> checkLogin2(HashMap<String, Object> paramMap) throws Exception;
	
	// 테스트용
	public HashMap<String, Object> httpServletReqTest(HashMap<String, Object> paramMap) throws Exception;

}
