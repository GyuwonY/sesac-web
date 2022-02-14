package com.sesac.education.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sesac.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
	public List<MemberVO> selectAll(){
		return memberDAO.selectAll();
	}
	
	public MemberVO selectById(String id) {
		return memberDAO.selectById(id);
	}
	
	public int insert(MemberVO member) {
		return memberDAO.insert(member);
	}
	
	public int update(MemberVO member) {
		return memberDAO.update(member);
	}
	
	public int delete(String id) {
		return memberDAO.delete(id);
	}
}
