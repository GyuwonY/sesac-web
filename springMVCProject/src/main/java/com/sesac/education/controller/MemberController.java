package com.sesac.education.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.sesac.education.model.MemberService;

import kr.co.sesac.vo.BoardVO;
import kr.co.sesac.vo.MemberVO;


@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;
	
	@RequestMapping("/member/list")
	public String memberList(Model model) {
		model.addAttribute("memberList", mService.selectAll());
		return "member/memberList";
	}
	
	@RequestMapping("/member/detail")
	public String memberDetail(String mid, Model model) {
		model.addAttribute("member", mService.selectById(mid));
		return "member/detailMemeber";
	}
	
	@RequestMapping("/member/insertForm")
	public String memberInsertForm() {
		
		return "member/insertMember";
	}
	
	@RequestMapping("/member/insert")
	public String memberInsert(MemberVO member, Model model) {
		model.addAttribute("member", mService.insert(member));
		return "redirect:/member/list";
	}
	
	@RequestMapping("/member/update")
	public String memberUpdate(MemberVO member, Model model) {
		model.addAttribute("member", mService.update(member));
		return "member/detailMemeber";
	}
	
	@RequestMapping("/member/delete")
	public String memberDelete(String mid, Model model) {
		mService.delete(mid);
		return "redirect:/member/list";
	}
}

