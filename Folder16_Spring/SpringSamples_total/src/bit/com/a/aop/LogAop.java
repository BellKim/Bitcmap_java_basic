package bit.com.a.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class LogAop {
	
	@Around("within(bit.com.a.controller.*)")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		
		String signatureStr = joinpoint.getSignature().toShortString();
		//session check
		//~~ 의 약자로서 관점지향 프로그래밍이다. 
		// 여러 다수의 공통된 작업을 한군데에서 수행하는 방식을  AOP 라고 한다. 
		

		Object obj = joinpoint.proceed(); //기능실행!

			
		System.out.println("loggerAop : " + signatureStr + " 종 료// 메소드 호출  ");
		
		
		
		return obj;
		

	}//loggerAop

}//end of class LogAop
