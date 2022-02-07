package com.sac.zz.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//보조 업무
public class LoggingAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("==================================================");
		System.out.println("[메서드 호출 전 LoggingAdvice]" + invocation.getMethod().getName() + " 메서드 호출 전");
		
		//주업무
		Object obj = invocation.proceed();
		
		//주업무를 다녀옴
		System.out.println("[메서드 호출 후 LoggingAdvice]" + invocation.getMethod().getName() + " 메서드 호출 후");
		System.out.println("==================================================");
		return obj;
	}

}
