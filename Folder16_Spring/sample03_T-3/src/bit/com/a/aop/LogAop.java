package bit.com.a.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import bit.com.a.service.MemberService;

@Aspect
public class LogAop {
	
//	@Autowired
//	MemberService memberservice;
	
	//조인포인터로 신호가 들어와서 TRY 문에 내용이 출력된다. 
	//@aspect 를 통해서 클래스를 안내하고, Around를 통해서 사용될 위치를 설정 
	
	@Around("within(bit.com.a.controller.*)")
//	@Around("within(bit.com.a.controller.*) or within(bit.com.a.controller.*)")		//중복선언할때 사용방식 
	public Object loggerr(ProceedingJoinPoint joinpoint) throws Throwable {
		//불리면 자동으로 실행되는 메소드 
		
		
		String signatureStr = joinpoint.getSignature().toShortString();
		try {
			System.out.println(" signatureStr + " + signatureStr+"가 실행되었습니다. ");
		Object obj = joinpoint.proceed(); //기능실행!
		
		return obj;
		
		} finally {
			System.out.println("실행 후 " + System.currentTimeMillis());
			
			//System.out.println(signatureStr + " 종 료 ");
		}
		
		
	}
	
	
	

}//LogAop
