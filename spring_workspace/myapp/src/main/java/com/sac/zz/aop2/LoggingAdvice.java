package com.sac.zz.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//보조 업무
@Component
@Aspect
public class LoggingAdvice{

	@Pointcut("execution(* add(int)) || execution(* add(int,int))") // return type 상관 없이 add args가 int or int,int 인것
	public void targetMethod2() {
		
	}
	
	@Around("targetMethod2()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("LoggingAdvice:주업무 before----------------------------------");
		System.out.println(joinPoint.getSignature().getName()+"메서드 호출 전");
		Object obj = joinPoint.proceed();
		System.out.println("LoggingAdvice:주업무 after----------------------------------");
		return obj;
	}
	
	@Before("targetMethod2()")
	public void aa(JoinPoint joinPoint) {
		System.out.println("before이벤트......" + joinPoint.getSignature().getName());
	}
	
	@After("targetMethod2()")
	public void bb(JoinPoint joinPoint) {
		System.out.println("after이벤트......" + joinPoint.getSignature().getName());
	}
	
	@AfterReturning("targetMethod2()")
	public void cc(JoinPoint joinPoint) {
		System.out.println("AfterReturning이벤트......" + joinPoint.getSignature().getName());
	}
	
	@AfterThrowing("targetMethod2()")
	public void dd(JoinPoint joinPoint) {
		System.out.println("AfterThrowing이벤트......" + joinPoint.getSignature().getName());
	}
}
