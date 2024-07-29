package river.board.web;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import river.board.service.BoardService;
import river.login.service.LoginService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name="LoginService")
	LoginService loginService;
	
	@Resource(name="BoardService")
	BoardService boardService;
	
	/**
	 * 글 작성 화면 이동
	 **/ 
	@RequestMapping(value="/boardwrite.do")
	public String goBoard(HttpServletRequest request, ModelMap model) throws Exception {
		logger.info("##### Controller : goBoard 진입 #####");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			loginService.checkUser(request);
		} catch (Exception e) {
			String errorStr = e.getMessage(); // serviceImpl에서 throw한 Exception 로그를 가져옴.
			if(errorStr.equals("guestUser Exception")) {
				return "redirect:/login.do";
			} else {
				// else 
			}
			e.printStackTrace();
			return "error/egovError";
		}
		
//		String userId = request.getSession().getAttribute("userId").toString();
//		logger.info("userId = " + userId );
//		model.addAttribute("userId", request.getParameter("userId").toString());
//		logger.info("model = " + model );
		//게시글 이용 전 회원 체크
		return "board/boardWrite"; 
	}
	
	/**
	 * 글 작성 저장
	 **/ 
	@RequestMapping(value="/saveBoard.do" ) // , method = RequestMethod.POST
	public String saveBoard(HttpServletRequest request, ModelMap model) throws Exception {
		logger.info("##### Controller : saveBoard 진입 #####");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			boardService.saveBoard(request);
		} catch (Exception e) {
			String errorStr = e.getMessage(); // serviceImpl에서 throw한 Exception 로그를 가져옴.
			if(errorStr.equals("guestUser Exception")) {
				return "redirect:/login.do";
			} else {
				// else 
			}
			e.printStackTrace();
			return "error/egovError";
		}
		//게시글 이용 전 회원 체크
		return "board/boardWrite"; 
	}
	
//	/**
//	 * 로그인 ID, PW 입력
//	 **/ 
//	@RequestMapping(value = "/submitLogin.do") /* , method = RequestMethod.POST */
//	public String submit(HttpServletRequest request, ModelMap model) throws Exception {
//		logger.info("##### Controller : submit 진입 #####");
//		HashMap<String, Object> resultMap = new HashMap<String, Object>();
//		
//		try {
//			resultMap = loginService.checkLogin(request);
//			request.getSession().setAttribute("myid",resultMap.get("userid").toString()); // 세션에 유저ID 넣어줌.
//			model.addAttribute("userId", resultMap.get("userid").toString());
//		} catch (Exception e) {
//			logger.info("##### 에러로 갔음 #####");
//			
//			String errorStr = e.getMessage(); // serviceImpl에서 throw한 Exception 로그를 가져옴.
//			if(errorStr.equals("Validation Error => return Null Error")) {
//				return "redirect:/login.do";
//			} else {
//				// else 
//			}
//			e.printStackTrace();
//			return "error/egovError";
//		} 
//		return "redirect:/logout.do";
//	}
//	
	/**
	 * 상세 글 화면 조회
	 **/ 
	@RequestMapping(value="/boardView.do")
	public String boardView(HttpServletRequest request, ModelMap model) throws Exception {
		logger.info("##### Controller : boardView 진입 #####");
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = boardService.showBoard(request); 
		// 07.30 아래 수정해야함
		try {
			resultMap = loginService.checkLogin(request);
			request.getSession().setAttribute("myid",resultMap.get("userid").toString()); // 세션에 유저ID 넣어줌.
			model.addAttribute("userId", resultMap.get("userid").toString());
			model.addAttribute("userPw", resultMap.get("userpw").toString());
			return "login/login"; 
		} catch (Exception e) {
			logger.info("##### 에러로 갔음 #####");
			e.printStackTrace();
			return "error/egovError";
		} 
	}
	
	
}
