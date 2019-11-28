package chap13Contructor;


public class mainClass {

	public static void main(String[] args) {
		/*
			contructor : 생성자
							structure (구조체)
							함수(메소드)
							class명과 같은 메소드. 
							return값이 없으며, 오버로딩이 가능하다. 
							class생성시 자동호출이 된다. 
							별도의 호출이 불가능하다. 
							생략이 가능하기도하다. 
							초기값 설정에 많이 사용된다. 
			distructor : 소멸자. (C++에 존재하며, 자동호출되는 녀석이지만 JAVA에서는 없어진기능이다.
								(자체적으로숨겨놈, 가비지컬랙터가 이 기능을 대신한다.))
			
			this 참조.

		 */
//		생성자를 통해서 인스턴스 변수 값을 초기화 해줄수도 있으며, 
//		처음 생성자를 호출할때 값을 넣어주면서 인스턴스 생성을 하는 총 2가지방법으로
//		인스턴스 값으로 초기화 할 수 있다. 
		
		MyClass cls = new MyClass();//인스턴스초기화 방법1 기본생성자로 초기화한다.(생성시 한번만 호출)
		MyClass cls2 = new MyClass(3);
		MyClass cls3 = new MyClass(3, 45);
		MyClass cls4 = new MyClass(12.4f);
		System.out.println("겟넘바"+cls4.getNumber());//인스턴스변수초기화// 생성자 오버라이딩으로 초기화 가능.
		
		
	}//end main

}//end class


