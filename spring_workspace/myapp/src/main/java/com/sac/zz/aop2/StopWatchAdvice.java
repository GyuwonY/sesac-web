package com.sac.zz.aop2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//보조 업무
@Component
@Aspect
public class StopWatchAdvice{
	
	@Pointcut("execution(* divide(int,int))")
	public void targetMethod2() {
		
	}
	
	@Around("targetMethod2()")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("*********************************");
		System.out.println("[메서드 호출 전 StopWatchAdvice]" + joinPoint.getSignature().getName() + " 메서드 호출 전");
		StopWatch watch = new StopWatch("계산시간");
		watch.start();
		
		//주업무
		Object obj = joinPoint.proceed();
		
		//주업무를 다녀옴
		watch.stop();
		System.out.println("[메서드 호출 후 StopWatchAdvice]" + "주업무 수행시간" + watch.getTotalTimeNanos());
		System.out.println(watch.prettyPrint());
		System.out.println("*********************************");
		return obj;
	}

}
