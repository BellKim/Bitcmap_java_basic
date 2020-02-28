package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
	public Object loggerr(ProceedingJoinPoint joinpoint) throws Throwable {
		//불리면 자동으로 실행되는 메소드 
		
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + " 시 작 ");
		
		
		try {
		Object obj = joinpoint.proceed(); //기능실행!
		return obj;
		} finally {
			System.out.println("실행 후 " + System.currentTimeMillis());
			
			System.out.println(signatureStr + " 종 료 ");
		}
		
		
	}
	
	
	

}
