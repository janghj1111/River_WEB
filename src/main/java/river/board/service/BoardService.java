package river.board.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {
	
	public HashMap<String, Object> insertBoard(HttpServletRequest request) throws Exception;

	//public HashMap<String, Object> checkLogin(HttpServletRequest request) throws Exception;
}
