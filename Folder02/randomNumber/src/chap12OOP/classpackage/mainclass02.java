package chap12OOP.classpackage;



public class mainclass02 {
	/*
		1. 은닉성(==캡슐화)
		: 외부와의 차단으로 변수들을 관리할 수 있다.
		  클래스 내부에서만 접근이 가능하도록 접근지정자로 제어한다. (내부에서만 처리함)
		  접근지정자 
		  	private(개인적인), -맴버변수
		  	public(대중적인),  - 맴버메소드
		  	protected(특정영역) - 상속관련
		  
		   
	*/
	public static void main(String[] args) {
		Myclass cls = new Myclass();
		
//		cls.number=1;
//		cls.name="sdfa";
//		cls.height=123.5;
		
		cls.input();
		
		cls.printing();
		
	}
}

