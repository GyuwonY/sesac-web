package com.sac.di5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Xml 대체할 수 있는 Annotation
@Configuration
// Component 전체 스캔
@ComponentScan
public class AppConfig {
	
	@Bean
	public Car carBean() {
		return new Car("A모델", 1000);
	}
}
