package chap14StaticClass01;

public class MyClass {
	/*
	 	1. 은닉성(캡슐화) 접근제어 private, public, protected, defatul
	 	class내부에서 member변수, member메소드로 처리
	 	변수에 접근할 경우 사용.
	 
	 
	 */
	private int number;
	private String strArr[];
	
	
	public MyClass() {	//생성시에 자동호출 메소드 Overload
//		this(1);// -> 맨위에 있어야만한다. 아래로가면 오류난다. 
				//myclass의 (int number) 있는 메소드로 갔다가 온다.
		System.out.println("MyClass Myclass() -> 기본생성자 실행.");
		strArr = new String[10];
	}//기본생성자
	
	
	public MyClass(int number) {
		this();
		this.number = number;
		//myclass의 number = 들어오는number값.
	}//기본생성자	
	
	public void method() {
		
		System.out.println("method() ;;;; ");
		
		System.out.println("number = " + this.number );
	}
	
	
	
	public int getNumber() {
		return number;
	}
	
	
	public void setNumber(int number) {
		this.number = number;
	}
	

	

}//end of class
