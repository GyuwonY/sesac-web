package com.sac.di5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest {

	public static void main(String[] args) {
		
		// 자바에 설정된 객체를 주입함
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		Car car = ctx.getBean("carBean", Car.class);
		System.out.println(car);

	}

}
