package kr.co.mlec.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.controller.Controller;
import kr.co.mlec.member.service.LoginService;
import kr.co.mlec.member.vo.LoginVO;

public class LoginProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		LoginVO loginVO = new LoginVO(id, password);
		
		LoginService service = new LoginService();
		LoginVO userVO = service.login(loginVO); 
		
		String url = "";
		if(userVO == null) {
			// 로그인 실패
			url = "/login.do";
		} else {
			// 로그인 성공
			url = "/";
			HttpSession session = request.getSession(); // java에서 session객체는 내장객체가 아니기 때문에 받아와야한다.
			session.setAttribute("userVO", userVO);
		}
		
		return "redirect:" + url; 
		// sendRedirect 진행할 때 sevlet에서 응답을 주고 클라이언트 요청을 재발생시킨다.
		// redirect를 해야하는 경우인지 판단하기 위해 접두어를 붙여 리턴함
	}
	
	/*
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		LoginVO loginVO = new LoginVO(id, password);
		
		LoginService service = new LoginService();
		LoginVO userVO = service.login(loginVO); 
		
		String url = "";
		if(userVO == null) {
			// 로그인 실패
			url = request.getContextPath() + "/login.do";
		} else {
			// 로그인 성공
			url = request.getContextPath();
		}
		
		response.sendRedirect(url);
		
		request.setAttribute("url", url);
		
		return "aaa.jsp";
	}
	*/
}
