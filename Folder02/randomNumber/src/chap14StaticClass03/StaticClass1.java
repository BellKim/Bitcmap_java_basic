package chap14StaticClass03;

public class StaticClass1 {
	
	public StaticClass1() {
		System.out.println("StaticClass1");
	}
	
	public void func() {
		System.out.println("func");
		

	}
	
	public void method() {
		System.out.println("method");

	}
	
	public static StaticClass1 getInstance() {//스테틱함수
		
		StaticClass1 sc = new StaticClass1();
		sc.method();
		sc.func();
		return sc;
		
		
	}
	
	
	public static void staticMethod() {
		System.out.println("스테틱 메소드 호출(staticClass1.java로부터 옴 )");
		//this 사용불가 .
	}
	
	

}//end class
