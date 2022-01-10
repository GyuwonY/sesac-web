package kr.co.mlec.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/examMethod"}) // 어노테이션을 이용한 경로 설정 servlet 3.0 버전부터 // 원래 사용해야하는 방식
//@WebServlet("/examMethod")// 인식 가능
public class ExamMethodServlet extends HttpServlet {
	
	// http://localhost:9999/Lecture-Web/examMethod?name=hong&hobby=reading&hobby=movie
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		// String hobby = request.getParameter("hobby"); getParameter는 제일 앞의 값만 받아옴
		String[] hobby = request.getParameterValues("hobby");
		
		System.out.println("name : "+ name);
		System.out.println("hobby : "+ Arrays.toString(hobby));
	}
}
