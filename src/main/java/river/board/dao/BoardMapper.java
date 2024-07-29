package river.board.dao;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.egovframe.rte.psl.dataaccess.mapper.Mapper;

@Mapper("BoardMapper")
public interface BoardMapper {

	// 글 추가
	public void saveBoard(HashMap<String, Object> paramMap) throws Exception;
	// 상세 글 조회 // 07.30 xml추가해야함.
	public HashMap<String, Object> showBoard(HashMap<String, Object> paramMap) throws Exception;

}
