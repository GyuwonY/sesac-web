package kr.co.mlec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{
	private HandlerMapping mappings = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String propLoc = config.getInitParameter("propLocation");
		//C:\\web-workspace\\Mission-Web-MV\\bean.propertie
		mappings = new HandlerMapping(propLoc);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		String uri = request.getRequestURI();
		String context = request.getContextPath(); // 자신이 설정한 server의 path를 받아와서 경로로 설정 가능
		uri = uri.substring(context.length());
//		System.out.println("contextPath : " + context);
		
		try {
			Controller control = mappings.getController(uri);
			String callPage = control.handleRequest(request, response);
			
			if(callPage.startsWith("redirect:")) {
				callPage = callPage.substring("redirect:".length()); 
				response.sendRedirect(request.getContextPath()+callPage); // redirect 해야하는 경우 바로 response 시킴
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(callPage); // forward를 위한 객체 생성
				dispatcher.forward(request, response); // forward 실행 (request와 response 객체 전달) 
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
