package com.sac.zz.aop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop.xml");
		Calculator cal = ctx.getBean("proxyCal", Calculator.class);
		cal.add();
		cal.add(100);
		cal.add(100, 200);
		cal.subtract(10, 20);
		cal.multiply(10, 20);
		cal.divide(100, 10);
	}
}
