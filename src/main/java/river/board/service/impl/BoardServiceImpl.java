package river.board.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import river.board.dao.BoardMapper;
import river.board.service.BoardService;

@Service("BoardService")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Resource(name="BoardMapper")
	BoardMapper boardMapper;

	// 글 작성 완료
	@Override
	public HashMap<String, Object> insertBoard(HttpServletRequest request) throws Exception {
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
		
		logger.info("@@@ 인자개수 수정함 ");
		// XML에서 리턴된 결과값
//		resultMap = loginMapper.checkLogin2(paramMap);
//		
//		
//		if (resultMap == null ) { // 검색된 내용이 없을 경우
//			throw new Exception("Validation Error => return Null Error");
//		} 	
		return resultMap;
	}
}
