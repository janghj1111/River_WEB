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
	public void saveBoard(HttpServletRequest request) throws Exception {
		// 로그인 상태 체크 // 일일이 로그인 체크 하냐고
		if(request.getSession().getAttribute("myid") == null) {
			throw new Exception("guestUser Exception");
		}
		
		logger.info("##### serviceimpl : saveBoard 진입 #####");
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		
		// request에 있는 title mytextarea 가져온다
		String title = request.getParameter("title"); //.toString();
		String content = request.getParameter("mytextarea"); //.toString();
		
		
		// XML에 보낼 인자값
		paramMap.put("in_title", title);
		paramMap.put("in_content", content);
		paramMap.put("in_userid", request.getSession().getAttribute("myid"));
		paramMap.put("out_state", 0);
		// XML에서 리턴된 결과값
		boardMapper.saveBoard(paramMap);
	}

	@Override
	public HashMap<String, Object> showBoard(HttpServletRequest request) throws Exception {
		// 로그인 상태 체크 // 일일이 로그인 체크 하냐고
		if(request.getSession().getAttribute("myid") == null) {
			throw new Exception("guestUser Exception");
		}
		logger.info("##### serviceimpl : saveBoard 진입 #####");
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		// request에 있는 title mytextarea 가져온다
		String title = request.getParameter("title"); //.toString();
		String content = request.getParameter("mytextarea"); //.toString();
		
		
		// XML에 보낼 인자값
		paramMap.put("in_title", title);
		paramMap.put("in_content", content);
		paramMap.put("in_userid", request.getSession().getAttribute("myid"));
		paramMap.put("out_state", 0);
		// XML에서 리턴된 결과값
		resultMap = boardMapper.showBoard(paramMap);
		return null;
	}
}
