package com.sac.di2;

public class TVFactory {
	
	public static TV makeTV(String brand) {
		
		if(brand.equals("S")) {
			return new SamsungTV("ABC");
		}else if(brand.equals("L")) {
			return new LgTV();
		}else {
			return null;
		}
	}
}
