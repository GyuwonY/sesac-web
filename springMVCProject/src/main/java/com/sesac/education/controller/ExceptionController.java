package com.sesac.education.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

//@ControllerAdivce를 통해 전역 Exception 처리
@ControllerAdvice // 전역 Exception
public class ExceptionController {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handler404(HttpServletRequest request, Model model) {
		model.addAttribute("message", "존재하지않는 페이지입니다");
		model.addAttribute("url", request.getRequestURI());
		return "error/errorPage404";
	}
}
