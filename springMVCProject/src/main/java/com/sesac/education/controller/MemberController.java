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


@Controller
public class MemberController {
	
	@Autowired
	MemberService mService;
	
	@GetMapping("/member/list.do")
	public String memberList(Model model) {
		model.addAttribute("memberList", mService.selectAll());
		return "member/memberList";
	}
	
}

