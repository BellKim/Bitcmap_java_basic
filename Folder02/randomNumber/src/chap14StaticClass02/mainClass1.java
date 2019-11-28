package chap14StaticClass02;

public class mainClass1 {

	public static void main(String[] args) {
		
		
		System.out.println("sn = "+StaticClass.staticNumber);
		
		StaticClass.staticNumber=1;
		
		StaticClass sc = new StaticClass();
		
		System.out.println("sc sn = "+sc.staticNumber);
		
		sc.StaticClass();
		
		StaticClass sc1 = new StaticClass();
		
		System.out.println("sc1 sn = "+sc1.staticNumber);
		
		//프로그램의 전체 흐름을 알고싶을떄 사용. 
		//어디서나 호출할 수있는 이점이 있다.
		

	}//end main

}//end class
