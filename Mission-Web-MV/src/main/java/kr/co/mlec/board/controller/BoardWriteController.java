package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.controller.Controller;
import kr.co.mlec.util.SesacFileNamePolicy;

public class BoardWriteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		
		String saveFolder = "C:\\web-workspace\\Mission-Web-MV\\src\\main\\webapp\\upload";
		
		MultipartRequest multi = new MultipartRequest(
				request, saveFolder, 1024*1024*3, "utf-8", new SesacFileNamePolicy());
		//객체를 생성하는 순간 파일 저장됨
		
		//제목 작성자 내용 추출
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		String content = multi.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		BoardService service = new BoardService();
		service.insertBoard(board);
		
		return "redirect:/board/list.do";
	}
}
