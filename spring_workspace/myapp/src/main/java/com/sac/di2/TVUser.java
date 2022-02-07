package com.sac.di2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TVUser {

	public static void main(String[] args) {
		m2();

	}


	private static void m1() { // 원하는 객체를 하나씩 생성할 수 있기 때문에 메모리 효율이 좋다. 모바일 앱 제작시 자주 사용함
		Resource resource = new ClassPathResource("di2.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		TV tv1 = (TV)factory.getBean("samsung1"); //getBean을 할 때 객체가 생성됨
		TV tv2 = factory.getBean("samsung2", TV.class);
		TV tv3 = (LgTV)factory.getBean("lg");
		
		tv1.powerOn();
		tv1.powerOff();
		tv2.powerOn();
		tv2.powerOff();
		tv3.powerOn();
		tv3.powerOff();
	}
	
	private static void m2() { // 사용전에 미리 로딩하기 때문에 빠르다. 일반 PC 앱 제작시 자주 사용함
		ApplicationContext ctx = new ClassPathXmlApplicationContext("di2.xml"); // 모든 객체가 한번에 생성됨
		
		TV tv1 = (TV)ctx.getBean("samsung1"); //getBean을 할 때 객체가 생성됨
		TV tv2 = ctx.getBean("samsung2", TV.class);
		TV tv3 = (LgTV)ctx.getBean("lg");
		
		tv1.powerOn();
		tv1.powerOff();
		tv2.powerOn();
		tv2.powerOff();
		tv3.powerOn();
		tv3.powerOff();
	}
}
