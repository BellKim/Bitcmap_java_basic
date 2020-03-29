package bit.com.a.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class logAop {
	
//	@Around("within(bit.com.a.controller.*)")
////	@Around("within(bit.com.a.controller.*) or within(bit.com.a.controller.*)")		//중복선언할때 사용방식 
//	public Object loggerr(ProceedingJoinPoint joinpoint) throws Throwable {
//		//불리면 자동으로 실행되는 메소드 
//		
//		
//		String signatureStr = joinpoint.getSignature().toShortString();
//		try {
//			System.out.println(" signatureStr + " + signatureStr+"가 실행되었습니다. ");
//		Object obj = joinpoint.proceed(); //기능실행!
//		
//		return obj;
//		
//		} finally {
//			System.out.println("실행 후 " + System.currentTimeMillis());
//			
//			//System.out.println(signatureStr + " 종 료 ");
//		}
//		
//		
//	}
	
	
	

}
