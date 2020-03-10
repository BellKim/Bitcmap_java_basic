package bit.com.a.aop;

import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import bit.com.a.model.MemberDto;


@Aspect
public class LogAop {
	
	@Around("within(bit.com.a.controller.*)")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		
		String signatureStr = joinpoint.getSignature().toShortString();
		//session check
		//~~ 의 약자로서 관점지향 프로그래밍이다. 
		// 여러 다수의 공통된 작업을 한군데에서 수행하는 방식을  AOP 라고 한다.
		
		
		
		// 세션체크를 할때에도 사용할 수 있다.(모든jsp 파일에 작성해서 세션체크를 해야하지만 여기서는 그냥 가능하다.)
		//session check
//		HttpServletRequest request
//		  =((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();

//		if(request != null) {
//			HttpSession session = request.getSession();
//			MemberDto login = (MemberDto) session.getAttribute("login");
//			if(login == null) {
//				return "redirect:/login.do";
//			}
//		}
		
		

		Object obj = joinpoint.proceed(); //기능실행!
	
		System.out.println("loggerAop : " + signatureStr + " 종 료// 메소드 호출  ");
		
		return obj;
		

	}//loggerAop

}//end of class LogAop
