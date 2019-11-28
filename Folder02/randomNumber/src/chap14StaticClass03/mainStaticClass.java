package chap14StaticClass03;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class mainStaticClass {
	public static void main(String[] args) {
		
/*
		StaticClass1 sc1 = new StaticClass1();
		sc1.getInstance();
		
		Calendar ca1 = new GregorianCalendar();
		Calendar ca2 = Calendar.getInstance();
//		calendar = static 함수이다. 
*/
		StaticClass1.staticMethod();//클래스명으로만 스테틱 메소드 호출을 한다.
									//static클래스는 this를 사용할 수 가 없다. 
		
		
	}//end main 

}
