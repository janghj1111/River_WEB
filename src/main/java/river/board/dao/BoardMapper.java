package river.board.dao;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper("BoardMapper")
public interface BoardMapper {

	// 로그인 시 정보 확인
	public HashMap<String, Object> checkLogin(HashMap<String, Object> paramMap)throws Exception;
	
	// checkLogin 프로시저 테스트용
	public HashMap<String, Object> checkLogin2(HashMap<String, Object> paramMap) throws Exception;
	
	// 테스트용
	public HashMap<String, Object> httpServletReqTest(HashMap<String, Object> paramMap) throws Exception;

	public void saveBoard(HashMap<String, Object> paramMap);

}
