package com.sac.di1;

public class LgTV implements TV{
	
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
