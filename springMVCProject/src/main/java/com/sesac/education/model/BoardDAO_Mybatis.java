package com.sesac.education.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sesac.education.utill.JDBCClose;

import kr.co.sesac.vo.BoardFileVO;
import kr.co.sesac.vo.BoardVO;

/**
 * 게시판 DB(tbl_board) CRUD
 * @author user
 *
 */

@Repository
public class BoardDAO_Mybatis {
	
	@Autowired
	SqlSession session;
	// SqlSession : SQL문 실행단위
	final String namespace = "com.sesac.board.";
	
	/**
	 * 전체게시글 조회
	 */
	public List<BoardVO> selectAllBoard(String keyword, String contents) {
		Map<String, String> myMap = new HashMap<>();
		myMap.put("keyword", keyword);
		myMap.put("contents", "%"+contents+"%");
		
		return session.selectList(namespace + "selectAll", myMap);
	}
	
	/**
	 * 게시물번호 추출(seq_tbl_board_no)
	 */
	public int selectBoardNo() {
		return session.selectOne(namespace + "selectBoardNo");
	}
	
	/**
	 * 새글등록
	 */
	public int insertBoard(BoardVO board) {
		return session.insert(namespace + "insertBoard", board);
	}
	
	/**
	 * 조회수 증가
	 */
	public int viewCnt(int boardNo) {
		return session.update(namespace + "viewCnt", boardNo);
	}
	
	/**
	 * 게시글 상세 보기
	 * @param boardNo
	 * @return
	 */
	public BoardVO selectBoardByNo(int boardNo) {
		return session.selectOne(namespace + "selectBoardByNo", boardNo);
	}
	
	public int deleteByNo(int boardNo) {
		return session.delete(namespace + "deleteByNo", boardNo);
	}
	
	/**
	 * 게시물 수정 (제목, 작성, 내용)
	 */
	public int updateBoard(BoardVO board) {
		return session.update(namespace + "updateBoard", board);
	}
	
	/**
	 * 페이징
	 */
	public int boardCnt() {
		return session.selectOne(namespace + "boardCnt");
	}
	
	/**
	 * 첨부파일 CRUD
	 */
	public int insertFile(BoardFileVO fileVO) {
		return session.insert(namespace + "insertFile", fileVO);
	}
	
	public List<BoardFileVO> selectFileByNo(int boardNo) {
		return session.selectList(namespace + "selectFileByNo", boardNo);
	}
}
