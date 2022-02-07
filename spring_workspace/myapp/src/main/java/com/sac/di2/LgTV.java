package com.sac.di2;

public class LgTV implements TV{
	
	public LgTV() {
		System.out.println("lgtv 기본생성자");
	}
	
	public void turnOn() {
		System.out.println( getClass().getSimpleName() + "전원을 켠다.");
	}
	
	public void turnOff() {
		System.out.println( getClass().getSimpleName() + "전원을 끈다.");
	}

	@Override
	public void powerOn() {
		System.out.println( getClass().getSimpleName() + "전원을 켠다.");
		
	}

	@Override
	public void powerOff() {
		System.out.println( getClass().getSimpleName() + "전원을 끈다.");
		
	}
	
	
}
