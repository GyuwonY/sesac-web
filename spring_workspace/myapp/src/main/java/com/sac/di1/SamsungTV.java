package com.sac.di1;

public class SamsungTV implements TV{
	
	
	public SamsungTV() {
		System.out.println("default 생성자");
	}
	
	public SamsungTV(String model) {
		System.out.println(model + ": arg1 생성자");
	}

	public void powerOn() {
		System.out.println( getClass().getSimpleName() + "전원을 켠다.");
	}
	
	public void powerOff() {
		System.out.println( getClass().getSimpleName() + "전원을 끈다.");
	}
}
