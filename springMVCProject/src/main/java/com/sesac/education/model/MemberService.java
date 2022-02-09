package com.sesac.education.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.sesac.education.utill.ConnectionFactory;
import com.sesac.education.utill.JDBCClose;

import kr.co.sesac.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;
	
	public List<MemberVO> selectAll(){
		return memberDAO.selectAll();
	}
	
	public void signUp(MemberVO member) {
		memberDAO.signUp(member);
	}
}
