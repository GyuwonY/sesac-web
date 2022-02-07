package com.sac.zz.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

//보조 업무
public class StopWatchAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("*********************************");
		System.out.println("[메서드 호출 전 StopWatchAdvice]" + invocation.getMethod().getName() + " 메서드 호출 전");
		StopWatch watch = new StopWatch("계산시간");
		watch.start();
		
		//주업무
		Object obj = invocation.proceed();
		
		//주업무를 다녀옴
		watch.stop();
		System.out.println("[메서드 호출 후 StopWatchAdvice]" + "주업무 수행시간" + watch.getTotalTimeNanos());
		System.out.println(watch.prettyPrint());
		System.out.println("*********************************");
		return obj;
	}

}
