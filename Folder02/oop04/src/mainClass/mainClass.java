package mainClass;

import child.ChildClass;

public class mainClass {
	public static void main(String[] args) {
		ChildClass cc = new ChildClass();
		//부모의 기본생성자실행후 자식클래스 기본생성자실행. 
		
		
		ChildClass cc1 = new ChildClass("",123);
		//childclass의 인자수 2개있는 기본생성자로 들어가서 실행.
		//자식클래스에서는 int값이 부모에만 있기에 super(3) 을 통해서 부모기본생성자에게 값전달. 
		
		
		
		
	}//end main

}//end of class
