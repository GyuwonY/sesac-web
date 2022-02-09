package com.sesac.education.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.sesac.vo.BookVO;

@Controller
@RequestMapping("/test")// type level url이 공통된 부분은 class 상단에서 통합시킬 수 있다.
public class HelloController {
	
	@RequestMapping("/hello1")//method level
	public String hello1() {
		System.out.println("Hello1");
		return "helloPage1";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView test2() {
		System.out.println("Hello2");
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", "SpringFrameWork");
		mv.addObject("price", 5000);
		mv.addObject("book", new BookVO(10, "java", "유규원", null, null));
		
		mv.setViewName("helloPage1");
		
		return mv;
	}
	
	@RequestMapping(value = {"/hello3", "/hello3.do", "/hello3.test"})
	// 배열을 통해 여러 url 설정이 가능하다.
	public String hello3(Model model) {
		model.addAttribute("myname", "jin");
		model.addAttribute("phone", "010-1234-7890");
		return "hello3";
	}
	
	@RequestMapping(value = {"/hello5"})// 배열을 통해 여러 url 설정이 가능하다.
	public void hello5(Model model) {
		model.addAttribute("myname", "jin");
		model.addAttribute("phone", "010-1234-7890");
		// return 이 없는 경우 default로 hello5.jsp를 찾는다.
	}
	
	
	//method 두가지 방식을 나눠 사용이 가능하다.
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		return "user/loginForm";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(String userid, String userpass, Model model) {
		System.out.println("userpass :"+userpass);
		System.out.println("userid :"+userid);
		
		if(userid==null) {
			model.addAttribute("message", "로그인아이디가 없습니다.");
		}else {
			model.addAttribute("message", "로그인 성공하였습니다.");
		}
		
		return "user/loginResult";
	}
	
	//파라미터를 통해서 접근 지정이 가능하다.
	@RequestMapping(value= {"helloParam.do"}, 
			params = {"userid=sesac", "userpass", "!email"}, method = RequestMethod.GET)
	public String helloParam(Model model, String userid, String userpass) {
		System.out.println("userid:"+userid);
		System.out.println("userpass:"+userpass);
		
		model.addAttribute("message", "helloParam.do 로그인 성공하였습니다.");
		return "user/loginResult";
	}
}












