package river.login.dao;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper("LoginMapper")
public interface LoginMapper {
	
	public HashMap<String, Object> httpServletReqTest(HashMap<String, Object> paramMap) throws Exception;

}
