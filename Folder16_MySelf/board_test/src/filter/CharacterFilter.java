package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")	//3번 웹필터 추가
public class CharacterFilter implements Filter{//1. 임플리 필터      2.마우스 오버해서 useunimplement method 로 열기 . (인터페이스)
	/* 클라이언트 <--> 필터 <--> 서블릿*/
	//destroy() 필터가 웨본테이너에서 삭제될때 호출된다. 
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	// doFilter() 클라이언트에서 요청이 올때마다 .
	//체인을 따라 다음에 존재하는 필터로 이동한다.
	//체인의 가장 마지막에는 클라이언트가 요청한 최종자원이 위치한다. 
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("before");
		req.setCharacterEncoding("UTF-8");
		chain.doFilter(req, resp);// 서블릿데모에 part04에 인코딩 주석처리
		
		System.out.println("after");
	} /*처음실행시 get이던 post 던 problemController.java 를 실행하면 
		dofilter 가 우선 실행되고 서블릿이 다시 dofilter에 진입하여 필터를 거쳐서
		인코딩을 한 후에  problemController.java 가 처리된후에 doFilter 가 끝난다. 
		problemController.java 실행  - doFilter (before, after) - dofileter(before) - problemController.java dofilter(after)  
	
	
	http://www.codejava.net/java-ee/servlet/webfilter-annotation-examples
	
	
	*/ 
	
	
	
	
	//init() 딱한번만 호출이된다.
	//필터가 웹 콘테이너에 생성한 후 초기화 할때 호출한다. 
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

}//end class

/*서블릿 - 필터 검색. */
