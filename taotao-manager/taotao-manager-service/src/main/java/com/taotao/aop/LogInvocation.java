package com.taotao.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogInvocation {

	private static Logger log = Logger.getLogger(LogInvocation.class);
	
	@Pointcut("execution(public * com.taotao.service..*.*(..))")
	private void logPointId(){}
	
	@Before("logPointId()")
	private void before(JoinPoint point){
		log.info("log before:"+point.getSignature().getName());
	}
	
	/*@Around("logPointId()")
	private Object around(ProceedingJoinPoint point) throws Throwable{
		
		
		Object result = point.proceed();
		return result;
	}*/
	
	@After("logPointId()")
	private void after(JoinPoint point){
		log.info("log after:"+point.getSignature().getName());
	}
	
}
