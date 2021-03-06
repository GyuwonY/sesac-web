package kr.co.mlec.board.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.controller.Controller;

// /board/list.do(전체 리스트 조회) 호출 되었을 때
// 1. 비지니스 로직 수행 (DB Access)
// 2. servlet에게 forward 시킬 jsp 알려줌

public class BoardListController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BoardService service = new BoardService();
		List<BoardVO> list = service.selectAllBoard();
		
		request.setAttribute("list", list);
		
		return "/jsp/board/list.jsp"; 
	}
}
