package com.sesac.education.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.sesac.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired //type이 같으면 injection 
	SqlSession session;
	final String namespace = "com.sesac.member.";
	
	public List<MemberVO> selectAll(){
		return session.selectList(namespace+"selectAll");
	}
	
	public MemberVO selectById(String id) {
		return session.selectOne(namespace+"selectById");
	}
	
	public int insert(MemberVO member) {
		return session.insert(namespace+"insert", member);
	}
	
	public int update(MemberVO member) {
		return session.update(namespace+"update", member);
	}
	
	public int delete(String id) {
		return session.delete(namespace+"delete", id);
	}
}
