package com.sac.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		m3();
	}
	
	private static void m4() {
		// scope : singleton이 기본 : 객체는 한번만 만들어짐
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di3.xml");
		People p1 = ctx.getBean("p5", People.class);
		People p2 = ctx.getBean("p5", People.class);
		System.out.println(p1==p2);
		System.out.println(System.identityHashCode(p1)); // 주소가 같다.
		System.out.println(System.identityHashCode(p2));
	}

	private static void m3() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di3.xml");
		People p = ctx.getBean("p5", People.class);
		People p6 = ctx.getBean("p6", People.class);
		System.out.println(p);
		System.out.println(p6);
	}

	private static void m2() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di3.xml");
		People p1 = ctx.getBean("p1", People.class);
		People p2 = ctx.getBean("p2", People.class);
		People p3 = ctx.getBean("p3", People.class);
		People p4 = ctx.getBean("p4", People.class);
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
	}

	private static void m1() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di3.xml");
		Car car = ctx.getBean("car", Car.class);
		Car car2 = ctx.getBean("car2", Car.class);
		System.out.println(car);
		System.out.println(car2);
	}
	
	
}
