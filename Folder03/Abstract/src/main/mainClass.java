package main;

import abstractClass.AbstractClass;
import child.MyClass;
import child.YouClass;

public class mainClass {
	
	public static void main(String[] args) {
		/*
			abctract : 추상 Class. 
			
			class: method의 내용이 모두 설정되어 있는 것.
					method가 정의만 되어 잇는 요소(추상 method)
					
			추상 method를 한개이상 포함하고 있는 것.
			추상 class만은 생성이 불가능하다.
			추상 class 를 상속한 후에 자식 class에서 정의후에 생성이 가능하다. 
			instance로 설정은 가능. 
			
			
			
			
		
		*/
		
		
//		AbstractClass ac = new AbstractClass();
		
		
		//둘다 가능. 상속받은 메소드이기때문에.
		MyClass cls = new MyClass();
		
		AbstractClass myClass = new MyClass();
		
		cls.abstractMethod();
		
		myClass.method();
		
		
		AbstractClass aCls = new AbstractClass() {
			
			@Override
			public void abstractMethod() {
				// TODO Auto-generated method stub
				System.out.println("abstractMethod() 상속안하고 정의.");
			}
		};
		aCls.abstractMethod();
		aCls.abstractMethod();
		
		AbstractClass mcls = new MyClass();
		AbstractClass ycls = new YouClass();
		
		
		
	}//end main

}//end class
