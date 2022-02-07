package kr.co.mlec.library.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.mlec.library.vo.LoginVO;

public class MyApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di5.xml"); 
		LoginService service = ctx.getBean("loginService", LoginService.class);
		
		LoginVO vo = new LoginVO("aaaa", "aaa", "asd", "aaa@aaa", null, 0);
		//service.createMember(vo);
		service.MemberLogin(vo);
	}

}
