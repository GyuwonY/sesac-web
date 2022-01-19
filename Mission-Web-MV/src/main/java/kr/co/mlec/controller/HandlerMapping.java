package kr.co.mlec.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {
	private Map<String, Controller> mappings = null;
	
	// uri당 필요한 Controller 객체가 다르기 때문에 맵핑을 통해 한쌍으로 움직일 수 있게한다
	public HandlerMapping(String propLoc) {
		
		Properties prop = new Properties();
		mappings = new HashMap<>();
		
		try {
			//InputStream is = new FileInputStream("C:\\web-workspace\\Mission-Web-MV\\bean.properties");
			//
			InputStream is = new FileInputStream(propLoc);
			prop.load(is);
			
			Set<Object> keys = prop.keySet();
			for(Object key: keys) {
				String className = prop.getProperty(key.toString());
				
				//동적으로 객체 생성을 할 수 있음
				Class<?> clz = Class.forName(className);
				// 타입을 모르기 때문에 강제 형변환을 시켜야함
				mappings.put(key.toString(), (Controller)clz.newInstance());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Controller getController(String uri) {
		return mappings.get(uri);
	}
}
