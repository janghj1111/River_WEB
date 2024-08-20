package river.board.service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import river.login.vo.UserVO;
import com.lib.util.ValidationForm;

import river.board.dao.BoardMapper;
import river.board.service.BoardService;

@Service("BoardService")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService {

	private static final Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Resource(name="BoardMapper")
	BoardMapper boardMapper;

	// 글 작성 완료
	@Override
	public void saveBoard(HttpServletRequest request) throws Exception {
		// 로그인 상태 체크 // 일일이 로그인 체크 하냐고
		if(request.getSession().getAttribute("userVo") == null) {
			throw new Exception("ERROR : UserInfo Null Exception");
		}
		
		logger.info("##### serviceimpl : saveBoard 진입 #####");
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		
		// request에 있는 title mytextarea 가져온다
		String title = request.getParameter("title"); //.toString();
		String content = request.getParameter("mytextarea"); //.toString();
		
		
		// XML에 보낼 인자값
		paramMap.put("in_title", title);
		paramMap.put("in_content", content);
		//paramMap.put("in_userid", request.getSession().getAttribute("myid"));
		paramMap.put("in_userid", ((UserVO)request.getSession().getAttribute("userVo")).getUserId());
		paramMap.put("out_state", 0);
		// XML에서 리턴된 결과값
		boardMapper.saveBoard(paramMap);
	}
	
	// 글 목록 조회
	@Override
	public ArrayList<HashMap<String, Object>> showBoardList(HttpServletRequest request) throws Exception {
		// 로그인 상태 체크 // 일일이 로그인 체크 하냐고
				if(request.getSession().getAttribute("userVo") == null) {
					throw new Exception("ERROR : UserInfo Null Exception");
				}
				logger.info("##### serviceimpl : showBoard 진입 #####");
				HashMap<String, Object> paramMap = new HashMap<String, Object>();
				HashMap<String, Object> resultMap = new HashMap<String, Object>();
				

				String id = ((UserVO)request.getSession().getAttribute("userVo")).getUserId();
				// request에 있는 boardId 가져온다 ( /boardView.do?boardId=1 )
				String boardId = request.getParameter("boardId");
				boolean validflag = false;
				validflag = ValidationForm.validNum(boardId); // util 유효성검증
				if(!validflag) {
					throw new Exception("ERROR : validation failed");
				}
				
				
				// XML에 보낼 인자값
				paramMap.put("in_boardId", boardId);
				// paramMap.put("out_state", 0);
				// XML에서 리턴된 결과값
				resultMap = boardMapper.showBoard(paramMap);
				if(resultMap == null) {
					throw new Exception("ERROR : validation failed");
				}
				return null;//resultMap;
	}
	
	// 상세 글 조회
	@Override
	public HashMap<String, Object> showBoard(HttpServletRequest request) throws Exception {
		// 로그인 상태 체크 // 일일이 로그인 체크 하냐고
		if(request.getSession().getAttribute("userVo") == null) {
			throw new Exception("ERROR : UserInfo Null Exception");
		}
		logger.info("##### serviceimpl : showBoard 진입 #####");
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		

		String id = ((UserVO)request.getSession().getAttribute("userVo")).getUserId();
		// request에 있는 boardId 가져온다 ( /boardView.do?boardId=1 )
		String boardId = request.getParameter("boardId");
		boolean validflag = false;
		validflag = ValidationForm.validNum(boardId); // util 유효성검증
		if(!validflag) {
			throw new Exception("ERROR : validation failed");
		}
		
		
		// XML에 보낼 인자값
		paramMap.put("in_boardId", boardId);
		// paramMap.put("out_state", 0);
		// XML에서 리턴된 결과값
		resultMap = boardMapper.showBoard(paramMap);
		if(resultMap == null) {
			throw new Exception("ERROR : validation failed");
		}
		return resultMap;
	}
}
