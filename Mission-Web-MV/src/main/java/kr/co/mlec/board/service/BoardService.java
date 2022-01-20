package kr.co.mlec.board.service;

import java.util.List;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

public class BoardService {
	
	private BoardDAO boardDao;

	public BoardService() {
		boardDao = new BoardDAO();
	}
	
	/**
	 * 게시글 조회 서비스
	 */
	public List<BoardVO> selectAllBoard(){
		List<BoardVO> list = boardDao.selectAllBoard();
		return list;
	}
	
	/**
	 * 상세게시글 조회 서비스
	 */
	public BoardVO selectBoardByNo(int no) {
		BoardVO board = boardDao.selectBoardByNo(no);
		return board;
	}
	
	/**
	 * 게시물 등록 서비스
	 */
	public void insertBoard(BoardVO board) {
		boardDao.insertBoard(board);
	}
}
