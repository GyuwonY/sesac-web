package com.sac.di1;

public class TVUser {

	public static void main(String[] args) {
		m2();

	}

	private static void m2() {
		TV tv = TVFactory.makeTV("S");
		tv.powerOn();
		tv.powerOff();
	}

	private static void m1() {
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();
	}

}
