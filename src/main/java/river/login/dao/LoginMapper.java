package river.login.dao;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper("LoginMapper")
public interface LoginMapper {
	
	// 테스트용
	public HashMap<String, Object> httpServletReqTest(HashMap<String, Object> paramMap) throws Exception;

	// 로그인 시 정보 확인
	public HashMap<String, Object> checkLogin(HashMap<String, Object> paramMap)throws Exception;

}
